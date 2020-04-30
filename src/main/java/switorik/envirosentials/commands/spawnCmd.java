package switorik.envirosentials.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import switorik.envirosentials.Main;

public class spawnCmd implements CommandExecutor {

    Main plugin = Main.plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {

                Location spawn = plugin.getConfig().getLocation("Spawn");

                if(spawn != null) {
                    player.teleport(spawn);
                } else {

                    player.sendMessage("A spawn point has not been set");

                }

            } else {

                if(args[0].equalsIgnoreCase("set")) {

                    plugin.getConfig().set("Spawn", player.getLocation());
                    plugin.saveConfig();
                    player.sendMessage("You set spawn here.");
                    //TODO: Move spawn chunk?


                } else {

                    //TODO: Incorrect subcommand?

                }

            }


        }
        return true;
    }
}
