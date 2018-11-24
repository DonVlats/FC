/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;

import POJO.MyAlert;
import POJO.Player;
import POJO.User;
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
}
