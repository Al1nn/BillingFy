package application.utilities;


import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class ResizeWindow {
	private double xOffset = 0; 
	private double yOffset = 0; 
	private double x = 0;
	private double y = 0;
	private final int padding = 15;
	public void resizeWindow(Parent root, Stage primaryStage) {
		root.getScene().setOnMousePressed(event -> {
			x = event.getSceneX();
			y = event.getSceneY();
			if(x < primaryStage.getWidth() - padding && y < primaryStage.getHeight() - padding) return;
			xOffset = primaryStage.getWidth() - x;
			yOffset = primaryStage.getHeight() - y; 
		});
		
		root.getScene().setOnMouseDragged(event -> {
		    if (event.getX() >= primaryStage.getMinWidth() - padding
		            && event.getY() >= primaryStage.getMinHeight() - padding
		            && event.getX() < primaryStage.getMaxWidth() + padding
		            && event.getY() < primaryStage.getMaxHeight() + padding){
		          primaryStage.setWidth(event.getX() + xOffset);
		          primaryStage.setHeight(event.getY() + yOffset);
		        }
		        // Change cursor to indicate resizing
		        root.getScene().setCursor(Cursor.SE_RESIZE);
		});
		
		root.getScene().setOnMouseReleased(event -> {
			root.getScene().setCursor(Cursor.DEFAULT);
		});
		primaryStage.show();
	}
	

}
