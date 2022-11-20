package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;



public class Login extends Application {
	
	//Properties
	private double xOffset = 0;
	private double yOffset = 0;
	
	//Methods
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
		
			Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
			primaryStage.initStyle(StageStyle.TRANSPARENT);
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
			
			Scene scene = new Scene(root,625,600);
			scene.setRoot(root);
			String css = this.getClass().getResource("application.css").toExternalForm();
			String fontCSS = this.getClass().getResource("/application/resources/material-design-skin.css").toExternalForm();
			scene.getStylesheets().add(css);
			scene.getStylesheets().add(fontCSS);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
