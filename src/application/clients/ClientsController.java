package application.clients;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.clients.backend.ClientDatabase;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ClientsController implements Initializable {

	@FXML
	private Button addClientButton;

	@FXML
	private Button addBillingButton;

	@FXML
	private Circle addBillingCircle;

	@FXML
	private MaterialIconView addBillingIcon;

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
	private TableColumn<Client, String> clientCity;

	@FXML
	private TableColumn<Client, String> clientCountry;

	@FXML
	private Text clientCurrentPage;

	@FXML
	private TableColumn<Client, String> clientEmail;

	@FXML
	private TableColumn<Client, String> clientFunctions;

	@FXML
	private AnchorPane clientLayout;

	@FXML
	public Text clientLengthText;

	@FXML
	private TableColumn<Client, String> clientName;

	@FXML
	private Button clientNextPage;

	@FXML
	private FontAwesomeIconView clientNextPageIcon;

	@FXML
	private TableColumn<Client, String> clientNumber;

	@FXML
	private Text clientPages;

	@FXML
	private TableColumn<Client, String> clientPhoneNumber;

	@FXML
	private Button clientPreviousPage;

	@FXML
	private FontAwesomeIconView clientPreviousPageIcon;

	@FXML
	private Text clientTitle;

	@FXML
	private TableColumn<Client, String> clientZipCode;

	@FXML
	private Button clientsButton;

	@FXML
	private Circle clientsCircle;

	@FXML
	private FontAwesomeIconView clientsIcon;

	@FXML
	public TableView<Client> clientsTable;

	@FXML
	private Button exitButton;

	@FXML
	private FontAwesomeIconView exitIcon;

	@FXML
	private ComboBox<String> itemsPerPage;

	@FXML
	private TextField searchClient;

	@FXML
	private TextField searchEmail;

	@FXML
	private TextField searchPhoneNumber;

	@FXML
	private Button servicesButton;

	@FXML
	private Circle servicesCircle;

	@FXML
	private FontAwesomeIconView servicesIcon;

	@FXML
	private Button sortCityButton;

	@FXML
	private FontAwesomeIconView sortCityIcon;

	@FXML
	private Button sortClientButton;

	@FXML
	private FontAwesomeIconView sortClientIcon;

	@FXML
	private Button sortCountryButton;

	@FXML
	private FontAwesomeIconView sortCountryIcon;

	@FXML
	private Button sortEmailButton;

	@FXML
	private FontAwesomeIconView sortEmailIcon;

	@FXML
	private Button sortNumberButton;

	@FXML
	private FontAwesomeIconView sortNumberIcon;

	@FXML
	private Button sortPhoneNumberButton;

	@FXML
	private FontAwesomeIconView sortPhoneNumberIcon;

	@FXML
	private Button sortZipCodeButton;

	@FXML
	private FontAwesomeIconView sortZipCodeIcon;

	@FXML
	private Button statisticsButton;

	@FXML
	private Circle statisticsCircle;

	@FXML
	private FontAwesomeIconView statisticsIcon;

	private ObservableList<Client> clientData;


	@FXML
	private FontAwesomeIconView searchByClientIcon;

	@FXML
	private FontAwesomeIconView searchByEmailIcon;

	@FXML
	private FontAwesomeIconView searchByPhoneNumberIcon;
	private ObservableList<Client> paginatedData;
	private static int ITEMS_PER_PAGE = 10;
	private int numPages = 1;
	private int currentPage = 0;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setInitialDesignButtons();
		MeniuButtonsStyle style = new MeniuButtonsStyle();
		style.styleButtons(billingsButton, billingsIcon, billingsCircle);
		style.styleButtons(servicesButton, servicesIcon, servicesCircle);
		style.styleButtons(statisticsButton, statisticsIcon, statisticsCircle);
		style.styleButtons(businessButton, businessIcon, businessCircle);
		style.styleButtons(addBillingButton, addBillingIcon, addBillingCircle);
		///Initialize contents from table with Database from MySQL !!!!!!!!
		updateTable();
		String[] itemPerPageOptions = { "10 iteme", "20 iteme", "30 iteme" };
		itemsPerPage.getItems().addAll(itemPerPageOptions);

	}


	public void updateTable(){
		clientNumber.setCellValueFactory(new PropertyValueFactory<>("clientNumber"));
		clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
		clientCountry.setCellValueFactory(new PropertyValueFactory<>("clientCountry"));
		clientCity.setCellValueFactory(new PropertyValueFactory<>("clientCity"));
		clientZipCode.setCellValueFactory(new PropertyValueFactory<>("clientZipCode"));
		clientEmail.setCellValueFactory(new PropertyValueFactory<>("clientEmail"));
		clientPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("clientPhoneNumber"));
		clientFunctions.setCellValueFactory(new PropertyValueFactory<>("buttonPane"));
		ClientDatabase connection = new ClientDatabase();
		try {
			clientData= connection.retrieveData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clientsTable.setEditable(true);
		paginatedData = createPage(currentPage);
		clientsTable.setItems(paginatedData);
		clientLengthText.setText(String.valueOf(clientsTable.getItems().size()));
		clientCurrentPage.setText(String.valueOf(currentPage + 1));
		numPages = (int) Math.ceil((double) clientData.size() / ITEMS_PER_PAGE);
		clientPages.setText(String.valueOf(numPages));
	}

	public void setInitialDesignButtons() {
		billingsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		clientsButton
				.setStyle("-fx-background-color: white; -fx-background-radius: 15px; -fx-border-radius: 15 15 15 15;"
						+ "-fx-text-fill: #5283E9");
		clientsIcon.setFill(Color.web("#5283E9"));
		servicesButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
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
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		stage.setMinWidth(1350);
		stage.setMinHeight(750);
		stage.show();
	}

	@FXML
	void addClientButtonClicked(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/clients/popup/ClientPopup.fxml"));
		Stage childStage = new Stage();
		Stage parentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
		refreshData(childStage);
	}
	private void refreshData(Stage childStage){
		childStage.setOnHidden(evt -> {
			updateTable();
		});
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
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
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
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
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
		stage.getScene().getStylesheets().add(billingCSS);
		stage.getScene().getStylesheets().add(chartCSS);
		window.fullscreenWindow(stage.getScene(), stage);
		stage.setFullScreenExitHint("");
		stage.getScene().setRoot(root);
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		stage.setMinWidth(1350);
		stage.setMinHeight(750);
		stage.show();
	}
	
	@FXML
	void clientNextPageClicked(ActionEvent event) {
		if(currentPage + 1< numPages )
		{
			currentPage++;
			clientCurrentPage.setText(String.valueOf(currentPage + 1));
			ObservableList<Client> paginatedData = createPage(currentPage);
			clientsTable.setItems(paginatedData);
		}

	}

	@FXML
	void clientPreviousPageClicked(ActionEvent event) {
		if(currentPage + 1 > 1)
			{
				currentPage--;
				clientCurrentPage.setText(String.valueOf(currentPage + 1));
				ObservableList<Client> paginatedData = createPage(currentPage);
				clientsTable.setItems(paginatedData);
			}

	}

	@FXML
	void clientsButtonClicked(ActionEvent event) {

	}
	@FXML
	void itemsPerPageSelected(ActionEvent event) {
		String selectedItemPerPage = itemsPerPage.getValue().toString();
		String[] tokens = selectedItemPerPage.split(" ");
		ITEMS_PER_PAGE = Integer.parseInt(tokens[0]);
		numPages = (int) Math.ceil((double) clientData.size() / ITEMS_PER_PAGE);
		clientPages.setText(String.valueOf(numPages));
		currentPage = 0;
		updateTable();
	}
	@FXML
	void exitButtonClicked(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void sortCityButtonClicked(ActionEvent event) {
		if (sortCityIcon.getGlyphName() == "ANGLE_UP") {
			sortCityIcon.setGlyphName("ANGLE_DOWN");
			clientCity.setSortType(TableColumn.SortType.DESCENDING);
		} else{
			sortCityIcon.setGlyphName("ANGLE_UP");
			clientCity.setSortType(TableColumn.SortType.ASCENDING);
		}
		clientCity.setSortable(true);
		clientsTable.getSortOrder().clear();
		clientsTable.getSortOrder().add(clientCity);
	}

	@FXML
	void sortClientButtonClicked(ActionEvent event) {
		if (sortClientIcon.getGlyphName() == "ANGLE_UP") {
			sortClientIcon.setGlyphName("ANGLE_DOWN");
			clientName.setSortType(TableColumn.SortType.DESCENDING);
		} else {
			sortClientIcon.setGlyphName("ANGLE_UP");
			clientName.setSortType(TableColumn.SortType.ASCENDING);
		}
		clientName.setSortable(true);
		clientsTable.getSortOrder().clear();
		clientsTable.getSortOrder().add(clientName);
	}

	@FXML
	void sortCountryButtonClicked(ActionEvent event) {
		if (sortCountryIcon.getGlyphName() == "ANGLE_UP") {
				sortCountryIcon.setGlyphName("ANGLE_DOWN");
				clientCountry.setSortType(TableColumn.SortType.DESCENDING);
			} else {
				sortCountryIcon.setGlyphName("ANGLE_UP");
				clientCountry.setSortType(TableColumn.SortType.ASCENDING);
			}
		clientCountry.setSortable(true);
		clientsTable.getSortOrder().clear();
		clientsTable.getSortOrder().add(clientCountry);
	}

	@FXML
	void sortEmailButtonClicked(ActionEvent event) {
		if (sortEmailIcon.getGlyphName() == "ANGLE_UP") {
			sortEmailIcon.setGlyphName("ANGLE_DOWN");
			clientEmail.setSortType(TableColumn.SortType.DESCENDING);
		}else{
			sortEmailIcon.setGlyphName("ANGLE_UP");
			clientEmail.setSortType(TableColumn.SortType.ASCENDING);
		}
		clientEmail.setSortable(true);
		clientsTable.getSortOrder().clear();
		clientsTable.getSortOrder().add(clientEmail);
	}

	@FXML
	void sortNumberButtonClicked(ActionEvent event) {
		if (sortNumberIcon.getGlyphName() == "ANGLE_UP") {
			sortNumberIcon.setGlyphName("ANGLE_DOWN");
			clientNumber.setSortType(TableColumn.SortType.DESCENDING);
		}else {
			sortNumberIcon.setGlyphName("ANGLE_UP");
			clientNumber.setSortType(TableColumn.SortType.ASCENDING);
		}
		clientNumber.setSortable(true);
		clientsTable.getSortOrder().clear();
		clientsTable.getSortOrder().add(clientNumber);
	}

	@FXML
	void sortPhoneNumberButtonClicked(ActionEvent event) {
		if (sortPhoneNumberIcon.getGlyphName() == "ANGLE_UP") {
			sortPhoneNumberIcon.setGlyphName("ANGLE_DOWN");
			clientPhoneNumber.setSortType(TableColumn.SortType.DESCENDING);
		}else {
			sortPhoneNumberIcon.setGlyphName("ANGLE_UP");
			clientPhoneNumber.setSortType(TableColumn.SortType.ASCENDING);
		}
		clientPhoneNumber.setSortable(true);
		clientsTable.getSortOrder().clear();
		clientsTable.getSortOrder().add(clientPhoneNumber);
	}

	@FXML
	void sortZipCodeButtonClicked(ActionEvent event) {
		if (sortZipCodeIcon.getGlyphName() == "ANGLE_UP") {
			sortZipCodeIcon.setGlyphName("ANGLE_DOWN");
			clientZipCode.setSortType(TableColumn.SortType.DESCENDING);
		}else{
			sortZipCodeIcon.setGlyphName("ANGLE_UP");
			clientZipCode.setSortType(TableColumn.SortType.ASCENDING);
		}
		clientZipCode.setSortable(true);
		clientsTable.getSortOrder().clear();
		clientsTable.getSortOrder().add(clientZipCode);
	}

	@FXML
	void searchByClientIconClicked(MouseEvent event) {
		String searchText = searchClient.getText();
		FilteredList<Client> filteredList = clientData.filtered(Client -> {
			return Client.getClientName().contains(searchText);
		});
		numPages = numPages = (int) Math.ceil((double) filteredList.size() / ITEMS_PER_PAGE);
		clientPages.setText(String.valueOf(numPages));
		clientsTable.setItems(filteredList);
		if (searchText == null || searchText.isEmpty())
			clientsTable.setItems(getPaginatedData());
	}

	@FXML
	void searchByEmailIconClicked(MouseEvent event) {
		String searchText = searchEmail.getText();
		FilteredList<Client> filteredList = clientData.filtered(Client -> {
			return Client.getClientEmail().contains(searchText);
		});
		numPages = numPages = (int) Math.ceil((double) filteredList.size() / ITEMS_PER_PAGE);
		clientPages.setText(String.valueOf(numPages));
		clientsTable.setItems(filteredList);
		if(searchText == null || searchText.isEmpty())
			clientsTable.setItems(getPaginatedData());
	}

	@FXML
	void searchByPhoneNumberIconClicked(MouseEvent event) {
		String searchText = searchPhoneNumber.getText();
		FilteredList<Client> filteredList = clientData.filtered(Client ->{
			return Client.getClientPhoneNumber().contains(searchText);
		});
		numPages = numPages = (int) Math.ceil((double) filteredList.size() / ITEMS_PER_PAGE);
		clientPages.setText(String.valueOf(numPages));
		clientsTable.setItems(filteredList);
		if (searchText == null || searchText.isEmpty())
			clientsTable.setItems(getPaginatedData());
	}

	private ObservableList<Client> createPage(int pageIndex){
		int startIndex = pageIndex * ITEMS_PER_PAGE;
		int endIndex = Math.min(startIndex + ITEMS_PER_PAGE, clientData.size());
		return FXCollections.observableArrayList(clientData.subList(startIndex,endIndex));
	}

	public ObservableList<Client> getPaginatedData() {
		return paginatedData;
	}

	public void setPaginatedData(ObservableList<Client> paginatedData) {
		this.paginatedData = paginatedData;
	}
}
