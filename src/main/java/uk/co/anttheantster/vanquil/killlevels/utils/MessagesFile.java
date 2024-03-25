package uk.co.anttheantster.vanquil.killlevels.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import uk.co.anttheantster.vanquil.killlevels.KillLevels;

import java.io.File;

public class MessagesFile {

    private final KillLevels plugin;
    public MessagesFile(KillLevels plugin){
        this.plugin = plugin;
    }

    private File messagesFile;
    private FileConfiguration messages;

    public FileConfiguration getMessagesFile(){
        return this.messages;
    }

    public void createMessagesFile(){
        messagesFile = new File(plugin.getDataFolder(), "messages.yml");
        if (!messagesFile.exists()) {
            try {
                messagesFile.createNewFile();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        messages = YamlConfiguration.loadConfiguration(messagesFile);
    }
    public void save(){
        try{
            messages.save(messagesFile);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void reload(){
        messages = YamlConfiguration.loadConfiguration(messagesFile);
    }

}
