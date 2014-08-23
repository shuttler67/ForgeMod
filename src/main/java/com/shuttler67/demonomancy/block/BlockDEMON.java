package com.shuttler67.demonomancy.block;

import com.shuttler67.demonomancy.creativetab.CreativeTabDEMON;
import com.shuttler67.demonomancy.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockDEMON extends Block
{
    public BlockDEMON(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabDEMON.DEMON_TAB);
    }

    public BlockDEMON()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabDEMON.DEMON_TAB);
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
