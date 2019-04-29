package fr.skytasul.accounts;

import java.util.Map;

public interface DataHook {

	/**
	 * Called when the accounts plugin have to unload player datas
	 * @param acc Account to save
	 * @return Map of saved datas
	 */
	public abstract Map<String, Object> unload(Account acc);
	
	/**
	 * Called when the accounts plugin have to load player datas
	 * @param acc Account to load
	 * @param map Map of saved datas
	 */
	public abstract void load(Account acc, Map<String, Object> map);
	
	/**
	 * Called when the accounts plugin creates a player account
	 * @param acc Account created
	 */
	public abstract void create(Account acc);
	
}
