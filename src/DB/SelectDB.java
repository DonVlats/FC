/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;
import java.util.ArrayList;

import POJO.*;
import javafx.collections.ObservableList;

/**
 *
 * @author 123
 */
public class SelectDB {
   
    public static ObservableList<Player> SelectPlayer(ObservableList<Player> personData, String select){
       
              try {
                    Connection conn = new ConnectionDB().GetConnectDatabase();
                    Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                
                ResultSet res = stm.executeQuery("SELECT * FROM football_club.player");
                  /* System.out.print("\n selSta" + "SELECT * FROM movie where " + select + "End sel\n");
                 if(select != null&&!select.equals("")){
                     System.out.print(select);
                           res  = stm.executeQuery("SELECT * FROM movie where " + select);
                 }
               */
                 System.out.println("\nSelectPlayer\n" );
                while (res.next()) {
                     final int id = res.getInt("id");;
                     final String name = res.getString("name");;
                     final String surname = res.getString("surname");
                     final String bday = res.getString("Date of signing");
                     final String nat = res.getString("Nationality");
                     final String dataSign = res.getString("Date of signing");
                     final String dataEnd = res.getString("Completion date");
                     final int price = res.getInt("Price");
                     final int salary = res.getInt("Salary");
                     final int phone = res.getInt("Phone");

                     personData.add(new Player(id, name, surname, nat, phone, bday,dataSign,dataEnd,price, salary));
                   
                    
                    
 }
  conn.close();
  stm.close();
            }
 catch (SQLException ex) {
     
 MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);

 
 System.out.println("SQLException: " + ex.getMessage());
 System.out.println("SQLState: " + ex.getSQLState());
 System.out.println("VendorError: " + ex.getErrorCode());
}
              return personData;
    }
    public static ArrayList<Player> SelectPlayer(ArrayList<Player> personData, String select){

              try {
                    Connection conn = new ConnectionDB().GetConnectDatabase();
                    Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                ResultSet res = stm.executeQuery("SELECT * FROM football_club.player");
                  /* System.out.print("\n selSta" + "SELECT * FROM movie where " + select + "End sel\n");
                 if(select != null&&!select.equals("")){
                     System.out.print(select);
                           res  = stm.executeQuery("SELECT * FROM movie where " + select);
                 }
               */
                 System.out.println("\nSelectPlayer\n" );
                while (res.next()) {
                     final int id = res.getInt("id");;
                     final String name = res.getString("name");;
                     final String surname = res.getString("surname");
                     final String bday = res.getString("Date of signing");
                     final String nat = res.getString("Nationality");
                     final String dataSign = res.getString("Date of signing");
                     final String dataEnd = res.getString("Completion date");
                     final int price = res.getInt("Price");
                     final int salary = res.getInt("Salary");
                     final int phone = res.getInt("Phone");

                     personData.add(new Player(id, name, surname, nat, phone, bday,dataSign,dataEnd,price, salary));



 }
  conn.close();
  stm.close();
            }
 catch (SQLException ex) {

 MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);


 System.out.println("SQLException: " + ex.getMessage());
 System.out.println("SQLState: " + ex.getSQLState());
 System.out.println("VendorError: " + ex.getErrorCode());
}
              return personData;
    }

    public static ObservableList<User> SelectUser(ObservableList<User> personData) {

        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet res = stm.executeQuery("select user from mysql.user");


            while (res.next()) {

                final String login = res.getString("USER");
                PreparedStatement pst = conn.prepareStatement("SHOW GRANTS FOR ?@localhost");
                pst.setString(1, res.getString("USER"));
                ResultSet rst = pst.executeQuery();
                 String grand = "" ;
                while (rst.next()) {
                    grand += rst.getString("Grants for "+res.getString("USER")+"@localhost");
                }

                System.out.println("\nSelectUser\n" + login + grand );
                personData.add(new User(login, grand));



            }
            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return personData;
    }

    public static ObservableList<Game> SelectGame(ObservableList<Game> gameData) {
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet res = stm.executeQuery("SELECT * FROM football_club.game ");


            while (res.next()) {
                final int id = res.getInt("id");;
                final String opponent = res.getString("opponent");;
                final String competition = res.getString("competition");;
                final String data = res.getString("data");;
                final int score = res.getInt("score");;
                final int scoreOpponent = res.getInt("Score_opponent");;
                final int home = res.getInt("Home");;

                gameData.add(new Game(id, opponent, competition, data, score, scoreOpponent, home ));
                }






            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return gameData;
    }

    public static ObservableList<GameStat> SelectGameStat(ObservableList<GameStat> gameData, int idOp) {
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            if(idOp == 0) {
                ResultSet res = stm.executeQuery("SELECT * FROM football_club.gamestatinfo");


                while (res.next()) {
                    final int id = res.getInt("id");
                    ;
                    final String name = res.getString("name");
                    ;
                    final String surname = res.getString("surname");
                    ;
                    final int start = res.getInt("Starting");
                    ;
                    final int substitutes = res.getInt("Substitutes");
                    ;
                    final int goal = res.getInt("Goal");
                    ;
                    final int assist = res.getInt("Assist");
                    ;
                    final String opponent = res.getString("Opponent");
                    ;

                    gameData.add(new GameStat(id, name, surname, start, substitutes, goal, assist, opponent));
                }


            }else{
                PreparedStatement pst = conn.prepareStatement("SELECT \n" +
                        "        `s`.`Id` AS `Id`,\n" +
                        "        `p`.`Name` AS `name`,\n" +
                        "        `p`.`Surname` AS `surname`,\n" +
                        "        `s`.`Starting` AS `Starting`,\n" +
                        "        `s`.`Substitutes` AS `Substitutes`,\n" +
                        "        `s`.`Goal` AS `Goal`,\n" +
                        "        `s`.`Assist` AS `Assist`,\n" +
                        "       `Opponent` AS `Opponent`\n" +
                        "    FROM\n" +
                        "        `football_club`.`game` `g`,`football_club`.`player` `p`,`football_club`.`game stat` `s`\n" +
                        "      where `p`.`Id` = (select `s`.`idPlayer` where `s`.`idGame` = ? )  && g.id = ?");
                pst.setInt(1,idOp);
                pst.setInt(2,idOp);
                ResultSet res = pst.executeQuery();


                while (res.next()) {
                    final int id = res.getInt("id");
                    ;
                    final String name = res.getString("name");
                    ;
                    final String surname = res.getString("surname");
                    ;
                    final int start = res.getInt("Starting");
                    ;
                    final int substitutes = res.getInt("Substitutes");
                    ;
                    final int goal = res.getInt("Goal");
                    ;
                    final int assist = res.getInt("Assist");
                    ;
                    final String opponent = res.getString("Opponent");
                    ;

                    gameData.add(new GameStat(id, name, surname, start, substitutes, goal, assist, opponent));
                }
            }



            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return gameData;
    }
}
