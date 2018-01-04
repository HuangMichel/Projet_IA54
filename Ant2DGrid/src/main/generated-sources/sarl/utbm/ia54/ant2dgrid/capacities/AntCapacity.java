package utbm.ia54.ant2dgrid.capacities;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.AgentTrait;
import io.sarl.lang.core.Capacity;
import java.util.List;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * Capacity to manage an ant
 */
@SarlSpecification("0.6")
@SarlElementType(18)
@SuppressWarnings("all")
public interface AntCapacity extends Capacity {
  /**
   * Pick the food
   * @param body the AntBody
   */
  public abstract void pickUpFood(final AntBody body);
  
  /**
   * Put the food
   * @param body the AntBody
   */
  public abstract void putDownFood(final AntBody body);
  
  /**
   * Sets the position before
   * @param pos the position
   */
  public abstract void setPositionBefore(final Vector2i pos);
  
  /**
   * Moves to a new position
   * @param newpos The new position
   * @param body an AntBody
   */
  public abstract void move(final Vector2i newpos, final AntBody body);
  
  /**
   * Moves random to a new position
   * @param listPerception the perception of the list of cell
   * @param body an AntBody
   */
  public abstract void randomMove(final List<Cell> listPerception, final AntBody body);
  
  /**
   * Stays to the same position
   * @param body an AntBody
   */
  public abstract void stay(final AntBody body);
  
  /**
   * Select the best cell to move
   * @param listPerception the perception of the list of cell
   * @return tempCell the cell to move
   */
  public abstract Cell followPheromone(final List<Cell> list, final AntState state);
  
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
    
    public void setPositionBefore(final Vector2i pos) {
      try {
        ensureCallerInLocalThread();
        this.capacity.setPositionBefore(pos);
      } finally {
        resetCallerInLocalThread();
      }
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
    
    public void stay(final AntBody body) {
      try {
        ensureCallerInLocalThread();
        this.capacity.stay(body);
      } finally {
        resetCallerInLocalThread();
      }
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
