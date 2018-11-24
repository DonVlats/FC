/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import POJO.MyAlert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 123
 */
public class DeleteDB {
    private static Connection conn = null;

    public static Integer delete( int Id) throws SQLException {
        int count = 0;
              try {
            
       conn = new ConnectionDB().GetConnectDatabase();

                    conn.setAutoCommit(false);
                  PreparedStatement pst = conn.prepareStatement("(select Number_contract from footballer where id = ?)");
                  pst.setInt(1,Id);
                  int Id_Contract = 0;
                  ResultSet resultSet = pst.executeQuery();
                  if(resultSet.next()){
                      Id_Contract =  Integer.parseInt(resultSet.getString("Number_contract"));
                  }  System.out.println(Id_Contract);
                  String sql = (" DELETE FROM `football_club`.`personal_data`\n" +
                          "WHERE id = (select Personal_data from footballer where id = ?);\n") ;
                  pst = conn.prepareStatement(sql);
                 pst.setInt(1,Id);
                  System.out.println(pst.toString());
                 pst.executeUpdate();

                   sql = (" DELETE FROM `football_club`.`contract_data`\n" +
                          "WHERE Number_contract =  ?;\n") ;
                   pst = conn.prepareStatement(sql);
                  pst.setInt(1,Id_Contract);
                  System.out.println(pst.toString());
                  pst.executeUpdate();
                  if(conn != null){
                      conn.commit();
                     conn.close();
                     pst.close();
                  }
 }

       
 catch (SQLException ex) {
     
                    
 conn.rollback();
     MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);
 System.out.println("SQLException: " + ex.getMessage());
 System.out.println("SQLState: " + ex.getSQLState());
 System.out.println("VendorError: " + ex.getErrorCode());
}
            
    
        return count;
    }

    public static int deleteUser(String id) throws SQLException {
        int count = 0;
        try {

            conn = new ConnectionDB().GetConnectDatabase();

            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("DROP USER ?@'localhost'");
            pst.setString(1,id);

             count = pst.executeUpdate();
            pst.execute("FLUSH PRIVILEGES");
            if(conn != null){
                conn.commit();
                conn.close();
                pst.close();
            }
        }


        catch (SQLException ex) {


            conn.rollback();
            MyAlert.ShowAlertError("SQLException: " + ex.getMessage()+"SQLState: " + ex.getSQLState()+"VendorError: " + ex.getErrorCode(), null);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


        return count;
    }
}
