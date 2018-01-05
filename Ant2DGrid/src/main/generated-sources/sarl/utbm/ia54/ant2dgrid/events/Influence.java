package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * The Ant sends to the environment to move
 * @param newpos the new position
 * @param body the AntBodyZ
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class Influence extends Event {
  public Vector2i newpos;
  
  public AntBody body;
  
  public Influence(final Vector2i newpos, final AntBody body) {
    this.newpos = newpos;
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
   * Returns a String representation of the Influence event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("newpos  = ").append(this.newpos);
    result.append("body  = ").append(this.body);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 1686467621L;
}
