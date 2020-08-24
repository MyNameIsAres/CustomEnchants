package org.geminicraft.customenchant.commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.customenchant.EnchantRegister;
import org.geminicraft.customenchant.enchants.utility.UtilityEnchants;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.model.SimpleEnchant;
import org.mineacademy.fo.model.SimpleEnchantment;

public class CustomEnchantmentCommand extends SimpleCommand {

    public CustomEnchantmentCommand() {
        super("gemenchant|ge");
        setUsage("/ge <enchantment>");
    }

    @Override
    protected void onCommand() {
        final Player player = getPlayer();

        final String param = args[0].toLowerCase();
        Common.log("This is param 1 " + param);
        final EnchantRegister enchantRegister = EnchantRegister.getInstance();
        final SimpleEnchantment enchantment = enchantRegister.findEnchantment(param);


        ItemStack testItem = player.getInventory().getItemInMainHand();
        testItem.addEnchantment(new SimpleEnchant(enchantment).getEnchant(), 1);
        UtilityEnchants.addEnchantmentLore(testItem);


        Common.log("I am a test item" + testItem);

        // TODO: Create enchantment books, probably in a different command or class.
        // TODO Consider creating flags for items

        tell("&6You were given items with custom enchantments");




    }
}

