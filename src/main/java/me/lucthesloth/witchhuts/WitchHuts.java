package me.lucthesloth.witchhuts;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BoundingBox;

import java.util.*;

public final class WitchHuts extends JavaPlugin {
    public ArrayList<BoundingBox> hutsBoundingBoxes = new ArrayList<>();
    public static WitchHuts instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        populateList();
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
        Objects.requireNonNull(getCommand("reloadwitchhuts")).setExecutor(new ReloadCommand());
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void populateList() {
        List<List<Integer>> list = (List<List<Integer>>) getConfig().getList("pyramids", Collections.emptyList());
        for (List<Integer> location : list)
            this.hutsBoundingBoxes.add(new BoundingBox(location.get(0), 64, location.get(2), location.get(0) + 7.0D, 73, location.get(2) + 5.0D));
    }
}
