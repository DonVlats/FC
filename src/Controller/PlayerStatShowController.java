package Controller;

import DB.DB;

import POJO.GameStat;

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


public class PlayerStatShowController {
    private int idGame;
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
    private TableColumn<GameStat, Integer> goalColumn;
    @FXML
    private TableColumn<GameStat, Integer> assistColumn;


    @FXML
    public void ShowStat(){
           initializeStat(idGame);
          }
    @FXML
    public void initializeStat(int id) {
        idGame = id;
        System.out.print("setMainApp - 1 \n");
        gameStatTable.getItems().clear();
        init(id);
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getSTname());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().getSTsurname());
        startColumn.setCellValueFactory(cellData->cellData.getValue().getSTOpponent());
        goalColumn.setCellValueFactory(cellData -> cellData.getValue().getSTgoal().asObject());

        assistColumn.setCellValueFactory(cellData -> cellData.getValue().getSTassist().asObject());

        gameStatTable.setItems(gameData);
        gameStatTable.setRowFactory(tv -> {
            TableRow<GameStat> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    GameStat rowData = row.getItem();
                    System.out.println("Double click on: "+rowData.getId());
                    try {
                        if(rowData.getId()>0)
                            MainApp.ShowGameStatInfoForPlayer(rowData.getId());
                        else
                            MainApp.ShowGameStatInfoForPlayer(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row; });



    }

    private void init(int id) {
        DB.readPlayerStatDB(gameData, id);
    }

    }

