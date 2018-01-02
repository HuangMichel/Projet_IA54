package utbm.ia54.ant2dgrid.skills;

import io.sarl.core.DefaultContextInteractions;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import io.sarl.lang.util.ClearableReference;
import java.util.concurrent.ThreadLocalRandom;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.capacities.MotionCapacity;
import utbm.ia54.ant2dgrid.events.Influence;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class MotionSkill extends Skill implements MotionCapacity {
  public Vector2i move(final Vector2i newpos, final AntBody body) {
    Vector2i _xblockexpression = null;
    {
      DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
      Vector2i _position = body.getPosition();
      Influence _influence = new Influence(_position, newpos, body);
      _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
      newpos.plus(body.getPosition());
      _xblockexpression = newpos;
    }
    return _xblockexpression;
  }
  
  public Vector2i randomMove(final Vector2i v, final AntBody body) {
    Vector2i _xblockexpression = null;
    {
      final int randomNum = ThreadLocalRandom.current().nextInt(0, (3 + 1));
      Vector2i newPos = null;
      switch (randomNum) {
        case 0:
          Vector2i _vector2i = new Vector2i(0, 1);
          newPos = _vector2i;
          break;
        case 1:
          Vector2i _vector2i_1 = new Vector2i((-1), 0);
          newPos = _vector2i_1;
          break;
        case 2:
          Vector2i _vector2i_2 = new Vector2i(0, (-1));
          newPos = _vector2i_2;
          break;
        case 3:
          Vector2i _vector2i_3 = new Vector2i(1, 0);
          newPos = _vector2i_3;
          break;
      }
      DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
      Influence _influence = new Influence(v, newPos, body);
      _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_influence);
      newPos.plus(body.getPosition());
      _xblockexpression = newPos;
    }
    return _xblockexpression;
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
