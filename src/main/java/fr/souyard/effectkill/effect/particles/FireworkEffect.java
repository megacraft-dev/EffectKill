package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.utils.ColoredParticle;
import fr.souyard.effectkill.utils.UtilItem;
import fr.souyard.effectkill.utils.UtilMath;
import fr.souyard.effectkill.utils.UtilParticle;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class FireworkEffect {

    public static void death(Player player) {
        Location location = player.getLocation();
        location.getWorld().playSound(location, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 0.1F, 1.0F);
        location.add(UtilMath.getRandomWithExclusion(-2, 2, 0), 1.0D, UtilMath.getRandomWithExclusion(-2, 2, 0));
        new BukkitRunnable() {
            int k = 0;
            float y = 0.0F;

            @Override
            public void run() {
                if (this.k < UtilMath.randomRange(2, 12)) {
                    location.add(0.0D, this.y, 0.0D);
                    this.y += 0.1F;
                    UtilParticle.sendParticle(location, Particle.FIREWORKS_SPARK, 1, new Vector(0, 0, 0), 0.0F);
                } else {
                    location.getWorld().playSound(location, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 0.1F, 1.0F);
                    Color color = UtilItem.getGreatRandomColor().getColor();
                    double randomRange = UtilMath.randomRange(0.4D, 1.0D);
                    for (int i = 0; i < 50; i++) {
                        Vector multiply = UtilMath.getRandomVector().multiply(randomRange);
                        location.add(multiply);
                        new ColoredParticle(Particle.REDSTONE, location, color.getRed(), color.getGreen(), color.getBlue()).send();
                        location.subtract(multiply);
                    }
                    FireworkEffect.playFirework1(player);
                    cancel();
                }
                this.k++;
            }
        }.runTaskTimer(Main.getInstance(), 1L, 1L);
    }

    private static void playFirework1(Player player) {
        Location location = player.getLocation();
        location.getWorld().playSound(location, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 0.1F, 1.0F);
        location.add(UtilMath.getRandomWithExclusion(-2, 2, 0), 1.0D, UtilMath.getRandomWithExclusion(-2, 2, 0));
        new BukkitRunnable() {
            int k = 0;
            float y = 0.0F;

            @Override
            public void run() {
                if (this.k < UtilMath.randomRange(2, 12)) {
                    location.add(0.0D, this.y, 0.0D);
                    this.y += 0.1F;
                    UtilParticle.sendParticle(location, Particle.FIREWORKS_SPARK, 1, new Vector(0, 0, 0), 0.0F);
                } else {
                    location.getWorld().playSound(location, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 0.1F, 1.0F);
                    Color color = UtilItem.getGreatRandomColor().getColor();
                    double randomRange = UtilMath.randomRange(0.4D, 1.0D);
                    for (int i = 0; i < 50; i++) {
                        Vector multiply = UtilMath.getRandomVector().multiply(randomRange);
                        location.add(multiply);
                        new ColoredParticle(Particle.REDSTONE, location, color.getRed(), color.getGreen(), color.getBlue()).send();
                        location.subtract(multiply);
                    }
                    FireworkEffect.playFirework2(player);
                    cancel();
                }
                this.k++;
            }
        }.runTaskTimer(Main.getInstance(), 1L, 1L);
    }

    private static void playFirework2(Player player) {
        Location location = player.getLocation();
        location.getWorld().playSound(location, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 0.1F, 1.0F);
        location.add(UtilMath.getRandomWithExclusion(-2, 2, 0), 1.0D, UtilMath.getRandomWithExclusion(-2, 2, 0));
        new BukkitRunnable() {
            int k = 0;
            float y = 0.0F;

            @Override
            public void run() {
                if (this.k < UtilMath.randomRange(2, 12)) {
                    location.add(0.0D, this.y, 0.0D);
                    this.y += 0.1F;
                    UtilParticle.sendParticle(location, Particle.FIREWORKS_SPARK, 1, new Vector(0, 0, 0), 0.0F);
                } else {
                    location.getWorld().playSound(location, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 0.1F, 1.0F);
                    Color color = UtilItem.getGreatRandomColor().getColor();
                    double randomRange = UtilMath.randomRange(0.4D, 1.0D);
                    for (int i = 0; i < 50; i++) {
                        Vector multiply = UtilMath.getRandomVector().multiply(randomRange);
                        location.add(multiply);
                        new ColoredParticle(Particle.REDSTONE, location, color.getRed(), color.getGreen(), color.getBlue()).send();
                        location.subtract(multiply);
                    }
                    cancel();
                }
                this.k++;
            }
        }.runTaskTimer(Main.getInstance(), 1L, 1L);
    }
}
