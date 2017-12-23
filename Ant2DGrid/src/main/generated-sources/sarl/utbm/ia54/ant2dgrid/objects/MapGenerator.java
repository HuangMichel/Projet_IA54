package utbm.ia54.ant2dgrid.objects;

import com.google.common.base.Objects;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import java.util.List;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.objects.Cell;

/**
 * This class generates a random 2D map
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class MapGenerator {
  /**
   * The 2D grid
   */
  private ArrayList<Cell> grid;
  
  /**
   * The chance to have a normal state
   */
  private final float chanceNormalState;
  
  /**
   * The width
   */
  private final int width;
  
  /**
   * The height
   */
  private final int height;
  
  /**
   * Default constructor
   */
  public MapGenerator() {
    ArrayList<Cell> _arrayList = new ArrayList<Cell>();
    this.grid = _arrayList;
    this.chanceNormalState = 0.4f;
    this.width = 45;
    this.height = 45;
  }
  
  /**
   * Constructor initializing
   * @param grid the 2D grid
   * @param chance the chance
   * @param width the width
   * @param height the height
   */
  public MapGenerator(final ArrayList<Cell> grid, final float chance, final int width, final int height) {
    this.grid = grid;
    this.chanceNormalState = chance;
    this.width = width;
    this.height = height;
  }
  
  /**
   * Initializing the 2D map
   */
  public void initializeMap() {
    for (int i = 0; (i < this.width); i++) {
      for (int j = 0; (j < this.height); j++) {
        {
          Cell cell = null;
          float _floatValue = Double.valueOf(Math.random()).floatValue();
          boolean _lessThan = (_floatValue < this.chanceNormalState);
          if (_lessThan) {
            Cell _cell = new Cell(i, j);
            cell = _cell;
          } else {
            Cell _cell_1 = new Cell(i, j, CellState.WALL);
            cell = _cell_1;
          }
          this.grid.add(cell);
        }
      }
    }
  }
  
  public ArrayList<Cell> simulationStep() {
    ArrayList<Cell> _xblockexpression = null;
    {
      ArrayList<Cell> newGrid = null;
      final int deathLimit = 4;
      final int birthLimit = 3;
      for (int i = 0; (i < this.width); i++) {
        for (int j = 0; (j < this.height); i++) {
          {
            int count = this.countNormalStateNeighbours(i, j);
            CellState _state = this.grid.get(((j * this.width) + i)).getState();
            boolean _equals = Objects.equal(_state, CellState.NORMAL);
            if (_equals) {
              if ((count < deathLimit)) {
                Cell _cell = new Cell(i, j, CellState.WALL);
                newGrid.add(_cell);
              } else {
                Cell _cell_1 = new Cell(i, j, CellState.NORMAL);
                newGrid.add(_cell_1);
              }
            } else {
              if ((count > birthLimit)) {
                Cell _cell_2 = new Cell(i, j, CellState.NORMAL);
                newGrid.add(_cell_2);
              } else {
                Cell _cell_3 = new Cell(i, j, CellState.WALL);
                newGrid.add(_cell_3);
              }
            }
          }
        }
      }
      _xblockexpression = this.grid = newGrid;
    }
    return _xblockexpression;
  }
  
  /**
   * Count the number of neighbours who has a Normal State
   * @param x the position x
   * @param y the position y
   * @return the number of neighbours
   */
  public int countNormalStateNeighbours(final int x, final int y) {
    int _xblockexpression = (int) 0;
    {
      int count = 0;
      for (int i = (-1); (i < 2); i++) {
        for (int j = (-1); (j < 2); j++) {
          {
            int temp_x = (x + i);
            int temp_y = (y + j);
            if (((((temp_x < 0) || (temp_y < 0)) || (temp_x >= this.height)) || (temp_y >= this.width))) {
              count++;
            } else {
              CellState _state = this.grid.get(((temp_y * this.width) + temp_x)).getState();
              boolean _equals = Objects.equal(_state, CellState.NORMAL);
              if (_equals) {
                count++;
              }
            }
          }
        }
      }
      _xblockexpression = count;
    }
    return _xblockexpression;
  }
  
  /**
   * Places the nest on the map
   */
  public void placeNest() {
    final int nestLimit = 2;
    for (int i = 0; (i < this.width); i++) {
      for (int j = 0; (j < this.height); j++) {
        CellState _state = this.grid.get(((j * this.width) + i)).getState();
        boolean _equals = Objects.equal(_state, CellState.NORMAL);
        if (_equals) {
          int count = this.countNormalStateNeighbours(i, j);
          if ((count == nestLimit)) {
            Cell _get = this.grid.get(((j * this.width) + i));
            _get.setState(CellState.HOME);
          }
        }
      }
    }
  }
  
  /**
   * Places the food on the map
   */
  public void placeFood() {
    final int foodLimit = 2;
    for (int i = this.width; (i < 0); i--) {
      for (int j = this.height; (j < 0); j--) {
        CellState _state = this.grid.get(((j * this.width) + i)).getState();
        boolean _equals = Objects.equal(_state, CellState.NORMAL);
        if (_equals) {
          int count = this.countNormalStateNeighbours(i, j);
          if ((count == foodLimit)) {
            Cell _get = this.grid.get(((j * this.width) + i));
            _get.setState(CellState.FOOD);
          }
        }
      }
    }
  }
  
  /**
   * Generates the map
   * @return the 2D grid
   */
  public List<Cell> generateMap() {
    ArrayList<Cell> _xblockexpression = null;
    {
      this.initializeMap();
      for (int i = 0; (i < 3); i++) {
        this.simulationStep();
      }
      this.placeNest();
      this.placeFood();
      _xblockexpression = this.grid;
    }
    return _xblockexpression;
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
    MapGenerator other = (MapGenerator) obj;
    if (Float.floatToIntBits(other.chanceNormalState) != Float.floatToIntBits(this.chanceNormalState))
      return false;
    if (other.width != this.width)
      return false;
    if (other.height != this.height)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.chanceNormalState);
    result = prime * result + this.width;
    result = prime * result + this.height;
    return result;
  }
}
