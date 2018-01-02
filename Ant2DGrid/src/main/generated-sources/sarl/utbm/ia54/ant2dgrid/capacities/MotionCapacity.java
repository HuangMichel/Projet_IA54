package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import java.util.UUID;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * Capacity to move for an Ant
 */
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface MotionCapacity extends Capacity {
  public abstract void move(final Vector2i v, final Vector2i newpos, final AntBody body, final UUID id);
  
  public abstract void randomMove(final Vector2i v, final AntBody body, final UUID id);
  
  public static class ContextAwareCapacityWrapper<C extends MotionCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements MotionCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void move(final Vector2i v, final Vector2i newpos, final AntBody body, final UUID id) {
      try {
        ensureCallerInLocalThread();
        this.capacity.move(v, newpos, body, id);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void randomMove(final Vector2i v, final AntBody body, final UUID id) {
      try {
        ensureCallerInLocalThread();
        this.capacity.randomMove(v, body, id);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
