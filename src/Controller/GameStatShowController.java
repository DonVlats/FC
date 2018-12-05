package Controller;

import DB.DB;
import POJO.Game;
import POJO.GameStat;
import POJO.MyAlert;
import View.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class GameStatShowController {
    private Game game;
    private Stage stage;
    private final ObservableList<GameStat> gameData = FXCollections.observableArrayList();
    @FXML
    private TableView<GameStat> gameStatTable;
    @FXML
    private TableColumn<GameStat, String> nameColumn;
    @FXML
    private TableColumn<GameStat, String> surnameColumn;
    @FXML
    private TableColumn<GameStat, String> startColumn;
    @FXML
    private TableColumn<GameStat, String> substitutesColumn;
    @FXML
    private TableColumn<GameStat, Integer> goalColumn;
    @FXML
    private TableColumn<GameStat, Integer> assistColumn;


    @FXML
public void ShowStat(){
    if(game != null)
    initializeStat(game.getId());
    else
        initializeStat(0);
}
    @FXML
    public void initializeStat(int id) {
        System.out.print("setMainApp - 1 \n");
        gameStatTable.getItems().clear();
        init(id);
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getSTname());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().getSTsurname());
        startColumn.setCellValueFactory(cellData->cellData.getValue().getSTstart());
        substitutesColumn.setCellValueFactory(cellData -> cellData.getValue().getSTsubstitutes());
        goalColumn.setCellValueFactory(cellData -> cellData.getValue().getSTgoal().asObject());

        assistColumn.setCellValueFactory(cellData -> cellData.getValue().getSTassist().asObject());

        gameStatTable.setItems(gameData);




    }

    private void init(int id) {
        DB.readGameStatDB(gameData, id);
    }



    @FXML
    private void handleNewMovie() {
        GameStat selectedPerson = gameStatTable.getSelectionModel().getSelectedItem();
        boolean okClicked = MainApp.showGameStatInsertDialog(game);
    }

    public void setGame(Game game) {

     this.game  = game;
    }

    @FXML
    private void handleEditPerson() throws IOException {
        GameStat selectedPerson = gameStatTable.getSelectionModel().getSelectedItem();


        if (game != null){
        GameStat gameStat = new GameStat(selectedPerson.getId(),
               selectedPerson.getName(),
               selectedPerson.getSurname(),
                selectedPerson.getStart() ,
                selectedPerson.getSubstitutes(),
                selectedPerson.getGoal(),
               selectedPerson.getAssist(),
                String.valueOf(game.getId())
        );
        MainApp.showGameStatUpdateDialog(game,gameStat);
      }
      else MyAlert.ShowAlertError("Виберіть матч",null);

    }

    public void setDialogStage(Stage dialogStage) {
        this.stage = dialogStage;
    }
    @FXML
    private void ShowChoseAction() {
        stage.close();
      // MainApp.ShowChoseAction();

    }
    @FXML
    private void handleDeletePerson() throws SQLException {
        int selectedIndex = gameStatTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {


            if( DB.deleteGameStatDB(      (gameStatTable.getSelectionModel().getSelectedItem().getId()))
                   > 0  ){
                MyAlert.ShowAlertInfo("Видалено");
            }
            gameStatTable.getItems().remove(selectedIndex);
        } else {
            MyAlert.ShowAlertError("Виберить запис для видалення", stage);

        }


    }
}
