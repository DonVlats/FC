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
class SelectDB {
   
    public static void SelectPlayer(ObservableList<Player> personData){
       
              try {
                    Connection conn = new ConnectionDB().GetConnectDatabase();
                    Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                
                ResultSet res = stm.executeQuery("SELECT * FROM football_club.player");

                 System.out.println("\nSelectPlayer\n" );
                while (res.next()) {
                     final int id = res.getInt("id");
                    final String name = res.getString("name");
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
     
 MyAlert.ShowAlertError("SQLException: "+ ex.getMessage() , null);

 
 System.out.println("SQLException: " + ex.getMessage());
 System.out.println("SQLState: " + ex.getSQLState());
 System.out.println("VendorError: " + ex.getErrorCode());
}catch (NullPointerException ex){
                  MyAlert.ShowAlertError("О О О О нема з'єднанння : "+ ex.getMessage()+" O O O O" , null);


              }

    }
    public static void SelectPlayer(ArrayList<Player> personData){

              try {
                    Connection conn = new ConnectionDB().GetConnectDatabase();
                    Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                ResultSet res = stm.executeQuery("SELECT * FROM football_club.player");

                 System.out.println("\nSelectPlayer\n" );
                while (res.next()) {
                     final int id = res.getInt("id");
                    final String name = res.getString("name");
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

 MyAlert.ShowAlertError("SQLException: "+ ex.getMessage(), null);


 System.out.println("SQLException: " + ex.getMessage());
 System.out.println("SQLState: " + ex.getSQLState());
 System.out.println("VendorError: " + ex.getErrorCode());
}
    }

    public static void SelectUser(ObservableList<User> personData) {

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
                 StringBuilder grand = new StringBuilder();
                while (rst.next()) {
                    grand.append(rst.getString("Grants for " + res.getString("USER") + "@localhost"));
                }
                String resultStr = grand.substring(grand.toString().indexOf("G") + 1, grand.toString().indexOf("TO"));

                System.out.println("\nSelectUser\n" + login + grand + resultStr
                );
                personData.add(new User(login, grand.toString()));



            }
            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: "+ ex.getMessage() , null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static String  SelectUser(String loginUser) {
        String role = "";
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            System.out.println("start");




                PreparedStatement pst = conn.prepareStatement("SELECT role FROM football_club.users where login = ? ;");
                pst.setString(1,loginUser );
                ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                role = rst.getString("role");
            }

            System.out.println(role);
        conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: " + ex.getMessage(), null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return role;
    }

    public static void SelectGame(ObservableList<Game> gameData) {
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet res = stm.executeQuery("SELECT * FROM football_club.game ");


            while (res.next()) {
                final int id = res.getInt("id");
                final String opponent = res.getString("opponent");
                final String competition = res.getString("competition");
                final String data = res.getString("data");
                final int score = res.getInt("score");
                final int scoreOpponent = res.getInt("Score_opponent");
                final int home = res.getInt("Home");

                gameData.add(new Game(id, opponent, competition, data, score, scoreOpponent, home ));
                }






            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: "+ ex.getMessage() , null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void SelectGameStat(ObservableList<GameStat> gameData, int idOp) {
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            if(idOp == 0) {
                ResultSet res = stm.executeQuery("SELECT * FROM football_club.gamestatinfo");


                while (res.next()) {
                    final int id = res.getInt("id");
                    final String name = res.getString("name");
                    final String surname = res.getString("surname");
                    final int start = res.getInt("Starting");
                    final int substitutes = res.getInt("Substitutes");
                    final int goal = res.getInt("Goal");
                    final int assist = res.getInt("Assist");
                    final String opponent = res.getString("Opponent");

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
                    final String name = res.getString("name");
                    final String surname = res.getString("surname");
                    final int start = res.getInt("Starting");
                    final int substitutes = res.getInt("Substitutes");
                    final int goal = res.getInt("Goal");
                    final int assist = res.getInt("Assist");
                    final String opponent = res.getString("Opponent");

                    gameData.add(new GameStat(id, name, surname, start, substitutes, goal, assist, opponent));
                }
            }



            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: "+ ex.getMessage() , null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void SelectEmployee(ObservableList<Employee> personData) {
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM football_club.employeeinfo;");
                            ResultSet res = pst.executeQuery();


                while (res.next()) {
                    final int id = res.getInt("id");
                    final String name = res.getString("name");
                    final String surname = res.getString("surname");
                    final String bday = res.getString("Date of signing");
                    final String nat = res.getString("Nationality");
                    final String dataSign = res.getString("Date of signing");
                    final String dataEnd = res.getString("Completion date");
                    final String post = res.getString("Position");
                    final int salary = res.getInt("Salary");
                    final int phone = res.getInt("Phone");

                    personData.add(new Employee(id, name, surname, bday, nat, dataSign,dataEnd, salary,phone, post));



                }




            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: "+ ex.getMessage() , null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    public static void SelectEmployeeForAccountant(ObservableList<Employee> personData) {
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM football_club.employeeinfo;");
                            ResultSet res = pst.executeQuery();


                while (res.next()) {

                    final int id = res.getInt("id");
                    final String name = res.getString("name");
                    final String surname = res.getString("surname");
                    final String bday = res.getString("Date of signing");
                    final String nat = res.getString("Nationality");
                    final String dataSign = res.getString("Date of signing");
                    final String dataEnd = res.getString("Completion date");
                    final String post = res.getString("Position");
                    final int salary = res.getInt("Salary");
                    final int phone = res.getInt("Phone");

                    personData.add(new Employee(id, name, surname, bday, nat, dataSign,dataEnd, salary,phone, post));
    }
            res = stm.executeQuery("SELECT * FROM football_club.player");
            while (res.next()) {
                if(!(res.getString("Date of signing")).equals( "0")){
                final int id = res.getInt("id");
                final String name = res.getString("name");
                final String surname = res.getString("surname");
                final String bday = res.getString("Date of signing");
                final String nat = res.getString("Nationality");
                final String dataSign = res.getString("Date of signing");
                final String dataEnd = res.getString("Completion date");
                final String post = "Футболіст";
                final int salary = res.getInt("Salary");
                final int phone = res.getInt("Phone");

                personData.add(new Employee(id, name, surname, bday, nat, dataSign,dataEnd, salary,phone, post));}
            }


            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: "+ ex.getMessage() , null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void SelectPlayerStat(ObservableList<GameStat> gameData, int idPlayer) {
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            if(idPlayer == 0) {
                ResultSet res = stm.executeQuery("call football_club.getPlayersStat()");


                while (res.next()) {
                    final int id = res.getInt("id");
                    final String name = res.getString("name");
                    final String surname = res.getString("surname");
                    final int start = res.getInt("Appearances");
                    final int substitutes = 0;
                    final int goal = res.getInt("Goals");
                    final int assist = res.getInt("Assists");
                    final String opponent = res.getString("Appearances");

                    gameData.add(new GameStat(id, name, surname, start, substitutes, goal, assist, opponent));
                }


            }else{
                PreparedStatement pst = conn.prepareStatement("call football_club.getPlayerStat(?);\n");
                pst.setInt(1,idPlayer);
      ;
                ResultSet res = pst.executeQuery();


                while (res.next()) {
                    final int id = res.getInt("id");
                    final String name = res.getString("name");
                    final String surname = res.getString("surname");
                    final int start = res.getInt("Appearances");
                    final int substitutes = 0;
                    final int goal = res.getInt("Goals");
                    final int assist = res.getInt("Assists");
                    final String opponent = res.getString("Appearances");


                    gameData.add(new GameStat(id, name, surname, start, substitutes, goal, assist, opponent));
                }
            }



            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: "+ ex.getMessage() , null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void SelectPlayerInfoStat(ObservableList<GameStat> gameData, int idPlayer) {
        try {
            Connection conn = new ConnectionDB().GetConnectDatabase();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            if(idPlayer == 0) {
                ResultSet res = stm.executeQuery("SELECT * FROM football_club.gamestatinfo ;");


                while (res.next()) {
                    final int id = res.getInt("id");
                    final String name = res.getString("name");
                    final String surname = res.getString("surname");
                    final int start = res.getInt("Appearances");
                    final int substitutes = 0;
                    final int goal = res.getInt("Goals");
                    final int assist = res.getInt("Assists");
                    final String opponent = res.getString("Appearances");

                    gameData.add(new GameStat(id, name, surname, start, substitutes, goal, assist, opponent));
                }


            }else{
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM football_club.gamestatinfo where id = ?;\n");
                pst.setInt(1,idPlayer);
                ;
                ResultSet res = pst.executeQuery();


                while (res.next()) {
                    final int id = res.getInt("id");
                    final String name = res.getString("name");
                    final String surname = res.getString("surname");
                    final int start = res.getInt("Starting");
                    final int substitutes = res.getInt("Substitutes");
                    final int goal = res.getInt("Goal");
                    final int assist = res.getInt("Assist");
                    final String opponent = res.getString("Opponent");

                    gameData.add(new GameStat(id, name, surname, start, substitutes, goal, assist, opponent));
                }
            }



            conn.close();
            stm.close();
        }
        catch (SQLException ex) {

            MyAlert.ShowAlertError("SQLException: " + ex.getMessage() , null);


            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
