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
    public void onDamage(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player damager = player.getKiller();
        if (damager != null) {
            if (instance.starEffect.contains(damager)) {
                StarEffect.death(player);
            } else if (instance.waveEffect.contains(damager)) {
                WaveEffect.death(player);
            } else if (instance.sphereEffect.contains(damager)) {
                SphereEffect.death(player);
            } else if (instance.satanEffect.contains(damager)) {
                SatanEffect.death(player);
            } else if (instance.frostEffect.contains(damager)) {
                FrostEffect.death(player);
            } else if (instance.cloudEffect.contains(damager)) {
                CloudEffect.death(player);
            } else if (instance.explodeEffect.contains(damager)) {
                ExplodeEffect.death(player);
            } else if (instance.flameringEffect.contains(damager)) {
                FlameRingEffect.death(player);
            } else if (instance.rainwealthEffect.contains(damager)) {
                RainwealthEffect.death(player);
            } else if (instance.fireworkEffect.contains(damager)) {
                FireworkEffect.death(player);
            } else if (instance.soupEffect.contains(damager)) {
                SoupEffect.death(player);
            } else if (instance.heartEffect.contains(damager)) {
                HeartEffect.death(player);
            }
        }
    }
}
