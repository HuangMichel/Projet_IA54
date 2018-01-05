package utbm.ia54.ant2dgrid.events;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

/**
 * Informs the ant that he is on the food place
 */
@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class onFoodPlace extends Event {
  @SyntheticMember
  public onFoodPlace() {
    super();
  }
  
  @SyntheticMember
  public onFoodPlace(final Address source) {
    super(source);
  }
}
