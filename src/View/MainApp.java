/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.io.IOException;

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

    public static boolean showGameStatUpdateDialog(Game game, GameStat selectedPerson) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("GameStatUpdateDialog.fxml"));
                AnchorPane page = loader.load();


                Stage dialogStage = new Stage();
                dialogStage.setTitle("Оновлення статистики");
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



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Клуб");

         
         initRootLayout();

         showAuth();
    }



    private void initRootLayout() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Auth.fxml"));
            AnchorPane rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            this.primaryStage.setTitle("Авторизація");
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

public MainApp() {
}



public static void main(String[] args) {
    
  
        launch(args);
       
    }
public static void ShowPlayerInfo() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("PlayerShowInfo.fxml"));
    AnchorPane page = loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Футболісти");
    dialogStage.initModality(Modality.NONE);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    PlayerOverviewController controller = loader.getController();
    controller.setDialogStage(dialogStage);



    dialogStage.show();

}public static void ShowEmployeeInfoForAccountant() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("EmployeeInfoForAccountant.fxml"));
    AnchorPane page = loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Працівники");
    dialogStage.initModality(Modality.NONE);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    EmployeeInfoForAccountantController controller = loader.getController();
    controller.setDialogStage(dialogStage);



    dialogStage.show();

}
public static void ShowEmployeeInfo() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("EmployeeShowInfo.fxml"));
    AnchorPane page = loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Працівники");
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
    AnchorPane page = loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Матчі");
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
    AnchorPane page = loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Статистика матчу");
    dialogStage.initModality(Modality.NONE);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    GameStatShowController controller = loader.getController();
    controller.initializeStat(id);
    controller.setGame(game);
    controller.setDialogStage(dialogStage);


    dialogStage.show();

}
public static void ShowGameStatInfo(int id) throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("PlayerStatShow.fxml"));
    AnchorPane page = loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Статистика матчу");
    dialogStage.initModality(Modality.WINDOW_MODAL);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    PlayerStatShowController controller = loader.getController();
    controller.initializeStat(id);



    dialogStage.show();

}
public static void ShowGameStatInfoForPlayer(int id) throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("PlayerStatInfoShow.fxml"));
    AnchorPane page = loader.load();


    Stage dialogStage = new Stage();
    dialogStage.setTitle("Статистика матчу");
    dialogStage.initModality(Modality.WINDOW_MODAL);

    Scene scene = new Scene(page);
    dialogStage.setScene(scene);


    PlayerStatInfoShowController controller = loader.getController();
    controller.initializeStat(id);



    dialogStage.show();

}
    public static void ShowChoseAction() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("ChoseAction.fxml"));
        AnchorPane page = loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Вибір ");
        dialogStage.initModality(Modality.NONE);
        ChoseActionController controller = loader.getController();
        controller.init();
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);



        dialogStage.show();

    }
    public static void ShowChoseActionForAccountant() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("ChoseActionForAccountant.fxml"));
        AnchorPane page = loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Вибір");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);



        dialogStage.show();
    }
public static boolean showPlayerInsertDialog() {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("PlayerInsertDialog.fxml"));
        AnchorPane page = loader.load();

       
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Додавання нового гравця");
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
public static boolean showEmployeeInsertDialog() {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("EmployeeInsertDialog.fxml"));
        AnchorPane page = loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Додавання нового працівника");
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
        AnchorPane page = loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Додавання статистики ");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);


        GameStatInsertDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.initialize(game);
        //controller.setPerson(person);

        if(game == null)
            MyAlert.ShowAlertError("Виберіть матч",null);
        else{
        dialogStage.showAndWait();

        return controller.isOkClicked();}
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
    return true;
}
public static void showUsers() {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("CreateUser.fxml"));
        AnchorPane page = loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Користувачі");
        dialogStage.initModality(Modality.NONE);

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);



        dialogStage.showAndWait();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static boolean showPlayerUpdateDialog(Player person) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("PlayerUpdateDialog.fxml"));
        AnchorPane page = loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування даних про гравця");
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
        AnchorPane page = loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редагування даних про робітника");
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
        AnchorPane page = loader.load();


        Stage dialogStage = new Stage();
        dialogStage.setTitle("Додавання інформації про матч");
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
            AnchorPane page = loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Оновлення інформації про матч");
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
    private void showAuth() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Auth.fxml"));

           // PlayerOverviewController controller = loader.getController();
            System.out.print("\nShowPlayerInfo\n");


            primaryStage.show();
            loader.setController(this);

        }catch(Exception ignored){
        }
    }
    public static void showAuthAgain( ) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Auth.fxml"));
            AnchorPane page = loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Авторизація");
            dialogStage.initModality(Modality.NONE);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);





            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
