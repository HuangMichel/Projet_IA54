package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.objects.AntBody;

/**
 * The ant send to the environment to inform he picks food
 * @param body the AntBody
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class PickFood extends Event {
  public AntBody body;
  
  public PickFood(final AntBody body) {
    this.body = body;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
  
  /**
   * Returns a String representation of the PickFood event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("body  = ").append(this.body);
    return result.toString();
  }
}
