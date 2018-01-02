package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
  
  public AntState getType() {
    return this.type;
  }
  
  public float getIntensity() {
    return this.intensity;
  }
  
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
    double _red = this.color.getRed();
    double _green = this.color.getGreen();
    double _blue = this.color.getBlue();
    double _opacity = this.color.getOpacity();
    double _plus = (_opacity + 0.05);
    Color _color = new Color(_red, _green, _blue, _plus);
    this.color = _color;
    this.objfx.setFill(this.color);
  }
  
  public float evaporation() {
    float _intensity = this.intensity;
    return this.intensity = (_intensity * this.coefEvaporation);
  }
  
  public Shape getObjfx() {
    return this.objfx;
  }
  
  public String toString() {
    return ("Intensity : " + Float.valueOf(this.intensity));
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
    Pheromone other = (Pheromone) obj;
    if (Float.floatToIntBits(other.intensity) != Float.floatToIntBits(this.intensity))
      return false;
    if (Float.floatToIntBits(other.coefEvaporation) != Float.floatToIntBits(this.coefEvaporation))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.intensity);
    result = prime * result + Float.floatToIntBits(this.coefEvaporation);
    return result;
  }
}
