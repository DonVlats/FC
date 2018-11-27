package Controller;

import DB.DB;
import POJO.Game;
import POJO.GameStat;
import POJO.MyAlert;
import POJO.Player;
import View.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class GameStatShowController {
    private Game game;
    private Stage stage;
    private ObservableList<GameStat> gameData = FXCollections.observableArrayList();
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


    Connection conn ;

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
        FilterDialogController.selectMessage = "";



    }

    public void setMainApp(ObservableList<GameStat> mainApp) {

        System.out.print("setMainApp - 1 \n");
        gameStatTable.setItems(mainApp);
    }
    public ObservableList<GameStat> getPersonData() {
        return gameData;
    }

    public void init(int id) {
        gameData = DB.readGameStatDB( gameData, id);
    }



    @FXML
    private void handleNewMovie() {
        GameStat selectedPerson = gameStatTable.getSelectionModel().getSelectedItem();
        boolean okClicked = MainApp.showGameStatInsertDialog(game);
        if (okClicked) {
            ;
        }
    }
    @FXML
    private void Filter() {

        MainApp.showFilterDialog();

    }
    public void setGame(Game game) {

     this.game  = game;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private void handleEditPerson() throws IOException {
        GameStat selectedPerson = gameStatTable.getSelectionModel().getSelectedItem();



        GameStat gameStat = new GameStat(selectedPerson.getId(),
               selectedPerson.getName(),
               selectedPerson.getSurname(),
                selectedPerson.getStart() ,
                selectedPerson.getSubstitutes(),
                selectedPerson.getGoal(),
               selectedPerson.getAssist(),
                String.valueOf(game.getId())
        );
        if (selectedPerson != null) {
          boolean okClicked = MainApp.showGameStatUpdateDialog(game,gameStat);
            if (okClicked) {
               // showPersonDetails(selectedPerson);
            }

        } else {
            MyAlert.ShowAlertError("Виберить запис для редагування", stage);
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.stage = dialogStage;
    }
    @FXML
    private void ShowChoseAction() throws IOException {
        stage.close();
      // MainApp.ShowChoseAction();

    }
    @FXML
    private void handleDeletePerson() throws SQLException {
        int selectedIndex = gameStatTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {


            if( DB.deleteGameStatDB(      (gameStatTable.getSelectionModel().getSelectedItem().getId()))
                    ){
                MyAlert.ShowAlertInfo("Видалено", stage);
            }
            gameStatTable.getItems().remove(selectedIndex);
        } else {
            MyAlert.ShowAlertError("Виберить запис для видалення", stage);

        }


    }
}
