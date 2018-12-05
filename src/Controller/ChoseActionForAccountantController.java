package Controller;

import View.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class ChoseActionForAccountantController {
    @FXML
    private Button btn;
    public void PlayerShow()throws IOException {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.ShowEmployeeInfoForAccountant();
    }
    public void AuthShow() {
        Stage stage =  (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.showAuthAgain();
    }
}
