package com.example.examplemod;

import com.example.examplemod.commands.AutoCallTermCommand;
import com.example.examplemod.config.ConfigHandler;
import com.example.examplemod.feature.AutoCallTerm;
import com.example.examplemod.feature.Ghostblocks;
import com.example.examplemod.utils.SkyblockLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Ghostblock_qol.MODID, version = Ghostblock_qol.VERSION, clientSideOnly = true, acceptedMinecraftVersions = "[1.8.9]")
public class Ghostblock_qol
{
	public static final Minecraft mc = Minecraft.getMinecraft();
	public static final EntityPlayerSP player = mc.thePlayer;
	public static final String MODID = "ghost_blocks";
	public static final String VERSION = "1.0.0";
	public static KeyBinding[] keyBindings = new KeyBinding[1];

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		ConfigHandler.registerConfig(e);
	}
	
	
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new SkyblockLocation());
		MinecraftForge.EVENT_BUS.register(new Ghostblocks());
		MinecraftForge.EVENT_BUS.register(new AutoCallTerm());
		ClientCommandHandler.instance.registerCommand(new AutoCallTermCommand());

		keyBindings[0] = new KeyBinding("Ghost Block Bind", 34, "Ghostblock and Qol");
		for (KeyBinding keyBinding : keyBindings)
			ClientRegistry.registerKeyBinding(keyBinding);
	}






}
