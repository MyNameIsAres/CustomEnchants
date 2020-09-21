package org.geminicraft.customenchant.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.geminicraft.customenchant.enchants.EnemyMobList;
import org.geminicraft.customenchant.enchants.MobRegistery;
import org.mineacademy.fo.Common;


// TODO To be replaced with proper pathfinding/goal algorithms. Utilizing NMS packages.
public final class DamageByCustomMobEvent implements Listener {

    MobRegistery registry = MobRegistery.getInstance();
    EnemyMobList enemyMobList = EnemyMobList.getInstance();

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Common.log("Reached this");

        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        if (event.getDamager() instanceof LivingEntity) {
            final EntityType victim = event.getDamager().getType();

            Common.log(victim.toString() + " just testing");
            registry.addMob(victim);
            enemyMobList.addMob(victim);


        }
    }

}
