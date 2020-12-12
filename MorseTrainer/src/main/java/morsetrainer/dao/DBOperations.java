
package morsetrainer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class contains functionality for database functionality
 * 
 * @author joonas
 */

public class DBOperations {
    Connection connection;
    
    public DBOperations() {
        connection = DBConnector.getConnection();
        if (connection == null) {
            System.out.println("Connection to database unsuccessful.");
            //System.exit(1);
        }
    }
    
    /**
    * Method for inserting data to database
    * Contains SQL commands for accessing database
    *
    * @param   username
    * @param   password
    * 
    * @return true if insert is okay
    */ 
    public boolean insertData(String username, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO users(username, password) VALUES (?,?)";
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int rowCount = preparedStatement.executeUpdate();
            System.out.println("Data has been inserted!");
            return rowCount != 0; 
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }   
    }
    
    /**
    * Method for validating log in, checking that username matches password
    *
    * @param   username   
    * @param   password    
    */ 
    public boolean validateLogIn(String username, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * "
                + "FROM users "
                + "WHERE username=? AND password=?";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Log in Ok in DBOperations");
                return true;
            } else {
                return false;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    /**
    * Method for checking if user already exist
    *
    * @param   user
    * @return true if user already exist
    */ 
    public boolean isUser(String user) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select rowid, * from users where username = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();    
        } catch (SQLException e) {
            return false;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }   
    }

    /**
    * Method for updating high score to database
    * Contains SQL command for accessing database
    *
    * @param   username  
    * @param   newHighScore    
    */ 
    public void updateUserHighscore(String username, int newHighScore) {
        PreparedStatement preparedStatement = null;
        String sqlQuery = "UPDATE users "
                + "SET highscore = ? " 
                + "WHERE username = ?";
        try {        
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, newHighScore);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            System.out.println(username + "'s highscore has been updated to " + newHighScore);            
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    /**
    * Method for getting users high score
    * Contains SQL command for accessing database
    *
    * @param    username
    * @return  int returns users high score from database
    */ 
    public int getUserHighscoreFromDB(String username) {
        Statement stmt;
        ResultSet resultSet;
        String sqlQuery;
        int resultFromDB = 0;
    try { 
        stmt = connection.createStatement();
        sqlQuery = "SELECT highscore "
            + "FROM users "
            + "WHERE username ='" + username + "';";
        resultSet = stmt.executeQuery(sqlQuery);

        while(resultSet.next()) {
            resultFromDB = resultSet.getInt("highscore");
        }           
    } catch (SQLException ex) {
        Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
    } 
        return resultFromDB;
    }
        
}
