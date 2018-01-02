package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import utbm.ia54.ant2dgrid.Enum.Direction;

/**
 * Capacity to move for an Ant
 */
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface MotionCapacity extends Capacity {
  public abstract void move(final Direction direction);
  
  public abstract void randomMove();
  
  public static class ContextAwareCapacityWrapper<C extends MotionCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements MotionCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void move(final Direction direction) {
      try {
        ensureCallerInLocalThread();
        this.capacity.move(direction);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void randomMove() {
      try {
        ensureCallerInLocalThread();
        this.capacity.randomMove();
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
