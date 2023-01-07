package application.billings.popup;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BillingsServiceContentController implements Initializable{

    @FXML
    private Button addAmountButton;

    @FXML
    private FontAwesomeIconView addAmountIcon;

    @FXML
    private Button billingDescriptionButton;

    @FXML
    private TextField billingDescriptionField;

    @FXML
    private FontAwesomeIconView billingDescriptionIcon;

    @FXML
    private Button billingPriceButton;

    @FXML
    private TextField billingPriceField;

    @FXML
    private FontAwesomeIconView billingPriceIcon;

    @FXML
    private TextField billingServiceAmountField;

    @FXML
    private FontAwesomeIconView billingServiceIcon;

    @FXML
    private Button billingServiceNameButton;

    @FXML
    private TextField billingServiceNameField;

    @FXML
    private Button removeAmountButton;

    @FXML
    private FontAwesomeIconView removeAmountIcon;

    @FXML
    private Button removeForm;
    
    @FXML
    private FontAwesomeIconView removeFormIcon;

    private int amount = 1;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		billingServiceAmountField.setText("1");
	}
    @FXML
    void addAmountButtonClicked(ActionEvent event) {
    	amount++;
    	billingServiceAmountField.setText(String.valueOf(amount));
    }

    @FXML
    void billingDescriptionButtonClicked(ActionEvent event) {
    	billingDescriptionField.clear();
    }

    @FXML
    void billingPriceButtonClicked(ActionEvent event) {
    	billingPriceField.clear();
    }

    @FXML
    void billingServiceNameButtonClicked(ActionEvent event) {
    	billingServiceNameField.clear();
    }

    @FXML
    void removeAmountButtonClicked(ActionEvent event) {
    	amount--;
    	if(amount <= 1)
    		amount = 1;
    	billingServiceAmountField.setText(String.valueOf(amount));
    }

    @FXML
    void removeFormClicked(ActionEvent event) {
    	billingServiceNameField.clear();
    	billingPriceField.clear();
    	billingDescriptionField.clear();
    	amount = 1;
    	billingServiceAmountField.setText(String.valueOf(amount));
    }

	

}
