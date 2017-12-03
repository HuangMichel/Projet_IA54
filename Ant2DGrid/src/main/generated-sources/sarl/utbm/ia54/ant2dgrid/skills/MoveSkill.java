package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import utbm.ia54.ant2dgrid.capacities.MoveCapacity;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class MoveSkill extends Skill implements MoveCapacity {
  public void move() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void moveUp() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void moveDown() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void moveLeft() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void moveRight() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @SyntheticMember
  public MoveSkill() {
    super();
  }
  
  @SyntheticMember
  public MoveSkill(final Agent agent) {
    super(agent);
  }
}
