package application.utilities;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class DraggableWindow {
	private double xOffset;
	private double yOffset;
	private final int padding = 25;
	public void dragWindow(Parent root, Stage primaryStage) {
		 root.setOnMousePressed(event -> {
			 if (event.getSceneX() <= padding || event.getSceneX() >=  root.getScene().getWidth() - padding ||
				event.getSceneY() <= padding || event.getSceneY() >= root.getScene().getHeight() - padding) {
				return;
			}
		      xOffset = event.getSceneX();
		      yOffset = event.getSceneY();
		    });

		 root.setOnMouseDragged(event -> {
			 if (event.getSceneX() <= padding || event.getSceneX() >=  root.getScene().getWidth() - padding ||
						event.getSceneY() <= padding || event.getSceneY() >= root.getScene().getHeight() - padding) {
						return;
					}
		      primaryStage.setX(event.getScreenX() - xOffset);
		      primaryStage.setY(event.getScreenY() - yOffset);
		    });
	}
	public void fullscreenWindow(Scene scene, Stage stage) {
		scene.setOnKeyPressed(e ->{
			if(e.getCode() == KeyCode.ENTER)
				stage.setFullScreen(true);
		});
	}

	
}
