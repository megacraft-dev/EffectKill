package fr.souyard.effectkill.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemFactory {

    public static ItemStack create(Material material, byte data, String displayName, String... lore) {
        ItemStack itemStack = new ItemStack(material, 1, data);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        if (lore != null) {
            itemMeta.setLore(Arrays.asList(lore));
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
