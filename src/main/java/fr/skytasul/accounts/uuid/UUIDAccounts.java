package fr.skytasul.accounts.uuid;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import fr.skytasul.accounts.AbstractAccounts;
import fr.skytasul.accounts.Account;
import fr.skytasul.accounts.AccountsPlugin;

public class UUIDAccounts extends AbstractAccounts implements Listener {

	@Override
	public Account getAccountForPlayer(Player p) {
		return new UUIDAccount(p.getUniqueId());
	}

	@Override
	public Account getAccountFromIdentifier(String identifier) {
		return new UUIDAccount(UUID.fromString(identifier));
	}
	
	@Override
	public Account createAccountFromUUID(UUID id){
		return new UUIDAccount(id);
	}

	public void load() {
		Bukkit.getPluginManager().registerEvents(this, AccountsPlugin.getInstance());
	}

	public void unload() {
		HandlerList.unregisterAll(this);
	}

}
