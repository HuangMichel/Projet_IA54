package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;

@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface PerceptionCapacity extends Capacity {
  public abstract void sendPerception();
  
  public abstract void receivePerception();
  
  public static class ContextAwareCapacityWrapper<C extends PerceptionCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements PerceptionCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public void sendPerception() {
      try {
        ensureCallerInLocalThread();
        this.capacity.sendPerception();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void receivePerception() {
      try {
        ensureCallerInLocalThread();
        this.capacity.receivePerception();
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
