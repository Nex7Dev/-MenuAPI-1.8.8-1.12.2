package me.nex7dev.menuapi;

import me.nex7dev.menuapi.manager.MenuListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MenuAPI extends JavaPlugin {

    private static MenuAPI instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
    }

    public static MenuAPI getInstance() {
        return instance;
    }
}
