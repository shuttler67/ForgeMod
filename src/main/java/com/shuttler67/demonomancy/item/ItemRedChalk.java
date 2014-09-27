package com.shuttler67.demonomancy.item;

import com.shuttler67.demonomancy.init.ModBlocks;
import com.shuttler67.demonomancy.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRedChalk extends ItemDEMON {

    public ItemRedChalk() {
        super();
        this.setUnlocalizedName(Names.Items.RED_CHALK);
        setMaxDamage(16);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote) {
            if (player.canPlayerEdit(x, y, z, side, stack)) {
                if (ModBlocks.pentacle.canPlaceBlockOnSide(world, x, y + 1, z, side)) {

                    if (!world.setBlock(x, y+1, z, ModBlocks.pentacle))
                        return false;

                    Block newBlock = world.getBlock(x, y+1, z);

                    if (newBlock == ModBlocks.pentacle) {
                        stack.damageItem(1, player);
                        world.getTileEntity(x, y+1, z).updateEntity();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
