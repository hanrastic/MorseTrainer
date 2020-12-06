/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
package morsetrainer.dao;
import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joonas
 */

public class DBConnector {
         public static Connection myConn = null;
         public static String sqliteServer = "jdbc:sqlite:";
         public static String resetPath = "";
         
         
    public static boolean isDatabaseExists(String dbFilePath) {
        File dbFile = new File(dbFilePath);
        
        return dbFile.exists();
    }
    
    
    public static Connection getConnection(){
        sqliteServer = "jdbc:sqlite";
        String getFilePath = new File ("").getAbsolutePath();
        String fileAbsolutePath = getFilePath.concat("\\src\\morsetrainer\\dao\\database.db");
        
        if(isDatabaseExists(fileAbsolutePath)) {
            try {
                myConn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                System.out.println("Connection to SQLite has been established");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }else{
            createNewDatabase("dao", "database");
                try {
                myConn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                System.out.println("Connection to SQLite has been established");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return myConn;
    }

    private static void createNewDatabase(String fileSubFolder, String fileName) {
       String getFilePath = new File("").getAbsolutePath();
       String fileAbsolutePath = "";
       
       if (fileSubFolder.isEmpty()) {
           fileAbsolutePath = getFilePath.concat("\\src\\morsetrainer\\" + fileName + ".db");
       }else {
           fileAbsolutePath = getFilePath.concat("\\src\\morsetrainer\\" + fileSubFolder+ "\\" + fileName + ".db");
       }
       
       Connection conn;
             try {
                 conn = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                if(conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                            try{
                                Statement statement = conn.createStatement();
                                statement.executeQuery(
                                        "CREATE TABLE users (user_id INTEGER PRIMARY KEY NOT NULL,"
                                        + "username TEXT NOT NULL UNIQUE,"
                                        + "password TEXT NOT NULL,"
                                        + "highscore INTEGER)");
                            }catch(SQLException e){
                                
                            }
                }
             } catch (SQLException ex) {
                 Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
             }

    }
}

