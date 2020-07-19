package fr.skytasul.accounts.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import fr.skytasul.accounts.Account;

public class AccountUseEvent extends AccountEvent {

	private boolean create;

	public AccountUseEvent(Player who, Account account, boolean create) {
		super(who);
		this.account = account;
		this.create = create;
	}

	public boolean isAccountCreated() {
		return create;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	private static final HandlerList handlers = new HandlerList();

}
