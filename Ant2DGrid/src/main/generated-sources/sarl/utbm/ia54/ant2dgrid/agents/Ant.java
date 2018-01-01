package utbm.ia54.ant2dgrid.agents;

import com.google.common.base.Objects;
import io.sarl.core.Destroy;
import io.sarl.core.Initialize;
import io.sarl.core.Logging;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.PerceptGuardEvaluator;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.DynamicSkillProvider;
import io.sarl.lang.core.Skill;
import io.sarl.lang.util.ClearableReference;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.events.Perception;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;
import utbm.ia54.ant2dgrid.skills.MotionSkill;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(17)
@SuppressWarnings("all")
public class Ant extends Agent {
  /**
   * ID of the environment agent
   */
  private UUID idEnv;
  
  /**
   * ID himself
   */
  private int selfID;
  
  /**
   * Position
   */
  private Vector2i position;
  
  /**
   * Current state of the Ant
   */
  private AntState currentState;
  
  /**
   * The capacity of the Ant to pick up food
   */
  private float capacity;
  
  @SyntheticMember
  private void $behaviorUnit$Initialize$0(final Initialize occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    UUID _iD = this.getID();
    String _plus = ("Ant " + _iD);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.setLoggingName(_plus);
    this.idEnv = occurrence.spawner;
    this.currentState = AntState.SEARCH_FOOD;
    Object _get = occurrence.parameters[0];
    this.selfID = (((Integer) _get)).intValue();
    Object _get_1 = occurrence.parameters[1];
    this.position = ((Vector2i) _get_1);
    this.capacity = 2f;
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1.info((("The agent Ant " + Integer.valueOf(this.selfID)) + " was started."));
    MotionSkill _motionSkill = new MotionSkill();
    this.<MotionSkill>setSkill(_motionSkill);
  }
  
  @SyntheticMember
  private void $behaviorUnit$Destroy$1(final Destroy occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info((("The agent Ant " + Integer.valueOf(this.selfID)) + " was stopped."));
  }
  
  @Pure
  protected Vector2i getPosition() {
    return this.position;
  }
  
  protected void setPosition(final Vector2i v) {
    this.position = v;
  }
  
  @Pure
  protected int getSelfID() {
    return this.selfID;
  }
  
  @Pure
  protected AntState getState() {
    return this.currentState;
  }
  
  protected void setState(final AntState state) {
    this.currentState = state;
  }
  
  @SyntheticMember
  private void $behaviorUnit$Perception$2(final Perception occurrence) {
    List<Cell> listPerception = occurrence.list;
    boolean _isEmpty = listPerception.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Vector2i tempVector = null;
      float pheromoneFood = 0f;
      float pheromoneHome = 0f;
      boolean _equals = Objects.equal(this.currentState, AntState.SEARCH_FOOD);
      if (_equals) {
        for (int i = 0; (i < ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length); i++) {
          float _pheromoneFoodIntensity = listPerception.get(i).getPheromoneFoodIntensity();
          boolean _lessThan = (pheromoneFood < _pheromoneFoodIntensity);
          if (_lessThan) {
            pheromoneFood = listPerception.get(i).getPheromoneFoodIntensity();
            tempVector = listPerception.get(i).getPosition();
          }
        }
      } else {
        boolean _equals_1 = Objects.equal(this.currentState, AntState.RETURN_HOME);
        if (_equals_1) {
          for (int i = 0; (i < ((Object[])Conversions.unwrapArray(listPerception, Object.class)).length); i++) {
            float _pheromoneHomeIntensity = listPerception.get(i).getPheromoneHomeIntensity();
            boolean _lessThan = (pheromoneHome < _pheromoneHomeIntensity);
            if (_lessThan) {
              pheromoneHome = listPerception.get(i).getPheromoneHomeIntensity();
              tempVector = listPerception.get(i).getPosition();
            }
          }
        }
      }
    }
  }
  
  @Extension
  @ImportedCapacityFeature(Logging.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_LOGGING;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(Logging.class, ($0$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || $0$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_LOGGING = $0$getSkill(Logging.class)) : $0$CAPACITY_USE$IO_SARL_CORE_LOGGING)", imported = Logging.class)
  private Logging $CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = $getSkill(Logging.class);
    }
    return $castSkill(Logging.class, this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Initialize(final Initialize occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Initialize$0(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Destroy(final Destroy occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Destroy$1(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Perception(final Perception occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Perception$2(occurrence));
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Ant other = (Ant) obj;
    if (!java.util.Objects.equals(this.idEnv, other.idEnv)) {
      return false;
    }
    if (other.selfID != this.selfID)
      return false;
    if (Float.floatToIntBits(other.capacity) != Float.floatToIntBits(this.capacity))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + java.util.Objects.hashCode(this.idEnv);
    result = prime * result + this.selfID;
    result = prime * result + Float.floatToIntBits(this.capacity);
    return result;
  }
  
  @SyntheticMember
  public Ant(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  @Deprecated
  public Ant(final BuiltinCapacitiesProvider provider, final UUID parentID, final UUID agentID) {
    super(provider, parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  public Ant(final UUID parentID, final UUID agentID, final DynamicSkillProvider skillProvider) {
    super(parentID, agentID, skillProvider);
  }
}
