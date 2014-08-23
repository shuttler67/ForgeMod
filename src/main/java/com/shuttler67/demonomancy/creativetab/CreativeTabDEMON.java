package com.shuttler67.demonomancy.creativetab;

import com.shuttler67.demonomancy.init.ModBlocks;
import com.shuttler67.demonomancy.init.ModItems;
import com.shuttler67.demonomancy.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabDEMON
{
    public static final CreativeTabs DEMON_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(ModBlocks.pentacle);
        }
    };

}
