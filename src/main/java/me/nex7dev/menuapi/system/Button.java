package me.nex7dev.menuapi.system;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import java.util.function.Consumer;

public class Button {

    private final ItemStack icon;
    private final Consumer<InventoryClickEvent> action;

    public Button(ItemStack icon) {
        this.icon = icon;
        this.action = null;
    }

    public Button(ItemStack icon, Consumer<InventoryClickEvent> action) {
        this.icon = icon;
        this.action = action;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public void onClick(InventoryClickEvent event) {
        if (action != null) {
            action.accept(event);
        }
    }
}
