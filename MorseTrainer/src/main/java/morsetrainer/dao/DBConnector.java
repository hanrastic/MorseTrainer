        
package morsetrainer.dao;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class contains functionality for database connection and creating database
 * 
 * @author joonas
 */

public class DBConnector {
    public static Connection myConn = null;
    public static String sqliteServer = "jdbc:sqlite:";
    public static String resetPath = "";
         
    /**
    * Method for checking if database exits
    *
    * @param   dbFilePath path to embedded database file
    * 
    * @return true/false according to if database exist
    */      
    public static boolean isDatabaseExists(String dbFilePath) {
        File dbFile = new File(dbFilePath);
        
        return dbFile.exists();
    }
    
    /**
    * Method for connecting to database
    * method creates new embedded database if one does not exist
    * 
    */ 
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        sqliteServer = "jdbc:sqlite:";
        String getFilePath = new File("").getAbsolutePath();
        String fileAbsolutePath = getFilePath.concat("\\src\\main\\java\\morsetrainer\\dao\\database.db");
        
        if (isDatabaseExists(fileAbsolutePath)) {
            try {
                
                myConn = DriverManager.getConnection(sqliteServer + fileAbsolutePath);
                System.out.println("Connection to SQLite has been established");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }            
        } else {
            createNewDatabase("database");
            try {
                myConn = DriverManager.getConnection(sqliteServer + fileAbsolutePath);
                System.out.println("Connection to SQLite has been established");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return myConn;
    }
    
    
    /**
    * Method for creating new embedded database
    * Contains SQL command for creating new file
    *
    * @param   fileName preferred file name
    */ 
    private static void createNewDatabase(String fileName) {
        String getFilePath = new File("").getAbsolutePath();
        String fileAbsolutePath = getFilePath.concat("\\src\\main\\java\\morsetrainer\\dao\\" + fileName + ".db");
        Connection conn;
        try {
            conn = DriverManager.getConnection(sqliteServer + fileAbsolutePath);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                try {
                    Statement statement = conn.createStatement();
                    statement.executeQuery(
                            "CREATE TABLE users (username TEXT PRIMARY KEY NOT NULL UNIQUE,"
                            + "password TEXT NOT NULL,"
                            + "highscore INTEGER)");
                } catch (SQLException e) {

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

