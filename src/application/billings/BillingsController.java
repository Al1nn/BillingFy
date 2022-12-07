package application.billings;


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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class BillingsController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableColumn<Void, Void> billingClient;

    @FXML
    private Text billingCurrentPage;

    @FXML
    private TableColumn<Void, Void> billingDueDate;

    @FXML
    private TableColumn<Void, Void> billingFunctions;

    @FXML
    private TableColumn<Void, Void> billingIssueDate;

    @FXML
    private AnchorPane billingLayout;

    @FXML
    private Text billingLengthText;

    @FXML
    private Button billingNextPage;

    @FXML
    private FontAwesomeIconView billingNextPageIcon;

    @FXML
    private TableColumn<Void, Void> billingNumber;

    @FXML
    private Text billingPages;

    @FXML
    private Button billingPreviousPage;

    @FXML
    private FontAwesomeIconView billingPreviousPageIcon;

    @FXML
    private TableColumn<Void, Void> billingStatus;

    @FXML
    private TableColumn<Void, Void> billingSum;

    @FXML
    private TableView<Billing> billingTable;

    @FXML
    private TableColumn<Void, Void> billingTax;

    @FXML
    private Text billingTitle;

    @FXML
    private TableColumn<Void, Void> billingTotal;

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
    
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		String[] itemPerPageOptions = { "10 iteme", "20 iteme", "30 iteme" };
		itemsPerPage.getItems().addAll(itemPerPageOptions);
		String[] statusOptions = {"Platit","Neplatit"};
		searchStatus.getItems().addAll(statusOptions);
		setInitialDesignButtons();
		MeniuButtonsStyle style = new MeniuButtonsStyle();
		style.styleButtons(clientsButton, clientsIcon, clientsCircle);
		style.styleButtons(servicesButton, servicesIcon, servicesCircle);
		style.styleButtons(statisticsButton, statisticsIcon, statisticsCircle);
		style.styleButtons(businessButton, businessIcon, businessCircle);
		style.styleButtons(addBillingButton, addBillingIcon, addBillingCircle);
		
		billingNumber.setCellValueFactory(new PropertyValueFactory<>("billingNumber"));
		billingClient.setCellValueFactory(new PropertyValueFactory<>("billingClient"));
		billingIssueDate.setCellValueFactory(new PropertyValueFactory<>("billingIssueDate"));
		billingDueDate.setCellValueFactory(new PropertyValueFactory<>("billingDueDate"));
		billingSum.setCellValueFactory(new PropertyValueFactory<>("billingSum"));
		billingTax.setCellValueFactory(new PropertyValueFactory<>("billingTax"));
		billingTotal.setCellValueFactory(new PropertyValueFactory<>("billingTotal"));
		billingStatus.setCellValueFactory(new PropertyValueFactory<>("statusPane"));
		billingFunctions.setCellValueFactory(new PropertyValueFactory<>("pane"));

		final ObservableList<Billing> billingsData = FXCollections.observableArrayList(
				new Billing("1", "SC COMPANY NAME", "12.12.2O22", "12.12.2022", "100.000.000 $", "100.000.000 $", "100.000.000 $", "Neplatit"),
				new Billing("1", "SC CACA S.R.L", "12.11.2020", "12.12.2020", "100.000.000 $", "100.000.000 $", "100.000.000 $", "Platit")
				);
		
		billingTable.setItems(billingsData);
		billingLengthText.setText(String.valueOf(billingTable.getItems().size()));
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
	
	@FXML
	public void exitButtonClicked(ActionEvent event) {
		Platform.exit();
	}
	
    @FXML
    void billingNextPageClicked(ActionEvent event) {

    }

    @FXML
    void billingPreviousPageClicked(ActionEvent event) {

    }
    
    @FXML
    void sortClientButtonClicked(ActionEvent event) {
    	if(sortClientIcon.getGlyphName() == "ANGLE_UP")
    		sortClientIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortClientIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortDueDateButtonClicked(ActionEvent event) {
    	if(sortDueDateIcon.getGlyphName() == "ANGLE_UP")
    		sortDueDateIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortDueDateIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortIssueDateButtonClicked(ActionEvent event) {
    	if(sortIssueDateIcon.getGlyphName() == "ANGLE_UP")
    		sortIssueDateIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortIssueDateIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortNumberButtonClicked(ActionEvent event) {
    	if(sortNumberIcon.getGlyphName() == "ANGLE_UP")
    		sortNumberIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortNumberIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortStatusButtonClicked(ActionEvent event) {
    	if(sortStatusIcon.getGlyphName() == "ANGLE_UP")
    		sortStatusIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortStatusIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortSumButtonClicked(ActionEvent event) {
    	if(sortSumIcon.getGlyphName() == "ANGLE_UP")
    		sortSumIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortSumIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortTaxButtonClicked(ActionEvent event) {
    	if(sortTaxIcon.getGlyphName() == "ANGLE_UP")
    		sortTaxIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortTaxIcon.setGlyphName("ANGLE_UP");
    
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
		stage.centerOnScreen();
		stage.show();
    }
    
    @FXML
    void servicesButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void statisticsButtonClicked(ActionEvent event) {

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
    void addBillingButtonClicked(ActionEvent event) {

    }
}
