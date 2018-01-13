package com.akaiha.sync;

import com.akaiha.sync.command.SyncCommand;

import net.md_5.bungee.api.plugin.Plugin;

public class Sync extends Plugin {
	
	private SyncCommand sc;

	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, sc = new SyncCommand(this));
	}

	public void onDisable() {
		getProxy().getPluginManager().unregisterCommand(sc);
	}
}