package com.shuttler67.demonomancy.reference;

import com.shuttler67.demonomancy.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public final class Textures {
    private static final String TEXTURE_LOCATION = "textures/";
    public static final ResourceLocation BLANK = ResourceLocationHelper.getResourceLocation(TEXTURE_LOCATION + "blank.png");

    public static final class Model {
        private static final String MODEL_TEXTURE_LOCATION = TEXTURE_LOCATION + "models/";
        public static final ResourceLocation PENTACLE_CENTER = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "pentacle_center.png");
        public static final ResourceLocation PENTACLE_LEVEL1 = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "pentacle_L1.png");
        public static final ResourceLocation PENTACLE_LEVEL2 = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "pentacle_L2.png");
        public static final ResourceLocation PENTACLE_LEVEL3 = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "pentacle_L3.png");
        public static final ResourceLocation PENTACLE_LEVEL4 = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "pentacle_L4.png");
        public static final ResourceLocation PENTACLE_LEVEL5 = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "pentacle_L5.png");
    }
}
