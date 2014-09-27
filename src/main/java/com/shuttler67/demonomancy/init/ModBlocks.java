package com.shuttler67.demonomancy.init;

import com.shuttler67.demonomancy.block.BlockPentacle;
import com.shuttler67.demonomancy.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockPentacle pentacle = new BlockPentacle();

    public static void init()
    {
        GameRegistry.registerBlock(pentacle, "pentacle");

    }
}
