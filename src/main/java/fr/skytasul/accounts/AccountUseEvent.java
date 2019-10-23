package fr.skytasul.accounts;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class AccountUseEvent extends PlayerEvent {

	private Account account;

	public AccountUseEvent(Player who, Account account) {
		super(who);
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	private static final HandlerList handlers = new HandlerList();

}
