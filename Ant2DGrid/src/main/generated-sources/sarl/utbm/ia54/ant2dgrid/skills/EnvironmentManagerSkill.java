package utbm.ia54.ant2dgrid.skills;

import io.sarl.core.InnerContextAccess;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Skill;
import io.sarl.lang.util.ClearableReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.capacities.EnvironmentManagerCapacity;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class EnvironmentManagerSkill extends Skill implements EnvironmentManagerCapacity {
  private final int width;
  
  private final int height;
  
  private List<Cell> grid;
  
  private final int antQuantity;
  
  private int homeCellPosition;
  
  private int foodCellPosition;
  
  private Map<UUID, Address> antAddresses;
  
  public EnvironmentManagerSkill(final int width, final int height, final List<Cell> grid, final int quantity) {
    this.width = width;
    this.height = height;
    this.grid = grid;
    this.antQuantity = quantity;
    HashMap<UUID, Address> _hashMap = new HashMap<UUID, Address>();
    this.antAddresses = _hashMap;
    this.defineCell();
  }
  
  private void defineCell() {
    for (int i = 0; (i < this.width); i++) {
      for (int j = 0; (j < this.height); j++) {
        CellState _state = this.grid.get(((i * this.height) + j)).getState();
        boolean _tripleEquals = (_state == CellState.HOME);
        if (_tripleEquals) {
          this.homeCellPosition = ((i * this.height) + j);
        } else {
          CellState _state_1 = this.grid.get(((i * this.height) + j)).getState();
          boolean _tripleEquals_1 = (_state_1 == CellState.FOOD);
          if (_tripleEquals_1) {
            this.foodCellPosition = ((i * this.height) + j);
          }
        }
      }
    }
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public List<Cell> getGrid() {
    return this.grid;
  }
  
  public int getAntQuantity() {
    return this.antQuantity;
  }
  
  public void createAnt(final Vector2i position, final UUID id, final AntBody body) {
    int _x = position.getX();
    int _multiply = (_x * this.height);
    int _y = position.getY();
    int _plus = (_multiply + _y);
    this.grid.get(_plus).addAnt(id, body);
  }
  
  public void sendPerception(final UUID sender, final UUID id, final List<Cell> list) {
  }
  
  public Cell getHomeCell() {
    return this.getCell(this.homeCellPosition);
  }
  
  public Cell getFoodCell() {
    return this.getCell(this.foodCellPosition);
  }
  
  public Cell getCell(final int i) {
    return this.grid.get(i);
  }
  
  public void setAddress(final UUID id, final Address address) {
    this.antAddresses.put(id, address);
  }
  
  public Address getAddress(final UUID id) {
    return this.antAddresses.get(id);
  }
  
  public List<Cell> getPerception(final UUID id) {
    ArrayList<Cell> _xblockexpression = null;
    {
      ArrayList<Cell> list = new ArrayList<Cell>();
      Vector2i vector = this.getAntPosition(id);
      int _x = vector.getX();
      int _plus = (_x + 1);
      boolean _lessThan = (_plus < this.width);
      if (_lessThan) {
        int _x_1 = vector.getX();
        int _plus_1 = (_x_1 + 1);
        int _multiply = (_plus_1 * this.height);
        int _y = vector.getY();
        int _plus_2 = (_multiply + _y);
        list.add(this.grid.get(_plus_2));
      }
      int _y_1 = vector.getY();
      int _plus_3 = (_y_1 + 1);
      boolean _lessThan_1 = (_plus_3 < this.height);
      if (_lessThan_1) {
        int _x_2 = vector.getX();
        int _multiply_1 = (_x_2 * this.height);
        int _y_2 = vector.getY();
        int _plus_4 = (_y_2 + 1);
        int _plus_5 = (_multiply_1 + _plus_4);
        list.add(this.grid.get(_plus_5));
      }
      int _x_3 = vector.getX();
      int _minus = (_x_3 - 1);
      boolean _greaterThan = (_minus > (-1));
      if (_greaterThan) {
        int _x_4 = vector.getX();
        int _minus_1 = (_x_4 - 1);
        int _multiply_2 = (_minus_1 * this.height);
        int _y_3 = vector.getY();
        int _plus_6 = (_multiply_2 + _y_3);
        list.add(this.grid.get(_plus_6));
      }
      int _y_4 = vector.getY();
      int _minus_2 = (_y_4 - 1);
      boolean _greaterThan_1 = (_minus_2 > (-1));
      if (_greaterThan_1) {
        int _x_5 = vector.getX();
        int _multiply_3 = (_x_5 * this.height);
        int _y_5 = vector.getY();
        int _minus_3 = (_y_5 - 1);
        int _plus_7 = (_multiply_3 + _minus_3);
        list.add(this.grid.get(_plus_7));
      }
      _xblockexpression = list;
    }
    return _xblockexpression;
  }
  
  public Map<UUID, Address> getAntAddresses() {
    return this.antAddresses;
  }
  
  private Vector2i getAntPosition(final UUID id) {
    Vector2i _xblockexpression = null;
    {
      Vector2i v = null;
      for (int i = 0; (i < this.width); i++) {
        for (int j = 0; (j < this.height); j++) {
          boolean _containsKey = this.grid.get(((i * this.height) + j)).getAntList().containsKey(id);
          if (_containsKey) {
            Vector2i _vector2i = new Vector2i(i, j);
            v = _vector2i;
          }
        }
      }
      _xblockexpression = v;
    }
    return _xblockexpression;
  }
  
  public void removeAntCell(final Vector2i position, final UUID id, final AntBody body) {
    int _x = position.getX();
    int _multiply = (_x * this.height);
    int _y = position.getY();
    int _plus = (_multiply + _y);
    this.getCell(_plus).removeAnt(id, body);
  }
  
  @Extension
  @ImportedCapacityFeature(InnerContextAccess.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS;
  
  @SyntheticMember
  @Inline(value = "$castSkill(InnerContextAccess.class, ($0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || $0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = $0$getSkill(InnerContextAccess.class)) : $0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS)", imported = InnerContextAccess.class)
  private InnerContextAccess $CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = $getSkill(InnerContextAccess.class);
    }
    return $castSkill(InnerContextAccess.class, this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
  }
  
  @Override
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EnvironmentManagerSkill other = (EnvironmentManagerSkill) obj;
    if (other.width != this.width)
      return false;
    if (other.height != this.height)
      return false;
    if (other.antQuantity != this.antQuantity)
      return false;
    if (other.homeCellPosition != this.homeCellPosition)
      return false;
    if (other.foodCellPosition != this.foodCellPosition)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.width;
    result = prime * result + this.height;
    result = prime * result + this.antQuantity;
    result = prime * result + this.homeCellPosition;
    result = prime * result + this.foodCellPosition;
    return result;
  }
}
