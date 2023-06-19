package me.lucthesloth.domhusks;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.generator.structure.StructureType;
import org.bukkit.util.StructureSearchResult;

public class EntityListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onCreatureSpawn(CreatureSpawnEvent event){
        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL ||
            !(event.getEntity() instanceof Monster) ||
            event.getLocation().getWorld().getEnvironment() != World.Environment.NORMAL) return;

        Location location = event.getLocation();
        if (location.getBlockY() <= 49 || location.getBlockY() >= 81) return;

        // Old Code compatibility. In case it's turned on in config
        if (HuskPyramid.instance.oldCode && (location.getBlock().getBiome() == Biome.DESERT || location.getBlock().getBiome() == Biome.RIVER)) {
            StructureSearchResult result = location.getWorld().locateNearestStructure(location, StructureType.DESERT_PYRAMID, 32, false);
            if (result != null && location.getBlockX() >= result.getLocation().getBlockX() && location.getBlockX() <= result.getLocation().getBlockX() + 22 &&
                location.getBlockZ() >= result.getLocation().getBlockZ() && location.getBlockZ() <= result.getLocation().getBlockZ() + 22){
                location.getWorld().spawnEntity(location, EntityType.HUSK);
                event.setCancelled(true);
                return;
            }
        }

        if (HuskPyramid.instance.pyramidBoundingBoxes.stream().anyMatch(box -> box.contains(location.toVector()))){
            location.getWorld().spawnEntity(location, EntityType.HUSK);
            event.setCancelled(true);
        }
    }
}
