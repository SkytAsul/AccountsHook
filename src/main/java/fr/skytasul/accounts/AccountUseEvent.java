package fr.skytasul.accounts;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class AccountUseEvent extends PlayerEvent {

	private Account account;
	private boolean create;

	public AccountUseEvent(Player who, Account account, boolean create) {
		super(who);
		this.account = account;
		this.create = create;
	}

	public Account getAccount() {
		return account;
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
