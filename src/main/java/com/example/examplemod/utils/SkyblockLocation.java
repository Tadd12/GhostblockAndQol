package com.example.examplemod.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.examplemod.Ghostblock_qol;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class SkyblockLocation {

	private static EntityPlayerSP player = Ghostblock_qol.player;

	public static boolean onSkyblock = false;
	public static boolean inDungeonHub = false;

	@SubscribeEvent
	public void onTick(ClientTickEvent e) {
		if(Ghostblock_qol.mc.theWorld != null) {
			onSkyblock = isOnSkyBlock();
			inDungeonHub = hasLine("Dungeon Hub");
		}
	}



	public static boolean isOnSkyBlock() {
		try {
			ScoreObjective titleObjective = player.getWorldScoreboard().getObjectiveInDisplaySlot(1);
			if (player.getWorldScoreboard().getObjectiveInDisplaySlot(0) != null)
				return ChatFormatting.stripFormatting(player.getWorldScoreboard().getObjectiveInDisplaySlot(0).getDisplayName()).contains("SKYBLOCK"); 
			return ChatFormatting.stripFormatting(player.getWorldScoreboard().getObjectiveInDisplaySlot(1).getDisplayName()).contains("SKYBLOCK");
		} catch (Exception e) {
			return false;
		} 
	}


	public static boolean hasLine(String line) {
		try {
			Scoreboard sb = (Minecraft.getMinecraft()).thePlayer.getWorldScoreboard();
			List<Score> list = new ArrayList<Score>(sb.getSortedScores(sb.getObjectiveInDisplaySlot(1)));
			for (Score score : list) {
				String s;
				ScorePlayerTeam team = sb.getPlayersTeam(score.getPlayerName());
				try {
					s = ChatFormatting.stripFormatting(team.getColorPrefix() + score.getPlayerName() + team.getColorSuffix());
				} catch (Exception e) {
					return false;
				} 
				StringBuilder builder = new StringBuilder();
				for (char c : s.toCharArray()) {
					if (c < (char)128)
						builder.append(c); 
				} 
				if (builder.toString().toLowerCase().contains(line.toLowerCase()))
					return true; 
				try {
					s = ChatFormatting.stripFormatting(team.getColorPrefix() + team.getColorSuffix());
				} catch (Exception e) {
					return false;
				} 
				builder = new StringBuilder();
				for (char c : s.toCharArray()) {
					if (c < (char)128)
						builder.append(c); 
				} 
				if (builder.toString().toLowerCase().contains(line.toLowerCase()))
					return true; 
			} 
		} catch (Exception e) {
			return false;
		} 
		return false;
	}

}
