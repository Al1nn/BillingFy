package application.services;

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

public class Service {
	private String servicesNumber;
	private String servicesName;
	private String servicesDescription;
	private String servicesPrice;
	private HBox buttonPane;
	
	public Service(String servicesNumber, String servicesName, String servicesDescription, String servicesPrice) {
		this.setServicesNumber(servicesNumber);
		this.setServicesName(servicesName);
		this.setServicesDescription(servicesDescription);
		this.setServicesPrice(servicesPrice);
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
					Parent root = FXMLLoader.load(getClass().getResource("/application/services/popup/ServicesPopup.fxml"));
					String popupCSS = this.getClass().getResource("/application/services/popup/ServicesPopupStyle.css").toExternalForm();
					String scrollPaneCSS = this.getClass().getResource("/application/resources/scrollPaneStyle.css").toExternalForm();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.getScene().getStylesheets().add(popupCSS);
					stage.getScene().getStylesheets().add(scrollPaneCSS);
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
	
	public HBox getButtonPane() {
		return buttonPane;
	}

	public void setButtonPane(HBox buttonPane) {
		this.buttonPane = buttonPane;
	}

	public String getServicesPrice() {
		return servicesPrice;
	}

	public void setServicesPrice(String servicesPrice) {
		this.servicesPrice = servicesPrice;
	}

	public String getServicesNumber() {
		return servicesNumber;
	}

	public void setServicesNumber(String servicesNumber) {
		this.servicesNumber = servicesNumber;
	}

	public String getServicesName() {
		return servicesName;
	}

	public void setServicesName(String servicesName) {
		this.servicesName = servicesName;
	}

	public String getServicesDescription() {
		return servicesDescription;
	}

	public void setServicesDescription(String servicesDescription) {
		this.servicesDescription = servicesDescription;
	}

}
