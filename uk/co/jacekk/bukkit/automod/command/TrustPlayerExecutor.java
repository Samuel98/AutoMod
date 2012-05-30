package uk.co.jacekk.bukkit.automod.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import uk.co.jacekk.bukkit.automod.AutoMod;
import uk.co.jacekk.bukkit.baseplugin.BaseCommandExecutor;

public class TrustPlayerExecutor extends BaseCommandExecutor<AutoMod> {
	
	public TrustPlayerExecutor(AutoMod plugin){
		super(plugin);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if (sender.hasPermission("automod.admin.trustplayer") == false){
			plugin.messagePlayer(sender, ChatColor.RED + "You do not have permissions to use this command.");
			return true;
		}
		
		if (args.length != 1){
			plugin.messagePlayer(sender, ChatColor.AQUA + "Usage: /trustplayer [player_name]");
			plugin.messagePlayer(sender, ChatColor.AQUA + "Example: /trustplayer wide_load");
			return true;
		}
		
		String trustedName = args[0];
		
		plugin.blockedPlayers.remove(trustedName);
		
		if (plugin.trustedPlayers.contains(trustedName) == false){
			plugin.trustedPlayers.add(trustedName);
			plugin.playerDataManager.unregisterPlayer(trustedName);
		}
		
		plugin.messagePlayer(sender, ChatColor.GREEN + trustedName + " has been added to the trusted list.");
		
		return true;
	}
	
}
