package com.sammy.omnis.network.packets;

import com.sammy.omnis.core.init.OmnisParticles;
import com.sammy.omnis.core.particles.ParticleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.awt.*;
import java.util.function.Supplier;

public class SpellBladeParticlePacket
{
    float strength;
    double posX;
    double posY;
    double posZ;
    public SpellBladeParticlePacket(float strength, double posX, double posY, double posZ)
    {
        this.strength = strength;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
    
    public static SpellBladeParticlePacket decode(PacketBuffer buf)
    {
        float strength = buf.readFloat();
        double posX = buf.readDouble();
        double posY = buf.readDouble();
        double posZ = buf.readDouble();
        return new SpellBladeParticlePacket(strength,posX,posY,posZ);
    }
    
    public void encode(PacketBuffer buf)
    {
        buf.writeFloat(strength);
        buf.writeDouble(posX);
        buf.writeDouble(posY);
        buf.writeDouble(posZ);
    }
    
    public void whenThisPacketIsReceived(Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() -> {
            World world = Minecraft.getInstance().world;
            Color color1 = new Color(232, 71, 90);
            Color color2 = new Color(245, 205, 59);
            Color color3 = new Color(63, 157, 240);
            ParticleManager.create(OmnisParticles.WISP_PARTICLE).setAlpha(0.4f, 0.1f).setLifetime(6).setSpin(0.8f).setScale(0.3f, 0).setColor(color1,color1).randomOffset(0.1f).enableNoClip().randomVelocity(0.075f, 0.075f).repeat(world, posX,posY,posZ, 20).setColor(color2,color2).repeat(world, posX,posY,posZ, 20).setColor(color3,color3).repeat(world, posX,posY,posZ, 20);
            ParticleManager.create(OmnisParticles.WISP_PARTICLE).setAlpha(0.6f, 0.1f).setLifetime(12).setSpin(0.8f).setScale(0.08f, 0).setColor(color1,color1).randomOffset(0.2f).enableGravity().randomVelocity(0.1f, 0.1f).addVelocity(0,0.1f,0).repeat(world, posX,posY,posZ, 10).setColor(color2,color2).repeat(world, posX,posY,posZ, 10).setColor(color3,color3).repeat(world, posX,posY,posZ, 10);

        });
        context.get().setPacketHandled(true);
    }
}