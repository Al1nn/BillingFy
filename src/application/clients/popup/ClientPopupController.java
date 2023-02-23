package application.clients.popup;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.clients.Client;
import application.clients.ClientsController;
import application.clients.backend.ClientDatabase;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ClientPopupController{
    @FXML
    private Button CUIButton;

    @FXML
    private FontAwesomeIconView CUIIcon;

    @FXML
    private Text CUILabel;

    @FXML
    private TextField CUITextField;

    @FXML
    private Button cityButton;

    @FXML
    private FontAwesomeIconView cityIcon;

    @FXML
    private Text cityLabel;

    @FXML
    private TextField cityTextField;
    
    @FXML
    private Text clientPopupTitle;
    
    @FXML
    private Button clientButton;

    @FXML
    private FontAwesomeIconView clientIcon;

    @FXML
    private Text clientLabel;

    @FXML
    private TextField clientNameTextField;

    @FXML
    private Button countryButton;

    @FXML
    private FontAwesomeIconView countryIcon;

    @FXML
    private Text countryLabel;

    @FXML
    private TextField countryTextField;

    @FXML
    private Button countyButton;

    @FXML
    private FontAwesomeIconView countyIcon;

    @FXML
    private Text countyLabel;

    @FXML
    private TextField countyTextField;

    @FXML
    private Button emailButton;

    @FXML
    private FontAwesomeIconView emailIcon;

    @FXML
    private Text emailLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button euidButton;

    @FXML
    private FontAwesomeIconView euidIcon;

    @FXML
    private Text euidLabel;

    @FXML
    private TextField euidTextField;

    @FXML
    private Button exitPopup;

    @FXML
    private Button numberButton;

    @FXML
    private FontAwesomeIconView numberIcon;

    @FXML
    private Text numberLabel;

    @FXML
    private TextField numberTextField;

    @FXML
    private FontAwesomeIconView passwordIcon;

    @FXML
    private Button phoneNumberButton;

    @FXML
    private FontAwesomeIconView phoneNumberIcon;

    @FXML
    private Text phoneNumberLabel;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button saveData;

    @FXML
    private Button streetButton;

    @FXML
    private FontAwesomeIconView streetIcon;

    @FXML
    private Text streetLabel;

    @FXML
    private TextField streetTextField;

    @FXML
    private Button tradeRegisterButton;

    @FXML
    private FontAwesomeIconView tradeRegisterIcon;

    @FXML
    private Text tradeRegisterLabel;

    @FXML
    private TextField tradeRegisterTextField;

    @FXML
    private Button zipCodeButton;

    @FXML
    private FontAwesomeIconView zipCodeIcon;

    @FXML
    private Text zipCodeLabel;

    @FXML
    private TextField zipCodeTextField;
    
    private boolean isEditable;
    
    private String oldClientNumber;
    private String oldClientName;

    public void initializeData(String clientName, String clientCUI
    		, String clientTradeRegisterNumber, String clientEUID
    		, String clientCountry, String clientCity
    		, String clientCounty, String clientStreet
    		, String clientNumber, String clientZipcode
    		, String clientEmail, String clientPhoneNumber) {
    	clientNameTextField.setText(clientName);
    	CUITextField.setText(clientCUI);
    	tradeRegisterTextField.setText(clientTradeRegisterNumber);
    	euidTextField.setText(clientEUID);
    	countryTextField.setText(clientCountry);
    	cityTextField.setText(clientCity);
    	countyTextField.setText(clientCounty);
    	streetTextField.setText(clientStreet);
    	numberTextField.setText(clientNumber);
    	zipCodeTextField.setText(clientZipcode);
    	emailTextField.setText(clientEmail);
    	phoneNumberTextField.setText(clientPhoneNumber);
    	oldClientNumber = clientNumber;
        oldClientName = clientName;
    }
    
 
    @FXML
    void saveDataClicked(ActionEvent event) throws ClassNotFoundException, IOException {
    	String clientName = clientNameTextField.getText();
    	String clientCUI = CUITextField.getText();
    	String clientTradeRegisterNumber = tradeRegisterTextField.getText();
    	String clientEUID = euidTextField.getText();
    	String clientCountry = countryTextField.getText();
    	String clientCity = cityTextField.getText();
    	String clientCounty = countyTextField.getText();
    	String clientStreet = streetTextField.getText();
    	String clientNumber = numberTextField.getText();
    	String clientZipCode = zipCodeTextField.getText();
    	String clientEmail = emailTextField.getText();
    	String clientPhoneNumber = phoneNumberTextField.getText();

    	if(!isEditable) {
            ClientDatabase connection = new ClientDatabase();
    		connection.insertData(clientName, clientCUI
    			, clientTradeRegisterNumber, clientEUID
    			, clientCountry, clientCity
    			, clientCounty, clientStreet
    			, clientNumber, clientZipCode
    			, clientEmail, clientPhoneNumber);
    		saveData.getScene().getWindow().hide();
    		return;
    	}
    	ClientDatabase connection = new ClientDatabase();
    	connection.updateData(clientName, clientCUI
    		, clientTradeRegisterNumber, clientEUID
    		, clientCountry, clientCity
    		, clientCounty, clientStreet
    		, clientNumber, clientZipCode
    		, clientEmail, clientPhoneNumber
    		, oldClientName, oldClientNumber
    		);
    	saveData.getScene().getWindow().hide();
    }



    @FXML
    void CUIButtonClicked(ActionEvent event) {
    	CUITextField.clear();
    }

    @FXML
    void cityButtonClicked(ActionEvent event) {
    	cityTextField.clear();
    }

    @FXML
    void clientButtonClicked(ActionEvent event) {
    	clientNameTextField.clear();
    }

    @FXML
    void countryButtonClicked(ActionEvent event) {
    	countryTextField.clear();
    }

    @FXML
    void countyButtonClicked(ActionEvent event) {
    	countyTextField.clear();
    }

    @FXML
    void emailButtonClicked(ActionEvent event) {
    	emailTextField.clear();
    }	

    @FXML
    void euidButtonClicked(ActionEvent event) {
    	euidTextField.clear();
    }

    @FXML
    void exitPopupClicked(ActionEvent event) {
        Stage childStage = (Stage) exitPopup.getScene().getWindow();
        childStage.close();
    }

    @FXML
    void numberButtonClicked(ActionEvent event) {
    	numberTextField.clear();
    }

    @FXML
    void phoneNumberButtonClicked(ActionEvent event) {
    	phoneNumberTextField.clear();
    }
    
    @FXML
    void streetButtonClicked(ActionEvent event) {
    	streetTextField.clear();
    }

    @FXML
    void tradeRegisterButtonClicked(ActionEvent event) {
    	tradeRegisterTextField.clear();
    }

    @FXML
    void zipCodeButtonClicked(ActionEvent event) {
    	zipCodeTextField.clear();
    }
    
    public void setEditable(boolean args) {
    	isEditable = args;
        clientPopupTitle.setText("Editare Client");
    }
	
}