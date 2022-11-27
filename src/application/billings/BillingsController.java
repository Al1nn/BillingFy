package application.billings;

import java.net.URL;
import java.util.ResourceBundle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;

public class BillingsController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableColumn<Void, Void> billingClient;

    @FXML
    private Text billingCurrentPage;

    @FXML
    private TableColumn<Void, Void> billingDueDate;

    @FXML
    private TableColumn<Void, Void> billingFunctions;

    @FXML
    private TableColumn<Void, Void> billingIssueDate;

    @FXML
    private AnchorPane billingLayout;

    @FXML
    private Text billingLengthText;

    @FXML
    private Button billingNextPage;

    @FXML
    private FontAwesomeIconView billingNextPageIcon;

    @FXML
    private TableColumn<Void, Void> billingNumber;

    @FXML
    private Text billingPages;

    @FXML
    private Button billingPreviousPage;

    @FXML
    private FontAwesomeIconView billingPreviousPageIcon;

    @FXML
    private TableColumn<Void, Void> billingStatus;

    @FXML
    private TableColumn<Void, Void> billingSum;

    @FXML
    private TableView<Billing> billingTable;

    @FXML
    private TableColumn<Void, Void> billingTax;

    @FXML
    private Text billingTitle;

    @FXML
    private TableColumn<Void, Void> billingTotal;

    @FXML
    private AnchorPane buttonLayout;

    @FXML
    private ComboBox<String> itemsPerPage;

    @FXML
    private Button exitButton;

    @FXML
    private FontAwesomeIconView exitIcon;

    @FXML
    private Button sortClientButton;

    @FXML
    private FontAwesomeIconView sortClientIcon;

    @FXML
    private Button sortDueDateButton;

    @FXML
    private FontAwesomeIconView sortDueDateIcon;

    @FXML
    private Button sortIssueDateButton;

    @FXML
    private FontAwesomeIconView sortIssueDateIcon;

    @FXML
    private Button sortNumberButton;

    @FXML
    private FontAwesomeIconView sortNumberIcon;

    @FXML
    private Button sortStatusButton;

    @FXML
    private FontAwesomeIconView sortStatusIcon;

    @FXML
    private Button sortSumButton;

    @FXML
    private FontAwesomeIconView sortSumIcon;

    @FXML
    private Button sortTaxButton;

    @FXML
    private FontAwesomeIconView sortTaxIcon;

    @FXML
    private TextField searchClient;

    @FXML
    private TextField searchDueDate;

    @FXML
    private TextField searchIssueDate;

    @FXML
    private TextField searchNumber;

    @FXML
    private ComboBox<String> searchStatus;
    

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		String[] itemPerPageOptions = { "10 iteme", "20 iteme", "30 iteme" };
		itemsPerPage.getItems().addAll(itemPerPageOptions);
		String[] statusOptions = {"Platit","Neplatit"};
		searchStatus.getItems().addAll(statusOptions);
		
		billingNumber.setCellValueFactory(new PropertyValueFactory<>("billingNumber"));
		billingClient.setCellValueFactory(new PropertyValueFactory<>("billingClient"));
		billingIssueDate.setCellValueFactory(new PropertyValueFactory<>("billingIssueDate"));
		billingDueDate.setCellValueFactory(new PropertyValueFactory<>("billingDueDate"));
		billingSum.setCellValueFactory(new PropertyValueFactory<>("billingSum"));
		billingTax.setCellValueFactory(new PropertyValueFactory<>("billingTax"));
		billingTotal.setCellValueFactory(new PropertyValueFactory<>("billingTotal"));
		billingStatus.setCellValueFactory(new PropertyValueFactory<>("billingStatus"));
		billingFunctions.setCellValueFactory(new PropertyValueFactory<>("billingFunctions"));
		
		Billing billing = new Billing("1", "SC COMPANY NAME S.R.L", "12.12.2020", "12.12.2020", "100 000 000 $", "100 000 000 $", "100 000 000 $","Neplatit","Butoane");
		
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingTable.getItems().add(billing);
		billingLengthText.setText(String.valueOf(billingTable.getItems().size()));
	}
	
	@FXML
	public void exitButtonClicked(ActionEvent event) {
		Platform.exit();
	}
	
    @FXML
    void billingNextPageClicked(ActionEvent event) {

    }

    @FXML
    void billingPreviousPageClicked(ActionEvent event) {

    }
    
    @FXML
    void sortClientButtonClicked(ActionEvent event) {
    	if(sortClientIcon.getGlyphName() == "ANGLE_UP")
    		sortClientIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortClientIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortDueDateButtonClicked(ActionEvent event) {
    	if(sortDueDateIcon.getGlyphName() == "ANGLE_UP")
    		sortDueDateIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortDueDateIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortIssueDateButtonClicked(ActionEvent event) {
    	if(sortIssueDateIcon.getGlyphName() == "ANGLE_UP")
    		sortIssueDateIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortIssueDateIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortNumberButtonClicked(ActionEvent event) {
    	if(sortNumberIcon.getGlyphName() == "ANGLE_UP")
    		sortNumberIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortNumberIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortStatusButtonClicked(ActionEvent event) {
    	if(sortStatusIcon.getGlyphName() == "ANGLE_UP")
    		sortStatusIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortStatusIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortSumButtonClicked(ActionEvent event) {
    	if(sortSumIcon.getGlyphName() == "ANGLE_UP")
    		sortSumIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortSumIcon.setGlyphName("ANGLE_UP");
    
    }

    @FXML
    void sortTaxButtonClicked(ActionEvent event) {
    	if(sortTaxIcon.getGlyphName() == "ANGLE_UP")
    		sortTaxIcon.setGlyphName("ANGLE_DOWN");
    	else
    	sortTaxIcon.setGlyphName("ANGLE_UP");
    
    }
}
