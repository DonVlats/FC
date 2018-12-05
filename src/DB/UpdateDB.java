/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import POJO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 123
 */
class UpdateDB {

    private static Connection conn = null;

    public static Integer update(Player player) throws SQLException {
        int count = 0;
              try {

                  conn = new ConnectionDB().GetConnectDatabase();
                  conn.setAutoCommit(false);


                  String sql = ("UPDATE `football_club`.`personal_data`\n" +
                          "SET\n" +
                          "`Name` = ?,\n" +
                          "`Surname` = ?,\n" +
                          "`Nationality` = ?,\n" +
                          "`Phone_number` =?,\n" +
                          "`Date_of_birth` = ?\n" +
                          "WHERE `id` = (select Personal_data from footballer where id = ?);\n" ) ;
                  PreparedStatement pst = conn.prepareStatement(sql);
                  pst.setString(1, player.getSTName().getValue());
                  pst.setString(2, player.getSurname());
                  pst.setString(3, player.getNationality());
                  pst.setInt(4, player.getPhone());
                  pst.setString(5, player.getBday());
                  pst.setInt(6, player.getId());
                  System.out.println(pst.toString());
                  pst.executeUpdate();

                  sql = ("UPDATE `football_club`.`contract_data`\n" +
                          "SET\n" +
                          "\n" +
                          "`Date_of_signing` = ?,\n" +
                          "`Completion_date` = ?,\n" +
                          "`Salary` =?\n" +
                          "WHERE `Number_contract` = (select Number_contract from footballer where id = ?);" ) ;
                  pst = conn.prepareStatement(sql);
                  pst.setString(1, player.getDataSign());
                  pst.setString(2, player.getDataEnd());
                  pst.setInt(3, player.getSalary());
                  pst.setInt(4, player.getId());

                  System.out.println(pst.toString());
                  pst.executeUpdate();






                  sql = ("UPDATE `football_club`.`footballer`\n" +
                          "SET\n" +
                          "`Price` = ?\n" +
                          "WHERE `id` = ?;\n" ) ;
                  pst = conn.prepareStatement(sql);
                  pst.setInt(1, player.getPrice());
                  pst.setInt(2, player.getId());


                  System.out.println(pst.toString());
                  count =  pst.executeUpdate();



                  pst.close();
              }

              catch (SQLException ex) {
                  if(conn != null)
                      conn.rollback();
                  if(ex.getErrorCode() == 1062){
                      MyAlert.ShowAlertError("Дані не вставлено, номер " +  player.getPhone() + " - вже існує\n", null);
                  }
                  else if(ex.getErrorCode() == 1064)
                      MyAlert.ShowAlertError("Дані не вставлено, оскільки вони некоректні\n" + ex.getMessage(), null);
                  else
                      MyAlert.ShowAlertError("SQLException: " , null);

                  System.out.println("SQLException: " + ex.getMessage() + ex.getMessage());
                  System.out.println("SQLState: " + ex.getSQLState());
                  System.out.println("VendorError: " + ex.getErrorCode());

              }finally {
                  if(conn != null){
                      conn.commit();
                      conn.close();}

              }


      return count;
  }

    public static int updateUser(String oldLogin, String login, String passsword) throws SQLException {
        int count = 0;
        try {

            conn = new ConnectionDB().GetConnectDatabase();



            String sql = ("alter USER ?@'localhost' IDENTIFIED BY ?");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(2, passsword);
            pst.setString(1, oldLogin);
            System.out.println(pst.toString());
            pst.executeUpdate();

             pst = conn.prepareStatement("SHOW GRANTS FOR ?@localhost");
            pst.setString(1, oldLogin);
            ResultSet rst = pst.executeQuery();
            StringBuilder grand = new StringBuilder();
            do {
                rst.next();
                rst.next();
                grand.append(rst.getString("Grants for " + oldLogin + "@localhost"));
            }
            while (rst.next());

             sql = ("UPDATE mysql.user SET user=? WHERE user=?;" ) ;
            pst = conn.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, oldLogin);

            System.out.println(pst.toString());
            count =  pst.executeUpdate();
            sql = (grand.toString());
            pst = conn.prepareStatement(sql);
           // pst.setString(1, grand);
            //pst.setString(2, oldLogin);

            System.out.println(pst.toString());
            pst.executeUpdate();
            pst.execute("FLUSH PRIVILEGES");



            if(conn != null)
                conn.close();
            pst.close();
        }

        catch (SQLException ex) {


             if(ex.getErrorCode() == 1064)
                MyAlert.ShowAlertError("Дані не вставлено, оскільки вони некоректні\n" + ex.getMessage(), null);
            else
                MyAlert.ShowAlertError("SQLException: " + ex.getMessage(), null);

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }finally {
            if(conn != null){

                conn.close();}

        }


        return count;
    }

    public static int updateGame(Game game) throws SQLException {
        int count = 0;
        try {

            conn = new ConnectionDB().GetConnectDatabase();

            String sql = ("UPDATE `football_club`.`game`\n" +
                    "SET\n" +
                    "`Opponent` = ?,\n" +
                    "`Competition` = ?,\n" +
                    "`Data` = ?,\n" +
                    "`Score` = ?,\n" +
                    "`Score_opponent` = ?,\n" +
                    "`Home` = ?\n" +
                    "WHERE `id` = ?;\n" ) ;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, game.getOpponent());
            pst.setString(2, game.getCompetition());
            pst.setString(3, game.getData());
            pst.setInt(4,game.getScore());
            pst.setInt(5,game.getScoreOpponent());
            pst.setInt(6,game.getHome());
            pst.setInt(7,game.getId());
            System.out.println(pst.toString());
            count = pst.executeUpdate();




            if(conn != null)
                conn.close();
            pst.close();
        }

        catch (SQLException ex) {


            if(ex.getErrorCode() == 1064)
                MyAlert.ShowAlertError("Дані не вставлено, оскільки вони некоректні\n" + ex.getMessage(), null);
            else
                MyAlert.ShowAlertError("SQLException: " + ex.getMessage(), null);

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }finally {
            if(conn != null){

                conn.close();}

        }


        return count;
    }

    public static int updateGameStat(GameStat gameStat) throws SQLException {
        int count = 0;
        try {

            conn = new ConnectionDB().GetConnectDatabase();

            String sql = ("UPDATE `football_club`.`game stat`\n" +
                    "SET\n" +
                    "`idGame` = ? ,\n" +
                    "`idPlayer` = ? ,\n" +
                    "`Starting` =? ,\n" +
                    "`Substitutes` =? ,\n" +
                    "`Goal` =? ,\n" +
                    "`Assist` = ? \n" +
                    "WHERE `id` = ? ;" ) ;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(gameStat.getOpponent()));
            pst.setInt(2, Integer.parseInt(gameStat.getName()));
            pst.setInt(3, gameStat.getStart());
            pst.setInt(4, gameStat.getSubstitutes());
            pst.setInt(5, gameStat.getGoal());
            pst.setInt(6, gameStat.getAssist());
            pst.setInt(7,gameStat.getId());
            System.out.println(pst.toString());
            count =  pst.executeUpdate();




            if(conn != null)
                conn.close();
            pst.close();
        }

        catch (SQLException ex) {


            if(ex.getErrorCode() == 1064)
                MyAlert.ShowAlertError("Дані не вставлено, оскільки вони некоректні\n" + ex.getMessage(), null);
            else
                MyAlert.ShowAlertError("SQLException: " + ex.getMessage() , null);

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }finally {
            if(conn != null){

                conn.close();}

        }


        return count;
    }

    public static int updateEmployee(Employee employee) throws SQLException {
        int count = 0;
        try {

            conn = new ConnectionDB().GetConnectDatabase();
            conn.setAutoCommit(false);


            String sql = ("UPDATE `football_club`.`personal_data`\n" +
                    "SET\n" +
                    "`Name` = ?,\n" +
                    "`Surname` = ?,\n" +
                    "`Nationality` = ?,\n" +
                    "`Phone_number` =?,\n" +
                    "`Date_of_birth` = ?\n" +
                    "WHERE `id` = (select Personal_data from employee where id = ?);\n" ) ;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, employee.getSTName().getValue());
            pst.setString(2, employee.getSurname());
            pst.setString(3, employee.getNationality());
            pst.setInt(4, employee.getPhone());
            pst.setString(5, employee.getBday());
            pst.setInt(6, employee.getId());
            System.out.println(pst.toString());
            count =  pst.executeUpdate();

            sql = ("UPDATE `football_club`.`contract_data`\n" +
                    "SET\n" +
                    "\n" +
                    "`Date_of_signing` = ?,\n" +
                    "`Completion_date` = ?,\n" +
                    "`Salary` =?\n" +
                    "WHERE `Number_contract` = (select Number_contract from employee where id = ?);" ) ;
            pst = conn.prepareStatement(sql);
            pst.setString(1, employee.getDataSign());
            pst.setString(2, employee.getDataEnd());
            pst.setInt(3, employee.getSalary());
            pst.setInt(4, employee.getId());

            System.out.println(pst.toString());
            count = pst.executeUpdate();






            sql = ("UPDATE `football_club`.`employee`\n" +
                    "SET\n" +
                    "`Position` = ?\n" +
                    "WHERE `id` = ?;\n" ) ;
            pst = conn.prepareStatement(sql);
            pst.setString(1, employee.getPost());
            pst.setInt(2, employee.getId());


            System.out.println(pst.toString());
            count =  pst.executeUpdate();



            pst.close();
        }

        catch (SQLException ex) {
            if(conn != null)
                conn.rollback();
            if(ex.getErrorCode() == 1062){
                MyAlert.ShowAlertError("Дані не вставлено, номер " +  employee.getPhone() + " - вже існує\n", null);
            }
            else if(ex.getErrorCode() == 1064)
                MyAlert.ShowAlertError("Дані не вставлено, оскільки вони некоректні\n" + ex.getMessage(), null);
            else
                MyAlert.ShowAlertError("SQLException: "  + ex.getMessage(), null);

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }finally {
            if(conn != null){
                conn.commit();
                conn.close();}

        }


        return count;
    }
}