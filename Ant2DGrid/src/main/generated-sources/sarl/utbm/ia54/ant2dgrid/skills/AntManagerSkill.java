package utbm.ia54.ant2dgrid.skills;

import io.sarl.core.DefaultContextInteractions;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import io.sarl.lang.util.ClearableReference;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.capacities.AntCapacity;
import utbm.ia54.ant2dgrid.events.Influence;
import utbm.ia54.ant2dgrid.events.PickFood;
import utbm.ia54.ant2dgrid.events.PutFood;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * A default skill to manage an ant
 */
@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class AntManagerSkill extends Skill implements AntCapacity {
  /**
   * The position before
   */
  private Vector2i positionBefore;
  
  /**
   * Pick the food
   * @param body the AntBody
   */
  public void pickUpFood(final AntBody body) {
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    PickFood _pickFood = new PickFood(body);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_pickFood);
  }
  
  /**
   * Put the food
   * @param body the AntBody
   */
  public void putDownFood(final AntBody body) {
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    PutFood _putFood = new PutFood(body);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_putFood);
  }
  
  /**
   * Gets has food cell of the list
   * @param list the perception of list of cell
   * return the place of the cell in the list
   */
  private int hasFood(final List<Cell> list) {
    int _xblockexpression = (int) 0;
    {
      int place = (-1);
      int iterator = 0;
      for (final Cell cell : list) {
        {
          CellState _state = cell.getState();
          boolean _tripleEquals = (_state == CellState.FOOD);
          if (_tripleEquals) {
            place = iterator;
          }
          iterator++;
        }
      }
      _xblockexpression = place;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets has home cell of the list
   * @param list the perception of list of cell
   * @return the place of the cell in the list
   */
  private int hasHome(final List<Cell> list) {
    int _xblockexpression = (int) 0;
    {
      int place = (-1);
      int iterator = 0;
      for (final Cell cell : list) {
        {
          CellState _state = cell.getState();
          boolean _tripleEquals = (_state == CellState.HOME);
          if (_tripleEquals) {
            place = iterator;
          }
          iterator++;
        }
      }
      _xblockexpression = place;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets the number of cell has pheromone home on the cell
   * @param list the perception of list of cell
   * return i the number of cell has pheromone home on the cell
   */
  private int countHasHomePherommoneCell(final List<Cell> list) {
    int _xblockexpression = (int) 0;
    {
      int i = 0;
      for (final Cell cell : list) {
        if (((((cell.getPheromoneFood().getIntensity() >= 0.01f) && (cell.getState() == CellState.NORMAL)) || (cell.getState() == CellState.HOME)) || (cell.getState() == CellState.FOOD))) {
          i++;
        }
      }
      _xblockexpression = i;
    }
    return _xblockexpression;
  }
  
  /**
   * Gets the number of cell has normal, home and food state
   * @param list the perception of list of cell
   * return i the number of cell has normal state
   */
  private int countNormalState(final List<Cell> list) {
    int _xblockexpression = (int) 0;
    {
      int i = 0;
      for (final Cell cell : list) {
        if ((((cell.getState() == CellState.NORMAL) || (cell.getState() == CellState.FOOD)) || (cell.getState() == CellState.HOME))) {
          i++;
        }
      }
      _xblockexpression = i;
    }
    return _xblockexpression;
  }
  
  /**
   * Moves to a new position
   * @param newpos The new position
   * @param body an AntBody
   */
  public void move(final Vector2i newpos, final AntBody body) {
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    Influence _influence = new Influence(newpos, body);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
  }
  
  /**
   * Moves random to a new position
   * @param listPerception the perception of the list of cell
   * @param body an AntBody
   */
  public void randomMove(final List<Cell> listPerception, final AntBody body) {
    final int randomNum = ThreadLocalRandom.current().nextInt(0, ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length);
    Vector2i newPos = null;
    Cell cell = listPerception.get(randomNum);
    int numberPheromoneCell = this.countHasHomePherommoneCell(listPerception);
    int numberNormalState = this.countNormalState(listPerception);
    if ((numberNormalState == 1)) {
      CellState _state = cell.getState();
      boolean _tripleEquals = (_state == CellState.WALL);
      if (_tripleEquals) {
        listPerception.remove(randomNum);
        this.randomMove(listPerception, body);
      } else {
        newPos = cell.getPosition();
        DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
        Influence _influence = new Influence(newPos, body);
        _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
        this.setPositionBefore(newPos);
      }
    } else {
      if (((this.hasFood(listPerception) != (-1)) && (body.getState() == AntState.SEARCH_FOOD))) {
        newPos = listPerception.get(this.hasFood(listPerception)).getPosition();
        DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_1 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
        Influence _influence_1 = new Influence(newPos, body);
        _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_1.emit(_influence_1);
        this.setPositionBefore(newPos);
      } else {
        if (((this.hasHome(listPerception) != (-1)) && (body.getState() == AntState.RETURN_HOME))) {
          newPos = listPerception.get(this.hasHome(listPerception)).getPosition();
          DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_2 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
          Influence _influence_2 = new Influence(newPos, body);
          _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_2.emit(_influence_2);
          this.setPositionBefore(newPos);
        } else {
          CellState _state_1 = cell.getState();
          if (_state_1 != null) {
            switch (_state_1) {
              case NORMAL:
                if (((numberPheromoneCell == 1) && (Boolean.valueOf(this.isEquals(cell.getPosition())) == Boolean.valueOf(false)))) {
                  newPos = cell.getPosition();
                  DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_3 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
                  Influence _influence_3 = new Influence(newPos, body);
                  _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_3.emit(_influence_3);
                  this.setPositionBefore(newPos);
                } else {
                  if (((numberNormalState - numberPheromoneCell) < numberNormalState)) {
                    if ((((0.1f > cell.getPheromoneHomeIntensity()) && (Boolean.valueOf(this.isEquals(cell.getPosition())) == Boolean.valueOf(false))) || 
                      (Boolean.valueOf(this.isEquals(cell.getPosition())) == Boolean.valueOf(false)))) {
                      newPos = cell.getPosition();
                      DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_4 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
                      Influence _influence_4 = new Influence(newPos, body);
                      _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_4.emit(_influence_4);
                      this.setPositionBefore(newPos);
                    } else {
                      listPerception.remove(randomNum);
                      this.randomMove(listPerception, body);
                    }
                  } else {
                    boolean _isEquals = this.isEquals(cell.getPosition());
                    boolean _tripleEquals_1 = (Boolean.valueOf(_isEquals) == Boolean.valueOf(false));
                    if (_tripleEquals_1) {
                      newPos = cell.getPosition();
                      DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_5 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
                      Influence _influence_5 = new Influence(newPos, body);
                      _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_5.emit(_influence_5);
                      this.setPositionBefore(newPos);
                    } else {
                      listPerception.remove(randomNum);
                      this.randomMove(listPerception, body);
                    }
                  }
                }
                break;
              case WALL:
                this.randomMove(listPerception, body);
                break;
              case HOME:
                if ((((body.getState() == AntState.RETURN_HOME) || 
                  (Boolean.valueOf(this.isEquals(cell.getPosition())) == Boolean.valueOf(false))) || 
                  (body.getState() == AntState.SEARCH_FOOD))) {
                  newPos = cell.getPosition();
                  DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_6 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
                  Influence _influence_6 = new Influence(newPos, body);
                  _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_6.emit(_influence_6);
                  this.setPositionBefore(newPos);
                } else {
                  listPerception.remove(randomNum);
                  this.randomMove(listPerception, body);
                }
                break;
              case FOOD:
                if ((((body.getState() == AntState.SEARCH_FOOD) || 
                  (Boolean.valueOf(this.isEquals(cell.getPosition())) == Boolean.valueOf(false))) || 
                  (body.getState() == AntState.RETURN_HOME))) {
                  newPos = cell.getPosition();
                  DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_7 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
                  Influence _influence_7 = new Influence(newPos, body);
                  _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_7.emit(_influence_7);
                  this.setPositionBefore(newPos);
                } else {
                  listPerception.remove(randomNum);
                  this.randomMove(listPerception, body);
                }
                break;
              default:
                break;
            }
          }
        }
      }
    }
  }
  
  /**
   * Stays to the same position
   * @param body an AntBody
   */
  public void stay(final AntBody body) {
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    Vector2i _position = body.getPosition();
    Influence _influence = new Influence(_position, body);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
  }
  
  /**
   * Sets the position before
   * @param pos the position
   */
  public void setPositionBefore(final Vector2i pos) {
    this.positionBefore = pos;
  }
  
  /**
   * Gets if is equals of two position
   * @param pos the posistion
   * @return true, if equals
   */
  private boolean isEquals(final Vector2i pos) {
    return this.positionBefore.equals(pos);
  }
  
  /**
   * Select the best cell to move
   * @param listPerception the perception of the list of cell
   * @return tempCell the cell to move
   */
  public Cell followPheromone(final List<Cell> listPerception, final AntState state) {
    Cell _xblockexpression = null;
    {
      Cell tempCell = null;
      Cell foodCell = null;
      Cell homeCell = null;
      boolean bool = false;
      boolean food = false;
      boolean home = false;
      float pheromoneFood = 0f;
      float pheromoneHome = 0f;
      if (state != null) {
        switch (state) {
          case SEARCH_FOOD:
            for (int i = 0; (i < ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length); i++) {
              if ((Boolean.valueOf(food) == Boolean.valueOf(false))) {
                CellState _state = listPerception.get(i).getState();
                boolean _tripleEquals = (_state == CellState.FOOD);
                if (_tripleEquals) {
                  foodCell = listPerception.get(i);
                  tempCell = foodCell;
                  food = true;
                } else {
                  if (((pheromoneFood < listPerception.get(i).getPheromoneFoodIntensity()) && 
                    (Boolean.valueOf(this.isEquals(listPerception.get(i).getPosition())) == Boolean.valueOf(false)))) {
                    pheromoneFood = listPerception.get(i).getPheromoneFoodIntensity();
                    tempCell = listPerception.get(i);
                    bool = true;
                  }
                }
              }
            }
            break;
          case RETURN_HOME:
            for (int i = 0; (i < ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length); i++) {
              if ((Boolean.valueOf(home) == Boolean.valueOf(false))) {
                CellState _state = listPerception.get(i).getState();
                boolean _tripleEquals = (_state == CellState.HOME);
                if (_tripleEquals) {
                  homeCell = listPerception.get(i);
                  tempCell = homeCell;
                  home = true;
                } else {
                  if (((pheromoneHome < listPerception.get(i).getPheromoneHomeIntensity()) && 
                    (Boolean.valueOf(this.isEquals(listPerception.get(i).getPosition())) == Boolean.valueOf(false)))) {
                    pheromoneHome = listPerception.get(i).getPheromoneHomeIntensity();
                    tempCell = listPerception.get(i);
                    bool = true;
                  }
                }
              }
            }
            break;
          default:
            break;
        }
      }
      if ((Boolean.valueOf(bool) == Boolean.valueOf(false))) {
        Cell _cell = new Cell((-1), (-1));
        tempCell = _cell;
      } else {
        this.setPositionBefore(tempCell.getPosition());
      }
      _xblockexpression = tempCell;
    }
    return _xblockexpression;
  }
  
  @Extension
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS;
  
  @SyntheticMember
  @Inline(value = "$castSkill(DefaultContextInteractions.class, ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $0$getSkill(DefaultContextInteractions.class)) : $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS)", imported = DefaultContextInteractions.class)
  private DefaultContextInteractions $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $getSkill(DefaultContextInteractions.class);
    }
    return $castSkill(DefaultContextInteractions.class, this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
  }
  
  @Override
  @SyntheticMember
  public boolean equals(final Object obj) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid implemented type: \'utbm.ia54.ant2dgrid.capacities.AntCapacity\'. Only subtypes of \'io.sarl.lang.core.Capacity\' are allowed for \'AntManagerSkill\'."
      + "\nInvalid implemented type: \'utbm.ia54.ant2dgrid.capacities.AntCapacity\'. Only subtypes of \'io.sarl.lang.core.Capacity\' are allowed for \'AntManagerSkill\'."
      + "\nMissing implemented type \'io.sarl.lang.core.Capacity\' for \'AntManagerSkill\'."
      + "\nMissing implemented type \'io.sarl.lang.core.Capacity\' for \'AntManagerSkill\'.");
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid implemented type: \'utbm.ia54.ant2dgrid.capacities.AntCapacity\'. Only subtypes of \'io.sarl.lang.core.Capacity\' are allowed for \'AntManagerSkill\'."
      + "\nMissing implemented type \'io.sarl.lang.core.Capacity\' for \'AntManagerSkill\'.");
  }
  
  @SyntheticMember
  public AntManagerSkill() {
    super();
  }
  
  @SyntheticMember
  public AntManagerSkill(final Agent agent) {
    super(agent);
  }
}
