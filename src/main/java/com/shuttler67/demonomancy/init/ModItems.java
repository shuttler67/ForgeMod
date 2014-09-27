package com.shuttler67.demonomancy.init;

import com.shuttler67.demonomancy.item.ItemDEMON;
import com.shuttler67.demonomancy.item.ItemObsidianTablet;
import com.shuttler67.demonomancy.item.ItemRedChalk;
import com.shuttler67.demonomancy.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final ItemDEMON itemDemon = new ItemDEMON();

    public static final ItemRedChalk redChalk = new ItemRedChalk();
    public static final ItemObsidianTablet obsidianTablet = new ItemObsidianTablet();

    public static void init()
    {
        GameRegistry.registerItem(itemDemon, "itemDemon");

        GameRegistry.registerItem(redChalk, "redChalk");
        GameRegistry.registerItem(obsidianTablet, "obsidianTablet");
    }

}
