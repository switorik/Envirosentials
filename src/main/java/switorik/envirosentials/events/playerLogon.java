package switorik.envirosentials.events;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerLogon implements Listener {
    //TODO: this will handle tablist colors and any other login stuffs

    @EventHandler
    public void onJoin(PlayerLoginEvent e) {

        Player player = (Player) e.getPlayer();
        LuckPerms luckapi = LuckPermsProvider.get();

        luckapi.getGroupManager();
        //TODO: this!
    }
}
