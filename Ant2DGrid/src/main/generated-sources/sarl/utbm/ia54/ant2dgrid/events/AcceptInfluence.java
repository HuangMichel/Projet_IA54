package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * Accepts the move by the environment
 * @param newpos the new position
 * @param accept a boolean
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class AcceptInfluence extends Event {
  public Vector2i newpos;
  
  public boolean accept;
  
  public AcceptInfluence(final Vector2i newpos, final boolean accept) {
    this.newpos = newpos;
    this.accept = accept;
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
    AcceptInfluence other = (AcceptInfluence) obj;
    if (other.accept != this.accept)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + (this.accept ? 1231 : 1237);
    return result;
  }
  
  /**
   * Returns a String representation of the AcceptInfluence event's attributes only.
   */
  @SyntheticMember
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("newpos  = ").append(this.newpos);
    result.append("accept  = ").append(this.accept);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = -1414600981L;
}
