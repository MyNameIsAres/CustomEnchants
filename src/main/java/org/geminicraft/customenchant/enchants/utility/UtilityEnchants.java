package org.geminicraft.customenchant.enchants.utility;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geminicraft.customenchant.betterenchants.BetterEnchants;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleEnchantment;

import java.util.*;

public class UtilityEnchants {
    // Copied method from SimpleEnchantments class
    public static ItemStack addEnchantmentLore(ItemStack item) {
        final List<String> customEnchants = new ArrayList<>();

        // Fill in our enchants
        for (final Map.Entry<Enchantment, Integer> e : item.getEnchantments().entrySet())
            if (e.getKey() instanceof SimpleEnchantment) {
                final String lore = ((SimpleEnchantment) e.getKey()).getLore(e.getValue());

                if (lore != null && !lore.isEmpty())
                    customEnchants.add(Common.colorize("&r&7" + lore));
            } else if (e.getKey() instanceof BetterEnchants) {
                final String lore = ((BetterEnchants) e.getKey()).getLore(e.getValue());
                if (lore != null && !lore.isEmpty())
                    customEnchants.add(Common.colorize("&r&7" + lore));
            }

        if (!customEnchants.isEmpty()) {
            final ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
            final List<String> originalLore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            final List<String> finalLore = new ArrayList<>();

            final List<String> colorlessOriginals = new ArrayList<>();

            for (final String original : originalLore)
                colorlessOriginals.add(ChatColor.stripColor(Common.colorize(original)));

            // Place our enchants
            for (final String customEnchant : customEnchants) {
                final String colorlessEnchant = ChatColor.stripColor(Common.colorize(customEnchant));

                if (!colorlessOriginals.contains(colorlessEnchant))
                    finalLore.add(customEnchant);
            }

            // Place the original lore at the bottom
            finalLore.addAll(originalLore);

            // Set the lore
            meta.setLore(finalLore);

            // Update the item stack
            item.setItemMeta(meta);

            Common.log("This runs");

            return item;
        }

        Common.log("Do we return null?");

        return null;
    }

}
