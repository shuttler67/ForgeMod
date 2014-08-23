package com.shuttler67.demonomancy.block;

import com.shuttler67.demonomancy.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPentacle extends BlockDEMON implements ITileEntityProvider
{
    public BlockPentacle()
    {
        super(Material.circuits);
        this.setBlockName("pentacle");

        this.setBlockBounds(-1F, 0F, -1F, 2F, 0.001F, 2F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    public boolean canPlaceBlockOnSide(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_)
    {
        return p_149707_5_ == 1 && this.canPlaceBlockAt(p_149707_1_, p_149707_2_, p_149707_3_, p_149707_4_);
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    @Override
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        for (int i=-1; i <= 1; i++) {
            for (int j=-1; j <= 1; j++) {
                if (!p_149742_1_.getBlock(p_149742_2_ + i, p_149742_3_, p_149742_4_ + j).isReplaceable(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_)) {
                    return false;
                }
                if (!p_149742_1_.getBlock(p_149742_2_ + i, p_149742_3_ - 1, p_149742_4_ + j).isOpaqueCube()) {
                    return false;
                }
            }
        }
        return true;
    }

}
