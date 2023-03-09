package application.billings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import application.billings.popup.BillingsPopupController;
import application.clients.Client;
import application.resources.DeletePopupController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Billing {
	private String issuerName;
	private String issuerCUI;
	private String issuerTradeRegisterNumber;
	private String issuerEUID;
	private String issuerCountry;
	private String issuerCity;
	private String issuerCounty;
	private String issuerStreet;
	private String issuerNumber;
	private String issuerZipCode;
	private String issuerEmail;
	private String issuerPhoneNumber;

	private String clientName;
	private String clientCUI;
	private String clientTradeRegisterNumber;
	private String clientEUID;
	private String clientCountry;
	private String clientCity;
	private String clientCounty;
	private String clientStreet;
	private String clientNumber;
	private String clientZipCode;
	private String clientEmail;
	private String clientPhoneNumber;

	private String serviceCurrency;

	private ObservableList<BillingService> services;

	private ObservableList<BillingDiscount> discounts;

	private ObservableList<BillingTax> taxes;

	private String paymentBank;
	private String paymentBeneficiary;
	private String paymentIBAN;
	private String paymentSwift;
	private String paymentReference;
	private double paymentExchange;

	private String paymentIssueDate;
	private String paymentDueDate;
	private String paymentCurrency;
	private String paymentStatus;

	private String calculationSubtotal;
	private String calculationTax;
	private String calculationTotal;
	private HBox pane;
	private HBox statusPane;
	
	public Billing(String issuerName, String issuerCUI, String issuerTradeRegisterNumber, String issuerEUID, String issuerCountry, String issuerCity, String issuerCounty, String issuerStreet, String issuerNumber, String issuerZipCode, String issuerEmail, String issuerPhoneNumber
				, String clientName, String clientCUI, String clientTradeRegisterNumber, String clientEUID, String clientCountry, String clientCity, String clientCounty, String clientStreet, String clientNumber, String clientZipCode, String clientEmail, String clientPhoneNumber
				, String serviceCurrency
				, ObservableList<BillingService> services
				, ObservableList<BillingDiscount> discounts
				, ObservableList<BillingTax> taxes
				, String paymentBank, String paymentBeneficiary, String paymentIBAN, String paymentSwift, String paymentReference, double paymentExchange, String paymentIssueDate, String paymentDueDate, String paymentCurrency, String paymentStatus
				, String calculationSubtotal, String calculationTax, String calculationTotal
	) {

		this.issuerName = issuerName;
		this.issuerCUI = issuerCUI;
		this.issuerTradeRegisterNumber = issuerTradeRegisterNumber;
		this.issuerEUID = issuerEUID;
		this.issuerCountry = issuerCountry;
		this.issuerCity = issuerCity;
		this.issuerCounty = issuerCounty;
		this.issuerStreet = issuerStreet;
		this.issuerNumber = issuerNumber;
		this.issuerZipCode = issuerZipCode;
		this.issuerEmail = issuerEmail;
		this.issuerPhoneNumber = issuerPhoneNumber;
		this.clientName = clientName;
		this.clientCUI = clientCUI;
		this.clientTradeRegisterNumber = clientTradeRegisterNumber;
		this.clientEUID = clientEUID;
		this.clientCountry = clientCountry;
		this.clientCity = clientCity;
		this.clientCounty = clientCounty;
		this.clientStreet = clientStreet;
		this.clientNumber = clientNumber;
		this.clientZipCode = clientZipCode;
		this.clientEmail = clientEmail;
		this.clientPhoneNumber = clientPhoneNumber;
		this.serviceCurrency = serviceCurrency;
		this.services = services;
		this.discounts = discounts;
		this.taxes = taxes;
		this.paymentBank = paymentBank;
		this.paymentBeneficiary = paymentBeneficiary;
		this.paymentIBAN = paymentIBAN;
		this.paymentSwift = paymentSwift;
		this.paymentReference = paymentReference;
		this.paymentExchange = paymentExchange;
		this.paymentIssueDate = paymentIssueDate;
		this.paymentDueDate = paymentDueDate;
		this.paymentCurrency = paymentCurrency;
		this.paymentStatus = paymentStatus;
		this.calculationSubtotal = calculationSubtotal;
		this.calculationTax = calculationTax;
		this.calculationTotal = calculationTotal;
		updateStatusPane();

		//Edit button
		Button editButton = new Button();
		styleButtons(editButton,FontAwesomeIcon.PENCIL);
		editButtonFunction(editButton);
		//Delete button
		Button deleteButton = new Button();
		styleButtons(deleteButton,FontAwesomeIcon.TRASH);
		deleteButtonFunction(deleteButton);

		//Download button
		Button downloadButton = new Button();
		styleDownloadButton(downloadButton,MaterialIcon.FILE_DOWNLOAD);
		downloadButtonFunction(downloadButton);

		this.pane = new HBox(editButton,deleteButton,downloadButton);
	}
	private void updateStatusPane(){
		Circle circle = new Circle();
		Text text = new Text();
		text.setText(paymentStatus);
		circle.setRadius(10);
		if (paymentStatus.equals("Neplatit")) {
			circle.setFill(Color.web("#E25F5F"));
			text.setFill(Color.web("#E25F5F"));
		}else if(paymentStatus.equals("Platit")) {
			circle.setFill(Color.web("#41A33F"));
			text.setFill(Color.web("#41A33F"));
		}
		this.statusPane = new HBox(circle,text);
		statusPane.setSpacing(10);
	}
	private void styleButtons(Button button, FontAwesomeIcon icon){
		String buttonStyle = this.getClass().getResource("/application/resources/material-design-skin.css").toExternalForm();
		FontAwesomeIconView buttonIcon = new FontAwesomeIconView(icon);
		buttonIcon.setFill(Color.web("#547cbc"));
		buttonIcon.setSize("20");
		button.setGraphic(buttonIcon);
		button.getStylesheets().add(buttonStyle);
		setIconFills(button, buttonIcon);
	}
	private void styleDownloadButton(Button button, MaterialIcon icon){
		String buttonStyle = this.getClass().getResource("/application/resources/material-design-skin.css").toExternalForm();
		MaterialIconView buttonIcon = new MaterialIconView(icon);
		buttonIcon.setFill(Color.web("#547cbc"));
		buttonIcon.setSize("20");
		button.setGraphic(buttonIcon);
		button.getStylesheets().add(buttonStyle);
		setIconFills(button, buttonIcon);
	}
	private void setIconFills(Button button, FontAwesomeIconView buttonIcon) {
		button.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				buttonIcon.setFill(Color.WHITE);
			}
		
		});
		button.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				buttonIcon.setFill(Color.web("#547cbc"));
			}
	
		});
	}
	
	private void setIconFills(Button button, MaterialIconView buttonIcon) {
		button.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				buttonIcon.setFill(Color.WHITE);
			}
		
		});
		button.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				buttonIcon.setFill(Color.web("#547cbc"));
			}
	
		});
	}
	
	public void editButtonFunction(Button button) {
		button.setOnMouseClicked(evt -> {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/billings/popup/BillingsPopup.fxml"));
					Parent root = loader.load();
					BillingsPopupController billingsPopupController = loader.getController();
					billingsPopupController.setEditable(true);
					billingsPopupController.initializeData(issuerName,issuerCUI,issuerTradeRegisterNumber,issuerEUID,issuerCountry,issuerCity,issuerCounty,issuerStreet,issuerNumber,issuerZipCode,issuerEmail,issuerPhoneNumber
					,clientName,clientCUI,clientTradeRegisterNumber,clientEUID,clientCountry,clientCity,clientCounty,clientStreet,clientNumber,clientZipCode,clientEmail,clientPhoneNumber
					,serviceCurrency
							,services
							,discounts
							,taxes
					,paymentBank,paymentBeneficiary,paymentIBAN,paymentSwift,paymentReference,paymentExchange,paymentIssueDate,paymentDueDate,paymentCurrency,paymentStatus
					,calculationSubtotal,calculationTax,calculationTotal);
					Stage childStage = new Stage();
					String popupCSS = this.getClass().getResource("/application/billings/popup/BillingsPopupStyle.css").toExternalForm();
					String scrollPaneCSS = this.getClass().getResource("/application/resources/scrollPaneStyle.css").toExternalForm();
					Stage parentStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
					//Implement elements from parentStage

					childStage.setScene(new Scene(root));
					childStage.getScene().getStylesheets().add(popupCSS);
					childStage.getScene().getStylesheets().add(scrollPaneCSS);
					childStage.initModality(Modality.APPLICATION_MODAL);
					childStage.initOwner(parentStage);
					childStage.initStyle(StageStyle.UNDECORATED);
					childStage.show();
					double x = parentStage.getX() + (parentStage.getWidth() - childStage.getWidth()) / 2;
					double y = parentStage.getY() + (parentStage.getHeight() - childStage.getHeight()) / 2;
					childStage.setX(x);
					childStage.setY(y);
					refreshData(childStage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		);
	}
	private void refreshData(Stage childStage){
		childStage.setOnHidden(evt -> {

		});
	}
	public void deleteButtonFunction(Button button){
		button.setOnMouseClicked(evt -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/resources/DeletePopup.fxml"));
				Parent root = loader.load();
				DeletePopupController deletePopupController = loader.getController();
				deletePopupController.getDeletePopupTitle().setText("Stergere Factura");
				Stage parentStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();

				Stage childStage = new Stage();
				String popupCSS = this.getClass().getResource("/application/resources/DeletePopupStyle.css").toExternalForm();
				childStage.setScene(new Scene(root));
				childStage.getScene().getStylesheets().add(popupCSS);
				childStage.initModality(Modality.APPLICATION_MODAL);
				childStage.initOwner(parentStage);
				childStage.initStyle(StageStyle.UNDECORATED);
				childStage.show();
				double x = parentStage.getX() + (parentStage.getWidth() - childStage.getWidth()) / 2;
				double y = parentStage.getY() + (parentStage.getHeight() - childStage.getHeight()) / 2;
				childStage.setX(x);
				childStage.setY(y);
				refreshAfterDelete(childStage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	private void refreshAfterDelete(Stage childStage) {
		childStage.setOnHidden(evt -> {
			System.out.println("Not on any form");
		});
	}
	public void downloadButtonFunction(Button button){
		button.setOnMouseClicked(evt -> {
			System.out.println("Script Python on download");
		});
	}
	public JSONObject toJsonObject() throws IOException {
		JSONObject jo = new JSONObject();
		jo.put("issuerName",issuerName);
		jo.put("issuerCUI",issuerCUI);
		jo.put("issuerTradeRegisterNumber",issuerTradeRegisterNumber);
		jo.put("issuerEUID",issuerEUID);
		jo.put("issuerCountry",issuerCountry);
		jo.put("issuerCity",issuerCity);
		jo.put("issuerCounty",issuerCounty);
		jo.put("issuerStreet",issuerStreet);
		jo.put("issuerNumber",issuerNumber);
		jo.put("issuerZipCode",issuerZipCode);
		jo.put("issuerEmail",issuerEmail);
		jo.put("issuerPhoneNumber",issuerPhoneNumber);
		jo.put("clientName",clientName);
		jo.put("clientCUI",clientCUI);
		jo.put("clientTradeRegisterNumber",clientTradeRegisterNumber);
		jo.put("clientEUID",clientEUID);
		jo.put("clientCountry",clientCountry);
		jo.put("clientCity",clientCity);
		jo.put("clientCounty",clientCounty);
		jo.put("clientStreet",clientStreet);
		jo.put("clientNumber",clientNumber);
		jo.put("clientZipCode",clientZipCode);
		jo.put("clientEmail",clientEmail);
		jo.put("clientPhoneNumber",clientPhoneNumber);
		jo.put("serviceCurrency",serviceCurrency);
		JSONArray serviceJsonArray = new JSONArray();
		for (BillingService service : services){
			JSONObject serviceJsonObject = new JSONObject();
			serviceJsonObject.put("serviceID",service.getServiceID());
			serviceJsonObject.put("serviceName",service.getBillingServiceName());
			serviceJsonObject.put("serviceAmount",service.getBillingServiceAmount());
			serviceJsonObject.put("servicePrice",service.getBillingServicePrice());
			serviceJsonObject.put("serviceDescription",service.getBillingServiceDescription());
			serviceJsonArray.add(serviceJsonObject);
		}
		jo.put("services",serviceJsonArray);
		JSONArray discountJsonArray = new JSONArray();
		for (BillingDiscount discount : discounts){
			JSONObject discountJsonObject = new JSONObject();
			discountJsonObject.put("discountID",discount.getDiscountID());
			discountJsonObject.put("discountName",discount.getBillingDiscountName());
			discountJsonObject.put("discountPercentage",discount.getBillingDiscountPercentage());
			discountJsonArray.add(discountJsonObject);
		}
		jo.put("discounts",discountJsonArray);
		JSONArray taxesJsonArray = new JSONArray();
		for (BillingTax tax : taxes){
			JSONObject taxJsonObject = new JSONObject();
			taxJsonObject.put("taxID",tax.getTaxID());
			taxJsonObject.put("taxName",tax.getBillingTaxName());
			taxJsonObject.put("taxValue",tax.getBillingTaxValue());
			taxesJsonArray.add(taxJsonObject);
		}
		jo.put("taxes",taxesJsonArray);
		jo.put("paymentBank",paymentBank);
		jo.put("paymentBeneficiary",paymentBeneficiary);
		jo.put("paymentIBAN",paymentIBAN);
		jo.put("paymentSwift",paymentSwift);
		jo.put("paymentReference",paymentReference);
		jo.put("paymentExchange",paymentExchange);
		jo.put("paymentIssueDate",paymentIssueDate);
		jo.put("paymentDueDate",paymentDueDate);
		jo.put("paymentCurrency",paymentCurrency);
		jo.put("paymentStatus",paymentStatus);
		jo.put("calculationSubtotal",calculationSubtotal);
		jo.put("calculationTax",calculationTax);
		jo.put("calculationTotal",calculationTotal);

		FileWriter file = new FileWriter("../Billings.json");

		file.write(jo.toJSONString());

		file.close();
		return jo;
	}
	public void fromJsonObject(JSONObject jo) throws IOException, ParseException {
		 this.issuerName = (String) jo.get("issuerName");
		 this.issuerCUI = (String) jo.get("issuerCUI");
		 this.issuerTradeRegisterNumber = (String) jo.get("issuerTradeRegisterNumber");
		 this.issuerEUID = (String) jo.get("issuerEUID");
		 this.issuerCountry = (String) jo.get("issuerCountry");
		 this.issuerCity = (String) jo.get("issuerCity");
		 this.issuerCounty = (String) jo.get("issuerCounty");
		 this.issuerStreet = (String) jo.get("issuerStreet");
		 this.issuerNumber = (String) jo.get("issuerNumber");
		 this.issuerZipCode = (String) jo.get("issuerZipCode");
		 this.issuerEmail = (String) jo.get("issuerEmail");
		 this.issuerPhoneNumber = (String) jo.get("issuerPhoneNumber");
		 this.clientName = (String) jo.get("clientName");
		 this.clientCUI = (String) jo.get("clientCUI");
		 this.clientTradeRegisterNumber = (String) jo.get("clientTradeRegisterNumber");
		 this.clientEUID = (String) jo.get("clientEUID");
		 this.clientCountry = (String) jo.get("clientCountry");
		 this.clientCity = (String) jo.get("clientCity");
		 this.clientCounty = (String) jo.get("clientCounty");
		 this.clientStreet = (String) jo.get("clientStreet");
		 this.clientNumber = (String) jo.get("clientNumber");
		 this.clientZipCode = (String) jo.get("clientZipCode");
		 this.clientEmail = (String) jo.get("clientEmail");
		 this.clientPhoneNumber = (String) jo.get("clientPhoneNumber");
		 this.serviceCurrency = (String) jo.get("serviceCurrency");
		 JSONArray servicesArray = (JSONArray) jo.get("services");
		 for (int i = 0; i < servicesArray.size() ; i++){
			 JSONObject serviceObject = (JSONObject) servicesArray.get(i);
			 String serviceID = (String) serviceObject.get("serviceID");
			 String serviceName = (String) serviceObject.get("serviceName");
			 int serviceAmount = (int) serviceObject.get("serviceAmount");
			 double servicePrice = (double) serviceObject.get("servicePrice");
			 String serviceDescription = (String) serviceObject.get("serviceDescription");
			 BillingService billingService = new BillingService(serviceID,serviceName,serviceAmount,servicePrice,serviceDescription);
			 this.services.add(billingService);
		 }
		 JSONArray discountsArray = (JSONArray) jo.get("discounts");
		 for (int i = 0 ; i < discountsArray.size() ; i++){
			 JSONObject discountObject = (JSONObject) discountsArray.get(i);
			 String discountID = (String) discountObject.get("discountID");
			 String discountName = (String) discountObject.get("discountName");
			 int discountPercentage = (int) discountObject.get("discountPercentage");
			 BillingDiscount billingDiscount = new BillingDiscount(discountID,discountName,discountPercentage);
			 this.discounts.add(billingDiscount);
		 }
		 JSONArray taxesArray = (JSONArray) jo.get("taxes");
		 for (int i = 0 ; i < taxesArray.size(); i++){
			 JSONObject taxObject = (JSONObject) taxesArray.get(i);
			 String taxID = (String) taxObject.get("taxID");
			 String taxName = (String) taxObject.get("taxName");
			 double taxValue = (double) taxObject.get("taxValue");
			 BillingTax billingTax = new BillingTax(taxID,taxName,taxValue);
			 this.taxes.add(billingTax);
		 }
		 this.paymentBank = (String) jo.get("paymentBank");
		 this.paymentBeneficiary = (String) jo.get("paymentBeneficiary");
		 this.paymentIBAN = (String) jo.get("paymentIBAN");
		 this.paymentSwift = (String) jo.get("paymentSwift");
		 this.paymentReference = (String) jo.get("paymentReference");
		 this.paymentExchange = (double) jo.get("paymentExchange");
		 this.paymentIssueDate = (String) jo.get("paymentIssueDate");
		 this.paymentDueDate = (String) jo.get("paymentDueDate");
		 this.paymentCurrency = (String) jo.get("paymentCurrency");
		 this.paymentStatus = (String) jo.get("paymentStatus");
		 this.calculationSubtotal = (String) jo.get("calculationSubtotal");
		 this.calculationTax = (String) jo.get("calculationTax");
		 this.calculationTotal = (String) jo.get("calculationTotal");

	}
	public HBox getPane() {
		return pane;
	}

	public void setPane(HBox pane) {
		this.pane = pane;
	}

	public HBox getStatusPane() {
		return statusPane;
	}

	public void setStatusPane(HBox statusPane) {
		this.statusPane = statusPane;
	}

	public String getIssuerName() {
		return issuerName;
	}


	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}


	public String getIssuerCUI() {
		return issuerCUI;
	}


	public void setIssuerCUI(String issuerCUI) {
		this.issuerCUI = issuerCUI;
	}

	public String getIssuerTradeRegisterNumber() {
		return issuerTradeRegisterNumber;
	}

	public void setIssuerTradeRegisterNumber(String issuerTradeRegisterNumber) {
		this.issuerTradeRegisterNumber = issuerTradeRegisterNumber;
	}

	public String getIssuerEUID() {
		return issuerEUID;
	}

	public void setIssuerEUID(String issuerEUID) {
		this.issuerEUID = issuerEUID;
	}

	public String getIssuerCountry() {
		return issuerCountry;
	}

	public void setIssuerCountry(String issuerCountry) {
		this.issuerCountry = issuerCountry;
	}

	public String getIssuerCity() {
		return issuerCity;
	}

	public void setIssuerCity(String issuerCity) {
		this.issuerCity = issuerCity;
	}

	public String getIssuerCounty() {
		return issuerCounty;
	}

	public void setIssuerCounty(String issuerCounty) {
		this.issuerCounty = issuerCounty;
	}

	public String getIssuerStreet() {
		return issuerStreet;
	}

	public void setIssuerStreet(String issuerStreet) {
		this.issuerStreet = issuerStreet;
	}

	public String getIssuerNumber() {
		return issuerNumber;
	}

	public void setIssuerNumber(String issuerNumber) {
		this.issuerNumber = issuerNumber;
	}

	public String getIssuerZipCode() {
		return issuerZipCode;
	}

	public void setIssuerZipCode(String issuerZipCode) {
		this.issuerZipCode = issuerZipCode;
	}

	public String getIssuerEmail() {
		return issuerEmail;
	}

	public void setIssuerEmail(String issuerEmail) {
		this.issuerEmail = issuerEmail;
	}

	public String getIssuerPhoneNumber() {
		return issuerPhoneNumber;
	}

	public void setIssuerPhoneNumber(String issuerPhoneNumber) {
		this.issuerPhoneNumber = issuerPhoneNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientCUI() {
		return clientCUI;
	}

	public void setClientCUI(String clientCUI) {
		this.clientCUI = clientCUI;
	}

	public String getClientTradeRegisterNumber() {
		return clientTradeRegisterNumber;
	}

	public void setClientTradeRegisterNumber(String clientTradeRegisterNumber) {
		this.clientTradeRegisterNumber = clientTradeRegisterNumber;
	}

	public String getClientEUID() {
		return clientEUID;
	}

	public void setClientEUID(String clientEUID) {
		this.clientEUID = clientEUID;
	}

	public String getClientCountry() {
		return clientCountry;
	}

	public void setClientCountry(String clientCountry) {
		this.clientCountry = clientCountry;
	}

	public String getClientCity() {
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	public String getClientCounty() {
		return clientCounty;
	}

	public void setClientCounty(String clientCounty) {
		this.clientCounty = clientCounty;
	}

	public String getClientStreet() {
		return clientStreet;
	}

	public void setClientStreet(String clientStreet) {
		this.clientStreet = clientStreet;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getClientZipCode() {
		return clientZipCode;
	}

	public void setClientZipCode(String clientZipCode) {
		this.clientZipCode = clientZipCode;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	public String getServiceCurrency() {
		return serviceCurrency;
	}

	public void setServiceCurrency(String serviceCurrency) {
		this.serviceCurrency = serviceCurrency;
	}

	public ObservableList<BillingService> getServices() {
		return services;
	}

	public void setServices(ObservableList<BillingService> services) {
		this.services = services;
	}

	public ObservableList<BillingDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(ObservableList<BillingDiscount> discounts) {
		this.discounts = discounts;
	}

	public ObservableList<BillingTax> getTaxes() {
		return taxes;
	}

	public void setTaxes(ObservableList<BillingTax> taxes) {
		this.taxes = taxes;
	}

	public String getPaymentBank() {
		return paymentBank;
	}

	public void setPaymentBank(String paymentBank) {
		this.paymentBank = paymentBank;
	}

	public String getPaymentBeneficiary() {
		return paymentBeneficiary;
	}

	public void setPaymentBeneficiary(String paymentBeneficiary) {
		this.paymentBeneficiary = paymentBeneficiary;
	}

	public String getPaymentIBAN() {
		return paymentIBAN;
	}

	public void setPaymentIBAN(String paymentIBAN) {
		this.paymentIBAN = paymentIBAN;
	}

	public String getPaymentSwift() {
		return paymentSwift;
	}

	public void setPaymentSwift(String paymentSwift) {
		this.paymentSwift = paymentSwift;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public double getPaymentExchange() {
		return paymentExchange;
	}

	public void setPaymentExchange(double paymentExchange) {
		this.paymentExchange = paymentExchange;
	}

	public String getPaymentIssueDate() {
		return paymentIssueDate;
	}

	public void setPaymentIssueDate(String paymentIssueDate) {
		this.paymentIssueDate = paymentIssueDate;
	}

	public String getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getCalculationSubtotal() {
		return calculationSubtotal;
	}

	public void setCalculationSubtotal(String calculationSubtotal) {
		this.calculationSubtotal = calculationSubtotal;
	}

	public String getCalculationTax() {
		return calculationTax;
	}

	public void setCalculationTax(String calculationTax) {
		this.calculationTax = calculationTax;
	}

	public String getCalculationTotal() {
		return calculationTotal;
	}

	public void setCalculationTotal(String calculationTotal) {
		this.calculationTotal = calculationTotal;
	}


}
