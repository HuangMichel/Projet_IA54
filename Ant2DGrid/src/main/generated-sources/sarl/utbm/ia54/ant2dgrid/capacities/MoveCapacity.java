package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import utbm.ia54.ant2dgrid.Enum.AntState;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface MoveCapacity extends Capacity {
  public abstract void move(final AntState move);
  
  public abstract void moveUp(final AntState up);
  
  public abstract void moveDown(final AntState down);
  
  public abstract void moveLeft(final AntState left);
  
  public abstract void moveRight(final AntState right);
  
  public static class ContextAwareCapacityWrapper<C extends MoveCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements MoveCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void move(final AntState move) {
      try {
        ensureCallerInLocalThread();
        this.capacity.move(move);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void moveUp(final AntState up) {
      try {
        ensureCallerInLocalThread();
        this.capacity.moveUp(up);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void moveDown(final AntState down) {
      try {
        ensureCallerInLocalThread();
        this.capacity.moveDown(down);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void moveLeft(final AntState left) {
      try {
        ensureCallerInLocalThread();
        this.capacity.moveLeft(left);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void moveRight(final AntState right) {
      try {
        ensureCallerInLocalThread();
        this.capacity.moveRight(right);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
