package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * @author Michel
 */
@FunctionalInterface
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface MotionCapacity extends Capacity {
  public abstract void move(final Vector2i v);
  
  public static class ContextAwareCapacityWrapper<C extends MotionCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements MotionCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void move(final Vector2i v) {
      try {
        ensureCallerInLocalThread();
        this.capacity.move(v);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
