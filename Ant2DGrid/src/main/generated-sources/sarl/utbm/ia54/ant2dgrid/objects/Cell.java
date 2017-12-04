package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.agents.Ant;
import utbm.ia54.ant2dgrid.objects.Vector2D;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Cell {
  private Vector2D vector;
  
  private final ArrayList<Ant> AntList;
  
  public Cell() {
    Vector2D _vector2D = new Vector2D();
    this.vector = _vector2D;
    ArrayList<Ant> _arrayList = new ArrayList<Ant>();
    this.AntList = _arrayList;
  }
  
  public Cell(final Vector2D v, final ArrayList<Ant> antList) {
    Vector2D _vector2D = new Vector2D(v);
    this.vector = _vector2D;
    this.AntList = antList;
  }
  
  public Cell(final double x, final double y, final ArrayList<Ant> antList) {
    Vector2D _vector2D = new Vector2D(x, y);
    this.vector = _vector2D;
    this.AntList = antList;
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
  
  public boolean addAnt(final Ant ant) {
    boolean _xsynchronizedexpression = false;
    synchronized (this.AntList) {
      _xsynchronizedexpression = this.AntList.add(ant);
    }
    return _xsynchronizedexpression;
  }
  
  public boolean removeAnt(final Ant ant) {
    boolean _xsynchronizedexpression = false;
    synchronized (this.AntList) {
      _xsynchronizedexpression = this.AntList.remove(ant);
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public List<Ant> getAntList() {
    List<Ant> _xsynchronizedexpression = null;
    synchronized (this.AntList) {
      _xsynchronizedexpression = Collections.<Ant>unmodifiableList(this.AntList);
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public int getNumberAnt() {
    synchronized (this.AntList) {
      return this.AntList.size();
    }
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
