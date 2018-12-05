package Controller;

import View.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoseActionForPlayerController {
    @FXML
    private Button btn;
    // private Stage stage;
    public void PlayerShow() throws IOException {

        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.ShowPlayerInfo();
    }


    public void GameShow() throws IOException {
        Stage stage =  (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.ShowGameInfo();
    }
    public void AuthShow() {
        Stage stage =  (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.showAuthAgain();
    }

}
