package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Skill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.capacities.EnvironmentManagerCapacity;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * A default skill of the environment
 */
@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class EnvironmentManagerSkill extends Skill implements EnvironmentManagerCapacity {
  /**
   * The number of rows
   */
  private final int width;
  
  /**
   * The number of cols
   */
  private final int height;
  
  /**
   * The grid contains all cells
   */
  private List<Cell> grid;
  
  /**
   * The ant quantity
   */
  private final int antQuantity;
  
  /**
   * The home cell position
   */
  private int homeCellPosition;
  
  /**
   * The food cell position
   */
  private int foodCellPosition;
  
  /**
   * A map contains Address of Ant agent
   */
  private Map<UUID, Address> antAddresses;
  
  /**
   * The default constructor initializing with parameters
   * @param width the number of cols
   * @param height the number of rows
   * @param grid the list of cell
   * @param quantity the number of ant
   */
  public EnvironmentManagerSkill(final int width, final int height, final List<Cell> grid, final int quantity) {
    this.width = width;
    this.height = height;
    this.grid = grid;
    this.antQuantity = quantity;
    HashMap<UUID, Address> _hashMap = new HashMap<UUID, Address>();
    this.antAddresses = _hashMap;
    this.defineCell();
  }
  
  /**
   * A function to define the position of food and home cell
   */
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
  
  /**
   * Gets the number of rows
   * @return width
   */
  public int getWidth() {
    return this.width;
  }
  
  /**
   * Gets the numbers of cols
   * @return height
   */
  public int getHeight() {
    return this.height;
  }
  
  /**
   * Gets the grid the list of cell
   * @return grid the list of cell
   */
  public List<Cell> getGrid() {
    return this.grid;
  }
  
  /**
   * Gets the quantity of ant
   * @param antQuantity
   */
  public int getAntQuantity() {
    return this.antQuantity;
  }
  
  /**
   * Creates an ant into a cell
   * @param position the position of the cell
   * @param id the UUID
   * @param body the AntBody
   */
  public void createAnt(final Vector2i position, final UUID id, final AntBody body) {
    int _x = position.getX();
    int _multiply = (_x * this.height);
    int _y = position.getY();
    int _plus = (_multiply + _y);
    this.grid.get(_plus).addAnt(id, body);
  }
  
  /**
   * Gets the Home cell
   * @return home cell
   */
  public Cell getHomeCell() {
    return this.getCell(this.homeCellPosition);
  }
  
  /**
   * Gets the food cell
   * @return food cell
   */
  public Cell getFoodCell() {
    return this.getCell(this.foodCellPosition);
  }
  
  /**
   * Gets the cell
   * @param i the position of the cell in the list
   * @return cell
   */
  public Cell getCell(final int i) {
    return this.grid.get(i);
  }
  
  /**
   * Sets the address into the map
   * @param id the UUID
   * @param address the address
   */
  public void setAddress(final UUID id, final Address address) {
    this.antAddresses.put(id, address);
  }
  
  /**
   * Gets the address of an agent
   * @param id the UUID
   * @return address
   */
  public Address getAddress(final UUID id) {
    return this.antAddresses.get(id);
  }
  
  /**
   * Gets the perception of an agent
   * @param id the UUID
   * @return list the list of cell
   */
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
  
  /**
   * Gets the map addresses
   * @return antAddresses
   */
  public Map<UUID, Address> getAntAddresses() {
    return this.antAddresses;
  }
  
  /**
   * Gets the ant position
   * @param id the UUID
   * @return v the position
   */
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
  
  /**
   * Removes an Ant of the cell
   * @param position the position of the cell
   * @param id the UUID
   * @param body the AntBody
   */
  public void removeAntCell(final Vector2i position, final UUID id, final AntBody body) {
    int _x = position.getX();
    int _multiply = (_x * this.height);
    int _y = position.getY();
    int _plus = (_multiply + _y);
    this.getCell(_plus).removeAnt(id, body);
  }
  
  @Override
  @SyntheticMember
  public boolean equals(final Object obj) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid implemented type: \'utbm.ia54.ant2dgrid.capacities.EnvironmentManagerCapacity\'. Only subtypes of \'io.sarl.lang.core.Capacity\' are allowed for \'EnvironmentManagerSkill\'."
      + "\nInvalid implemented type: \'utbm.ia54.ant2dgrid.capacities.EnvironmentManagerCapacity\'. Only subtypes of \'io.sarl.lang.core.Capacity\' are allowed for \'EnvironmentManagerSkill\'."
      + "\nMissing implemented type \'io.sarl.lang.core.Capacity\' for \'EnvironmentManagerSkill\'."
      + "\nMissing implemented type \'io.sarl.lang.core.Capacity\' for \'EnvironmentManagerSkill\'.");
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid implemented type: \'utbm.ia54.ant2dgrid.capacities.EnvironmentManagerCapacity\'. Only subtypes of \'io.sarl.lang.core.Capacity\' are allowed for \'EnvironmentManagerSkill\'."
      + "\nMissing implemented type \'io.sarl.lang.core.Capacity\' for \'EnvironmentManagerSkill\'.");
  }
}
