package utbm.ia54.ant2dgrid.gui;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.List;
import java.util.function.Consumer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
  
  @FXML
  private Button btnMap;
  
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
  public void createMap() {
    int _width = this.getWidth();
    int _height = this.getHeight();
    MapGenerator generator = new MapGenerator(_width, _height);
    this.grid = generator.generateMap();
    for (int i = 0; (i < this.getWidth()); i++) {
      for (int j = 0; (j < this.getHeight()); j++) {
        int _height_1 = this.getHeight();
        int _multiply = (i * _height_1);
        int _plus = (_multiply + j);
        this.gridZone.add(this.grid.get(_plus), i, j);
      }
    }
    if ((Boolean.valueOf(this.mapCreated) == Boolean.valueOf(false))) {
      this.mapCreated = true;
      this.btnMap.setText("Re-generate Map");
      this.spawnButton.setDisable(false);
    }
    this.addCellEvent();
  }
  
  @FXML
  public void addCellEvent() {
    abstract class __Ant2DGridFxViewerController_0 implements EventHandler<MouseEvent> {
      public abstract void handle(final MouseEvent event);
    }
    
    final Consumer<Node> _function = (Node item) -> {
      __Ant2DGridFxViewerController_0 ___Ant2DGridFxViewerController_0 = new __Ant2DGridFxViewerController_0() {
        public void handle(final MouseEvent event) {
          int _clickCount = event.getClickCount();
          boolean _tripleEquals = (_clickCount == 1);
          if (_tripleEquals) {
            InputOutput.<String>println(item.toString());
          }
        }
      };
      item.setOnMouseClicked(___Ant2DGridFxViewerController_0);
    };
    this.gridZone.getChildren().forEach(_function);
  }
  
  @FXML
  public void actionSpawn() {
    int _antQuantity = this.getAntQuantity();
    String _plus = ("Number of Ant : " + Integer.valueOf(_antQuantity));
    InputOutput.<String>println(_plus);
    int _width = this.getWidth();
    String _plus_1 = ("Width : " + Integer.valueOf(_width));
    InputOutput.<String>println(_plus_1);
    int _height = this.getHeight();
    String _plus_2 = ("Height :" + Integer.valueOf(_height));
    InputOutput.<String>println(_plus_2);
    int _antQuantity_1 = this.getAntQuantity();
    int _width_1 = this.getWidth();
    int _height_1 = this.getHeight();
    ConfigureSimulation evt = new ConfigureSimulation(_antQuantity_1, _width_1, _height_1, this.grid);
    this.emitToAgent(evt);
    this.btnMap.setDisable(true);
    this.spawnButton.setDisable(true);
    this.numberOfAnt.setDisable(true);
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
