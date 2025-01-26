package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.utils.UtilLocation;
import fr.souyard.effectkill.utils.UtilMath;
import fr.souyard.effectkill.utils.UtilParticle;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class CloudEffect {

    public static void death(Player player) {
        Location loc = player.getLocation();
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner(player.getName());
        skull.setItemMeta(skullMeta);

        ArmorStand armor = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        armor.setVisible(false);
        armor.setCustomName("§c§l" + player.getName());
        armor.setCustomNameVisible(true);
        armor.setHelmet(skull);
        armor.setGravity(false);
        armor.setVelocity(armor.getVelocity().multiply(new Vector(0, 4, 0)));

        new BukkitRunnable() {
            double phi = 0.0D;

            @Override
            public void run() {
                this.phi += 0.3141592653589793D;
                for (int i = 0; i < 3; i++) {
                    UtilParticle.sendParticle(loc.clone().add(UtilMath.randomRange(-1.0F, 1.0F), 2.5D,
                            UtilMath.randomRange(-1.0F, 1.0F)), Particle.EXPLOSION_NORMAL, 1, new Vector(0, 0, 0), 0.0F);
                    UtilParticle.sendParticle(loc.clone().add(UtilMath.randomRange(-1.0F, 1.0F), 2.7D,
                            UtilMath.randomRange(-1.0F, 1.0F)), Particle.EXPLOSION_NORMAL, 1, new Vector(0, 0, 0), 0.0F);
                    loc.getWorld().spawnParticle(Particle.SNOW_SHOVEL, loc.clone().add(UtilMath.randomRange(-0.5F, 0.5F), 3.0D,
                            UtilMath.randomRange(-0.5F, 0.5F)), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                    loc.getWorld().spawnParticle(Particle.CLOUD, loc.clone().add(UtilMath.randomRange(-0.5F, 0.5F), 0.0D,
                            UtilMath.randomRange(-0.5F, 0.5F)), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                }
                if (this.phi > 9.42477796076938D) {
                    CloudEffect.playThunder(loc.clone().add(UtilMath.randomRange(-0.5F, 0.5F),
                            2.7D, UtilMath.randomRange(-0.5F, 0.5F)));
                    armor.remove();
                    cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 1L, 3L);
    }

    private static void playThunder(Location location) {
        UtilLocation.getClosestPlayersFromLocation(location, 4.0D).forEach(player ->
                player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_THUNDER, 0.05F, 0.0F));
        Location clone = location.clone();
        Vector vector = UtilMath.getRandomVector();
        vector.setY(-Math.abs(vector.getY() - 2.0D));
        int randomRange = UtilMath.randomRange(20, 40);
        for (int i = 0; i < 50; i++) {
            clone.add(vector.clone().multiply(i * 0.06F / 28.0F));
            UtilParticle.sendParticle(clone, Particle.FLAME, 1, new Vector(0, 0, 0), 0.0F);
            if (i == randomRange || i == randomRange + 10) {
                vector = UtilMath.getRandomVector();
                vector.setY(-Math.abs(vector.getY()));
            }
        }
    }
}
