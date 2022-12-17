package application.services.popup;


import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ServicesPopupController implements Initializable{

    @FXML
    private Button addServiceButton;

    @FXML
    private Button exitPopup;

    @FXML
    private FontAwesomeIconView passwordIcon;

    @FXML
    private Button saveData;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane pane;
    
    @FXML
    private GridPane contentPane;
    
    private int nr = 1;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	pane = new GridPane();
    	contentPane = new GridPane();
    	initializeGridPane(contentPane);
    	pane.addRow(0, contentPane);
    	pane.setVgap(10);
    	scrollPane.setContent(pane);
	}
    
    private void initializeGridPane(GridPane content) {
    	TextField serviceName = new TextField();
    	serviceName.setPrefWidth(200);
    	serviceName.setPrefHeight(40);
    	serviceName.setPromptText("Nume Serviciu");
    	TextField serviceAmount = new TextField();
    	serviceAmount.setPrefWidth(125);
    	serviceAmount.setPrefHeight(40);
    	serviceAmount.setPromptText("Cantitate");
    	TextField servicePrice = new TextField();
    	servicePrice.setPrefWidth(200);
    	servicePrice.setPrefHeight(40);
    	servicePrice.setPromptText("Pret");
    	ComboBox<String> serviceExchange = new ComboBox<String>();
    	serviceExchange.setPrefWidth(125);
    	serviceExchange.setPrefHeight(40);
    	serviceExchange.setPromptText("Valuta");
    	String[] exchangeOptions = {"RON","EUR"};
    	serviceExchange.getItems().addAll(exchangeOptions);
    	TextField serviceDescription = new TextField();
    	serviceDescription.setPrefWidth(200);
    	serviceDescription.setPrefHeight(40);
    	serviceDescription.setPromptText("Descriere");
    	Button clearFields = new Button();
		FontAwesomeIconView clearFieldsIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
		clearFieldsIcon.setFill(Color.web("#942c5c"));
		clearFieldsIcon.setSize("28");
		clearFields.setGraphic(clearFieldsIcon);
		clearFields.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				serviceName.clear();
				serviceAmount.clear();
				servicePrice.clear();
				serviceDescription.clear();
			}
		});
		
		
    	content.setHgap(5);
    	content.setVgap(5);
    	content.addRow(0, serviceName);
    	content.addRow(0, serviceAmount);
    	content.addRow(0, clearFields);
    	content.addRow(1, servicePrice);
    	content.addRow(1, serviceExchange);
    	content.addRow(2, serviceDescription);
    }
    
    @FXML
    void addServiceButtonClicked(ActionEvent event) {
    	GridPane addedPane = new GridPane();
    	initializeGridPane(addedPane);
    	pane.addRow(nr, addedPane);
    	nr++;
    }

    @FXML
    void exitPopupClicked(ActionEvent event) {
    	exitPopup.getScene().getWindow().hide();
    }

    @FXML
    void saveDataClicked(ActionEvent event) {

    }

	

}


