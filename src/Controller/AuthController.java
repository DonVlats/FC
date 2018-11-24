package Controller;

        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */


        import DB.ConnectionDB;
        import POJO.MyAlert;
        import POJO.Player;
        import View.MainApp;
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

    @FXML
    private TextField UserNameFiel;
    @FXML
    private TextField PasswordFiel;




    private Stage dialogStage;
    private Player player;
    private boolean okClicked = false;
    private boolean isUpdate = false;


    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param player
     */
   /* public void setPerson(Player player) {
        this.player = player;
        if(player.getBday() != 0)
        isUpdate = true;
        IDField.setText(Integer.toString(player.getIdN()));
        TitleField.setText(player.getTitle());
        YearField.setText(Integer.toString(player.getYearN()));
        DirectorField.setText(player.getDirectorN());

    }*/

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }




    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (UserNameFiel.getText() == null || UserNameFiel.getText().length() == 0) {
            errorMessage += "ID!\n";
        }
        if (PasswordFiel.getText() == null || PasswordFiel.getText().length() == 0) {
            errorMessage += "Title !\n";
        }





        if (errorMessage.length() == 0) {

            return true;
        } else {
            // Show the error message.

            MyAlert.ShowAlertError(errorMessage, dialogStage);
            return false;
        }

    }
    @FXML
    public void OkClicked() throws SQLException, IOException {
        // Initialize the person table with the two columns.
        // if(this.isInputValid())
        new ConnectionDB().SetUser(UserNameFiel.getText(), PasswordFiel.getText() );
        if(new ConnectionDB().TestConnectDatabase())
        { Stage stage = (Stage) PasswordFiel.getScene().getWindow();
            stage.close();

            MainApp.ShowChoseAction();}

        ;
    }
    @FXML
    public void CencelClicked() {
        Stage stage = (Stage) PasswordFiel.getScene().getWindow();
        stage.close();
    }

    public void setPerson(Player person) {
    }
}