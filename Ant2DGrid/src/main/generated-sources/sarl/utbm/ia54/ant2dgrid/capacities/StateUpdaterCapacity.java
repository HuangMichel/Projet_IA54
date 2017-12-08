package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import java.util.List;
import utbm.ia54.ant2dgrid.Enum.Direction;

@FunctionalInterface
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface StateUpdaterCapacity extends Capacity {
  public abstract void update(final List<Direction> l);
  
  public static class ContextAwareCapacityWrapper<C extends StateUpdaterCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements StateUpdaterCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void update(final List<Direction> l) {
      try {
        ensureCallerInLocalThread();
        this.capacity.update(l);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
