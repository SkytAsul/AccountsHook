package fr.skytasul.accounts;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.Optional;

public interface AccountsProvider {

	public @NotNull String getName();

	public @NotNull Optional<Account> getFromIdentifier(@NotNull NamespacedKey identifier);

	public @NotNull Account getCurrentAccount(@NotNull Player p);

	public @NotNull Collection<@NotNull Account> getAllAccounts(@NotNull OfflinePlayer player);

	public default boolean isDefaultProvider() {
		return Bukkit.getServicesManager().load(AccountsProvider.class) == this;
	}

}
