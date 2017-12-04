package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;

@FunctionalInterface
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface PheromoneCapacity extends Capacity {
  public abstract void followPheromone();
  
  public static class ContextAwareCapacityWrapper<C extends PheromoneCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements PheromoneCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void followPheromone() {
      try {
        ensureCallerInLocalThread();
        this.capacity.followPheromone();
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
