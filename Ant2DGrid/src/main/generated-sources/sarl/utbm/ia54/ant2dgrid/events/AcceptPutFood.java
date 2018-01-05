package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Accepts to put the food
 * @param accept a boolean
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class AcceptPutFood extends Event {
  public boolean accept;
  
  public AcceptPutFood(final boolean accept) {
    this.accept = accept;
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
    AcceptPutFood other = (AcceptPutFood) obj;
    if (other.accept != this.accept)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + (this.accept ? 1231 : 1237);
    return result;
  }
  
  /**
   * Returns a String representation of the AcceptPutFood event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("accept  = ").append(this.accept);
    return result.toString();
  }
}
