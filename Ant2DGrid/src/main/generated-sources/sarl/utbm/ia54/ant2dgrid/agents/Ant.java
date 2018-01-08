package utbm.ia54.ant2dgrid.agents;

import io.sarl.core.DefaultContextInteractions;
import io.sarl.core.Destroy;
import io.sarl.core.Initialize;
import io.sarl.core.Lifecycle;
import io.sarl.core.Logging;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.annotation.PerceptGuardEvaluator;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.DynamicSkillProvider;
import io.sarl.lang.core.Skill;
import io.sarl.lang.util.ClearableReference;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.capacities.AntCapacity;
import utbm.ia54.ant2dgrid.events.AcceptInfluence;
import utbm.ia54.ant2dgrid.events.AcceptPickFood;
import utbm.ia54.ant2dgrid.events.AcceptPutFood;
import utbm.ia54.ant2dgrid.events.AntInitialize;
import utbm.ia54.ant2dgrid.events.ChangeState;
import utbm.ia54.ant2dgrid.events.EndAgent;
import utbm.ia54.ant2dgrid.events.Perception;
import utbm.ia54.ant2dgrid.events.onFoodPlace;
import utbm.ia54.ant2dgrid.events.onNestPlace;
import utbm.ia54.ant2dgrid.gui.fx.AppExit;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;
import utbm.ia54.ant2dgrid.skills.AntManagerSkill;

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
  private int selfIDAnt;
  
  /**
   * The ant body
   */
  private AntBody body;
  
  @SyntheticMember
  private void $behaviorUnit$Initialize$0(final Initialize occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    UUID _iD = this.getID();
    String _plus = ("Ant " + _iD);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.setLoggingName(_plus);
    UUID _iD_1 = this.getID();
    Object _get = occurrence.parameters[1];
    AntBody _antBody = new AntBody(_iD_1, ((Vector2i) _get));
    this.body = _antBody;
    this.idEnv = occurrence.spawner;
    Object _get_1 = occurrence.parameters[0];
    this.selfIDAnt = (((Integer) _get_1)).intValue();
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    int _selfID = this.getSelfID();
    String _plus_1 = ("The agent Ant " + Integer.valueOf(_selfID));
    String _plus_2 = (_plus_1 + " was started.");
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1.info(_plus_2);
    AntManagerSkill _antManagerSkill = new AntManagerSkill();
    this.<AntManagerSkill>setSkill(_antManagerSkill, AntCapacity.class);
    DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
    AntInitialize _antInitialize = new AntInitialize(this.body);
    _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_antInitialize);
    AntCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER = this.$castSkill(AntCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = this.$getSkill(AntCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY);
    _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER.setPositionBefore(this.body.getPosition());
  }
  
  @SyntheticMember
  private void $behaviorUnit$Destroy$1(final Destroy occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    int _selfID = this.getSelfID();
    String _plus = ("The agent Ant " + Integer.valueOf(_selfID));
    String _plus_1 = (_plus + " was stopped.");
    String _plus_2 = (_plus_1 + "Killed by ");
    Address _source = occurrence.getSource();
    String _plus_3 = (_plus_2 + _source);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(_plus_3);
  }
  
  /**
   * Gets the number of ant
   */
  @Pure
  protected int getSelfID() {
    return this.selfIDAnt;
  }
  
  @SyntheticMember
  private void $behaviorUnit$onFoodPlace$2(final onFoodPlace occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    int _selfID = this.getSelfID();
    String _plus = ("Ant " + Integer.valueOf(_selfID));
    String _plus_1 = (_plus + " on food Place");
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(_plus_1);
    AntCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER = this.$castSkill(AntCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = this.$getSkill(AntCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY);
    _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER.pickUpFood(this.body);
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$onFoodPlace$2(final onFoodPlace it, final onFoodPlace occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @SyntheticMember
  private void $behaviorUnit$onNestPlace$3(final onNestPlace occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    int _selfID = this.getSelfID();
    String _plus = ("Ant " + Integer.valueOf(_selfID));
    String _plus_1 = (_plus + " on nest Place");
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(_plus_1);
    AntCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER = this.$castSkill(AntCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = this.$getSkill(AntCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY);
    _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER.putDownFood(this.body);
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$onNestPlace$3(final onNestPlace it, final onNestPlace occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @SyntheticMember
  private void $behaviorUnit$Perception$4(final Perception occurrence) {
    List<Cell> listPerception = occurrence.list.get(this.getID());
    Vector2i tempVector = null;
    boolean _isEmpty = listPerception.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      AntCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER = this.$castSkill(AntCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = this.$getSkill(AntCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY);
      tempVector = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER.followPheromone(listPerception, this.body.getState()).getPosition();
      Vector2i _vector2i = new Vector2i((-1), (-1));
      boolean _equals = tempVector.equals(_vector2i);
      if (_equals) {
        AntCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER_1 = this.$castSkill(AntCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = this.$getSkill(AntCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY);
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER_1.randomMove(listPerception, this.body);
      } else {
        AntCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER_2 = this.$castSkill(AntCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = this.$getSkill(AntCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY);
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER_2.move(tempVector, this.body);
      }
    } else {
      AntCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER_3 = this.$castSkill(AntCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = this.$getSkill(AntCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY);
      _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER_3.stay(this.body);
    }
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$Perception$4(final Perception it, final Perception occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @SyntheticMember
  private void $behaviorUnit$AcceptInfluence$5(final AcceptInfluence occurrence) {
    boolean _equals = this.body.getPosition().equals(occurrence.newpos);
    if (_equals) {
      Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
      int _selfID = this.getSelfID();
      String _plus = ("Ant " + Integer.valueOf(_selfID));
      String _plus_1 = (_plus + " stay in ");
      Vector2i _position = this.body.getPosition();
      String _plus_2 = (_plus_1 + _position);
      _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(_plus_2);
    } else {
      Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
      int _selfID_1 = this.getSelfID();
      String _plus_3 = ("Ant " + Integer.valueOf(_selfID_1));
      String _plus_4 = (_plus_3 + " ");
      Vector2i _position_1 = this.body.getPosition();
      String _plus_5 = (_plus_4 + _position_1);
      String _plus_6 = (_plus_5 + " move to ");
      String _plus_7 = (_plus_6 + occurrence.newpos);
      _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1.info(_plus_7);
      this.body.setPosition(occurrence.newpos);
    }
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$AcceptInfluence$5(final AcceptInfluence it, final AcceptInfluence occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @SyntheticMember
  private void $behaviorUnit$ChangeState$6(final ChangeState occurrence) {
    boolean _equals = this.body.getState().equals(occurrence.newState);
    if (_equals) {
      Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
      int _selfID = this.getSelfID();
      String _plus = ("Ant " + Integer.valueOf(_selfID));
      String _plus_1 = (_plus + " the same ");
      AntState _state = this.body.getState();
      String _plus_2 = (_plus_1 + _state);
      _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(_plus_2);
    } else {
      Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
      int _selfID_1 = this.getSelfID();
      String _plus_3 = ("Ant " + Integer.valueOf(_selfID_1));
      String _plus_4 = (_plus_3 + " ");
      AntState _state_1 = this.body.getState();
      String _plus_5 = (_plus_4 + _state_1);
      String _plus_6 = (_plus_5 + " change state to ");
      String _plus_7 = (_plus_6 + occurrence.newState);
      _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1.info(_plus_7);
      this.body.setState(occurrence.newState);
    }
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$ChangeState$6(final ChangeState it, final ChangeState occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @SyntheticMember
  private void $behaviorUnit$AcceptPickFood$7(final AcceptPickFood occurrence) {
    if ((Boolean.valueOf(occurrence.accept) == Boolean.valueOf(true))) {
      this.body.setTook();
    }
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$AcceptPickFood$7(final AcceptPickFood it, final AcceptPickFood occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @SyntheticMember
  private void $behaviorUnit$AcceptPutFood$8(final AcceptPutFood occurrence) {
    if ((Boolean.valueOf(occurrence.accept) == Boolean.valueOf(true))) {
      this.body.put();
    }
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$AcceptPutFood$8(final AcceptPutFood it, final AcceptPutFood occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @SyntheticMember
  private void $behaviorUnit$AppExit$9(final AppExit occurrence) {
    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$castSkill(Lifecycle.class, (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = this.$getSkill(Lifecycle.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.killMe();
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$AppExit$9(final AppExit it, final AppExit occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @SyntheticMember
  private void $behaviorUnit$EndAgent$10(final EndAgent occurrence) {
    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$castSkill(Lifecycle.class, (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = this.$getSkill(Lifecycle.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.killMe();
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$EndAgent$10(final EndAgent it, final EndAgent occurrence) {
    boolean _isFrom = it.isFrom(this.idEnv);
    return _isFrom;
  }
  
  @Extension
  @ImportedCapacityFeature(Lifecycle.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(Lifecycle.class, ($0$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || $0$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = $0$getSkill(Lifecycle.class)) : $0$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE)", imported = Lifecycle.class)
  private Lifecycle $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = $getSkill(Lifecycle.class);
    }
    return $castSkill(Lifecycle.class, this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
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
  
  @Extension
  @ImportedCapacityFeature(DefaultContextInteractions.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(DefaultContextInteractions.class, ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $0$getSkill(DefaultContextInteractions.class)) : $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS)", imported = DefaultContextInteractions.class)
  private DefaultContextInteractions $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $getSkill(DefaultContextInteractions.class);
    }
    return $castSkill(DefaultContextInteractions.class, this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
  }
  
  @Extension
  @ImportedCapacityFeature(AntCapacity.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(AntCapacity.class, ($0$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || $0$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) ? ($0$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = $0$getSkill(AntCapacity.class)) : $0$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY)", imported = AntCapacity.class)
  private AntCapacity $CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY$CALLER() {
    if (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY.get() == null) {
      this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY = $getSkill(AntCapacity.class);
    }
    return $castSkill(AntCapacity.class, this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ANTCAPACITY);
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Initialize(final Initialize occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Initialize$0(occurrence));
  }
  
  /**
   * Accepts the change state by the environment
   * @param newState the AntState
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$ChangeState(final ChangeState occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$ChangeState$6(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$ChangeState$6(occurrence));
    }
  }
  
  /**
   * Sends by the environment to inform the ant that he is on the nest place
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$onNestPlace(final onNestPlace occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$onNestPlace$3(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$onNestPlace$3(occurrence));
    }
  }
  
  /**
   * The environment sends the perception to the Ant
   * @param list the list of perception
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Perception(final Perception occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$Perception$4(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Perception$4(occurrence));
    }
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Destroy(final Destroy occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Destroy$1(occurrence));
  }
  
  /**
   * Kill himself after an reset signal
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$EndAgent(final EndAgent occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$EndAgent$10(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$EndAgent$10(occurrence));
    }
  }
  
  /**
   * Sends by the environment to inform the ant that he is on the food place
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$onFoodPlace(final onFoodPlace occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$onFoodPlace$2(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$onFoodPlace$2(occurrence));
    }
  }
  
  /**
   * Accepts to pick the food
   * @param accept a boolean
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$AcceptPickFood(final AcceptPickFood occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$AcceptPickFood$7(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$AcceptPickFood$7(occurrence));
    }
  }
  
  /**
   * Accepts to put the food
   * @param accept a boolean
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$AcceptPutFood(final AcceptPutFood occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$AcceptPutFood$8(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$AcceptPutFood$8(occurrence));
    }
  }
  
  /**
   * Kill himself after an exit signal of the application
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$AppExit(final AppExit occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$AppExit$9(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$AppExit$9(occurrence));
    }
  }
  
  /**
   * Accepts the move by the environment
   * @param newpos the new position
   * @param accept a boolean
   */
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$AcceptInfluence(final AcceptInfluence occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$AcceptInfluence$5(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$AcceptInfluence$5(occurrence));
    }
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
    if (!Objects.equals(this.idEnv, other.idEnv)) {
      return false;
    }
    if (other.selfIDAnt != this.selfIDAnt)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.idEnv);
    result = prime * result + this.selfIDAnt;
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
