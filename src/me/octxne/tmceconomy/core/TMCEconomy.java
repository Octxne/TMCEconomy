package me.octxne.tmceconomy.core;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.octxne.tmceconomy.core.file.files.ConfigurationFile;
import me.octxne.tmceconomy.utilities.Printer;
import me.octxne.tmceconomy.utilities.type.PrinterType;

public class TMCEconomy extends JavaPlugin
{
	private static TMCEconomy instance;
	
	private String name, author;
	
	private double version;
	
	@Override
	public void onEnable()
	{
		this.setPlugin(this);
		this.setPluginName("TMCEconomy");
		this.setPluginAuthor("Octxne");
		this.setPluginVersion(0.1D);
		this.registerCommands();
		this.registerListeners();
		this.setupFiles();
		
		Printer.printToConsole("v" + this.getPluginVersion() + " developed by " + this.getPluginAuthor() + " has been enabled!", PrinterType.NORMAL);
	}
	
	@Override
	public void onDisable()
	{
		Printer.printToConsole("v" + this.getPluginVersion() + " developed by \"" + this.getPluginAuthor() + "\" has been disabled!", PrinterType.NORMAL);
		
		this.setPlugin(null);
	}
	
	public static TMCEconomy getInstance()
	{
		return instance;
	}
	
	public String getPluginName()
	{
		return this.name;
	}
	
	public String getPluginAuthor()
	{
		return this.author;
	}
	
	public double getPluginVersion()
	{
		return this.version;
	}
	
	public String getPrefix()
	{
		return ConfigurationFile.getFile().getConfiguration().getString("tmceconomy.settings.prefix");
	}
	
	public void setPlugin(TMCEconomy plugin)
	{
		instance = plugin;
	}
	
	public void setPluginName(String name)
	{
		this.name = name;
	}
	
	public void setPluginAuthor(String author)
	{
		this.author = author;
	}
	
	public void setPluginVersion(Double version)
	{
		this.version = version;
	}
	
	public void setPrefix(String prefix)
	{
		ConfigurationFile.getFile().getConfiguration().set("tmceconomy.settings.prefix", prefix);
		ConfigurationFile.getFile().saveConfiguration();
	}
	
	public void registerCommand(String name, CommandExecutor executor)
	{
		this.getCommand(name).setExecutor(executor);
	}
	
	public void registerListener(Listener listener)
	{
		this.getServer().getPluginManager().registerEvents(listener, this);
	}
	
	private void registerCommands()
	{
		
	}
	
	private void registerListeners()
	{
		
	}
	
	private void setupFiles()
	{
		ConfigurationFile.loadDefaults();
	}
}
