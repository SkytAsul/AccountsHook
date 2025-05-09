package fr.skytasul.accounts;

import fr.skytasul.accounts.uuid.UUIDAccountsProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class AccountsPlugin extends JavaPlugin {

	private UUIDAccountsProvider uuidProvider = new UUIDAccountsProvider();

	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(uuidProvider, this);
		getServer().getServicesManager().register(AccountsProvider.class, uuidProvider, this, ServicePriority.Lowest);

		getLogger().info("Registered default accounts provider: uuid");
	}

	@Override
	public void onDisable(){
		getServer().getServicesManager().unregister(uuidProvider);
	}

}
