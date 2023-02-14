package application.resources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeletePopupController {

    @FXML
    private Button deleteData;

    @FXML
    private Text deletePopupTitle;

    @FXML
    private Button exitDeletePopup;

    @FXML
    void deleteDataClicked(ActionEvent event) {
        deleteData.getScene().getWindow().hide();
    }

    @FXML
    void exitDeletePopupClicked(ActionEvent event) {
        Stage childStage = (Stage) exitDeletePopup.getScene().getWindow();
        childStage.close();
    }

    public Text getDeletePopupTitle() {
        return deletePopupTitle;
    }
}
