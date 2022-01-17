package com.example.examplemod.feature;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.examplemod.Ghostblock_qol;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Ghostblocks {
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START) {
            return;
        }
        Minecraft mc = Minecraft.getMinecraft();
        WorldClient worldClient = mc.theWorld;
        EntityPlayerSP player = mc.thePlayer;
        if (Ghostblock_qol.keyBindings[0].isKeyDown()) {
            if (mc.objectMouseOver.getBlockPos() == null)
                return;
            Block block = (Minecraft.getMinecraft()).theWorld.getBlockState(mc.objectMouseOver.getBlockPos()).getBlock();
            ArrayList<Block> interactables = new ArrayList<Block>(Arrays.asList(new Block[] {
                    Blocks.acacia_door, Blocks.anvil, (Block)Blocks.beacon, Blocks.bed, Blocks.birch_door, Blocks.brewing_stand, Blocks.command_block, Blocks.crafting_table, (Block)Blocks.chest, Blocks.dark_oak_door,
                    (Block)Blocks.daylight_detector, (Block)Blocks.daylight_detector_inverted, Blocks.dispenser, Blocks.dropper, Blocks.enchanting_table, Blocks.ender_chest, Blocks.furnace, (Block)Blocks.hopper, Blocks.jungle_door, Blocks.lever,
                    Blocks.noteblock, (Block)Blocks.powered_comparator, (Block)Blocks.unpowered_comparator, (Block)Blocks.powered_repeater, (Block)Blocks.unpowered_repeater, Blocks.standing_sign, Blocks.wall_sign, Blocks.trapdoor, Blocks.trapped_chest, Blocks.wooden_button,
                    Blocks.stone_button, Blocks.oak_door, (Block)Blocks.skull }));
            if (!interactables.contains(block))
                worldClient.setBlockToAir(mc.objectMouseOver.getBlockPos());
        }

    }
}
