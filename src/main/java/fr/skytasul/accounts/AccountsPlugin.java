package fr.skytasul.accounts;

import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import fr.skytasul.accounts.uuid.UUIDAccounts;

public class AccountsPlugin extends JavaPlugin {
	
	static AbstractAccounts accounts = null;
	private static AccountsPlugin instance;
	
	private AccountService service;
	
	public void onEnable(){
		instance = this;
		accounts = new UUIDAccounts();
		accounts.load();
		getServer().getServicesManager().register(AccountService.class, service = new AccountService(), this, ServicePriority.Normal);
	}
	
	public void onDisable(){
		accounts.unload();
		getServer().getServicesManager().unregister(service);
	}
	
	public static void registerAccountService(AbstractAccounts acc){
		if (accounts == null) throw new IllegalStateException("Plugin is not enabled.");
		String last = accounts.getName();
		accounts.unload();
		accounts = acc;
		accounts.load();
		instance.getLogger().info("New accounts service registered. Last: " + last + " | New: " + accounts.getName());
	}
	
	public static AccountsPlugin getInstance(){
		return instance;
	}

	public AccountService getAccountService(){
		return service;
	}
	
}
