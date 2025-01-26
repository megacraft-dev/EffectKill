package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.utils.UtilMath;
import fr.souyard.effectkill.utils.UtilParticle;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class HeartEffect {

    public static void death(Player player) {
        Location loc = player.getLocation();
        for (double height = 0.0D; height < 1.0D; height += 0.2D) {
            UtilParticle.sendParticle(loc.clone().add(UtilMath.randomRange(-1.0F, 1.0F), height,
                    UtilMath.randomRange(-1.0F, 1.0F)), Particle.HEART, 1, new Vector(0, 0, 0), 0.0F);
        }
    }
}
