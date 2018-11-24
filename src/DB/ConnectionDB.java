/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;


import POJO.MyAlert;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author 123
 */
public  class ConnectionDB {
    Connection  conn;
   
   static String username = "root";
static String password = "1234";
public void SetUser(String userName, String passwordUser){
    username = userName;
    password = passwordUser;
}
    public  Connection GetConnectDatabase() throws SQLException {
         
        String url =("jdbc:mysql://localhost/football_club?verifyServerCertificate=false&useSSL=false&requireSSL=false" +
                "&useLegacyDatetimeCode=false&amp&serverTimezone=UTC&allowPublicKeyRetrieval=true");
       // try {
      //      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      //  } catch (ClassNotFoundException e) {
         //   System.out.println("Driver not found.");
        //    System.exit(-1);

       // }
        
        try{
        conn = DriverManager.getConnection(url,username,password );
        } catch (SQLException ex) {
     

 MyAlert.ShowAlertError("Не коректні дані про користувача", null);
 System.out.println("SQLException: " + ex.getMessage());
 System.out.println("SQLState: " + ex.getSQLState());
 System.out.println("VendorError: " + ex.getErrorCode());
}catch(Exception e){
            MyAlert.ShowAlertError("Не коректні дані про користувача", null);
               System.out.println("not connect");
               System.exit(-1);
               
        }
        
                 System.out.println("Database created by path " + url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Driver name: " + meta.getDriverName());
                System.out.println("Database created by path " + url);
  
            }
            else{
                 System.out.println("pzdc " + url);
               // MyAlert.ShowAlertError("Не коректні дані про користувача", null);
            }
       //    try {
 // Створюємо об’єкт Statement
 //Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
 //ResultSet.CONCUR_READ_ONLY);
 // виконуємо запит до сервера

 //stm.execute("DELETE FROM `lb9`.`movie` WHERE (`Id` = '11119');");
// stm.executeUpdate ("INSERT INTO `lb9`.`movie` (`Id`, `Title`, `year`, `director`) VALUES ("+ id +","+title+ ","+year+","+director+");");
 // видаляємо об’єкт Statement
 //UPDATE `lb9`.`movie` SET `Title` = '3', `director` = '43' WHERE (`Id` = '1');
  //stm.executeUpdate ("UPDATE `lb9`.`movie` SET `director` = 'им88т' WHERE (`Id` = '1111');");
 // видаляємо об’єкт Statement
 //stm.close();
 //stm.close();
// conn.close();
//} catch (SQLException ex) {  
 // виводимо інформацію про виключну ситуацію
 //System.out.println("SQLException: " + ex.getMessage());
 //System.out.println("SQLState: " + ex.getSQLState());
 //System.out.println("VendorError: " + ex.getErrorCode());
            return conn;
} 
       public Connection getConn(){
           return conn;
       }

    public  boolean TestConnectDatabase() throws SQLException {
        boolean OK = false;
        String url =("jdbc:mysql://localhost/football_club?verifyServerCertificate=false&useSSL=false&requireSSL=false" +
                "&useLegacyDatetimeCode=false&amp&serverTimezone=UTC&allowPublicKeyRetrieval=true");


        try{
            conn = DriverManager.getConnection(url,username,password );
            OK = true;
        } catch (SQLException ex) {

            OK = false;
            MyAlert.ShowAlertError("Не коректні дані про користувача", null);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){
            MyAlert.ShowAlertError("Не коректні дані про користувача", null);
            System.out.println("not connect");
            System.exit(-1);
            OK = false;
        }

        System.out.println("Database created by path " + url);
        if (conn != null) {
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("Driver name: " + meta.getDriverName());
            System.out.println("Database created by path " + url);

        }
        else{

        }
        if(OK)  conn.close();
        return OK;
    }


}
