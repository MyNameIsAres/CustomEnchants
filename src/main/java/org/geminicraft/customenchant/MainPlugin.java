package org.geminicraft.customenchant;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public class MainPlugin extends SimplePlugin {


    @Override
    protected void onPluginStart() {
        Common.log("Plugin is working!");
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        Common.tellLater(2, player, "&3Hello World!!!!");


        player.getInventory().addItem(new ItemStack(Material.EMERALD, 5));

    }

}
