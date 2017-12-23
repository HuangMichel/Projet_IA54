package utbm.ia54.ant2dgrid;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import io.sarl.lang.core.DynamicSkillProvider;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import utbm.ia54.ant2dgrid.agents.Environment;
import utbm.ia54.ant2dgrid.gui.Ant2DGridFxApplication;
import utbm.ia54.ant2dgrid.gui.Ant2DGridFxViewerController;
import utbm.ia54.ant2dgrid.gui.fx.FxApplication;
import utbm.ia54.ant2dgrid.gui.fx.FxBootAgent;
import utbm.ia54.ant2dgrid.gui.fx.FxViewerController;

/**
 * @author aelez
 */
@SarlSpecification("0.6")
@SarlElementType(17)
@SuppressWarnings("all")
public class Ant2DGrid extends FxBootAgent {
  protected Class<? extends FxApplication> getFxApplicationType() {
    return Ant2DGridFxApplication.class;
  }
  
  protected Class<? extends Agent> getApplicationBootAgentType() {
    return Environment.class;
  }
  
  @Override
  protected void buildApplicationBootAgentParameters(final UUID launcherID, final FxViewerController controller, final List<Object> parameters) {
    Ant2DGridFxViewerController ctrl = ((Ant2DGridFxViewerController) controller);
  }
  
  @SyntheticMember
  public Ant2DGrid(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  @Deprecated
  public Ant2DGrid(final BuiltinCapacitiesProvider provider, final UUID parentID, final UUID agentID) {
    super(provider, parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  public Ant2DGrid(final UUID parentID, final UUID agentID, final DynamicSkillProvider skillProvider) {
    super(parentID, agentID, skillProvider);
  }
}
