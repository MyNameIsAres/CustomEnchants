package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.geminicraft.customenchant.enchants.MobRegistery;
import org.mineacademy.fo.BlockUtil;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.Remain;


public class SummonEnchant extends SimpleEnchantment {

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
        MobRegistery registery = MobRegistery.getInstance();
        StrictList<EntityType> spawnableMobsList = registery.getSpawnableMobs();

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (index == spawnableMobsList.size()) {
                index = 0;
                currentMob = spawnableMobsList.get(index);
            }
            currentMob = spawnableMobsList.get(index++);

            Remain.sendActionBar(event.getPlayer(), String.valueOf(currentMob));

        } else if (action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR) {
            final Location location = RandomUtil.nextLocation(event.getPlayer().getLocation(), 5, false);
            final int highestY = BlockUtil.findHighestBlockNoSnow(location);

            if (highestY != -1) {
                location.setY(highestY);
                registery.spawn(location, currentMob);
            }

            //TODO summon mobs (amount maybe decided by level?)
        }

    }
}
