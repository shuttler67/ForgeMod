package com.shuttler67.circuitry.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init() {

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.golden_circuit), " r ", "rgr", " r ", 'r', "dustRedstone", 'g', "ingotGold"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.diamond_circuit), " r ", "rdr", " r ", 'r', "dustRedstone", 'd', "gemDiamond"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.iron_circuit), " r ", "rir", " r ", 'r', "dustRedstone", 'i', "ingotIron"));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.panel), Items.iron_ingot);
    }

}
