package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.objects.Cell;

/**
 * The environment sends the perception to an Ant
 * @param list the list of perception
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class Perception extends Event {
  public Map<UUID, List<Cell>> list;
  
  public Perception(final Map<UUID, List<Cell>> list) {
    this.list = list;
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
   * Returns a String representation of the Perception event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("list  = ").append(this.list);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 2934127843L;
}
