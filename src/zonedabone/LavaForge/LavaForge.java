package zonedabone.LavaForge;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LavaForge extends JavaPlugin {

	private final LavaForgeInventoryListener inventoryListener = new LavaForgeInventoryListener(this);
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEnable() {
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.FURNACE_BURN,  inventoryListener, Event.Priority.Normal,  this);

	}

}
