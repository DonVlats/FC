
package Controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import DB.DB;
import POJO.MyAlert;
import POJO.Player;
import View.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PlayerOverviewController {
     private Stage stage;
    private  ObservableList<Player> personData = FXCollections.observableArrayList();
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
    Connection conn ;


    @FXML
    public void initialize() {
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
        FilterDialogController.selectMessage = "";
    
              }
   
    public void setMainApp(ObservableList<Player> mainApp) {
        
        System.out.print("setMainApp - 1 \n");
        PlayerTable.setItems(mainApp);
    }
    public ObservableList<Player> getPersonData() {
return personData;
}

    public void init() {        
          personData = DB.readDB(    personData,FilterDialogController.selectMessage);
              }
    
        @FXML
private void handleDeletePerson() throws SQLException {
    int selectedIndex = PlayerTable.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
       
  
   if( DB.deleteDB(      (PlayerTable.getSelectionModel().getSelectedItem().getId()))
           > 0){
       MyAlert.ShowAlertInfo("Видалено", stage);
   }
        PlayerTable.getItems().remove(selectedIndex);
    } else {
        MyAlert.ShowAlertError("Виберить запис для видалення", stage);
      
    }
    
    
}

@FXML
private void handleNewMovie() {
    Player tempPerson = new Player();
    boolean okClicked = MainApp.showMovieEditDialog(tempPerson);
    if (okClicked) {
        ;
    }
}
@FXML
private void Filter() {
  
 MainApp.showFilterDialog();
  
}
private void showPersonDetails(Player player) {
    if (player != null) {
           } else {
                ;
    }
}

public void setStage(Stage stage) {
        this.stage = stage;
    }
@FXML
private void handleEditPerson() {
    Player selectedPerson = PlayerTable.getSelectionModel().getSelectedItem();
    if (selectedPerson != null) {
        boolean okClicked = MainApp.showMovieUpdateDialog(selectedPerson);
        if (okClicked) {
            showPersonDetails(selectedPerson);
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
      MainApp.ShowChoseAction();

    }
}