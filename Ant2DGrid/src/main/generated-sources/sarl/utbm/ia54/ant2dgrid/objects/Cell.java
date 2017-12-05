package utbm.ia54.ant2dgrid.objects;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Pure;

import com.google.common.base.Objects;

import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.agents.Ant;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Cell {
  /**
   * The vector position
   */
  private Vector2i vector;
  
  /**
   * A list of ants
   */
  private final ArrayList<Ant> AntList;
  
  /**
   * The cell state
   */
  private CellState state;
  
  public Cell() {
    Vector2i _vector2i = new Vector2i();
    this.vector = _vector2i;
    ArrayList<Ant> _arrayList = new ArrayList<Ant>();
    this.AntList = _arrayList;
    this.state = CellState.NORMAL;
  }
  
  public Cell(final int x, final int y) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    ArrayList<Ant> _arrayList = new ArrayList<Ant>();
    this.AntList = _arrayList;
    this.state = CellState.NORMAL;
  }
  
  public Cell(final int x, final int y, final CellState state) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    ArrayList<Ant> _arrayList = new ArrayList<Ant>();
    this.AntList = _arrayList;
    this.state = state;
  }
  
  public Cell(final Vector2i v, final ArrayList<Ant> antList, final CellState state) {
    Vector2i _vector2i = new Vector2i(v);
    this.vector = _vector2i;
    this.AntList = antList;
    this.state = state;
  }
  
  public Cell(final int x, final int y, final ArrayList<Ant> antList, final CellState state) {
    Vector2i _vector2i = new Vector2i(x, y);
    this.vector = _vector2i;
    this.AntList = antList;
    this.state = state;
  }
  
  @Pure
  public Vector2i getPosition() {
    return this.vector;
  }
  
  public void setPosition(final Vector2i v) {
    this.vector = v;
  }
  
  public void setPosition(final int x, final int y) {
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
    int _xsynchronizedexpression = (int) 0;
    synchronized (this.AntList) {
      _xsynchronizedexpression = this.AntList.size();
    }
    return _xsynchronizedexpression;
  }
  
  @Pure
  public CellState getState() {
    return this.state;
  }
  
  public void setState(final CellState state) {
    this.state = state;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
	Cell other = (Cell) obj;
	return (Objects.equal(this.state, other.getState()) && Objects.equal(this.vector, other.getPosition()) && Objects.equal(this.AntList, other.getAntList()));
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
}
