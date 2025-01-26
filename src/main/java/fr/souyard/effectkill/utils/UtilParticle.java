package fr.souyard.effectkill.utils;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class UtilParticle {

    public static void sendParticle(Location location, Particle particle, int n, Vector vector, double extra) {
        location.getWorld().spawnParticle(particle, location, n, vector.getX(), vector.getY(), vector.getZ(), extra);
    }

    public static void sendParticle(Location location, Particle particle, int n, Vector vector, float extra, ItemStack itemStack) {
        location.getWorld().spawnParticle(particle, location, n, vector.getX(), vector.getY(), vector.getZ(), extra, itemStack);
    }
}
