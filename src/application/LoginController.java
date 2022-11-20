package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class LoginController {
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
	public void loginButtonClicked(ActionEvent event) {
		passwordLabel.setText(passwordTextField.getText());
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
