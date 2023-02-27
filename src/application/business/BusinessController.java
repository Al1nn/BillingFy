package application.business;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private TableColumn<Business, String> businessCity;

    @FXML
    private TableColumn<Business, String> businessCountry;

    @FXML
    private Text businessCurrentPage;

    @FXML
    private TableColumn<Business, String> businessEmail;

    @FXML
    private TableColumn<Business, HBox> businessFunctions;

    @FXML
    private FontAwesomeIconView businessIcon;

    @FXML
    private AnchorPane businessLayout;

    @FXML
    private Text businessLengthText;

    @FXML
    private TableColumn<Business, String> businessName;

    @FXML
    private Button businessNextPage;

    @FXML
    private FontAwesomeIconView businessNextPageIcon;

    @FXML
    private TableColumn<Business, String> businessNumber;

    @FXML
    private Text businessPages;

    @FXML
    private TableColumn<Business, String> businessPhoneNumber;

    @FXML
    private Button businessPreviousPage;

    @FXML
    private FontAwesomeIconView businessPreviousPageIcon;

    @FXML
    private TableView<Business> businessTable;

    @FXML
    private Text businessTitle;

    @FXML
    private TableColumn<Business, String> businessZipCode;

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
    private FontAwesomeIconView SearchByBusinessEmail;

    @FXML
    private FontAwesomeIconView SearchByBusinessName;

    @FXML
    private FontAwesomeIconView SearchByBusinessPhoneNumber;

    @FXML
    private Button statisticsButton;

    @FXML
    private Circle statisticsCircle;

    @FXML
    private FontAwesomeIconView statisticsIcon;

    private ObservableList<Business> businessData;
    
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
        try {
            updateTable();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void updateTable() throws ClassNotFoundException {
        businessNumber.setCellValueFactory(new PropertyValueFactory<>("businessNumber"));
        centerCellsOnColumn(businessNumber);
        businessName.setCellValueFactory(new PropertyValueFactory<>("businessName"));
        centerCellsOnColumn(businessName);
        businessCountry.setCellValueFactory(new PropertyValueFactory<>("businessCountry"));
        centerCellsOnColumn(businessCountry);
        businessCity.setCellValueFactory(new PropertyValueFactory<>("businessCity"));
        centerCellsOnColumn(businessCity);
        businessZipCode.setCellValueFactory(new PropertyValueFactory<>("businessZipCode"));
        centerCellsOnColumn(businessZipCode);
        businessEmail.setCellValueFactory(new PropertyValueFactory<>("businessEmail"));
        centerCellsOnColumn(businessEmail);
        businessPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("businessPhoneNumber"));
        centerCellsOnColumn(businessPhoneNumber);
        businessFunctions.setCellValueFactory(new PropertyValueFactory<>("buttonPane"));
        centerBusinessFunctionColumn(businessFunctions);
        BusinessDatabase connection = new BusinessDatabase();
        businessData = connection.retriveData();
        businessTable.setEditable(true);
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
    private void centerCellsOnColumn(TableColumn<Business,String> tableColumn){
        tableColumn.setCellFactory(column -> new TableCell<Business,String>(){
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
    private void centerBusinessFunctionColumn(TableColumn<Business,HBox> tableColumn){
        tableColumn.setCellFactory(column-> new TableCell<Business,HBox>(){
            @Override
            protected void updateItem(HBox item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    Business business = businessTable.getItems().get(getIndex());
                    item = business.getButtonPane();
                    item.setAlignment(Pos.CENTER);
                    setGraphic(item);
                }
            }
        });
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
		}
    

    @FXML
    void addBusinessButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/business/popup/BusinessPopup.fxml"));
		Stage childStage = new Stage();
		Stage parentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		String popupCSS = this.getClass().getResource("/application/business/popup/BusinessPopupStyle.css").toExternalForm();		
		childStage.setScene(new Scene(root));
		childStage.getScene().getStylesheets().add(popupCSS);
		childStage.initModality(Modality.APPLICATION_MODAL);
		childStage.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
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
            try {
                updateTable();
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
//		stage.centerOnScreen();
		if(!stage.isFullScreen())
		{
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		}
		//stage.centerOnScreen();
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
//		stage.centerOnScreen();
		if(!stage.isFullScreen())
		{
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		}
		//stage.centerOnScreen();
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
//		stage.centerOnScreen();
		if(!stage.isFullScreen())
		{
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		}
		//stage.centerOnScreen();
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
//		stage.centerOnScreen();
		if(!stage.isFullScreen())
		{
		ResizeWindow trigger = new ResizeWindow();
		trigger.resizeWindow(root, stage);
		}
		//stage.centerOnScreen();
		stage.setMinWidth(1350);
		stage.setMinHeight(750);
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
    void exitButtonClicked(ActionEvent event) {
    	Platform.exit();
    }

    

    @FXML
    void sortBusinessButtonClicked(ActionEvent event) {
    	if(sortBusinessIcon.getGlyphName() == "ANGLE_UP") {
            sortBusinessIcon.setGlyphName("ANGLE_DOWN");
            businessName.setSortType(TableColumn.SortType.DESCENDING);
        }else{
    		sortBusinessIcon.setGlyphName("ANGLE_UP");
            businessName.setSortType(TableColumn.SortType.ASCENDING);
        }
        businessName.setSortable(true);
        businessTable.getSortOrder().clear();
        businessTable.getSortOrder().add(businessName);
    }

    @FXML
    void sortCityButtonClicked(ActionEvent event) {
    	if (sortCityIcon.getGlyphName() == "ANGLE_UP") {
			sortCityIcon.setGlyphName("ANGLE_DOWN");
	        businessCity.setSortType(TableColumn.SortType.DESCENDING);
		} else {
            sortCityIcon.setGlyphName("ANGLE_UP");
            businessCity.setSortType(TableColumn.SortType.ASCENDING);
        }
        businessCity.setSortable(true);
        businessTable.getSortOrder().clear();
        businessTable.getSortOrder().add(businessCity);
    }

    @FXML
    void sortCountryButtonClicked(ActionEvent event) {
    	if(sortCountryIcon.getGlyphName() == "ANGLE_UP") {
            sortCountryIcon.setGlyphName("ANGLE_DOWN");
            businessCountry.setSortType(TableColumn.SortType.DESCENDING);
        }else {
            sortCountryIcon.setGlyphName("ANGLE_UP");
            businessCountry.setSortType(TableColumn.SortType.ASCENDING);
        }
        businessCountry.setSortable(true);
        businessTable.getSortOrder().clear();
        businessTable.getSortOrder().add(businessCountry);
    }

    @FXML
    void sortEmailButtonClicked(ActionEvent event) {
    	if (sortEmailIcon.getGlyphName() == "ANGLE_UP") {
            sortEmailIcon.setGlyphName("ANGLE_DOWN");
            businessEmail.setSortType(TableColumn.SortType.DESCENDING);
        }else {
            sortEmailIcon.setGlyphName("ANGLE_UP");
            businessEmail.setSortType(TableColumn.SortType.ASCENDING);
        }
        businessEmail.setSortable(true);
        businessTable.getSortOrder().clear();
        businessTable.getSortOrder().add(businessEmail);
    }

    @FXML
    void sortNumberButtonClicked(ActionEvent event) {
    	if(sortNumberIcon.getGlyphName() == "ANGLE_UP") {
            sortNumberIcon.setGlyphName("ANGLE_DOWN");
            businessNumber.setSortType(TableColumn.SortType.DESCENDING);
        }else {
			sortNumberIcon.setGlyphName("ANGLE_UP");
            businessNumber.setSortType(TableColumn.SortType.ASCENDING);
		}
        businessNumber.setSortable(true);
        businessTable.getSortOrder().clear();
        businessTable.getSortOrder().add(businessNumber);
    }

    @FXML
    void sortPhoneNumberButtonClicked(ActionEvent event) {
    	if(sortPhoneNumberIcon.getGlyphName() == "ANGLE_UP") {
            sortPhoneNumberIcon.setGlyphName("ANGLE_DOWN");
            businessPhoneNumber.setSortType(TableColumn.SortType.DESCENDING);
        }else {
            sortPhoneNumberIcon.setGlyphName("ANGLE_UP");
            businessPhoneNumber.setSortType(TableColumn.SortType.ASCENDING);
        }
        businessPhoneNumber.setSortable(true);
        businessTable.getSortOrder().clear();
        businessTable.getSortOrder().add(businessPhoneNumber);
    }

    @FXML
    void sortZipCodeButtonClicked(ActionEvent event) {
    	if(sortZipCodeIcon.getGlyphName() == "ANGLE_UP") {
            sortZipCodeIcon.setGlyphName("ANGLE_DOWN");
            businessZipCode.setSortType(TableColumn.SortType.DESCENDING);
        }else {
            sortZipCodeIcon.setGlyphName("ANGLE_UP");
            businessZipCode.setSortType(TableColumn.SortType.ASCENDING);
        }
        businessZipCode.setSortable(true);
        businessTable.getSortOrder().clear();
        businessTable.getSortOrder().add(businessZipCode);
    }

    @FXML
    void SearchByBusinessEmailClicked(MouseEvent event) {
        System.out.println("Search By Business Email");
    }

    @FXML
    void SearchByBusinessNameClicked(MouseEvent event) {
        System.out.println("Search By Business Name");
    }

    @FXML
    void SearchByBusinessPhoneNumberClicked(MouseEvent event) {
        System.out.println("Search By Phone Number");
    }

	

}
