
package Controller;


import java.io.IOException;
import java.sql.SQLException;

import DB.DB;
import DB.ConnectionDB;
import POJO.MyAlert;
import POJO.Player;
import View.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PlayerOverviewController {
     private Stage stage;
    private final ObservableList<Player> personData = FXCollections.observableArrayList();
    @FXML
    private Button deleteBTN;
    @FXML
    private Button insertBTN;
    @FXML
    private Button updateBTN;
    @FXML
    private TableView<Player> PlayerTable;
    @FXML
    private TableColumn<Player, String> NameColumn;
    @FXML
    private TableColumn<Player, String> CountryColumn;
    @FXML
    private TableColumn<Player, String> SurnameColumn;
    @FXML
    private TableColumn<Player, String> BdayColumn;
    @FXML
    private TableColumn<Player, String> SignColumn;
    @FXML
    private TableColumn<Player, String> EndColumn;
    @FXML

    private TableColumn<Player, Integer> SalaryColumn;
    @FXML
    private TableColumn<Player, Integer> PriceColumn;


    @FXML
    public void initialize() throws SQLException {
           System.out.print("setMainApp - 1 \n");
        PlayerTable.getItems().clear();
        init();              
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().getSTName());
        SurnameColumn.setCellValueFactory(cellData -> cellData.getValue().getSTSurname());
        CountryColumn.setCellValueFactory(cellData->cellData.getValue().getSTNationality());
        BdayColumn.setCellValueFactory(cellData -> cellData.getValue().getSTBday());
        SignColumn.setCellValueFactory(cellData -> cellData.getValue().getSTDataSign());
        EndColumn.setCellValueFactory(cellData -> cellData.getValue().getSTDataEnd());
        SalaryColumn.setCellValueFactory(cellData -> cellData.getValue().getSTSalary().asObject());
        PriceColumn.setCellValueFactory(cellData -> cellData.getValue().getSTPrice().asObject());
        PlayerTable.setItems(personData);

        PlayerTable.setRowFactory(tv -> {
            TableRow<Player> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Player rowData = row.getItem();
                    System.out.println("Double click on: "+rowData.getId());
                    try {
                        if(rowData.getId()>0)
                            MainApp.ShowGameStatInfo(rowData.getId());
                        else
                            MainApp.ShowGameStatInfo(0);
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
            }}


    private void init() {
        DB.readOBlistDB(personData);
    }
    
        @FXML
private void handleDeletePerson() throws SQLException {
    int selectedIndex = PlayerTable.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
       
  
   if( DB.deleteDB(      (PlayerTable.getSelectionModel().getSelectedItem().getId()))
           > 0){
       MyAlert.ShowAlertInfo("Видалено");
   }
        PlayerTable.getItems().remove(selectedIndex);
    } else {
        MyAlert.ShowAlertError("Виберить запис для видалення", stage);
      
    }
    
    
}

@FXML
private void handleNewMovie() {
    Player tempPerson = new Player();
    boolean okClicked = MainApp.showPlayerInsertDialog();

}


    @FXML
private void handleEditPerson() {

    Player selectedPerson = PlayerTable.getSelectionModel().getSelectedItem();
    if (selectedPerson != null) {
        boolean okClicked = MainApp.showPlayerUpdateDialog(selectedPerson);


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
}