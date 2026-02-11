# 📦 MenuAPI (1.8.8 - 1.12.2)

![Java](https://img.shields.io/badge/Java-8-orange)
![Spigot](https://img.shields.io/badge/Spigot-1.8.8%20--%201.12.2-yellow)
![License](https://img.shields.io/badge/License-MIT-blue)
![Status](https://img.shields.io/badge/Status-Stable-green)

Una API de gestión de inventario profesional, ligera y fácil de usar.

![Multi_Color_Bar](https://github.com/Walkoud/CS2-Auto-Accept/assets/38588921/3f57ad10-c80c-457a-9f49-679558eb2f79)

## 🔥 Información

- **Versión:** 1.8.8 - 1.12.2
- **Optimización:** Nuestro sistema de MenuAPI se encuentra totalmente optimizado para ofrecer el mejor rendimiento dentro de cualquier plugin.

¿Encontraste algún error o necesitas soporte?
Contáctame mediante **[Discord](https://dsc.gg/nex7dev)** o puedes enviarme solicitud a **nex7dev**.

![Multi_Color_Bar](https://github.com/Walkoud/CS2-Auto-Accept/assets/38588921/3f57ad10-c80c-457a-9f49-679558eb2f79)

## 💻 Ejemplo de Uso

Implementar nuestro sistema de MenuAPI es extremadamente sencillo. Puedes usar la siguiente estructura como base:

```java
import me.nex7dev.menuapi.system.Button;
import me.nex7dev.menuapi.system.Menu;
import me.nex7dev.menuapi.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExampleMenu extends Menu {

    public ExampleMenu() {
        super(ChatColor.DARK_AQUA + "Menu Title", 27);
    }

    @Override
    public void configureItems(Player player) {
        ItemStack filler = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 15).setName(" ").build();

        for (int i = 0; i < 27; i++) {
            setButton(i, new Button(filler));
        }

        setButton(11, new Button(
            new ItemBuilder(Material.DIAMOND_SWORD)
                .setName(ChatColor.GOLD + "Title")
                .setLore(ChatColor.GRAY + "Lore")
                .build(),
            event -> {
                player.sendMessage(ChatColor.GREEN + "Message");
                player.playSound(player.getLocation(), Sound.CLICK, 1f, 1f);
                player.closeInventory();
            }
        ));

        setButton(15, new Button(
            new ItemBuilder(Material.ENDER_PEARL)
                .setName(ChatColor.LIGHT_PURPLE + "Title2")
                .setLore(ChatColor.GRAY + "Lore2")
                .build(),
            event -> {
                player.sendMessage(ChatColor.GREEN + "Message2");
                player.playSound(player.getLocation(), Sound.CLICK, 1f, 1f);
                player.closeInventory();
            }
        ));

        setButton(26, new Button(
            new ItemBuilder(Material.BARRIER)
                .setName(ChatColor.RED + "Close Menu")
                .build(),
            event -> player.closeInventory()
        ));
    }
}

## Abrir el menú
Puedes registrar y abrir el menú mediante comandos usando el siguiente código:
Player player = (Player) sender;
new ExampleMenu().open(player);

## 🛠️ Instalación
Añade la dependencia a tu archivo pom.xml:
<dependency>
    <groupId>me.nex7dev</groupId>
    <artifactId>menuapi</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>


