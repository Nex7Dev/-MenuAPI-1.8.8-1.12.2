package me.nex7dev.menuapi.system;

import me.nex7dev.menuapi.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class PaginatedMenu extends Menu {

    protected int page = 0;
    protected int maxItemsPerPage = 28;
    protected int index = 0;

    public PaginatedMenu(String title) {
        super(title, 54);
    }

    public void addMenuBorder() {
        ItemStack filler = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 15).setName(" ").build();
        Button fillerButton = new Button(filler);

        setButton(48, new Button(new ItemBuilder(Material.ARROW).setName(ChatColor.GREEN + "Previous").build(), event -> {
            if (page == 0) {
                ((Player) event.getWhoClicked()).sendMessage(ChatColor.RED + "You are already on the first page.");
            } else {
                page = page - 1;
                super.open((Player) event.getWhoClicked());
            }
        }));

        setButton(49, new Button(new ItemBuilder(Material.BARRIER).setName(ChatColor.DARK_RED + "Close").build(), event -> {
            event.getWhoClicked().closeInventory();
        }));

        setButton(50, new Button(new ItemBuilder(Material.ARROW).setName(ChatColor.GREEN + "Next").build(), event -> {
            if (!((index + 1) >= getDataSize())) {
                page = page + 1;
                super.open((Player) event.getWhoClicked());
            } else {
                ((Player) event.getWhoClicked()).sendMessage(ChatColor.RED + "You are on the last page.");
            }
        }));

        for (int i = 0; i < 10; i++) {
            if (inventory.getItem(i) == null) {
                setButton(i, fillerButton);
            }
        }

        setButton(17, fillerButton);
        setButton(18, fillerButton);
        setButton(26, fillerButton);
        setButton(27, fillerButton);
        setButton(35, fillerButton);
        setButton(36, fillerButton);

        for (int i = 44; i < 54; i++) {
            if (inventory.getItem(i) == null) {
                setButton(i, fillerButton);
            }
        }
    }

    public abstract int getDataSize();

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}
