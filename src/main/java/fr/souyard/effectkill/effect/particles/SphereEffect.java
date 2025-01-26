package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.utils.ColoredParticle;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class SphereEffect {

    public static void death(Player player) {
        Location loc = player.getLocation();
        ArmorStand armor = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        armor.setVisible(false);
        armor.setCustomName("§c§l" + player.getName());
        armor.setCustomNameVisible(true);
        armor.setGravity(false);
        armor.setVelocity(armor.getVelocity().multiply(new Vector(0, 4, 0)));
        new BukkitRunnable() {
            double phi = 0.0D;

            public void run() {
                this.phi += 0.3141592653589793D;
                for (double theta = 0.0D; theta <= 6.283185307179586D; theta += 0.15707963267948966D) {
                    double r = 1.5D;
                    double x = r * Math.cos(theta) * Math.sin(this.phi);
                    double y = r * Math.cos(this.phi) + 2.0D;
                    double z = r * Math.sin(theta) * Math.sin(this.phi);
                    loc.add(x, y, z);
                    new ColoredParticle(Particle.REDSTONE, loc, 255, 0, 0).send();
                    loc.subtract(x, y, z);
                }
                if (this.phi > Math.PI) {
                    armor.remove();
                    cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 1L);
    }
}
