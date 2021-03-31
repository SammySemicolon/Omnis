package com.sammy.omnis.network.packets;

import com.sammy.omnis.core.init.OmnisParticles;
import com.sammy.omnis.core.particles.ParticleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.awt.*;
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
        context.get().enqueueWork(() -> {
            World world = Minecraft.getInstance().world;
            switch (type)
            {
                case 0 :
                {
                    Color color1 = new Color(250, 89, 140);
                    Color color2 = new Color(253, 187, 106);
                    Color color3 = new Color(157, 207, 224);
                    ParticleManager.create(OmnisParticles.WISP_PARTICLE).setAlpha(0.4f, 0.1f).setLifetime(6).setSpin(0.8f).setScale(0.3f, 0).setColor(color1,color1).randomOffset(0.1f).enableNoClip().randomVelocity(0.075f, 0.075f).repeat(world, posX,posY,posZ, 20).setColor(color2,color2).repeat(world, posX,posY,posZ, 20).setColor(color3,color3).repeat(world, posX,posY,posZ, 20);
                    ParticleManager.create(OmnisParticles.WISP_PARTICLE).setAlpha(0.6f, 0.1f).setLifetime(12).setSpin(0.8f).setScale(0.08f, 0).setColor(color1,color1).randomOffset(0.2f).enableGravity().randomVelocity(0.1f, 0.1f).addVelocity(0,0.1f,0).repeat(world, posX,posY,posZ, 10).setColor(color2,color2).repeat(world, posX,posY,posZ, 10).setColor(color3,color3).repeat(world, posX,posY,posZ, 10);
                    break;
                }
                case 1 :
                {

                    Color color = new Color(40, 72, 165);
                    ParticleManager.create(OmnisParticles.WISP_PARTICLE).setAlpha(0.2f, 0.1f).setLifetime(12).setSpin(0.8f).setScale(0.4f, 0).setColor(color,color.darker()).randomOffset(0.1f).enableNoClip().randomVelocity(0.075f, 0.075f).addVelocity(0,-0.05f,0).repeat(world, posX,posY,posZ, 20);
                    ParticleManager.create(OmnisParticles.WISP_PARTICLE).setAlpha(0.6f, 0.1f).setLifetime(18).setSpin(0.8f).setScale(0.08f, 0).setColor(color,color.brighter()).randomOffset(0.2f).enableGravity().randomVelocity(0.1f, 0.1f).addVelocity(0,-0.1f,0).repeat(world, posX,posY,posZ, 10);
                    break;
                }
            }
        });
        context.get().setPacketHandled(true);
    }
}