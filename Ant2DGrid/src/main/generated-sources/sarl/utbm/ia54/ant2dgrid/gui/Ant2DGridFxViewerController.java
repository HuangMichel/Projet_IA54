package utbm.ia54.ant2dgrid.gui;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pure;
import utbm.ia54.ant2dgrid.gui.fx.ConfigureSimulation;
import utbm.ia54.ant2dgrid.gui.fx.FxViewerController;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.MapGenerator;

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
  private TextField numberOfAnt;
  
  private List<Cell> grid;
  
  private boolean mapCreated = false;
  
  @Pure
  public int getAntQuantity() {
    return Integer.parseInt(this.numberOfAnt.getText());
  }
  
  @Pure
  public int getWidth() {
    return this.gridZone.getRowConstraints().size();
  }
  
  @Pure
  public int getHeight() {
    return this.gridZone.getColumnConstraints().size();
  }
  
  @FXML
  public void actionSpawn() {
    int _antQuantity = this.getAntQuantity();
    String _plus = ("Number of Ant : " + Integer.valueOf(_antQuantity));
    InputOutput.<String>println(_plus);
    InputOutput.<Integer>println(Integer.valueOf(this.getWidth()));
    InputOutput.<Integer>println(Integer.valueOf(this.getHeight()));
    int _width = this.getWidth();
    int _height = this.getHeight();
    final MapGenerator generator = new MapGenerator(_width, _height);
    this.grid = generator.generateMap();
    for (int i = 0; (i < this.getWidth()); i++) {
      for (int j = 0; (j < this.getHeight()); j++) {
        int _height_1 = this.getHeight();
        int _multiply = (i * _height_1);
        int _plus_1 = (_multiply + j);
        this.gridZone.add(this.grid.get(_plus_1), i, j);
      }
    }
    int _antQuantity_1 = this.getAntQuantity();
    int _width_1 = this.getWidth();
    int _height_1 = this.getHeight();
    ConfigureSimulation evt = new ConfigureSimulation(_antQuantity_1, _width_1, _height_1, this.grid);
    this.emitToAgent(evt);
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
    Ant2DGridFxViewerController other = (Ant2DGridFxViewerController) obj;
    if (other.mapCreated != this.mapCreated)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + (this.mapCreated ? 1231 : 1237);
    return result;
  }
  
  @SyntheticMember
  public Ant2DGridFxViewerController() {
    super();
  }
}
