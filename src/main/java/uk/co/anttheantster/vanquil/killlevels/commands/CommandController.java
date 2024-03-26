package uk.co.anttheantster.vanquil.killlevels.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

public class CommandController implements CommandExecutor {
    private KillLevels plugin;
    private ShowEXP showEXP;

    public CommandController(KillLevels plugin, ShowEXP showEXP){
        this.plugin = plugin;
        this.showEXP = showEXP;
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

        }

        return false;
    }
}