package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import java.util.List;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.objects.Cell;

@FunctionalInterface
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface PheromoneCapacity extends Capacity {
  public abstract Cell followPheromone(final List<Cell> list, final AntState state);
  
  public static class ContextAwareCapacityWrapper<C extends PheromoneCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements PheromoneCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public Cell followPheromone(final List<Cell> list, final AntState state) {
      try {
        ensureCallerInLocalThread();
        return this.capacity.followPheromone(list, state);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
