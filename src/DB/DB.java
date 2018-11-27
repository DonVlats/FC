/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;


import POJO.Game;
import POJO.GameStat;
import POJO.Player;
import POJO.User;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;


public class DB {




    public static ObservableList<Player> readDB(ObservableList<Player> personData, String select){
   System.out.println("ReadDB\n");
      personData = SelectDB.SelectPlayer(personData, select);
          System.out.println("EndReadDB\n");
   
    return personData;
}   public static ArrayList<Player> readDB(ArrayList<Player> personData, String select){
   System.out.println("ReadDB\n");
      personData = SelectDB.SelectPlayer(personData, select);
          System.out.println("EndReadDB\n");

    return personData;
}   public static ObservableList<Game> readGameDB(ObservableList<Game> gameData){
   System.out.println("ReadDB\n");
        gameData = SelectDB.SelectGame(gameData);
          System.out.println("EndReadDB\n");

    return gameData;
}
public static ObservableList<GameStat> readGameStatDB(ObservableList<GameStat> gameData, int id){
   System.out.println("ReadDB\n");
        gameData = SelectDB.SelectGameStat(gameData, id);
          System.out.println("EndReadDB\n");

    return gameData;
}
public static ObservableList<User> readDB(ObservableList<User> personData){
   System.out.println("ReadDB\n");
      personData = SelectDB.SelectUser(personData);
          System.out.println("EndReadDB\n");

    return personData;
}
     
    public static Integer deleteDB(int Id) throws SQLException {
   System.out.println("DeleteDB\n");
      int count = DeleteDB.delete(Id);
          System.out.println("EndDeleteDB\n");
   
    return count;
};
    public static Integer deleteGameDB(int Id) throws SQLException {
   System.out.println("DeleteDB\n");
      int count = DeleteDB.deleteGame(Id);
          System.out.println("EndDeleteDB\n");

    return count;
};
public static Integer deleteDB(String Id) throws SQLException {
   System.out.println("DeleteDB\n");
      int count = DeleteDB.deleteUser(Id);
          System.out.println("EndDeleteDB\n");

    return count;
};
    public static boolean deleteGameStatDB(int id) throws SQLException {
        System.out.println("DeleteDB\n");
        int count = DeleteDB.deleteGameStat(id);
        System.out.println("EndDeleteDB\n");
        if (count > 0)
            return true;
        return false;
    }
   public static Integer insertDB(Player player) throws SQLException {
   System.out.println("insertDB\n");
      int count = InsertDB.insert(player);
          System.out.println("EndDeleteDB\n");
   
    return count;
};   public static Integer insertDB(Game game) throws SQLException {
   System.out.println("insertDB\n");
      int count = InsertDB.insertGame(game);
          System.out.println("EndDeleteDB\n");

    return count;
};
public static Integer insertDB(GameStat game) throws SQLException {
   System.out.println("insertDB\n");
      int count = InsertDB.insertGameStat(game);
          System.out.println("EndDeleteDB\n");

    return count;
};
   public static Integer insertDB(String login,String grand,String passsword ) throws SQLException {
   System.out.println("insertDB\n");
      int count = InsertDB.insertUser(login, grand, passsword);
          System.out.println("EndDeleteDB\n");

    return count;
};
      public static Integer updateDB(Player player) throws SQLException {
   System.out.println("insertDB\n");
      int count = UpdateDB.update(player);
          System.out.println("EndDeleteDB\n");
   
    return count;
};
      public static Integer updateDB(GameStat gameStat) throws SQLException {
   System.out.println("insertDB\n");
      int count = UpdateDB.updateGameStat(gameStat);
          System.out.println("EndDeleteDB\n");

    return count;
};
      public static Integer updateDB(Game game) throws SQLException {
   System.out.println("insertDB\n");
      int count = UpdateDB.updateGame(game);
          System.out.println("EndDeleteDB\n");

    return count;
};
      public static Integer updateDB(String oldLogin, String login,String passsword ) throws SQLException {
   System.out.println("insertDB\n");
      int count = UpdateDB.updateUser(oldLogin, login, passsword);
          System.out.println("EndDeleteDB\n");

    return count;
};




}
