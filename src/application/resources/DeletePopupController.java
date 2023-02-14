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
        Stage childStage = (Stage) deleteData.getScene().getWindow();
        childStage.hide();
    }

    @FXML
    void exitDeletePopupClicked(ActionEvent event) {
        exitDeletePopup.getScene().getWindow().setOnHidden(evt -> {
            System.out.println("Exited");
        });
        exitDeletePopup.getScene().getWindow().hide();
    }

    public Text getDeletePopupTitle() {
        return deletePopupTitle;
    }


}
