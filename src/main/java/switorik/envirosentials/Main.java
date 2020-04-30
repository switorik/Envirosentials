package switorik.envirosentials;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import switorik.envirosentials.commands.home;
import switorik.envirosentials.commands.message;
import switorik.envirosentials.commands.spawn;
import switorik.envirosentials.events.playerDeath;

import java.io.File;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getLogger().info("Envirosentials has loaded.");

        File configyml = new File(plugin.getDataFolder() + File.separator + "config.yml");
        if (!configyml.exists()) {
            this.saveResource("config.yml", false);
        }

        registerCmds();
        resgisterListeners();

    }
//SWIT SMELLS
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getLogger().info("Envirosentials has unloaded.");
    }

    public void registerCmds() {

        this.getCommand("home").setExecutor(new home());
        this.getCommand("spawn").setExecutor(new spawn());
        this.getCommand("message").setExecutor(new message());

    }
    public void resgisterListeners() {
        PluginManager manager = getServer().getPluginManager();

        manager.registerEvents(new playerDeath(), this);
    }
}
