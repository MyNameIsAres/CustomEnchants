package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.GameMode;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleEnchantment;


public class ThunderStrikeEnchant extends SimpleEnchantment {

    @Getter
    private static final Enchantment instance = new ThunderStrikeEnchant();

    private ThunderStrikeEnchant() {
        super("xx", 3);
    }

    protected boolean thunderCharged = false;

    @Override
    public EnchantmentTarget getItemTarget() {
        Common.log("Test");
        return EnchantmentTarget.ARMOR;
    }


    //    @Override
//    public @NotNull EnchantmentTarget getItemTarget() {
//        return EnchantmentTarget.ARMOR;
//    }

    @Override
    protected void onDamage(int level, LivingEntity damager, EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        Common.log("onDamage works!");

        if (damager instanceof Player && thunderCharged) {
            Common.log("Instance of player");
            final Player attacker = (Player) event.getDamager();
            final LivingEntity victim = (LivingEntity) event.getEntity();

            if (attacker.getGameMode() == GameMode.CREATIVE) {
                attacker.getWorld().strikeLightning(victim.getLocation());
            }
        }

    }

    // TODO Implement cool-down
    @Override
    protected void onInteract(int level, PlayerInteractEvent event) {

        try {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                thunderCharged = true;
                Common.log("onInteract works");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            Common.tell(event.getPlayer(), "&c Oops! Something went wrong! Please contact an administrator.");
        }
    }

}
