package fr.skytasul.accounts;

import java.util.Map;

public interface DataHook {

	/**
	 * Called when the accounts plugin have to save/unload player datas
	 * @param acc Account to save/unload
	 * @param unload true if the specified account will be unloaded
	 * @return Map of saved datas
	 */
	public abstract Map<String, Object> save(Account acc, boolean unload);
	
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
