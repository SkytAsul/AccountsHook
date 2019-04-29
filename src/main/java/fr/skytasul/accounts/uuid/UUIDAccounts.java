package fr.skytasul.accounts.uuid;

import java.util.UUID;

import org.bukkit.entity.Player;

import fr.skytasul.accounts.AbstractAccounts;
import fr.skytasul.accounts.Account;

public class UUIDAccounts extends AbstractAccounts {

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

}
