package application.billings;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class BillingsController {
	@FXML
	private Button exitButton;
	@FXML 
	private Pane buttonLayout;
	@FXML
	private Pane billingLayout;
	
	@FXML
	public void exitButtonClicked(ActionEvent event) {
		Platform.exit();
	}

}
