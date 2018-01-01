package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.layout.Pane;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.agents.Ant;
import utbm.ia54.ant2dgrid.objects.Pheromone;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Cell extends Pane {
  /**
   * The vector position
   */
  private Vector2i vector;
  
  /**
   * A list of ants
   */
  private final ArrayList<Ant> AntList;
  
  /**
   * The cell state
   */
  private CellState state;
  
  /**
   * The pheromone home
   */
  private Pheromone pheromoneHome;
  
  /**
   * The pheromone food
   */
  private Pheromone pheromoneFood;
  
  /**
   * Quantity of food in Food place
   */
  private float foodToPick;
  
  /**
   * Number of food in Nest place
   */
  private float foodInNest;
  
  public Cell() {
    Vector2i _vector2i = new Vector2i();
    this.vector = _vector2i;
    ArrayList<Ant> _arrayList = new ArrayList<Ant>();
    this.AntList = _arrayList;
    this.state = CellState.NORMAL;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
  }
  
  public Cell(final int x, final int y) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    ArrayList<Ant> _arrayList = new ArrayList<Ant>();
    this.AntList = _arrayList;
    this.state = CellState.NORMAL;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
  }
  
  public Cell(final Vector2i v) {
    this.vector = v;
    ArrayList<Ant> _arrayList = new ArrayList<Ant>();
    this.AntList = _arrayList;
    this.state = CellState.NORMAL;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
  }
  
  public Cell(final int x, final int y, final CellState state) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    ArrayList<Ant> _arrayList = new ArrayList<Ant>();
    this.AntList = _arrayList;
    this.state = state;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
  }
  
  public Cell(final Vector2i v, final ArrayList<Ant> antList, final CellState state) {
    Vector2i _vector2i = new Vector2i(v);
    this.vector = _vector2i;
    this.AntList = antList;
    this.state = state;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
  }
  
  public Cell(final int x, final int y, final ArrayList<Ant> antList, final CellState state) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    this.AntList = antList;
    this.state = state;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
  }
  
  @Pure
  public Vector2i getPosition() {
    return this.vector;
  }
  
  public void setPosition(final Vector2i v) {
    this.vector = v;
  }
  
  public void setPosition(final int x, final int y) {
    this.vector.setX(x);
    this.vector.setY(y);
  }
  
  public boolean addAnt(final Ant ant) {
    boolean _xsynchronizedexpression = false;
    synchronized (this.AntList) {
      _xsynchronizedexpression = this.AntList.add(ant);
    }
    return _xsynchronizedexpression;
  }
  
  public boolean removeAnt(final Ant ant) {
    boolean _xsynchronizedexpression = false;
    synchronized (this.AntList) {
      _xsynchronizedexpression = this.AntList.remove(ant);
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public List<Ant> getAntList() {
    List<Ant> _xsynchronizedexpression = null;
    synchronized (this.AntList) {
      _xsynchronizedexpression = Collections.<Ant>unmodifiableList(this.AntList);
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public int getNumberAnt() {
    int _xsynchronizedexpression = (int) 0;
    synchronized (this.AntList) {
      _xsynchronizedexpression = this.AntList.size();
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public CellState getState() {
    return this.state;
  }
  
  public float setState(final CellState state) {
    float _xblockexpression = (float) 0;
    {
      this.state = state;
      this.setColor();
      _xblockexpression = this.setFood();
    }
    return _xblockexpression;
  }
  
  @Pure
  public float getPheromoneHomeIntensity() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneHome) {
      _xsynchronizedexpression = this.pheromoneHome.getIntensity();
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public float getPheromoneFoodIntensity() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneFood) {
      _xsynchronizedexpression = this.pheromoneFood.getIntensity();
    }
    return _xsynchronizedexpression;
  }
  
  public float incrementPheromoneHomeIntensity() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneHome) {
      _xsynchronizedexpression = this.pheromoneHome.incrementIntensity();
    }
    return _xsynchronizedexpression;
  }
  
  public float incrementPheromoneFoodIntensity() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneFood) {
      _xsynchronizedexpression = this.pheromoneFood.incrementIntensity();
    }
    return _xsynchronizedexpression;
  }
  
  public float evaporationPheromoneFood() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneFood) {
      _xsynchronizedexpression = this.pheromoneFood.evaporation();
    }
    return _xsynchronizedexpression;
  }
  
  public float evaporationPheromoneHome() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneHome) {
      _xsynchronizedexpression = this.pheromoneHome.evaporation();
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public boolean removeAllAnt() {
    boolean _xsynchronizedexpression = false;
    synchronized (this.AntList) {
      _xsynchronizedexpression = CollectionExtensions.<Ant>removeAll(this.AntList);
    }
    return _xsynchronizedexpression;
  }
  
  public void setColor() {
    String color = null;
    final CellState _switchValue = this.state;
    if (_switchValue != null) {
      switch (_switchValue) {
        case WALL:
          color = "#d2691e";
          break;
        case HOME:
          color = "#f0ffff";
          break;
        case FOOD:
          color = "#00ffff";
          break;
        default:
          color = "#a9a9a9";
          break;
      }
    } else {
      color = "#a9a9a9";
    }
    this.setStyle(("-fx-background-color: " + color));
  }
  
  @Pure
  public String getColor() {
    return this.getStyle();
  }
  
  public float setFood() {
    float _xifexpression = (float) 0;
    if ((this.state == CellState.FOOD)) {
      _xifexpression = this.foodToPick = 100f;
    }
    return _xifexpression;
  }
  
  @Pure
  public float getFood() {
    return this.foodToPick;
  }
  
  public void setFoodInNest(final float n) {
    this.foodInNest = n;
  }
  
  @Pure
  public float getFoodInNest() {
    return this.foodInNest;
  }
  
  public String toString() {
    String _xblockexpression = null;
    {
      String _string = this.vector.toString();
      String _plus = ("Cell : " + _string);
      String _plus_1 = (_plus + "\n Ant : ");
      int _size = this.AntList.size();
      String _plus_2 = (_plus_1 + Integer.valueOf(_size));
      String _plus_3 = (_plus_2 + "\n food : ");
      String _string_1 = this.pheromoneFood.toString();
      String _plus_4 = (_plus_3 + _string_1);
      String _plus_5 = (_plus_4 + 
        "\n home : ");
      String _string_2 = this.pheromoneHome.toString();
      String _plus_6 = (_plus_5 + _string_2);
      String _plus_7 = (_plus_6 + "\n state : ");
      String string = (_plus_7 + this.state);
      _xblockexpression = string;
    }
    return _xblockexpression;
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
    Cell other = (Cell) obj;
    if (Float.floatToIntBits(other.foodToPick) != Float.floatToIntBits(this.foodToPick))
      return false;
    if (Float.floatToIntBits(other.foodInNest) != Float.floatToIntBits(this.foodInNest))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.foodToPick);
    result = prime * result + Float.floatToIntBits(this.foodInNest);
    return result;
  }
}
