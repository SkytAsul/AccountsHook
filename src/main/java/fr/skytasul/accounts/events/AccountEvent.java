package fr.skytasul.accounts.events;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

import fr.skytasul.accounts.Account;

public abstract class AccountEvent extends PlayerEvent {
	
	protected Account account;

	public AccountEvent(Player who) {
		super(who);
	}

	public Account getAccount() {
		return account;
	}
	
}