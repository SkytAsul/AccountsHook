package fr.skytasul.accounts;

import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import fr.skytasul.accounts.uuid.UUIDAccounts;

public class AccountsPlugin extends JavaPlugin {
	
	static AbstractAccounts accounts = new UUIDAccounts();
	private static AccountsPlugin instance;
	
	private AccountService service;
	
	public void onEnable(){
		instance = this;
		getServer().getServicesManager().register(AccountService.class, service = new AccountService(), this, ServicePriority.Normal);
	}
	
	public static void registerAccountService(AbstractAccounts acc){
		String last = accounts.getName();
		accounts = acc;
		instance.getLogger().info("New accounts service registered. Last: " + last + " | New: " + accounts.getName());
	}
	
	public static AccountsPlugin getInstance(){
		return instance;
	}

	public AccountService getAccountService(){
		return service;
	}
	
}
