package Controller;

        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */


        import DB.ConnectionDB;
        import DB.DB;
        import View.MainApp;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.sql.SQLException;

/**
 * View Controller class
 *
 * @author 123
 */
public class AuthController {
    private final ObservableList<String> grand  = FXCollections.observableArrayList("Бухгалтер","Футболіст", "Працівник", "Керівник","Адмін");
    @FXML
    private TextField UserNameFiel;
    @FXML
    private TextField PasswordFiel;



   /* public void setPerson(Player player) {
        this.player = player;
        if(player.getBday() != 0)
        isUpdate = true;
        IDField.setText(Integer.toString(player.getIdN()));
        TitleField.setText(player.getTitle());
        YearField.setText(Integer.toString(player.getYearN()));
        DirectorField.setText(player.getDirectorN());

    }*/


    @FXML
    public void OkClicked() throws SQLException, IOException {
        // Initialize the person table with the two columns.
        // if(this.isInputValid())
        new ConnectionDB().SetUser(UserNameFiel.getText(), PasswordFiel.getText() );
        if(new ConnectionDB().TestConnectDatabase())
        {
            String role = DB.readDB(UserNameFiel.getText());
            if(grand.get(0).equals(role)){
                Stage stage = (Stage) PasswordFiel.getScene().getWindow();
                stage.close();

                MainApp.ShowChoseActionForAccountant();
            }
         else {    Stage stage = (Stage) PasswordFiel.getScene().getWindow();
                stage.close();

                MainApp.ShowChoseAction();}
            }
            }


    @FXML
    public void CencelClicked() {
        Stage stage = (Stage) PasswordFiel.getScene().getWindow();
        stage.close();
    }

}