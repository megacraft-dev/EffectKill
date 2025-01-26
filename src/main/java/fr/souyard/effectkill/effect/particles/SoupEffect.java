package fr.souyard.effectkill.effect.particles;

import fr.souyard.effectkill.Main;
import fr.souyard.effectkill.utils.ColoredParticle;
import fr.souyard.effectkill.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SoupEffect {

    private static final Random r = new Random();
    private static final List<Item> items = new ArrayList<>();

    public static void death(Player player) {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            for (int i = 0; i < 30; i++) {
                Item ITEM = player.getWorld().dropItem(player.getLocation(), ItemFactory.create(
                        Material.matchMaterial(Main.getInstance().getConfig().getString("EffectKill.Gui.SOUP.ID")),
                        (byte) 0, UUID.randomUUID().toString()));
                ITEM.setPickupDelay(300);
                ITEM.setVelocity(new Vector(r.nextDouble() - 0.5D, r.nextDouble() / 2.0D, r.nextDouble() - 0.5D));
                SoupEffect.items.add(ITEM);
            }
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
                for (Item i : SoupEffect.items) {
                    new ColoredParticle(Particle.REDSTONE, i.getLocation(), 0, 0, 0).send();
                    i.remove();
                }
            }, 50L);
        }, 9L);
    }
}

