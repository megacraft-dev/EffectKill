package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.utils.UtilParticle;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class FrostEffect {

    public static void death(Player player) {
        Location loc = player.getLocation();
        new BukkitRunnable() {
            double t = 0.0D;

            public void run() {
                this.t += 0.19634954084936207D;
                for (double phi = 0.0D; phi <= 6.283185307179586D; phi += 1.5707963267948966D) {
                    double x = 0.11D * (12.566370614359172D - this.t) * Math.cos(this.t + phi);
                    double y = 0.23D * this.t;
                    double z = 0.11D * (12.566370614359172D - this.t) * Math.sin(this.t + phi);
                    loc.add(x, y, z);
                    UtilParticle.sendParticle(loc, Particle.FLAME, 1, new Vector(0, 0, 0), 0.0F);

                    loc.subtract(x, y, z);
                    if (this.t >= 12.566370614359172D) {
                        loc.add(x, y, z);
                        loc.getWorld().spawnParticle(Particle.FLAME, loc, 500);
                        cancel();
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 1L);
    }
}
