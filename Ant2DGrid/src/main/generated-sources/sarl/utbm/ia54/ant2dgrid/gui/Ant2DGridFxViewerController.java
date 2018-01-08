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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import utbm.ia54.ant2dgrid.Enum.CellState;
import utbm.ia54.ant2dgrid.events.ConfigureSimulation;
import utbm.ia54.ant2dgrid.events.EndAgent;
import utbm.ia54.ant2dgrid.events.PauseSim;
import utbm.ia54.ant2dgrid.events.ResumeSim;
import utbm.ia54.ant2dgrid.gui.fx.FxViewerController;
import utbm.ia54.ant2dgrid.objects.Cell;
import utbm.ia54.ant2dgrid.objects.MapGenerator;

/**
 * @author aelez
 * @author Michel
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
  
  @FXML
  private Button restartBtn;
  
  @FXML
  private Button pauseButton;
  
  @FXML
  private Button resumeButton;
  
  /**
   * The grid a list of cell
   */
  private List<Cell> grid;
  
  /**
   * mapCreated a boolean
   */
  private boolean mapCreated = false;
  
  /**
   * launched a boolean
   */
  private boolean launched = false;
  
  /**
   * Gets the grid
   * @return grid the list of cell
   */
  public List<Cell> getGrid() {
    return this.grid;
  }
  
  /**
   * Gets the quantity of ant
   * @return quantity
   */
  public int getAntQuantity() {
    return Integer.parseInt(this.numberOfAnt.getText());
  }
  
  /**
   * Gets the number of rows
   * @return width
   */
  public int getWidth() {
    return this.gridZone.getRowConstraints().size();
  }
  
  /**
   * Gets the number of cols
   * @return height
   */
  public int getHeight() {
    return this.gridZone.getColumnConstraints().size();
  }
  
  /**
   * Creates the map
   */
  @FXML
  public void createMap() {
    int _width = this.getWidth();
    int _height = this.getHeight();
    MapGenerator generator = new MapGenerator(_width, _height);
    this.grid = generator.generateMap();
    for (int i = 0; (i < this.getWidth()); i++) {
      for (int j = 0; (j < this.getHeight()); j++) {
        {
          int _height_1 = this.getHeight();
          int _multiply = (i * _height_1);
          int _plus = (_multiply + j);
          Cell cell = this.grid.get(_plus);
          this.gridZone.add(cell, i, j);
          CellState _state = cell.getState();
          boolean _tripleEquals = (_state == CellState.NORMAL);
          if (_tripleEquals) {
            this.gridZone.add(cell.getShapeAnt(), cell.getPosition().getX(), cell.getPosition().getY(), 1, 1);
            this.gridZone.add(cell.getPheromoneHome().getObjfx(), cell.getPosition().getX(), cell.getPosition().getY(), 1, 2);
            this.gridZone.add(cell.getPheromoneFood().getObjfx(), cell.getPosition().getX(), cell.getPosition().getY(), 2, 2);
          }
          if (((cell.getState() == CellState.FOOD) || (cell.getState() == CellState.HOME))) {
            this.gridZone.add(cell.getFood().getShape(), cell.getPosition().getX(), cell.getPosition().getY(), 2, 1);
          }
        }
      }
    }
    if ((Boolean.valueOf(this.mapCreated) == Boolean.valueOf(false))) {
      this.mapCreated = true;
      this.btnMap.setText("Re-generate Map");
      this.spawnButton.setDisable(false);
    }
    this.addCellEvent();
  }
  
  /**
   * Add event on the cell
   */
  private void addCellEvent() {
    abstract class __Ant2DGridFxViewerController_0 implements EventHandler<MouseEvent> {
      public abstract void handle(final MouseEvent event);
    }
    
    final Consumer<Node> _function = (Node item) -> {
      __Ant2DGridFxViewerController_0 ___Ant2DGridFxViewerController_0 = new __Ant2DGridFxViewerController_0() {
        public void handle(final MouseEvent event) {
          if ((item instanceof Cell)) {
            Cell cell = ((Cell) item);
            int _clickCount = event.getClickCount();
            boolean _tripleEquals = (_clickCount == 1);
            if (_tripleEquals) {
              InputOutput.<String>println(cell.toString());
            }
          }
        }
      };
      item.setOnMouseClicked(___Ant2DGridFxViewerController_0);
    };
    this.gridZone.getChildren().forEach(_function);
  }
  
  /**
   * Launched the application
   */
  @FXML
  public void actionSpawn() {
    ConfigureSimulation evt = new ConfigureSimulation();
    if ((!this.launched)) {
      final Procedure0 _function = () -> {
        this.emitToAgent(evt);
      };
      this.startAgentApplication(_function);
      this.launched = true;
      this.btnMap.setDisable(true);
      this.spawnButton.setDisable(true);
      this.numberOfAnt.setDisable(true);
      this.resumeButton.setDisable(true);
      this.restartBtn.setDisable(false);
      this.pauseButton.setDisable(false);
    } else {
      this.emitToAgent(evt);
    }
  }
  
  /**
   * Restart the application
   */
  @FXML
  public void onRestart() {
    this.btnMap.setDisable(false);
    this.numberOfAnt.setDisable(false);
    this.restartBtn.setDisable(true);
    this.launched = false;
    this.spawnButton.setDisable(false);
    EndAgent _endAgent = new EndAgent();
    this.emitToAgent(_endAgent);
  }
  
  /**
   * Pause the Simulation
   */
  @FXML
  public void pauseSim() {
    PauseSim _pauseSim = new PauseSim();
    this.emitToAgent(_pauseSim);
    this.pauseButton.setDisable(true);
    this.resumeButton.setDisable(false);
  }
  
  /**
   * Resume the Simulation
   */
  @FXML
  public void resumeSim() {
    ResumeSim _resumeSim = new ResumeSim();
    this.emitToAgent(_resumeSim);
    this.pauseButton.setDisable(false);
    this.resumeButton.setDisable(true);
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
    Ant2DGridFxViewerController other = (Ant2DGridFxViewerController) obj;
    if (other.mapCreated != this.mapCreated)
      return false;
    if (other.launched != this.launched)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + (this.mapCreated ? 1231 : 1237);
    result = prime * result + (this.launched ? 1231 : 1237);
    return result;
  }
  
  @SyntheticMember
  public Ant2DGridFxViewerController() {
    super();
  }
}
