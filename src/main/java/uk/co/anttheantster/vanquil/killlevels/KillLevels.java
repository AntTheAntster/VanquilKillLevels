package uk.co.anttheantster.vanquil.killlevels;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.vanquil.killlevels.utils.MessagesFile;
import uk.co.anttheantster.vanquil.killlevels.utils.MySQL;
import uk.co.anttheantster.vanquil.killlevels.utils.SQLGetter;

import java.sql.SQLException;

public class KillLevels extends JavaPlugin {

    public MySQL SQL;
    public SQLGetter data;

    public MessagesFile messagesFile;

    @Override
    public void onDisable() {
        SQL.disconnect();
    }

    @Override
    public void onEnable() {
        setup();
    }

    private void setup(){
        saveDefaultConfig();
        registerClasses();
        messagesFile.createMessagesFile();
        messagesFile.save();
        setupSQL();

        registerCommands();
        registerListeners();

    }
    private void registerClasses(){
        messagesFile = new MessagesFile(this);
    }

    private void registerCommands(){

    }

    private void registerListeners(){

    }

    private void setupSQL() {
        this.SQL = new MySQL(this);
        this.data = new SQLGetter(this);

        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if (SQL.isConnected()) {
            Bukkit.getLogger().info("[VKL] Database is connected!");
            data.createTable();
        } else {
            Bukkit.getLogger().info("[VKL] No Database Connected! Please check the details in the Config.yml!");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
}
