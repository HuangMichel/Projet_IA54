package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.objects.Vector2D;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Cell {
  private Vector2D vector;
  
  public Cell() {
    Vector2D _vector2D = new Vector2D();
    this.vector = _vector2D;
  }
  
  public Cell(final Vector2D v) {
    Vector2D _vector2D = new Vector2D(v);
    this.vector = _vector2D;
  }
  
  public Cell(final double x, final double y) {
    Vector2D _vector2D = new Vector2D(x, y);
    this.vector = _vector2D;
  }
  
  @Pure
  public Vector2D getPosition() {
    return this.vector;
  }
  
  public void setPosition(final Vector2D v) {
    this.vector = v;
  }
  
  public void setPosition(final double x, final double y) {
    this.vector.setX(x);
    this.vector.setY(y);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
}
