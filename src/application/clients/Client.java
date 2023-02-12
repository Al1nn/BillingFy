package application.clients;

import java.io.IOException;

import application.clients.backend.ClientDatabase;
import application.clients.popup.ClientPopupController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Client {
	
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
	private HBox buttonPane;

	public Client(String clientName, String clientCUI
			, String clientTradeRegisterNumber, String clientEUID
			, String clientCountry, String clientCity
			, String clientCounty, String clientStreet
			, String clientNumber, String clientZipCode
			, String clientEmail, String clientPhoneNumber) {
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
		String buttonStyle = this.getClass().getResource("/application/resources/material-design-skin.css")
				.toExternalForm();
		// Edit button
		Button editButton = new Button();
		styleButtons(editButton,FontAwesomeIcon.PENCIL);
		buttonFunctions(editButton);
		// Delete button
		Button deleteButton = new Button();
		styleButtons(deleteButton,FontAwesomeIcon.TRASH);

		this.setButtonPane(new HBox(editButton, deleteButton));
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
	private void buttonFunctions(Button button) {
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/clients/popup/ClientPopup.fxml"));
					//Parent root = FXMLLoader.load(getClass().getResource("/application/clients/popup/ClientPopup.fxml"));
					Parent root = loader.load();
					ClientPopupController clientPopupController = loader.getController();
					clientPopupController.setEditable(true);
					clientPopupController.initializeData(clientName, clientCUI, clientTradeRegisterNumber, clientEUID, clientCountry, clientCity, clientCounty, clientStreet, clientNumber, clientZipCode, clientEmail, clientPhoneNumber);
					Stage parentStage = (Stage) ((Node) arg0.getSource()).getScene().getWindow();
					Stage childStage = new Stage();
					String popupCSS = this.getClass().getResource("/application/clients/popup/ClientPopupStyle.css").toExternalForm();
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
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

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	public HBox getButtonPane() {
		return buttonPane;
	}

	public void setButtonPane(HBox buttonPane) {
		this.buttonPane = buttonPane;
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

}
