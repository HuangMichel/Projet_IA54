package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.capacities.MoveCapacity;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class MoveSkill extends Skill implements MoveCapacity {
  public void move(final AntState move) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void moveUp(final AntState up) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void moveDown(final AntState down) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void moveLeft(final AntState left) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void moveRight(final AntState right) {
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
