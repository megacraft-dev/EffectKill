package fr.souyard.effectkill;

import fr.souyard.effectkill.commands.EffectCMD;
import fr.souyard.effectkill.effect.EffectRun;
import fr.souyard.effectkill.gui.Gui;
import fr.souyard.effectkill.utils.Listeners;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    public ArmorStand armor;
    public List<Player> waveEffect = new ArrayList<>();
    public List<Player> starEffect = new ArrayList<>();
    public List<Player> explodeEffect = new ArrayList<>();
    public List<Player> frostEffect = new ArrayList<>();
    public List<Player> satanEffect = new ArrayList<>();
    public List<Player> sphereEffect = new ArrayList<>();
    public List<Player> cloudEffect = new ArrayList<>();
    public List<Player> flameringEffect = new ArrayList<>();
    public List<Player> rainwealthEffect = new ArrayList<>();
    public List<Player> fireworkEffect = new ArrayList<>();
    public List<Player> soupEffect = new ArrayList<>();
    public List<Player> heartEffect = new ArrayList<>();

    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8[§6EffectKill§8] §7Plugin is §bloading...");
        Bukkit.getConsoleSender().sendMessage(" ");
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("§7==========================");
        Bukkit.getConsoleSender().sendMessage("§8[§6EffectKill§8] §7Plugin was §aenabled!");
        Bukkit.getConsoleSender().sendMessage("§8[§6EffectKill§8] §7By: §6Souyard");
        Bukkit.getConsoleSender().sendMessage("§8[§6EffectKill§8] §7Version: §62.0.0");
        Bukkit.getConsoleSender().sendMessage("§7==========================");
        getServer().getPluginManager().registerEvents(new EffectRun(), this);
        getServer().getPluginManager().registerEvents(new Gui(), this);
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        this.getCommand("effectkill").setExecutor(new EffectCMD());
    }

    public String gui(String path) {
        return getConfig().getString("EffectKill." + path).replace("&", "§");
    }

    public List<String> guiLore(String path) {
        return getConfig().getStringList("EffectKill.Gui." + path);
    }

    public List<String> itemLore(String path) {
        return getConfig().getStringList("Item." + path);
    }
}
