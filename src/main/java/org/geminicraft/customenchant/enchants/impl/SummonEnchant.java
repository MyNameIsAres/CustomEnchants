package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.Goal;
import net.citizensnpcs.api.ai.goals.TargetNearbyEntityGoal;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.geminicraft.customenchant.enchants.EnemyMobList;
import org.geminicraft.customenchant.enchants.MobRegistery;
import org.mineacademy.fo.BlockUtil;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.Remain;

import java.util.HashSet;
import java.util.Set;


public class SummonEnchant extends SimpleEnchantment implements Listener {


    MobRegistery registery = MobRegistery.getInstance();
    EnemyMobList enemyMobList = EnemyMobList.getInstance();
    Set<EntityType> testSet = new HashSet<>();

    public Set<EntityType> getTestSet() {
        addEntity(EntityType.SKELETON);

        return testSet;
    }

    public void addEntity(EntityType entity) {
        if (entity.isSpawnable() || entity.isAlive()) {
            testSet.add(entity);
        }
    }

    @Getter
    private static final Enchantment instance = new SummonEnchant();

    private SummonEnchant() {
        super("Summoning Staff", 1);
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.TRIDENT;
    }

    
    int index = 0;
    EntityType currentMob;

    @Override
    protected void onInteract(int level, PlayerInteractEvent event) {
        Action action = event.getAction();
        StrictList<EntityType> spawnableMobsList = registery.getSpawnableMobs();

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (index == spawnableMobsList.size()) {
                index = 0;
                currentMob = spawnableMobsList.get(index);
            }

            currentMob = spawnableMobsList.get(index++);

            Remain.sendActionBar(event.getPlayer(), String.valueOf(currentMob));

        } else if (action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR) {
            enemyMobList.addMob(EntityType.CHICKEN);

            final NPCRegistry registry = CitizensAPI.getNPCRegistry();
            final NPC npc = registry.createNPC(currentMob, "Test");

            final Location location = RandomUtil.nextLocation(event.getPlayer().getLocation(), 5, false);
            final int highestY = BlockUtil.findHighestBlockNoSnow(location);

            if (highestY != -1) {
                location.setY(highestY);

                npc.spawn(location);
                npc.setProtected(false);

                final Goal goal = TargetNearbyEntityGoal.builder(npc)
                        .aggressive(true)
                        .radius(12)
                        .targets(enemyMobList.getGetHostileMobs())
                        .build();
                npc.getDefaultGoalController().addGoal(goal, 1);

                Common.log(enemyMobList.getGetHostileMobs().toString());
//                registery.spawn(location, npc); // Refactor later.
            }

            //TODO summon mobs (amount maybe decided by level?)
        }
    }


}
