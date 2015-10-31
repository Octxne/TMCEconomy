package me.octxne.tmceconomy.core.file;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.octxne.tmceconomy.core.TMCEconomy;

public class Filer
{
	private File file;

	private FileConfiguration configuration;

	public Filer(String fileName)
	{
		if (!TMCEconomy.getInstance().getDataFolder().exists())
		{
			TMCEconomy.getInstance().getDataFolder().mkdir();
		}
		
		this.file = new File(TMCEconomy.getInstance().getDataFolder(), fileName);

		if (!this.getFile().exists())
		{
			try
			{
				this.getFile().createNewFile();
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}
		}

		this.configuration = YamlConfiguration.loadConfiguration(this.getFile());
	}

	public File getFile()
	{
		return this.file;
	}
	
	public FileConfiguration getConfiguration()
	{
		return this.configuration;
	}

	public void saveConfiguration()
	{
		try
		{
			this.getConfiguration().save(this.getFile());
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	public void reloadConfiguration()
	{
		this.configuration = YamlConfiguration.loadConfiguration(this.getFile());
	}
	
	public void addDefault(String path, Object value)
	{
		if (!this.getConfiguration().contains(path))
		{
			this.getConfiguration().set(path, value);
			this.saveConfiguration();
		}
	}
}
