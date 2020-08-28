package org.geminicraft.customenchant;


import lombok.Getter;

import org.geminicraft.customenchant.enchants.impl.ChildYeetEnchantment;
import org.geminicraft.customenchant.enchants.impl.ThunderStrikeEnchant;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.collection.StrictList;
import org.mineacademy.fo.model.SimpleEnchantment;

public final class EnchantRegister {
    @Getter
    private static final EnchantRegister instance = new EnchantRegister();

    private final StrictList<SimpleEnchantment> simpleEnchantments = new StrictList<>();


    private EnchantRegister() {
        add((SimpleEnchantment) ThunderStrikeEnchant.getInstance());
        add((SimpleEnchantment) ChildYeetEnchantment.getInstance());

    }

    public void add(SimpleEnchantment enchantment) {
        simpleEnchantments.add(enchantment);
    }

    public SimpleEnchantment findEnchantment(String name) {
        Valid.checkNotNull(name);
        Common.log("I am name in findEnchantment " + name);

        for (SimpleEnchantment enchantment : simpleEnchantments) {
            Common.log("I am the getName method " + enchantment.getName());
            if (enchantment.getName().toLowerCase().equals(name.toLowerCase())) {
                Common.log("Enchantment register returned the enchantment");

                return enchantment;
            }

            Common.log(enchantment.getName() + " I am the getname function again");
            Common.log(name + " I am the name");

            Common.log("Escaping loop");
        }


        Common.log("Enchantment register returned null");
        Common.log(name);
        Common.log(ThunderStrikeEnchant.getInstance().getName());
        return null;

    }
}
