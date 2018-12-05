package Controller;

import DB.DB;
import DB.ConnectionDB;
import POJO.Employee;
import POJO.MyAlert;
import View.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeShowInfoController {
    private Stage stage;
    private final ObservableList<Employee> personData = FXCollections.observableArrayList();
    @FXML
    private Button deleteBTN;
    @FXML
    private Button insertBTN;
    @FXML
    private Button updateBTN;
    @FXML
    private TableView<Employee> PlayerTable;
    @FXML
    private TableColumn<Employee, String> NameColumn;
    @FXML
    private TableColumn<Employee, String> CountryColumn;
    @FXML
    private TableColumn<Employee, String> SurnameColumn;
    @FXML
    private TableColumn<Employee, String> BdayColumn;
    @FXML
    private TableColumn<Employee, String> SignColumn;
    @FXML
    private TableColumn<Employee, String> EndColumn;
    @FXML

    private TableColumn<Employee, Integer> SalaryColumn;
    @FXML
    private TableColumn<Employee, String> PostColumn;


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
        PostColumn.setCellValueFactory(cellData -> cellData.getValue().getSTPost());
        PlayerTable.setItems(personData);

        String role = DB.readDB(new ConnectionDB().getUsername());
        if(!"Адмін".equals(role)){
            deleteBTN.setVisible(false);
            insertBTN.setVisible(false);
            updateBTN.setVisible(false);
        }
    }

    private void init() {
        DB.readEmployeeDB(personData);
    }

    @FXML
    private void handleDeletePerson() throws SQLException {
        int selectedIndex = PlayerTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {


            if( DB.deleteEmployeeDB(      (PlayerTable.getSelectionModel().getSelectedItem().getId()))
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
        Employee tempPerson = new Employee();
        boolean okClicked = MainApp.showEmployeeInsertDialog();

    }


    @FXML
    private void handleEditPerson() {

        Employee selectedPerson = PlayerTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = MainApp.showEmployeeUpdateDialog(selectedPerson);


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
