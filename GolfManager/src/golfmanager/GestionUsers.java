/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golfmanager;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geoffrey.Candeias
 */
public class GestionUsers {
    private String url;
    private String user;
    private String password;
    private java.sql.Connection dbConnect = null;
    private java.sql.Statement dbStatement = null;
    private int lastID=1;

    public GestionUsers() {
        this.url="jdbc:mysql://localhost:3306/mydb" ;
        this.user="root";
        this.password="43gzh9x69";
    }
    
    public boolean connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.dbConnect = DriverManager.getConnection(this.url, this.user, this.password);
            this.dbStatement = this.dbConnect.createStatement();
            return true;
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(GestionUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ResultSet connexionUser(String login, String pass)
    {
        try 
        {
            ResultSet rs = this.dbStatement.executeQuery("select idusers from users where login="+"\""+login+"\""+ "and password="+"\""+pass+"\"");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean addUser(String login, String pass, boolean admin)
    {
        try {
            lastID++;
            if (admin==false)
                this.dbStatement.executeUpdate("INSERT INTO `mydb`.`users` (`idusers`,`login`, `password`, `admin`) VALUES ("+"\'"+lastID+"\',"+"\""+login+"\""+ "," +"\""+pass+"\""+", '0')");
            else        
                this.dbStatement.executeUpdate("INSERT INTO `mydb`.`users` (`idusers`,`login`, `password`, `admin`) VALUES ("+"\'"+lastID+"\',"+"\""+login+"\""+ "," +"\""+pass+"\""+", '1')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
