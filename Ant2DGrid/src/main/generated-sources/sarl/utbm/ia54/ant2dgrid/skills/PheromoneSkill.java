package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import java.util.List;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.capacities.PheromoneCapacity;
import utbm.ia54.ant2dgrid.objects.Cell;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class PheromoneSkill extends Skill implements PheromoneCapacity {
  public Cell followPheromone(final List<Cell> list, final AntState state) {
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
