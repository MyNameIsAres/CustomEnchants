package org.geminicraft.customenchant.enchants;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.NPC;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.collection.StrictList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MobRegistery {

    @Getter
    private static final MobRegistery instance = new MobRegistery();
    private final StrictList<EntityType> spawnableMobs = new StrictList<>();


    private MobRegistery() {
        addMob(EntityType.ZOMBIE);
        addMob(EntityType.SKELETON);
        addMob(EntityType.COW);
    }

    public void addMob(EntityType entity) {
        if (entity.isSpawnable() || entity.isAlive()) {
            spawnableMobs.add(entity);
        }
    }

    public final List<EntityType> getEntities() {
        return Collections.unmodifiableList(spawnableMobs.getSource());
    }

    public StrictList<EntityType> getSpawnableMobs() {
        return spawnableMobs;
    }

//    public final void spawn(Location location, NPC entityType) {
//        location.getWorld().spawnEntity(location, entityType);
}
//}
