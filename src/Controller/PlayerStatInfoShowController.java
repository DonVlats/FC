package Controller;

import DB.DB;
import POJO.Game;
import POJO.GameStat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;



public class PlayerStatInfoShowController {
    int idPlayer;
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
    private TableColumn<GameStat, String> opponentColumn;


    @FXML
    public void ShowStat(){

            initializeStat(idPlayer);

    }
    @FXML
    public void initializeStat(int id) {
        idPlayer = id;
        System.out.print("setMainApp - 1 \n");
        gameStatTable.getItems().clear();
        init(id);
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getSTname());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().getSTsurname());
        startColumn.setCellValueFactory(cellData->cellData.getValue().getSTstart());
        substitutesColumn.setCellValueFactory(cellData -> cellData.getValue().getSTsubstitutes());
        goalColumn.setCellValueFactory(cellData -> cellData.getValue().getSTgoal().asObject());
        opponentColumn.setCellValueFactory(cellData -> cellData.getValue().getSTOpponent());

        assistColumn.setCellValueFactory(cellData -> cellData.getValue().getSTassist().asObject());

        gameStatTable.setItems(gameData);




    }

    private void init(int id) {
        DB.readPlayerGameStatDB(gameData, id);
    }


}
