package fr.souyard.effectkill.effect.particles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class StarEffect {

    public static void death(Player player) {
        Location loc = player.getLocation();
        loc.getWorld().spawnParticle(Particle.FLAME, loc, 500);
        loc.getWorld().spawnParticle(Particle.CLOUD, loc, 500);
    }
}
