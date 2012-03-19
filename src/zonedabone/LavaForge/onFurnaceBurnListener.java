package zonedabone.LavaForge;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.ItemStack;

public class onFurnaceBurnListener extends LavaForge implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onFurnaceBurn(FurnaceBurnEvent e) {
        if (e.getFuel().getType() == Material.LAVA_BUCKET) {
            final Block furnace = e.getBlock();
            org.bukkit.Bukkit.getServer().getScheduler()
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
