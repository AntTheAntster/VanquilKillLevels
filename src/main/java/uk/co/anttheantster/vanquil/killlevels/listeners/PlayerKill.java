package uk.co.anttheantster.vanquil.killlevels.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

public class PlayerKill implements Listener {

    private KillLevels plugin;
    public PlayerKill(KillLevels plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void playerKill(PlayerDeathEvent e){

        Player killer = e.getEntity().getKiller();
        Player player = e.getEntity().getPlayer();

        int prevLevel = Integer.parseInt(plugin.data.getLevel(killer));
        plugin.data.setLevel(prevLevel + 1, killer);
    }

}
