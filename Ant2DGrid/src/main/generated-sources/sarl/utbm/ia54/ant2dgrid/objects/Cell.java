package utbm.ia54.ant2dgrid.objects;

import com.google.common.base.Objects;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
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
   * Quantity of food in Food place
   */
  private Food foodPlace;
  
  /**
   * Number of food in Nest place
   */
  private Food foodInNest;
  
  private Shape shapeAnt;
  
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
  
  public void addAnt(final UUID id, final AntBody ant) {
    synchronized (this.antList) {
      this.antList.put(id, ant);
      boolean _notEquals = (!Objects.equal(this.state, CellState.HOME));
      if (_notEquals) {
        this.incrementPheromone(ant.getState());
      }
      this.incrementOpacity();
    }
  }
  
  public void removeAnt(final UUID id, final AntBody ant) {
    synchronized (this.antList) {
      this.antList.remove(id, ant);
      this.decrementOpacity();
    }
  }
  
  @Pure
  public Map<UUID, AntBody> getAntList() {
    Map<UUID, AntBody> _xsynchronizedexpression = null;
    synchronized (this.antList) {
      _xsynchronizedexpression = Collections.<UUID, AntBody>unmodifiableMap(this.antList);
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public int getNumberAnt() {
    int _xsynchronizedexpression = (int) 0;
    synchronized (this.antList) {
      _xsynchronizedexpression = this.antList.size();
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public CellState getState() {
    return this.state;
  }
  
  public Food setState(final CellState state) {
    Food _xblockexpression = null;
    {
      this.state = state;
      this.setColor();
      Food _xifexpression = null;
      if ((state == CellState.FOOD)) {
        Food _food = new Food(state);
        _xifexpression = this.foodPlace = _food;
      } else {
        Food _food_1 = new Food(state);
        _xifexpression = this.foodInNest = _food_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Pure
  public Pheromone getPheromoneHome() {
    return this.pheromoneHome;
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
  public Pheromone getPheromoneFood() {
    return this.pheromoneFood;
  }
  
  @Pure
  public float getPheromoneFoodIntensity() {
    float _xsynchronizedexpression = (float) 0;
    synchronized (this.pheromoneFood) {
      _xsynchronizedexpression = this.pheromoneFood.getIntensity();
    }
    return _xsynchronizedexpression;
  }
  
  public void incrementPheromoneHomeIntensity() {
    synchronized (this.pheromoneHome) {
      this.pheromoneHome.incrementIntensity();
    }
  }
  
  public void incrementPheromoneFoodIntensity() {
    synchronized (this.pheromoneFood) {
      this.pheromoneFood.incrementIntensity();
    }
  }
  
  public void evaporationPheromoneFood() {
    synchronized (this.pheromoneFood) {
      this.pheromoneFood.evaporation();
    }
  }
  
  public void evaporationPheromoneHome() {
    synchronized (this.pheromoneHome) {
      this.pheromoneHome.evaporation();
    }
  }
  
  public void removeAllAnt() {
    synchronized (this.antList) {
      Set<Map.Entry<UUID, AntBody>> _entrySet = this.antList.entrySet();
      for (final Map.Entry<UUID, AntBody> body : _entrySet) {
        this.removeAnt(body.getKey(), body.getValue());
      }
    }
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
  
  private void setShapeAnt() {
    Color _color = new Color(0f, 0f, 1f, 0);
    this.color = _color;
    Polygon _polygon = new Polygon(
      30, 
      30, 
      40, 
      40, 
      20, 
      40);
    this.shapeAnt = _polygon;
    this.shapeAnt.setFill(this.color);
  }
  
  public void decrementOpacity() {
    double _opacity = this.color.getOpacity();
    boolean _greaterThan = (_opacity > 0.1);
    if (_greaterThan) {
      double _red = this.color.getRed();
      double _green = this.color.getGreen();
      double _blue = this.color.getBlue();
      double _opacity_1 = this.color.getOpacity();
      double _minus = (_opacity_1 - 0.3);
      Color _color = new Color(_red, _green, _blue, _minus);
      this.color = _color;
      this.shapeAnt.setFill(this.color);
    }
  }
  
  public void incrementOpacity() {
    double _opacity = this.color.getOpacity();
    boolean _lessThan = (_opacity < 0.9);
    if (_lessThan) {
      double _red = this.color.getRed();
      double _green = this.color.getGreen();
      double _blue = this.color.getBlue();
      double _opacity_1 = this.color.getOpacity();
      double _plus = (_opacity_1 + 0.3);
      Color _color = new Color(_red, _green, _blue, _plus);
      this.color = _color;
      this.shapeAnt.setFill(this.color);
    }
  }
  
  @Pure
  public Shape getShapeAnt() {
    return this.shapeAnt;
  }
  
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
  
  @Pure
  public Food getFood() {
    Food _xblockexpression = null;
    {
      Food food = null;
      if ((this.state == CellState.FOOD)) {
        food = this.foodPlace;
      } else {
        food = this.foodInNest;
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
