package application.billings.popup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.billings.BillingDiscount;
import application.billings.BillingService;
import application.billings.BillingTax;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class BillingsPopupController implements Initializable{

    @FXML
    private Button addDiscountButton;

    @FXML
    private FontAwesomeIconView addDiscountIcon;

    @FXML
    private Button addServiceButton;

    @FXML
    private FontAwesomeIconView addServiceIcon;

    @FXML
    private FontAwesomeIconView addTaxIcon;

    @FXML
    private Button addTaxesButton;

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
    private FontAwesomeIconView clientPhoneNumberIcon;

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
    private Button exitPopup;

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
    private Text paymentCurrency;

    @FXML
    private ComboBox<String> paymentCurrencyCmbBox;

    @FXML
    private Text paymentStatus;

    @FXML
    private ComboBox<String> paymentStatusCmbBox;

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
    private Button saveData;

    @FXML
    private ComboBox<String> serviceCurrencyCmbBox;;
    
    @FXML
    private ScrollPane serviceScrollPane;
    
    @FXML 
    private GridPane serviceContentPane;
    
    private int serviceButtonPressed = 1;
    
    @FXML
    private ScrollPane discountScrollPane;
    
    @FXML
    private GridPane discountContentPane;
    
    private int discountButtonPressed = 1;
    
    @FXML
    private ScrollPane taxScrollPane;
    
    @FXML
    private GridPane taxContentPane;

    @FXML
    private Text billingPopupTitle;

    private int taxButtonPressed = 1;

    private boolean isEditable;

    private TextField billingServiceNameField;
    private TextField billingServiceAmountField;
    private TextField billingPriceField;
    private TextField billingDescriptionField;

    private TextField billingDiscountNameField;
    private TextField billingDiscountPercentageField;

    private TextField billingTaxNameField;
    private TextField billingTaxValueField;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] clientNameOptions = {"Alin","Romy","Ionut","Edi"};
		String[] issuerNameOptions = {"Endava","IBM","ALL TECHNOLOGIES"};
        String[] currencyOptions = {"RON","EUR"};
        String[] statusOptions = {"Neplatit","Platit"};
    	clientNameCmbBox.getItems().addAll(clientNameOptions);
    	issuerNameCmbBox.getItems().addAll(issuerNameOptions);
        paymentCurrencyCmbBox.getItems().addAll(currencyOptions);
        paymentStatusCmbBox.getItems().addAll(statusOptions);
        serviceCurrencyCmbBox.getItems().addAll(currencyOptions);
    	try {
            serviceContentPane = new GridPane();
			Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsServiceContent.fxml"));
			String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsServiceContentStyle.css").toExternalForm();
			root.getStylesheets().add(contentCSS);
			serviceContentPane.addRow(0, root);
			serviceScrollPane.setContent(serviceContentPane);
			serviceScrollPane.setFitToWidth(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	try {
            discountContentPane = new GridPane();
			Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsDiscountContent.fxml"));
			String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsDiscountContentStyle.css").toExternalForm();
			root.getStylesheets().add(contentCSS);
			discountContentPane.addRow(0, root);
			discountScrollPane.setContent(discountContentPane);
			discountScrollPane.setFitToWidth(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	try {
            taxContentPane = new GridPane();
			Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsTaxContent.fxml"));
			String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsTaxContentStyle.css").toExternalForm();
			root.getStylesheets().add(contentCSS);
			taxContentPane.addRow(0, root);
			taxScrollPane.setContent(taxContentPane);
			taxScrollPane.setFitToWidth(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public void initializeData(String issuerName, String issuerCUI, String issuerTradeRegisterNumber, String issuerEUID, String issuerCountry, String issuerCity, String issuerCounty, String issuerStreet, String issuerNumber, String issuerZipCode, String issuerEmail, String issuerPhoneNumber
            , String clientName, String clientCUI, String clientTradeRegisterNumber, String clientEUID, String clientCountry, String clientCity, String clientCounty, String clientStreet, String clientNumber, String clientZipCode, String clientEmail, String clientPhoneNumber
            , String serviceCurrency
            , ObservableList<BillingService> services
            , ObservableList<BillingDiscount> discounts
            , ObservableList<BillingTax> taxes
            , String paymentBank, String paymentBeneficiary, String paymentIBAN, String paymentSwift, String paymentReference, double paymentExchange, String paymentIssueDate, String paymentDueDate, String paymentCurrency, String paymentStatus
            , String calculationSubtotal, String calculationTax, String calculationTotal) throws IOException {
        issuerNameCmbBox.setValue(issuerName);
        issuerCUITextField.setText(issuerCUI);
        issuerRegisterNumberField.setText(issuerTradeRegisterNumber);
        issuerEUIDField.setText(issuerEUID);
        issuerCountryField.setText(issuerCountry);
        issuerCityField.setText(issuerCity);
        issuerCountyField.setText(issuerCounty);
        issuerStreetField.setText(issuerStreet);
        issuerNumberField.setText(issuerNumber);
        issuerZipCodeField.setText(issuerZipCode);
        issuerEmailField.setText(issuerEmail);
        issuerPhoneNumberField.setText(issuerPhoneNumber);
        clientNameCmbBox.setValue(clientName);
        clientCUITextField.setText(clientCUI);
        clientRegisterNumberField.setText(clientTradeRegisterNumber);
        clientEUIDField.setText(clientEUID);
        clientCountryField.setText(clientCountry);
        clientCityField.setText(clientCity);
        clientCountyField.setText(clientCounty);
        clientStreetField.setText(clientStreet);
        clientNumberField.setText(clientNumber);
        clientZipCodeField.setText(clientZipCode);
        clientEmailField.setText(clientEmail);
        clientPhoneNumberField.setText(clientPhoneNumber);
        serviceCurrencyCmbBox.setValue(serviceCurrency);
        serviceContentPane.getChildren().clear();
        for (int i = 0 * serviceButtonPressed; i < services.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/billings/popup/BillingsServiceContent.fxml"));
            Parent root = loader.load();
            String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsServiceContentStyle.css").toExternalForm();
            root.getStylesheets().add(contentCSS);
            billingServiceNameField = (TextField) root.lookup("#billingServiceNameField");
            billingServiceAmountField = (TextField) root.lookup("#billingServiceAmountField");
            billingPriceField = (TextField) root.lookup("#billingPriceField");
            billingDescriptionField = (TextField) root.lookup("#billingDescriptionField");
            billingServiceNameField.setText(services.get(i).getBillingServiceName());
            billingServiceAmountField.setText(String.valueOf(services.get(i).getBillingServiceAmount()));
            billingPriceField.setText(String.valueOf(services.get(i).getBillingServicePrice()));
            billingDescriptionField.setText(services.get(i).getBillingServiceDescription());
            serviceContentPane.addRow(i,root);
        }

        discountContentPane.getChildren().clear();
        for(int i = 0 ; i < discounts.size(); i++){
            Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsDiscountContent.fxml"));
            String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsDiscountContentStyle.css").toExternalForm();
            root.getStylesheets().add(contentCSS);
            billingDiscountNameField = (TextField) root.lookup("#billingDiscountNameField");
            billingDiscountPercentageField = (TextField) root.lookup("#billingDiscountPercentageField");
            billingDiscountNameField.setText(discounts.get(i).getBillingDiscountName());
            billingDiscountPercentageField.setText(String.valueOf(discounts.get(i).getBillingDiscountPercentage()));
            discountContentPane.addRow(i, root);
        }
        taxContentPane.getChildren().clear();

        for(int i = 0 ; i < taxes.size(); i++){
            Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsTaxContent.fxml"));
            String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsTaxContentStyle.css").toExternalForm();
            root.getStylesheets().add(contentCSS);
            billingTaxNameField = (TextField) root.lookup("#billingTaxNameField");
            billingTaxValueField = (TextField) root.lookup("#billingTaxValueField");
            billingTaxNameField.setText(taxes.get(i).getBillingTaxName());
            billingTaxValueField.setText(String.valueOf(taxes.get(i).getBillingTaxValue()));
            taxContentPane.addRow(i, root);
        }
        paymentBankField.setText(paymentBank);
        paymentBeneficiaryField.setText(paymentBeneficiary);
        paymentIBANField.setText(paymentIBAN);
        paymentSwiftField.setText(paymentSwift);
        paymentReferenceField.setText(paymentReference);
        paymentExchangeField.setText(String.valueOf(paymentExchange));
        paymentIssueDateField.setText(paymentIssueDate);
        paymentDueDateField.setText(paymentDueDate);
        paymentCurrencyCmbBox.setValue(paymentCurrency);
        paymentStatusCmbBox.setValue(paymentStatus);
        calculationSubtotalField.setText(calculationSubtotal);
        calculationTaxField.setText(calculationTax);
        calculationTotalField.setText(calculationTotal);
    }

    @FXML
    void addDiscountButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsDiscountContent.fxml"));
    	String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsDiscountContentStyle.css").toExternalForm();
    	root.getStylesheets().add(contentCSS);
        discountButtonPressed++;
    	discountContentPane.addRow(discountButtonPressed, root);
        System.out.println("Discount Button Pressed : " + discountButtonPressed);
    }

    @FXML
    void addServiceButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsServiceContent.fxml"));
    	String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsServiceContentStyle.css").toExternalForm();
    	root.getStylesheets().add(contentCSS);
        serviceButtonPressed++;
    	serviceContentPane.addRow(serviceButtonPressed, root);
        System.out.println("Service Button Pressed : "+serviceButtonPressed);
    }

    @FXML
    void addTaxesButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsTaxContent.fxml"));
    	String contentCSS = this.getClass().getResource("/application/billings/popup/BillingsTaxContentStyle.css").toExternalForm();
    	root.getStylesheets().add(contentCSS);
        taxButtonPressed++;
    	taxContentPane.addRow(taxButtonPressed, root);
        System.out.println("Tax button pressed : " + taxButtonPressed);
    }

    @FXML
    void calculationSubtotalButtonClicked(ActionEvent event) {
    	calculationSubtotalField.clear();
    }

    @FXML
    void calculationTaxButtonClicked(ActionEvent event) {
    	calculationTaxField.clear();
    }

    @FXML
    void calculationTotalButtonClicked(ActionEvent event) {
    	calculationTotalField.clear();
    }

    @FXML
    void clientCUIButtonClicked(ActionEvent event) {
    	clientCUITextField.clear();
    }

    @FXML
    void clientCityButtonClicked(ActionEvent event) {
    	clientCityField.clear();
    }

    @FXML
    void clientCountryButtonClicked(ActionEvent event) {
    	clientCountryField.clear();
    }

    @FXML
    void clientCountyButtonClicked(ActionEvent event) {
    	clientCountyField.clear();
    }

    @FXML
    void clientEUIDButtonClicked(ActionEvent event) {
    	clientEUIDField.clear();
    }

    @FXML
    void clientEmailButtonClicked(ActionEvent event) {
    	clientEmailField.clear();
    }

    @FXML
    void clientNumberButtonClicked(ActionEvent event) {
    	clientNumberField.clear();
    }

    @FXML
    void clientPhoneNumberButtonClicked(ActionEvent event) {
    	clientPhoneNumberField.clear();
    }

    @FXML
    void clientRegisterNumberButtonClicked(ActionEvent event) {
    	clientRegisterNumberField.clear();
    }

    @FXML
    void clientStreetButtonClicked(ActionEvent event) {
    	clientStreetField.clear();
    }

    @FXML
    void clientZipCodeButtonClicked(ActionEvent event) {
    	clientZipCodeField.clear();
    }

    @FXML
    void exitButtonClicked(ActionEvent event) {
    	exitButton.getScene().getWindow().hide();
    }

    @FXML
    void exitPopupClicked(ActionEvent event) {
    	exitPopup.getScene().getWindow().hide();
    }

    @FXML
    void issuerCUIButtonClicked(ActionEvent event) {
    	issuerCUITextField.clear();
    }

    @FXML
    void issuerCityButtonClicked(ActionEvent event) {
    	issuerCityField.clear();
    }

    @FXML
    void issuerCountryButtonClicked(ActionEvent event) {
    	issuerCountryField.clear();
    }

    @FXML
    void issuerCountyButtonClicked(ActionEvent event) {
    	issuerCountyField.clear();
    }

    @FXML
    void issuerEUIDButtonClicked(ActionEvent event) {
    	issuerEUIDField.clear();
    }	

    @FXML
    void issuerEmailButtonClicked(ActionEvent event) {
    	issuerEmailField.clear();
    }

    @FXML
    void issuerNumberButtonClicked(ActionEvent event) {
    	issuerNumberField.clear();
    }

    @FXML
    void issuerPhoneNumberButtonClicked(ActionEvent event) {
    	issuerPhoneNumberField.clear();
    }

    @FXML
    void issuerRegisterNumberButtonClicked(ActionEvent event) {
    	issuerRegisterNumberField.clear();
    }

    @FXML
    void issuerStreetButtonClicked(ActionEvent event) {
    	issuerStreetField.clear();
    }

    @FXML
    void issuerZipCodeButtonClicked(ActionEvent event) {
    	issuerZipCodeField.clear();
    }

    @FXML
    void paymentBankButtonClicked(ActionEvent event) {
    	paymentBankField.clear();
    }

    @FXML
    void paymentBeneficiaryButtonClicked(ActionEvent event) {
    	paymentBeneficiaryField.clear();
    }

    @FXML
    void paymentDueDateButtonClicked(ActionEvent event) {
    	paymentDueDateField.clear();
    }

    @FXML
    void paymentExchangeButtonClicked(ActionEvent event) {
    	paymentExchangeField.clear();
    }

    @FXML
    void paymentIBANButtonClicked(ActionEvent event) {
    	paymentIBANField.clear();
    }

    @FXML
    void paymentIssueDateButtonClicked(ActionEvent event) {
    	paymentIssueDateField.clear();
    }

    @FXML
    void paymentReferenceButtonClicked(ActionEvent event) {
    	paymentReferenceField.clear();
    }

    @FXML
    void paymentSwiftButtonClicked(ActionEvent event) {
    	paymentSwiftField.clear();
    }

    @FXML
    void saveDataClicked(ActionEvent event) throws ClassNotFoundException {

    	if(!isEditable){
            String issuerName = issuerNameCmbBox.getValue();
            String issuerCUI = issuerCUITextField.getText();
            String issuerTradeRegisterNumber = issuerRegisterNumberField.getText();
            String issuerEUID = issuerEUIDField.getText();
            String issuerCountry = issuerCountryField.getText();
            String issuerCity = issuerCityField.getText();
            String issuerCounty = issuerCountyField.getText();
            String issuerStreet = issuerStreetField.getText();
            String issuerNumber = issuerNumberField.getText();
            String issuerZipCode = issuerZipCodeField.getText();
            String issuerEmail = issuerEmailField.getText();
            String issuerPhoneNumber = issuerPhoneNumberField.getText();
            String clientName = clientNameCmbBox.getValue();
            String clientCUI = clientCUITextField.getText();
            String clientTradeRegisterNumber = clientRegisterNumberField.getText();
            String clientEUID = clientEUIDField.getText();
            String clientCountry = clientCountryField.getText();
            String clientCity = clientCityField.getText();
            String clientCounty = clientCountyField.getText();
            String clientStreet = clientStreetField.getText();
            String clientNumber = clientNumberField.getText();
            String clientZipCode = clientZipCodeField.getText();
            String clientEmail = clientEmailField.getText();
            String clientPhoneNumber = clientPhoneNumberField.getText();
            String serviceCurrency = serviceCurrencyCmbBox.getValue();
            for (Node node : serviceContentPane.getChildren()) {
                billingServiceNameField = (TextField) node.lookup("#billingServiceNameField");
                billingServiceAmountField = (TextField) node.lookup("#billingServiceAmountField");
                billingPriceField = (TextField) node.lookup("#billingPriceField");
                billingDescriptionField = (TextField) node.lookup("#billingDescriptionField");
                String billingServiceName = billingServiceNameField.getText();
                String billingServiceAmount = billingServiceAmountField.getText();
                String billingServicePrice = billingPriceField.getText();
                String billingServiceDescription = billingDescriptionField.getText();

            }
            for (Node node: discountContentPane.getChildren()) {
                billingDiscountNameField = (TextField) node.lookup("#billingDiscountNameField");
                billingDiscountPercentageField = (TextField) node.lookup("#billingDiscountPercentageField");
                String billingDiscountName = billingDiscountNameField.getText();
                String billingDiscountPercentage = billingDiscountPercentageField.getText();

            }
            for (Node node : taxContentPane.getChildren()) {
                billingTaxNameField = (TextField) node.lookup("#billingTaxNameField");
                billingTaxValueField = (TextField) node.lookup("#billingTaxValueField");
                String billingTaxName = billingTaxNameField.getText();
                String billingTaxValue = billingTaxValueField.getText();

            }
            String paymentBank = paymentBankField.getText();
            String paymentBeneficiary = paymentBeneficiaryField.getText();
            String paymentIBAN = paymentIBANField.getText();
            String paymentSwift = paymentSwiftField.getText();
            String paymentReference = paymentReferenceField.getText();
            String paymentExchange = paymentExchangeField.getText();
            String paymentIssueDate = paymentIssueDateField.getText();
            String paymentDueDate = paymentDueDateField.getText();
            String paymentCurrency = paymentCurrencyCmbBox.getValue();
            String paymentStatus = paymentStatusCmbBox.getValue();
            String calculationSubtotal = calculationSubtotalField.getText();
            String calculationTax = calculationTaxField.getText();
            String calculationTotal = calculationTotalField.getText();

            saveData.getScene().getWindow().hide();
        }
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        billingPopupTitle.setText("Editare Factura");
        addServiceButton.setVisible(false);
        addDiscountButton.setVisible(false);
        addTaxesButton.setVisible(false);
        isEditable = editable;
    }
}
