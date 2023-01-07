package application.billings.popup;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BillingsDiscountContentController implements Initializable{

    @FXML
    private Button addPercentageButton;

    @FXML
    private FontAwesomeIconView addPercentageIcon;

    @FXML
    private Button billingDiscountNameButton;

    @FXML
    private TextField billingDiscountNameField;

    @FXML
    private FontAwesomeIconView billingDiscountNameIcon;

    @FXML
    private TextField billingDiscountPercentageField;

    @FXML
    private Button removeForm;

    @FXML
    private FontAwesomeIconView removeFormIcon;

    @FXML
    private Button removePercentageButton;

    @FXML
    private FontAwesomeIconView removePercentageIcon;
    
    private int amount = 1;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		billingDiscountPercentageField.setText(String.valueOf(amount));	
	}
    
    @FXML
    void addPercentageButtonClicked(ActionEvent event) {
    	amount++;
    	billingDiscountPercentageField.setText(String.valueOf(amount));
    }

    @FXML
    void billingDiscountNameButtonClicked(ActionEvent event) {
    	billingDiscountNameField.clear();
    }

    @FXML
    void removeFormClicked(ActionEvent event) {
    	billingDiscountNameField.clear();
    	amount = 1;
    	billingDiscountPercentageField.setText(String.valueOf(amount));
    }

    @FXML
    void removePercentageButtonClicked(ActionEvent event) {
    	amount--;
    	if(amount <= 1)
    		amount = 1;
    	billingDiscountPercentageField.setText(String.valueOf(amount));
    }

	

}
