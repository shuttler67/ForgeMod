package com.shuttler67.circuitry.init;

import com.shuttler67.circuitry.block.BlockCRCT;
import com.shuttler67.circuitry.block.BlockPanel;
import com.shuttler67.circuitry.handler.ConfigurationHandler;
import com.shuttler67.circuitry.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockCRCT panel = new BlockPanel();

    public static void init()
    {
        GameRegistry.registerBlock(panel, "panel");

    }
}
