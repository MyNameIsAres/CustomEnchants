package org.geminicraft.customenchant.enchants;

import lombok.Getter;
import org.bukkit.entity.EntityType;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.collection.StrictList;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnemyMobList {

    @Getter
    private static final EnemyMobList instance = new EnemyMobList();
    private final Set<EntityType> hostileMobs = new HashSet<>();

    private EnemyMobList() {

    }

    public void addMob(EntityType entity) {
        Common.log("We have just added a mob!.. I hope!");
        if (entity.isSpawnable() || entity.isAlive()) {
            hostileMobs.add(entity);
        }
    }
    public Set<EntityType> getGetHostileMobs() {
        return hostileMobs;
    }

}
