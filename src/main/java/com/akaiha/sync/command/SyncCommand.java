package com.akaiha.sync.command;

import com.akaiha.core.data.network.Transmit;
import com.akaiha.sync.Sync;
import com.google.gson.JsonObject;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class SyncCommand extends Command {
	
	private Sync plugin;
	
	public SyncCommand(Sync plugin) {
		super("sync");
		this.plugin = plugin;
	}

	@Override
	public void execute(final CommandSender sender, final String[] args) {
		if (sender.hasPermission("sync") && args.length > 1) {
			plugin.getProxy().getScheduler().runAsync(plugin, new Runnable() {
	            @Override
	            public void run() {
	            	String command = "";
	            	for (int i = 1; i < args.length; i++) {
	            		command += args[i] + " ";
	            	}
	            	JsonObject jObj = new JsonObject();
	            	jObj.addProperty("channel", "sync");
	            	jObj.addProperty("command", command);
	            	Transmit.send(plugin.getProxy().getServerInfo(args[0]), jObj);
	        		sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&6Sync Command Sent!")));
	            }
			});
		}
	}
}