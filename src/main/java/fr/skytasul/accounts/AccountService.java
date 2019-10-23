package fr.skytasul.accounts;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class AccountService {

	private Map<Player, Account> cachedAccounts = new HashMap<>();
	
	public Account getAccountForPlayer(Player p){
		Account acc = cachedAccounts.get(p);
		if (acc != null && acc.isCurrent()) return acc;
		acc = AccountsPlugin.accounts.getAccountForPlayer(p);
		cachedAccounts.put(p, acc);
		return acc;
	}

	public Account getAccountFromIdentifier(String identifier){
		int index = identifier.indexOf("|");
		String service = identifier.substring(0, identifier.indexOf("|"));
		if (!AccountsPlugin.accounts.getName().equals(service)){
			if (service.equals("UUIDAccounts")) return AccountsPlugin.accounts.createAccountFromUUID(UUID.fromString(identifier.substring(index + 1)));
			AccountsPlugin.getInstance().getLogger().severe("Cannot get the account with identifier \"" + identifier + "\": service " + service + " is not the service loaded.");
			return null;
		}
		return AccountsPlugin.accounts.getAccountFromIdentifier(identifier.substring(index + 1));
	}
	
	public Account createAccountFromUUID(UUID id){
		return AccountsPlugin.accounts.createAccountFromUUID(id);
	}
	
	public String getServiceName(){
		return AccountsPlugin.accounts.getName();
	}
	
	public void registerDataHook(String name, DataHook hook){
		AccountsPlugin.accounts.registerDataHook(name, hook);
	}
	
	public void callAccountUse(Player p, Account acc, boolean create) {
		Bukkit.getPluginManager().callEvent(new AccountUseEvent(p, acc, create));
	}

}
