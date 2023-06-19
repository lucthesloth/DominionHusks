package me.lucthesloth.witchhuts;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EntityListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onCreatureSpawn(CreatureSpawnEvent event){
        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL ||
            !(event.getEntity() instanceof Monster) ||
            event.getLocation().getWorld().getEnvironment() != World.Environment.NORMAL) return;

        Location location = event.getLocation();
        if (WitchHuts.instance.hutsBoundingBoxes.stream().anyMatch(box -> box.contains(location.toVector()))){
            location.getWorld().spawnEntity(location, EntityType.WITCH);
            event.setCancelled(true);
        }
    }
}