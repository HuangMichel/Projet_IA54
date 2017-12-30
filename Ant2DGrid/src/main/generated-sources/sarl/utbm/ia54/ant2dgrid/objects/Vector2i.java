package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Simple 2D Vector contains x and y position
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Vector2i {
  /**
   * The position x
   */
  private int x;
  
  /**
   * The position y
   */
  private int y;
  
  public Vector2i() {
    this.x = 0;
    this.y = 0;
  }
  
  public Vector2i(final int x, final int y) {
    this.x = x;
    this.y = y;
  }
  
  public Vector2i(final Vector2i v) {
    this.x = v.getX();
    this.y = v.getY();
  }
  
  @Pure
  public int getX() {
    return this.x;
  }
  
  @Pure
  public int getY() {
    return this.y;
  }
  
  public void setX(final int x) {
    this.x = x;
  }
  
  public void setY(final int y) {
    this.y = y;
  }
  
  public int setXY(final int x, final int y) {
    int _xblockexpression = (int) 0;
    {
      this.x = x;
      _xblockexpression = this.y = y;
    }
    return _xblockexpression;
  }
  
  public int setXY(final Vector2i v) {
    int _xblockexpression = (int) 0;
    {
      this.x = v.getX();
      _xblockexpression = this.y = v.getY();
    }
    return _xblockexpression;
  }
  
  @Pure
  public String toString() {
    return ((("X : " + Integer.valueOf(this.x)) + ", Y : ") + Integer.valueOf(this.y));
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
    Vector2i other = (Vector2i) obj;
    if (other.x != this.x)
      return false;
    if (other.y != this.y)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.x;
    result = prime * result + this.y;
    return result;
  }
}
