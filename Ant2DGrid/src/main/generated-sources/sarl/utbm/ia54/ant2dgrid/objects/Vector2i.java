package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;

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
  
  /**
   * Gets x position
   * @return x
   */
  public int getX() {
    return this.x;
  }
  
  /**
   * Gets y position
   * @return y
   */
  public int getY() {
    return this.y;
  }
  
  /**
   * Sets x position
   * @param x the x position
   */
  public void setX(final int x) {
    this.x = x;
  }
  
  /**
   * Sets y position
   * @param y the x position
   */
  public void setY(final int y) {
    this.y = y;
  }
  
  /**
   * Sets x and y position
   * @param x the x position
   * @param y the y position
   */
  public int setXY(final int x, final int y) {
    int _xblockexpression = (int) 0;
    {
      this.x = x;
      _xblockexpression = this.y = y;
    }
    return _xblockexpression;
  }
  
  /**
   * Sets x and y position
   * @param v the vector
   */
  public int setXY(final Vector2i v) {
    int _xblockexpression = (int) 0;
    {
      this.x = v.getX();
      _xblockexpression = this.y = v.getY();
    }
    return _xblockexpression;
  }
  
  /**
   * Adds
   * @param v the vector
   */
  public int plus(final Vector2i v) {
    int _xblockexpression = (int) 0;
    {
      int _x = this.x;
      this.x = (_x + v.x);
      int _y = this.y;
      _xblockexpression = this.y = (_y + v.y);
    }
    return _xblockexpression;
  }
  
  /**
   * Adds
   * @param x the x position
   * @param y the y position
   */
  public int plus(final int x, final int y) {
    int _xblockexpression = (int) 0;
    {
      int _x = this.x;
      this.x = (_x + x);
      int _y = this.y;
      _xblockexpression = this.y = (_y + y);
    }
    return _xblockexpression;
  }
  
  public boolean equals(final Object obj) {
    boolean _xblockexpression = false;
    {
      boolean bool = false;
      if ((obj instanceof Vector2i)) {
        Vector2i v = ((Vector2i) obj);
        if ((Integer.valueOf(v.x).equals(Integer.valueOf(this.x)) && Integer.valueOf(v.y).equals(Integer.valueOf(this.y)))) {
          bool = true;
        }
      }
      _xblockexpression = bool;
    }
    return _xblockexpression;
  }
  
  public String toString() {
    return ((("X : " + Integer.valueOf(this.x)) + ", Y : ") + Integer.valueOf(this.y));
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.x;
    result = prime * result + this.y;
    return result;
  }
}
