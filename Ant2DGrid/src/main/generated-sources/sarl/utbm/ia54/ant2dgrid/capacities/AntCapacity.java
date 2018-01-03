package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import utbm.ia54.ant2dgrid.objects.AntBody;

@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface AntCapacity extends Capacity {
  public abstract void pickUpFood(final AntBody body);
  
  public abstract void putDownFood(final AntBody body);
  
  public static class ContextAwareCapacityWrapper<C extends AntCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements AntCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void pickUpFood(final AntBody body) {
      try {
        ensureCallerInLocalThread();
        this.capacity.pickUpFood(body);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void putDownFood(final AntBody body) {
      try {
        ensureCallerInLocalThread();
        this.capacity.putDownFood(body);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
