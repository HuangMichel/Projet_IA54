package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Vector2i;

@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class Influence extends Event {
  public Vector2i v;
  
  public Vector2i newpos;
  
  public AntBody body;
  
  public Influence(final Vector2i v, final Vector2i newpos, final AntBody body) {
    this.v = v;
    this.newpos = newpos;
    this.body = body;
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
   * Returns a String representation of the Influence event's attributes only.
   */
  @SyntheticMember
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("v  = ").append(this.v);
    result.append("newpos  = ").append(this.newpos);
    result.append("body  = ").append(this.body);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 3621897213L;
}
