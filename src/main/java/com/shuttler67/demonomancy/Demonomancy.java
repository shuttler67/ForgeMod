package com.shuttler67.demonomancy;

import com.shuttler67.demonomancy.handler.ConfigurationHandler;
import com.shuttler67.demonomancy.init.ModBlocks;
import com.shuttler67.demonomancy.init.ModItems;
import com.shuttler67.demonomancy.init.Recipes;
import com.shuttler67.demonomancy.network.MessagePentacleSync;
import com.shuttler67.demonomancy.network.MessagePentacleSyncRequest;
import com.shuttler67.demonomancy.proxy.IProxy;
import com.shuttler67.demonomancy.reference.Reference;
import com.shuttler67.demonomancy.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

import static cpw.mods.fml.common.Mod.EventHandler;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Demonomancy
{
    @Mod.Instance(Reference.MOD_ID)
    public static Demonomancy instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static SimpleNetworkWrapper network;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        network = NetworkRegistry.INSTANCE.newSimpleChannel("demonSH67");

        network.registerMessage(MessagePentacleSync.Handler.class, MessagePentacleSync.class, 0, Side.CLIENT);
        network.registerMessage(MessagePentacleSyncRequest.Handler.class, MessagePentacleSyncRequest.class, 1, Side.SERVER);

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        proxy.registerKeyBindings();

        ModItems.init();

        ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Initialize mod tile entities
        proxy.registerTileEntities();

        // Initialize custom rendering and pre-load textures (Client only)
        proxy.initRenderingAndTextures();

        // Register the Items Event Handler
        proxy.registerEventHandlers();

        Recipes.init();

        LogHelper.info("Initialization Complete!");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }

}
