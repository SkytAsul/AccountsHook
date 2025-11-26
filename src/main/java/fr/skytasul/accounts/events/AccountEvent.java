package fr.skytasul.accounts.events;

import fr.skytasul.accounts.Account;
import fr.skytasul.accounts.AccountsProvider;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public abstract class AccountEvent extends PlayerEvent {

	protected final @NotNull Account account;

	public AccountEvent(@NotNull Player who, @NotNull Account account) {
		super(who);
		this.account = Objects.requireNonNull(account);
	}

	public @NotNull Account getAccount() {
		return account;
	}

	/**
	 * Utility method to test if the account returned by {@link #getAccount()} is owned by the main
	 * account provider
	 *
	 * @return wether or not the subject of this event is owned by the main account provider
	 * @see AccountsProvider#isDefaultProvider()
	 */
	public boolean isFromDefaultProvider() {
		return account.getProvider().isDefaultProvider();
	}

}