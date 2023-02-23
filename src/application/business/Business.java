package application.business;

import java.io.IOException;

import application.business.popup.BusinessPopupController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Business {
	private String businessName;
	private String businessCUI;
	private String businessTradeRegisterNumber;
	private String businessEUID;
	private String businessCountry;
	private String businessCity;
	private String businessCounty;
	private String businessStreet;
	private String businessNumber;
	private String businessZipCode;
	private String businessEmail;
	private String businessPhoneNumber;
	private String businessPaymentBank;
	private String businessPaymentBeneficiary;
	private String businessPaymentIBAN;
	private String businessPaymentSwift;
	private String businessPaymentReference;
	private String businessPaymentExchange;
	private String businessPaymentCurrency;

	private HBox buttonPane;
	
	
	public Business(String businessName, String businessCUI, String businessTradeRegisterNumber, String businessEUID, String businessCountry, String businessCity, String businessCounty, String businessStreet, String businessNumber, String businessZipCode, String businessEmail, String businessPhoneNumber
	, String businessPaymentBank, String businessPaymentBeneficiary, String businessPaymentIBAN, String businessPaymentSwift, String businessPaymentReference, String businessPaymentExchange, String businessPaymentCurrency) {
		this.businessName = businessName;
		this.businessCUI = businessCUI;
		this.businessTradeRegisterNumber = businessTradeRegisterNumber;
		this.businessEUID = businessEUID;
		this.businessCountry = businessCountry;
		this.businessCity = businessCity;
		this.businessCounty = businessCounty;
		this.businessStreet = businessStreet;
		this.businessNumber = businessNumber;
		this.businessZipCode = businessZipCode;
		this.businessEmail = businessEmail;
		this.businessPhoneNumber = businessPhoneNumber;
		this.businessPaymentBank = businessPaymentBank;
		this.businessPaymentBeneficiary = businessPaymentBeneficiary;
		this.businessPaymentIBAN = businessPaymentIBAN;
		this.businessPaymentSwift = businessPaymentSwift;
		this.businessPaymentReference = businessPaymentReference;
		this.businessPaymentExchange = businessPaymentExchange;
		this.businessPaymentCurrency = businessPaymentCurrency;

		// Edit button
		Button editButton = new Button();
		styleButtons(editButton,FontAwesomeIcon.PENCIL);
		editButtonFunction(editButton);
		// Delete button
		Button deleteButton = new Button();
		styleButtons(deleteButton,FontAwesomeIcon.TRASH);
		deleteButtonFunction(deleteButton);
		this.setButtonPane(new HBox(editButton,deleteButton));
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
	
	private void editButtonFunction(Button button) {
		button.setOnMouseClicked(evt -> {
			try {
				FXMLLoader loader =  new FXMLLoader(getClass().getResource("/application/business/popup/BusinessPopup.fxml"));
				Parent root = loader.load();
				BusinessPopupController businessPopupController = loader.getController();
				businessPopupController.setEditable(true);
				businessPopupController.initializeData(businessName,businessCUI,businessTradeRegisterNumber,businessEUID,businessCountry,businessCity,businessCounty,businessStreet,businessNumber,businessZipCode,businessEmail,businessPhoneNumber,businessPaymentBank,businessPaymentBeneficiary,businessPaymentIBAN,businessPaymentSwift,businessPaymentReference,businessPaymentExchange,businessPaymentCurrency);
				Stage parentStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
				Stage childStage = new Stage();
				String popupCSS = this.getClass().getResource("/application/business/popup/BusinessPopupStyle.css").toExternalForm();
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
				refreshData(childStage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	private void deleteButtonFunction(Button button){
		button.setOnMouseClicked(evt -> {
			System.out.println("Delete popup opened !");
		});
	}
	private void refreshData(Stage childStage){

	}
	public String getBusinessNumber() {
		return businessNumber;
	}


	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public String getBusinessCountry() {
		return businessCountry;
	}


	public void setBusinessCountry(String businessCountry) {
		this.businessCountry = businessCountry;
	}


	public String getBusinessCity() {
		return businessCity;
	}


	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}


	public String getBusinessZipCode() {
		return businessZipCode;
	}


	public void setBusinessZipCode(String businessZipCode) {
		this.businessZipCode = businessZipCode;
	}


	public String getBusinessEmail() {
		return businessEmail;
	}


	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}


	public String getBusinessPhoneNumber() {
		return businessPhoneNumber;
	}


	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhoneNumber = businessPhoneNumber;
	}


	public HBox getButtonPane() {
		return buttonPane;
	}


	public void setButtonPane(HBox buttonPane) {
		this.buttonPane = buttonPane;
	}

	public String getBusinessCUI() {
		return businessCUI;
	}

	public void setBusinessCUI(String businessCUI) {
		this.businessCUI = businessCUI;
	}

	public String getBusinessTradeRegisterNumber() {
		return businessTradeRegisterNumber;
	}

	public void setBusinessTradeRegisterNumber(String businessTradeRegisterNumber) {
		this.businessTradeRegisterNumber = businessTradeRegisterNumber;
	}

	public String getBusinessEUID() {
		return businessEUID;
	}

	public void setBusinessEUID(String businessEUID) {
		this.businessEUID = businessEUID;
	}

	public String getBusinessCounty() {
		return businessCounty;
	}

	public void setBusinessCounty(String businessCounty) {
		this.businessCounty = businessCounty;
	}

	public String getBusinessStreet() {
		return businessStreet;
	}

	public void setBusinessStreet(String businessStreet) {
		this.businessStreet = businessStreet;
	}

	public String getBusinessPaymentBank() {
		return businessPaymentBank;
	}

	public void setBusinessPaymentBank(String businessPaymentBank) {
		this.businessPaymentBank = businessPaymentBank;
	}

	public String getBusinessPaymentBeneficiary() {
		return businessPaymentBeneficiary;
	}

	public void setBusinessPaymentBeneficiary(String businessPaymentBeneficiary) {
		this.businessPaymentBeneficiary = businessPaymentBeneficiary;
	}

	public String getBusinessPaymentIBAN() {
		return businessPaymentIBAN;
	}

	public void setBusinessPaymentIBAN(String businessPaymentIBAN) {
		this.businessPaymentIBAN = businessPaymentIBAN;
	}

	public String getBusinessPaymentSwift() {
		return businessPaymentSwift;
	}

	public void setBusinessPaymentSwift(String businessPaymentSwift) {
		this.businessPaymentSwift = businessPaymentSwift;
	}

	public String getBusinessPaymentReference() {
		return businessPaymentReference;
	}

	public void setBusinessPaymentReference(String businessPaymentReference) {
		this.businessPaymentReference = businessPaymentReference;
	}

	public String getBusinessPaymentExchange() {
		return businessPaymentExchange;
	}

	public void setBusinessPaymentExchange(String businessPaymentExchange) {
		this.businessPaymentExchange = businessPaymentExchange;
	}

	public String getBusinessPaymentCurrency() {
		return businessPaymentCurrency;
	}

	public void setBusinessPaymentCurrency(String businessPaymentCurrency) {
		this.businessPaymentCurrency = businessPaymentCurrency;
	}
}
