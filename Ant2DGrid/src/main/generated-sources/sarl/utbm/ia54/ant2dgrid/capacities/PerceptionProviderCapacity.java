package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import java.util.Map;
import java.util.UUID;
import utbm.ia54.ant2dgrid.events.Perception;

@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface PerceptionProviderCapacity extends Capacity {
  public abstract Map<UUID, Perception> compute();
  
  public abstract void emit(final Map<UUID, Perception> l);
  
  public static class ContextAwareCapacityWrapper<C extends PerceptionProviderCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements PerceptionProviderCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public Map<UUID, Perception> compute() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.compute();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void emit(final Map<UUID, Perception> l) {
      try {
        ensureCallerInLocalThread();
        this.capacity.emit(l);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
