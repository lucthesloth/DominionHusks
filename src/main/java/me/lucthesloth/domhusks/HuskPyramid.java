package me.lucthesloth.domhusks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BoundingBox;

import java.util.*;

public final class HuskPyramid extends JavaPlugin {
    public static HuskPyramid instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
