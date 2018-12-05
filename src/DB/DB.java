/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;


import POJO.*;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;


public class DB {




    public static void readOBlistDB(ObservableList<Player> personData){
   System.out.println("ReadDB\n");
        SelectDB.SelectPlayer(personData);
        System.out.println("EndReadDB\n");

    } public static void readEmployeeForAccountantDB(ObservableList<Employee> personData){
   System.out.println("ReadDB\n");
        SelectDB.SelectEmployeeForAccountant(personData);
        System.out.println("EndReadDB\n");

    }   public static void readDB(ArrayList<Player> personData){
   System.out.println("ReadDB\n");
        SelectDB.SelectPlayer(personData);
        System.out.println("EndReadDB\n");

    }   public static void readGameDB(ObservableList<Game> gameData){
   System.out.println("ReadDB\n");
        SelectDB.SelectGame(gameData);
        System.out.println("EndReadDB\n");

    }
public static void readGameStatDB(ObservableList<GameStat> gameData, int id){
   System.out.println("ReadDB\n");
    SelectDB.SelectGameStat(gameData, id);
    System.out.println("EndReadDB\n");

}
public static void readPlayerStatDB(ObservableList<GameStat> gameData, int id){
   System.out.println("ReadDB\n");
    SelectDB.SelectPlayerStat(gameData, id);
    System.out.println("EndReadDB\n");

}
    public static void readPlayerGameStatDB(ObservableList<GameStat> gameData, int id) {
        System.out.println("ReadDB\n");
        SelectDB.SelectPlayerInfoStat(gameData, id);
        System.out.println("EndReadDB\n");
    }
public static void readDB(ObservableList<User> personData){
   System.out.println("ReadDB\n");
    SelectDB.SelectUser(personData);
    System.out.println("EndReadDB\n");

}public static String readDB(String login){
   System.out.println("ReadDB\n");
    return SelectDB.SelectUser(login);


}
public static void readEmployeeDB(ObservableList<Employee> personData){
   System.out.println("ReadDB\n");
        SelectDB.SelectEmployee(personData);
        System.out.println("EndReadDB\n");

    }
     
    public static Integer deleteDB(int Id) throws SQLException {
   System.out.println("DeleteDB\n");
     return DeleteDB.delete(Id);

}

    public static Integer deleteGameDB(int Id) throws SQLException {
   System.out.println("DeleteDB\n");
      return DeleteDB.deleteGame(Id);

}

    public static Integer deleteDB(String Id) throws SQLException {
   System.out.println("DeleteDB\n");
    return DeleteDB.deleteUser(Id);


}

    public static Integer deleteEmployeeDB(int id) throws SQLException {
        System.out.println("DeleteDB\n");
        return DeleteDB.deleteEmployee(id);

    }
    public static Integer deleteGameStatDB(int id) throws SQLException {
        System.out.println("DeleteDB\n");
        return DeleteDB.deleteGameStat(id);

    }
   public static Integer insertDB(Player player) throws SQLException {
   System.out.println("insertDB\n");
     return InsertDB.insert(player);

}

    public static Integer insertDB(Employee employee) throws SQLException {
   System.out.println("insertDB\n");
     return InsertDB.insertEmployee(employee);

}

    public static Integer insertDB(Game game) throws SQLException {
   System.out.println("insertDB\n");
    return InsertDB.insertGame(game);

}

    public static Integer insertDB(GameStat game) throws SQLException {
   System.out.println("insertDB\n");
      return InsertDB.insertGameStat(game);

}

    public static Integer insertDB(String login, String grand, String passsword ) throws SQLException {
   System.out.println("insertDB\n");
      return InsertDB.insertUser(login, grand, passsword);


    }

    public static Integer updateDB(Player player) throws SQLException {
   System.out.println("insertDB\n");
      return UpdateDB.update(player);


    }

    public static Integer updateDB(GameStat gameStat) throws SQLException {
   System.out.println("insertDB\n");
      return UpdateDB.updateGameStat(gameStat);



}

    public static Integer updateDB(Game game) throws SQLException {
   System.out.println("insertDB\n");
      return UpdateDB.updateGame(game);

}

    public static Integer updateDB(Employee employee) throws SQLException {
   System.out.println("insertDB\n");
     return UpdateDB.updateEmployee(employee);


    }

    public static Integer updateDB(String oldLogin, String login, String passsword ) throws SQLException {
   System.out.println("insertDB\n");
      return UpdateDB.updateUser(oldLogin, login, passsword);


    }



}
