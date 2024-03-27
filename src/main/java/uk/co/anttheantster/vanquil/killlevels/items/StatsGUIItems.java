package uk.co.anttheantster.vanquil.killlevels.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
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

    public ItemStack killItem() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(chatColor.message("&eKills: "));
        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack levelItem() {
        ItemStack item = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(chatColor.message("&eLevel: "));
        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack filler(){
        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(" ");
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.isUnbreakable();
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(itemMeta);

        return item;
    }
}
