package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;
import java.util.Objects;
import java.util.UUID;
import utbm.ia54.ant2dgrid.objects.Vector2i;

@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class Influence extends Event {
  public Vector2i v;
  
  public UUID id;
  
  @SyntheticMember
  public Influence() {
    super();
  }
  
  @SyntheticMember
  public Influence(final Address source) {
    super(source);
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
    Influence other = (Influence) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.id);
    return result;
  }
  
  /**
   * Returns a String representation of the Influence event's attributes only.
   */
  @SyntheticMember
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("v  = ").append(this.v);
    result.append("id  = ").append(this.id);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 2657391728L;
}
