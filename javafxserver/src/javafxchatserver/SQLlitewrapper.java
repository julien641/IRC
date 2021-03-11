/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    
    
}
