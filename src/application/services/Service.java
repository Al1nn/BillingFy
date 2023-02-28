package application.services;

import java.io.IOException;

import application.clients.Client;
import application.resources.DeletePopupController;
import application.services.backend.ServicesDatabase;
import application.services.popup.ServicesPopupController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
	private TableView<Service> tableView;
	private Text servicesLengthText;
	private Text servicesCurrentPage;
	private Text servicesNumPages;
	private ComboBox<String> itemsPerPage;
	private int pageSize = 10;
	private int currentPage = 1;
	private int totalPages;

	public Service(String serviceName, String serviceAmount, String servicePrice, String serviceCurrency, String serviceDescription, String serviceNumber) {
		this.serviceName = serviceName;
		this.serviceAmount = serviceAmount;
		this.servicePrice = servicePrice;
		this.serviceCurrency = serviceCurrency;
		this.serviceDescription = serviceDescription;
		this.serviceNumber = serviceNumber;

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
	private  void styleButtons(Button button, FontAwesomeIcon icon){
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
	
	public void editButtonFunction(Button button) {
		button.setOnMouseClicked(evt -> {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/services/popup/ServicesPopup.fxml"));
					Parent root = loader.load();
					ServicesPopupController servicesPopupController = loader.getController();
					servicesPopupController.setEditable(true);
					servicesPopupController.setInvisibleAdd();
					servicesPopupController.initializeData(serviceName,serviceAmount,servicePrice,serviceCurrency,serviceDescription,serviceNumber);
					Stage parentStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
					tableView = (TableView<Service>) parentStage.getScene().lookup("#servicesTable");
					servicesLengthText = (Text) parentStage.getScene().lookup("#servicesLengthText");
					servicesCurrentPage = (Text) parentStage.getScene().lookup("#servicesCurrentPage");
					currentPage = Integer.parseInt(servicesCurrentPage.getText());
					servicesNumPages = (Text) parentStage.getScene().lookup("#servicesPages");
					totalPages = Integer.parseInt(servicesNumPages.getText());
					itemsPerPage = (ComboBox<String>) parentStage.getScene().lookup("#itemsPerPage");
					String selectedValue = itemsPerPage.getValue();
					pageSize = Integer.parseInt(selectedValue.split(" ")[0]);
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
			try {
				displayTable(currentPage,pageSize);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public void deleteButtonFunction(Button button){
		button.setOnMouseClicked(evt -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/resources/DeletePopup.fxml"));
				Parent root = loader.load();
				DeletePopupController deletePopupController = loader.getController();
				deletePopupController.getDeletePopupTitle().setText("Stergere Serviciu");
				Stage parentStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
				tableView = (TableView<Service>) parentStage.getScene().lookup("#servicesTable");
				servicesLengthText = (Text) parentStage.getScene().lookup("#servicesLengthText");
				servicesCurrentPage = (Text) parentStage.getScene().lookup("#servicesCurrentPage");
				currentPage = Integer.parseInt(servicesCurrentPage.getText());
				servicesNumPages = (Text) parentStage.getScene().lookup("#servicesPages");
				totalPages = Integer.parseInt(servicesNumPages.getText());
				itemsPerPage = (ComboBox<String>) parentStage.getScene().lookup("#itemsPerPage");
				String selectedValue = itemsPerPage.getValue();
				pageSize = Integer.parseInt(selectedValue.split(" ")[0]);
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

	private void refreshAfterDelete(Stage childStage){
		ServicesDatabase connection = new ServicesDatabase();
		childStage.setOnHidden(evt ->{
			try {
				if(tableView.getItems().size() == 1){
					--totalPages;
					servicesNumPages.setText(String.valueOf(totalPages));
					--currentPage;
					servicesCurrentPage.setText(String.valueOf(currentPage));
				}
				connection.deleteData(serviceName,serviceNumber);
				servicesLengthText.setText(String.valueOf(connection.retrieveData().size()));
				displayTable(currentPage,pageSize);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		});
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

	private void displayTable(int page, int size) throws ClassNotFoundException{
		ServicesDatabase connection = new ServicesDatabase();
		int startIndex = (page - 1) * size;
		int endIndex = Math.min(startIndex + size, connection.retrieveData().size());
		ObservableList<Service> currentPageData = FXCollections.observableArrayList(connection.retrieveData().subList(startIndex,endIndex));
		tableView.setItems(currentPageData);
	}
}
