package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.mineacademy.fo.model.SimpleEnchantment;

public class TeleportEnchant extends SimpleEnchantment {
    
    @Getter
    private static final Enchantment instance = new TeleportEnchant();

    private TeleportEnchant() {
        super("Flash", 1);
    }
}
