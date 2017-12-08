package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import java.util.List;
import utbm.ia54.ant2dgrid.Enum.Direction;
import utbm.ia54.ant2dgrid.capacities.StateUpdaterCapacity;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class StateUpdaterSkill extends Skill implements StateUpdaterCapacity {
  public void update(final List<Direction> l) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @SyntheticMember
  public StateUpdaterSkill() {
    super();
  }
  
  @SyntheticMember
  public StateUpdaterSkill(final Agent agent) {
    super(agent);
  }
}
