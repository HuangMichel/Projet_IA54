package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import utbm.ia54.ant2dgrid.capacities.AntCapacity;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class AntManagerSkill extends Skill implements AntCapacity {
  public void pickUpFood() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void putDownFood() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @SyntheticMember
  public AntManagerSkill() {
    super();
  }
  
  @SyntheticMember
  public AntManagerSkill(final Agent agent) {
    super(agent);
  }
}
