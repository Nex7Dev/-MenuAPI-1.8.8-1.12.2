package me.nex7dev.menuapi.manager;

import me.nex7dev.menuapi.system.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof Menu) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) return;
            
            ((Menu) holder).performClick(event);
        }
    }
}
