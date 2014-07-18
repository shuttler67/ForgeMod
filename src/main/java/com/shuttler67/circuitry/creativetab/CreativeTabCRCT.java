package com.shuttler67.circuitry.creativetab;

import com.shuttler67.circuitry.init.ModItems;
import com.shuttler67.circuitry.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCRCT
{
    public static final CreativeTabs CRCT_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.golden_circuit;
        }
    };

}
