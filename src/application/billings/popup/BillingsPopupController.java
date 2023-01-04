package application.billings.popup;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BillingsPopupController implements Initializable{

    @FXML
    private Button clientCUIButton;

    @FXML
    private FontAwesomeIconView clientCUIIcon;

    @FXML
    private TextField clientCUITextField;

    @FXML
    private Button clientCityButton;

    @FXML
    private TextField clientCityField;

    @FXML
    private FontAwesomeIconView clientCityIcon;

    @FXML
    private Button clientCountryButton;

    @FXML
    private TextField clientCountryField;

    @FXML
    private FontAwesomeIconView clientCountryIcon;

    @FXML
    private Button clientCountyButton;

    @FXML
    private TextField clientCountyField;

    @FXML
    private FontAwesomeIconView clientCountyIcon;

    @FXML
    private Button clientEUIDButton;

    @FXML
    private TextField clientEUIDField;

    @FXML
    private FontAwesomeIconView clientEUIDIcon;

    @FXML
    private Button clientEmailButton;

    @FXML
    private TextField clientEmailField;

    @FXML
    private FontAwesomeIconView clientEmailIcon;

    @FXML
    private ComboBox<String> clientNameCmbBox;

    @FXML
    private Button clientNumberButton;

    @FXML
    private TextField clientNumberField;

    @FXML
    private FontAwesomeIconView clientNumberIcon;

    @FXML
    private Button clientPhoneNumberButton;

    @FXML
    private TextField clientPhoneNumberField;

    @FXML
    private Button clientRegisterNumberButton;

    @FXML
    private TextField clientRegisterNumberField;

    @FXML
    private FontAwesomeIconView clientRegisterNumberIcon;

    @FXML
    private Button clientStreetButton;

    @FXML
    private TextField clientStreetField;

    @FXML
    private FontAwesomeIconView clientStreetIcon;

    @FXML
    private Button clientZipCodeButton;

    @FXML
    private TextField clientZipCodeField;

    @FXML
    private FontAwesomeIconView clientZipCodeIcon;

    @FXML
    private Button exitButton;

    @FXML
    private FontAwesomeIconView exitButtonIcon;

    @FXML
    private Button issuerCUIButton;

    @FXML
    private FontAwesomeIconView issuerCUIIcon;

    @FXML
    private TextField issuerCUITextField;

    @FXML
    private Button issuerCityButton;

    @FXML
    private TextField issuerCityField;

    @FXML
    private FontAwesomeIconView issuerCityIcon;

    @FXML
    private Button issuerCountryButton;

    @FXML
    private TextField issuerCountryField;

    @FXML
    private FontAwesomeIconView issuerCountryIcon;

    @FXML
    private Button issuerCountyButton;

    @FXML
    private TextField issuerCountyField;

    @FXML
    private FontAwesomeIconView issuerCountyIcon;

    @FXML
    private Button issuerEUIDButton;

    @FXML
    private TextField issuerEUIDField;

    @FXML
    private FontAwesomeIconView issuerEUIDIcon;

    @FXML
    private Button issuerEmailButton;

    @FXML
    private TextField issuerEmailField;

    @FXML
    private FontAwesomeIconView issuerEmailIcon;

    @FXML
    private ComboBox<String> issuerNameCmbBox;

    @FXML
    private Button issuerNumberButton;

    @FXML
    private TextField issuerNumberField;

    @FXML
    private FontAwesomeIconView issuerNumberIcon;

    @FXML
    private Button issuerPhoneNumberButton;

    @FXML
    private TextField issuerPhoneNumberField;

    @FXML
    private FontAwesomeIconView issuerPhoneNumberIcon;

    @FXML
    private FontAwesomeIconView issuerPhoneNumberIcon1;

    @FXML
    private Button issuerRegisterNumberButton;

    @FXML
    private TextField issuerRegisterNumberField;

    @FXML
    private FontAwesomeIconView issuerRegisterNumberIcon;

    @FXML
    private Button issuerStreetButton;

    @FXML
    private TextField issuerStreetField;

    @FXML
    private FontAwesomeIconView issuerStreetIcon;

    @FXML
    private Button issuerZipCodeButton;

    @FXML
    private TextField issuerZipCodeField;

    @FXML
    private FontAwesomeIconView issuerZipCodeIcon;
    
    @FXML
    private ComboBox<String> serviceExchangeCmbBox;
    
    @FXML
    private Button paymentBankButton;

    @FXML
    private TextField paymentBankField;

    @FXML
    private FontAwesomeIconView paymentBankIcon;

    @FXML
    private Button paymentBeneficiaryButton;

    @FXML
    private TextField paymentBeneficiaryField;

    @FXML
    private FontAwesomeIconView paymentBeneficiaryIcon;

    @FXML
    private Button paymentDueDateButton;

    @FXML
    private TextField paymentDueDateField;

    @FXML
    private FontAwesomeIconView paymentDueDateIcon;

    @FXML
    private Button paymentExchangeButton;

    @FXML
    private TextField paymentExchangeField;

    @FXML
    private FontAwesomeIconView paymentExchangeIcon;

    @FXML
    private Button paymentIBANButton;

    @FXML
    private TextField paymentIBANField;

    @FXML
    private FontAwesomeIconView paymentIBANIcon;

    @FXML
    private Button paymentIIssueDateButton;

    @FXML
    private Button paymentIReferenceButton;

    @FXML
    private TextField paymentIssueDateField;

    @FXML
    private FontAwesomeIconView paymentIssueDateIcon;

    @FXML
    private TextField paymentReferenceField;

    @FXML
    private FontAwesomeIconView paymentReferenceIcon;

    @FXML
    private Button paymentSwiftButton;

    @FXML
    private TextField paymentSwiftField;

    @FXML
    private FontAwesomeIconView paymentSwiftIcon;
    
    @FXML
    private ComboBox<String> paymentCurrencyCmbBox;
    
    @FXML
    private Button calculationSubtotalButton;

    @FXML
    private TextField calculationSubtotalField;

    @FXML
    private FontAwesomeIconView calculationSubtotalIcon;

    @FXML
    private Button calculationTaxButton;

    @FXML
    private TextField calculationTaxField;

    @FXML
    private FontAwesomeIconView calculationTaxIcon;

    @FXML
    private Button calculationTotalButton;

    @FXML
    private TextField calculationTotalField;

    @FXML
    private FontAwesomeIconView calculationTotalIcon;
    
    @FXML
    private Button exitPopup;
    
    @FXML
    private Button saveData;
    
    @FXML
    private Button addServiceButton;
    
    @FXML
    private Button addDiscountButton;
    
    @FXML
    private Button addTaxesButton;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] issuerNameOptions = {"ALL IN TECHNOLOGIES","Endava","UPIT"};
		String[] clientNameOptions = {"Alin","Romy","Ionut"};
		String[] serviceExchangeOptions = {"RON","EUR","USD"};
		issuerNameCmbBox.getItems().addAll(issuerNameOptions);
		clientNameCmbBox.getItems().addAll(clientNameOptions);
		serviceExchangeCmbBox.getItems().addAll(serviceExchangeOptions);
		paymentCurrencyCmbBox.getItems().addAll(serviceExchangeOptions);
    }
    
    @FXML
    void addDiscountButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void addTaxesButtonClicked(ActionEvent event) {
    	
    }
    
    @FXML
    void addServiceButtonClicked(ActionEvent event) {
    	
    }
    
    @FXML
    void clientCUIButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientCityButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientCountryButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientCountyButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientEUIDButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientEmailButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientNumberButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientPhoneNumberButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientRegisterNumberButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientStreetButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientZipCodeButtonClicked(ActionEvent event) {

    }

    @FXML
    void exitButtonClicked(ActionEvent event) {
    	exitButton.getScene().getWindow().hide();
    }

    @FXML
    void issuerCUIButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerCityButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerCountryButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerCountyButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerEUIDButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerEmailButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerNumberButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerPhoneNumberButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerRegisterNumberButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerStreetButtonClicked(ActionEvent event) {

    }

    @FXML
    void issuerZipCodeButtonClicked(ActionEvent event) {

    }

    @FXML
    void paymentBankButtonClicked(ActionEvent event) {

    }

    @FXML
    void paymentBeneficiaryButtonClicked(ActionEvent event) {

    }

    @FXML
    void paymentDueDateButtonClicked(ActionEvent event) {

    }

    @FXML
    void paymentExchangeButtonClicked(ActionEvent event) {

    }

    @FXML
    void paymentIBANButtonClicked(ActionEvent event) {

    }

    @FXML
    void paymentIssueDateButtonClicked(ActionEvent event) {

    }

    @FXML
    void paymentReferenceButtonClicked(ActionEvent event) {

    }

    @FXML
    void paymentSwiftButtonClicked(ActionEvent event) {

    }

    @FXML
    void calculationSubtotalButtonClicked(ActionEvent event) {

    }

    @FXML
    void calculationTaxButtonClicked(ActionEvent event) {

    }

    @FXML
    void calculationTotalButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void exitPopupClicked(ActionEvent event) {
    	exitPopup.getScene().getWindow().hide();
    }
    
    @FXML
    void saveDataClicked(ActionEvent event) {

    }
    
}
