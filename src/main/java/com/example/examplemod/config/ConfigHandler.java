package com.example.examplemod.config;

import java.io.File;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler  {
	public static Configuration config;

	public static int TERMINAL;
	public static boolean ACT;
	public static int MEMBERCOUNT = 5;

	public static void registerConfig(FMLPreInitializationEvent e) {
		LoadConfigSettings(new File(e.getModConfigurationDirectory() + "/Ghostblock qol/", "Settings.cfg"));
	}

	public static void LoadConfigSettings(File configFile)
	{
		ReadConfigSettings(configFile, true);
	}
	public static void SaveConfigSettings()
	{
		ReadConfigSettings(null, false);
	}


	private static void ReadConfigSettings(File configFile, boolean loadSettings){
		if(loadSettings)
		{
			config = new Configuration(configFile);
			config.load();
			try {
				
				TERMINAL = config.getCategory("act").get("Terminal").getInt();
				MEMBERCOUNT = config.getCategory("act").get("Member Count").getInt();
				ACT = config.getCategory("act").get("ACT Enabled").getBoolean();
				
			} catch(Exception e) {
				FMLLog.log(Level.FATAL, e, "Config failed to load");
			}
		}
		Property p;
		config.addCustomCategoryComment("act", "Auto Call Terminal Settings");
		p = config.get("act", "Terminal", 1);
		p.comment = "1->s1, 2->2b, 3->2t, 4->3, 5->4";
		p.set(TERMINAL);
		p = config.get("act", "ACT Enabled", false);
		p.comment = "If ACT is enabled";
		p.set(ACT);
		p= config.get("act", "Member Count", 5);
		p.comment = "At how many people act activates";
		p.set(MEMBERCOUNT);
		config.save();
	}

}
