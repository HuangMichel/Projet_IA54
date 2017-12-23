package utbm.ia54.ant2dgrid.gui;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import utbm.ia54.ant2dgrid.gui.fx.ConfigureSimulation;
import utbm.ia54.ant2dgrid.gui.fx.FxViewerController;
import utbm.ia54.ant2dgrid.objects.Cell;

/**
 * @author aelez
 */
@SarlSpecification("0.6")
@SarlElementType(9)
@SuppressWarnings("all")
public class Ant2DGridFxViewerController extends FxViewerController {
  @FXML
  private Button spawnButton;
  
  @FXML
  private GridPane gridZone;
  
  @FXML
  public void actionSpawn() {
    ConfigureSimulation evt = new ConfigureSimulation(5, 10, 10, new Function0<List<Cell>>() {
      public List<Cell> apply() {
        return null;
      }
    }.apply());
    this.emitToAgent(evt);
  }
  
  @Override
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
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
