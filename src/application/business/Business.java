package application.business;

import java.io.IOException;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.EventHandler;
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
		String buttonStyle = this.getClass().getResource("/application/resources/material-design-skin.css")
				.toExternalForm();
		// Edit button
		Button editButton = new Button();
		FontAwesomeIconView editButtonIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
		editButtonIcon.setFill(Color.web("#547cbc"));
		editButtonIcon.setSize("20");
		editButton.setGraphic(editButtonIcon);
		editButton.getStylesheets().add(buttonStyle);
		setIconFills(editButton, editButtonIcon);
		buttonFunctions(editButton);
		// Delete button
		Button deleteButton = new Button();
		FontAwesomeIconView deleteButtonIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
		deleteButtonIcon.setFill(Color.web("#547cbc"));
		deleteButtonIcon.setSize("20");
		deleteButton.setGraphic(deleteButtonIcon);
		deleteButton.getStylesheets().add(buttonStyle);
		setIconFills(deleteButton, deleteButtonIcon);
		this.setButtonPane(new HBox(editButton,deleteButton));
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
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/business/popup/BusinessPopup.fxml"));
					Stage stage = new Stage();
					String popupCSS = this.getClass().getResource("/application/business/popup/BusinessPopupStyle.css").toExternalForm();
					stage.setScene(new Scene(root));
					stage.getScene().getStylesheets().add(popupCSS);
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner((Stage) ((Node) arg0.getSource()).getScene().getWindow());
					stage.initStyle(StageStyle.UNDECORATED);
					stage.centerOnScreen();
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
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
