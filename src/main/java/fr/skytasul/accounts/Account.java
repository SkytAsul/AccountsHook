package fr.skytasul.accounts;

import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.Optional;

public abstract class Account {

	private final @NotNull AccountsProvider provider;

	protected Account(@NotNull AccountsProvider provider) {
		this.provider = provider;
	}

	/**
	 * @return the OfflinePlayer instance attached to this account (no matter if the player is online or
	 *         not, or if the account is the one currently being used)
	 */
	public abstract @NotNull OfflinePlayer getOfflinePlayer();

	/**
	 * @return the Player instance who own this account. If the account is not which in use by the player ({@link #isCurrent()}), this will return null.
	 */
	public final @NotNull Optional<Player> getPlayer() {
		if (!isCurrent())
			return Optional.empty();
		return Optional.of(getOfflinePlayer().getPlayer());
	}

	/**
	 * @return if this account is currently used by the player (if true, {@link #getPlayer()} cannot return a null player)
	 */
	public abstract boolean isCurrent();

	public @NotNull AccountsProvider getProvider() {
		return provider;
	}

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract int hashCode();

	protected abstract @NotNull String getAccountIdentifier();

	@SuppressWarnings("deprecation")
	public final @NotNull NamespacedKey getIdentifier() {
		return new NamespacedKey(provider.getName(), getAccountIdentifier());
	}

}
