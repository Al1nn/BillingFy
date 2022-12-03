package application.billings;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

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
		Circle circle = new Circle();
		Text text = new Text();
		text.setText(billingStatus);
		circle.setRadius(10);
		if (this.billingStatus == "Neplatit") {
			circle.setFill(Color.web("#E25F5F"));
			text.setFill(Color.web("#E25F5F"));
		}else if(this.billingStatus == "Platit") {
			circle.setFill(Color.web("#41A33F"));
			text.setFill(Color.web("#41A33F"));
		}
		this.statusPane = new HBox(circle,text);
		statusPane.setSpacing(10);
		//Button Column
		String buttonStyle = this.getClass().getResource("/application/resources/material-design-skin.css").toExternalForm();
		//Edit button
		Button editButton = new Button();
		FontAwesomeIconView editButtonIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
		editButtonIcon.setFill(Color.web("#547cbc"));
		editButtonIcon.setSize("20");
		editButton.setGraphic(editButtonIcon);
		editButton.getStylesheets().add(buttonStyle);
		setIconFills(editButton, editButtonIcon);
		//Delete button
		Button deleteButton = new Button();
		FontAwesomeIconView deleteButtonIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
		deleteButtonIcon.setFill(Color.web("#547cbc"));
		deleteButtonIcon.setSize("20");
		deleteButton.setGraphic(deleteButtonIcon);
		deleteButton.getStylesheets().add(buttonStyle);
		setIconFills(deleteButton, deleteButtonIcon);
		//Download button
		Button downloadButton = new Button();
		MaterialIconView downloadButtonIcon = new MaterialIconView(MaterialIcon.FILE_DOWNLOAD);
		downloadButtonIcon.setFill(Color.web("#547cbc"));
		downloadButtonIcon.setSize("20");
		downloadButton.setGraphic(downloadButtonIcon);
		downloadButton.getStylesheets().add(buttonStyle);
		setIconFills(downloadButton, downloadButtonIcon);
		this.setPane(new HBox(editButton,deleteButton,downloadButton));
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
