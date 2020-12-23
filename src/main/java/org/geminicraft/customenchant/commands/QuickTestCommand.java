package org.geminicraft.customenchant.commands;

//import net.citizensnpcs.api.CitizensAPI;
//
////import net.citizensnpcs.api.ai.Goal;
////import net.citizensnpcs.api.ai.goals.TargetNearbyEntityGoal;
////import net.citizensnpcs.api.npc.NPC;
////import net.citizensnpcs.api.npc.NPCRegistry;
////import org.bukkit.entity.EntityType;
////import org.bukkit.entity.Player;
//import net.citizensnpcs.api.ai.Goal;
//import net.citizensnpcs.api.ai.goals.TargetNearbyEntityGoal;
//import net.citizensnpcs.api.npc.NPC;
//import net.citizensnpcs.api.npc.NPCRegistry;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.geminicraft.customenchant.enchants.MobRegistery;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.HashSet;
import java.util.Set;

public class QuickTestCommand extends SimpleCommand {

    public QuickTestCommand() {
        super("npctest");
    }

    @Override
    protected void onCommand() {
//        MobRegistery registery = MobRegistery.getInstance();
//        checkConsole();
//
//        Set<EntityType> testSet = new HashSet<>();
//        testSet.add(EntityType.ZOMBIE);
//
//
//        final Player player = getPlayer();
//        final NPCRegistry registry = CitizensAPI.getNPCRegistry();
//
//        final NPC npc = registry.createNPC(registery.getEntities().get(0), "Test");
//
//        npc.spawn(player.getTargetBlock(null, 5).getLocation().add(0, 1, 0));
//        npc.setProtected(false);
//
//        Goal goal = TargetNearbyEntityGoal.builder(npc)
//                .aggressive(true)
//                .radius(6) // May remove
//                .targets(testSet)
//                .build();
//
//        npc.getDefaultGoalController().addGoal(goal, 1);
    }
}
