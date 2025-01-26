package fr.souyard.effectkill.utils;

import lombok.RequiredArgsConstructor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class ColoredParticle {

    private final Particle particle;
    private final Location loc;
    private final int r, g, b;

    public void send() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double x = this.loc.getX() + random.nextDouble() * 0.6D + 0.2D;
        double y = this.loc.getY() + random.nextDouble() * 0.6D + 0.2D;
        double z = this.loc.getZ() + random.nextDouble() * 0.6D + 0.2D;
        this.loc.getWorld().spawnParticle(
                this.particle, x, y, z, 1,
                new Particle.DustOptions(Color.fromBGR(this.r, this.g, this.b), 1));
    }
}
