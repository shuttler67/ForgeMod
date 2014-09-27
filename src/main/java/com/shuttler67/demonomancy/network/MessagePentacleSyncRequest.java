package com.shuttler67.demonomancy.network;

import com.shuttler67.demonomancy.tileentity.TileEntityPentacle;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessagePentacleSyncRequest implements IMessage {
    private static final int intSize = 4;
    int x;
    int y;
    int z;

    public MessagePentacleSyncRequest() {
    }

    public MessagePentacleSyncRequest(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = ByteBufUtils.readVarInt(buf, intSize);
        y = ByteBufUtils.readVarShort(buf);
        z = ByteBufUtils.readVarInt(buf, intSize);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf, x, intSize);
        ByteBufUtils.writeVarShort(buf, y);
        ByteBufUtils.writeVarInt(buf, z, intSize);
    }

    public static class Handler implements IMessageHandler<MessagePentacleSyncRequest, MessagePentacleSync> {
        @Override
        public MessagePentacleSync onMessage(MessagePentacleSyncRequest message, MessageContext ctx)
        {
            TileEntity tile = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);

            if (tile != null && tile instanceof TileEntityPentacle) {
                TileEntityPentacle tileP = (TileEntityPentacle) tile;
                return new MessagePentacleSync(message.x, message.y, message.z, tileP.isCenter, (byte)tileP.getPentacleX(), (byte)tileP.getPentacleY(), (byte)tileP.level);
            }
            return null;
        }
    }
}
