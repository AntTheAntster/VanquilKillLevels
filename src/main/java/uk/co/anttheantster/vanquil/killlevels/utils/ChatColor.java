package uk.co.anttheantster.vanquil.killlevels.utils;

public class ChatColor {

    public String message(String string){
        String msg = org.bukkit.ChatColor.translateAlternateColorCodes('&', string);
        return msg;
    }


}
