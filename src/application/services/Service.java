package application.services;

import java.io.IOException;

import application.services.popup.ServicesPopupController;
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

public class Service {
	private String serviceName;
	private String serviceAmount;
	private String servicePrice;
	private String serviceCurrency;
	private String serviceDescription;
	private String serviceNumber;
	private HBox buttonPane;
	
	public Service(String serviceName, String serviceAmount, String servicePrice, String serviceCurrency, String serviceDescription, String serviceNumber) {
		this.serviceName = serviceName;
		this.serviceAmount = serviceAmount;
		this.servicePrice = servicePrice;
		this.serviceCurrency = serviceCurrency;
		this.serviceDescription = serviceDescription;
		this.serviceNumber = serviceNumber;
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
		button.setOnMouseClicked(evt -> {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/services/popup/ServicesPopup.fxml"));
					Parent root = loader.load();
					ServicesPopupController servicesPopupController = loader.getController();
					servicesPopupController.setEditable(true);
					servicesPopupController.setInvisibleAdd();
					servicesPopupController.initializeData(serviceName,serviceAmount,servicePrice,serviceCurrency,serviceDescription,serviceNumber);
					Stage parentStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
					String popupCSS = this.getClass().getResource("/application/services/popup/ServicesPopupStyle.css").toExternalForm();
					String scrollPaneCSS = this.getClass().getResource("/application/resources/scrollPaneStyle.css").toExternalForm();
					Stage childStage = new Stage();
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		);
	}


	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(String serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public String getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}

	public String getServiceCurrency() {
		return serviceCurrency;
	}

	public void setServiceCurrency(String serviceCurrency) {
		this.serviceCurrency = serviceCurrency;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public HBox getButtonPane() {
		return buttonPane;
	}

	public void setButtonPane(HBox buttonPane) {
		this.buttonPane = buttonPane;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
}
