package org.geminicraft.customenchant.enchants.utility;

import lombok.Getter;
import org.geminicraft.customenchant.betterenchants.BetterEnchants;
import org.geminicraft.customenchant.enchants.impl.*;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.Valid;
import org.mineacademy.fo.collection.StrictList;

import java.util.List;

public class BetterEnchantsRegister {

    @Getter
    private static final BetterEnchantsRegister instance = new BetterEnchantsRegister();
    private final StrictList<BetterEnchants> simpleEnchantments = new StrictList<>();

    private BetterEnchantsRegister() {
      add(new NewFancyEnchantment());
    }

    public void add(BetterEnchants enchantment) {
        simpleEnchantments.add(enchantment);
    }

    public BetterEnchants findEnchantment(String name) {
        Valid.checkNotNull(name);

        for (BetterEnchants enchantment : simpleEnchantments) {
            if (enchantment.getName().toLowerCase().equals(name.toLowerCase())) {
                return enchantment;
            }
        }

        return null;
    }

    public List<String> getEnchantmentNames() {
        return Common.convert(simpleEnchantments, BetterEnchants::getName);
    }
}


