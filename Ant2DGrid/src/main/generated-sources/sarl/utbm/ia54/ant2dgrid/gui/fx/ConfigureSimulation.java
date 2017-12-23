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
public class ConfigureSimulation extends Event {
  public final int antQuantity;
  
  public final int width;
  
  public final int height;
  
  public List<Cell> grid;
  
  public ConfigureSimulation(final int antQuantity, final int width, final int height, final List<Cell> grid) {
    this.antQuantity = antQuantity;
    this.width = width;
    this.height = height;
    this.grid = grid;
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
    ConfigureSimulation other = (ConfigureSimulation) obj;
    if (other.antQuantity != this.antQuantity)
      return false;
    if (other.width != this.width)
      return false;
    if (other.height != this.height)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.antQuantity;
    result = prime * result + this.width;
    result = prime * result + this.height;
    return result;
  }
  
  /**
   * Returns a String representation of the ConfigureSimulation event's attributes only.
   */
  @SyntheticMember
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("antQuantity  = ").append(this.antQuantity);
    result.append("width  = ").append(this.width);
    result.append("height  = ").append(this.height);
    result.append("grid  = ").append(this.grid);
    return result.toString();
  }
  
  @SyntheticMember
  private final static long serialVersionUID = -1306196060L;
}
