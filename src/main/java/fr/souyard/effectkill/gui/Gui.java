package fr.souyard.effectkill.gui;

import fr.souyard.effectkill.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Gui implements Listener {

    private static final Main plugin = Main.getInstance();
    private static final FileConfiguration config = plugin.getConfig();

    public static void openInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 45, plugin.gui("Gui.NAME"));

        ItemStack particle1 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.WAVE.ID")));
        ItemMeta particlemeta1 = particle1.getItemMeta();
        List<String> particlelore1 = new ArrayList<>();
        for (String messages : plugin.guiLore("WAVE.LORE")) {
            particlelore1.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta1.setLore(particlelore1);
        particlemeta1.setDisplayName(plugin.gui("Gui.WAVE.NAME"));
        particle1.setItemMeta(particlemeta1);
        if (config.getBoolean("EffectKill.Gui.WAVE.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.WAVE.SLOTS") - 1, particle1);
        }

        ItemStack particle2 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.STAR.ID")));
        ItemMeta particlemeta2 = particle2.getItemMeta();
        List<String> particlelore2 = new ArrayList<>();
        for (String messages : plugin.guiLore("STAR.LORE")) {
            particlelore2.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta2.setLore(particlelore2);
        particlemeta2.setDisplayName(plugin.gui("Gui.STAR.NAME"));
        particle2.setItemMeta(particlemeta2);
        if (config.getBoolean("EffectKill.Gui.STAR.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.STAR.SLOTS") - 1, particle2);
        }

        ItemStack particle3 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.EXPLODE.ID")));
        ItemMeta particlemeta3 = particle3.getItemMeta();
        List<String> particlelore3 = new ArrayList<>();
        for (String messages : plugin.guiLore("EXPLODE.LORE")) {
            particlelore3.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta3.setLore(particlelore3);
        particlemeta3.setDisplayName(plugin.gui("Gui.EXPLODE.NAME"));
        particle3.setItemMeta(particlemeta3);
        if (config.getBoolean("EffectKill.Gui.EXPLODE.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.EXPLODE.SLOTS") - 1, particle3);
        }

        ItemStack particle4 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.FROST.ID")));
        ItemMeta particlemeta4 = particle4.getItemMeta();
        List<String> particlelore4 = new ArrayList<>();
        for (String messages : plugin.guiLore("FROST.LORE")) {
            particlelore4.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta4.setLore(particlelore4);
        particlemeta4.setDisplayName(plugin.gui("Gui.FROST.NAME"));
        particle4.setItemMeta(particlemeta4);
        if (config.getBoolean("EffectKill.Gui.FROST.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.FROST.SLOTS") - 1, particle4);
        }

        ItemStack particle5 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.SATAN.ID")));
        ItemMeta particlemeta5 = particle5.getItemMeta();
        List<String> particlelore5 = new ArrayList<>();
        for (String messages : plugin.guiLore("SATAN.LORE")) {
            particlelore5.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta5.setLore(particlelore5);
        particlemeta5.setDisplayName(plugin.gui("Gui.SATAN.NAME"));
        particle5.setItemMeta(particlemeta5);
        if (config.getBoolean("EffectKill.Gui.SATAN.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.SATAN.SLOTS") - 1, particle5);
        }

        ItemStack particle6 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.SPHERE.ID")));
        ItemMeta particlemeta6 = particle6.getItemMeta();
        List<String> particlelore6 = new ArrayList<>();
        for (String messages : plugin.guiLore("SPHERE.LORE")) {
            particlelore6.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta6.setLore(particlelore6);
        particlemeta6.setDisplayName(plugin.gui("Gui.SPHERE.NAME"));
        particle6.setItemMeta(particlemeta6);
        if (config.getBoolean("EffectKill.Gui.SPHERE.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.SPHERE.SLOTS") - 1, particle6);
        }

        ItemStack particle7 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.CLOUD.ID")));
        ItemMeta particlemeta7 = particle7.getItemMeta();
        List<String> particlelore7 = new ArrayList<>();
        for (String messages : plugin.guiLore("CLOUD.LORE")) {
            particlelore7.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta7.setLore(particlelore7);
        particlemeta7.setDisplayName(plugin.gui("Gui.CLOUD.NAME"));
        particle7.setItemMeta(particlemeta7);
        if (config.getBoolean("EffectKill.Gui.CLOUD.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.CLOUD.SLOTS") - 1, particle7);
        }

        ItemStack particle8 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.FLAMERING.ID")));
        ItemMeta particlemeta8 = particle8.getItemMeta();
        List<String> particlelore8 = new ArrayList<>();
        for (String messages : plugin.guiLore("FLAMERING.LORE")) {
            particlelore8.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta8.setLore(particlelore8);
        particlemeta8.setDisplayName(plugin.gui("Gui.FLAMERING.NAME"));
        particle8.setItemMeta(particlemeta8);
        if (config.getBoolean("EffectKill.Gui.FLAMERING.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.FLAMERING.SLOTS") - 1, particle8);
        }

        ItemStack particle9 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.RAINWEALTH.ID")));
        ItemMeta particlemeta9 = particle9.getItemMeta();
        List<String> particlelore9 = new ArrayList<>();
        for (String messages : plugin.guiLore("RAINWEALTH.LORE")) {
            particlelore9.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta9.setLore(particlelore9);
        particlemeta9.setDisplayName(plugin.gui("Gui.RAINWEALTH.NAME"));
        particle9.setItemMeta(particlemeta9);
        if (config.getBoolean("EffectKill.Gui.RAINWEALTH.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.RAINWEALTH.SLOTS") - 1, particle9);
        }

        ItemStack particle10 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.FIREWORK.ID")));
        ItemMeta particlemeta10 = particle10.getItemMeta();
        List<String> particlelore10 = new ArrayList<>();
        for (String messages : plugin.guiLore("FIREWORK.LORE")) {
            particlelore10.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta10.setLore(particlelore10);
        particlemeta10.setDisplayName(plugin.gui("Gui.FIREWORK.NAME"));
        particle10.setItemMeta(particlemeta10);
        if (config.getBoolean("EffectKill.Gui.FIREWORK.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.FIREWORK.SLOTS") - 1, particle10);
        }

        ItemStack particle11 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.SOUP.ID")));
        ItemMeta particlemeta11 = particle11.getItemMeta();
        List<String> particlelore11 = new ArrayList<>();
        for (String messages : plugin.guiLore("SOUP.LORE")) {
            particlelore11.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta11.setLore(particlelore11);
        particlemeta11.setDisplayName(plugin.gui("Gui.SOUP.NAME"));
        particle11.setItemMeta(particlemeta11);
        if (config.getBoolean("EffectKill.Gui.SOUP.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.SOUP.SLOTS") - 1, particle11);
        }

        ItemStack particle12 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.HEART.ID")));
        ItemMeta particlemeta12 = particle12.getItemMeta();
        List<String> particlelore12 = new ArrayList<>();
        for (String messages : plugin.guiLore("HEART.LORE")) {
            particlelore12.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta12.setLore(particlelore12);
        particlemeta12.setDisplayName(plugin.gui("Gui.HEART.NAME"));
        particle12.setItemMeta(particlemeta12);
        if (config.getBoolean("EffectKill.Gui.HEART.ENABLE")) {
            inv.setItem(config.getInt("EffectKill.Gui.HEART.SLOTS") - 1, particle12);
        }

        ItemStack particle13 = new ItemStack(Material.matchMaterial(config.getString("EffectKill.Gui.REMOVE.ID")));
        ItemMeta particlemeta13 = particle13.getItemMeta();
        List<String> particlelore13 = new ArrayList<>();
        for (String messages : plugin.guiLore("REMOVE.LORE")) {
            particlelore13.add(ChatColor.translateAlternateColorCodes('&', messages));
        }
        particlemeta13.setLore(particlelore13);
        particlemeta13.setDisplayName(plugin.gui("Gui.REMOVE.NAME"));
        particle13.setItemMeta(particlemeta13);
        inv.setItem(config.getInt("EffectKill.Gui.REMOVE.SLOTS") - 1, particle13);

        p.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        String title = event.getView().getTitle();
        if (title.equals(plugin.gui("Gui.NAME"))) {
            Player player = (Player) event.getWhoClicked();
            if (event.getInventory() == null)
                return;
            if (event.getCurrentItem() == null)
                return;
            ItemStack item = event.getCurrentItem();
            event.setCancelled(true);
            if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.WAVE.ID"))) {
                remove(player);
                if (!plugin.waveEffect.contains(player) && player.hasPermission("effectkill.wave")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.WaveEffect")));
                    plugin.waveEffect.add(player);
                } else if (!player.hasPermission("effectkill.wave")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.STAR.ID"))) {
                remove(player);
                if (!plugin.starEffect.contains(player) && player.hasPermission("effectkill.NAME")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.StarEffect")));
                    plugin.starEffect.add(player);
                } else if (!player.hasPermission("effectkill.starEffect")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.RAINWEALTH.ID"))) {
                remove(player);
                if (!plugin.rainwealthEffect.contains(player) && player.hasPermission("effectkill.rainwealth")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.RainwealthEffect")));
                    plugin.rainwealthEffect.add(player);
                } else if (!player.hasPermission("effectkill.rainwealth")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.FLAMERING.ID"))) {
                remove(player);
                if (!plugin.flameringEffect.contains(player) && player.hasPermission("effectkill.flamering")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.FlameringEffect")));
                    plugin.flameringEffect.add(player);
                } else if (!player.hasPermission("effectkill.flamering")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.EXPLODE.ID"))) {
                remove(player);
                if (!plugin.explodeEffect.contains(player) && player.hasPermission("effectkill.explode")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.ExplodeEffect")));
                    plugin.explodeEffect.add(player);
                } else if (!player.hasPermission("effectkill.explode")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.FROST.ID"))) {
                remove(player);
                if (!plugin.frostEffect.contains(player) && player.hasPermission("effectkill.frost")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.FrostEffect")));
                    plugin.frostEffect.add(player);
                } else if (!player.hasPermission("effectkill.frost")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.SATAN.ID"))) {
                remove(player);
                if (!plugin.satanEffect.contains(player) && player.hasPermission("effectkill.satan")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.SatanEffect")));
                    plugin.satanEffect.add(player);
                } else if (!player.hasPermission("effectkill.satan")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.CLOUD.ID"))) {
                remove(player);
                if (!plugin.cloudEffect.contains(player) && player.hasPermission("effectkill.cloud")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.CloudEffect")));
                    plugin.cloudEffect.add(player);
                } else if (!player.hasPermission("effectkill.cloud")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.SPHERE.ID"))) {
                remove(player);
                if (!plugin.sphereEffect.contains(player) && player.hasPermission("effectkill.sphere")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.SphereEffect")));
                    plugin.sphereEffect.add(player);
                } else if (!player.hasPermission("effectkill.sphere")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.FIREWORK.ID"))) {
                remove(player);
                if (!plugin.fireworkEffect.contains(player) && player.hasPermission("effectkill.firework")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.FireworkEffect")));
                    plugin.fireworkEffect.add(player);
                } else if (!player.hasPermission("effectkill.firework")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.SOUP.ID"))) {
                remove(player);
                if (!plugin.soupEffect.contains(player) && player.hasPermission("effectkill.soup")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.SoupEffect")));
                    plugin.soupEffect.add(player);
                } else if (!player.hasPermission("effectkill.soup")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.HEART.ID"))) {
                remove(player);
                if (!plugin.heartEffect.contains(player) && player.hasPermission("effectkill.heart")) {
                    player.sendMessage(plugin.gui("Messages.Display").replace("%effect%", plugin.gui("Messages.HeartEffect")));
                    plugin.heartEffect.add(player);
                } else if (!player.hasPermission("effectkill.heart")) {
                    player.sendMessage(plugin.gui("Messages.noPerm"));
                } else {
                    remove(player);
                }
            } else if (item.getType() == Material.matchMaterial(config.getString("EffectKill.Gui.REMOVE.ID"))) {
                remove(player);
            }
        }
    }

    public static void remove(Player player) {
        plugin.waveEffect.remove(player);
        plugin.starEffect.remove(player);
        plugin.sphereEffect.remove(player);
        plugin.fireworkEffect.remove(player);
        plugin.satanEffect.remove(player);
        plugin.frostEffect.remove(player);
        plugin.flameringEffect.remove(player);
        plugin.rainwealthEffect.remove(player);
        plugin.explodeEffect.remove(player);
        plugin.cloudEffect.remove(player);
        plugin.soupEffect.remove(player);
        plugin.heartEffect.remove(player);
        player.sendMessage(plugin.gui("Messages.Remove"));
    }
}
