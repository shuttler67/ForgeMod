package com.shuttler67.demonomancy.block;

import com.shuttler67.demonomancy.init.ModItems;
import com.shuttler67.demonomancy.reference.Names;
import com.shuttler67.demonomancy.reference.RenderIds;
import com.shuttler67.demonomancy.tileentity.TileEntityPentacle;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockPentacle extends BlockContainerDEMON
{
    private boolean shouldDrop = false;

    public BlockPentacle()
    {
        super(Material.circuits);
        this.setBlockName(Names.Blocks.PENTACLE);

        this.setBlockBounds(0F, 0F, 0F, 1F, 0.001F, 1F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityPentacle();
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
        return RenderIds.pentacle;
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
    {
        return side == 1 && this.canPlaceBlockAt(world, x, y, z);
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
        if (!world.isRemote) {
            if (!World.doesBlockHaveSolidTopSurface(world, x, y-1, z)) {
                breakBlock(world, x, y, z, this, world.getBlockMetadata(x, y, z));
                world.setBlockToAir(x, y, z);
            }
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile != null && tile instanceof TileEntityPentacle)
            if (((TileEntityPentacle) tile).isCenter)
                shouldDrop = true;
        super.breakBlock(world, x, y, z, block, metadata);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {

        ArrayList<ItemStack> l = new ArrayList<ItemStack>( );
        if (shouldDrop) {

            l.add( new ItemStack(ModItems.obsidianTablet));
            shouldDrop = false;
        }
        return l;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        if (world.isRemote || !world.getBlock(x, y, z).isReplaceable(world, x, y, z) || !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z))
            return false;

        world.setBlockToAir(x, y, z);
        return true;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        ItemStack heldItem = entityPlayer.getHeldItem();

        if (tileEntity instanceof TileEntityPentacle)
        {
            TileEntityPentacle tileEntityPentacle = (TileEntityPentacle) tileEntity;

            if (heldItem.getItem() == ModItems.redChalk) {
                if (tileEntityPentacle.isCenter && tileEntityPentacle.level == 0) {
                    heldItem.damageItem(1, entityPlayer);
                    ++tileEntityPentacle.level;
                } else {
                    heldItem.damageItem(1, entityPlayer);
                    tileEntityPentacle.reset();
                }
                return true;
            } else if (heldItem.getItem() == Items.netherbrick) {
                if (tileEntityPentacle.level == 1) {
                    heldItem.damageItem(1, entityPlayer);
                    ++tileEntityPentacle.level;
                    return true;
                }
            } else if (heldItem.getItem() == Items.redstone) {
                if (tileEntityPentacle.level == 2) {
                    heldItem.damageItem(1, entityPlayer);
                    ++tileEntityPentacle.level;
                    return true;
                }
            } else if (heldItem.getItem() == Item.getItemFromBlock(Blocks.obsidian)) {
                if (tileEntityPentacle.level == 3) {
                    heldItem.damageItem(1, entityPlayer);
                    ++tileEntityPentacle.level;
                    return true;
                }
            } else if (heldItem.getItem() == Items.gold_ingot) {
                if (tileEntityPentacle.level == 4) {
                    heldItem.damageItem(1, entityPlayer);
                    ++tileEntityPentacle.level;
                    return true;
                }
            }
        }
        return false;
    }
}
