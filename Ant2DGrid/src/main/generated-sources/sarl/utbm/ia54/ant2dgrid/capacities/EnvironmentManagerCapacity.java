package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * Capacity to manage the environment
 */
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface EnvironmentManagerCapacity extends Capacity {
  public abstract int getWidth();
  
  public abstract int getHeight();
  
  public abstract List<Cell> getGrid();
  
  public abstract void createAnt(final Vector2i position, final UUID id, final AntBody body);
  
  public abstract int getAntQuantity();
  
  public abstract Cell getHomeCell();
  
  public abstract Cell getFoodCell();
  
  public abstract Cell getCell(final int i);
  
  public abstract void setAddress(final UUID id, final Address address);
  
  public abstract void sendPerception(final UUID sender, final UUID id, final List<Cell> list);
  
  public abstract List<Cell> getPerception(final UUID id);
  
  public abstract Map<UUID, Address> getAntAddresses();
  
  public abstract Address getAddress(final UUID id);
  
  public abstract void removeAntCell(final Vector2i position, final UUID id, final AntBody body);
  
  public static class ContextAwareCapacityWrapper<C extends EnvironmentManagerCapacity> extends Capacity.ContextAwareCapacityWrapper<C> implements EnvironmentManagerCapacity {
    public ContextAwareCapacityWrapper(final C capacity, final AgentTrait caller) {
      super(capacity, caller);
    }
    
    public int getWidth() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getWidth();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public int getHeight() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getHeight();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public List<Cell> getGrid() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getGrid();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void createAnt(final Vector2i position, final UUID id, final AntBody body) {
      try {
        ensureCallerInLocalThread();
        this.capacity.createAnt(position, id, body);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public int getAntQuantity() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getAntQuantity();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public Cell getHomeCell() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getHomeCell();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public Cell getFoodCell() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getFoodCell();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public Cell getCell(final int i) {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getCell(i);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void setAddress(final UUID id, final Address address) {
      try {
        ensureCallerInLocalThread();
        this.capacity.setAddress(id, address);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void sendPerception(final UUID sender, final UUID id, final List<Cell> list) {
      try {
        ensureCallerInLocalThread();
        this.capacity.sendPerception(sender, id, list);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public List<Cell> getPerception(final UUID id) {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getPerception(id);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public Map<UUID, Address> getAntAddresses() {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getAntAddresses();
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public Address getAddress(final UUID id) {
      try {
        ensureCallerInLocalThread();
        return this.capacity.getAddress(id);
      } finally {
        resetCallerInLocalThread();
      }
    }
    
    public void removeAntCell(final Vector2i position, final UUID id, final AntBody body) {
      try {
        ensureCallerInLocalThread();
        this.capacity.removeAntCell(position, id, body);
      } finally {
        resetCallerInLocalThread();
      }
    }
  }
}
