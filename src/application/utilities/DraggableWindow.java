package application.utilities;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class DraggableWindow {
	private double xOffset;
	private double yOffset;
	
	public void dragWindow(Parent root, Stage primaryStage) {
		root.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getSceneY() - yOffset);
			}
		});
	}
	public void fullscreenWindow(Scene scene, Stage stage) {
		scene.setOnKeyPressed(e ->{
			if(e.getCode() == KeyCode.ENTER)
				stage.setFullScreen(true);
		});
	}
	
}
