package me.lucthesloth.domhusks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BoundingBox;

import java.util.*;

public final class HuskPyramid extends JavaPlugin {
    public ArrayList<BoundingBox> pyramidBoundingBoxes = new ArrayList<>();
    public static HuskPyramid instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        populateList();
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
        Objects.requireNonNull(getCommand("reloadhuskpyramid")).setExecutor(new ReloadCommand());
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void populateList() {
        List<List<Integer>> list = (List<List<Integer>>) getConfig().getList("pyramids", Collections.emptyList());
        for (List<Integer> location : list)
            this.pyramidBoundingBoxes.add(new BoundingBox(location.get(0), 50.0D, location.get(1), location.get(0) + 21.0D, 80.0D, location.get(1) + 21.0D));
    }
}