package com.example.examplemod.commands;

import com.example.examplemod.config.ConfigHandler;
import com.example.examplemod.utils.Util;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
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
		Util u = new Util();
		if(args.length > 1) {
			u.addMessage(sender, "/act [s1, 2b, 2t, 3, 4]", EnumChatFormatting.DARK_RED);
		}
		if(args.length == 0) {
			ConfigHandler.ACT = !ConfigHandler.ACT;
			if(ConfigHandler.ACT) {
				u.addMessage(sender, "ACT enabled", EnumChatFormatting.GREEN);
			} else {
				u.addMessage(sender, "ACT disabled", EnumChatFormatting.RED);
			}
		} else {
			args[0] = args[0].toLowerCase();
			if(args[0].contentEquals("help")) {
				u.addMessage(sender, "ACT Help:", EnumChatFormatting.GREEN);
				u.addMessage(sender, "- /act to toggle", EnumChatFormatting.GREEN);
				u.addMessage(sender, "- /act [s1, 2b, 2t, 3, 4] to set the Terminal", EnumChatFormatting.GREEN);
				u.addMessage(sender, "- /act help to show this", EnumChatFormatting.GREEN);
				return;
			}
			if(args[0].equals("s1")) {
				ConfigHandler.TERMINAL = 1;
				u.addMessage(sender, "Terminal set to " + args[0], EnumChatFormatting.GREEN);
			} else if(args[0].equals("2b")) {
				ConfigHandler.TERMINAL = 2;
				u.addMessage(sender, "Terminal set to " + args[0], EnumChatFormatting.GREEN);
			} else if(args[0].equals("2t")) {
				ConfigHandler.TERMINAL = 3;
				u.addMessage(sender, "Terminal set to " + args[0], EnumChatFormatting.GREEN);
			} else if(args[0].equals("3")) {
				ConfigHandler.TERMINAL = 4;
				u.addMessage(sender, "Terminal set to " + args[0], EnumChatFormatting.GREEN);
			} else if(args[0].equals("4")) {
				ConfigHandler.TERMINAL = 5;
				u.addMessage(sender, "Terminal set to " + args[0], EnumChatFormatting.GREEN);
			} else {
				u.addMessage(sender, "/act [s1, 2b, 2t, 3, 4]", EnumChatFormatting.DARK_RED);
			}
		}
		ConfigHandler.SaveConfigSettings();
		
	}

}
