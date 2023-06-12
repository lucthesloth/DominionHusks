package me.lucthesloth.domhusks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("huskpyramid.reload")) {
            HuskPyramid.instance.reloadConfig();
            HuskPyramid.instance.pyramidBoundingBoxes.clear();
            HuskPyramid.instance.populateList();
            sender.sendMessage("§aReloaded HuskPyramid config.");
            return true;
        }
        return false;
    }
}
