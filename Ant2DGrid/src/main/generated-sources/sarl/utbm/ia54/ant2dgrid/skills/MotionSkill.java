package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import utbm.ia54.ant2dgrid.capacities.MotionCapacity;
import utbm.ia54.ant2dgrid.objects.Vector2i;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class MotionSkill extends Skill implements MotionCapacity {
  public void move(final Vector2i v) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
