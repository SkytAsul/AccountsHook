package fr.skytasul.accounts.uuid;

import fr.skytasul.accounts.AbstractAccountsProvider;
import fr.skytasul.accounts.Account;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UUIDAccountsProvider extends AbstractAccountsProvider implements Listener {

	public UUIDAccountsProvider() {
		super("uuid");
	}

	@Override
	public @NotNull Collection<@NotNull Account> getAllAccounts(@NotNull OfflinePlayer player) {
		return List.of(new UUIDAccount(this, player.getUniqueId()));
	}

	@Override
	protected @NotNull Account getCurrentAccountInternal(@NotNull Player p) {
		return new UUIDAccount(this, p.getUniqueId());
	}

	@Override
	protected @NotNull Optional<Account> getFromIdentifierInternal(@NotNull String accountIdentifier) {
		return Optional.of(new UUIDAccount(this, UUID.fromString(accountIdentifier)));
	}

	@EventHandler (priority = EventPriority.LOWEST)
	public void onJoin(PlayerJoinEvent e) {
		callAccountJoin(e.getPlayer(), getCurrentAccount(e.getPlayer()), !e.getPlayer().hasPlayedBefore());
	}

	@EventHandler (priority = EventPriority.LOWEST)
	public void onQuit(PlayerQuitEvent e) {
		callAccountLeave(e.getPlayer(), getCurrentAccount(e.getPlayer()));
	}

}
