/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author 123
 */
public class MyAlert {
    
    public static void ShowAlertError(String message , Stage stage ){
     Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(stage);
            alert.setTitle("Помилочка");
            alert.setHeaderText("Дані некоректні");
            alert.setContentText(message);
            
            alert.showAndWait();
} 
    public static void ShowAlertInfo(String message , Stage stage ){
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Інформація");
    alert.setHeaderText(null);
   alert.setContentText(message);
    alert.showAndWait();
}
    
}
