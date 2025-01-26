package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.utils.ColoredParticle;
import fr.souyard.effectkill.utils.UtilParticle;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class WaveEffect {

    public static void death(Player player) {
        Location loc = player.getLocation();
        new BukkitRunnable() {
            double t = 0;

            @Override
            public void run() {
                this.t += 0.3141592653589793D;
                for (double theta = 0.0D; theta <= 6.283185307179586D; theta += 0.09817477042468103D) {
                    double x = this.t * Math.cos(theta);
                    double y = 2.0D * Math.exp(-0.1D * this.t) * Math.sin(this.t) + 1.5D;
                    double z = this.t * Math.sin(theta);
                    loc.add(x, y, z);

                    new ColoredParticle(Particle.REDSTONE, loc, 0, 0, 225).send();
                    loc.subtract(x, y, z);

                    theta += 0.04908738521234052D;
                    x = this.t * Math.cos(theta);
                    y = 2.0D * Math.exp(-0.1D * this.t) * Math.sin(this.t) + 1.5D;
                    z = this.t * Math.sin(theta);
                    loc.add(x, y, z);

                    UtilParticle.sendParticle(loc, Particle.DRIP_WATER, 1, new Vector(0, 0, 0), 0.0F);
                    loc.subtract(x, y, z);
                }
                if (this.t > 10.0D) {
                    cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 1L);
    }
}
