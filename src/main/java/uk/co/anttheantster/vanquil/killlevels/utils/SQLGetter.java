package uk.co.anttheantster.vanquil.killlevels.utils;

import org.bukkit.entity.Player;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLGetter {
    private KillLevels plugin;
    public SQLGetter (KillLevels plugin){
        this.plugin = plugin;
    }

    public void createTable() {
        PreparedStatement ps;

        //Everything must be surrounded in Try/Catch statements in SQL Connections... I HATE MySQL.
        try {
            //Create the "vklplayers" table in the Database if it doesn't exist
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS vklplayers "
                    //Table will store the players UUID, IGN, EXP, Level and Kills.
                    + "(UUID VARCHAR(100),NAME VARCHAR(100),EXP VARCHAR(100),EXPREQ VARCHAR(100),KILLS VARCHAR(100),LEVEL VARCHAR(100), PRIMARY KEY (UUID))");
            //Similar to "#saveConfig()" SQL classes have to "#executeUpdate()" after each modification.
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();

            //If the UUID doesn't exist, create the player in the database.
            if (!exists(uuid)){
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT vklplayers"
                        + " (UUID,NAME) VALUES (?,?)");
                ps2.setString(1, uuid.toString());
                ps2.setString(2, player.getName());
                ps2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM vklplayers WHERE UUID=?");
            ps.setString(1, uuid.toString());

            ResultSet results = ps.executeQuery();
            if (results.next()) {
                //"results.next()" meants player UUID is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setEXP(int exp, Player player){
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE vklplayers SET EXP=? WHERE UUID=?");
            ps.setString(1, Integer.toString(exp));
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getEXP(Player player) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT EXP FROM vklplayers WHERE UUID=?");
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String time = rs.getString("EXP");
                return time;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setLevel(int level, Player player){
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE vklplayers SET LEVEL=? WHERE UUID=?");
            ps.setString(1, Integer.toString(level));
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getLevel(Player player) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT LEVEL FROM vklplayers WHERE UUID=?");
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String time = rs.getString("LEVEL");
                return time;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setKills(int kills, Player player){
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE vklplayers SET KILLS=? WHERE UUID=?");
            ps.setString(1, Integer.toString(kills));
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getKills(Player player) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT KILLS FROM vklplayers WHERE UUID=?");
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String time = rs.getString("KILLS");
                return time;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setExpReq(int expReq, Player player){
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE vklplayers SET EXPREQ=? WHERE UUID=?");
            ps.setString(1, Integer.toString(expReq));
            ps.setString(2, player.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getExpReq(Player player) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT EXPREQ FROM vklplayers WHERE UUID=?");
            ps.setString(1, player.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String time = rs.getString("EXPREQ");
                return time;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
