package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.utils.ColoredParticle;
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

public class RainwealthEffect {

    public static void death(Player player) {
        Location loc = player.getLocation();
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
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

            public void run() {
                this.phi += 0.3141592653589793D;
                for (int i = 0; i < 3; i++) {
                    new ColoredParticle(Particle.REDSTONE, loc.clone().add(UtilMath.randomRange(-0.8F, 0.8F), 2.5D,
                            UtilMath.randomRange(-0.8F, 0.8F)), 255, 255, 0).send();
                    new ColoredParticle(Particle.REDSTONE, loc.clone().add(UtilMath.randomRange(-0.8F, 0.8F), 2.5D,
                            UtilMath.randomRange(-0.8F, 0.8F)), 255, 255, 0).send();
                    new ColoredParticle(Particle.REDSTONE, loc.clone().add(UtilMath.randomRange(0.8F, -0.8F), 2.5D,
                            UtilMath.randomRange(0.8F, -0.8F)), 255, 255, 0).send();
                    new ColoredParticle(Particle.REDSTONE, loc.clone().add(UtilMath.randomRange(0.8F, -0.8F), 2.5D,
                            UtilMath.randomRange(0.8F, -0.8F)), 255, 185, 0).send();
                    new ColoredParticle(Particle.REDSTONE, loc.clone().add(UtilMath.randomRange(-0.8F, 0.8F), 2.7D,
                            UtilMath.randomRange(-0.8F, 0.8F)), 255, 255, 0).send();
                    new ColoredParticle(Particle.REDSTONE, loc.clone().add(UtilMath.randomRange(-0.8F, 0.8F), 2.7D,
                            UtilMath.randomRange(-0.8F, 0.8F)), 255, 185, 0).send();
                    new ColoredParticle(Particle.REDSTONE, loc.clone().add(UtilMath.randomRange(0.8F, -0.8F), 2.7D,
                            UtilMath.randomRange(0.8F, -0.8F)), 255, 255, 0).send();
                    new ColoredParticle(Particle.REDSTONE, loc.clone().add(UtilMath.randomRange(0.8F, -0.8F), 2.7D,
                            UtilMath.randomRange(0.8F, -0.8F)), 255, 185, 0).send();
                    UtilParticle.sendParticle(loc.clone().add(UtilMath.randomRange(-0.8F, 0.8F), 2.5D,
                                    UtilMath.randomRange(-0.8F, 0.8F)), Particle.ITEM_CRACK, 0, new Vector(0.0D, -1.5D, 0.0D),
                            1.0F, new ItemStack(Material.GOLD_INGOT));
                }
                if (this.phi > 18.84955592153876D) {
                    RainwealthEffect.playThunder(loc.clone().add(UtilMath.randomRange(-0.5F, 0.5F), 2.7D,
                            UtilMath.randomRange(-0.5F, 0.5F)));
                    armor.remove();
                    cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 2L);
    }

    private static void playThunder(Location location) {
        UtilLocation.getClosestPlayersFromLocation(location, 4.0D).forEach(player ->
                player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 0.05F, 0.0F));
        Location clone = location.clone();
        Vector vector = UtilMath.getRandomVector();
        vector.setY(-Math.abs(vector.getY() - 2.0D));
        int randomRange = UtilMath.randomRange(20, 40);
        for (int i = 0; i < 50; i++) {
            clone.add(vector.clone().multiply(i * 0.06F / 28.0F));
            new ColoredParticle(Particle.REDSTONE, clone, 255, 150, 0).send();
            if (i == randomRange || i == randomRange + 10) {
                vector = UtilMath.getRandomVector();
                vector.setY(-Math.abs(vector.getY()));
            }
        }
    }
}
