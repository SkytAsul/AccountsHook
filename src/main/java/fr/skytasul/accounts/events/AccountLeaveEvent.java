package fr.skytasul.accounts.events;

import fr.skytasul.accounts.Account;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AccountLeaveEvent extends AccountEvent {

	public AccountLeaveEvent(@NotNull Player who, @NotNull Account account) {
		super(who, account);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	private static final HandlerList handlers = new HandlerList();

}
