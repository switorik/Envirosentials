package switorik.envirosentials.events;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static switorik.envirosentials.utils.getPlayerData;
import static switorik.envirosentials.utils.saveData;

public class playerDeath implements Listener {

    @EventHandler
    public void ondeath(PlayerDeathEvent e) {

        if(e.getEntity() instanceof Player) {
            Player player = e.getEntity().getPlayer();
            YamlConfiguration yml = getPlayerData(player);
            yml.set("Last Death", player);
            saveData(yml, player);
        }

    }
}
