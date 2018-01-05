package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * Pause the Simulation
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class PauseSim extends Event {
  @SyntheticMember
  public PauseSim() {
    super();
  }
  
  @SyntheticMember
  public PauseSim(final Address source) {
    super(source);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 588368462L;
}
