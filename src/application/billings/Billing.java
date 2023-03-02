package application.billings;

import java.io.IOException;

import application.billings.popup.BillingsPopupController;
import application.clients.Client;
import application.resources.DeletePopupController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
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
	private String billingNumber;
	private String billingClient;
	private String billingIssueDate;
	private String billingDueDate;
	private String billingSum;
	private String billingTax;
	private String billingTotal;
	private String billingStatus;
	
	private HBox pane;
	private HBox statusPane;
	
	public Billing(String billingNumber, String billingClient
			, String billingIssueDate, String billingDueDate
			, String billingSum, String billingTax
			, String billingTotal, String billingStatus
			) {
		this.billingNumber = billingNumber;
		this.billingClient = billingClient;
		this.billingIssueDate = billingIssueDate;
		this.billingDueDate = billingDueDate;
		this.billingSum = billingSum;
		this.billingTax = billingTax;
		this.billingTotal = billingTotal;
		this.billingStatus = billingStatus;

		updateStatusPane(this.billingStatus);

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
	private void updateStatusPane(String billingStatus){
		Circle circle = new Circle();
		Text text = new Text();
		text.setText(billingStatus);
		circle.setRadius(10);
		if (billingStatus == "Neplatit") {
			circle.setFill(Color.web("#E25F5F"));
			text.setFill(Color.web("#E25F5F"));
		}else if(billingStatus == "Platit") {
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

					Stage stage = new Stage();
					String popupCSS = this.getClass().getResource("/application/billings/popup/BillingsPopupStyle.css").toExternalForm();
					String scrollPaneCSS = this.getClass().getResource("/application/resources/scrollPaneStyle.css").toExternalForm();
					Stage parentStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
					//Implement elements from parentStage

					stage.setScene(new Scene(root));
					stage.getScene().getStylesheets().add(popupCSS);
					stage.getScene().getStylesheets().add(scrollPaneCSS);
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(parentStage);
					stage.initStyle(StageStyle.UNDECORATED);
					stage.centerOnScreen();
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		);
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

	public void downloadButtonFunction(Button button){
		button.setOnMouseClicked(evt -> {
			System.out.println("Script Python on download");
		});
	}

	private void refreshAfterDelete(Stage childStage) {
		childStage.setOnHidden(evt -> {
			System.out.println("Not on any form");
		});
	}

	public String getBillingNumber() {
		return billingNumber;
	}

	public void setBillingNumber(String billingNumber) {
		this.billingNumber = billingNumber;
	}
	
	public String getBillingClient() {
		return billingClient;
	}

	public void setBillingClient(String billingClient) {
		this.billingClient = billingClient;
	}



	public String getBillingIssueDate() {
		return billingIssueDate;
	}



	public void setBillingIssueDate(String billingIssueDate) {
		this.billingIssueDate = billingIssueDate;
	}



	public String getBillingDueDate() {
		return billingDueDate;
	}



	public void setBillingDueDate(String billingDueDate) {
		this.billingDueDate = billingDueDate;
	}



	public String getBillingSum() {
		return billingSum;
	}



	public void setBillingSum(String billingSum) {
		this.billingSum = billingSum;
	}



	public String getBillingTax() {
		return billingTax;
	}



	public void setBillingTax(String billingTax) {
		this.billingTax = billingTax;
	}



	public String getBillingTotal() {
		return billingTotal;
	}



	public void setBillingTotal(String billingTotal) {
		this.billingTotal = billingTotal;
	}



	public String getBillingStatus() {
		return billingStatus;
	}



	public void setBillingStatus(String billingStatus) {
		this.billingStatus = billingStatus;
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



	

	
}
