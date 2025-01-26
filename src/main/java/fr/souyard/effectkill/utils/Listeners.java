package fr.souyard.effectkill.utils;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.gui.Gui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Listeners implements Listener {

    private final Main plugin = Main.getInstance();
    private final FileConfiguration config = Main.getInstance().getConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (config.getBoolean("Item.Giveitem")) {
            ItemStack item = new ItemStack(Material.getMaterial(config.getInt("Item.Joinitem")), 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(config.getString("Item.Nameitem").replace("&", "§"));
            List<String> lore = new ArrayList<>();
            for (String messages : Main.getInstance().itemLore("Loreitem")) {
                lore.add(ChatColor.translateAlternateColorCodes('&', messages));
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            player.getInventory().setItem(config.getInt("Item.Placeitem") - 1, item);
        }
        if (config.getBoolean("Default.enable")) {
            String type = config.getString("Default.type");
            switch (type) {
                case "WaveEffect":
                    plugin.waveEffect.add(player);
                    break;
                case "StarEffect":
                    plugin.starEffect.add(player);
                    break;
                case "SphereEffect":
                    plugin.sphereEffect.add(player);
                    break;
                case "SoupEffect":
                    plugin.soupEffect.add(player);
                    break;
                case "SatanEffect":
                    plugin.satanEffect.add(player);
                    break;
                case "RainwealthEffect":
                    plugin.rainwealthEffect.add(player);
                    break;
                case "HeartEffect":
                    plugin.heartEffect.add(player);
                    break;
                case "FrostEffect":
                    plugin.frostEffect.add(player);
                    break;
                case "FlameringEffect ":
                    plugin.flameringEffect.add(player);
                    break;
                case "ExplodeEffect":
                    plugin.explodeEffect.add(player);
                    break;
                case "CloudEffect":
                    plugin.cloudEffect.add(player);
                    break;
                case "FireworkEffect":
                    plugin.fireworkEffect.add(player);
                    break;
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                && config.getBoolean("Item.Giveitem")
                && event.getItem() != null && event.getItem().getType() == Material.getMaterial(config.getInt("Item.Joinitem"))) {
            Gui.openInventory(event.getPlayer());
        }
    }

    @EventHandler
    public void onArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        if (event.getRightClicked() == plugin.armor) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    protected void onDropItem(PlayerDropItemEvent event) {
        ItemStack item = event.getItemDrop().getItemStack();
        if (item.getType() == Material.getMaterial(config.getInt("Item.Joinitem"))
                && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName()
                .equals(config.getString("Item.Nameitem").replace("&", "§"))) {
            event.setCancelled(true);
        }
    }
}
