package utbm.ia54.ant2dgrid.agents;

import io.sarl.core.DefaultContextInteractions;
import io.sarl.core.Destroy;
import io.sarl.core.Initialize;
import io.sarl.core.InnerContextAccess;
import io.sarl.core.Lifecycle;
import io.sarl.core.Logging;
import io.sarl.core.Schedules;
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
import io.sarl.util.Scopes;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.Enum.AntState;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.agents.Ant;
import utbm.ia54.ant2dgrid.capacities.EnvironmentManagerCapacity;
import utbm.ia54.ant2dgrid.events.AcceptInfluence;
import utbm.ia54.ant2dgrid.events.AcceptPickFood;
import utbm.ia54.ant2dgrid.events.AntInitialize;
import utbm.ia54.ant2dgrid.events.ChangeState;
import utbm.ia54.ant2dgrid.events.Continue;
import utbm.ia54.ant2dgrid.events.EndSimulation;
import utbm.ia54.ant2dgrid.events.Influence;
import utbm.ia54.ant2dgrid.events.Perception;
import utbm.ia54.ant2dgrid.events.PickFood;
import utbm.ia54.ant2dgrid.events.PutFood;
import utbm.ia54.ant2dgrid.events.StartSimulation;
import utbm.ia54.ant2dgrid.events.onFoodPlace;
import utbm.ia54.ant2dgrid.events.onNestPlace;
import utbm.ia54.ant2dgrid.gui.Ant2DGridFxViewerController;
import utbm.ia54.ant2dgrid.objects.AntBody;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.Vector2i;
import utbm.ia54.ant2dgrid.skills.EnvironmentManagerSkill;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(17)
@SuppressWarnings("all")
public class Environment extends Agent {
  /**
   * The fx viewer controller
   */
  private Ant2DGridFxViewerController ctrl = null;
  
  private Boolean launched = Boolean.valueOf(false);
  
  private int counter = 0;
  
  private HashMap<UUID, List<Cell>> perception = new HashMap<UUID, List<Cell>>();
  
  @SyntheticMember
  private void $behaviorUnit$Initialize$0(final Initialize occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    UUID _iD = this.getID();
    String _plus = ("Environment " + _iD);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.setLoggingName(_plus);
    if ((this.ctrl == null)) {
      Object _get = occurrence.parameters[0];
      this.ctrl = ((Ant2DGridFxViewerController) _get);
    }
    int _width = this.ctrl.getWidth();
    int _height = this.ctrl.getHeight();
    List<Cell> _grid = this.ctrl.getGrid();
    int _antQuantity = this.ctrl.getAntQuantity();
    EnvironmentManagerSkill _environmentManagerSkill = new EnvironmentManagerSkill(_width, _height, _grid, _antQuantity);
    this.<EnvironmentManagerSkill>setSkill(_environmentManagerSkill, EnvironmentManagerCapacity.class);
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
    String _string = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.getHomeCell().toString();
    String _plus_1 = ("CELL HOME :" + _string);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1.info(_plus_1);
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_2 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
    String _string_1 = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.getFoodCell().toString();
    String _plus_2 = ("CELL FOOD :" + _string_1);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_2.info(_plus_2);
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_3 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_3.info("The agent Environment was started.");
  }
  
  @SyntheticMember
  private void $behaviorUnit$AntInitialize$1(final AntInitialize occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    UUID _uUID = occurrence.getSource().getUUID();
    String _plus = ("Ant created " + _uUID);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(_plus);
    EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
    _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.setAddress(occurrence.getSource().getUUID(), occurrence.getSource());
    EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
    EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
    _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.createAnt(_$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2.getHomeCell().getPosition(), occurrence.getSource().getUUID(), occurrence.body);
    int _counter = this.counter;
    this.counter = (_counter + 1);
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_1.info(Integer.valueOf(this.counter));
    int _antQuantity = this.ctrl.getAntQuantity();
    boolean _tripleEquals = (this.counter == _antQuantity);
    if (_tripleEquals) {
      Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_2 = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
      _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER_2.info("reset counter");
      DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
      Continue _continue = new Continue();
      _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_continue);
      this.counter = 0;
    }
  }
  
  @SyntheticMember
  @Pure
  private boolean $behaviorUnitGuard$AntInitialize$1(final AntInitialize it, final AntInitialize occurrence) {
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    boolean _isInInnerDefaultSpace = _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.isInInnerDefaultSpace(occurrence);
    return _isInInnerDefaultSpace;
  }
  
  @SyntheticMember
  private void $behaviorUnit$StartSimulation$2(final StartSimulation occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("Starting Simulation");
    for (int i = 0; (i < this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getAntQuantity()); i++) {
      Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$castSkill(Lifecycle.class, (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = this.$getSkill(Lifecycle.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
      InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
      EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
      Vector2i _position = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.getHomeCell().getPosition();
      _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.spawnInContext(Ant.class, _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext(), new Object[] { Integer.valueOf((i + 1)), _position });
    }
  }
  
  @SyntheticMember
  private void $behaviorUnit$Continue$3(final Continue occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("New cycle");
    if ((!(this.launched).booleanValue())) {
      synchronized (this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getGrid()) {
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        final BiConsumer<UUID, Address> _function = (UUID id, Address address) -> {
          EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
          List<Cell> list = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.getPerception(id);
          this.perception.put(id, list);
        };
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.getAntAddresses().forEach(_function);
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _numberAnt = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.getHomeCell().getNumberAnt();
        boolean _greaterThan = (_numberAnt > 0);
        if (_greaterThan) {
          EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
          final BiConsumer<UUID, AntBody> _function_1 = (UUID id, AntBody body) -> {
            if (((Boolean.valueOf(body.isTake()) == Boolean.valueOf(true)) && (body.getState() == AntState.RETURN_HOME))) {
              InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
              onNestPlace _onNestPlace = new onNestPlace();
              EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
              _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _onNestPlace, Scopes.addresses(_$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3.getAddress(body.getID())));
            }
          };
          _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2.getHomeCell().getAntList().forEach(_function_1);
        }
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _numberAnt_1 = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3.getFoodCell().getNumberAnt();
        boolean _greaterThan_1 = (_numberAnt_1 > 0);
        if (_greaterThan_1) {
          EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_4 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
          final BiConsumer<UUID, AntBody> _function_2 = (UUID id, AntBody body) -> {
            if (((Boolean.valueOf(body.isTake()) == Boolean.valueOf(false)) && (body.getState() == AntState.SEARCH_FOOD))) {
              InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
              onFoodPlace _onFoodPlace = new onFoodPlace();
              EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_5 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
              _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _onFoodPlace, Scopes.addresses(_$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_5.getAddress(body.getID())));
            }
          };
          _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_4.getFoodCell().getAntList().forEach(_function_2);
        }
        Schedules _$CAPACITY_USE$IO_SARL_CORE_SCHEDULES$CALLER = this.$castSkill(Schedules.class, (this.$CAPACITY_USE$IO_SARL_CORE_SCHEDULES == null || this.$CAPACITY_USE$IO_SARL_CORE_SCHEDULES.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_SCHEDULES = this.$getSkill(Schedules.class)) : this.$CAPACITY_USE$IO_SARL_CORE_SCHEDULES);
        final Procedure1<Agent> _function_3 = (Agent it) -> {
          InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
          Perception _perception = new Perception(this.perception);
          _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(it.getID(), _perception, null);
        };
        _$CAPACITY_USE$IO_SARL_CORE_SCHEDULES$CALLER.in(1000, _function_3);
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_5 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        final Consumer<Cell> _function_4 = (Cell cell) -> {
          if (((cell.getState() == CellState.NORMAL) && (cell.getNumberAnt() == 0))) {
            cell.evaporationPheromoneHome();
          }
        };
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_5.getGrid().forEach(_function_4);
      }
    }
  }
  
  @SyntheticMember
  private void $behaviorUnit$PickFood$4(final PickFood occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("Pick");
    AntBody body = occurrence.body;
    if (((body.getState() == AntState.SEARCH_FOOD) && (Boolean.valueOf(body.isTake()) == Boolean.valueOf(false)))) {
      EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
      int _x = body.getPosition().getX();
      EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
      int _height = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.getHeight();
      int _multiply = (_x * _height);
      int _y = body.getPosition().getY();
      int _plus = (_multiply + _y);
      CellState _state = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.getCell(_plus).getState();
      boolean _tripleEquals = (_state == CellState.FOOD);
      if (_tripleEquals) {
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _x_1 = body.getPosition().getX();
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _height_1 = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3.getHeight();
        int _multiply_1 = (_x_1 * _height_1);
        int _y_1 = body.getPosition().getY();
        int _plus_1 = (_multiply_1 + _y_1);
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2.getCell(_plus_1).getFood().decrementFood(body.getCapacity());
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_4 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _x_2 = body.getPosition().getX();
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_5 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _height_2 = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_5.getHeight();
        int _multiply_2 = (_x_2 * _height_2);
        int _y_2 = body.getPosition().getY();
        int _plus_2 = (_multiply_2 + _y_2);
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_4.getCell(_plus_2).getAntList().get(body.getID()).setTake();
      }
    }
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_6 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
    int _x_3 = body.getPosition().getX();
    EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_7 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
    int _height_3 = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_7.getHeight();
    int _multiply_3 = (_x_3 * _height_3);
    int _y_3 = body.getPosition().getY();
    int _plus_3 = (_multiply_3 + _y_3);
    boolean _isTake = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_6.getCell(_plus_3).getAntList().get(body.getID()).isTake();
    AcceptPickFood _acceptPickFood = new AcceptPickFood(_isTake);
    _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _acceptPickFood, Scopes.addresses(occurrence.getSource()));
  }
  
  @SyntheticMember
  private void $behaviorUnit$PutFood$5(final PutFood occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("put");
    AntBody body = occurrence.body;
    if (((body.getState() == AntState.RETURN_HOME) && (Boolean.valueOf(body.isTake()) == Boolean.valueOf(true)))) {
      EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
      _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.getHomeCell().getFood().incrementFood(body.getCapacity());
      EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
      _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.getHomeCell().getAntList().get(body.getID()).put();
    }
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
    boolean _isTake = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2.getHomeCell().getAntList().get(body.getID()).isTake();
    AcceptPickFood _acceptPickFood = new AcceptPickFood(_isTake);
    _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _acceptPickFood, 
      Scopes.addresses(occurrence.getSource()));
  }
  
  @SyntheticMember
  private void $behaviorUnit$Influence$6(final Influence occurrence) {
    boolean accept = false;
    AntBody body = occurrence.body;
    Vector2i oldPosition = occurrence.body.getPosition();
    Vector2i newPosition = occurrence.newpos;
    synchronized (this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getGrid()) {
      if ((((this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getCell(((newPosition.getX() * this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getHeight()) + newPosition.getY())).getState() == CellState.NORMAL) || 
        (this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getCell(((newPosition.getX() * this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getHeight()) + newPosition.getY())).getState() == CellState.FOOD)) || 
        (this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getCell(((newPosition.getX() * this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getHeight()) + newPosition.getY())).getState() == CellState.HOME))) {
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.removeAntCell(oldPosition, body.getID(), body);
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.createAnt(newPosition, body.getID(), body);
        accept = true;
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _x = newPosition.getX();
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _height = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3.getHeight();
        int _multiply = (_x * _height);
        int _y = newPosition.getY();
        int _plus = (_multiply + _y);
        CellState _state = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2.getCell(_plus).getState();
        boolean _tripleEquals = (_state == CellState.FOOD);
        if (_tripleEquals) {
          InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
          ChangeState _changeState = new ChangeState(AntState.RETURN_HOME);
          _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _changeState, Scopes.addresses(occurrence.getSource()));
        }
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_4 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _x_1 = newPosition.getX();
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_5 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _height_1 = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_5.getHeight();
        int _multiply_1 = (_x_1 * _height_1);
        int _y_1 = newPosition.getY();
        int _plus_1 = (_multiply_1 + _y_1);
        CellState _state_1 = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_4.getCell(_plus_1).getState();
        boolean _tripleEquals_1 = (_state_1 == CellState.HOME);
        if (_tripleEquals_1) {
          InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER_1 = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
          ChangeState _changeState_1 = new ChangeState(AntState.SEARCH_FOOD);
          _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER_1.getInnerContext().getDefaultSpace().emit(this.getID(), _changeState_1, Scopes.addresses(occurrence.getSource()));
        }
      }
    }
    int _counter = this.counter;
    this.counter = (_counter + 1);
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    String _plus = (Integer.valueOf(this.counter) + " Ants updated");
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info(_plus);
    if (accept) {
      InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
      AcceptInfluence _acceptInfluence = new AcceptInfluence(newPosition, accept);
      _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _acceptInfluence, 
        Scopes.addresses(occurrence.getSource()));
      int _antQuantity = this.ctrl.getAntQuantity();
      boolean _tripleEquals = (this.counter == _antQuantity);
      if (_tripleEquals) {
        this.counter = 0;
        this.perception.clear();
        DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
        Continue _continue = new Continue();
        _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_continue);
      }
    }
  }
  
  @SyntheticMember
  private void $behaviorUnit$Destroy$7(final Destroy occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("Agent Environment go die!");
  }
  
  @SyntheticMember
  private void $behaviorUnit$EndSimulation$8(final EndSimulation occurrence) {
    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$castSkill(Lifecycle.class, (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = this.$getSkill(Lifecycle.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.killMe();
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
  @ImportedCapacityFeature(InnerContextAccess.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(InnerContextAccess.class, ($0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || $0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = $0$getSkill(InnerContextAccess.class)) : $0$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS)", imported = InnerContextAccess.class)
  private InnerContextAccess $CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = $getSkill(InnerContextAccess.class);
    }
    return $castSkill(InnerContextAccess.class, this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
  }
  
  @Extension
  @ImportedCapacityFeature(EnvironmentManagerCapacity.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(EnvironmentManagerCapacity.class, ($0$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || $0$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? ($0$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = $0$getSkill(EnvironmentManagerCapacity.class)) : $0$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY)", imported = EnvironmentManagerCapacity.class)
  private EnvironmentManagerCapacity $CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER() {
    if (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) {
      this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = $getSkill(EnvironmentManagerCapacity.class);
    }
    return $castSkill(EnvironmentManagerCapacity.class, this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
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
  @ImportedCapacityFeature(Schedules.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_SCHEDULES;
  
  @SyntheticMember
  @Pure
  @Inline(value = "$castSkill(Schedules.class, ($0$CAPACITY_USE$IO_SARL_CORE_SCHEDULES == null || $0$CAPACITY_USE$IO_SARL_CORE_SCHEDULES.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_SCHEDULES = $0$getSkill(Schedules.class)) : $0$CAPACITY_USE$IO_SARL_CORE_SCHEDULES)", imported = Schedules.class)
  private Schedules $CAPACITY_USE$IO_SARL_CORE_SCHEDULES$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_SCHEDULES == null || this.$CAPACITY_USE$IO_SARL_CORE_SCHEDULES.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_SCHEDULES = $getSkill(Schedules.class);
    }
    return $castSkill(Schedules.class, this.$CAPACITY_USE$IO_SARL_CORE_SCHEDULES);
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
  private void $guardEvaluator$EndSimulation(final EndSimulation occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$EndSimulation$8(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Continue(final Continue occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Continue$3(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$PutFood(final PutFood occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$PutFood$5(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Influence(final Influence occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Influence$6(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$StartSimulation(final StartSimulation occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$StartSimulation$2(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Destroy(final Destroy occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Destroy$7(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$AntInitialize(final AntInitialize occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    if ($behaviorUnitGuard$AntInitialize$1(occurrence, occurrence)) {
      ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$AntInitialize$1(occurrence));
    }
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$PickFood(final PickFood occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$PickFood$4(occurrence));
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
    Environment other = (Environment) obj;
    if (other.launched != this.launched)
      return false;
    if (other.counter != this.counter)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + (this.launched ? 1231 : 1237);
    result = prime * result + this.counter;
    return result;
  }
  
  @SyntheticMember
  public Environment(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  @Deprecated
  public Environment(final BuiltinCapacitiesProvider provider, final UUID parentID, final UUID agentID) {
    super(provider, parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  public Environment(final UUID parentID, final UUID agentID, final DynamicSkillProvider skillProvider) {
    super(parentID, agentID, skillProvider);
  }
}
