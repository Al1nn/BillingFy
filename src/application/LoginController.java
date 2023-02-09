package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.mindrot.jbcrypt.BCrypt;

import application.register.backend.LoginDatabase;
import application.utilities.DraggableWindow;
import application.utilities.ResizeWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class LoginController implements Initializable{
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
    private Text registerText;
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
    private Text errorMessage;
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		errorMessage.setVisible(false);
	}
    
	@FXML
	public void loginButtonClicked(ActionEvent event) throws IOException, ClassNotFoundException{
		LoginDatabase connection = new LoginDatabase();
		String usernameText = usernameTextField.getText();
		String passwordText = passwordTextField.getText();
		boolean fieldsEmpty = fieldsAreEmpty(usernameText, passwordText);
		if(!fieldsEmpty)
			return;
		String usernameOrEmail = null;
		
		if(isEmail(usernameText)) {
			usernameOrEmail = connection.getEmail(usernameText);
		}else {
			usernameOrEmail = connection.getUsername(usernameText);
		}
		String hashedPassword = connection.getHashedPassword(usernameText);
		
		if(checkUsername(usernameText, usernameOrEmail)  && checkPassword(passwordText, hashedPassword))
			enterApplication(event);
	}
	
	private boolean checkUsername(String usernameText, String databaseUsername) {
		if(!usernameText.equals(databaseUsername)) {
			errorMessage.setText("Username or Email is not correct");
			errorMessage.setVisible(true);
			return false;
		}
		return true;
	}
	
	private boolean isEmail(String usernameText) {
		return usernameText.contains("@");
	}

	private boolean checkPassword(String passwordText, String databasePassword) {
		boolean isPasswordCorrect = BCrypt.checkpw(passwordText, databasePassword);
		if(!isPasswordCorrect)
		{
			errorMessage.setText("Password is not correct");
			errorMessage.setVisible(true);
			return false;
		}
		return true;
	}
	
	private boolean fieldsAreEmpty(String username, String password) {
		if(username.isEmpty() || password.isEmpty()) {
			errorMessage.setText("One of the fields are empty");
			errorMessage.setVisible(true);
			return false;
		}
		return true;
		
	}
	
	private void enterApplication(ActionEvent event) throws IOException {
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
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);	
		stage.setMinWidth(1350);
		stage.setMinHeight(750);
		stage.show();
	}
	
	@FXML
    void registerTextClicked(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/register/RegisterForm.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		scene = new Scene(root);
		String registerCSS = this.getClass().getResource("/application/register/RegisterStyle.css").toExternalForm();
		scene.getStylesheets().add(registerCSS);
		window.dragWindow(root, stage);
		stage.setScene(scene);
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
