import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;


public class RandomizedRectsController {

    @FXML
    private Canvas canv;
    private CanvasUtiles _canvasUtiles;
    private static final double FILL_PERCENT = 10;
    
    @FXML
    void initialize() {
    	_canvasUtiles = new CanvasUtiles(canv);
    	_canvasUtiles.CreateMatrix();
    }


    @FXML
    void btnPressed(ActionEvent event) {
    	_canvasUtiles.ClearCanvas();
    	_canvasUtiles.CreateMatrix();
    	_canvasUtiles.FillRandomRects(FILL_PERCENT);
    }
}
