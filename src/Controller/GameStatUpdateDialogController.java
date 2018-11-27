package Controller;

import DB.DB;
import POJO.Game;
import POJO.GameStat;
import POJO.MyAlert;
import POJO.Player;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.ArrayList;

public class GameStatUpdateDialogController {
    GameStat gameStat;
    private ArrayList<Player> personData = new ArrayList<>();
    @FXML
    private ChoiceBox playerCB;
    @FXML
    private TextField gameTF;
    @FXML
    private ChoiceBox startCB;
    @FXML
    private ChoiceBox subCB;
    @FXML
    private TextField goalTF;
    @FXML
    private TextField assistTF;



    private  GameStat gameOldStat;
    private Stage dialogStage;
    private Game game;
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
    public void setPerson(GameStat player) {
        this.gameOldStat = player;
        if(player.getId() != 0) ;


            playerCB.getSelectionModel().select(2);;
        gameTF.setText(player.getOpponent());
        startCB.getSelectionModel().select(player.getStart());
        subCB.getSelectionModel().select(player.getSubstitutes());
        goalTF.setText(String.valueOf(player.getGoal()));
        assistTF.setText(String.valueOf(player.getAssist()));

    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    public void initialize(Game game){
        DecimalFormat format = new DecimalFormat( "#.0" );
        goalTF.setTextFormatter( new TextFormatter<>(c ->
        {
            if ( c.getControlNewText().isEmpty() )
            {
                return c;
            }

            ParsePosition parsePosition = new ParsePosition( 0 );
            Object object = format.parse( c.getControlNewText(), parsePosition );

            if ( object == null || parsePosition.getIndex() < c.getControlNewText().length() )
            {
                return null;
            }
            else
            {
                return c;
            }
        }));
        assistTF.setTextFormatter( new TextFormatter<>(c ->
        {
            if ( c.getControlNewText().isEmpty() )
            {
                return c;
            }

            ParsePosition parsePosition = new ParsePosition( 0 );
            Object object = format.parse( c.getControlNewText(), parsePosition );

            if ( object == null || parsePosition.getIndex() < c.getControlNewText().length() )
            {
                return null;
            }
            else
            {
                return c;
            }
        }));
        startCB.getItems().clear();
        personData = DB.readDB(    personData,FilterDialogController.selectMessage);
        for (Player element : personData) {
            playerCB .getItems().addAll(element.getName() + " " + element.getSurname());
        }

        playerCB.getSelectionModel().select(1);
        startCB .getItems().add("Так");
        startCB .getItems().add("НІ");
        startCB.getSelectionModel().select(0);
        subCB.getItems().clear();

        subCB .getItems().add("Так");
        subCB .getItems().add("НІ");
        subCB.getSelectionModel().select(0);
        this.game = game;
        if(game != null)
            gameTF.setText(game.getOpponent());
        else
            MyAlert.ShowAlertError("Виберіть матч",null);
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (playerCB.getSelectionModel().getSelectedItem() == null || playerCB.getSelectionModel().getSelectedItem().toString().length() == 0) {
            errorMessage += "ID!\n";
        }
        if (gameTF.getText() == null || gameTF.getText().length() == 0) {
            errorMessage += "Title !\n";
        }
        if (errorMessage.length() == 0) {
            int start = 0;
            int sub = 0;
            if( startCB.getSelectionModel().getSelectedItem()=="Так")
                start = 1;
            if( subCB.getSelectionModel().getSelectedItem()=="Так" && start !=1)
                sub = 1;


            String[] splited = playerCB.getSelectionModel().getSelectedItem().toString().split(" ");
            int playerId = 0;
            for (Player element : personData) {
                if( splited[0] .equals( element.getName()) &&
                        splited[1].equals(element.getSurname())){
                    playerId = element.getId()      ;             }

            }
            gameStat = new GameStat(gameOldStat.getId(),
                    String.valueOf(playerId),
                    splited[1],
                    start ,
                    sub,
                    Integer.parseInt(goalTF.getText()),
                    Integer.parseInt(assistTF.getText()),
                    String.valueOf(gameOldStat.getOpponent())
            );
            System.out.println(gameOldStat.getId()+
                    String.valueOf(playerId)+
                    splited[1]+

                    Integer.parseInt(goalTF.getText())+
                    Integer.parseInt(assistTF.getText())+
                    String.valueOf(gameOldStat.getId()));
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

            int count = DB.updateDB(gameStat);
            if(count > 0 ){
                MyAlert.ShowAlertInfo("Кількість рядків які було встановлено " + count , dialogStage);
            }

            dialogStage.close();
        }}


    @FXML
    public void CencelClicked() {
        dialogStage.close();
    }
}