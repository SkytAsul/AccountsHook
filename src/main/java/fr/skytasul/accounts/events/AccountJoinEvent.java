package fr.skytasul.accounts.events;

import fr.skytasul.accounts.Account;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AccountJoinEvent extends AccountEvent {

	private boolean create;

	public AccountJoinEvent(@NotNull Player who, @NotNull Account account, boolean create) {
		super(who, account);
		this.create = create;
	}

	public boolean isAccountCreated() {
		return create;
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
