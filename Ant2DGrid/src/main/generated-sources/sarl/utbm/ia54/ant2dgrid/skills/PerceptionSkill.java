package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import utbm.ia54.ant2dgrid.capacities.PerceptionCapacity;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class PerceptionSkill extends Skill implements PerceptionCapacity {
  public void sendPerception() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void receivePerception() {
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
