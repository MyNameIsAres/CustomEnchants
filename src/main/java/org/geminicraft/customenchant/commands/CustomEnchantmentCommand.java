package org.geminicraft.customenchant.commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.customenchant.enchants.utility.EnchantRegister;
import org.geminicraft.customenchant.enchants.utility.UtilityEnchants;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.TabUtil;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.model.SimpleEnchant;
import org.mineacademy.fo.model.SimpleEnchantment;

import java.util.*;

public class CustomEnchantmentCommand extends SimpleCommand {

    public CustomEnchantmentCommand() {
        super("cemenchant|ce");
        setUsage("/ge <enchantment>");
        setMinArguments(1);
    }

    @Override
    protected void onCommand() {
        checkConsole();
        final Player player = getPlayer();
        final String enchantName = Common.joinRange(0, args);
        Common.log(enchantName + " I am the enchantName variable");

        final EnchantRegister enchantRegister = EnchantRegister.getInstance();
        final SimpleEnchantment enchantment = enchantRegister.findEnchantment(enchantName);

        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

        if (enchantRegister.findEnchantment(enchantName).getItemTarget().includes(itemInMainHand)) {
            itemInMainHand.addEnchantment(new SimpleEnchant(enchantment).getEnchant(), 1);
            UtilityEnchants.addEnchantmentLore(itemInMainHand);
            tell("&6You were given items with custom enchantments");
        } else {
            tell("&6Enchantment can't be applied to this (/these) item(s)");
        }
    }

    @Override
    protected List<String> tabComplete() {
        if (args.length >= 1) {
            final String enchantName = Common.joinRange(0, args);
            return TabUtil.complete(enchantName, EnchantRegister.getInstance().getEnchantmentNames());
        }

        return new ArrayList<>();
    }
}

