package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ExplodeEffect {

    public static void death(Player player) {
        World w = Bukkit.getWorlds().get(0);
        Location loc = player.getLocation();
        new BukkitRunnable() {
            @Override
            public void run() {
                w.strikeLightningEffect(player.getLocation());
                loc.getWorld().spawnParticle(Particle.FLAME, loc, 500);
            }
        }.runTaskLater(Main.getInstance(), 1L);
    }
}
