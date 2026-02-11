package me.nex7dev.menuapi.system;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import java.util.HashMap;
import java.util.Map;

public abstract class Menu implements InventoryHolder {

    protected final Inventory inventory;
    protected final Map<Integer, Button> buttons;

    public Menu(String title, int size) {
        this.inventory = Bukkit.createInventory(this, size, title);
        this.buttons = new HashMap<>();
    }

    public abstract void configureItems(Player player);

    public void setButton(int slot, Button button) {
        buttons.put(slot, button);
        inventory.setItem(slot, button.getIcon());
    }

    public void performClick(InventoryClickEvent event) {
        if (buttons.containsKey(event.getSlot())) {
            buttons.get(event.getSlot()).onClick(event);
        }
    }

    public void open(Player player) {
        configureItems(player);
        player.openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
