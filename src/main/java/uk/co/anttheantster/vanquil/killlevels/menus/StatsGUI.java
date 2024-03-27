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
        Inventory inv = Bukkit.createInventory(player, 27, chatColor.message("&a&lStats"));



        inv.setItem(10, statsGUIItems.expItem());

        return inv;
    }

}
