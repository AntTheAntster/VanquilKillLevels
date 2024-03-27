package uk.co.anttheantster.vanquil.killlevels.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

public class CommandController implements CommandExecutor {
    private KillLevels plugin;
    private ShowEXP showEXP;
    private ShowLevel showLevel;
    private ShowKills showKills;

    public CommandController(KillLevels plugin, ShowEXP showEXP, ShowLevel showLevel, ShowKills showKills){
        this.plugin = plugin;
        this.showEXP = showEXP;
        this.showLevel = showLevel;
        this.showKills = showKills;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;
        if (args[0].equalsIgnoreCase("exp")){
            showEXP.show(player);
        }
        if (args[0].equalsIgnoreCase("level")){

        }
        if (args[0].equalsIgnoreCase("kills")){
            showKills.showKills(player);
        }

        return false;
    }
}
