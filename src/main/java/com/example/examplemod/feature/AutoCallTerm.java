package com.example.examplemod.feature;

import com.example.examplemod.Ghostblock_qol;
import com.example.examplemod.config.ConfigHandler;
import com.example.examplemod.utils.SkyblockLocation;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoCallTerm {
	@SubscribeEvent
	public void onMessage(ClientChatReceivedEvent event){
		String Message = event.message.getUnformattedText();
		if(ConfigHandler.ACT) {
			if(Message.contains("Dungon Finder") || Message.contains("joined the")) {
				Ghostblock_qol.mc.thePlayer.sendChatMessage("/pl");
			}
			if(Message.contains("Party Members (")) {
				int members = 0;
				for(char m : Message.toCharArray()) {
					try {
						members = Integer.parseInt(""+m);
						break;
					} catch(Exception e) {}
				}
				if(members == ConfigHandler.MEMBERCOUNT && SkyblockLocation.inDungeonHub) {
					String term = "";
					switch(ConfigHandler.TERMINAL) {
					case 1:
						term = "s1";
						break;
					case 2:
						term = "2b";
						break;
					case 3:
						term = "2t";
						break;
					case 4:
						term = "3";
						break;
					case 5:
						term = "4";
						break;
					}
					if(!term.equals("")) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {}
						Ghostblock_qol.mc.thePlayer.sendChatMessage("/pc " + term);
					}
				}
			}
		}
	}
}
