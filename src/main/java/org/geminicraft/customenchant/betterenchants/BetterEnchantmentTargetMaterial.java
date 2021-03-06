package org.geminicraft.customenchant.betterenchants;

import org.bukkit.Material;

import java.util.HashSet;
import java.util.Set;

public class BetterEnchantmentTargetMaterial {

    /**
     * Create a set of materials that can be enchanted
     * for a particular SimpleEnchantment.
     *
     * @return
     */
    public static Set<Material> enchantMaterials() {
        return new HashSet<>();
    }

    /**
     * Add a material outside of the SimpleEnchantmentTarget
     * and EnchantmentTarget Enum options
     *
     * @return
     */
    public static Material enchantMaterial() {
        return null;
    }

}
