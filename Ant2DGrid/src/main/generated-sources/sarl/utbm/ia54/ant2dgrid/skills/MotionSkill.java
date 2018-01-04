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
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.capacities.MotionCapacity;
import utbm.ia54.ant2dgrid.events.Influence;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class MotionSkill extends Skill implements MotionCapacity {
  private Vector2i positionBefore;
  
  @Pure
  public boolean hasFood(final List<Cell> list) {
    boolean _xblockexpression = false;
    {
      boolean bool = false;
      for (final Cell cell : list) {
        CellState _state = cell.getState();
        boolean _tripleEquals = (_state == CellState.FOOD);
        if (_tripleEquals) {
          bool = true;
        }
      }
      _xblockexpression = bool;
    }
    return _xblockexpression;
  }
  
  @Pure
  public boolean hasHome(final List<Cell> list) {
    boolean _xblockexpression = false;
    {
      boolean bool = false;
      for (final Cell cell : list) {
        CellState _state = cell.getState();
        boolean _tripleEquals = (_state == CellState.HOME);
        if (_tripleEquals) {
          bool = true;
        }
      }
      _xblockexpression = bool;
    }
    return _xblockexpression;
  }
  
  public void move(final Vector2i newpos, final AntBody body) {
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    Influence _influence = new Influence(newpos, body);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
  }
  
  public void randomMove(final List<Cell> listPerception, final AntBody body) {
    final int randomNum = ThreadLocalRandom.current().nextInt(0, ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length);
    Vector2i newPos = null;
    Cell cell = listPerception.get(randomNum);
    CellState _state = cell.getState();
    if (_state != null) {
      switch (_state) {
        case NORMAL:
          boolean _isEquals = this.isEquals(cell.getPosition());
          boolean _tripleEquals = (Boolean.valueOf(_isEquals) == Boolean.valueOf(false));
          if (_tripleEquals) {
            newPos = cell.getPosition();
            DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
            Influence _influence = new Influence(newPos, body);
            _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
            this.setPositionBefore(newPos);
          } else {
            this.randomMove(listPerception, body);
          }
          break;
        case WALL:
          this.randomMove(listPerception, body);
          break;
        case HOME:
          if (((body.getState() == AntState.RETURN_HOME) || (Boolean.valueOf(this.isEquals(cell.getPosition())) == Boolean.valueOf(false)))) {
            newPos = cell.getPosition();
            DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_1 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
            Influence _influence_1 = new Influence(newPos, body);
            _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_1.emit(_influence_1);
            this.setPositionBefore(newPos);
          } else {
            this.randomMove(listPerception, body);
          }
          break;
        case FOOD:
          AntState _state_1 = body.getState();
          boolean _tripleEquals_1 = (_state_1 == AntState.SEARCH_FOOD);
          if (_tripleEquals_1) {
            newPos = cell.getPosition();
            DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_2 = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
            Influence _influence_2 = new Influence(newPos, body);
            _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER_2.emit(_influence_2);
            this.setPositionBefore(newPos);
          } else {
            AntState _state_2 = body.getState();
            boolean _tripleEquals_2 = (_state_2 == AntState.RETURN_HOME);
            if (_tripleEquals_2) {
              this.randomMove(listPerception, body);
            }
          }
          break;
        default:
          break;
      }
    }
  }
  
  public void stay(final AntBody body) {
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    Vector2i _position = body.getPosition();
    Influence _influence = new Influence(_position, body);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
  }
  
  public void setPositionBefore(final Vector2i pos) {
    this.positionBefore = pos;
  }
  
  @Pure
  private boolean isEquals(final Vector2i pos) {
    return this.positionBefore.equals(pos);
  }
  
  @Extension
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(DefaultContextInteractions.class, ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $0$getSkill(DefaultContextInteractions.class)) : $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS)", imported = DefaultContextInteractions.class)
  private DefaultContextInteractions $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $getSkill(DefaultContextInteractions.class);
    }
    return $castSkill(DefaultContextInteractions.class, this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
  
  @SyntheticMember
  public MotionSkill() {
    super();
  }
  
  @SyntheticMember
  public MotionSkill(final Agent agent) {
    super(agent);
  }
}
