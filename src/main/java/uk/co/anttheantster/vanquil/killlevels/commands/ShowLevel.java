package uk.co.anttheantster.vanquil.killlevels.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

public class ShowLevel {

    private KillLevels plugin;
    public ShowLevel(KillLevels plugin){
        this.plugin = plugin;
    }

    public void showLevel(Player player){
        String level = plugin.data.getLevel(player);
        player.sendMessage(ChatColor.GOLD + "Your current Level: " + ChatColor.GREEN + level);
    }

}
