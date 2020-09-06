package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleEnchantment;


public class ChildYeetEnchantment extends SimpleEnchantment {

    @Getter
    private static final Enchantment instance = new ChildYeetEnchantment();

    private ChildYeetEnchantment() {
        super("Child Yeet", 5);
    }

    @Override
    protected void onDamage(int level, LivingEntity damager, EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        if (damager instanceof Player) {
            final Player attacker = (Player) event.getDamager();
            final LivingEntity victim = (LivingEntity) event.getEntity();

            if (victim instanceof Zombie && ((Zombie) victim).isBaby() || victim instanceof Villager && !((Villager) victim).isAdult()) {
                victim.setVelocity(damager.getEyeLocation().getDirection().multiply(10).setY(10));

                Common.tell(attacker, "Yeeted the mob");
            }
        }
    }
}
