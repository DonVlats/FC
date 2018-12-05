package Controller;

import DB.DB;
import POJO.Employee;
import POJO.MyAlert;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class EmployeeUpdateDialogController {

    @FXML
    public TextField PostField;
    @FXML
    private TextField NameField;
    @FXML
    private TextField SurnameField;
    @FXML
    private TextField CountryField;
    @FXML
    private TextField PhoneField;
    @FXML
    private TextField SignField;
    @FXML
    private TextField EndField;
    @FXML
    private TextField SalaryField;

    @FXML
    private TextField BdayField;




    private Stage dialogStage;
    private Employee employee;


    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /* public void setPerson(Player player) {
        this.player = player;
        if(player.getBday() != 0)
        isUpdate = true;
        NameField.setText(Integer.toString(player.getIdN()));
        SurnameField.setText(player.getTitle());
        CountryField.setText(Integer.toString(player.getYearN()));
        DirectorField.setText(player.getDirectorN());

    }*/

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return false;
    }




    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (NameField.getText() == null || NameField.getText().length() == 0) {
            errorMessage += "ID!\n";
        }
        if (SurnameField.getText() == null || SurnameField.getText().length() == 0) {
            errorMessage += "Title !\n";
        }
        if (CountryField.getText() == null || CountryField.getText().length() == 0) {
            errorMessage += "Year!\n";
        }

        if (PhoneField.getText() == null || PhoneField.getText().length() == 0) {
            errorMessage += "director!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(SalaryField.getText());
                Integer.parseInt(PhoneField.getText());


            } catch (NumberFormatException e) {
                errorMessage += "ID і year - ЧИСЛАААА!\n";
            }
        }




        if (errorMessage.length() == 0) {
            employee = new Employee(this.employee.getId(),
                    NameField.getText()
                    , SurnameField.getText(),
                    BdayField.getText(),
                    CountryField.getText() ,
                    SignField.getText(),
                    EndField.getText(),
                    Integer.parseInt(SalaryField.getText()),
                    Integer.parseInt(PhoneField.getText()),
                    PostField.getText()
            );
                    //

            return true;
        } else {
            // Show the error message.

            MyAlert.ShowAlertError(errorMessage, dialogStage);
            return false;
        }
    }
    @FXML
    public void AddClicked() throws SQLException {
        // Initialize the person table with the two columns.
        if(this.isInputValid())

        if(DB.updateDB(employee) > 0){
            MyAlert.ShowAlertInfo("Дані успішно оновленно");
        }
        dialogStage.close();

    }
    @FXML
    public void CencelClicked() {
        dialogStage.close();
    }

    public void setPerson(Employee player) {
        this.employee = player;
        NameField.setText(player.getName());
        SurnameField.setText(player.getSurname());
        CountryField.setText(player.getNationality());
        PhoneField.setText(String.valueOf(player.getPhone()));
        BdayField.setText(player.getBday());
        SignField.setText(player.getDataSign());
        EndField.setText(player.getDataEnd());
        SalaryField.setText(String.valueOf(player.getSalary()));
        PostField.setText(String.valueOf(player.getPost()));
    }
}
