package application.services.popup;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.services.Service;
import application.services.backend.ServicesDatabase;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ServicesPopupController implements Initializable{

    @FXML
    private Button addServiceButton;

    @FXML
    private FontAwesomeIconView addServiceIcon;
    
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

    @FXML
    private Text servicePopupTitle;
    private int nrPressed = 1;
    private TextField serviceNameField;
    private TextField serviceAmountField;
    private TextField servicePriceField;
    private ComboBox<String> serviceCurrencyField;
    private TextField serviceDescriptionField;
    private TextField serviceNumberField;

    private boolean isEditable;
    ObservableList<Service> serviceData;
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
    		contentPane = new GridPane();
            Parent root = FXMLLoader.load(getClass().getResource("/application/services/popup/ServicesContent.fxml"));
			String contentCSS = this.getClass().getResource("/application/services/popup/ServicesContentStyle.css").toExternalForm();
			root.getStylesheets().add(contentCSS);
            serviceNameField = (TextField) root.lookup("#serviceNameField");
            serviceAmountField = (TextField) root.lookup("#serviceAmountField");
            servicePriceField = (TextField) root.lookup("#servicePriceField");
            serviceCurrencyField = (ComboBox<String>) root.lookup("#serviceCurrencyField");
            serviceDescriptionField = (TextField) root.lookup("#serviceDescriptionField");
            serviceNumberField = (TextField) root.lookup("#serviceNumberField");
			contentPane.addRow(0, root);
			scrollPane.setContent(contentPane);
			scrollPane.setFitToWidth(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void initializeData(String serviceName, String serviceAmount, String servicePrice, String serviceCurrency, String serviceDescription, String serviceNumber){
        serviceNameField.setText(serviceName);
        serviceAmountField.setText(serviceAmount);
        servicePriceField.setText(servicePrice);
        serviceCurrencyField.setValue(serviceCurrency);
        serviceDescriptionField.setText(serviceDescription);
        serviceNumberField.setText(serviceNumber);
    }
    @FXML
    void addServiceButtonClicked(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/services/popup/ServicesContent.fxml"));
    	String contentCSS = this.getClass().getResource("/application/services/popup/ServicesContentStyle.css").toExternalForm();
    	root.getStylesheets().add(contentCSS);
    	contentPane.addRow(nrPressed, root);
    	nrPressed++;
    }

    @FXML
    void exitPopupClicked(ActionEvent event) {
    	exitPopup.getScene().getWindow().hide();
    }

    @FXML
    void saveDataClicked(ActionEvent event) throws ClassNotFoundException {
        ServicesDatabase connection = new ServicesDatabase();
        if(!isEditable) {
            for (Node node : contentPane.getChildren()) {
                serviceNameField = (TextField) node.lookup("#serviceNameField");
                serviceAmountField = (TextField) node.lookup("#serviceAmountField");
                servicePriceField = (TextField) node.lookup("#servicePriceField");
                serviceCurrencyField = (ComboBox<String>) node.lookup("#serviceCurrencyField");
                serviceDescriptionField = (TextField) node.lookup("#serviceDescriptionField");
                serviceNumberField = (TextField) node.lookup("#serviceNumberField");
                String serviceName = serviceNameField.getText();
                String serviceAmount = serviceAmountField.getText();
                String servicePrice = servicePriceField.getText();
                String serviceCurrency = serviceCurrencyField.getValue();
                String serviceDescription = serviceDescriptionField.getText();
                String serviceNumber = serviceNumberField.getText();
                connection.insertData(serviceName,serviceAmount,servicePrice,serviceCurrency,serviceDescription,serviceNumber);
            }
            saveData.getScene().getWindow().hide();
            return;
        }
    }

    public void setEditable(boolean args) {
        servicePopupTitle.setText("Editare Serviciu");
        isEditable = args;
    }
    public void setInvisibleAdd(){
        addServiceButton.setVisible(false);
    }
}


