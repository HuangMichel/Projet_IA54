package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class ConfigureSimulation extends Event {
  public final int antQuantity;
  
  public ConfigureSimulation(final int antQuantity) {
    this.antQuantity = antQuantity;
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
    ConfigureSimulation other = (ConfigureSimulation) obj;
    if (other.antQuantity != this.antQuantity)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.antQuantity;
    return result;
  }
  
  /**
   * Returns a String representation of the ConfigureSimulation event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("antQuantity  = ").append(this.antQuantity);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 1807761431L;
}
