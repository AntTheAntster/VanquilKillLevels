package uk.co.anttheantster.vanquil.killlevels.listeners;

import org.bukkit.entity.Player;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;
import uk.co.anttheantster.vanquil.killlevels.utils.ChatColor;

public class LevelController {

    private KillLevels plugin;
    private ChatColor chatColor;
    public LevelController (KillLevels plugin, ChatColor chatColor){
        this.plugin = plugin;
        this.chatColor = chatColor;
    }

    public void kill(Player player){
        int kills = Integer.parseInt(plugin.data.getKills(player));
        plugin.data.setKills(kills + 1, player);
    }

    private void exp(Player player){
        plugin.data.setEXP(pExp(player) + plugin.getConfig().getInt("Settings.Exp Per Kill"), player);
         if (pExp(player) >= pExpReq(player)){
             int exp = pExp(player);
             int expReq = pExpReq(player);
             int expReqNext = 0;
             int expOver = exp - expReq;

             plugin.data.setEXP(expOver, player);
             if (plugin.getConfig().getString("Settings.Exp Increase.Type").equalsIgnoreCase("Percentage")){
                 expReqNext = (expReq / 100) * plugin.getConfig().getInt("Settings.Exp Increase.Amount");
             } else if (plugin.getConfig().getString("Settings.Exp Increase.Type").equalsIgnoreCase("Amount")){
                 expReqNext = expReq + plugin.getConfig().getInt("Settings.Exp Increase.Amount");
             }
             plugin.data.setExpReq(expReqNext, player);

         }

    }

    private void pLevelUp(Player player){
        plugin.data.setLevel(pLevel(player) + 1, player);
    }

    private Integer pExp(Player player){
        int exp = Integer.parseInt(plugin.data.getEXP(player));
        return exp;
    }
    private Integer pExpReq(Player player){
        int expreq = Integer.parseInt(plugin.data.getExpReq(player));
        return expreq;
    }
    private Integer pLevel(Player player){
        int level = Integer.parseInt(plugin.data.getLevel(player));
        return level;
    }

}
