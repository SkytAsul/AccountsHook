package fr.skytasul.accounts;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import fr.skytasul.accounts.events.AccountJoinEvent;
import fr.skytasul.accounts.events.AccountLeaveEvent;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public abstract class AbstractAccountsProvider implements AccountsProvider {

	private final @NotNull String name;

	private final @NotNull Cache<Player, Account> playersCache =
			CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();

	protected AbstractAccountsProvider(@NotNull String name) {
		this.name = name;
	}

	@Override
	public @NotNull String getName() {
		return name;
	}

	@Override
	public @NotNull Account getCurrentAccount(@NotNull Player p) {
		var account = playersCache.getIfPresent(p);
		if (account == null || !account.isCurrent()) {
			account = Objects.requireNonNull(getCurrentAccountInternal(p));
			playersCache.put(p, account);
		}
		return account;
	}

	protected abstract @NotNull Account getCurrentAccountInternal(@NotNull Player p);

	@Override
	public @NotNull Optional<Account> getFromIdentifier(@NotNull NamespacedKey identifier) {
		if (!identifier.getNamespace().equals(name))
			throw new IllegalArgumentException("Wrong identifier: " + identifier.getNamespace());
		return getFromIdentifierInternal(identifier.getKey());
	}

	protected abstract @NotNull Optional<Account> getFromIdentifierInternal(@NotNull String accountIdentifier);

	protected void callAccountJoin(@NotNull Player p, @NotNull Account acc, boolean create) {
		Bukkit.getPluginManager().callEvent(new AccountJoinEvent(p, acc, create));
	}

	protected void callAccountLeave(@NotNull Player p, @NotNull Account acc) {
		Bukkit.getPluginManager().callEvent(new AccountLeaveEvent(p, acc));
	}

}
