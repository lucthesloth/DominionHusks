package me.lucthesloth.witchhuts;

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
            WitchHuts.instance.RefreshConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aReloaded WitchHuts config. &e" + (WitchHuts.instance.hutsBoundingBoxes.size() > 0 ? " &c" + WitchHuts.instance.hutsBoundingBoxes.size() + " huts loaded." : "")));
            return true;
        }
        return false;
    }
}
