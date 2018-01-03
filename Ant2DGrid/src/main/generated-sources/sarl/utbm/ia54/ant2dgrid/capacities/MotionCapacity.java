package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import java.util.List;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * Capacity to move for an Ant
 */
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface MotionCapacity extends Capacity {
  public abstract void move(final Vector2i newpos, final AntBody body);
  
  public abstract void randomMove(final List<Cell> listPerception, final AntBody body);
  
  public static class ContextAwareCapacityWrapper<C extends MotionCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements MotionCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void move(final Vector2i newpos, final AntBody body) {
      try {
        ensureCallerInLocalThread();
        this.capacity.move(newpos, body);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void randomMove(final List<Cell> listPerception, final AntBody body) {
      try {
        ensureCallerInLocalThread();
        this.capacity.randomMove(listPerception, body);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
