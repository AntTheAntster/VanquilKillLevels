package uk.co.anttheantster.vanquil.killlevels.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

public class ShowEXP {

    private KillLevels plugin;
    public ShowEXP(KillLevels plugin){
        this.plugin = plugin;
    }

    public void show(Player player){
        String exp = plugin.data.getEXP(player);

        player.sendMessage(ChatColor.GOLD + "Your Exp: " + ChatColor.GREEN + exp);
    }

}
