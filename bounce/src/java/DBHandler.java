
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Radwa Manssour
 */
public class DBHandler {

    private Connection con;

    DBHandler() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bounce", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from user order by score desc");
            System.out.println("yyy");
            while (rs.next()) {
                Player p = new Player(rs.getString("user_name"), null, rs.getInt("score"), rs.getString("image"));
                System.out.println(rs.getString("user_name"));
                players.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return players;
    }

    boolean checkUser(String userName, String pass) {
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from user where user_name like '" + userName + "' and pass like '" + pass + "'");
            if (rs.first()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    Player getPlayerInfo(String userName) {
        Player player = null;
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from user where user_name like '" + userName + "'");
            if (rs.first()) {
                player = new Player(rs.getString("user_name"), rs.getString("pass"), rs.getInt("score"), rs.getString("image"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player;
    }
    boolean updatePlayerInfo(String userName,String name, String score)
    {
         String query ="\"update user set score= '100' , name='shimaa' where userName='" + userName + "'";
         try
         {
        ResultSet rs= con.createStatement().executeQuery(query);
        return true;
         }
         
         catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }
}
