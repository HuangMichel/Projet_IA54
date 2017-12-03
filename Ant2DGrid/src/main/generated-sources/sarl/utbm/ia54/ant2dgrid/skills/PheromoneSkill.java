package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import utbm.ia54.ant2dgrid.capacities.PheromoneCapacity;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class PheromoneSkill extends Skill implements PheromoneCapacity {
  public void followPheromone() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @SyntheticMember
  public PheromoneSkill() {
    super();
  }
  
  @SyntheticMember
  public PheromoneSkill(final Agent agent) {
    super(agent);
  }
}
