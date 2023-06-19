package me.lucthesloth.witchhuts;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BoundingBox;

import java.util.*;

public final class WitchHuts extends JavaPlugin {
    public ArrayList<BoundingBox> hutsBoundingBoxes = new ArrayList<>();
    public int xSize,zSize,ySize,baseHeight;
    public static WitchHuts instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        RefreshConfig();
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
        Objects.requireNonNull(getCommand("reloadwitchhuts")).setExecutor(new ReloadCommand());
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void RefreshConfig() {
        this.xSize = getConfig().getInt("xSize", 7);
        this.zSize = getConfig().getInt("zSize", 5);
        this.ySize = getConfig().getInt("ySize", 7);
        this.baseHeight = getConfig().getInt("yStart", 64);
        List<List<Integer>> list = (List<List<Integer>>) getConfig().getList("huts", Collections.emptyList());
        for (List<Integer> location : list)
            this.hutsBoundingBoxes.add(new BoundingBox(location.get(0)-1, baseHeight-1, location.get(1) - 1, location.get(0) + xSize + 1, baseHeight + ySize + 1, location.get(1) + zSize + 1));
    }
}
