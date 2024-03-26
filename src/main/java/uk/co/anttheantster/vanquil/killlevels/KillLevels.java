package uk.co.anttheantster.vanquil.killlevels;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.vanquil.killlevels.commands.CommandController;
import uk.co.anttheantster.vanquil.killlevels.commands.ShowEXP;
import uk.co.anttheantster.vanquil.killlevels.listeners.PlayerJoinSQL;
import uk.co.anttheantster.vanquil.killlevels.utils.MessagesFile;
import uk.co.anttheantster.vanquil.killlevels.utils.MySQL;
import uk.co.anttheantster.vanquil.killlevels.utils.SQLGetter;

import java.sql.SQLException;

public class KillLevels extends JavaPlugin {

    public MySQL SQL;
    public SQLGetter data;

    public MessagesFile messagesFile;
    public ShowEXP showEXP;

    private PluginManager pm = Bukkit.getPluginManager();

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
        showEXP = new ShowEXP(this);
    }

    private void registerCommands(){
        getCommand("vkl").setExecutor(new CommandController(this, showEXP));
    }

    private void registerListeners(){
        pm.registerEvents(new PlayerJoinSQL(this, messagesFile), this);
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
