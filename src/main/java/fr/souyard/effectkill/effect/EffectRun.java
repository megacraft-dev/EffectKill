package fr.souyard.effectkill.effect;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.effect.particles.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EffectRun implements Listener {

    private final Main instance = Main.getInstance();

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = player.getKiller();
        if (killer != null) {
            if (instance.waveEffect.contains(killer)) {
                WaveEffect.death(player);
            } else if (instance.starEffect.contains(killer)) {
                StarEffect.death(player);
            } else if (instance.explodeEffect.contains(killer)) {
                ExplodeEffect.death(player);
            } else if (instance.frostEffect.contains(killer)) {
                FrostEffect.death(player);
            } else if (instance.satanEffect.contains(killer)) {
                SatanEffect.death(player);
            } else if (instance.sphereEffect.contains(killer)) {
                SphereEffect.death(player);
            } else if (instance.cloudEffect.contains(killer)) {
                CloudEffect.death(player);
            } else if (instance.flameringEffect.contains(killer)) {
                FlameRingEffect.death(player);
            } else if (instance.rainwealthEffect.contains(killer)) {
                RainwealthEffect.death(player);
            } else if (instance.fireworkEffect.contains(killer)) {
                FireworkEffect.death(player);
            } else if (instance.soupEffect.contains(killer)) {
                SoupEffect.death(player);
            } else if (instance.heartEffect.contains(killer)) {
                HeartEffect.death(player);
            }
        }
    }
}
