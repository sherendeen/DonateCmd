package com.inivican.donateCmd;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManagement {

	private DonateCmdPlugin main;
	private String fileName = "config.yml";
	private File file;//the configuration file
	private FileConfiguration fileConfiguration;
	
	
	public FileManagement() {
		this.file = new File(this.main.getDataFolder(),this.fileName);
		this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileManagement(File file, String fileName) {
		this.file = file;
		this.fileName = fileName;
	}
	
	public FileManagement(File file, DonateCmdPlugin main,String fileName) {
		this.file = file;
		this.main = main;
		this.fileName = fileName;
	}
	
	public FileManagement(String fileName) {
		this.file = new File(this.main.getDataFolder(),fileName);
		this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getFileConfiguration() {
		return this.fileConfiguration;
	}
	
	public File getConfigFile() {
		return this.file;
	}
	
	public void setFileConfiguration(FileConfiguration fileConfiguration) {
		this.fileConfiguration = fileConfiguration;
	}
	
	public void saveConfigFile() {
		if(this.fileConfiguration == null || this.file == null) {
			return;
		}
		
		try {
			getFileConfiguration().save(file);
		} catch (IOException ioe) {
			this.main.getLogger().log(Level.SEVERE,"Could not save config to " + file , ioe );
		}
	}
	
	public void reloadConfigFile() {
		if(file == null) {
			file = new File(main.getDataFolder(),fileName);
		}
		
		fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}
	
	public void createConfigurationFile() {
		if(this.file == null) {
			this.file = new File(this.main.getDataFolder(),fileName);
			resetConfigInTheFile();
		}
		this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
		//resetConfigInTheFile();
	}
	
	public void resetConfigInTheFile() {
		this.fileConfiguration.createSection("Message");
		this.getFileConfiguration().getConfigurationSection("Message").set("Text", "Example Text Telling You Where To Donate");
	}
	
	public void createConfigurationFile(File file, FileConfiguration fileConfiguration, String fileName) {
		file = new File(this.main.getDataFolder(), fileName);
		fileConfiguration = YamlConfiguration.loadConfiguration(file);
		//resetConfigInTheFile();
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
}
