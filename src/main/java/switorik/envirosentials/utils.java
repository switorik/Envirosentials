package switorik.envirosentials;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import switorik.envirosentials.Main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class utils {

    private static Main plugin = Main.plugin;

    public static String[] Trim(String[] args){
        return Arrays.copyOfRange(args, 1, args.length);
    }

    public static YamlConfiguration getPlayerData(Player player) {

        File ymlFile = new File(plugin.getDataFolder() + File.separator + "data" + File.separator +  player.getUniqueId() + ".yml");
        YamlConfiguration yml = new YamlConfiguration().loadConfiguration(ymlFile);

        return yml;

    }
    public static void saveData(YamlConfiguration yml, Player player) {

        File ymlFile = new File(plugin.getDataFolder() + File.separator + "data" + File.separator +  player.getUniqueId() + ".yml");
        try {
            yml.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
