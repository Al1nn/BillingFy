package application.business;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BusinessController implements Initializable{

    @FXML
    private Button addBillingButton;

    @FXML
    private Circle addBillingCircle;

    @FXML
    private MaterialIconView addBillingIcon;

    @FXML
    private Button addBusinessButton;

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
    private TableColumn<?, ?> businessCity;

    @FXML
    private TableColumn<?, ?> businessCountry;

    @FXML
    private Text businessCurrentPage;

    @FXML
    private TableColumn<?, ?> businessEmail;

    @FXML
    private TableColumn<?, ?> businessFunctions;

    @FXML
    private FontAwesomeIconView businessIcon;

    @FXML
    private AnchorPane businessLayout;

    @FXML
    private Text businessLengthText;

    @FXML
    private TableColumn<?, ?> businessName;

    @FXML
    private Button businessNextPage;

    @FXML
    private FontAwesomeIconView businessNextPageIcon;

    @FXML
    private TableColumn<?, ?> businessNumber;

    @FXML
    private Text businessPages;

    @FXML
    private TableColumn<?, ?> businessPhoneNumber;

    @FXML
    private Button businessPreviousPage;

    @FXML
    private FontAwesomeIconView businessPreviousPageIcon;

    @FXML
    private TableView<Business> businessTable;

    @FXML
    private Text businessTitle;

    @FXML
    private TableColumn<?, ?> businessZipCode;

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
    private TextField searchBusiness;

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
    private Button sortBusinessButton;

    @FXML
    private FontAwesomeIconView sortBusinessIcon;

    @FXML
    private Button sortCityButton;

    @FXML
    private FontAwesomeIconView sortCityIcon;

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
		style.styleButtons(clientsButton,clientsIcon, clientsCircle);
		style.styleButtons(servicesButton, servicesIcon, servicesCircle);
		style.styleButtons(statisticsButton, statisticsIcon, statisticsCircle);
		style.styleButtons(addBillingButton, addBillingIcon, addBillingCircle);
		
		businessNumber.setCellValueFactory(new PropertyValueFactory<>("businessNumber"));
		businessName.setCellValueFactory(new PropertyValueFactory<>("businessName"));
		businessCountry.setCellValueFactory(new PropertyValueFactory<>("businessCountry"));
		businessCity.setCellValueFactory(new PropertyValueFactory<>("businessCity"));
		businessZipCode.setCellValueFactory(new PropertyValueFactory<>("businessZipCode"));
		businessEmail.setCellValueFactory(new PropertyValueFactory<>("businessEmail"));
		businessPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("businessPhoneNumber"));
		businessFunctions.setCellValueFactory(new PropertyValueFactory<>("buttonPane"));
		
		final ObservableList<Business> businessData = FXCollections.observableArrayList(
				new Business("1", "SC COMPANY NAME", "Romania", "Pitesti", "142424", "csgo@gmail.com", "0724636474"),
				new Business("2", "SC COMPANY NAME", "Romania", "Pitesti", "163263", "atwg@gmail.com", "0742523623")
				);
		businessTable.setItems(businessData);
		businessLengthText.setText(String.valueOf(businessTable.getItems().size()));
    }
    
    public void setInitialDesignButtons() {
    	billingsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
    	clientsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
    	servicesButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		statisticsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		businessButton.setStyle("-fx-background-color: white; -fx-background-radius: 15px; -fx-border-radius: 15 15 15 15; "
				+ "-fx-text-fill: #5283E9");
		businessIcon.setFill(Color.web("#5283E9"));
    	addBillingButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
	}
    
    @FXML
    void addBillingButtonClicked(ActionEvent event) {

    }

    @FXML
    void addBusinessButtonClicked(ActionEvent event) {

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
    void businessButtonClicked(ActionEvent event) {

    }

    @FXML
    void clientNextPageClicked(ActionEvent event) {

    }

    @FXML
    void clientPreviousPageClicked(ActionEvent event) {

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
		stage.centerOnScreen();
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
    void sortBusinessButtonClicked(ActionEvent event) {
    	if(sortBusinessIcon.getGlyphName() == "ANGLE_UP")
    		sortBusinessIcon.setGlyphName("ANGLE_DOWN");
    	else
    		sortBusinessIcon.setGlyphName("ANGLE_UP");
    }

    @FXML
    void sortCityButtonClicked(ActionEvent event) {
    	if (sortCityIcon.getGlyphName() == "ANGLE_UP") {
			sortCityIcon.setGlyphName("ANGLE_DOWN");
		} else
			sortCityIcon.setGlyphName("ANGLE_UP");
    }

    @FXML
    void sortCountryButtonClicked(ActionEvent event) {
    	if(sortCountryIcon.getGlyphName() == "ANGLE_UP")
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
    	if(sortNumberIcon.getGlyphName() == "ANGLE_UP")
    		sortNumberIcon.setGlyphName("ANGLE_DOWN");
    	else {
			sortNumberIcon.setGlyphName("ANGLE_UP");
		}
    }

    @FXML
    void sortPhoneNumberButtonClicked(ActionEvent event) {
    	if(sortPhoneNumberIcon.getGlyphName() == "ANGLE_UP")
    		sortPhoneNumberIcon.setGlyphName("ANGLE_DOWN");
    	else
    		sortPhoneNumberIcon.setGlyphName("ANGLE_UP");
    }

    @FXML
    void sortZipCodeButtonClicked(ActionEvent event) {
    	if(sortZipCodeIcon.getGlyphName() == "ANGLE_UP")
    		sortZipCodeIcon.setGlyphName("ANGLE_DOWN");
    	else
    		sortZipCodeIcon.setGlyphName("ANGLE_UP");
    }

    @FXML
    void statisticsButtonClicked(ActionEvent event) {

    }

	

}
