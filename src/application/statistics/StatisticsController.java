package application.statistics;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StatisticsController implements Initializable{

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
    private Button servicesButton;

    @FXML
    private Circle servicesCircle;

    @FXML
    private FontAwesomeIconView servicesIcon;

    @FXML
    private AnchorPane servicesLayout;

    @FXML
    private Button statisticsButton;

    @FXML
    private Circle statisticsCircle;

    @FXML
    private FontAwesomeIconView statisticsIcon;

    @FXML
    private Text statisticsTitle;
    

    @FXML
    private BarChart<?, ?> servicesIncomingsChart;

    @FXML
    private BarChart<?, ?> servicesNumberChart;
    
    @FXML
    private PieChart clientsPieChart;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setInitialDesignButtons();
		MeniuButtonsStyle style = new MeniuButtonsStyle();
		style.styleButtons(billingsButton, billingsIcon, billingsCircle);
		style.styleButtons(clientsButton, clientsIcon, clientsCircle);
		style.styleButtons(servicesButton, servicesIcon, servicesCircle);
		style.styleButtons(businessButton, businessIcon, businessCircle);
		style.styleButtons(addBillingButton, addBillingIcon, addBillingCircle);
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Grapefruit",13),
				new PieChart.Data("Oranges", 25),
				new PieChart.Data("Apples", 50)
				);
		clientsPieChart.setData(pieChartData);
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("data1");
		series1.getData().add(new XYChart.Data("Caca",250));
		series1.getData().add(new XYChart.Data("Muie",500));
		
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("data2");
		series2.getData().add(new XYChart.Data("Caca",350));
		series2.getData().add(new XYChart.Data("Muie",750));
		
		XYChart.Series series1I = new XYChart.Series();
		series1I.setName("data1");
		series1I.getData().add(new XYChart.Data("Caca",150));
		series1I.getData().add(new XYChart.Data("Muie",450));
		
		XYChart.Series series2I = new XYChart.Series();
		series2I.setName("data2");
		series2I.getData().add(new XYChart.Data("Caca",350));
		series2I.getData().add(new XYChart.Data("Muie",150));
		
		
		
		servicesNumberChart.getData().addAll(series1,series2);

		servicesIncomingsChart.getData().addAll(series1I,series2I);
		
		}
    
    public void setInitialDesignButtons() {
		billingsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ " -fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		clientsButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
				+ "-fx-border-radius: 15px; -fx-border-color: rgba(255,255,255,0.2);");
		statisticsButton.setStyle("-fx-background-color: white; -fx-background-radius: 15px; -fx-border-radius: 15 15 15 15;"
				+ "-fx-text-fill: #5283E9");
		statisticsIcon.setFill(Color.web("#5283E9"));
		servicesButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 15px;"
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
		//stage.centerOnScreen();
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
    void statisticsButtonClicked(ActionEvent event) {

    }

	

}

