package fr.skytasul.accounts;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public abstract class Account {
	
	protected Account(){}
	
	/**
	 * @return the OfflinePlayer instance attached to this account (no matter if the player is online or not, or if the account is the currently used)
	 */
	public abstract OfflinePlayer getOfflinePlayer();
	
	/**
	 * @return the Player instance who own this account. If the account is not which in use by the player ({@link #isCurrent()}), this will return null.
	 */
	public final Player getPlayer(){
		if (!isCurrent()) return null;
		return getOfflinePlayer().getPlayer();
	}
	
	/**
	 * @return if this account is currently used by the player (if true, {@link #getPlayer()} cannot return a null player)
	 */
	public abstract boolean isCurrent();
	
	public boolean equals(Object obj){
		if (obj == this) return true;
		if (obj.getClass() != getClass()) return false;
		return equalsAccount((Account) obj);
	}
	
	protected boolean equalsAccount(Account acc){return false;}
	
	public abstract int hashCode();
	
	protected abstract String getMyIdentifier();
	
	public final String getIdentifier(){
		return AccountsPlugin.accounts.getName() + "|" + getMyIdentifier();
	}
	
}
