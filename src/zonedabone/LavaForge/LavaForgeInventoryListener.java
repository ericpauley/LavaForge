package zonedabone.LavaForge;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.InventoryListener;
import org.bukkit.inventory.ItemStack;

public class LavaForgeInventoryListener extends InventoryListener {

	public static LavaForge plugin;
	
	public LavaForgeInventoryListener(LavaForge instance) {
		plugin = instance;
	}
	
	public void onFurnaceBurn(FurnaceBurnEvent e){
		if(e.getFuel().getType()==Material.LAVA_BUCKET){
			final Block furnace = e.getFurnace();
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			    public void run() {
			        Furnace furn = (Furnace) furnace.getState();
			        furn.getInventory().setItem(1, new ItemStack(Material.BUCKET, 1));
			    }
			}, 0L);
		}
	}
}
