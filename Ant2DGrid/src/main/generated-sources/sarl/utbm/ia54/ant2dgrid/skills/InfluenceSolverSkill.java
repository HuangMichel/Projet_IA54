package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import java.util.List;
import utbm.ia54.ant2dgrid.Enum.Direction;
import utbm.ia54.ant2dgrid.capacities.InfluenceSolverCapacity;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class InfluenceSolverSkill extends Skill implements InfluenceSolverCapacity {
  public List<Direction> solve() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @SyntheticMember
  public InfluenceSolverSkill() {
    super();
  }
  
  @SyntheticMember
  public InfluenceSolverSkill(final Agent agent) {
    super(agent);
  }
}
