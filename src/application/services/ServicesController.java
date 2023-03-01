package application.services;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.clients.Client;
import application.services.backend.ServicesDatabase;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ServicesController implements Initializable{

    @FXML
    private Button addBillingButton;

    @FXML
    private Circle addBillingCircle;

    @FXML
    private MaterialIconView addBillingIcon;

    @FXML
    private Button addServicesButton;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button billingsButton;

    @FXML
    private Circle billingsCircle;

    @FXML
    private OctIconView billingsIcon;

    @FXML
    private Button businessButton;

    @FXML
    private Circle businessCircle;

    @FXML
    private FontAwesomeIconView businessIcon;

    @FXML
    private AnchorPane buttonLayout;

    @FXML
    private Button clientsButton;

    @FXML
    private Circle clientsCircle;

    @FXML
    private FontAwesomeIconView clientsIcon;

    @FXML
    private Button exitButton;

    @FXML
    private FontAwesomeIconView exitIcon;

    @FXML
    private ComboBox<String> itemsPerPage;

	@FXML
	private TextField searchServiceName;

	@FXML
	private FontAwesomeIconView searchServiceNameIcon;

    @FXML
    private Button servicesButton;

    @FXML
    private Circle servicesCircle;

    @FXML
    private Text servicesCurrentPage;

    @FXML
    private TableColumn<Service, String> servicesDescription;

    @FXML
    private TableColumn<Service, HBox> servicesFunctions;

    @FXML
    private FontAwesomeIconView servicesIcon;

    @FXML
    private AnchorPane servicesLayout;

    @FXML
    private Text servicesLengthText;

    @FXML
    private TableColumn<Service, String> servicesName;

    @FXML
    private Button servicesNextPage;

    @FXML
    private FontAwesomeIconView servicesNextPageIcon;

    @FXML
    private TableColumn<Service, String> servicesNumber;

    @FXML
    private Text servicesPages;

    @FXML
    private Button servicesPreviousPage;

    @FXML
    private FontAwesomeIconView servicesPreviousPageIcon;

    @FXML
    private TableColumn<Service, String> servicesPrice;

    @FXML
    private TableView<Service> servicesTable;

    @FXML
    private Text servicesTitle;

    @FXML
    private Button sortNumberButton;

    @FXML
    private FontAwesomeIconView sortNumberIcon;

    @FXML
    private Button sortPriceButton;

    @FXML
    private FontAwesomeIconView sortPriceIcon;

    @FXML
    private Button sortServicesButton;

    @FXML
    private FontAwesomeIconView sortServicesIcon;

    @FXML
    private Button statisticsButton;

    @FXML
    private Circle statisticsCircle;

    @FXML
    private FontAwesomeIconView statisticsIcon;
    
    @FXML
    private BarChart<?, ?> servicesNumberChart;
    
    @FXML
    private BarChart<?, ?> servicesIncomingsChart;
    private ObservableList<Service> servicesData;
	@FXML
	private ScrollPane chartScrollPane;
	private int pageSize = 10;
	private int currentPage = 1;
	private int totalPages;
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setInitialDesignButtons();
		MeniuButtonsStyle style = new MeniuButtonsStyle();
		style.styleButtons(billingsButton, billingsIcon, billingsCircle);
		style.styleButtons(clientsButton, clientsIcon, clientsCircle);
		style.styleButtons(statisticsButton, statisticsIcon, statisticsCircle);
		style.styleButtons(businessButton, businessIcon, businessCircle);
		style.styleButtons(addBillingButton, addBillingIcon, addBillingCircle);
		String[] itemPerPageOptions = { "10 iteme", "20 iteme", "30 iteme" };
		itemsPerPage.getItems().addAll(itemPerPageOptions);
		itemsPerPage.getSelectionModel().selectFirst();
		try {
			updateTable();
			updateCharts();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		totalPages = (int) Math.ceil((double) servicesData.size() / pageSize);
		servicesPages.setText(String.valueOf(totalPages));
	}
	private void updateCharts(){
		servicesNumberChart.getData().clear();
		servicesIncomingsChart.getData().clear();
		for (Service service : servicesTable.getItems()) {
			XYChart.Series series = new XYChart.Series();
			series.setName(service.getServiceName());
			series.getData().add(new XYChart.Data(service.getServiceName(),Integer.valueOf(service.getServiceAmount())));
			servicesNumberChart.getData().add(series);

			XYChart.Series incomingsSeries = new XYChart.Series();
			incomingsSeries.setName(service.getServiceName());
			incomingsSeries.getData().add(new XYChart.Data(service.getServiceName(),Double.valueOf(service.getServicePrice())));
			servicesIncomingsChart.getData().add(incomingsSeries);
		}

	}
    private void updateTable() throws ClassNotFoundException {
		ServicesDatabase connection = new ServicesDatabase();
		servicesNumber.setCellValueFactory(new PropertyValueFactory<>("serviceNumber"));
		centerCellsOnColumn(servicesNumber);
		servicesName.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
		centerCellsOnColumn(servicesName);
		servicesDescription.setCellValueFactory(new PropertyValueFactory<>("serviceDescription"));
		centerCellsOnColumn(servicesDescription);
		servicesPrice.setCellValueFactory(new PropertyValueFactory<>("servicePrice"));
		centerCellsOnColumn(servicesPrice);
		servicesFunctions.setCellValueFactory(new PropertyValueFactory<>("buttonPane"));
		centerServiceFunctionsColumn(servicesFunctions);
		servicesTable.setEditable(true);
		servicesData = connection.retrieveData();
		displayTable(1,pageSize);
		servicesLengthText.setText(String.valueOf(connection.retrieveData().size()));
	}
	private void centerCellsOnColumn(TableColumn<Service,String> tableColumn){
		tableColumn.setCellFactory(column -> new TableCell<Service,String>(){
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
	private void centerServiceFunctionsColumn(TableColumn<Service,HBox> tableColumn){
		tableColumn.setCellFactory(column-> new TableCell<Service,HBox>(){
			@Override
			protected void updateItem(HBox item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setGraphic(null);
				} else {
					Service service = servicesTable.getItems().get(getIndex());
					item = service.getButtonPane();
					item.setAlignment(Pos.CENTER);
					setGraphic(item);
				}
			}
		});
	}
    public void setInitialDesignButtons() {
		billingsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		clientsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ "-fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		servicesButton.setStyle("-fx-background-color: white; -fx-background-radius: 15px; -fx-border-radius: 15 15 15 15;"
				+ "-fx-text-fill: #5283E9");
		servicesIcon.setFill(Color.web("#5283E9"));
		statisticsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		businessButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		addBillingButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
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
		double x = parentStage.getX() + (parentStage.getWidth() - childStage.getWidth()) / 2;
		double y = parentStage.getY() + (parentStage.getHeight() - childStage.getHeight()) / 2;
		childStage.setX(x);
		childStage.setY(y);
    }

    @FXML
    void addServicesButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/services/popup/ServicesPopup.fxml"));
		Stage childStage = new Stage();
		Stage parentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String popupCSS = this.getClass().getResource("/application/services/popup/ServicesPopupStyle.css").toExternalForm();
		String scrollCSS = this.getClass().getResource("/application/resources/scrollPaneStyle.css").toExternalForm();
		childStage.setScene(new Scene(root));
		childStage.getScene().getStylesheets().add(popupCSS);
		childStage.getScene().getStylesheets().add(scrollCSS);
		childStage.initModality(Modality.APPLICATION_MODAL);
		childStage.initOwner(parentStage);
		childStage.initStyle(StageStyle.UNDECORATED);
		childStage.show();
		double x = parentStage.getX() + (parentStage.getWidth() - childStage.getWidth()) / 2;
		double y = parentStage.getY() + (parentStage.getHeight() - childStage.getHeight()) / 2;
		childStage.setX(x);
		childStage.setY(y);
    	refreshData(childStage);
	}
	private void refreshData(Stage childStage){
		ServicesDatabase connection = new ServicesDatabase();
		childStage.setOnHidden(evt -> {
			try {
				if(servicesTable.getItems().size() == pageSize){
					totalPages = (int) Math.ceil((double) connection.retrieveData().size() / pageSize);
					servicesPages.setText(String.valueOf(totalPages));
				}
				servicesLengthText.setText(String.valueOf(connection.retrieveData().size()));
				displayTable(currentPage,pageSize);
				updateCharts();
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		});
	}
    @FXML
    void billingsButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/billings/Billings.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		window.dragWindow(root, stage);
		String billingCSS = this.getClass().getResource("/application/billings/BillingStyle.css").toExternalForm();
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
    void clientsButtonClicked(ActionEvent event) throws IOException {
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
    void exitButtonClicked(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void servicesButtonClicked(ActionEvent event) {

    }

    @FXML
    void servicesNextPageClicked(ActionEvent event) throws ClassNotFoundException {
		if (currentPage < totalPages)
		{
			currentPage++;
			totalPages = (int) Math.ceil((double) servicesData.size() / pageSize);
			servicesCurrentPage.setText(String.valueOf(currentPage));
			servicesPages.setText(String.valueOf(totalPages));
			displayTable(currentPage,pageSize);
			updateCharts();
		}
    }

    @FXML
    void servicesPreviousPageClicked(ActionEvent event) throws ClassNotFoundException {
		if(currentPage > 1){
			currentPage--;
			totalPages = (int) Math.ceil((double) servicesData.size() / pageSize);
			servicesCurrentPage.setText(String.valueOf(currentPage));
			servicesPages.setText(String.valueOf(totalPages));
			displayTable(currentPage,pageSize);
			updateCharts();
		}
    }
	@FXML
	void itemsPerPageSelected(ActionEvent event) throws ClassNotFoundException {
		String selectedValue = itemsPerPage.getValue();
		pageSize = Integer.parseInt(selectedValue.split(" ")[0]);
		totalPages = (int) Math.ceil((double) servicesData.size() / pageSize);
		servicesPages.setText(String.valueOf(totalPages));
		currentPage = 1;
		servicesCurrentPage.setText(String.valueOf(currentPage));
		displayTable(currentPage,pageSize);
		updateCharts();
	}
    @FXML
    void sortNumberButtonClicked(ActionEvent event) {
    	if(sortNumberIcon.getGlyphName() == "ANGLE_UP") {
			sortNumberIcon.setGlyphName("ANGLE_DOWN");
			servicesNumber.setSortType(TableColumn.SortType.DESCENDING);
		}else {
			sortNumberIcon.setGlyphName("ANGLE_UP");
			servicesNumber.setSortType(TableColumn.SortType.ASCENDING);
		}
		servicesNumber.setSortable(true);
		servicesTable.getSortOrder().clear();
		servicesTable.getSortOrder().add(servicesNumber);
    }

    @FXML
    void sortPriceButtonClicked(ActionEvent event) {
    	if(sortPriceIcon.getGlyphName() == "ANGLE_UP") {
			sortPriceIcon.setGlyphName("ANGLE_DOWN");
			servicesPrice.setSortType(TableColumn.SortType.DESCENDING);
		}else {
			sortPriceIcon.setGlyphName("ANGLE_UP");
			servicesPrice.setSortType(TableColumn.SortType.ASCENDING);
		}
		servicesPrice.setSortable(true);
		servicesTable.getSortOrder().clear();
		servicesTable.getSortOrder().add(servicesPrice);
	}

    @FXML
    void sortServicesButtonClicked(ActionEvent event) {
    	if (sortServicesIcon.getGlyphName() == "ANGLE_UP") {
			sortServicesIcon.setGlyphName("ANGLE_DOWN");
			servicesName.setSortType(TableColumn.SortType.DESCENDING);
		}else {
			sortServicesIcon.setGlyphName("ANGLE_UP");
			servicesName.setSortType(TableColumn.SortType.ASCENDING);
		}
		servicesName.setSortable(true);
		servicesTable.getSortOrder().clear();
		servicesTable.getSortOrder().add(servicesName);
	}

	@FXML
	void searchServiceNameIconClicked(MouseEvent event) throws ClassNotFoundException {
		String searchText = searchServiceName.getText();
		FilteredList<Service> filteredList = servicesData.filtered(Service -> {
			return Service.getServiceName().contains(searchText);
		});
		servicesTable.setItems(filteredList);
		updateCharts();
		if(searchText == null || searchText.isEmpty())
			{
				displayTable(currentPage,pageSize);
				updateCharts();
			}
	}

    private void displayTable(int page, int size) throws ClassNotFoundException{
		ServicesDatabase connection = new ServicesDatabase();
		servicesData = connection.retrieveData();
		int startIndex = (page - 1) * size;
		int endIndex = Math.min(startIndex + size, servicesData.size());
		ObservableList<Service> currentPageData = FXCollections.observableArrayList(servicesData.subList(startIndex,endIndex));
		servicesTable.setItems(currentPageData);
	}

}
