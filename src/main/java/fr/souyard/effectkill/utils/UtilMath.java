package fr.souyard.effectkill.utils;

import org.bukkit.util.Vector;

import java.util.Random;

public class UtilMath {

    public static Random random = new Random(System.nanoTime());

    public static float randomRange(float n, float n2) {
        return n + (float) Math.random() * (n2 - n);
    }

    public static int randomRange(int n, int n2) {
        return (new Random()).nextInt(n2 - n + 1) + n;
    }

    public static double randomRange(double n, double n2) {
        return (Math.random() < 0.5D) ? ((1.0D - Math.random()) * (n2 - n) + n) : (Math.random() * (n2 - n) + n);
    }

    public static int getRandomWithExclusion(int n, int n2, int... array) {
        int n3 = n + random.nextInt(n2 - n + 1 - array.length);
        for (int length = array.length, n4 = 0; n4 < length && n3 >= array[n4]; ) {
            n3++;
            n4++;
        }
        return n3;
    }

    public static Vector getRandomVector() {
        return (new Vector(random.nextDouble() * 2.0D - 1.0D, random.nextDouble() * 2.0D - 1.0D, random.nextDouble() * 2.0D - 1.0D)).normalize();
    }
}
