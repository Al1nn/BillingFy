package application;
import java.io.IOException;

import application.utilities.DraggableWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class LoginController{
	@FXML
	private Button loginButton; 
	@FXML 
	private Text textLabel;
	@FXML 
	private AnchorPane anchorPane;
	@FXML 
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML 
	private Rectangle rectangleForm;
	@FXML
	private Text passwordLabel;
	@FXML
	private Text usernameLabel;
	@FXML
	private Button usernameButton;
	@FXML
	private Button passwordButton;
	@FXML 
	private Parent root;
	@FXML
	protected Stage stage;
	@FXML
	protected Scene scene;
	@FXML
	public void loginButtonClicked(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("/application/billings/Billings.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		scene = new Scene(root);
		String billingCSS = this.getClass().getResource("/application/billings/BillingStyle.css").toExternalForm();
		scene.getStylesheets().add(billingCSS);
		window.dragWindow(root, stage);
		window.fullscreenWindow(scene, stage);
		stage.setFullScreenExitHint("");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
		}
	
	@FXML
	public void exitButtonClicked(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML
	public void usernameButtonClicked(ActionEvent event) {
		usernameTextField.clear();
	}
	@FXML
	public void passwordButtonClicked(ActionEvent event) {
		passwordTextField.clear();
	}
}
