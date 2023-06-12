package me.lucthesloth.domhusks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("witchhuts.reload")) {
            WitchHuts.instance.reloadConfig();
            WitchHuts.instance.hutsBoundingBoxes.clear();
            WitchHuts.instance.populateList();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aReloaded WitchHuts config."));
            return true;
        }
        return false;
    }
}
