/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joonas
 */
public class DBOperations {
    Connection connection;
    public DBOperations() {
        connection = DBConnector.getConnection();
            if(connection == null) {
                 System.out.println("Connection to database unsuccessful.");
                 //System.exit(1);
            }
    }
    
    public void insertData(String username, String password) {
        PreparedStatement preparedStatement = null;
        String sqlQuery = "INSERT INTO users(username, password) VALUES (?,?)";

        try {
            //Connection connection = DBConnector.getConnection();
                       
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("Data has been inserted!");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
    
//    public boolean addAccount(String user, String pwd) throws SQLException {
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        String sql = "insert into users (username, password) values (?, ?)";
//        try {
//            Connection conn = DBConnector.getConnection();
//            preparedStatement = conn.prepareStatement(sql);
//            preparedStatement.setString(1, user);
//            preparedStatement.setString(2, pwd);
//           // resultSet = 
//            int rowCount = preparedStatement.executeUpdate();
//            return rowCount != 0;          
//        } catch (SQLException e) {
//            return false;
//        } finally {
//            if(preparedStatement != null) preparedStatement.close();
//            if(resultSet != null) resultSet.close();
//        }   
//    }
    //Create method for updating highscore for user
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
    
    //Create method for returning user highscore
    public int getUserHighscoreFromDB(String username) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT highscore "
                + "FROM users "
                + "WHERE username = ?";
        int resultFromDB;
        
        try { 
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            resultFromDB = resultSet.getInt("highscore");
            System.out.println("Returns " + resultFromDB + " from database");
            return resultFromDB;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 9999;
    }
        
}
