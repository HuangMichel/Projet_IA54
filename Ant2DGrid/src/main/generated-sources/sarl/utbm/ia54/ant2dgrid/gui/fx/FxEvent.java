package utbm.ia54.ant2dgrid.gui.fx;

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
public class FxEvent extends Event {
  @SyntheticMember
  public FxEvent() {
    super();
  }
  
  @SyntheticMember
  public FxEvent(final Address source) {
    super(source);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 588368462L;
}
