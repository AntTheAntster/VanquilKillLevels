package uk.co.anttheantster.vanquil.killlevels.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;
import uk.co.anttheantster.vanquil.killlevels.listeners.LevelController;
import uk.co.anttheantster.vanquil.killlevels.menus.StatsGUI;

public class CommandController implements CommandExecutor {
    private KillLevels plugin;
    private ShowEXP showEXP;
    private ShowLevel showLevel;
    private ShowKills showKills;
    private StatsGUI statsGUI;
    private LevelController levelController;

    public CommandController(KillLevels plugin, ShowEXP showEXP, ShowLevel showLevel, ShowKills showKills, StatsGUI statsGUI, LevelController levelController){
        this.plugin = plugin;
        this.showEXP = showEXP;
        this.showLevel = showLevel;
        this.showKills = showKills;
        this.statsGUI = statsGUI;
        this.levelController = levelController;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;
        if (args[0].equalsIgnoreCase("exp")){
            showEXP.show(player);
        }
        if (args[0].equalsIgnoreCase("level")){
            showLevel.showLevel(player);
        }
        if (args[0].equalsIgnoreCase("kills")){
            showKills.showKills(player);
        }
        if (args[0].equalsIgnoreCase("stats")){
            statsGUI.statsGUI(player);
        }
        if (args[0].equalsIgnoreCase("test")){
            levelController.kill(player);
        }

        return false;
    }
}
