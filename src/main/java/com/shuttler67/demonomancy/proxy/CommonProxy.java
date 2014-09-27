package com.shuttler67.demonomancy.proxy;


import com.shuttler67.demonomancy.handler.ConfigurationHandler;
import com.shuttler67.demonomancy.reference.Names;
import com.shuttler67.demonomancy.tileentity.TileEntityPentacle;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IProxy
{
    @Override
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityPentacle.class, Names.Blocks.PENTACLE);
    }

    @Override
    public void registerEventHandlers() {
        
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
    }
}
