package Controller;

import DB.DB;
import DB.ConnectionDB;
import View.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoseActionController {
    @FXML
    public Button userBTN;
    @FXML
    private Button btn;
   // private Stage stage;
    public void PlayerShow() throws IOException {

        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.ShowPlayerInfo();
    }

    public void EditUsers() {

        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.showUsers();
    }
    public void EmployeeShow() throws IOException {
        Stage stage =  (Stage) btn.getScene().getWindow();
        stage.close();
        MainApp.ShowEmployeeInfo();
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

    public void init() {
        String role = DB.readDB(new ConnectionDB().getUsername());
        if(!"Адмін".equals(role)){
            userBTN.setVisible(false);

        }
    }
}
