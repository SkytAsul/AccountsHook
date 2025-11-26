package fr.skytasul.accounts;

import fr.skytasul.accounts.uuid.UUIDAccountsProvider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServiceRegisterEvent;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class AccountsPlugin extends JavaPlugin implements Listener {

	private UUIDAccountsProvider uuidProvider = new UUIDAccountsProvider();

	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);

		getServer().getPluginManager().registerEvents(uuidProvider, this);
		getServer().getServicesManager().register(AccountsProvider.class, uuidProvider, this, ServicePriority.Lowest);
	}

	@Override
	public void onDisable(){
		getServer().getServicesManager().unregister(uuidProvider);
	}

	@EventHandler
	public void onServiceRegistered(ServiceRegisterEvent event) {
		if (event.getProvider().getProvider() instanceof AccountsProvider accountsProvider) {
			getLogger().info("Registered accounts provider %s with priority %s".formatted(accountsProvider.getName(),
					event.getProvider().getPriority().name()));
		}
	}

}
