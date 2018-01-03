package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.AntState;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Pheromone {
  private AntState type;
  
  private float intensity;
  
  private final float coefEvaporation;
  
  private final Shape objfx;
  
  private Color color;
  
  public Pheromone() {
    this.type = AntState.SEARCH_FOOD;
    this.intensity = 0f;
    this.coefEvaporation = 0.5f;
    Color _color = new Color(1, 0, 0, 0);
    this.color = _color;
    Rectangle _rectangle = new Rectangle(10, 10, this.color);
    this.objfx = _rectangle;
  }
  
  public Pheromone(final AntState type) {
    this.type = type;
    this.intensity = 0f;
    this.coefEvaporation = 0.5f;
    if ((type == AntState.SEARCH_FOOD)) {
      Color _color = new Color(1.0, 0, 0, 0);
      this.color = _color;
      Rectangle _rectangle = new Rectangle(10, 10, this.color);
      this.objfx = _rectangle;
    } else {
      Color _color_1 = new Color(0, 1.0, 0, 0);
      this.color = _color_1;
      Circle _circle = new Circle(7, this.color);
      this.objfx = _circle;
    }
  }
  
  public Pheromone(final AntState type, final float intensity, final float coefEvaporation) {
    this.type = type;
    this.intensity = intensity;
    this.coefEvaporation = coefEvaporation;
    if ((type == AntState.SEARCH_FOOD)) {
      Color _color = new Color(1.0, 0, 0, 0);
      this.color = _color;
      Rectangle _rectangle = new Rectangle(10, 10, this.color);
      this.objfx = _rectangle;
    } else {
      Color _color_1 = new Color(0, 1.0, 0, 0);
      this.color = _color_1;
      Circle _circle = new Circle(7, this.color);
      this.objfx = _circle;
    }
  }
  
  @Pure
  public AntState getType() {
    return this.type;
  }
  
  @Pure
  public float getIntensity() {
    return this.intensity;
  }
  
  @Pure
  public float getCoefEvaportation() {
    return this.coefEvaporation;
  }
  
  public void setType(final AntState type) {
    this.type = type;
  }
  
  public void setIntensity(final float intensity) {
    this.intensity = intensity;
  }
  
  public void incrementIntensity() {
    this.intensity++;
    double _opacity = this.color.getOpacity();
    boolean _lessThan = (_opacity < 0.9f);
    if (_lessThan) {
      double _red = this.color.getRed();
      double _green = this.color.getGreen();
      double _blue = this.color.getBlue();
      double _opacity_1 = this.color.getOpacity();
      double _plus = (_opacity_1 + 0.05);
      Color _color = new Color(_red, _green, _blue, _plus);
      this.color = _color;
      this.objfx.setFill(this.color);
    }
  }
  
  public void evaporation() {
    float _intensity = this.intensity;
    this.intensity = (_intensity * this.coefEvaporation);
    double _opacity = this.color.getOpacity();
    boolean _greaterThan = (_opacity > 0.1f);
    if (_greaterThan) {
      double _red = this.color.getRed();
      double _green = this.color.getGreen();
      double _blue = this.color.getBlue();
      double _opacity_1 = this.color.getOpacity();
      double _minus = (_opacity_1 - 0.05);
      Color _color = new Color(_red, _green, _blue, _minus);
      this.color = _color;
      this.objfx.setFill(this.color);
    }
  }
  
  @Pure
  public Shape getObjfx() {
    return this.objfx;
  }
  
  @Pure
  public String toString() {
    return ("Intensity : " + Float.valueOf(this.intensity));
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
    Pheromone other = (Pheromone) obj;
    if (Float.floatToIntBits(other.intensity) != Float.floatToIntBits(this.intensity))
      return false;
    if (Float.floatToIntBits(other.coefEvaporation) != Float.floatToIntBits(this.coefEvaporation))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.intensity);
    result = prime * result + Float.floatToIntBits(this.coefEvaporation);
    return result;
  }
}
