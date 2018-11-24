package Controller;

import DB.DB;
import POJO.MyAlert;
import POJO.User;
import View.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateUserController {

    private ObservableList<User> personData = FXCollections.observableArrayList();
    @FXML
    private TableView<User> TableUsers;
    @FXML
    private TableColumn<User,String> Login;
    @FXML
    private TableColumn<User, String> Grand;
    @FXML
    private ChoiceBox choiceBoxGrand;
    @FXML
    private TextField TFLoginCreate;
     @FXML
    private TextField TFPassCreate;
     @FXML
    private TextField OldLogin;
     @FXML
    private TextField NewLogin;
     @FXML
    private TextField NewPassword;
     @FXML
     private Tab UpdateUsers;
    @FXML
    private TabPane RootTavleUser;


    private ObservableList<String> grand  = FXCollections.observableArrayList("Бухгалтер","Футболіст", "Працівник", "Керівник","Адмін");
    @FXML
    public void initialize() {
        System.out.print("setMainApp - 1 \n");

        TableUsers.getItems().clear();
        init();
        Login.setCellValueFactory(cellData -> cellData.getValue().getSTLogin());
        Grand.setCellValueFactory(cellData -> cellData.getValue().getSTGrand());
        TableUsers.setItems(personData);

    }

    private void init() {
        personData = DB.readDB(personData);
        choiceBoxGrand.getItems().clear();
        choiceBoxGrand .getItems().addAll(grand);

    }

    @FXML
    private void DeleteUser() throws SQLException {



        int selectedIndex = TableUsers.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            if(!TableUsers.getSelectionModel().getSelectedItem().getLogin().equals("root")){
            if( DB.deleteDB(  (TableUsers.getSelectionModel().getSelectedItem().getLogin()))
                    > 0){
                MyAlert.ShowAlertInfo("Видалено", null);

            TableUsers.getItems().remove(selectedIndex);}}
            else MyAlert.ShowAlertError("Root", null);
        } else {
            MyAlert.ShowAlertError("Виберить запис для видалення", null);

        }
    }

    @FXML
    private void BTNCreateUser() throws SQLException {
        System.out.println(TFLoginCreate.getText().toString() + "  " + TFPassCreate.getText().toString() + choiceBoxGrand.getSelectionModel().getSelectedItem());
      if(!TFLoginCreate.getText().toString().equals("")&&!TFPassCreate.getText().equals(""))
        if(choiceBoxGrand.getSelectionModel().getSelectedItem()==grand.get((0)))
            DB.insertDB(TFLoginCreate.getText().toString(), "GRANT select ON football_club.salary_employee TO ?@'localhost'",TFPassCreate.getText().toString());
            else if(choiceBoxGrand.getSelectionModel().getSelectedItem()==grand.get((1)))
            DB.insertDB(TFLoginCreate.getText().toString(), "GRANT select ON football_club.player TO ?@'localhost';", TFPassCreate.getText().toString());
            else if(choiceBoxGrand.getSelectionModel().getSelectedItem()==grand.get((2)))
            DB.insertDB(TFLoginCreate.getText().toString(), "GRANT select ON football_club.employeeinfo TO ?@'localhost';", TFPassCreate.getText().toString());
            else if(choiceBoxGrand.getSelectionModel().getSelectedItem()==grand.get((3)))
            DB.insertDB(TFLoginCreate.getText().toString(), "GRANT select ON football_club.* TO ?@'localhost';",TFPassCreate.getText().toString());
            else if(choiceBoxGrand.getSelectionModel().getSelectedItem()==grand.get((4)))
            DB.insertDB(TFLoginCreate.getText().toString(), "GRANT ALL ON *.* TO",TFPassCreate.getText().toString());
    }

    @FXML
    private void ShowUpdateTab(){

        int selectedIndex = TableUsers.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {

                OldLogin.setText(TableUsers.getSelectionModel().getSelectedItem().getLogin());
                NewLogin.setText(TableUsers.getSelectionModel().getSelectedItem().getLogin());
                NewPassword.setText("0");




        } else {
            MyAlert.ShowAlertError("Виберить запис для оновлення", null);

        }
        SingleSelectionModel<Tab> selectionModel = RootTavleUser.getSelectionModel();
        selectionModel.select(UpdateUsers);
    }

    @FXML
    private void UpdateUserInDB() throws SQLException {
        if(ValidDate())
        DB.updateDB(OldLogin.getText(),
        NewLogin.getText(),
        NewPassword.getText());
    }

    private boolean ValidDate(){
        System.out.println(OldLogin.getText() + " " + NewLogin.getText() + " " + NewPassword.getText());
       if( !OldLogin.getText().equalsIgnoreCase("")
               && !NewLogin.getText().equalsIgnoreCase("")
               && !NewPassword.getText().equalsIgnoreCase(""))
       return true;
       return false;
    }
    @FXML
    private void ShowChoseAction() throws IOException {
        Stage stage =  (Stage) TableUsers.getScene().getWindow();
        stage.close();
        MainApp.ShowChoseAction();
    }
    }

