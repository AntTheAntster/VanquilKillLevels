package uk.co.anttheantster.vanquil.killlevels.utils;

import org.bukkit.configuration.file.FileConfiguration;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private final KillLevels plugin;
    public MySQL (KillLevels plugin){
        this.plugin = plugin;
    }

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            FileConfiguration config  = plugin.getConfig();

            String host = config.getString("MySQL.Host");
            String port = config.getString("MySQL.Port");
            String database = config.getString("MySQL.Database");
            String username = config.getString("MySQL.Username");
            String password = config.getString("MySQL.Password");

            connection = DriverManager.getConnection("jdbc:mysql://" +
                            host + ":" + port + "/" + database + "?useSSL=false",
                    username, password);
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
