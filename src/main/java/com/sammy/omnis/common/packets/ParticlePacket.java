package com.sammy.omnis.common.packets;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ParticlePacket
{
    public enum typeEnum
    {
        spellBlade(0),
        vindicatorAxe(1);
        int type;
        typeEnum(int type)
        {
            this.type = type;
        }
    }
    int type;
    double posX;
    double posY;
    double posZ;
    public ParticlePacket(typeEnum type, double posX, double posY, double posZ)
    {
        this.type = type.type;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        
    }
    public ParticlePacket(int type, double posX, double posY, double posZ)
    {
        this.type = type;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
    
    public static ParticlePacket decode(PacketBuffer buf)
    {
        int strength = buf.readInt();
        double posX = buf.readDouble();
        double posY = buf.readDouble();
        double posZ = buf.readDouble();
        return new ParticlePacket(strength,posX,posY,posZ);
    }
    
    public void encode(PacketBuffer buf)
    {
        buf.writeInt(type);
        buf.writeDouble(posX);
        buf.writeDouble(posY);
        buf.writeDouble(posZ);
    }
    
    public void whenThisPacketIsReceived(Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() -> PacketEffects.particles(type, posX,posY,posZ));
        context.get().setPacketHandled(true);
    }
}