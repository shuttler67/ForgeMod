package com.shuttler67.demonomancy.item;

import com.shuttler67.demonomancy.init.ModBlocks;
import com.shuttler67.demonomancy.reference.Names;
import com.shuttler67.demonomancy.tileentity.TileEntityPentacle;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemObsidianTablet extends ItemDEMON {

    public ItemObsidianTablet() {
        super();
        this.setUnlocalizedName(Names.Items.OBSIDIAN_TABLET);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote) {
            if (player.canPlayerEdit(x, y, z, side, stack)) {
                y++;
                if (ModBlocks.pentacle.canPlaceBlockOnSide(world, x, y, z, side)) {

                    if (!world.setBlock(x, y, z, ModBlocks.pentacle))
                        return false;

                    Block newBlock = world.getBlock(x, y, z);

                    if (newBlock == ModBlocks.pentacle) {

                        if (!player.capabilities.isCreativeMode)
                            --stack.stackSize;

                        TileEntityPentacle tileP = (TileEntityPentacle) world.getTileEntity(x, y, z);
                        tileP.isCenter = true;

                        int l = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
                        world.setBlockMetadataWithNotify(x, y, z, l, 3);

                        tileP.updateEntity();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
