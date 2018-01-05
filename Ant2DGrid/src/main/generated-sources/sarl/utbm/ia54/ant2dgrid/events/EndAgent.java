package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * Informs all agent to kill
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class EndAgent extends Event {
  @SyntheticMember
  public EndAgent() {
    super();
  }
  
  @SyntheticMember
  public EndAgent(final Address source) {
    super(source);
  }
}
