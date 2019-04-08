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
		//first certify that the command sender has adequate permission
		if (commandSender.hasPermission("vdg")) {
			
			String cmdNameStr = cmd.getName().toLowerCase();
			
			if (cmdNameStr.equals("donate")) {
				commandSender.sendMessage(FileManagerRegistrar.messageStorageFileManager.getFileConfiguration().getString("Message") );
				return true;
			}
			
		}
		
		return false;
	}
	
}
