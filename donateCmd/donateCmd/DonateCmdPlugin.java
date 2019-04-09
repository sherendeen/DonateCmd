package com.inivican.donateCmd;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandExecutor;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class DonateCmdPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Hello World from DonateCmdPlugin");
		
		this.getCommand("donate").setExecutor(new CmdExecutor(this));
		//prepareCommandExecution();
		
		FileManagerRegistrar.messageStorageFileManager = new FileManagement(new File(this.getDataFolder(),
				"messageStorage.yml"),"messageStorage.yml");
		FileManagerRegistrar.messageStorageFileManager.createConfigurationFile();
		FileManagerRegistrar.messageStorageFileManager.saveConfigFile();
		
		
		
		
	}
	
	@Override
	public void onDisable() {
		getLogger().info("We are now disabled. :(");
	}
	
	public void prepareCommandExecution() {
		
		//this.getCommand("vdg").setExecutor(new CmdExecutor());
		this.getCommand("donate").setExecutor(new CmdExecutor(this));
	}
	
}
