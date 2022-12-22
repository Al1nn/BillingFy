package application.services.popup;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ServicesContentController implements Initializable{

    @FXML
    private Button addAmountButton;

    @FXML
    private FontAwesomeIconView addAmountIcon;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private Button removeAmountButton;

    @FXML
    private FontAwesomeIconView removeAmountIcon;
    
    @FXML
    private FontAwesomeIconView removeFormIcon;
    
    @FXML
    private Button removeForm;

    @FXML
    private TextField serviceAmountField;

    @FXML
    private Button serviceDescriptionButton;

    @FXML
    private TextField serviceDescriptionField;

    @FXML
    private FontAwesomeIconView serviceDescriptionIcon;
    
    @FXML
    private ComboBox<String> serviceExchangeField;

    @FXML
    private Button serviceNameButton;

    @FXML
    private TextField serviceNameField;

    @FXML
    private FontAwesomeIconView serviceNameIcon;
    
    @FXML
    private Button servicePriceButton;

    @FXML
    private TextField servicePriceField;

    @FXML
    private FontAwesomeIconView servicePriceIcon;
    
    private int amount = 1;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	serviceAmountField.setText("1");
    	String[] serviceExchangeOptions = {"RON","EUR"};
    	serviceExchangeField.getItems().addAll(serviceExchangeOptions);
	}
    
    @FXML
    void addAmountButtonClicked(ActionEvent event) {
    	amount++;
    	serviceAmountField.setText(String.valueOf(amount));
    }

    @FXML
    void removeAmountButtonClicked(ActionEvent event) {
    	amount--;
    	if(amount <= 1)
    		amount = 1;
    	serviceAmountField.setText(String.valueOf(amount));
    }

    @FXML
    void removeFormClicked(ActionEvent event) {
    	serviceNameField.clear();
    	servicePriceField.clear();
    	serviceDescriptionField.clear();
    	amount = 1;
    	serviceAmountField.setText(String.valueOf(amount));
    	serviceExchangeField.getSelectionModel().clearSelection();
    }

    @FXML
    void serviceDescriptionButtonClicked(ActionEvent event) {
    	serviceDescriptionField.clear();
    }

    @FXML
    void serviceNameButtonClicked(ActionEvent event) {
    	serviceNameField.clear();
    }

    @FXML
    void servicePriceButtonClicked(ActionEvent event) {
    	servicePriceField.clear();
    }
    
}

