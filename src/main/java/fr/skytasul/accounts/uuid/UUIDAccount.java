package fr.skytasul.accounts.uuid;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import fr.skytasul.accounts.Account;

public class UUIDAccount extends Account {

	UUID id;
	
	UUIDAccount(UUID id){
		this.id = id;
	}
	
	@Override
	public OfflinePlayer getOfflinePlayer() {
		return Bukkit.getOfflinePlayer(id);
	}

	public Player getAccountPlayer(){
		return Bukkit.getPlayer(id);
	}

	@Override
	public String getMyIdentifier() {
		return id.toString();
	}

	@Override
	public boolean isCurrent() {
		return getOfflinePlayer().isOnline();
	}

	@Override
	public boolean equalsAccount(Account acc) {
		return ((UUIDAccount) acc).id.equals(this.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
