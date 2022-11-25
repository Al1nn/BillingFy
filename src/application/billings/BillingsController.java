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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;

public class BillingsController implements Initializable {
	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Pane billingLayout;

	@FXML
	private Text billingTitle;

	@FXML
	private Pane buttonLayout;

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

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		String[] cmboxOptions = { "10 iteme", "20 iteme", "30 iteme" };
		comboBox.getItems().addAll(cmboxOptions);
		

	}

}
