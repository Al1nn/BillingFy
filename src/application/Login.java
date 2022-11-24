package application;
import application.utilities.DraggableWindow;
import application.utilities.ResizeHelper;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Login extends Application {
	//Properties
	
	//Methods
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
		
			Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			DraggableWindow window = new DraggableWindow();
			window.dragWindow(root, primaryStage);
			
			Scene scene = new Scene(root,625,600);
			scene.setRoot(root);
			String css = this.getClass().getResource("application.css").toExternalForm();
			String fontCSS = this.getClass().getResource("/application/resources/material-design-skin.css").toExternalForm();
			scene.getStylesheets().add(css);
			scene.getStylesheets().add(fontCSS);
			primaryStage.setScene(scene);
			ResizeHelper.addResizeListener(primaryStage);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
