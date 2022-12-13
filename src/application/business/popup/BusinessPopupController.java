package application.business.popup;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BusinessPopupController implements Initializable{

    @FXML
    private Button CUIButton;

    @FXML
    private FontAwesomeIconView CUIIcon;

    @FXML
    private TextField CUITextField;

    @FXML
    private Button IBANButton;

    @FXML
    private FontAwesomeIconView IBANIcon;

    @FXML
    private TextField IBANTextField;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button bankButton;

    @FXML
    private FontAwesomeIconView bankIcon;

    @FXML
    private TextField bankTextField;

    @FXML
    private Button beneficiaryButton;

    @FXML
    private FontAwesomeIconView beneficiaryIcon;

    @FXML
    private TextField beneficiaryTextField;

    @FXML
    private Button businessButton;

    @FXML
    private FontAwesomeIconView businessIcon;

    @FXML
    private TextField businessNameTextField;

    @FXML
    private Button cityButton;

    @FXML
    private FontAwesomeIconView cityIcon;

    @FXML
    private TextField cityTextField;

    @FXML
    private Button countryButton;

    @FXML
    private FontAwesomeIconView countryIcon;

    @FXML
    private TextField countryTextField;

    @FXML
    private Button countyButton;

    @FXML
    private FontAwesomeIconView countyIcon;

    @FXML
    private TextField countyTextField;

    @FXML
    private ComboBox<String> currencyComboBox;

    @FXML
    private Button emailButton;

    @FXML
    private FontAwesomeIconView emailIcon;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button euidButton;

    @FXML
    private FontAwesomeIconView euidIcon;

    @FXML
    private TextField euidTextField;

    @FXML
    private Button exchangeButton;

    @FXML
    private FontAwesomeIconView exchangeIcon;

    @FXML
    private TextField exchangeTextField;

    @FXML
    private Button exitPopup;

    @FXML
    private Button numberButton;

    @FXML
    private FontAwesomeIconView numberIcon;

    @FXML
    private TextField numberTextField;

    @FXML
    private FontAwesomeIconView passwordIcon;

    @FXML
    private Button phoneNumberButton;

    @FXML
    private FontAwesomeIconView phoneNumberIcon;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button referenceButton;

    @FXML
    private FontAwesomeIconView referenceIcon;

    @FXML
    private TextField referenceTextField;

    @FXML
    private Button saveData;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button streetButton;

    @FXML
    private FontAwesomeIconView streetIcon;

    @FXML
    private TextField streetTextField;

    @FXML
    private Button swiftButton;

    @FXML
    private FontAwesomeIconView swiftIcon;

    @FXML
    private TextField swiftTextField;

    @FXML
    private Button tradeRegisterButton;

    @FXML
    private FontAwesomeIconView tradeRegisterIcon;

    @FXML
    private TextField tradeRegisterTextField;

    @FXML
    private Button zipCodeButton;

    @FXML
    private FontAwesomeIconView zipCodeIcon;

    @FXML
    private TextField zipCodeTextField;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] currencyOptions = {"RON","EUR"};
		currencyComboBox.getItems().addAll(currencyOptions);
		
	}
    
    @FXML
    void CUIButtonClicked(ActionEvent event) {

    }

    @FXML
    void IBANButtonClicked(ActionEvent event) {

    }

    @FXML
    void bankButtonClicked(ActionEvent event) {

    }

    @FXML
    void beneficiaryButtonClicked(ActionEvent event) {

    }

    @FXML
    void businessButtonClicked(ActionEvent event) {

    }

    @FXML
    void cityButtonClicked(ActionEvent event) {

    }

    @FXML
    void countryButtonClicked(ActionEvent event) {

    }

    @FXML
    void countyButtonClicked(ActionEvent event) {

    }

    @FXML
    void emailButtonClicked(ActionEvent event) {

    }

    @FXML
    void euidButtonClicked(ActionEvent event) {

    }

    @FXML
    void exchangeButtonClicked(ActionEvent event) {

    }

    @FXML
    void exitPopupClicked(ActionEvent event) {
    	exitPopup.getScene().getWindow().hide();
    }

    @FXML
    void numberButtonClicked(ActionEvent event) {

    }

    @FXML
    void phoneNumberButtonClicked(ActionEvent event) {

    }

    @FXML
    void referenceButtonClicked(ActionEvent event) {

    }

    @FXML
    void saveDataClicked(ActionEvent event) {

    }

    @FXML
    void streetButtonClicked(ActionEvent event) {

    }

    @FXML
    void swiftButtonClicked(ActionEvent event) {

    }

    @FXML
    void tradeRegisterButtonClicked(ActionEvent event) {

    }

    @FXML
    void zipCodeButtonClicked(ActionEvent event) {

    }

	

}
