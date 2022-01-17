package com.example.examplemod.commands;

import com.example.examplemod.config.ConfigHandler;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class AutoCallTermCommand extends CommandBase{

	@Override
	public int getRequiredPermissionLevel()
    {
        return 0;
    } 
	
	
	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "act";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/act [s1, 2b, 2t, 3, 4]";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if(args.length > 1) {
			sender.addChatMessage(new ChatComponentText("/act [s1, 2b, 2t, 3, 4]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED)));
		}
		if(args.length == 0) {
			ConfigHandler.ACT = !ConfigHandler.ACT;
			if(ConfigHandler.ACT) {
				sender.addChatMessage(new ChatComponentText("ACT enabled").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
			} else {
				sender.addChatMessage(new ChatComponentText("ACT disabled").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
			}
		} else {
			args[0] = args[0].toLowerCase();
			if(args[0].equals("s1")) {
				ConfigHandler.TERMINAL = 1;
				sender.addChatMessage(new ChatComponentText("Terminal set to " + args[0]).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
			} else if(args[0].equals("2b")) {
				ConfigHandler.TERMINAL = 2;
				sender.addChatMessage(new ChatComponentText("Terminal set to " + args[0]).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
			} else if(args[0].equals("2t")) {
				ConfigHandler.TERMINAL = 3;
				sender.addChatMessage(new ChatComponentText("Terminal set to " + args[0]).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
			} else if(args[0].equals("3")) {
				ConfigHandler.TERMINAL = 4;
				sender.addChatMessage(new ChatComponentText("Terminal set to " + args[0]).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
			} else if(args[0].equals("4")) {
				ConfigHandler.TERMINAL = 5;
				sender.addChatMessage(new ChatComponentText("Terminal set to " + args[0]).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
			} else {
				sender.addChatMessage(new ChatComponentText("/act [s1, 2b, 2t, 3, 4]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_RED)));
			}
		}
		ConfigHandler.SaveConfigSettings();
		
	}

}
