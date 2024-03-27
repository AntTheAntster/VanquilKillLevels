package uk.co.anttheantster.vanquil.killlevels.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;
import uk.co.anttheantster.vanquil.killlevels.utils.ChatColor;

public class StatsGUIItems {
    private KillLevels plugin;
    private ChatColor chatColor;
    public StatsGUIItems(KillLevels plugin, ChatColor chatColor){
        this.plugin = plugin;
        this.chatColor = chatColor;
    }

    public ItemStack expItem(){
        ItemStack item = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(chatColor.message("&eKills Experience"));
        item.setItemMeta(itemMeta);

        return item;
    }




}
