/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.io.IOException;
import java.sql.SQLException;

import Controller.*;
import POJO.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;

  static String select;

    public String getSelect() {
        return select;
    }
    private AnchorPane rootLayout;

     @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Фільми");
          new AuthController().setDialogStage(primaryStage);
         
         initRootLayout();

         showAuth();
    }



    public void initRootLayout() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Auth.fxml"));
            rootLayout = (AnchorPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

public MainApp() {
}



public static void main(String[] args) throws SQLException {
    
  
        launch(args);
       
    }
public static void ShowPlayerInfo() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("PlayerShowInfo.fxml"));
    AnchorPane page = (AnchorPane) loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Редагування");
    dialogStage.initModality(Modality.NONE);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    PlayerOverviewController controller = loader.getController();
    controller.setDialogStage(dialogStage);



    dialogStage.show();

}
    public static void ShowChoseAction() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("ChoseAction.fxml"));
        AnchorPane page = (AnchorPane) loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);


        ChoseActionController controller = loader.getController();
        controller.setDialogStage(dialogStage);



        dialogStage.show();

    }
public static boolean showMovieEditDialog(Player person) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("PlayerInsertDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

       
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування");
        dialogStage.initModality(Modality.NONE);
      
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

       
        PlayerInsertDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        //controller.setPerson(person);

    
        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
public static boolean showUsers() {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("CreateUser.fxml"));
        AnchorPane page = (AnchorPane) loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);


        CreateUserController controller = loader.getController();

       // controller.setDialogStage(dialogStage);
        //controller.setPerson(person);


        dialogStage.showAndWait();

        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

public static boolean showMovieUpdateDialog(Player person) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("PlayerUpdateDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);


        PlayerUpdateDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPerson(person);


        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
    public  boolean showAuth( ) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Auth.fxml"));

           // PlayerOverviewController controller = loader.getController();
            System.out.print("\nShowPlayerInfo\n");

            loader.setController(this);

        }catch(Exception e){
        }
        return true;
    }
public static boolean showFilterDialog() {
    try {
     
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("FilterDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

       
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Фільтр");
        dialogStage.initModality(Modality.NONE);
    
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

       
        FilterDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
       

       
        dialogStage.showAndWait();
        select = controller.OkClicked();
     
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
    return true;
}
    public static boolean showAuthAgain( ) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Auth.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Редагування");
            dialogStage.initModality(Modality.NONE);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            AuthController controller = loader.getController();
            controller.setDialogStage(dialogStage);



            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
