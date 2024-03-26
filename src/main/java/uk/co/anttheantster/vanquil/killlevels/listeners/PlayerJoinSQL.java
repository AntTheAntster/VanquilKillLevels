package uk.co.anttheantster.vanquil.killlevels.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;
import uk.co.anttheantster.vanquil.killlevels.utils.MessagesFile;

public class PlayerJoinSQL implements Listener {
    private final KillLevels plugin;
    private final MessagesFile messages;
    public PlayerJoinSQL(KillLevels plugin, MessagesFile messages){
        this.plugin = plugin;
        this.messages = messages;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        if (plugin.SQL.isConnected()){
            if (!plugin.data.exists(e.getPlayer().getUniqueId())){
                Player player = e.getPlayer();
                plugin.data.createPlayer(player);
                plugin.data.setEXP(plugin.getConfig().getInt("Settings.Starting EXP"), player);
                plugin.data.setKills(plugin.getConfig().getInt("Settings.Starting Kills"), player);
                plugin.data.setLevel(plugin.getConfig().getInt("Settings.Starting Level"), player);
            }
        }
    }

}
