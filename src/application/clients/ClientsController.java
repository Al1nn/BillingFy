package application.clients;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.utilities.DraggableWindow;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ClientsController implements Initializable{

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
    private TableView<?> clientsTable;

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
		
		billingsButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				billingsCircle.setFill(Color.LIGHTGRAY);
				billingsIcon.setFill(Color.web("#5283E9"));
			}
		
		});
		billingsButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				billingsCircle.setFill(Color.web("#2E4EB8"));
				billingsIcon.setFill(Color.web("#FFFFFF"));
				billingsButton.setTextFill(Color.WHITE);
			}
		});
		
		servicesButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				servicesCircle.setFill(Color.LIGHTGRAY);
				servicesIcon.setFill(Color.web("#5283E9"));
			}
		});
		
		servicesButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				servicesCircle.setFill(Color.web("#2E4EB8"));
				servicesIcon.setFill(Color.web("#FFFFFF"));
				servicesButton.setTextFill(Color.WHITE);
			}
		
		});
		
		statisticsButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				statisticsCircle.setFill(Color.LIGHTGRAY);
				statisticsIcon.setFill(Color.web("#5283E9"));
			}
		
		});
		
		statisticsButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				statisticsCircle.setFill(Color.web("#2E4EB8"));
				statisticsIcon.setFill(Color.web("#FFFFFF"));
				statisticsButton.setTextFill(Color.WHITE);
			}
		});
		
		businessButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				businessCircle.setFill(Color.LIGHTGRAY);
				businessIcon.setFill(Color.web("#5283E9"));
			}
		});
		
		businessButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				businessCircle.setFill(Color.web("#2E4EB8"));
				businessIcon.setFill(Color.web("#FFFFFF"));
				businessButton.setTextFill(Color.WHITE);
			}
	
		});
		
		addBillingButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				addBillingCircle.setFill(Color.LIGHTGRAY);
				addBillingIcon.setFill(Color.web("#5283E9"));
			}
		});
		
		addBillingButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				addBillingCircle.setFill(Color.web("#2E4EB8"));
				addBillingIcon.setFill(Color.web("#FFFFFF"));
				addBillingButton.setTextFill(Color.WHITE);
			}
		});
		
	}
    
    @FXML
    void addBillingButtonClicked(ActionEvent event) {

    }

    @FXML
    void billingsButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/billings/Billings.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		DraggableWindow window = new DraggableWindow();
		window.dragWindow(root, stage);
		Scene scene = new Scene(root);
		String billingCSS = this.getClass().getResource("/application/billings/BillingStyle.css").toExternalForm();
		scene.getStylesheets().add(billingCSS);
		window.fullscreenWindow(scene, stage);
		stage.setFullScreenExitHint("");
		stage.setScene(scene);
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
    void clientsButtonClicked(ActionEvent event) {

    }

    @FXML
    void exitButtonClicked(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void servicesButtonClicked(ActionEvent event) {

    }

    @FXML
    void sortCityButtonClicked(ActionEvent event) {
    	if (sortCityIcon.getGlyphName() == "ANGLE_UP") {
			sortCityIcon.setGlyphName("ANGLE_DOWN");
		}else
			sortCityIcon.setGlyphName("ANGLE_UP");
    }

    @FXML
    void sortClientButtonClicked(ActionEvent event) {
    	if(sortClientIcon.getGlyphName() == "ANGLE_UP") {
    		sortClientIcon.setGlyphName("ANGLE_DOWN");
    	}else
    		sortClientIcon.setGlyphName("ANGLE_UP");
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
    	if(sortEmailIcon.getGlyphName() == "ANGLE_UP")
    		sortEmailIcon.setGlyphName("ANGLE_DOWN");
    	else
    		sortEmailIcon.setGlyphName("ANGLE_UP");
    }

    @FXML
    void sortNumberButtonClicked(ActionEvent event) {
    	if(sortNumberIcon.getGlyphName() == "ANGLE_UP")
    		sortNumberIcon.setGlyphName("ANGLE_DOWN");
    	else 
			sortNumberIcon.setGlyphName("ANGLE_UP");
		
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
