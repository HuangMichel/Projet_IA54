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
 * An Ant body contains information of an ant
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class AntBody {
  /**
   * The id
   */
  private UUID id;
  
  /**
   * The capacity to take a food
   */
  private float capacity;
  
  /**
   * The position
   */
  private Vector2i position;
  
  /**
   * The state
   */
  private AntState state;
  
  /**
   * A boolean took
   */
  private boolean took = false;
  
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
  
  /**
   * Gets the id
   * @return id
   */
  @Pure
  public UUID getID() {
    return this.id;
  }
  
  /**
   * Gets the capacity
   * @return capacity
   */
  @Pure
  public float getCapacity() {
    return this.capacity;
  }
  
  /**
   * Gets the position
   * @return position
   */
  @Pure
  public Vector2i getPosition() {
    return this.position;
  }
  
  /**
   * Gets the state
   * @return state
   */
  @Pure
  public AntState getState() {
    return this.state;
  }
  
  /**
   * Sets the id
   * @param id the UUID
   */
  public void setID(final UUID id) {
    this.id = id;
  }
  
  /**
   * Sets the position
   * @param position the position
   */
  public void setPosition(final Vector2i position) {
    this.position = position;
  }
  
  /**
   * Sets the capacity
   * @param f the capacity
   */
  public void setCapacity(final float f) {
    this.capacity = f;
  }
  
  /**
   * Sets the state
   * @param state the AntState
   */
  public void setState(final AntState state) {
    this.state = state;
  }
  
  /**
   * Tests if took
   * @return true, if successful
   */
  @Pure
  public boolean isTook() {
    return this.took;
  }
  
  /**
   * Sets is took
   */
  public void setTook() {
    this.took = true;
  }
  
  /**
   * Sets is put
   */
  public void put() {
    this.took = false;
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
    if (other.took != this.took)
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
    result = prime * result + (this.took ? 1231 : 1237);
    return result;
  }
}
