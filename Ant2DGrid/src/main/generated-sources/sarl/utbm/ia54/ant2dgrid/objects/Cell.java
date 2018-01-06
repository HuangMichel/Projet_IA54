package utbm.ia54.ant2dgrid.objects;

import com.google.common.base.Objects;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.agents.Ant;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Food;
import utbm.ia54.ant2dgrid.objects.Pheromone;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * A class contains all informations of the cell
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
  private Map<UUID, AntBody> antList;
  
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
   * Quantity of food in Food place or in Nest place
   */
  private Food foodNest;
  
  /**
   * The shape of an Ant
   */
  private Shape shapeAnt;
  
  /**
   * The color of the shape ant
   */
  private Color color;
  
  public Cell() {
    Vector2i _vector2i = new Vector2i();
    this.vector = _vector2i;
    this.state = CellState.NORMAL;
    HashMap<UUID, AntBody> _hashMap = new HashMap<UUID, AntBody>();
    this.antList = _hashMap;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
    this.setShapeAnt();
  }
  
  public Cell(final int x, final int y) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    HashMap<UUID, AntBody> _hashMap = new HashMap<UUID, AntBody>();
    this.antList = _hashMap;
    this.state = CellState.NORMAL;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
    this.setShapeAnt();
  }
  
  public Cell(final Vector2i v) {
    this.vector = v;
    HashMap<UUID, AntBody> _hashMap = new HashMap<UUID, AntBody>();
    this.antList = _hashMap;
    this.state = CellState.NORMAL;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
    this.setShapeAnt();
  }
  
  public Cell(final int x, final int y, final CellState state) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    HashMap<UUID, AntBody> _hashMap = new HashMap<UUID, AntBody>();
    this.antList = _hashMap;
    this.state = state;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
    this.setShapeAnt();
  }
  
  public Cell(final Vector2i v, final ArrayList<Ant> antList, final CellState state) {
    Vector2i _vector2i = new Vector2i(v);
    this.vector = _vector2i;
    HashMap<UUID, AntBody> _hashMap = new HashMap<UUID, AntBody>();
    this.antList = _hashMap;
    this.state = state;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
    this.setShapeAnt();
  }
  
  public Cell(final int x, final int y, final Map<UUID, AntBody> antList, final CellState state) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    this.antList = antList;
    this.state = state;
    this.setColor();
    Pheromone _pheromone = new Pheromone(AntState.RETURN_HOME);
    this.pheromoneHome = _pheromone;
    Pheromone _pheromone_1 = new Pheromone();
    this.pheromoneFood = _pheromone_1;
    this.setShapeAnt();
  }
  
  /**
   * Gets the position
   * @return vector the position
   */
  @Pure
  public Vector2i getPosition() {
    return this.vector;
  }
  
  /**
   * Sets the position
   * @param v the position
   */
  public void setPosition(final Vector2i v) {
    this.vector = v;
  }
  
  /**
   * Sets the position
   * @param x the x position
   * @param y the y position
   */
  public void setPosition(final int x, final int y) {
    this.vector.setX(x);
    this.vector.setY(y);
  }
  
  /**
   * Adds ant on the list
   * @param id the UUID
   * @param ant the AntBody
   */
  public void addAnt(final UUID id, final AntBody ant) {
    synchronized (this.antList) {
      this.antList.put(id, ant);
      if (((this.state == CellState.NORMAL) && (!Objects.equal(this.state, CellState.WALL)))) {
        this.incrementPheromone(ant.getState());
      }
      int _size = this.antList.size();
      boolean _tripleEquals = (_size == 1);
      if (_tripleEquals) {
        this.incrementOpacity();
      }
    }
  }
  
  /**
   * Removes an ant of the list
   * @param id the UUID
   * @param ant the AntBody
   */
  public void removeAnt(final UUID id, final AntBody ant) {
    synchronized (this.antList) {
      this.antList.remove(id, ant);
      int _size = this.antList.size();
      boolean _tripleEquals = (_size == 0);
      if (_tripleEquals) {
        this.decrementOpacity();
      }
    }
  }
  
  /**
   * Gets the ant list
   * @return antList
   */
  @Pure
  public Map<UUID, AntBody> getAntList() {
    Map<UUID, AntBody> _xsynchronizedexpression = null;
    synchronized (this.antList) {
      _xsynchronizedexpression = Collections.<UUID, AntBody>unmodifiableMap(this.antList);
    }
    return _xsynchronizedexpression;
  }
  
  /**
   * Gets the the quantity of ant on the cell
   * @return size the quantity of ant
   */
  @Pure
  public int getNumberAnt() {
    int _xsynchronizedexpression = (int) 0;
    synchronized (this.antList) {
      _xsynchronizedexpression = this.antList.size();
    }
    return _xsynchronizedexpression;
  }
  
  /**
   * Gets the state of the cell
   * @return state
   */
  @Pure
  public CellState getState() {
    return this.state;
  }
  
  /**
   * Sets the state of the cell
   * @param state the CellState
   */
  public Food setState(final CellState state) {
    Food _xblockexpression = null;
    {
      this.state = state;
      this.setColor();
      Food _xifexpression = null;
      if ((state == CellState.FOOD)) {
        Food _food = new Food(state);
        _xifexpression = this.foodNest = _food;
      } else {
        Food _food_1 = new Food(state);
        _xifexpression = this.foodNest = _food_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets the pheromone Home
   * @return pheromoneHome
   */
  @Pure
  public Pheromone getPheromoneHome() {
    return this.pheromoneHome;
  }
  
  /**
   * Gets the pheromone home intensity
   * @return intensity
   */
  @Pure
  public float getPheromoneHomeIntensity() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneHome) {
      _xsynchronizedexpression = this.pheromoneHome.getIntensity();
    }
    return _xsynchronizedexpression;
  }
  
  /**
   * Gets the pheromone food
   * @return pheromoneFood
   */
  @Pure
  public Pheromone getPheromoneFood() {
    return this.pheromoneFood;
  }
  
  /**
   * Gets the pheromone food intensity
   * @return intensity
   */
  @Pure
  public float getPheromoneFoodIntensity() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneFood) {
      _xsynchronizedexpression = this.pheromoneFood.getIntensity();
    }
    return _xsynchronizedexpression;
  }
  
  /**
   * Increments the pheromone home intensity
   */
  public void incrementPheromoneHomeIntensity() {
    synchronized (this.pheromoneHome) {
      this.pheromoneHome.incrementIntensity();
    }
  }
  
  /**
   * Increments the pheromone food intensity
   */
  public void incrementPheromoneFoodIntensity() {
    synchronized (this.pheromoneFood) {
      this.pheromoneFood.incrementIntensity();
    }
  }
  
  /**
   * Evaporations the pheromone food intensity
   */
  public void evaporationPheromoneFood() {
    synchronized (this.pheromoneFood) {
      this.pheromoneFood.evaporation();
    }
  }
  
  /**
   * Evaporations the pheromone home intensity
   */
  public void evaporationPheromoneHome() {
    synchronized (this.pheromoneHome) {
      this.pheromoneHome.evaporation();
    }
  }
  
  /**
   * Removes all ant of the list
   */
  public void removeAllAnt() {
    synchronized (this.antList) {
      boolean _isEmpty = this.antList.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final BiConsumer<UUID, AntBody> _function = (UUID k, AntBody v) -> {
          this.removeAnt(k, v);
        };
        this.antList.forEach(_function);
      }
    }
  }
  
  /**
   * Sets the color of the cell
   */
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
  
  /**
   * Gets the color of the cell
   * @return style
   */
  @Pure
  public String getColor() {
    return this.getStyle();
  }
  
  /**
   * Sets the shape of ant
   */
  private void setShapeAnt() {
    Color _color = new Color(0f, 0f, 1f, 0);
    this.color = _color;
    Polygon _polygon = new Polygon(8.0, 0.0, 
      12.0, 0.0, 
      12.0, 2.0, 
      14.0, 3.0, 
      12.0, 4.0, 
      12.0, 6.0, 
      14.0, 7.0, 
      12.0, 8.0, 
      12.0, 10.0, 
      12.0, 12.0, 
      14.0, 13.0, 
      12.0, 14.0, 
      8.0, 14.0, 
      6.0, 13.0, 
      8.0, 12.0, 
      8.0, 10.0, 
      8.0, 8.0, 
      6.0, 7.0, 
      8.0, 6.0, 
      8.0, 4.0, 
      6.0, 3.0, 
      8.0, 2.0, 
      8.0, 4.0);
    this.shapeAnt = _polygon;
    this.shapeAnt.setFill(this.color);
  }
  
  /**
   * Decrements the opacity of the shape ant
   */
  public void decrementOpacity() {
    double _red = this.color.getRed();
    double _green = this.color.getGreen();
    double _blue = this.color.getBlue();
    Color _color = new Color(_red, _green, _blue, 0f);
    this.color = _color;
    this.shapeAnt.setFill(this.color);
  }
  
  /**
   * Increments the opacity of the shape ant
   */
  public void incrementOpacity() {
    double _red = this.color.getRed();
    double _green = this.color.getGreen();
    double _blue = this.color.getBlue();
    Color _color = new Color(_red, _green, _blue, 1f);
    this.color = _color;
    this.shapeAnt.setFill(this.color);
  }
  
  /**
   * Gets the shape ant
   * @return shapeAnt
   */
  @Pure
  public Shape getShapeAnt() {
    return this.shapeAnt;
  }
  
  /**
   * Increments the pheromones
   * @param antState the Antstate
   */
  public void incrementPheromone(final AntState antState) {
    if (antState != null) {
      switch (antState) {
        case RETURN_HOME:
          this.incrementPheromoneFoodIntensity();
          break;
        case SEARCH_FOOD:
          this.incrementPheromoneHomeIntensity();
          break;
        default:
          break;
      }
    }
  }
  
  /**
   * Gets the quantity of food
   * @return food
   */
  @Pure
  public Food getFood() {
    Food _xblockexpression = null;
    {
      Food food = null;
      if ((this.state == CellState.FOOD)) {
        food = this.foodNest;
      } else {
        food = this.foodNest;
      }
      _xblockexpression = food;
    }
    return _xblockexpression;
  }
  
  @Pure
  public boolean equals(final Object obj) {
    boolean _xblockexpression = false;
    {
      boolean bool = false;
      if ((obj instanceof Cell)) {
        Cell cell = ((Cell) obj);
        boolean _equals = cell.vector.equals(this.getPosition());
        if (_equals) {
          bool = true;
        }
      }
      _xblockexpression = bool;
    }
    return _xblockexpression;
  }
  
  public String toString() {
    String _xblockexpression = null;
    {
      String _string = this.vector.toString();
      String _plus = ("Cell : " + _string);
      String _plus_1 = (_plus + "\n Ant : ");
      int _size = this.antList.size();
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
      if (((this.state == CellState.FOOD) || (this.state == CellState.HOME))) {
        String _string_3 = string;
        float _food = this.foodNest.getFood();
        String _plus_8 = ("\n food : " + Float.valueOf(_food));
        string = (_string_3 + _plus_8);
      }
      _xblockexpression = string;
    }
    return _xblockexpression;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
}
