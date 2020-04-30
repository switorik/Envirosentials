package switorik.envirosentials.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import switorik.envirosentials.Main;

import java.util.List;

import static switorik.envirosentials.commands.utils.*;

public class homeCmd implements CommandExecutor {

    Main plugin = Main.plugin;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            YamlConfiguration yml = getPlayerData(player);

            switch(args.length) {

                case 0: {
                    //TODO: teleport home if exists
                    List<String> homes = yml.getStringList(player.getUniqueId() + "Homes");

                    if(homes != null) {

                        Location loc = yml.getLocation(player.getUniqueId() + "Homes." + args[0]);
                        player.teleport(loc);

                    } else {

                        //TODO: you do not have a home set.

                    }
                    return true;

                }
                case 1: {


                    //TODO: subcommands will be {set, list, delete, goto(admin command)}
                    return true;
                }
                case 2: {
                    if(args[0].equalsIgnoreCase("set")) setHome((Player) sender, Trim(args));
                    //TODO: what home will be set or deleted
                    return true;
                }
                default: {
                    //TODO: command syntax?
                    return true;
                }

            }

        } else {

            //TODO:messages must be player

        }

        return false;
    }
    public void setHome(Player player, String[] args) {
        YamlConfiguration yml = getPlayerData(player);
        yml.set("Homes." + args[0], player.getLocation());
        saveData(yml, player);

    }
    public void goingHome(Player player, String[] args) {

        YamlConfiguration yml = getPlayerData(player);
        List<String> homes = yml.getStringList(player.getUniqueId() + "Homes");

        if(homes != null) {

            if(yml.get("Homes." + args[0]) != null) {

                Location loc = yml.getLocation("Homes." + args[0]);
                player.teleport(loc);
            } else {

                //TODO:you do not have a home by that name

            }

        } else {

            //TODO: you do not have any homes set.

        }

    }

}
