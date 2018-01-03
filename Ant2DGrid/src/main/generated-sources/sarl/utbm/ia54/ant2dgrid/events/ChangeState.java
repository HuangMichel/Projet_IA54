package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import utbm.ia54.ant2dgrid.Enum.AntState;

@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class ChangeState extends Event {
  public AntState newState;
  
  public ChangeState(final AntState newState) {
    this.newState = newState;
  }
  
  @Override
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
  
  /**
   * Returns a String representation of the ChangeState event's attributes only.
   */
  @SyntheticMember
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("newState  = ").append(this.newState);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 883262486L;
}
