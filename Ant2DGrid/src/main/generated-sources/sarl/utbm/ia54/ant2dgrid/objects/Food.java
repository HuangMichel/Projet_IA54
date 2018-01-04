package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import utbm.ia54.ant2dgrid.Enum.CellState;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Food {
  /**
   * The shape of the food
   */
  private Shape shape;
  
  /**
   * The color of the shape
   */
  private Color color;
  
  /**
   * The quantity of food
   */
  private float food;
  
  public Food(final CellState state) {
    Polygon _polygon = new Polygon(10, 10, 10, 10, 10, 10, 10);
    this.shape = _polygon;
    if ((state == CellState.FOOD)) {
      this.food = 1000f;
      Color _color = new Color(0.5, 0.5, 0.5, 1);
      this.color = _color;
    } else {
      this.food = 0;
      Color _color_1 = new Color(0.5, 0.5, 0.5, 0);
      this.color = _color_1;
    }
    this.shape.setFill(this.color);
  }
  
  /**
   * Gets the quantity of food
   * @return food
   */
  public float getFood() {
    return this.food;
  }
  
  /**
   * Sets the quantity of food
   * @param f the quantity of food
   */
  public void setFood(final float f) {
    this.food = f;
  }
  
  /**
   * Increments the quantity of food
   * @param f the quantity of food
   */
  public void incrementFood(final float f) {
    float _food = this.food;
    this.food = (_food + f);
    this.incrementOpacity();
  }
  
  /**
   * Decrements the quantity of food
   * @param f the quantity of food
   */
  public void decrementFood(final float f) {
    float _food = this.food;
    this.food = (_food - f);
    this.decrementOpacity();
  }
  
  /**
   * Increments the opacity of the shape
   */
  public void incrementOpacity() {
    double _opacity = this.color.getOpacity();
    boolean _lessThan = (_opacity < 0.9f);
    if (_lessThan) {
      double _red = this.color.getRed();
      double _green = this.color.getGreen();
      double _blue = this.color.getBlue();
      double _opacity_1 = this.color.getOpacity();
      double _plus = (_opacity_1 + 0.1);
      Color _color = new Color(_red, _green, _blue, _plus);
      this.color = _color;
      this.shape.setFill(this.color);
    }
  }
  
  /**
   * Decrements the opacity of the shape
   */
  public void decrementOpacity() {
    if (((this.food > 100f) && (this.color.getOpacity() > 0.1f))) {
      double _red = this.color.getRed();
      double _green = this.color.getGreen();
      double _blue = this.color.getBlue();
      double _opacity = this.color.getOpacity();
      double _minus = (_opacity - 0.1);
      Color _color = new Color(_red, _green, _blue, _minus);
      this.color = _color;
      this.shape.setFill(this.color);
    }
  }
  
  /**
   * Gets the shape
   * @return shape
   */
  public Shape getShape() {
    return this.shape;
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
    Food other = (Food) obj;
    if (Float.floatToIntBits(other.food) != Float.floatToIntBits(this.food))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.food);
    return result;
  }
}
