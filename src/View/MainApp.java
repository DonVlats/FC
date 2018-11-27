/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.io.IOException;
import java.sql.SQLException;

import Controller.*;
import POJO.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;

  static String select;

            public static boolean showGameStatUpdateDialog(Game game, GameStat selectedPerson) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("GameStatUpdateDialog.fxml"));
                AnchorPane page = (AnchorPane) loader.load();


                Stage dialogStage = new Stage();
                dialogStage.setTitle("Редагування");
                dialogStage.initModality(Modality.NONE);

                Scene scene = new Scene(page);
                dialogStage.setScene(scene);


                GameStatUpdateDialogController controller = loader.getController();
                controller.setDialogStage(dialogStage);


                controller.setPerson(selectedPerson);
                controller.initialize(game);
                if(game == null)
                    MyAlert.ShowAlertError("Виберіть матч",null);
                else
                    dialogStage.showAndWait();

                return controller.isOkClicked();



    }

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
public static void ShowEmployeeInfo() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("EmployeeShowInfo.fxml"));
    AnchorPane page = (AnchorPane) loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Редагування");
    dialogStage.initModality(Modality.NONE);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    EmployeeShowInfoController controller = loader.getController();
    controller.setDialogStage(dialogStage);



    dialogStage.show();

}
public static void ShowGameInfo() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("GameShowInfo.fxml"));
    AnchorPane page = (AnchorPane) loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Редагування");
    dialogStage.initModality(Modality.NONE);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    GameShowInfoController controller = loader.getController();
    controller.setDialogStage(dialogStage);



    dialogStage.show();

}
public static void ShowGameStatInfo(Game game, int id) throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("GameStatShow.fxml"));
    AnchorPane page = (AnchorPane) loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Редагування");
    dialogStage.initModality(Modality.NONE);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    GameStatShowController controller = loader.getController();
    controller.initializeStat(id);
    controller.setGame(game);
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
public static boolean showEmployeeInsertDialog(Employee person) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("EmployeeInsertDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);


        EmployeeInsertDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        //controller.setPerson(person);


        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
public static boolean showGameStatInsertDialog(Game game ) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("GameStatInsertDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);


        GameStatInsertDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.initialize(game);
        //controller.setPerson(person);

        if(game == null)
            MyAlert.ShowAlertError("Виберіть матч",null);
        else
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
public static boolean showEmployeeUpdateDialog(Employee person) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("EmployeeUpdateDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);


        EmployeeUpdateDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
       controller.setPerson(person);


        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
public static boolean showGameInsertDialog( ) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("GameInsertDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);


        GameInsertDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);



        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

    public static boolean showGameUpdatedDialog(Game game) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("GameUpdateDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Редагування");
            dialogStage.initModality(Modality.NONE);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            GameUpdateDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(game);


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
