package com.shuttler67.circuitry.block;

import com.shuttler67.circuitry.creativetab.CreativeTabCRCT;
import com.shuttler67.circuitry.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockCRCT extends Block
{
    public BlockCRCT(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabCRCT.CRCT_TAB);
    }

    public BlockCRCT()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabCRCT.CRCT_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
