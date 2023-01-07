package application.billings.popup;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BillingsTaxContentController implements Initializable{

    @FXML
    private Button addValueButton;

    @FXML
    private FontAwesomeIconView addValueIcon;

    @FXML
    private Button billingTaxNameButton;

    @FXML
    private TextField billingTaxNameField;

    @FXML
    private FontAwesomeIconView billingTaxNameIcon;

    @FXML
    private TextField billingTaxValueField;

    @FXML
    private Button removeForm;

    @FXML
    private FontAwesomeIconView removeFormIcon;

    @FXML
    private Button removeValueButton;

    @FXML
    private FontAwesomeIconView removeValueIcon;

    private int amount = 1;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	billingTaxValueField.setText(String.valueOf(amount));
	}
    
    @FXML
    void addValueButtonClicked(ActionEvent event) {
    	amount++;
    	billingTaxValueField.setText(String.valueOf(amount));
    }

    @FXML
    void billingTaxNameButtonClicked(ActionEvent event) {
    	billingTaxNameField.clear();
    }

    @FXML
    void removeFormClicked(ActionEvent event) {
    	billingTaxNameField.clear();
    	amount = 1;
    	billingTaxValueField.setText(String.valueOf(amount));
    }

    @FXML
    void removeValueButtonClicked(ActionEvent event) {
    	amount--;
    	if(amount <= 1)
    		amount = 1;
    	billingTaxValueField.setText(String.valueOf(amount));
    }

	

}
