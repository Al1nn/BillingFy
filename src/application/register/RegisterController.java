package application.register;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.utilities.DraggableWindow;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController implements Initializable{

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Rectangle rectangleForm;
    
    @FXML
    private Button exitButton;

    @FXML
    private Button registerBackButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button registerEmailButton;

    @FXML
    private FontAwesomeIconView registerEmailIcon;

    @FXML
    private Text registerEmailLabel;

    @FXML
    private TextField registerEmailTextField;

    @FXML
    private Button registerPasswordButton;

    @FXML
    private FontAwesomeIconView registerPasswordIcon;

    @FXML
    private Text registerPasswordLabel;

    @FXML
    private PasswordField registerPasswordTextField;

    @FXML
    private Button registerUsernameButton;

    @FXML
    private FontAwesomeIconView registerUsernameIcon;

    @FXML
    private Text registerUsernameLabel;

    @FXML
    private TextField registerUsernameTextField;

    @FXML
    private Text registerMessage;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	registerMessage.setVisible(false);
		
	}
    @FXML
    void registerBackButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/LoginForm.fxml"));
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		Scene scene = new Scene(root);
		String registerCSS = this.getClass().getResource("/application/application.css").toExternalForm();
		scene.getStylesheets().add(registerCSS);
		window.dragWindow(root, stage);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void exitButtonClicked(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void registerButtonClicked(ActionEvent event) {
    		
    }

    @FXML
    void registerEmailButtonClicked(ActionEvent event) {
    	registerEmailTextField.clear();
    }

    @FXML
    void registerPasswordButtonClicked(ActionEvent event) {
    	registerPasswordTextField.clear();
    }

    @FXML
    void registerUsernameButtonClicked(ActionEvent event) {
    	registerUsernameTextField.clear();
    }

	

}
