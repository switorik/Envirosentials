package switorik.envirosentials;

import org.bukkit.plugin.java.JavaPlugin;
import switorik.envirosentials.commands.homeCmd;
import switorik.envirosentials.commands.spawnCmd;

import java.io.File;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getLogger().info("Switsentials has loaded.");

        File configyml = new File(plugin.getDataFolder() + File.separator + "config.yml");
        if (!configyml.exists()) {
            this.saveResource("config.yml", false);
        }

        registerCmds();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getLogger().info("Switsentials has unloaded.");
    }

    public void registerCmds() {

        this.getCommand("home").setExecutor(new homeCmd());
        this.getCommand("spawn").setExecutor(new spawnCmd());

    }
}
