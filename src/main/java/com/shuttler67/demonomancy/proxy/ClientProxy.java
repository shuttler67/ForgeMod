package com.shuttler67.demonomancy.proxy;

import com.shuttler67.demonomancy.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(Keybindings.demonify);
    }
}
