package uk.co.anttheantster.vanquil.killlevels;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.vanquil.killlevels.commands.CommandController;
import uk.co.anttheantster.vanquil.killlevels.commands.ShowEXP;
import uk.co.anttheantster.vanquil.killlevels.commands.ShowKills;
import uk.co.anttheantster.vanquil.killlevels.commands.ShowLevel;
import uk.co.anttheantster.vanquil.killlevels.items.StatsGUIItems;
import uk.co.anttheantster.vanquil.killlevels.listeners.LevelController;
import uk.co.anttheantster.vanquil.killlevels.listeners.PlayerJoinSQL;
import uk.co.anttheantster.vanquil.killlevels.listeners.PlayerKill;
import uk.co.anttheantster.vanquil.killlevels.menus.StatsGUI;
import uk.co.anttheantster.vanquil.killlevels.utils.ChatColor;
import uk.co.anttheantster.vanquil.killlevels.utils.MessagesFile;
import uk.co.anttheantster.vanquil.killlevels.utils.MySQL;
import uk.co.anttheantster.vanquil.killlevels.utils.SQLGetter;

import java.sql.SQLException;

public class KillLevels extends JavaPlugin {

    public MySQL SQL;
    public SQLGetter data;

    public MessagesFile messagesFile;
    public ShowEXP showEXP;
    public ShowLevel showLevel;
    public ShowKills showKills;
    public ChatColor chatColor;
    public StatsGUI statsGUI;
    public StatsGUIItems statsGUIItems;
    public LevelController levelController;

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
        showLevel = new ShowLevel(this);
        showKills = new ShowKills(this);
        chatColor = new ChatColor();
        statsGUI = new StatsGUI(this, chatColor, statsGUIItems);
        statsGUIItems = new StatsGUIItems(this, chatColor);
        levelController = new LevelController(this, chatColor);
    }

    private void registerCommands(){
        getCommand("vkl").setExecutor(new CommandController(this, showEXP, showLevel, showKills, statsGUI, levelController));
    }

    private void registerListeners(){
        pm.registerEvents(new PlayerJoinSQL(this), this);
        pm.registerEvents(new PlayerKill(this, levelController), this);
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
