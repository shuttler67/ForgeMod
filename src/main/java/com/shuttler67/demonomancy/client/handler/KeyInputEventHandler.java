package com.shuttler67.demonomancy.client.handler;

import com.shuttler67.demonomancy.client.settings.Keybindings;
import com.shuttler67.demonomancy.reference.Key;
import com.shuttler67.demonomancy.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {

    private static Key getPressedKeybinding() {

        if (Keybindings.demonify.isPressed()) {

            return Key.DEMONIFY;
        }
        return Key.UNKNOWN;
    }
    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {

        Key key = getPressedKeybinding();

        if (key != Key.UNKNOWN) {
            LogHelper.info(key);
        }
    }
}

