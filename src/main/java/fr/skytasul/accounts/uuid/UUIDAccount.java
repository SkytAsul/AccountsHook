package fr.skytasul.accounts.uuid;

import fr.skytasul.accounts.Account;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import java.util.UUID;

public class UUIDAccount extends Account {

	protected UUID id;

	protected UUIDAccount(UUIDAccountsProvider provider, UUID id) {
		super(provider);
		this.id = id;
	}

	@Override
	public OfflinePlayer getOfflinePlayer() {
		return Bukkit.getOfflinePlayer(id);
	}

	@Override
	public String getAccountIdentifier() {
		return id.toString();
	}

	@Override
	public boolean isCurrent() {
		return getOfflinePlayer().isOnline();
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UUIDAccount uuidAccount)
			return id.equals(uuidAccount.id);
		return false;
	}

}
