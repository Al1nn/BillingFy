package application.services;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.clients.Client;
import application.utilities.DraggableWindow;
import application.utilities.MeniuButtonsStyle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private TextField searchService;

    @FXML
    private Button servicesButton;

    @FXML
    private Circle servicesCircle;

    @FXML
    private Text servicesCurrentPage;

    @FXML
    private TableColumn<?, ?> servicesDescription;

    @FXML
    private TableColumn<?, ?> servicesFunctions;

    @FXML
    private FontAwesomeIconView servicesIcon;

    @FXML
    private AnchorPane servicesLayout;

    @FXML
    private Text servicesLengthText;

    @FXML
    private TableColumn<?, ?> servicesName;

    @FXML
    private Button servicesNextPage;

    @FXML
    private FontAwesomeIconView servicesNextPageIcon;

    @FXML
    private TableColumn<?, ?> servicesNumber;

    @FXML
    private Text servicesPages;

    @FXML
    private Button servicesPreviousPage;

    @FXML
    private FontAwesomeIconView servicesPreviousPageIcon;

    @FXML
    private TableColumn<?, ?> servicesPrice;

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
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	String[] itemPerPageOptions = { "10 iteme", "20 iteme", "30 iteme" };
		itemsPerPage.getItems().addAll(itemPerPageOptions);
		setInitialDesignButtons();
		MeniuButtonsStyle style = new MeniuButtonsStyle();
		style.styleButtons(billingsButton, billingsIcon, billingsCircle);
		style.styleButtons(clientsButton, clientsIcon, clientsCircle);
		style.styleButtons(statisticsButton, statisticsIcon, statisticsCircle);
		style.styleButtons(businessButton, businessIcon, businessCircle);
		style.styleButtons(addBillingButton, addBillingIcon, addBillingCircle);
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("data1");
		series1.getData().add(new XYChart.Data("caca",50));
		series1.getData().add(new XYChart.Data("pisu",100));
		
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("data2");
		series2.getData().add(new XYChart.Data("caca",250));
		series2.getData().add(new XYChart.Data("Muia",50));
		
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("data3");
		series3.getData().add(new XYChart.Data("pisu",400));
		series3.getData().add(new XYChart.Data("Muia",500));
		servicesNumberChart.getData().addAll(series1,series2,series3);
		
		servicesNumber.setCellValueFactory(new PropertyValueFactory<>("servicesNumber"));
		servicesName.setCellValueFactory(new PropertyValueFactory<>("servicesName"));
		servicesDescription.setCellValueFactory(new PropertyValueFactory<>("servicesDescription"));
		servicesPrice.setCellValueFactory(new PropertyValueFactory<>("servicesPrice"));
		servicesFunctions.setCellValueFactory(new PropertyValueFactory<>("buttonPane"));
		
		final ObservableList<Service> servicesData = FXCollections.observableArrayList(
				new Service("1", "SC COMPANY NAME", "Descriere","5000"),
				new Service("1", "SC CACA NAME", "Descriere","2500"));
		
		servicesTable.setItems(servicesData);
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
    void addBillingButtonClicked(ActionEvent event) {

    }

    @FXML
    void addServicesButtonClicked(ActionEvent event) {

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
    void statisticsButtonClicked(ActionEvent event) {

    }
    
    @FXML
    void exitButtonClicked(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void servicesButtonClicked(ActionEvent event) {

    }

    @FXML
    void servicesNextPageClicked(ActionEvent event) {

    }

    @FXML
    void servicesPreviousPageClicked(ActionEvent event) {

    }

    @FXML
    void sortNumberButtonClicked(ActionEvent event) {
    	if(sortNumberIcon.getGlyphName() == "ANGLE_UP")
    		sortNumberIcon.setGlyphName("ANGLE_DOWN");
    	else
    		sortNumberIcon.setGlyphName("ANGLE_UP");
    }

    @FXML
    void sortPriceButtonClicked(ActionEvent event) {
    	if(sortPriceIcon.getGlyphName() == "ANGLE_UP")
    		sortPriceIcon.setGlyphName("ANGLE_DOWN");
    	else
    		sortPriceIcon.setGlyphName("ANGLE_UP");
    }

    @FXML
    void sortServicesButtonClicked(ActionEvent event) {
    	if (sortServicesIcon.getGlyphName() == "ANGLE_UP") {
			sortServicesIcon.setGlyphName("ANGLE_DOWN");
		}else
			sortServicesIcon.setGlyphName("ANGLE_UP");
    }

	

    

}
