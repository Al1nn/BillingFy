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
    private ComboBox<String> comboBox;

    @FXML
    private Button exitButton;

    @FXML
    private FontAwesomeIconView exitIcon;

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

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		String[] cmboxOptions = { "10 iteme", "20 iteme", "30 iteme" };
		comboBox.getItems().addAll(cmboxOptions);
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

}
