package javafxapplication16;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML 
    private MaterialDesignIconView btnClose;
    
    // For Make Stage Drageable
    private double xOffset = 0;
    private double yOffset = 0;
    
    public void closeFenetre(){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDrageable();
    }
    /**
     * a grand thanks for my frend houari zegay for this function ,
     *the application returned nice with this functionality
    **/
    private void makeStageDrageable() {
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                JavaFXApplication16.stage.setX(event.getScreenX() - xOffset);
                JavaFXApplication16.stage.setY(event.getScreenY() - yOffset);
                JavaFXApplication16.stage.setOpacity(0.7f);
            }
        });
        root.setOnDragDone((e) -> {
            JavaFXApplication16.stage.setOpacity(1.0f);
        });
        root.setOnMouseReleased((e) -> {
            JavaFXApplication16.stage.setOpacity(1.0f);
        });

    }
    
}
