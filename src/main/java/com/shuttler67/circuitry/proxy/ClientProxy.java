package com.shuttler67.circuitry.proxy;

import com.shuttler67.circuitry.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(Keybindings.demonify);
    }
}
