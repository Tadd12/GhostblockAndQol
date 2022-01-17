package com.example.examplemod.utils;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class Util {
	public void addMessage(ICommandSender p, String message, EnumChatFormatting c) {
		p.addChatMessage(new ChatComponentText(message).setChatStyle(new ChatStyle().setColor(c)));
	}
}
