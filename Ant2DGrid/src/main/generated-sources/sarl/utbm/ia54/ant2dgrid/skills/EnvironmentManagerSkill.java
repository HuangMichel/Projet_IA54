package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Skill;
import java.util.List;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.capacities.EnvironmentManagerCapacity;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;

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
  
  public EnvironmentManagerSkill(final int width, final int height, final List<Cell> grid, final int quantity) {
    this.width = width;
    this.height = height;
    this.grid = grid;
    this.antQuantity = quantity;
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
  
  public AntBody createAnt(final UUID id, final AntBody body) {
    int _x = this.getHomeCell().getPosition().getX();
    int _multiply = (_x * this.height);
    int _y = this.getHomeCell().getPosition().getY();
    int _plus = (_multiply + _y);
    return this.grid.get(_plus).addAnt(id, body);
  }
  
  public void sendPerception(final UUID id, final List<Cell> list) {
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
  
  @Override
  @Pure
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
  @Pure
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
