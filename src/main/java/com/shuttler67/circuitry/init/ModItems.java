package com.shuttler67.circuitry.init;

import com.shuttler67.circuitry.item.ItemCRCT;
import com.shuttler67.circuitry.item.ItemDiamondCircuit;
import com.shuttler67.circuitry.item.ItemGoldenCircuit;
import com.shuttler67.circuitry.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final ItemCRCT golden_circuit = new ItemGoldenCircuit();
    public static final ItemCRCT diamond_circuit = new ItemDiamondCircuit();

    public static void init()
    {
        GameRegistry.registerItem(golden_circuit, "golden_circuit");
        GameRegistry.registerItem(diamond_circuit, "diamond_circuit");
    }

}
