package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.utils.UtilParticle;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class FlameRingEffect {

    public static void death(Player player) {
        Location loc = player.getLocation();
        new BukkitRunnable() {
            double t = 0.0D;
            final double r = 1.5D;

            public void run() {
                this.t += 0.19634954084936207D;
                double x = this.r * Math.cos(this.t);
                double y = this.r * Math.sin(this.t) + 1.4D;
                double z = this.r * Math.sin(this.t);
                loc.add(x, y, z);
                UtilParticle.sendParticle(loc, Particle.FLAME, 1, new Vector(0, 0, 0), 0.0F);

                loc.subtract(x, y, z);
                double x1 = this.r * Math.sin(this.t);
                double y1 = this.r * Math.sin(this.t) + 1.4D;
                double z1 = this.r * Math.cos(this.t);
                loc.add(x1, y1, z1);
                UtilParticle.sendParticle(loc, Particle.FLAME, 1, new Vector(0, 0, 0), 0.0F);

                loc.subtract(x1, y1, z1);
                if (this.t > 6.283185307179586D) {
                    loc.getWorld().spawnParticle(Particle.FLAME, loc, 500);
                    cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 1L);
    }
}
