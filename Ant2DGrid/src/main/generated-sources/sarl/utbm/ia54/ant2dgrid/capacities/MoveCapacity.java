package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface MoveCapacity extends Capacity {
  public abstract void move();
  
  public abstract void moveUp();
  
  public abstract void moveDown();
  
  public abstract void moveLeft();
  
  public abstract void moveRight();
  
  public static class ContextAwareCapacityWrapper<C extends MoveCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements MoveCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void move() {
      try {
        ensureCallerInLocalThread();
        this.capacity.move();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void moveUp() {
      try {
        ensureCallerInLocalThread();
        this.capacity.moveUp();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void moveDown() {
      try {
        ensureCallerInLocalThread();
        this.capacity.moveDown();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void moveLeft() {
      try {
        ensureCallerInLocalThread();
        this.capacity.moveLeft();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void moveRight() {
      try {
        ensureCallerInLocalThread();
        this.capacity.moveRight();
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
