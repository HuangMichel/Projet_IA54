package utbm.ia54.ant2dgrid.gui.fx;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventListener;
import io.sarl.util.OpenEventSpace;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.UUID;
import javafx.application.Platform;
import javafx.fxml.FXML;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.gui.fx.AppExit;
import utbm.ia54.ant2dgrid.gui.fx.AppStart;

@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class FxViewerController implements EventListener {
  private final UUID id = UUID.randomUUID();
  
  /**
   * Event space for interacting with the agents
   */
  private OpenEventSpace space;
  
  /**
   * Emit a kill signal when the app is exited
   */
  public void safeExit() {
    AppExit _appExit = new AppExit();
    this.emitToAgent(_appExit);
  }
  
  /**
   * Method invoked by the SARL agent to register the object on a space
   */
  public Address setUISpace(final OpenEventSpace space) {
    Address _xblockexpression = null;
    {
      OpenEventSpace _space = this.space;
      if (_space!=null) {
        _space.unregister(this);
      }
      this.space = space;
      OpenEventSpace _space_1 = this.space;
      Address _register = null;
      if (_space_1!=null) {
        _register=_space_1.register(this);
      }
      _xblockexpression = _register;
    }
    return _xblockexpression;
  }
  
  /**
   * Replies the space for interaction between SARL agent and UI
   */
  @Pure
  public OpenEventSpace getUISpace() {
    return this.space;
  }
  
  public void startAgentApplication(final Procedure0 feedback) {
    AppStart _appStart = new AppStart(this, feedback);
    this.emitToAgent(_appStart);
  }
  
  @FXML
  public void exitApplication(final ActionEvent event) {
    this.safeExit();
    Platform.exit();
  }
  
  /**
   * Emit an event to the agents
   */
  public void emitToAgent(final Event event) {
    if ((this.space != null)) {
      this.space.emit(this.id, event, null);
    }
  }
  
  /**
   * Get ID of the object on the space
   */
  @Pure
  public UUID getID() {
    return this.id;
  }
  
  /**
   * Needed for receiving events from the agents
   */
  public void receiveEvent(final Event event) {
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
    FxViewerController other = (FxViewerController) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.id);
    return result;
  }
  
  @SyntheticMember
  public FxViewerController() {
    super();
  }
}
