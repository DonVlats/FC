package Controller;

import View.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoseActionController {
    @FXML
    private Button btn;
   // private Stage stage;
    public void PlayerShow() throws IOException {

        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.ShowPlayerInfo();
    }

    public void EditUsers() throws IOException {

        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.showUsers();
    }
    public void EmployeeShow() throws IOException {
        Stage stage =  (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.ShowPlayerInfo();
    }
    public void GameShow() throws IOException {
        Stage stage =  (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.ShowGameInfo();
    }
    public void AuthShow() throws IOException {
        Stage stage =  (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.showAuthAgain();
    }

    public void setDialogStage(Stage dialogStage) {

    }
}
