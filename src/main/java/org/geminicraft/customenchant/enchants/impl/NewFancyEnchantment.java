package org.geminicraft.customenchant.enchants.impl;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.geminicraft.customenchant.betterenchants.BetterEnchantmentTarget;
import org.geminicraft.customenchant.betterenchants.BetterEnchants;
import org.mineacademy.fo.Common;

// This class exists to test out new features.
public class NewFancyEnchantment extends BetterEnchants {

    @Getter
    private static final Enchantment instance = new NewFancyEnchantment();

    public NewFancyEnchantment() {
        super("test", 3);
    }

    @Override
    public BetterEnchantmentTarget getCustomItemTarget() {
        Common.log("herloh it me charl legreg");
        return BetterEnchantmentTarget.CROSSBOW;
    }

    @Override
    public Material enchantMaterial() {
        return Material.DIAMOND_SHOVEL;
    }



}
