package zonedabone.LavaForge;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LavaForge extends JavaPlugin implements Listener {

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEnable() {

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(this, this);

	}

	@EventHandler
	public void onFurnaceBurn(FurnaceBurnEvent e) {
		if (e.getFuel().getType() == Material.LAVA_BUCKET) {
			final Block furnace = e.getBlock();
			this.getServer().getScheduler()
					.scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							Furnace furn = (Furnace) furnace.getState();
							furn.getInventory().setItem(1,
									new ItemStack(Material.BUCKET, 1));
						}
					});
		}
	}

}
