package Controller;

import DB.DB;
import DB.ConnectionDB;
import POJO.Game;
import POJO.MyAlert;

import View.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class GameShowInfoController {
    private Stage stage;
    private final ObservableList<Game> gameData = FXCollections.observableArrayList();
    @FXML
    private Button deleteBTN;
    @FXML
    private Button insertBTN;
    @FXML
    private Button updateBTN;
    @FXML
    private TableView<Game> gameTable;
    @FXML
    private TableColumn<Game, String> opponentColumn;
    @FXML
    private TableColumn<Game, String> competitionColumn;
    @FXML
    private TableColumn<Game, String> dataColumn;
    @FXML
    private TableColumn<Game, Integer> scoreColumn;
    @FXML
    private TableColumn<Game, Integer> scoreOpponentColumn;
    @FXML
    private TableColumn<Game, String> homeColumn;


    @FXML
    public void initialize() {
        System.out.print("setMainApp - 1 \n");
        gameTable.getItems().clear();
        init();
        opponentColumn.setCellValueFactory(cellData -> cellData.getValue().getSTopponent());
        competitionColumn.setCellValueFactory(cellData -> cellData.getValue().getSTcompetition());
        dataColumn.setCellValueFactory(cellData->cellData.getValue().getSTdata());
        scoreColumn.setCellValueFactory(cellData -> cellData.getValue().getSTscore().asObject());
        scoreOpponentColumn.setCellValueFactory(cellData -> cellData.getValue().getSTscoreOpponent().asObject());

        homeColumn.setCellValueFactory(cellData -> cellData.getValue().getSThome());

        gameTable.setItems(gameData);

        gameTable.setRowFactory(tv -> {
            TableRow<Game> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Game rowData = row.getItem();
                    System.out.println("Double click on: "+rowData.getId());
                    try {
                        if(rowData.getId()>0)
                        MainApp.ShowGameStatInfo(rowData,rowData.getId());
                        else
                            MainApp.ShowGameStatInfo(rowData,0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row; });
        String role = DB.readDB(new ConnectionDB().getUsername());
        if(!"Адмін".equals(role)){
            deleteBTN.setVisible(false);
            insertBTN.setVisible(false);
            updateBTN.setVisible(false);
        }
    }
    @FXML
    public void ShowStat() throws IOException {
        Game game =gameTable.getSelectionModel().getSelectedItem();
        if( game != null)
            MainApp.ShowGameStatInfo(gameTable.getSelectionModel().getSelectedItem(),gameTable.getSelectionModel().getSelectedItem().getId());
        else
            MainApp.ShowGameStatInfo(gameTable.getSelectionModel().getSelectedItem(),0);
    }

    private void init() {
        DB.readGameDB(gameData);
    }



    @FXML
    private void handleNewMovie() {
        Game tempPerson = new Game();
        boolean okClicked =MainApp.showGameInsertDialog();
    }

    @FXML
    private void handleEditPerson() {
        Game selectedPerson = gameTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
           MainApp.showGameUpdatedDialog(selectedPerson);


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
        MainApp.ShowChoseAction();

    }
    @FXML
    private void handleDeletePerson() throws SQLException {
        int selectedIndex = gameTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {


            if( DB.deleteGameDB(      (gameTable.getSelectionModel().getSelectedItem().getId()))
                    > 0){
                MyAlert.ShowAlertInfo("Видалено");
            }
            gameTable.getItems().remove(selectedIndex);
        } else {
            MyAlert.ShowAlertError("Виберить запис для видалення", stage);

        }


    }
}
