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

        oldCode(event);
    }
    public void oldCode(CreatureSpawnEvent event) {
        //Old code
        EntityType entityType = event.getEntityType();
        Location location = event.getLocation();
        Biome biome = location.getBlock().getBiome();
        double structureX = 0.0D;
        double structureZ = 0.0D;
        //Changed to structure search result to avoid using deprecated method
        StructureSearchResult result = null;
        //Removed specific entity type check in favor of checking only for monsters
        //There were only 2 possible cases of an entity not being valid: Enderman and Drowneds, which
        //Would not spawn inside a husk farm in any case
        if (biome == Biome.DESERT)
            result = location.getWorld().locateNearestStructure(location, StructureType.DESERT_PYRAMID, 25, false);
        if (result != null) {
            structureZ = result.getLocation().getZ();
            structureX = result.getLocation().getX();
        }
        if (location.getY() >= 50.0D && location.getY() <= 80.0D && Math.abs(structureX - location.getX() + 11.0D) < 12.0D && Math.abs(structureZ - location.getZ() + 11.0D) < 12.0D) {
            location.getWorld().spawnEntity(location, EntityType.HUSK);
            event.setCancelled(true);
        }
    }
}
