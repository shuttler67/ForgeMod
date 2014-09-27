package com.shuttler67.demonomancy.network;

import com.shuttler67.demonomancy.tileentity.TileEntityPentacle;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class MessagePentacleSync implements IMessage{
    private static final int intSize = 4;
    private int x;
    private int y;
    private int z;

    private boolean isCenter;
    private byte pentacleX;
    private byte pentacleY;
    private byte level;

    public MessagePentacleSync() {
    }

    public MessagePentacleSync(int x, int y, int z, boolean isCenter, byte pentacleX, byte pentacleY, byte level) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.isCenter = isCenter;
        this.pentacleX = pentacleX;
        this.pentacleY = pentacleY;
        this.level = level;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = ByteBufUtils.readVarInt(buf, intSize);
        y = ByteBufUtils.readVarShort(buf);
        z = ByteBufUtils.readVarInt(buf, intSize);

        isCenter = buf.readBoolean();
        pentacleX = buf.readByte();
        pentacleY = buf.readByte();
        level = buf.readByte();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf, x, intSize);
        ByteBufUtils.writeVarShort(buf, y);
        ByteBufUtils.writeVarInt(buf, z, intSize);

        buf.writeBoolean(isCenter);
        buf.writeByte(pentacleX);
        buf.writeByte(pentacleY);
        buf.writeByte(level);
    }

    public static class Handler implements IMessageHandler<MessagePentacleSync, IMessage> {
        @Override
        public IMessage onMessage(MessagePentacleSync message, MessageContext ctx) {
            TileEntity tile = Minecraft.getMinecraft().theWorld.getTileEntity(message.x, message.y, message.z);

            if (tile != null && tile instanceof TileEntityPentacle) {
                TileEntityPentacle tileP = (TileEntityPentacle) tile;

                tileP.isCenter = message.isCenter;
                tileP.setPentaclePos(message.pentacleX, message.pentacleY);
                tileP.level = message.level;
            }
            return null;
        }
    }
}
