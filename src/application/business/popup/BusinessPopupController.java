package application.business.popup;

import java.net.URL;
import java.util.ResourceBundle;

import application.business.Business;
import application.business.backend.BusinessDatabase;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
    private Text businessTitle;
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

    private String oldBusinessName;
    private String oldBusinessNumber;
    private boolean isEditable;
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] currencyOptions = {"RON","EUR"};
		currencyComboBox.getItems().addAll(currencyOptions);
		
	}
    public void initializeData(String businessName, String businessCUI, String businessTradeRegisterNumber,
                               String businessEUID, String businessCountry, String businessCity,
                               String businessCounty, String businessStreet, String businessNumber,
                               String businessZipCode, String businessEmail, String businessPhoneNumber,
                               String businessPaymentBank, String businessPaymentBeneficiary,
                               String businessPaymentIBAN, String businessPaymentSwift,
                               String businessPaymentReference, String businessPaymentExchange,
                               String businessPaymentCurrency){
        businessNameTextField.setText(businessName);
        CUITextField.setText(businessCUI);
        tradeRegisterTextField.setText(businessTradeRegisterNumber);
        euidTextField.setText(businessEUID);
        countryTextField.setText(businessCountry);
        cityTextField.setText(businessCity);
        countyTextField.setText(businessCounty);
        streetTextField.setText(businessStreet);
        numberTextField.setText(businessNumber);
        zipCodeTextField.setText(businessZipCode);
        emailTextField.setText(businessEmail);
        phoneNumberTextField.setText(businessPhoneNumber);
        bankTextField.setText(businessPaymentBank);
        beneficiaryTextField.setText(businessPaymentBeneficiary);
        IBANTextField.setText(businessPaymentIBAN);
        swiftTextField.setText(businessPaymentSwift);
        referenceTextField.setText(businessPaymentReference);
        exchangeTextField.setText(businessPaymentExchange);
        currencyComboBox.setValue(businessPaymentCurrency);
        oldBusinessName = businessName;
        oldBusinessNumber = businessNumber;
    }
    @FXML
    void CUIButtonClicked(ActionEvent event) {
    	CUITextField.clear();
    }

    @FXML
    void IBANButtonClicked(ActionEvent event) {
    	IBANTextField.clear();
    }

    @FXML
    void bankButtonClicked(ActionEvent event) {
    	bankTextField.clear();
    }

    @FXML
    void beneficiaryButtonClicked(ActionEvent event) {
    	beneficiaryTextField.clear();
    }

    @FXML
    void businessButtonClicked(ActionEvent event) {
    	businessNameTextField.clear();
    }

    @FXML
    void cityButtonClicked(ActionEvent event) {
    	cityTextField.clear();
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
    void exchangeButtonClicked(ActionEvent event) {
    	exchangeTextField.clear();
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
    void referenceButtonClicked(ActionEvent event) {
    	referenceTextField.clear();
    }

    @FXML
    void saveDataClicked(ActionEvent event) throws ClassNotFoundException {
        String businessName = businessNameTextField.getText();
        String businessCUI = CUITextField.getText();
        String businessTradeRegisterNumber = tradeRegisterTextField.getText();
        String businessEUID = euidTextField.getText();
        String businessCountry = countryTextField.getText();
        String businessCity = cityTextField.getText();
        String businessCounty = countyTextField.getText();
        String businessStreet = streetTextField.getText();
        String businessNumber = numberTextField.getText();
        String businessZipCode = zipCodeTextField.getText();
        String businessEmail = emailTextField.getText();
        String businessPhoneNumber = phoneNumberTextField.getText();
        String businessPaymentBank = bankTextField.getText();
        String businessPaymentBeneficiary = beneficiaryTextField.getText();
        String businessPaymentIBAN = IBANTextField.getText();
        String businessPaymentSwift = swiftTextField.getText();
        String businessPaymentReference = referenceTextField.getText();
        String businessPaymentExchange = exchangeTextField.getText();
        String businessPaymentCurrency = currencyComboBox.getValue().toString();
        if (!isEditable){
            BusinessDatabase connection = new BusinessDatabase();
            connection.insertData(businessName,businessCUI
                    ,businessTradeRegisterNumber,businessEUID
                    ,businessCountry,businessCity
                    ,businessCounty,businessStreet
                    ,businessNumber,businessZipCode
                    ,businessEmail,businessPhoneNumber
                    ,businessPaymentBank,businessPaymentBeneficiary
                    ,businessPaymentIBAN,businessPaymentSwift
                    ,businessPaymentReference,businessPaymentExchange
                    ,businessPaymentCurrency);
            saveData.getScene().getWindow().hide();
            return;
        }
        BusinessDatabase connection = new BusinessDatabase();
        connection.updateData(businessName,businessCUI
        ,businessTradeRegisterNumber,businessEUID
        ,businessCountry,businessCity
        ,businessCounty, businessStreet
        ,businessNumber, businessZipCode
        ,businessEmail, businessPhoneNumber
        ,businessPaymentBank, businessPaymentBeneficiary
        ,businessPaymentIBAN, businessPaymentSwift
        ,businessPaymentReference, businessPaymentExchange
        ,businessPaymentCurrency,oldBusinessName,oldBusinessNumber);
        saveData.getScene().getWindow().hide();
    }

    @FXML
    void streetButtonClicked(ActionEvent event) {
    	streetTextField.clear();
    }

    @FXML
    void swiftButtonClicked(ActionEvent event) {
    	swiftTextField.clear();
    }

    @FXML
    void tradeRegisterButtonClicked(ActionEvent event) {
    	tradeRegisterTextField.clear();
    }

    @FXML
    void zipCodeButtonClicked(ActionEvent event) {
    	zipCodeTextField.clear();
    }


    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        this.isEditable = editable;
        businessTitle.setText("Editare Firma");
    }
}
