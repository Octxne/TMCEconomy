package me.octxne.tmceconomy.core.file.files;

import me.octxne.tmceconomy.core.TMCEconomy;
import me.octxne.tmceconomy.core.file.Filer;

public class ConfigurationFile
{
	private static Filer file = new Filer("config.yml");
	
	public static Filer getFile()
	{
		return file;
	}
	
	public static void loadDefaults()
	{
		getFile().addDefault("tmceconomy.settings.prefix", "[" + TMCEconomy.getInstance().getPluginName() + "]");
	}
}
