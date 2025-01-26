package fr.souyard.effectkill.commands;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.gui.Gui;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class EffectCMD implements CommandExecutor {

    private final Main plugin = Main.getInstance();
    private final FileConfiguration config = plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            return true;
        }
        if (args.length == 0) {
            displayCommandHelp(player);
            return true;
        }
        if (args[0].equalsIgnoreCase("help")) {
            displayCommandHelp(player);
        } else if (args[0].equalsIgnoreCase("open")) {
            Gui.openInventory(player);
        } else if (args[0].equalsIgnoreCase("list")) {
            player.sendMessage("§e----- EffectKill -----");
            if (player.hasPermission("effectkill.wave")) {
                player.sendMessage(config.getString("EffectKill.Messages.WaveEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.star")) {
                player.sendMessage(config.getString("EffectKill.Messages.StarEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.sphere")) {
                player.sendMessage(config.getString("EffectKill.Messages.SphereEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.satan")) {
                player.sendMessage(config.getString("EffectKill.Messages.SatanEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.frost")) {
                player.sendMessage(config.getString("EffectKill.Messages.FrostEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.cloud")) {
                player.sendMessage(config.getString("EffectKill.Messages.CloudEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.explode")) {
                player.sendMessage(config.getString("EffectKill.Messages.ExplodeEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.flamering")) {
                player.sendMessage(config.getString("EffectKill.Messages.FlameringEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.rainwealth")) {
                player.sendMessage(config.getString("EffectKill.Messages.RainwealthEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.firework")) {
                player.sendMessage(config.getString("EffectKill.Messages.FireworkEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.soup")) {
                player.sendMessage(config.getString("EffectKill.Messages.SoupEffect").replace("&", "§"));
            } else if (player.hasPermission("effectkill.heart")) {
                player.sendMessage(config.getString("EffectKill.Messages.HeartEffect").replace("&", "§"));
            } else {
                player.sendMessage(config.getString("EffectKill.Messages.noEffect").replace("&", "§"));
            }
            player.sendMessage("§e----- EffectKill -----");
        } else if (args[0].equalsIgnoreCase("set")) {
            if (!player.hasPermission("effectkill.admin")) {
                return true;
            }
            if (args.length != 3) {
                sender.sendMessage("§cplease use /effectkill <player> <effect>");
                return true;
            }
            Player target = Bukkit.getPlayerExact(args[1]);
            if (target == null) {
                sender.sendMessage("§cThis player is not connected");
                return true;
            }
            String gui = plugin.gui("Messages.Display");
            if (args[2].equalsIgnoreCase("WaveEffect")) {
                Gui.remove(target);
                plugin.waveEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.WaveEffect")));
            } else if (args[2].equalsIgnoreCase("StarEffect")) {
                Gui.remove(target);
                plugin.starEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.StarEffect")));
            } else if (args[2].equalsIgnoreCase("SphereEffect")) {
                Gui.remove(target);
                plugin.sphereEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.SphereEffect")));
            } else if (args[2].equalsIgnoreCase("SatanEffect")) {
                Gui.remove(target);
                plugin.satanEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.SatanEffect")));
            } else if (args[2].equalsIgnoreCase("FrostEffect")) {
                Gui.remove(target);
                plugin.frostEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.FrostEffect")));
            } else if (args[2].equalsIgnoreCase("CloudEffect")) {
                Gui.remove(target);
                plugin.cloudEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.CloudEffect")));
            } else if (args[2].equalsIgnoreCase("ExplodeEffect")) {
                Gui.remove(target);
                plugin.explodeEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.ExplodeEffect")));
            } else if (args[2].equalsIgnoreCase("FlameringEffect")) {
                Gui.remove(target);
                plugin.flameringEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.FlameringEffect")));
            } else if (args[2].equalsIgnoreCase("RainwealthEffect")) {
                Gui.remove(target);
                plugin.rainwealthEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.RainwealthEffect")));
            } else if (args[2].equalsIgnoreCase("FireworkEffect")) {
                Gui.remove(target);
                plugin.fireworkEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.FireworkEffect")));
            } else if (args[2].equalsIgnoreCase("SoupEffect")) {
                Gui.remove(target);
                plugin.soupEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.SoupEffect")));
            } else if (args[2].equalsIgnoreCase("HeartEffect")) {
                Gui.remove(target);
                plugin.soupEffect.add(target);
                player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.HeartEffect")));
            } else {
                player.sendMessage("§cError");
            }
        } else {
            String gui = plugin.gui("Messages.Display");
            if (args[0].equalsIgnoreCase("waveeffect")) {
                if (player.hasPermission("effectkill.wave")) {
                    Gui.remove(player);
                    plugin.waveEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.WaveEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("stareffect")) {
                if (player.hasPermission("effectkill.star")) {
                    Gui.remove(player);
                    plugin.starEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.StarEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("sphereeffect")) {
                if (player.hasPermission("effectkill.sphere")) {
                    Gui.remove(player);
                    plugin.sphereEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.SphereEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("sataneffect")) {
                if (player.hasPermission("effectkill.satan")) {
                    Gui.remove(player);
                    plugin.satanEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.SatanEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("frosteffect")) {
                if (player.hasPermission("effectkill.frost")) {
                    Gui.remove(player);
                    plugin.frostEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.FrostEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("cloudeffect")) {
                if (player.hasPermission("effectkill.cloud")) {
                    Gui.remove(player);
                    plugin.cloudEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.CloudEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("explodeeffect")) {
                if (player.hasPermission("effectkill.explode")) {
                    Gui.remove(player);
                    plugin.explodeEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.ExplodeEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("flameringeffect")) {
                if (player.hasPermission("effectkill.flamering")) {
                    Gui.remove(player);
                    plugin.flameringEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.FlameringEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("rainwealtheffect")) {
                if (player.hasPermission("effectkill.rainwealth")) {
                    Gui.remove(player);
                    plugin.rainwealthEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.RainwealthEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("fireworkeffect")) {
                if (player.hasPermission("effectkill.firework")) {
                    Gui.remove(player);
                    plugin.fireworkEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.FireworkEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("soupeffect")) {
                if (player.hasPermission("effectkill.soup")) {
                    Gui.remove(player);
                    plugin.soupEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.SoupEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("hearteffect")) {
                if (player.hasPermission("effectkill.heart")) {
                    Gui.remove(player);
                    plugin.heartEffect.add(player);
                    player.sendMessage(gui.replace("%effect%", plugin.gui("Messages.HeartEffect")));
                    return true;
                }
                player.sendMessage(plugin.gui("Messages.noPerm"));
            } else if (args[0].equalsIgnoreCase("remove")) {
                Gui.remove(player);
            } else {
                displayCommandHelp(player);
            }
        }
        return true;
    }

    private void displayCommandHelp(Player player) {
        player.sendMessage("§e----- EffectKill -----");
        player.sendMessage("");
        player.sendMessage("§ehelp: /effectkill help");
        player.sendMessage("§eopen gui: /effectkill open");
        player.sendMessage("§elist: /effectkill list");
        player.sendMessage("§eset effect: /effectkill set <player> <effect>");
        player.sendMessage("§eTo put you an effect: /effectkill <effect>");
        player.sendMessage("");
        player.sendMessage("§e----- EffectKill -----");
    }
}
