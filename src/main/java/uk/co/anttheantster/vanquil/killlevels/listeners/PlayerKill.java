package uk.co.anttheantster.vanquil.killlevels.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

public class PlayerKill implements Listener {

    private KillLevels plugin;
    private LevelController levelController;
    public PlayerKill(KillLevels plugin, LevelController levelController){
        this.plugin = plugin;
        this.levelController = levelController;
    }

    @EventHandler
    public void playerKill(PlayerDeathEvent e){

        Player killer = e.getEntity().getKiller();

        levelController.kill(killer);
    }

}
