package fr.souyard.effectkill.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class UtilLocation {

    public static List<Player> getClosestPlayersFromLocation(Location location, double n) {
        List<Player> list = new ArrayList<>();
        double n2 = n * n;
        for (Player player : location.getWorld().getPlayers()) {
            if (!player.hasMetadata("NPC")
                    && player.getLocation().add(0.0D, 0.85D, 0.0D).distanceSquared(location) <= n2) {
                list.add(player);
            }
        }
        return list;
    }
}
