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
	private String businessNumber;
	private String businessName;
	private String businessCountry;
	private String businessCity;
	private String businessZipCode;
	private String businessEmail;
	private String businessPhoneNumber;
	private HBox buttonPane;
	
	
	public Business(String businessNumber, String businessName, String businessCountry, String businessCity, String businessZipCode, String businessEmail, String businessPhoneNumber) {
		this.businessNumber = businessNumber;
		this.businessName = businessName;
		this.businessCountry = businessCountry;
		this.businessCity = businessCity;
		this.businessZipCode = businessZipCode;
		this.businessEmail = businessEmail;
		this.businessPhoneNumber = businessPhoneNumber;

		// Edit button
		Button editButton = new Button();
		styleButtons(editButton,FontAwesomeIcon.PENCIL);
		buttonFunctions(editButton);
		// Delete button
		Button deleteButton = new Button();
		styleButtons(deleteButton,FontAwesomeIcon.TRASH);

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
	
	public void buttonFunctions(Button button) {
		button.setOnMouseClicked(evt -> {
			try {
				FXMLLoader loader =  new FXMLLoader(getClass().getResource("/application/business/popup/BusinessPopup.fxml"));
				Parent root = loader.load();
				BusinessPopupController businessPopupController = loader.getController();
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

}
