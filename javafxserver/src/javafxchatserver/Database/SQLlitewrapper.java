/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver.Database;

import java.sql.*;

/**
 *
 * @author julien
 */
public class SQLlitewrapper {
    private Connection sqlite= null;
    private String database;
    
    public SQLlitewrapper(String database) throws ClassNotFoundException, SQLException{
        this.database =database;
      
         Class.forName("org.sqlite.JDBC");
         sqlite = DriverManager.getConnection("jdbc:sqlite:" + database);
      
    }

    private void sql(String sql){
      // Statement statement= sqlite.createStatement();
        try {
            PreparedStatement preparedStatement =sqlite.prepareStatement(sql);

       //     preparedStatement.


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    
    
    
}
