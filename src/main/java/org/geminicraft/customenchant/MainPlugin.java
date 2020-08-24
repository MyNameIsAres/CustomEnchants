package org.geminicraft.customenchant;
import org.geminicraft.customenchant.commands.CustomEnchantmentCommand;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public class MainPlugin extends SimplePlugin {


    @Override
    protected void onPluginStart() {
        Common.log("Plugin is working!");

        registerCommand(new CustomEnchantmentCommand());
    }



}
