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
  public void move(final Vector2i newpos, final AntBody body) {
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    Vector2i _position = body.getPosition();
    Influence _influence = new Influence(_position, newpos, body);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
  }
  
  public void randomMove(final List<Cell> listPerception, final AntBody body) {
    ThreadLocalRandom _current = ThreadLocalRandom.current();
    int _length = ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length;
    int _plus = (_length + 1);
    final int randomNum = _current.nextInt(0, _plus);
    Vector2i newPos = null;
    CellState _state = listPerception.get(randomNum).getState();
    boolean _tripleEquals = (_state == CellState.NORMAL);
    if (_tripleEquals) {
      newPos = listPerception.get(randomNum).getPosition();
      DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
      Vector2i _position = body.getPosition();
      Influence _influence = new Influence(_position, newPos, body);
      _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
    } else {
      this.randomMove(listPerception, body);
    }
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
  
  @SyntheticMember
  public MotionSkill() {
    super();
  }
  
  @SyntheticMember
  public MotionSkill(final Agent agent) {
    super(agent);
  }
}
