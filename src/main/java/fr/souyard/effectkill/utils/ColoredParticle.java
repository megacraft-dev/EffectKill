package fr.souyard.effectkill.utils;

import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.Particle;

@RequiredArgsConstructor
public class ColoredParticle {

    private final Particle particle;
    private final Location loc;
    private final int r, g, b;

    public void send() {
        this.loc.getWorld().spawnParticle(
                this.particle, this.loc.getX(), this.loc.getY(), this.loc.getZ(), 0,
                color(this.r), color(this.g), color(this.b), 1.0D);
    }

    private double color(double n) {
        n = (n <= 0.0D) ? -1.0D : n;
        return n / 255.0D;
    }
}
