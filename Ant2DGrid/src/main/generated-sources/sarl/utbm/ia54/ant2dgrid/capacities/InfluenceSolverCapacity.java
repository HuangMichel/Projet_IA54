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
public interface InfluenceSolverCapacity extends Capacity {
  public abstract List<Direction> solve();
  
  public static class ContextAwareCapacityWrapper<C extends InfluenceSolverCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements InfluenceSolverCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public List<Direction> solve() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.solve();
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
