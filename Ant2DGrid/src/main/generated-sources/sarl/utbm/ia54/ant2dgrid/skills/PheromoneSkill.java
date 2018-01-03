package utbm.ia54.ant2dgrid.skills;

import com.google.common.base.Objects;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.capacities.PheromoneCapacity;
import utbm.ia54.ant2dgrid.objects.Cell;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class PheromoneSkill extends Skill implements PheromoneCapacity {
  public Cell followPheromone(final List<Cell> listPerception, final AntState state) {
    Cell _xblockexpression = null;
    {
<<<<<<< HEAD
      Cell tempCell = null;
      boolean bool = false;
=======
      Cell tempCell = new Cell();
>>>>>>> 0353e32b6a4fb200237fd621a6a895365921459a
      float pheromoneFood = 0f;
      float pheromoneHome = 0f;
      boolean _equals = Objects.equal(state, AntState.SEARCH_FOOD);
      if (_equals) {
        for (int i = 0; (i < ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length); i++) {
          float _pheromoneFoodIntensity = listPerception.get(i).getPheromoneFoodIntensity();
          boolean _lessThan = (pheromoneFood < _pheromoneFoodIntensity);
          if (_lessThan) {
            pheromoneFood = listPerception.get(i).getPheromoneFoodIntensity();
            tempCell = listPerception.get(i);
            bool = true;
          }
        }
      } else {
        boolean _equals_1 = Objects.equal(state, AntState.RETURN_HOME);
        if (_equals_1) {
          for (int i = 0; (i < ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length); i++) {
            float _pheromoneHomeIntensity = listPerception.get(i).getPheromoneHomeIntensity();
            boolean _lessThan = (pheromoneHome < _pheromoneHomeIntensity);
            if (_lessThan) {
              pheromoneHome = listPerception.get(i).getPheromoneHomeIntensity();
              tempCell = listPerception.get(i);
              bool = true;
            }
          }
        }
      }
<<<<<<< HEAD
      if ((Boolean.valueOf(bool) == Boolean.valueOf(false))) {
        Cell _cell = new Cell((-1), (-1));
        tempCell = _cell;
      }
=======
>>>>>>> 0353e32b6a4fb200237fd621a6a895365921459a
      _xblockexpression = tempCell;
    }
    return _xblockexpression;
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
