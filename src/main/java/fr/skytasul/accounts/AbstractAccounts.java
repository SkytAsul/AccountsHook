package fr.skytasul.accounts;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.entity.Player;

public abstract class AbstractAccounts {
	
	private Map<String, DataHook> dataHooks = new HashMap<>();

	public String getName(){
		return getClass().getSimpleName();
	}
	
	public abstract Account getAccountForPlayer(Player p);
	
	public abstract Account getAccountFromIdentifier(String identifier);
	
	public Account createAccountFromUUID(UUID id){
		return null;
	}
	
	public void registerDataHook(String name, DataHook hook){
		dataHooks.put(name, hook);
	}
	
	public Map<String, Map<String, Object>> unload(Account acc){
		Map<String, Map<String, Object>> map = new HashMap<>();
		
		for (Entry<String, DataHook> en : dataHooks.entrySet()){
			try{
				map.put(en.getKey(), en.getValue().unload(acc));
			}catch (Exception ex){
				AccountsPlugin.getInstance().getLogger().severe(en.getKey() + " hooker failed to save datas");
				ex.printStackTrace();
				continue;
			}
		}
		
		return map;
	}
	
	public void load(Account acc, Map<String, Map<String, Object>> datas){
		for (Entry<String, Map<String, Object>> en : datas.entrySet()){
			DataHook hook = dataHooks.get(en.getKey());
			if (hook != null){
				try{
					hook.load(acc, en.getValue());
				}catch (Exception ex){
					AccountsPlugin.getInstance().getLogger().severe(en.getKey() + " hooker failed to load datas");
					ex.printStackTrace();
					continue;
				}
			}else AccountsPlugin.getInstance().getLogger().warning("DataHooker " + en.getKey() + " not registered.");
		}
	}
	
	public void create(Account acc){
		for (DataHook hook : dataHooks.values()){
			hook.create(acc);
		}
	}
	
}
