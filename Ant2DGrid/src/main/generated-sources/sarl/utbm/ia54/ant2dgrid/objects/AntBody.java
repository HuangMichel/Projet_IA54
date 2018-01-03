package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.Objects;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class AntBody {
  private UUID id;
  
  private float capacity;
  
  private Vector2i position;
  
  private AntState state;
  
  private boolean take = false;
  
  public AntBody(final UUID id, final Vector2i position) {
    this.id = id;
    this.position = position;
    this.capacity = 2f;
    this.state = AntState.SEARCH_FOOD;
  }
  
  public AntBody(final AntBody body) {
    this.id = body.id;
    this.capacity = body.capacity;
    this.position = body.position;
    this.state = AntState.SEARCH_FOOD;
  }
  
  @Pure
  public UUID getID() {
    return this.id;
  }
  
  @Pure
  public float getCapacity() {
    return this.capacity;
  }
  
  @Pure
  public Vector2i getPosition() {
    return this.position;
  }
  
  @Pure
  public AntState getState() {
    return this.state;
  }
  
  public void setID(final UUID id) {
    this.id = id;
  }
  
  public void setPosition(final Vector2i position) {
    this.position = position;
  }
  
  public void setCapacity(final float f) {
    this.capacity = f;
  }
  
  public void setState(final AntState state) {
    this.state = state;
  }
  
  @Pure
  public boolean isTake() {
    return this.take;
  }
  
  public void setTake() {
    this.take = true;
  }
  
  public void put() {
    this.take = false;
  }
  
  @Pure
  public String toString() {
    String _xblockexpression = null;
    {
      String _string = this.position.toString();
      String _plus = ((("id : " + this.id) + 
        "\n position : ") + _string);
      String _plus_1 = (_plus + 
        "\n capacity : ");
      String _plus_2 = (_plus_1 + Float.valueOf(this.capacity));
      String _plus_3 = (_plus_2 + 
        "\n state : ");
      String string = (_plus_3 + this.state);
      _xblockexpression = string;
    }
    return _xblockexpression;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AntBody other = (AntBody) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    if (Float.floatToIntBits(other.capacity) != Float.floatToIntBits(this.capacity))
      return false;
    if (other.take != this.take)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.id);
    result = prime * result + Float.floatToIntBits(this.capacity);
    result = prime * result + (this.take ? 1231 : 1237);
    return result;
  }
}
