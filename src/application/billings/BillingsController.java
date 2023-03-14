package application.billings;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Filter;

import application.billings.backend.BillingsDatabase;
import application.business.Business;
import application.business.backend.BusinessDatabase;
import application.utilities.DraggableWindow;
import application.utilities.MeniuButtonsStyle;
import application.utilities.ResizeWindow;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class BillingsController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableColumn<Billing, String> billingClient;

    @FXML
    private Text billingCurrentPage;

    @FXML
    private TableColumn<Billing, String> billingDueDate;

    @FXML
    private TableColumn<Billing, HBox> billingFunctions;

    @FXML
    private TableColumn<Billing, String> billingIssueDate;

    @FXML
    private AnchorPane billingLayout;

    @FXML
    private Text billingLengthText;

    @FXML
    private Button billingNextPage;

    @FXML
    private FontAwesomeIconView billingNextPageIcon;

    @FXML
    private TableColumn<Billing, String> billingNumber;

    @FXML
    private Text billingPages;

    @FXML
    private Button billingPreviousPage;

    @FXML
    private FontAwesomeIconView billingPreviousPageIcon;

    @FXML
    private TableColumn<Billing, HBox> billingStatus;

    @FXML
    private TableColumn<Billing, String> billingSum;

    @FXML
    private TableView<Billing> billingTable;

    @FXML
    private TableColumn<Billing, String> billingTax;

    @FXML
    private Text billingTitle;

    @FXML
    private TableColumn<Billing, String> billingTotal;

    @FXML
    private AnchorPane buttonLayout;

    @FXML
    private ComboBox<String> itemsPerPage;

    @FXML
    private Button exitButton;

    @FXML
    private FontAwesomeIconView exitIcon;

    @FXML
    private Button sortClientButton;

    @FXML
    private FontAwesomeIconView sortClientIcon;

    @FXML
    private Button sortDueDateButton;

    @FXML
    private FontAwesomeIconView sortDueDateIcon;

    @FXML
    private Button sortIssueDateButton;

    @FXML
    private FontAwesomeIconView sortIssueDateIcon;

    @FXML
    private Button sortNumberButton;

    @FXML
    private FontAwesomeIconView sortNumberIcon;

    @FXML
    private Button sortStatusButton;

    @FXML
    private FontAwesomeIconView sortStatusIcon;

    @FXML
    private Button sortSumButton;

    @FXML
    private FontAwesomeIconView sortSumIcon;

    @FXML
    private Button sortTaxButton;

    @FXML
    private FontAwesomeIconView sortTaxIcon;

    @FXML
    private TextField searchClient;

    @FXML
    private TextField searchDueDate;

    @FXML
    private TextField searchIssueDate;

    @FXML
    private TextField searchNumber;

    @FXML
    private ComboBox<String> searchStatus;
    
    @FXML
    private Button billingsButton;

    @FXML
    private OctIconView billingsIcon;
        
    @FXML
    private Button clientsButton;

    @FXML
    private Circle clientsCircle;

    @FXML
    private FontAwesomeIconView clientsIcon;

    @FXML
    private Button servicesButton;

    @FXML
    private Circle servicesCircle;

    @FXML
    private FontAwesomeIconView servicesIcon;
    
    @FXML
    private Button statisticsButton;

    @FXML
    private Circle statisticsCircle;

    @FXML
    private FontAwesomeIconView statisticsIcon;

	@FXML
	private FontAwesomeIconView searchClientButton;

	@FXML
	private FontAwesomeIconView searchDueDateButton;

	@FXML
	private FontAwesomeIconView searchIssueDateButton;

	@FXML
	private FontAwesomeIconView searchNumberButton;
    @FXML
    private Button businessButton;

    @FXML
    private Circle businessCircle;

    @FXML
    private FontAwesomeIconView businessIcon;
    
    @FXML
    private Button addBillingButton;

    @FXML
    private Circle addBillingCircle;

    @FXML
    private MaterialIconView addBillingIcon;

	private ObservableList<Billing> billingsData;
	private ObservableList<Billing> totalData;
	private int pageSize = 10;
	private int currentPage = 1;
	private int totalPages;
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		BillingsDatabase connection = new BillingsDatabase();
		String[] itemPerPageOptions = { "10 iteme", "20 iteme", "30 iteme" };
		itemsPerPage.getItems().addAll(itemPerPageOptions);
		itemsPerPage.getSelectionModel().selectFirst();
		String[] statusOptions = {"Platit","Neplatit"};
		searchStatus.getItems().addAll(statusOptions);
		setInitialDesignButtons();
		try {
			totalData = connection.retrieveData();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		MeniuButtonsStyle style = new MeniuButtonsStyle();
		style.styleButtons(clientsButton, clientsIcon, clientsCircle);
		style.styleButtons(servicesButton, servicesIcon, servicesCircle);
		style.styleButtons(statisticsButton, statisticsIcon, statisticsCircle);
		style.styleButtons(businessButton, businessIcon, businessCircle);
		style.styleButtons(addBillingButton, addBillingIcon, addBillingCircle);
		try {
			updateTable();
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException(e);
		}
		totalPages = (int) Math.ceil((double) totalData.size() / pageSize);
		billingPages.setText(String.valueOf(totalPages));
	}
	private void updateTable() throws ClassNotFoundException, IOException {
		BillingsDatabase connection = new BillingsDatabase();
		billingNumber.setCellValueFactory(new PropertyValueFactory<>("clientNumber"));
		centerCellsOnColumn(billingNumber);
		billingClient.setCellValueFactory(new PropertyValueFactory<>("clientName"));
		centerCellsOnColumn(billingClient);
		billingIssueDate.setCellValueFactory(new PropertyValueFactory<>("paymentIssueDate"));
		centerCellsOnColumn(billingIssueDate);
		billingDueDate.setCellValueFactory(new PropertyValueFactory<>("paymentDueDate"));
		centerCellsOnColumn(billingDueDate);
		billingSum.setCellValueFactory(new PropertyValueFactory<>("calculationSubtotal"));
		centerCellsOnColumn(billingSum);
		billingTax.setCellValueFactory(new PropertyValueFactory<>("calculationTax"));
		centerCellsOnColumn(billingTax);
		billingTotal.setCellValueFactory(new PropertyValueFactory<>("calculationTotal"));
		centerCellsOnColumn(billingTotal);
		billingStatus.setCellValueFactory(new PropertyValueFactory<>("statusPane"));
		centerStatusColumn(billingStatus);
		billingFunctions.setCellValueFactory(new PropertyValueFactory<>("pane"));
		centerBillingFunctionsColumn(billingFunctions);
		billingsData = connection.retrieveData(pageSize,currentPage);
		billingTable.setItems(billingsData);
		billingLengthText.setText(String.valueOf(billingsData.size()));
	}
	public void setInitialDesignButtons() {
		billingsButton.setStyle("-fx-background-color: white; -fx-background-radius: 15px; -fx-border-radius: 15 15 15 15; "
				+ "-fx-text-fill: #5283E9");
		billingsIcon.setFill(Color.web("#5283E9"));
		clientsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		servicesButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		statisticsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		businessButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		addBillingButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
	}
	private void centerCellsOnColumn(TableColumn<Billing,String> tableColumn){
		tableColumn.setCellFactory(column -> new TableCell<Billing,String>(){
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText(null);
					setAlignment(Pos.CENTER);
				} else {
					setText(item);
					setAlignment(Pos.CENTER);
				}
			}
		});
	}

	private void centerStatusColumn(TableColumn<Billing,HBox> tableColumn){
		tableColumn.setCellFactory(column-> new TableCell<Billing,HBox>(){
			@Override
			protected void updateItem(HBox item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setGraphic(null);
				} else {
					Billing billing = billingTable.getItems().get(getIndex());
					item = billing.getStatusPane();
					item.setAlignment(Pos.CENTER);
					setGraphic(item);
				}
			}
		});
	}
	private void centerBillingFunctionsColumn(TableColumn<Billing,HBox> tableColumn){
		tableColumn.setCellFactory(column-> new TableCell<Billing,HBox>(){
			@Override
			protected void updateItem(HBox item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setGraphic(null);
				} else {
					Billing billing = billingTable.getItems().get(getIndex());
					item = billing.getPane();
					item.setAlignment(Pos.CENTER);
					setGraphic(item);
				}
			}
		});
	}
	@FXML
	public void exitButtonClicked(ActionEvent event) {
		Platform.exit();
	}
	
    @FXML
    void billingNextPageClicked(ActionEvent event) throws ClassNotFoundException {
		BillingsDatabase connection = new BillingsDatabase();
		if(currentPage < totalPages){
			currentPage++;
			totalPages = (int) Math.ceil((double) totalData.size() / pageSize);
			billingCurrentPage.setText(String.valueOf(currentPage));
			billingPages.setText(String.valueOf(currentPage));
			billingTable.setItems(connection.retrieveData(pageSize,currentPage));
		}
    }

    @FXML
    void billingPreviousPageClicked(ActionEvent event) throws ClassNotFoundException {
		BillingsDatabase connection = new BillingsDatabase();
		if(currentPage > 1){
			currentPage--;
			totalPages = (int) Math.ceil((double) totalData.size() / pageSize);
			billingCurrentPage.setText(String.valueOf(currentPage));
			billingPages.setText(String.valueOf(totalPages));
			billingTable.setItems(connection.retrieveData(pageSize,currentPage));
		}
    }
	@FXML
	void itemsPerPageSelected(ActionEvent event) throws ClassNotFoundException {
		BillingsDatabase connection = new BillingsDatabase();
		String selectedValue = itemsPerPage.getValue();
		pageSize = Integer.parseInt(selectedValue.split(" ")[0]);
		totalPages = (int) Math.ceil((double) totalData.size() / pageSize);
		billingPages.setText(String.valueOf(totalPages));
		currentPage = 1;
		billingCurrentPage.setText(String.valueOf(currentPage));
		billingTable.setItems(connection.retrieveData(pageSize,currentPage));
	}
    @FXML
    void sortClientButtonClicked(ActionEvent event) {
    	if(sortClientIcon.getGlyphName() == "ANGLE_UP") {
    		sortClientIcon.setGlyphName("ANGLE_DOWN");
			billingClient.setSortType(TableColumn.SortType.DESCENDING);
		} else {
			sortClientIcon.setGlyphName("ANGLE_UP");
			billingClient.setSortType(TableColumn.SortType.ASCENDING);
		}
		billingClient.setSortable(true);
		billingTable.getSortOrder().clear();
		billingTable.getSortOrder().add(billingClient);
    }

    @FXML
    void sortDueDateButtonClicked(ActionEvent event) {
    	if(sortDueDateIcon.getGlyphName() == "ANGLE_UP")
		{
			sortDueDateIcon.setGlyphName("ANGLE_DOWN");
			billingDueDate.setSortType(TableColumn.SortType.DESCENDING);
		}
    	else {
			sortDueDateIcon.setGlyphName("ANGLE_UP");
			billingDueDate.setSortType(TableColumn.SortType.ASCENDING);
		}
		billingDueDate.setSortable(true);
		billingTable.getSortOrder().clear();
		billingTable.getSortOrder().add(billingDueDate);
    }

    @FXML
    void sortIssueDateButtonClicked(ActionEvent event) {
    	if(sortIssueDateIcon.getGlyphName() == "ANGLE_UP") {
			sortIssueDateIcon.setGlyphName("ANGLE_DOWN");
			billingIssueDate.setSortType(TableColumn.SortType.DESCENDING);
		}
    	else {
			sortIssueDateIcon.setGlyphName("ANGLE_UP");
			billingIssueDate.setSortType(TableColumn.SortType.ASCENDING);
		}
		billingIssueDate.setSortable(true);
		billingTable.getSortOrder().clear();
		billingTable.getSortOrder().add(billingIssueDate);
    }

    @FXML
    void sortNumberButtonClicked(ActionEvent event) {
    	if(sortNumberIcon.getGlyphName() == "ANGLE_UP") {
			sortNumberIcon.setGlyphName("ANGLE_DOWN");
			billingNumber.setSortType(TableColumn.SortType.DESCENDING);
		}
    	else {
			sortNumberIcon.setGlyphName("ANGLE_UP");
			billingNumber.setSortType(TableColumn.SortType.ASCENDING);
		}
		billingNumber.setSortable(true);
		billingTable.getSortOrder().clear();
		billingTable.getSortOrder().add(billingNumber);
    }

    @FXML
    void sortStatusButtonClicked(ActionEvent event) {
    	if(sortStatusIcon.getGlyphName() == "ANGLE_UP") {
			sortStatusIcon.setGlyphName("ANGLE_DOWN");
			billingStatus.setSortType(TableColumn.SortType.DESCENDING);
		}
    	else {
			sortStatusIcon.setGlyphName("ANGLE_UP");
			billingStatus.setSortType(TableColumn.SortType.ASCENDING);
		}
		billingStatus.setSortable(true);
		billingTable.getSortOrder().clear();
		billingTable.getSortOrder().add(billingStatus);
    }

    @FXML
    void sortSumButtonClicked(ActionEvent event) {
    	if(sortSumIcon.getGlyphName() == "ANGLE_UP") {
			sortSumIcon.setGlyphName("ANGLE_DOWN");
			billingSum.setSortType(TableColumn.SortType.DESCENDING);
		}
    	else {
			sortSumIcon.setGlyphName("ANGLE_UP");
			billingSum.setSortType(TableColumn.SortType.ASCENDING);
		}
		billingSum.setSortable(true);
		billingTable.getSortOrder().clear();
		billingTable.getSortOrder().add(billingSum);
    }

    @FXML
    void sortTaxButtonClicked(ActionEvent event) {
    	if(sortTaxIcon.getGlyphName() == "ANGLE_UP") {
			sortTaxIcon.setGlyphName("ANGLE_DOWN");
			billingTax.setSortType(TableColumn.SortType.DESCENDING);
		}
    	else {
			sortTaxIcon.setGlyphName("ANGLE_UP");
			billingTax.setSortType(TableColumn.SortType.ASCENDING);
		}
		billingTax.setSortable(true);
		billingTable.getSortOrder().clear();
		billingTable.getSortOrder().add(billingTax);
    }


	@FXML
	void searchClientButtonClicked(MouseEvent event) {
		String searchedClient = searchClient.getText();

		if(searchedClient == null || searchedClient.isEmpty()){
			billingTable.setItems(billingsData);
			return;
		}

		FilteredList<Billing> filteredList = billingsData.filtered(Billing -> {
			return Billing.getClientName().contains(searchedClient);
		});

		billingTable.setItems(filteredList);

	}

	@FXML
	void searchDueDateButtonClicked(MouseEvent event) {
		String searchedDueDate = searchDueDate.getText();

		if (searchedDueDate == null || searchedDueDate.isEmpty()){
			billingTable.setItems(billingsData);
			return;
		}

		FilteredList<Billing> filteredList = billingsData.filtered(Billing -> {
			return Billing.getPaymentDueDate().contains(searchedDueDate);
		});

		billingTable.setItems(filteredList);



	}

	@FXML
	void searchIssueDateButtonClicked(MouseEvent event) {
		String searchedIssueDate = searchIssueDate.getText();

		if (searchedIssueDate == null || searchedIssueDate.isEmpty()){

			billingTable.setItems(billingsData);
			return;
		}

		FilteredList<Billing> filteredList = billingsData.filtered(Billing -> {
			return Billing.getPaymentIssueDate().contains(searchedIssueDate);
		});
		billingTable.setItems(filteredList);

	}

	@FXML
	void searchNumberButtonClicked(MouseEvent event) {
		String searchedNumber = searchNumber.getText();

		if (searchedNumber == null || searchedNumber.isEmpty()){
			billingTable.setItems(billingsData);
			return;
		}

		FilteredList<Billing> filteredList = billingsData.filtered(Billing -> {
			return Billing.getClientNumber().contains(searchedNumber);
		});

		billingTable.setItems(filteredList);



	}

	@FXML
	void searchStatusSelected(ActionEvent event) {
		String searchedStatus = searchStatus.getValue();

		if (searchedStatus == null || searchedStatus.isEmpty()){
			billingTable.setItems(billingsData);
			return;
		}

		FilteredList<Billing> filteredList = billingsData.filtered(Billing -> {
			return Billing.getPaymentStatus().contains(searchedStatus);
		});

		billingTable.setItems(filteredList);
	}

    @FXML
    void clientsButtonClicked(ActionEvent event) throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("/application/clients/Clients.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		window.dragWindow(root, stage);
		String billingCSS = this.getClass().getResource("/application/clients/ClientStyle.css").toExternalForm();
		stage.getScene().getStylesheets().add(billingCSS);
		window.fullscreenWindow(stage.getScene(), stage);
		stage.setFullScreenExitHint("");
		stage.getScene().setRoot(root);
		if(!stage.isFullScreen())
		{
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		}
		stage.setMinWidth(1350);
		stage.setMinHeight(750);
		stage.show();
    }
    
    @FXML
    void servicesButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/services/Services.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		window.dragWindow(root, stage);
		String billingCSS = this.getClass().getResource("/application/services/ServicesStyle.css").toExternalForm();
		String chartCSS = this.getClass().getResource("/application/resources/chartStyle.css").toExternalForm();
		String scrollCSS = this.getClass().getResource("/application/resources/scrollPaneStyle.css").toExternalForm();
		stage.getScene().getStylesheets().add(billingCSS);
		stage.getScene().getStylesheets().add(chartCSS);
		stage.getScene().getStylesheets().add(scrollCSS);
		window.fullscreenWindow(stage.getScene(), stage);
		stage.setFullScreenExitHint("");
		stage.getScene().setRoot(root);
		if(!stage.isFullScreen())
		{
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		}
		stage.setMinWidth(1350);
		stage.setMinHeight(750);
		stage.show();
    }
    
    @FXML
    void statisticsButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/statistics/Statistics.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		window.dragWindow(root, stage);
		String billingCSS = this.getClass().getResource("/application/statistics/StatisticsStyle.css").toExternalForm();
		String chartCSS = this.getClass().getResource("/application/resources/chartStyle.css").toExternalForm();
		stage.getScene().getStylesheets().add(billingCSS);
		stage.getScene().getStylesheets().add(chartCSS);
		window.fullscreenWindow(stage.getScene(), stage);
		stage.setFullScreenExitHint("");
		stage.getScene().setRoot(root);
		if(!stage.isFullScreen())
		{
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		}
		stage.setMinWidth(1350);
		stage.setMinHeight(750);
		stage.show();
    }
    
    @FXML
    void businessButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/business/Business.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		window.dragWindow(root, stage);
		String billingCSS = this.getClass().getResource("/application/business/BusinessStyle.css").toExternalForm();
		stage.getScene().getStylesheets().add(billingCSS);
		window.fullscreenWindow(stage.getScene(), stage);
		stage.setFullScreenExitHint("");
		stage.getScene().setRoot(root);
		if(!stage.isFullScreen())
		{
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		}
		stage.setMinWidth(1350);
		stage.setMinHeight(750);
		stage.show();
    }
    
    @FXML
    void addBillingButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/billings/popup/BillingsPopup.fxml"));
		Stage childStage = new Stage();
		Stage parentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String popupCSS = this.getClass().getResource("/application/billings/popup/BillingsPopupStyle.css").toExternalForm();
		String scrollCSS = this.getClass().getResource("/application/resources/scrollPaneStyle.css").toExternalForm();
		childStage.setScene(new Scene(root));
		childStage.getScene().getStylesheets().add(popupCSS);
		childStage.getScene().getStylesheets().add(scrollCSS);
		childStage.initModality(Modality.WINDOW_MODAL);
		childStage.initOwner(parentStage);
		childStage.initStyle(StageStyle.UNDECORATED);
		childStage.show();
		//stage.centerOnScreen();
		double x = parentStage.getX() + (parentStage.getWidth() - childStage.getWidth()) / 2;
		double y = parentStage.getY() + (parentStage.getHeight() - childStage.getHeight()) / 2;
		childStage.setX(x);
		childStage.setY(y);
		refreshData(childStage);
		}
		private void refreshData(Stage childStage){
		BillingsDatabase connection = new BillingsDatabase();
		childStage.setOnHidden(evt -> {
			try {
				if(billingTable.getItems().size() == pageSize){
					totalPages = (int) Math.ceil((double) totalData.size() / pageSize);
					billingPages.setText(String.valueOf(totalPages));
				}
				billingLengthText.setText(String.valueOf(totalData.size()));
				billingTable.setItems(connection.retrieveData(pageSize,currentPage));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		});
	}

}
