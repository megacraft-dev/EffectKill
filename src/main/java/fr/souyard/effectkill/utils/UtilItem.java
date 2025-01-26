package fr.souyard.effectkill.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Color;

public class UtilItem {

    public static ColorData getGreatRandomColor() {
        byte b = 0;
        Color color = switch (UtilMath.randomRange(0, 8)) {
            case 0 -> Color.WHITE;
            case 1 -> {
                b = 1;
                yield Color.ORANGE;
            }
            case 2 -> {
                b = 2;
                yield Color.FUCHSIA;
            }
            case 3 -> {
                b = 4;
                yield Color.YELLOW;
            }
            case 4 -> {
                b = 5;
                yield Color.GREEN;
            }
            case 5 -> {
                b = 9;
                yield Color.NAVY;
            }
            case 6 -> {
                b = 10;
                yield Color.PURPLE;
            }
            case 7 -> {
                b = 11;
                yield Color.BLUE;
            }
            case 8 -> {
                b = 14;
                yield Color.RED;
            }
            default -> null;
        };
        return new ColorData(b, color);
    }

    @Getter
    @RequiredArgsConstructor
    public static class ColorData {

        private final byte data;
        private final Color color;
    }
}
