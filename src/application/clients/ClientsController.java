package application.clients;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.utilities.DraggableWindow;
import application.utilities.MeniuButtonsStyle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
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
	private TableColumn<?, ?> clientCity;

	@FXML
	private TableColumn<?, ?> clientCountry;

	@FXML
	private Text clientCurrentPage;

	@FXML
	private TableColumn<?, ?> clientEmail;

	@FXML
	private TableColumn<?, ?> clientFunctions;

	@FXML
	private AnchorPane clientLayout;

	@FXML
	private Text clientLengthText;

	@FXML
	private TableColumn<?, ?> clientName;

	@FXML
	private Button clientNextPage;

	@FXML
	private FontAwesomeIconView clientNextPageIcon;

	@FXML
	private TableColumn<?, ?> clientNumber;

	@FXML
	private Text clientPages;

	@FXML
	private TableColumn<?, ?> clientPhoneNumber;

	@FXML
	private Button clientPreviousPage;

	@FXML
	private FontAwesomeIconView clientPreviousPageIcon;

	@FXML
	private Text clientTitle;

	@FXML
	private TableColumn<?, ?> clientZipCode;

	@FXML
	private Button clientsButton;

	@FXML
	private Circle clientsCircle;

	@FXML
	private FontAwesomeIconView clientsIcon;

	@FXML
	private TableView<Client> clientsTable;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] itemPerPageOptions = { "10 iteme", "20 iteme", "30 iteme" };
		itemsPerPage.getItems().addAll(itemPerPageOptions);
		setInitialDesignButtons();
		MeniuButtonsStyle style = new MeniuButtonsStyle();
		style.styleButtons(billingsButton, billingsIcon, billingsCircle);
		style.styleButtons(servicesButton, servicesIcon, servicesCircle);
		style.styleButtons(statisticsButton, statisticsIcon, statisticsCircle);
		style.styleButtons(businessButton, businessIcon, businessCircle);
		style.styleButtons(addBillingButton, addBillingIcon, addBillingCircle);

		clientNumber.setCellValueFactory(new PropertyValueFactory<>("clientNumber"));
		clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
		clientCountry.setCellValueFactory(new PropertyValueFactory<>("clientCountry"));
		clientCity.setCellValueFactory(new PropertyValueFactory<>("clientCity"));
		clientZipCode.setCellValueFactory(new PropertyValueFactory<>("clientZipCode"));
		clientEmail.setCellValueFactory(new PropertyValueFactory<>("clientEmail"));
		clientPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("clientPhoneNumber"));
		clientFunctions.setCellValueFactory(new PropertyValueFactory<>("buttonPane"));
		final ObservableList<Client> clientData = FXCollections.observableArrayList(
				new Client("1", "SC COMPANY NAME", "Romania", "Pitesti", "115025", "cascsac@gmail.com", "0745263634"),
				new Client("1", "SC CACA NAME", "Romania", "Costesti", "162636", "geogsg@gmail.com", "0746263635"));

		clientsTable.setItems(clientData);
		clientLengthText.setText(String.valueOf(clientsTable.getItems().size()));
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
	void addBillingButtonClicked(ActionEvent event) {

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
		stage.centerOnScreen();
		stage.show();
	}

	@FXML
	void addClientButtonClicked(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/clients/popup/ClientPopup.fxml"));
		Stage stage = new Stage();
		DraggableWindow window = new DraggableWindow();
		String popupCSS = this.getClass().getResource("/application/clients/popup/ClientPopupStyle.css").toExternalForm();
		stage.setScene(new Scene(root));
		stage.getScene().getStylesheets().add(popupCSS);
		stage.initModality(Modality.NONE);
		stage.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
		stage.initStyle(StageStyle.UNDECORATED);
		stage.centerOnScreen();
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
		stage.centerOnScreen();
		stage.show();
	}

	@FXML
	void clientNextPageClicked(ActionEvent event) {

	}

	@FXML
	void clientPreviousPageClicked(ActionEvent event) {

	}

	@FXML
	void clientsButtonClicked(ActionEvent event) {

	}

	@FXML
	void exitButtonClicked(ActionEvent event) {
		Platform.exit();
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
		stage.centerOnScreen();
		stage.show();
	}

	@FXML
	void sortCityButtonClicked(ActionEvent event) {
		if (sortCityIcon.getGlyphName() == "ANGLE_UP") {
			sortCityIcon.setGlyphName("ANGLE_DOWN");
		} else
			sortCityIcon.setGlyphName("ANGLE_UP");
	}

	@FXML
	void sortClientButtonClicked(ActionEvent event) {
		if (sortClientIcon.getGlyphName() == "ANGLE_UP") {
			sortClientIcon.setGlyphName("ANGLE_DOWN");
		} else
			sortClientIcon.setGlyphName("ANGLE_UP");
	}

	@FXML
	void sortCountryButtonClicked(ActionEvent event) {
		if (sortCountryIcon.getGlyphName() == "ANGLE_UP")
			sortCountryIcon.setGlyphName("ANGLE_DOWN");
		else
			sortCountryIcon.setGlyphName("ANGLE_UP");
	}

	@FXML
	void sortEmailButtonClicked(ActionEvent event) {
		if (sortEmailIcon.getGlyphName() == "ANGLE_UP")
			sortEmailIcon.setGlyphName("ANGLE_DOWN");
		else
			sortEmailIcon.setGlyphName("ANGLE_UP");
	}

	@FXML
	void sortNumberButtonClicked(ActionEvent event) {
		if (sortNumberIcon.getGlyphName() == "ANGLE_UP")
			sortNumberIcon.setGlyphName("ANGLE_DOWN");
		else
			sortNumberIcon.setGlyphName("ANGLE_UP");

	}

	@FXML
	void sortPhoneNumberButtonClicked(ActionEvent event) {
		if (sortPhoneNumberIcon.getGlyphName() == "ANGLE_UP")
			sortPhoneNumberIcon.setGlyphName("ANGLE_DOWN");
		else
			sortPhoneNumberIcon.setGlyphName("ANGLE_UP");
	}

	@FXML
	void sortZipCodeButtonClicked(ActionEvent event) {
		if (sortZipCodeIcon.getGlyphName() == "ANGLE_UP")
			sortZipCodeIcon.setGlyphName("ANGLE_DOWN");
		else
			sortZipCodeIcon.setGlyphName("ANGLE_UP");
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
		stage.centerOnScreen();
		stage.show();
	}

}
