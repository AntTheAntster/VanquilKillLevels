package uk.co.anttheantster.vanquil.killlevels.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

public class ShowKills {

    private KillLevels plugin;
    public ShowKills(KillLevels plugin){
        this.plugin = plugin;
    }

    public void showKills(Player player){
        String kills = plugin.data.getKills(player);
        player.sendMessage(ChatColor.GOLD + "Your current kills: " + ChatColor.GREEN + kills);
    }

}
