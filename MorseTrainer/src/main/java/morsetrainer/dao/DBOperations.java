/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joonas
 */
public class DBOperations {
    
    public static void insertData(int user_id, String username, String password, int highscore){
        String sqlQuery = "INSERT INTO users(user_id, username, password, highscore) VALUES (?,?,?,?)";

        try {
            Connection conn = DBConnector.getConnection();
            PreparedStatement preparedStatement;            
            preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, highscore);
            preparedStatement.executeUpdate();
            System.out.println("Data has been inserted!");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }   
        
}
