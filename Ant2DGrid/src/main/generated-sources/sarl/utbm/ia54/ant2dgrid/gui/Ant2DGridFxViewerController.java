package utbm.ia54.ant2dgrid.gui;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.events.SpawnEnv;
import utbm.ia54.ant2dgrid.gui.fx.FxViewerController;

/**
 * @author Michel
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Ant2DGridFxViewerController extends FxViewerController {
  @FXML
  private Button spawnButton;
  
  @FXML
  @Pure
  public void actionSpawn() {
    SpawnEnv evt = new SpawnEnv();
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
  
  @SyntheticMember
  public Ant2DGridFxViewerController() {
    super();
  }
}
