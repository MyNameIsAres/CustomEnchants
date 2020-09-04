package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.geminicraft.customenchant.enchants.MobRegistery;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.model.SimpleEnchantment;

import java.util.Iterator;

public class SummonEnchant extends SimpleEnchantment {

    @Getter
    private static final Enchantment instance = new SummonEnchant();

    private final StrictList<EntityType> spawnableMobs = new StrictList<>();

    private SummonEnchant() {
        super("Summoning Staff", 1);
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.TRIDENT;
    }

    @Override
    protected void onInteract(int level, PlayerInteractEvent event) {

        Action action = event.getAction();
        MobRegistery registery = MobRegistery.getInstance();
        Iterator<EntityType> iterator = registery.getEntities().iterator();

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            Common.log(iterator.next().toString());

            // TODO: Display currently selected mob
            // TODO: Check what mob is currently selected (maybe responsibility of else if,
            // could deligate to its own method.

        } else if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            //TODO summon mobs (amount maybe decided by level?)
        }

    }


}
