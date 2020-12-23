package org.geminicraft.customenchant.commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.customenchant.betterenchants.BetterEnchants;
import org.geminicraft.customenchant.enchants.utility.BetterEnchantsRegister;
import org.geminicraft.customenchant.enchants.utility.UtilityEnchants;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.model.SimpleEnchant;

public class BetterEnchantsCommand extends SimpleCommand {
    public BetterEnchantsCommand() {
        super("tec");
    }

    @Override
    protected void onCommand() {
        checkConsole();

        final Player player = getPlayer();
        final String enchantName = Common.joinRange(0, args);
        final BetterEnchantsRegister enchantRegister = BetterEnchantsRegister.getInstance();
        final BetterEnchants enchantment = enchantRegister.findEnchantment(enchantName);
        final ItemStack itemInMainHand = player.getInventory().getItemInMainHand();


        if (enchantment.getCustomItemTarget().includes(itemInMainHand)) {
            itemInMainHand.addEnchantment(new SimpleEnchant(enchantment).getEnchant(), 1);
            UtilityEnchants.addEnchantmentLore(itemInMainHand);
            tell("&6You were given items with custom enchantments");
        }
        else if (enchantment.enchantMaterial().equals(itemInMainHand.getType())) {
            itemInMainHand.addEnchantment(new SimpleEnchant(enchantment).getEnchant(), 1);
            UtilityEnchants.addEnchantmentLore(itemInMainHand);
            tell("&8You were given items with custom enchantments second");
        }
        else {
            tell("&6Enchantment can't be applied to this (/these) item(s)");
        }
    }
}
