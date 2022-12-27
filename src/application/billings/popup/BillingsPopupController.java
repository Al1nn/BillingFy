package application.billings.popup;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BillingsPopupController implements Initializable{

    @FXML
    private Button exitButton;

    @FXML
    private FontAwesomeIconView exitButtonIcon;

    @FXML
    private Button issuerCUIButton;

    @FXML
    private FontAwesomeIconView issuerCUIIcon;

    @FXML
    private TextField issuerCUITextField;

    @FXML
    private ComboBox<String> issuerNameCmbBox;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	String[] issuerNameOptions = {"ALL IN TECHNOLOGIES","Endava","UPIT"};
    	issuerNameCmbBox.getItems().addAll(issuerNameOptions);
	}
    @FXML
    void exitButtonClicked(ActionEvent event) {
    	exitButton.getScene().getWindow().hide();
    }

    @FXML
    void issuerCUIButtonClicked(ActionEvent event) {

    }

	

}
