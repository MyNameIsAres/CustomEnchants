package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.mineacademy.fo.model.SimpleEnchantment;

public class FlashEnchant extends SimpleEnchantment {

    @Getter
    private static final Enchantment instance = new FlashEnchant();


    private FlashEnchant() {
        super("Flash", 1);
    }

    // TODO: I am flash.. Fill this in.
}
