package zonedabone.LavaForge;

import org.bukkit.plugin.java.JavaPlugin;

public class LavaForge extends JavaPlugin {

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        onFurnaceBurnListener onFurnaceBurnListener = new onFurnaceBurnListener();
        getServer().getPluginManager().registerEvents(onFurnaceBurnListener, this);
    }


}
