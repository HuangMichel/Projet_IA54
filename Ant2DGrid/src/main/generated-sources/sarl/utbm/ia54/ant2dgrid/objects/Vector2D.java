package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Vector2D {
  private double x;
  
  private double y;
  
  public Vector2D() {
    this.x = 0;
    this.y = 0;
  }
  
  public Vector2D(final double x, final double y) {
    this.x = x;
    this.y = y;
  }
  
  public Vector2D(final Vector2D v) {
    this.x = v.getX();
    this.y = v.getY();
  }
  
  @Pure
  public double getX() {
    return this.x;
  }
  
  @Pure
  public double getY() {
    return this.y;
  }
  
  public void setX(final double x) {
    this.x = x;
  }
  
  public void setY(final double y) {
    this.y = y;
  }
  
  public double setXY(final double x, final double y) {
    double _xblockexpression = (double) 0;
    {
      this.x = x;
      _xblockexpression = this.y = y;
    }
    return _xblockexpression;
  }
  
  public double setXY(final Vector2D v) {
    double _xblockexpression = (double) 0;
    {
      this.x = v.getX();
      _xblockexpression = this.y = v.getY();
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
    Vector2D other = (Vector2D) obj;
    if (Double.doubleToLongBits(other.x) != Double.doubleToLongBits(this.x))
      return false;
    if (Double.doubleToLongBits(other.y) != Double.doubleToLongBits(this.y))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
    result = prime * result + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
    return result;
  }
}
