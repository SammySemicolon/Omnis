package com.sammy.omnis.common.packets;

import com.sammy.omnis.core.registry.ParticleRegistry;
import com.sammy.omnis.core.systems.particles.ParticleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

import java.awt.*;

public class PacketEffects
{
    public static void particles(int type, double posX, double posY, double posZ)
    {
        World world = Minecraft.getInstance().world;
        switch (type)
        {
            case 0:
            {
                Color color1 = new Color(250, 89, 140);
                Color color2 = new Color(253, 187, 106);
                Color color3 = new Color(157, 207, 224);
                ParticleManager.create(ParticleRegistry.WISP_PARTICLE).setAlpha(0.4f, 0.1f).setLifetime(6).setSpin(0.8f).setScale(0.3f, 0).setColor(color1, color1).randomOffset(0.1f).enableNoClip().randomVelocity(0.075f, 0.075f).repeat(world, posX, posY, posZ, 20).setColor(color2, color2).repeat(world, posX, posY, posZ, 20).setColor(color3, color3).repeat(world, posX, posY, posZ, 20);
                ParticleManager.create(ParticleRegistry.WISP_PARTICLE).setAlpha(0.6f, 0.1f).setLifetime(12).setSpin(0.8f).setScale(0.08f, 0).setColor(color1, color1).randomOffset(0.2f).enableGravity().randomVelocity(0.1f, 0.1f).addVelocity(0, 0.1f, 0).repeat(world, posX, posY, posZ, 10).setColor(color2, color2).repeat(world, posX, posY, posZ, 10).setColor(color3, color3).repeat(world, posX, posY, posZ, 10);
                break;
            }
            case 1:
            {
                Color color = new Color(40, 72, 165);
                ParticleManager.create(ParticleRegistry.WISP_PARTICLE).setAlpha(0.2f, 0.1f).setLifetime(12).setSpin(0.8f).setScale(0.4f, 0).setColor(color, color.darker()).randomOffset(0.1f).enableNoClip().randomVelocity(0.075f, 0.075f).addVelocity(0, -0.05f, 0).repeat(world, posX, posY, posZ, 20);
                ParticleManager.create(ParticleRegistry.WISP_PARTICLE).setAlpha(0.6f, 0.1f).setLifetime(18).setSpin(0.8f).setScale(0.08f, 0).setColor(color, color.brighter()).randomOffset(0.2f).enableGravity().randomVelocity(0.1f, 0.1f).addVelocity(0, -0.1f, 0).repeat(world, posX, posY, posZ, 10);
                break;
            }
        }
    }
}
