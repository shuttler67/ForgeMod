package com.shuttler67.demonomancy.utility;

import com.shuttler67.demonomancy.reference.Reference;
import net.minecraft.util.ResourceLocation;

//Pahimar's ResourceLocationHelper

public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(Reference.MOD_ID.toLowerCase(), path);
    }
}
