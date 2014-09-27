package com.shuttler67.demonomancy.utility;

import net.minecraft.util.MathHelper;

public class ModMathHelper {

    public static final float PI = 3.14159265359f;

    public static double[] rotateVector(double x, double y, float angle) {
        angle = (float) Math.toDegrees(angle);
        double newx = MathHelper.cos(angle)*x - MathHelper.sin(angle)*y;
        double newy = MathHelper.sin(angle)*x + MathHelper.cos(angle)*y;
        return new double[]{newx, newy};
    }
    public static double[] rotateVector(double x, double y, double angle) {
        double newx = MathHelper.cos((float) angle)*x - MathHelper.sin((float) angle)*y;
        double newy = MathHelper.sin((float) angle)*x + MathHelper.cos((float) angle)*y;
        return new double[]{newx, newy};
    }
}
