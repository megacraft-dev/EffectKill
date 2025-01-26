package fr.souyard.effectkill.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Color;

public class UtilItem {

    public static ColorData getGreatRandomColor() {
        byte b = 0;
        Color color = null;
        switch (UtilMath.randomRange(0, 8)) {
            case 0: {
                color = Color.WHITE;
                break;
            }
            case 1: {
                b = 1;
                color = Color.ORANGE;
                break;
            }
            case 2: {
                b = 2;
                color = Color.FUCHSIA;
                break;
            }
            case 3: {
                b = 4;
                color = Color.YELLOW;
                break;
            }
            case 4: {
                b = 5;
                color = Color.GREEN;
                break;
            }
            case 5: {
                b = 9;
                color = Color.NAVY;
                break;
            }
            case 6: {
                b = 10;
                color = Color.PURPLE;
                break;
            }
            case 7: {
                b = 11;
                color = Color.BLUE;
                break;
            }
            case 8: {
                b = 14;
                color = Color.RED;
                break;
            }
        }
        return new ColorData(b, color);
    }

    @Getter
    @RequiredArgsConstructor
    public static class ColorData {

        private final byte data;
        private final Color color;
    }
}
