/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * View Controller class
 *
 * @author 123
 */
public class FilterDialogController implements Initializable {
    @FXML
    private TextField IDField;
    @FXML
    private TextField TitleField;
    @FXML
    private TextField YearField;
    @FXML
    private TextField DirectorField;

    /**
     * Initializes the controller class.
     */  
   static String selectMessage = "";

    public String getSelectMessage() {
        return selectMessage;
    }
        private Stage dialogStage;
      public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      private boolean isInputValid() {
        String errorMessage = "";
      
        if (IDField.getText() == null || IDField.getText().length() == 0) {
            errorMessage += "Id!\n";             
        }
        else if(selectMessage.equals(""))
            selectMessage = "Id = "+IDField.getText().toString();
        
        if (TitleField.getText() == null || TitleField.getText().length() == 0) {
            errorMessage += "Title !\n"; 
        }else if(selectMessage.equals(""))
            selectMessage = "Title =" + "'" + TitleField.getText().toString()+ "'";
        else  selectMessage += "&&Title =" + "'" + TitleField.getText().toString()+ "'";
        
        
        
        if (YearField.getText() == null || YearField.getText().length() == 0) {
            errorMessage += "Year!\n"; 
        }
           else if(selectMessage.equals(""))
            selectMessage = "Year =" + YearField.getText().toString();
        else  selectMessage += "&&Year =" + YearField.getText().toString();
        
        
        if (DirectorField.getText() == null || DirectorField.getText().length() == 0) {
            errorMessage += "director!\n"; 
        } else if(selectMessage.equals(""))
            selectMessage = "director =" + "'" + YearField.getText().toString()+ "'";
        else if(selectMessage !=  null) 
            selectMessage += "&&director =" + "'" + YearField.getText().toString()+ "'";
       /* else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(IDField.getText());
                Integer.parseInt(YearField.getText());

                
            } catch (NumberFormatException e) {
                errorMessage += "ID і year - ЧИСЛАААА!\n"; 
            }
        }*/

      
        

       
         //   System.out.print("selectMessage            "+selectMessage + "   selectMessage");
          
            return true;
        
    }
     @FXML
    public String OkClicked() {
     
        isInputValid();
       new PlayerOverviewController().init();
     
            dialogStage.close();
        return selectMessage;
            }
         @FXML
    public void CencelClicked() {
         FilterDialogController.selectMessage = "";
        dialogStage.close();
    }
}
