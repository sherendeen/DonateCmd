package com.inivican.donateCmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class CmdExecutor implements CommandExecutor {

	private DonateCmdPlugin pluginEntrant;
	private String donationMsgLocation = "donation.yml";
	
	
	public CmdExecutor() {
		//donationMessageObj.setFileConfiguration(OurMessage.Read(this.donationMsgLocation, pluginEntrant));
	}
	
	public CmdExecutor(DonateCmdPlugin pluginEntrant) {
		this.pluginEntrant = pluginEntrant;
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command cmd, String arg2, String[] arg3) {
		
		String command = cmd.getName().toLowerCase();
		
		switch(command) {
		
		case "donate":
			return executeDonateCommand(commandSender);
			
		
		}
		
		
		return false;
	}

	private boolean executeDonateCommand(CommandSender sender) {
		sender.sendMessage(FileManagerRegistrar.messageStorageFileManager.getFileConfiguration().getString("Message"));
		return true;
	}
	
}
