package com.shuttler67.demonomancy.tileentity;

import com.shuttler67.demonomancy.Demonomancy;
import com.shuttler67.demonomancy.network.MessagePentacleSyncRequest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPentacle extends TileEntity {

    private int pentacleSize = 5;
    private int pentacleX;
    private int pentacleY;
    public int level = 0;
    public boolean isCenter = false;
    public boolean justPlaced = true;

    private int networkCooldown = 0;

    private boolean findAndCopyCenter() {

        TileEntityPentacle tile = find(1);

        if (!isCenter)
            level = 1;

        if (tile != null) {

            int px = xCoord - tile.xCoord;
            int py = zCoord - tile.zCoord;

            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, tile.getBlockMetadata(), 3);

            for (int i = 0; i < getBlockMetadata(); ++i) {
                int tmpx = py;
                py = -px;
                px = tmpx;
            }

            py = -py;

            if (Math.abs(px) <= pentacleSize / 2 && Math.abs(py) <= pentacleSize / 2) {
                pentacleX = px + pentacleSize/2;
                pentacleY = py + pentacleSize/2;

                return true;
            }
        }

        pentacleX = pentacleSize / 2;
        if (isCenter) {
            pentacleY = pentacleSize / 2;
        } else {
            pentacleY = 0;
        }
        return false;
    }

    private TileEntityPentacle find(int stack) {
        int x = stack, y = stack;

        int ix = 0, iy = -1;

        do {
            TileEntity tile = worldObj.getTileEntity(xCoord + x, yCoord, zCoord + y);

            if (tile != null && tile instanceof TileEntityPentacle) {

                TileEntityPentacle tileP = (TileEntityPentacle) tile;
                if (tileP.isCenter)
                    return tileP;
            }

            if (Math.abs(x+ix) > stack || Math.abs(y+iy) > stack) {
                int tmpix = iy;
                iy = -ix;
                ix = tmpix;
            }

            x += ix; y += iy;

        } while (x != stack || y != stack);

        if (stack < pentacleSize/2)
            return find(stack + 1);
        return null;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        pentacleSize = nbtTagCompound.getByte("pSize");
        pentacleX = nbtTagCompound.getByte("pX");
        pentacleY = nbtTagCompound.getByte("pY");
        level = nbtTagCompound.getByte("level");
        isCenter = nbtTagCompound.getBoolean("center");
        justPlaced = nbtTagCompound.getBoolean("justPlaced");
    }

    @Override
    public void updateEntity()
    {
        if (!worldObj.isRemote) {
            if (justPlaced) {
                findAndCopyCenter();
                justPlaced = false;
            }
        } else {
            if (networkCooldown > 0)
                --networkCooldown;

            if (justPlaced && networkCooldown == 0) {
                Demonomancy.network.sendToServer(new MessagePentacleSyncRequest(xCoord, yCoord, zCoord));
                networkCooldown = 15;
                justPlaced = false;
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte("pSize", (byte)pentacleSize);
        nbtTagCompound.setByte("pX", (byte)pentacleX);
        nbtTagCompound.setByte("pY", (byte)pentacleY);
        nbtTagCompound.setByte("level", (byte)level);
        nbtTagCompound.setBoolean("center", isCenter);
        nbtTagCompound.setBoolean("justPlaced", justPlaced);
    }

    public int getPentacleSize() {
        return pentacleSize;
    }

    public int getPentacleX() {
        return pentacleX;
    }

    public int getPentacleY() {
        return pentacleY;
    }

    public void reset() {
        justPlaced = true;
    }

    @SideOnly(Side.CLIENT)
    public void setPentaclePos(byte x, byte y) {
        pentacleX = x;
        pentacleY = y;
    }
}
