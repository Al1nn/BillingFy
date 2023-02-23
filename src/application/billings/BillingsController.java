package application.billings;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.print.attribute.standard.PrinterMakeAndModel;

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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


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
		updateTable();
	}
	private void updateTable(){
		billingNumber.setCellValueFactory(new PropertyValueFactory<>("billingNumber"));
		centerCellsOnColumn(billingNumber);
		billingClient.setCellValueFactory(new PropertyValueFactory<>("billingClient"));
		centerCellsOnColumn(billingClient);
		billingIssueDate.setCellValueFactory(new PropertyValueFactory<>("billingIssueDate"));
		centerCellsOnColumn(billingIssueDate);
		billingDueDate.setCellValueFactory(new PropertyValueFactory<>("billingDueDate"));
		centerCellsOnColumn(billingDueDate);
		billingSum.setCellValueFactory(new PropertyValueFactory<>("billingSum"));
		centerCellsOnColumn(billingSum);
		billingTax.setCellValueFactory(new PropertyValueFactory<>("billingTax"));
		centerCellsOnColumn(billingTax);
		billingTotal.setCellValueFactory(new PropertyValueFactory<>("billingTotal"));
		centerCellsOnColumn(billingTotal);
		billingStatus.setCellValueFactory(new PropertyValueFactory<>("statusPane"));
		centerStatusColumn(billingStatus);
		billingFunctions.setCellValueFactory(new PropertyValueFactory<>("pane"));
		centerBillingFunctionsColumn(billingFunctions);
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
		//stage.centerOnScreen();
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
		}
}
