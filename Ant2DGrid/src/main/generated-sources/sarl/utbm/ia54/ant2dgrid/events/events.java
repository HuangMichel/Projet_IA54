package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class events extends Event {
  @SyntheticMember
  public events() {
    super();
  }
  
  @SyntheticMember
  public events(final Address source) {
    super(source);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 588368462L;
}