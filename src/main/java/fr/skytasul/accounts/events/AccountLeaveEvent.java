package fr.skytasul.accounts.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import fr.skytasul.accounts.Account;

public class AccountLeaveEvent extends AccountEvent {

	public AccountLeaveEvent(Player who, Account account) {
		super(who);
		this.account = account;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	private static final HandlerList handlers = new HandlerList();

}
