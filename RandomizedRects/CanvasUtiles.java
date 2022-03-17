import java.security.SecureRandom;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/*
 *  CanvasUtiles provides canvas utilities such as generating a matrix 
 *  and fill selected percentage of rectangles for a given canvas element.
 */
public class CanvasUtiles {
	
	private GraphicsContext _gc;
	private int _canvWidth;
	private int _canvHeight;
    private static final SecureRandom _randomNumbers = new SecureRandom();
    private static final int SIZE_OF_RECT = 10;
	
	public CanvasUtiles(Canvas canv) {
		_gc = canv.getGraphicsContext2D();
		_canvWidth = (int) canv.getWidth();
		_canvHeight = (int) canv.getHeight();
	}

	// create the vertical and horizontal lines of the matrix.
	public void CreateMatrix() {
		for(int i = 0; i <= _canvWidth; i+=SIZE_OF_RECT) {
    		_gc.strokeLine(i, 0, i, _canvHeight);
    	}
    	
    	for(int i = 0; i <= _canvHeight; i+=SIZE_OF_RECT) {
    		_gc.strokeLine(0, i, _canvWidth, i);
    	}
	}
	
	// fill the canvas with {0} percentage of rectangles.
	public void FillRandomRects(double fillPercentage) {
		
		if(fillPercentage > 100){
			System.out.println("Rectangels fill percentage has to be less then 100");
			return;
		}
		
		int numberOfRects = (int) (_canvWidth *_canvHeight /SIZE_OF_RECT*SIZE_OF_RECT);
		
		// contain the index of each random rectangle that will be filled.
    	int[] randomIndexes = new int[(int) ((numberOfRects/100)*fillPercentage)];
    	
    	
    	// fill randomIndexes will unique values. 
    	for(int i = 0; i < randomIndexes.length; i++) {
    		int rand;

    		do {
    			rand = _randomNumbers.nextInt(numberOfRects);
    		}while(ArrayContains(randomIndexes, rand));
    		
    		randomIndexes[i] = rand;
    	}
    	
    	// fill rectangle in the canvas for each index
    	for(int i = 0; i < randomIndexes.length; i++) {
    		int rectsInRow = (int) (_canvWidth/10);
    		
    		// the Row and Column that matches the index
    		int rectRow = (int) (randomIndexes[i]/rectsInRow);
    		int rectColumn = (int) (randomIndexes[i]%rectsInRow);
    		
    		_gc.fillRect(rectColumn*SIZE_OF_RECT, rectRow*SIZE_OF_RECT, SIZE_OF_RECT, SIZE_OF_RECT);
    	}
	}
	
	// clear the canvas
	public void ClearCanvas() {
		_gc.clearRect(0, 0, _canvWidth, _canvHeight);
	}
	
	// check if array{0} contains {1}
	private boolean ArrayContains(int [] arr, int num) {
    	for(int i = 0; i < arr.length ; i++) {
    		if(arr[i] == num) 
    			return true;	
    	}
    	
    	return false;
    }
}
