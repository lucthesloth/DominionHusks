package me.lucthesloth.domhusks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BoundingBox;

import java.util.*;

public final class HuskPyramid extends JavaPlugin {
    public ArrayList<BoundingBox> pyramidBoundingBoxes = new ArrayList<>();
    public boolean oldCode = false;
    public static HuskPyramid instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        refreshConfiguration();
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
        Objects.requireNonNull(getCommand("reloadhuskpyramid")).setExecutor(new ReloadCommand());
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void refreshConfiguration() {
        this.oldCode = getConfig().getBoolean("old-code", false);
        List<List<Integer>> list = (List<List<Integer>>) getConfig().getList("pyramids", Collections.emptyList());
        for (List<Integer> location : list)
            this.pyramidBoundingBoxes.add(new BoundingBox(location.get(0)-1, 49.0D, location.get(1)-1, location.get(0) + 22.0D, 81.0D, location.get(1) + 22.0D));
    }
}
