package application.clients.popup;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ClientPopupController {
    @FXML
    private Button CUIButton;

    @FXML
    private FontAwesomeIconView CUIIcon;

    @FXML
    private Text CUILabel;

    @FXML
    private TextField CUITextField;

    @FXML
    private Button cityButton;

    @FXML
    private FontAwesomeIconView cityIcon;

    @FXML
    private Text cityLabel;

    @FXML
    private TextField cityTextField;

    @FXML
    private Button clientButton;

    @FXML
    private FontAwesomeIconView clientIcon;

    @FXML
    private Text clientLabel;

    @FXML
    private TextField clientNameTextField;

    @FXML
    private Button countryButton;

    @FXML
    private FontAwesomeIconView countryIcon;

    @FXML
    private Text countryLabel;

    @FXML
    private TextField countryTextField;

    @FXML
    private Button countyButton;

    @FXML
    private FontAwesomeIconView countyIcon;

    @FXML
    private Text countyLabel;

    @FXML
    private TextField countyTextField;

    @FXML
    private Button emailButton;

    @FXML
    private FontAwesomeIconView emailIcon;

    @FXML
    private Text emailLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button euidButton;

    @FXML
    private FontAwesomeIconView euidIcon;

    @FXML
    private Text euidLabel;

    @FXML
    private TextField euidTextField;

    @FXML
    private Button exitPopup;

    @FXML
    private Button numberButton;

    @FXML
    private FontAwesomeIconView numberIcon;

    @FXML
    private Text numberLabel;

    @FXML
    private TextField numberTextField;

    @FXML
    private FontAwesomeIconView passwordIcon;

    @FXML
    private Button phoneNumberButton;

    @FXML
    private FontAwesomeIconView phoneNumberIcon;

    @FXML
    private Text phoneNumberLabel;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button saveData;

    @FXML
    private Button streetButton;

    @FXML
    private FontAwesomeIconView streetIcon;

    @FXML
    private Text streetLabel;

    @FXML
    private TextField streetTextField;

    @FXML
    private Button tradeRegisterButton;

    @FXML
    private FontAwesomeIconView tradeRegisterIcon;

    @FXML
    private Text tradeRegisterLabel;

    @FXML
    private TextField tradeRegisterTextField;

    @FXML
    private Button zipCodeButton;

    @FXML
    private FontAwesomeIconView zipCodeIcon;

    @FXML
    private Text zipCodeLabel;

    @FXML
    private TextField zipCodeTextField;

    @FXML
    void CUIButtonClicked(ActionEvent event) {
    	CUITextField.clear();
    }

    @FXML
    void cityButtonClicked(ActionEvent event) {
    	cityTextField.clear();
    }

    @FXML
    void clientButtonClicked(ActionEvent event) {
    	clientNameTextField.clear();
    }

    @FXML
    void countryButtonClicked(ActionEvent event) {
    	countryTextField.clear();
    }

    @FXML
    void countyButtonClicked(ActionEvent event) {
    	countyTextField.clear();
    }

    @FXML
    void emailButtonClicked(ActionEvent event) {
    	emailTextField.clear();
    }	

    @FXML
    void euidButtonClicked(ActionEvent event) {
    	euidTextField.clear();
    }

    @FXML
    void exitPopupClicked(ActionEvent event) {
    	exitPopup.getScene().getWindow().hide();
    }

    @FXML
    void numberButtonClicked(ActionEvent event) {
    	numberTextField.clear();
    }

    @FXML
    void phoneNumberButtonClicked(ActionEvent event) {
    	phoneNumberTextField.clear();
    }

    @FXML
    void saveDataClicked(ActionEvent event) {
    	saveData.getScene().getWindow().hide();
    }

    @FXML
    void streetButtonClicked(ActionEvent event) {
    	streetTextField.clear();
    }

    @FXML
    void tradeRegisterButtonClicked(ActionEvent event) {
    	tradeRegisterTextField.clear();
    }

    @FXML
    void zipCodeButtonClicked(ActionEvent event) {
    	zipCodeTextField.clear();
    }
}