package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleEnchantment;

public class ExplosiveArrowsEnchant extends SimpleEnchantment {

    @Getter
    private static final Enchantment instance = new ExplosiveArrowsEnchant();

    private ExplosiveArrowsEnchant() {
        super("Explosive Arrows", 4);
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.BOW;
    }

    @Override
    protected void onHit(int level, LivingEntity shooter, ProjectileHitEvent event) {
        if (!(event.getHitEntity() instanceof LivingEntity)) {
            return;
        }

        Common.log("Elloh");

        if (shooter instanceof Player) {

            Common.log("Reached this portion");

            final LivingEntity hitEntity = (LivingEntity) event.getHitEntity();
            hitEntity.getWorld().createExplosion(hitEntity.getLocation(), 3F);
        } else {
            Common.log(shooter.toString());
        }
        
    }
}
