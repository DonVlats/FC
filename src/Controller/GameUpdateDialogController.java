package Controller;

import DB.DB;
import POJO.Game;
import POJO.MyAlert;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class GameUpdateDialogController {

    @FXML
    private TextField opponentTF;
    @FXML
    private TextField competitionTF;
    @FXML
    private TextField dataTF;
    @FXML
    private TextField scoreTF;
    @FXML
    private TextField scoreOpponentTF;
    @FXML
    private ChoiceBox homeTF;




    private Stage dialogStage;
    private Game game;


    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /* public void setPerson(Player player) {
        this.player = player;
        if(player.getBday() != 0)
        isUpdate = true;
        NameField.setText(Integer.toString(player.getIdN()));
        SurnameField.setText(player.getTitle());
        CountryField.setText(Integer.toString(player.getYearN()));
        DirectorField.setText(player.getDirectorN());

    }*/

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return false;
    }


    @FXML
    public void initialize(){
        homeTF.getItems().clear();

        homeTF .getItems().add("Так");
        homeTF .getItems().add("НІ");
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (opponentTF.getText() == null || opponentTF.getText().length() == 0) {
            errorMessage += "ID!\n";
        }
        if (competitionTF.getText() == null || competitionTF.getText().length() == 0) {
            errorMessage += "Title !\n";
        }
        if (dataTF.getText() == null || dataTF.getText().length() == 0) {
            errorMessage += "Year!\n";
        }

        else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(scoreTF.getText());
                Integer.parseInt(scoreOpponentTF.getText());



            } catch (NumberFormatException e) {
                errorMessage += "ID і year - ЧИСЛАААА!\n";
            }
        }



        if (errorMessage.length() == 0) {
            int home = 0;
            if( homeTF.getSelectionModel().getSelectedItem()=="Так")
                home = 1;
            game = new Game(this.game.getId(),
                    opponentTF.getText()
                    ,competitionTF.getText() ,
                    dataTF.getText() ,
                    Integer.parseInt(scoreTF.getText()) ,
                    Integer.parseInt(scoreOpponentTF.getText()),home

                    //
            );
            return true;
        } else {
            // Show the error message.

            MyAlert.ShowAlertError(errorMessage, dialogStage);
            return false;
        }
    }
    @FXML
    public void AddClicked() throws SQLException {
        // Initialize the person table with the two columns.
        if(this.isInputValid()){


            if(DB.updateDB(game) > 0){
                MyAlert.ShowAlertInfo("Дані успішно оновленно");
            }

            dialogStage.close();
        }}


    @FXML
    public void CencelClicked() {
        dialogStage.close();
    }
    public void setPerson(Game game) {
        this.game = game;
        opponentTF.setText(game.getOpponent());
        competitionTF.setText(game.getCompetition());
        dataTF.setText(game.getData());
        scoreTF.setText(String.valueOf(game.getScore()));
        scoreOpponentTF.setText(String.valueOf(game.getScoreOpponent()));
        if (game.getHome() == 1)
        homeTF.getSelectionModel().select(0);
        else
            homeTF.getSelectionModel().select(1);
    }
}
