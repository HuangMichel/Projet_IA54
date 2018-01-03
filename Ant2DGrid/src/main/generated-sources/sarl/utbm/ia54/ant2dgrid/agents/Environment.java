package utbm.ia54.ant2dgrid.agents;

import io.sarl.core.DefaultContextInteractions;
import io.sarl.core.Destroy;
import io.sarl.core.Initialize;
import io.sarl.core.InnerContextAccess;
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
import io.sarl.util.Scopes;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Inline;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.agents.Ant;
import utbm.ia54.ant2dgrid.capacities.EnvironmentManagerCapacity;
import utbm.ia54.ant2dgrid.events.AcceptInfluence;
import utbm.ia54.ant2dgrid.events.AntInitialize;
import utbm.ia54.ant2dgrid.events.Continue;
import utbm.ia54.ant2dgrid.events.EndSimulation;
import utbm.ia54.ant2dgrid.events.Influence;
import utbm.ia54.ant2dgrid.events.Perception;
import utbm.ia54.ant2dgrid.events.StartSimulation;
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
    int _antQuantity = this.ctrl.getAntQuantity();
    boolean _tripleEquals = (this.counter == _antQuantity);
    if (_tripleEquals) {
      DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
      Continue _continue = new Continue();
      _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_continue);
      this.counter = 0;
    }
  }
  
  @SyntheticMember
  private boolean $behaviorUnitGuard$AntInitialize$1(final AntInitialize it, final AntInitialize occurrence) {
    InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
    boolean _isInInnerDefaultSpace = _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.isInInnerDefaultSpace(occurrence);
    return _isInInnerDefaultSpace;
  }
  
  @SyntheticMember
  private void $behaviorUnit$StartSimulation$2(final StartSimulation occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("StartSimulation");
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
    if ((!(this.launched).booleanValue())) {
      synchronized (this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getGrid()) {
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        final BiConsumer<UUID, Address> _function = (UUID id, Address address) -> {
          EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
          List<Cell> list = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.getPerception(id);
          InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
          Perception _perception = new Perception(list);
          _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _perception, Scopes.addresses(address));
        };
        _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.getAntAddresses().forEach(_function);
      }
    }
  }
  
  @SyntheticMember
  private void $behaviorUnit$Influence$4(final Influence occurrence) {
    boolean accept = false;
    AntBody body = occurrence.body;
    Vector2i oldPosition = occurrence.body.getPosition();
    Vector2i newPosition = occurrence.newpos;
    boolean _equals = oldPosition.equals(newPosition);
    if (_equals) {
    } else {
      synchronized (this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY).getGrid()) {
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _x = newPosition.getX();
        EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
        int _height = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_1.getHeight();
        int _multiply = (_x * _height);
        int _y = newPosition.getY();
        int _plus = (_multiply + _y);
        CellState _state = _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER.getCell(_plus).getState();
        boolean _tripleEquals = (_state == CellState.NORMAL);
        if (_tripleEquals) {
          EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
          _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_2.removeAntCell(oldPosition, body.getID(), body);
          EnvironmentManagerCapacity _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3 = this.$castSkill(EnvironmentManagerCapacity.class, (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY == null || this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY.get() == null) ? (this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY = this.$getSkill(EnvironmentManagerCapacity.class)) : this.$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY);
          _$CAPACITY_USE$UTBM_IA54_ANT2DGRID_CAPACITIES_ENVIRONMENTMANAGERCAPACITY$CALLER_3.createAnt(newPosition, body.getID(), body);
          accept = true;
        }
      }
    }
    if (accept) {
      InnerContextAccess _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER = this.$castSkill(InnerContextAccess.class, (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS == null || this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS = this.$getSkill(InnerContextAccess.class)) : this.$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS);
      AcceptInfluence _acceptInfluence = new AcceptInfluence(newPosition, accept);
      _$CAPACITY_USE$IO_SARL_CORE_INNERCONTEXTACCESS$CALLER.getInnerContext().getDefaultSpace().emit(this.getID(), _acceptInfluence, 
        Scopes.addresses(occurrence.getSource()));
      int _counter = this.counter;
      this.counter = (_counter + 1);
      int _antQuantity = this.ctrl.getAntQuantity();
      boolean _tripleEquals = (this.counter == _antQuantity);
      if (_tripleEquals) {
        DefaultContextInteractions _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER = this.$castSkill(DefaultContextInteractions.class, (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = this.$getSkill(DefaultContextInteractions.class)) : this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
        Continue _continue = new Continue();
        _$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER.emit(_continue);
        this.counter = 0;
      }
    }
  }
  
  @SyntheticMember
  private void $behaviorUnit$Destroy$5(final Destroy occurrence) {
    Logging _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER = this.$castSkill(Logging.class, (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING == null || this.$CAPACITY_USE$IO_SARL_CORE_LOGGING.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LOGGING = this.$getSkill(Logging.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LOGGING);
    _$CAPACITY_USE$IO_SARL_CORE_LOGGING$CALLER.info("Agent Environment go die!");
  }
  
  @SyntheticMember
  private void $behaviorUnit$EndSimulation$6(final EndSimulation occurrence) {
    Lifecycle _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER = this.$castSkill(Lifecycle.class, (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE == null || this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE.get() == null) ? (this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE = this.$getSkill(Lifecycle.class)) : this.$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE);
    _$CAPACITY_USE$IO_SARL_CORE_LIFECYCLE$CALLER.killMe();
  }
  
  @Extension
  @ImportedCapacityFeature(Lifecycle.class)
  @SyntheticMember
  private transient ClearableReference<Skill> $CAPACITY_USE$IO_SARL_CORE_LIFECYCLE;
  
  @SyntheticMember
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
  @Inline(value = "$castSkill(DefaultContextInteractions.class, ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) ? ($0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $0$getSkill(DefaultContextInteractions.class)) : $0$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS)", imported = DefaultContextInteractions.class)
  private DefaultContextInteractions $CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS$CALLER() {
    if (this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS == null || this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS.get() == null) {
      this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS = $getSkill(DefaultContextInteractions.class);
    }
    return $castSkill(DefaultContextInteractions.class, this.$CAPACITY_USE$IO_SARL_CORE_DEFAULTCONTEXTINTERACTIONS);
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
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$EndSimulation$6(occurrence));
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
  private void $guardEvaluator$Influence(final Influence occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Influence$4(occurrence));
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
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Destroy$5(occurrence));
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
  
  @Override
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
