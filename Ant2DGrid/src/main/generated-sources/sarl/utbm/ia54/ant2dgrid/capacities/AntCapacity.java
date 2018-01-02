package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;

@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface AntCapacity extends Capacity {
  public abstract void pickUpFood();
  
  public abstract void putDownFood();
  
  public static class ContextAwareCapacityWrapper<C extends AntCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements AntCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void pickUpFood() {
      try {
        ensureCallerInLocalThread();
        this.capacity.pickUpFood();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void putDownFood() {
      try {
        ensureCallerInLocalThread();
        this.capacity.putDownFood();
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
