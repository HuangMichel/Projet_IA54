package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * Starting the simulation
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class StartSimulation extends Event {
  @SyntheticMember
  public StartSimulation() {
    super();
  }
  
  @SyntheticMember
  public StartSimulation(final Address source) {
    super(source);
  }
}
