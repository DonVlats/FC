package Controller;

import DB.DB;
import POJO.Employee;
import POJO.MyAlert;
import POJO.Player;
import View.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeInfoForAccountantController {   private Stage stage;
    private final ObservableList<Employee> personData = FXCollections.observableArrayList();
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
    private Label SalaryPlayer;
  @FXML
    private Label SalaryEmp;
  @FXML
    private Label SalaryAll;

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

        setSalaryValue();
    }

    private void setSalaryValue() {
        int salPl = 0 ;
        int salEm = 0 ;
        for (Employee emp: personData){
            if (emp.getPost() .equals( "Футболіст"))
                salPl +=emp.getSalary();
            else
                salEm += emp.getSalary();
        }
        SalaryPlayer.setText(String.valueOf(salPl));
        SalaryEmp.setText(String.valueOf(salEm));
        SalaryAll.setText(String.valueOf(salPl + salEm));
    }

    private void init() {
        DB.readEmployeeForAccountantDB(personData);
    }



    public void setDialogStage(Stage dialogStage) {
        this.stage = dialogStage;
    }
    @FXML
    private void ShowChoseAction() throws IOException {
        stage.close();
        MainApp.ShowChoseActionForAccountant();

    }
    public void AuthShow() {
        Stage stage =  (Stage) PlayerTable.getScene().getWindow();
        stage.close();
        MainApp.showAuthAgain();
    }

}
