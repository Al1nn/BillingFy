package application.utilities;

import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class DraggableWindow {
	private double xOffset;
	private double yOffset;
	
	public void dragWindow(Parent root, Stage primaryStage) {
		 root.setOnMousePressed(event -> {
			 if(!event.isPrimaryButtonDown() || event.getTarget() instanceof Button)
				 return;
		      xOffset = event.getSceneX();
		      yOffset = event.getSceneY();
		    });

		 root.setOnMouseDragged(event -> {
			 if(!event.isPrimaryButtonDown() || event.getTarget() instanceof Button)
				 return;
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
