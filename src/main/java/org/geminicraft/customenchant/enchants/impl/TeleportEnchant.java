package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.CompSound;

public class TeleportEnchant extends SimpleEnchantment {

    @Getter
    private static final Enchantment instance = new TeleportEnchant();

    private TeleportEnchant() {
        super("TeleportSword", 1);
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.WEAPON;
    }

    // Externalize variables
    Location location;
    Block block;

    @Override
    protected void onInteract(int level, PlayerInteractEvent event) {
        Action action = event.getAction();
        Player player = event.getPlayer();

        if (action == Action.RIGHT_CLICK_BLOCK && event.getHand() == EquipmentSlot.HAND) {
            Common.tell(player, "&2Teleport Anchor Set!");
            
            block = player.getTargetBlock(null, 1);
            location = block.getLocation().add(0.5, 0, 0.5);


        } else if (action == Action.RIGHT_CLICK_AIR) {
            float currentYaw = player.getLocation().getYaw();

            if (location == null) {
                Common.tell(player, "No location set!");
            } else {
                location.setYaw(currentYaw);
                player.teleport(location);

                Common.tell(player, "&6The grant escape!");
                player.playEffect(location, Effect.ENDER_SIGNAL, null);
                CompSound.ENDERMAN_TELEPORT.play(player);

                location = null;
            }
        }

        // TODO Better particles

    }
}
