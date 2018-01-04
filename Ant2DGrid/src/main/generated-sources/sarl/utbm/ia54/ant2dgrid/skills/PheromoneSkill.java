package utbm.ia54.ant2dgrid.skills;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.capacities.PheromoneCapacity;
import utbm.ia54.ant2dgrid.objects.Cell;

@SarlSpecification("0.6")
@SarlElementType(20)
@SuppressWarnings("all")
public class PheromoneSkill extends Skill implements PheromoneCapacity {
  public Cell followPheromone(final List<Cell> listPerception, final AntState state) {
    Cell _xblockexpression = null;
    {
      Cell tempCell = null;
      Cell foodCell = null;
      Cell homeCell = null;
      boolean bool = false;
      boolean food = false;
      boolean home = false;
      float pheromoneFood = 0f;
      float pheromoneHome = 0f;
      if (state != null) {
        switch (state) {
          case SEARCH_FOOD:
            for (int i = 0; (i < ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length); i++) {
              if ((Boolean.valueOf(food) == Boolean.valueOf(false))) {
                CellState _state = listPerception.get(i).getState();
                boolean _tripleEquals = (_state == CellState.FOOD);
                if (_tripleEquals) {
                  foodCell = listPerception.get(i);
                  tempCell = foodCell;
                  food = true;
                } else {
                  float _pheromoneFoodIntensity = listPerception.get(i).getPheromoneFoodIntensity();
                  boolean _lessThan = (pheromoneFood < _pheromoneFoodIntensity);
                  if (_lessThan) {
                    pheromoneFood = listPerception.get(i).getPheromoneFoodIntensity();
                    tempCell = listPerception.get(i);
                    bool = true;
                  }
                }
              }
            }
            break;
          case RETURN_HOME:
            for (int i = 0; (i < ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length); i++) {
              if ((Boolean.valueOf(home) == Boolean.valueOf(false))) {
                CellState _state = listPerception.get(i).getState();
                boolean _tripleEquals = (_state == CellState.HOME);
                if (_tripleEquals) {
                  homeCell = listPerception.get(i);
                  tempCell = homeCell;
                  home = true;
                } else {
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
            break;
          default:
            break;
        }
      }
      if ((Boolean.valueOf(bool) == Boolean.valueOf(false))) {
        Cell _cell = new Cell((-1), (-1));
        tempCell = _cell;
      }
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
