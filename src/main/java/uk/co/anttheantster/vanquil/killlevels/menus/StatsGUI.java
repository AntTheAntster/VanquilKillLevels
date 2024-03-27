package uk.co.anttheantster.vanquil.killlevels.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;
import uk.co.anttheantster.vanquil.killlevels.items.StatsGUIItems;
import uk.co.anttheantster.vanquil.killlevels.utils.ChatColor;

public class StatsGUI {

    private KillLevels plugin;
    private ChatColor chatColor;
    private StatsGUIItems statsGUIItems;
    public StatsGUI(KillLevels plugin, ChatColor chatColor, StatsGUIItems statsGUIItems){
        this.plugin = plugin;
        this.chatColor = chatColor;
        this.statsGUIItems = statsGUIItems;
    }

    public Inventory statsGUI(Player player){
        int invSize = 27;
        Inventory inv = Bukkit.createInventory(player, invSize, chatColor.message("&a&lStats"));

        for (int i = 0; i < invSize; i++){
            inv.setItem(i, statsGUIItems.filler());
        }

        inv.setItem(10, statsGUIItems.expItem());
        inv.setItem(12, statsGUIItems.killItem());
        inv.setItem(14, statsGUIItems.levelItem());

        return inv;
    }

}
