package org.geminicraft.customenchant.commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.geminicraft.customenchant.EnchantRegister;
import org.geminicraft.customenchant.enchants.utility.UtilityEnchants;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.TabUtil;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.model.SimpleEnchant;
import org.mineacademy.fo.model.SimpleEnchantment;

import java.util.ArrayList;
import java.util.List;

public class CustomEnchantmentCommand extends SimpleCommand {

    public CustomEnchantmentCommand() {
        super("cemenchant|ce");
        setUsage("/ge <enchantment>");
    }

    @Override
    protected void onCommand() {
        Common.log("LOOOOL");
        final Player player = getPlayer();

        final String param = args[0].toLowerCase();

        final String enchantName = Common.joinRange(1, args);
        Common.log("This is param " + param);
        Common.log("This is enchantName " + enchantName);
        final EnchantRegister enchantRegister = EnchantRegister.getInstance();
        final SimpleEnchantment enchantment = enchantRegister.findEnchantment(enchantName);
//        Common.log(enchantment.toString() + " I am the enchantment test!");


        ItemStack testItem = player.getInventory().getItemInMainHand();
        testItem.addEnchantment(new SimpleEnchant(enchantment).getEnchant(), 1);
        UtilityEnchants.addEnchantmentLore(testItem);


        Common.log("I am a test item" + testItem);

        // TODO: Create enchantment books, probably in a different command or class.
        // TODO Consider creating flags for items

        tell("&6You were given items with custom enchantments");


    }

    @Override
    protected List<String> tabComplete() {
        if (args.length > 1) {
            final String enchantName = Common.joinRange(0, args);
            Common.log("If checks out");

            return TabUtil.complete(enchantName, EnchantRegister.getInstance().getEnchantmentNames());
        }

        Common.log("If does not check out");
        return new ArrayList<>();
    }
}

