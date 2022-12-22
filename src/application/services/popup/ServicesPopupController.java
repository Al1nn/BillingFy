package application.services.popup;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    
    private int nrPressed = 1;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
    		contentPane = new GridPane();
			Parent root = FXMLLoader.load(getClass().getResource("/application/services/popup/ServicesContent.fxml"));
			String contentCSS = this.getClass().getResource("/application/services/popup/ServicesContentStyle.css").toExternalForm();
			root.getStylesheets().add(contentCSS);
			contentPane.addRow(0, root);
			scrollPane.setContent(contentPane);
			scrollPane.setFitToWidth(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    void saveDataClicked(ActionEvent event) {

    }

	

}


