package org.geminicraft.customenchant.enchants;


import lombok.Getter;

import org.geminicraft.customenchant.enchants.impl.ChildYeetEnchantment;
import org.geminicraft.customenchant.enchants.impl.SummonEnchant;
import org.geminicraft.customenchant.enchants.impl.TeleportEnchant;
import org.geminicraft.customenchant.enchants.impl.ThunderStrikeEnchant;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.model.SimpleEnchantment;

import java.util.List;

public final class EnchantRegister {
    @Getter
    private static final EnchantRegister instance = new EnchantRegister();

    private final StrictList<SimpleEnchantment> simpleEnchantments = new StrictList<>();
    
    private EnchantRegister() {
        add((SimpleEnchantment) ThunderStrikeEnchant.getInstance());
        add((SimpleEnchantment) ChildYeetEnchantment.getInstance());
        add((SimpleEnchantment) SummonEnchant.getInstance());
        add((SimpleEnchantment) TeleportEnchant.getInstance());
    }

    public void add(SimpleEnchantment enchantment) {
        simpleEnchantments.add(enchantment);
    }

    public SimpleEnchantment findEnchantment(String name) {
        Valid.checkNotNull(name);

        for (SimpleEnchantment enchantment : simpleEnchantments) {
            if (enchantment.getName().toLowerCase().equals(name.toLowerCase())) {
                return enchantment;
            }
        }

        return null;
    }

    public List<String> getEnchantmentNames() {
        return Common.convert(simpleEnchantments, SimpleEnchantment::getName);
    }
}
