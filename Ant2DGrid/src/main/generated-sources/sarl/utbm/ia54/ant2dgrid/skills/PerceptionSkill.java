package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import java.util.Map;
import java.util.UUID;
import utbm.ia54.ant2dgrid.capacities.PerceptionProviderCapacity;
import utbm.ia54.ant2dgrid.events.Perception;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class PerceptionSkill extends Skill implements PerceptionProviderCapacity {
  public Map<UUID, Perception> compute() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void emit(final Map<UUID, Perception> l) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @SyntheticMember
  public PerceptionSkill() {
    super();
  }
  
  @SyntheticMember
  public PerceptionSkill(final Agent agent) {
    super(agent);
  }
}
