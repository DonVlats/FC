/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import POJO.MyAlert;
import POJO.Player;

import java.sql.*;

/**
 *
 * @author 123
 */
public class InsertDB {
    private static Connection conn = null;

    public static Integer insert(Player player) throws SQLException {
        int count = 0;
              try {
            
       conn = new ConnectionDB().GetConnectDatabase();
        conn.setAutoCommit(false);


                 String sql = ("INSERT INTO `football_club`.`personal_data`\n" +
                         "(`Name`,\n" +
                         "`Surname`,\n" +
                         "`Nationality`,\n" +
                         "`Phone_number`,\n" +
                         "`Date_of_birth`)\n" +
                         "VALUES(\n" +
                         "?,\n" +
                         "?,\n" +
                         "?,\n" +
                         "?,\n" +
                         "?);\n" ) ;
                 PreparedStatement pst = conn.prepareStatement(sql);
                 pst.setString(1, player.getSTName().getValue());
                 pst.setString(2, player.getSurname());
                 pst.setString(3, player.getNationality());
                 pst.setInt(4, player.getPhone());
                 pst.setString(5, player.getBday());
                  System.out.println(pst.toString());
                 pst.executeUpdate();
                  int idPersonalData = 0;
                  ResultSet resultSet = pst.executeQuery("select last_insert_id() as last_id from football_club.personal_data");
                  if(resultSet.next()){
                      idPersonalData =  Integer.parseInt(resultSet.getString("last_id"));
                  }
                   sql = ("INSERT INTO `football_club`.`contract_data`\n" +
                          "(`Date_of_signing`,\n" +
                          "`Completion_date`,\n" +
                          "`Salary`)\n" +
                          "VALUES(\n" +
                          "?,\n" +
                          "?,\n" +
                          "?);\n" ) ;
                   pst = conn.prepareStatement(sql);
                  pst.setString(1, player.getDataSign());
                  pst.setString(2, player.getDataEnd());
                  pst.setInt(3, player.getSalary());

                  System.out.println(pst.toString());
                  pst.executeUpdate();


                  int idContractData = 0 ;
                  resultSet = pst.executeQuery("select last_insert_id() as last_id from football_club.contract_data");
                  if(resultSet.next()){
                      idContractData =  Integer.parseInt(resultSet.getString("last_id"));
                  }

                 // if(conn != null){
                 //     conn.commit();
                //    }
                  sql = ("INSERT INTO `football_club`.`footballer`\n" +
                          "(`Personal_data`,\n" +
                          "`Price`,\n" +
                          "`Number_contract`)\n" +

                          "VALUES(\n" +
                          "?,\n" +
                          "?,\n" +
                          "?);\n" ) ;
                  pst = conn.prepareStatement(sql);
                  pst.setInt(1, idPersonalData);
                  pst.setInt(2, player.getPrice());
                  pst.setInt(3, idContractData);

                  System.out.println(pst.toString());
                  pst.executeUpdate();
                  int Id_subscriber = 0;
                   resultSet = pst.executeQuery("select last_insert_id() as last_id from football_club.personal_data");
                  if(resultSet.next()){
                      Id_subscriber =  Integer.parseInt(resultSet.getString("last_id"));
                  }

                  sql = ("UPDATE `football_club`.`contract_data`\n" +
                          "SET\n" +

                          "`Id_subscriber` = ?\n" +
                          "WHERE `Number_contract` = ?;" ) ;
                  pst = conn.prepareStatement(sql);

                  pst.setInt(1, Id_subscriber);
                  pst.setInt(2, idContractData);

                  System.out.println(pst.toString());
                  pst.executeUpdate();
                  if(conn != null){
                 conn.commit();
                 conn.close();}

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
 MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);

 System.out.println("SQLException: " + ex.getMessage());
 System.out.println("SQLState: " + ex.getSQLState());
 System.out.println("VendorError: " + ex.getErrorCode());

}


        return count;
    }

    public static int insertUser(String login, String grand,String password) throws SQLException {
        int count = 0;
        try {

            conn = new ConnectionDB().GetConnectDatabase();
            conn.setAutoCommit(false);
            String sql = ("CREATE USER ?@'localhost' IDENTIFIED BY ?;") ;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, password);

            System.out.println(pst.toString());
            pst.executeUpdate();

             sql = (grand) ;
             pst = conn.prepareStatement(sql);
            pst.setString(1, login);


            System.out.println(pst.toString());
            pst.executeUpdate();

            if(conn != null){
                conn.commit();
                conn.close();}

        }

        catch (SQLException ex) {
            if(conn != null)
                conn.rollback();

            else if(ex.getErrorCode() == 1064)
                MyAlert.ShowAlertError("Дані не вставлено, оскільки вони некоректні\n" + ex.getMessage(), null);
            else
                MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }


        return count;
    }
    }

