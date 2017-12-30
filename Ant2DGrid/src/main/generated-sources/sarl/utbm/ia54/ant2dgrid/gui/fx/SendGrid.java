package utbm.ia54.ant2dgrid.gui.fx;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.util.List;
import utbm.ia54.ant2dgrid.objects.Cell;

@SarlSpecification("0.6")
@SarlElementType(14)
@SuppressWarnings("all")
public class SendGrid extends Event {
  public List<Cell> grid;
  
  public SendGrid(final List<Cell> grid) {
    this.grid = grid;
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
   * Returns a String representation of the SendGrid event's attributes only.
   */
  @SyntheticMember
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("grid  = ").append(this.grid);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = -2314718677L;
}
