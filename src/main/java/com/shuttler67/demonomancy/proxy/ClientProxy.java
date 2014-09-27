package com.shuttler67.demonomancy.proxy;

import com.shuttler67.demonomancy.client.handler.KeyInputEventHandler;
import com.shuttler67.demonomancy.client.renderer.tileentity.TileEntityRendererPentacle;
import com.shuttler67.demonomancy.client.settings.Keybindings;
import com.shuttler67.demonomancy.reference.RenderIds;
import com.shuttler67.demonomancy.tileentity.TileEntityPentacle;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(Keybindings.demonify);
    }

    @Override
    public void initRenderingAndTextures() {

        RenderIds.pentacle = RenderingRegistry.getNextAvailableRenderId();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPentacle.class, new TileEntityRendererPentacle());
    }

    @Override
    public void registerEventHandlers() {
        super.registerEventHandlers();

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
    }
}
