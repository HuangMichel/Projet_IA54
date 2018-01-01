package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
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
  
  public Pheromone() {
    this.type = AntState.SEARCH_FOOD;
    this.intensity = 0f;
    this.coefEvaporation = 0.5f;
  }
  
  public Pheromone(final AntState type) {
    this.type = type;
    this.intensity = 0f;
    this.coefEvaporation = 0.5f;
  }
  
  public Pheromone(final AntState type, final float intensity, final float coefEvaporation) {
    this.type = type;
    this.intensity = intensity;
    this.coefEvaporation = coefEvaporation;
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
  
  public float incrementIntensity() {
    return this.intensity++;
  }
  
  public float evaporation() {
    float _intensity = this.intensity;
    return this.intensity = (_intensity * this.coefEvaporation);
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
