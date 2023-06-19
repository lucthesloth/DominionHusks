package me.lucthesloth.domhusks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("huskpyramid.reload")) {
            HuskPyramid.instance.reloadConfig();
            HuskPyramid.instance.pyramidBoundingBoxes.clear();
            HuskPyramid.instance.refreshConfiguration();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aReloaded config and bounding boxes. &7(&e" + HuskPyramid.instance.pyramidBoundingBoxes.size() + " &7Pyramid bound boxes&7)"));
            return true;
        }
        return false;
    }
}
