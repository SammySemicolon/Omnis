package com.sammy.omnis.client.particle.wisp;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sammy.omnis.RenderUtil;
import com.sammy.omnis.core.systems.particles.GenericParticle;
import com.sammy.omnis.core.systems.particles.ParticleRendering;
import com.sammy.omnis.core.systems.particles.data.ParticleData;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.world.ClientWorld;

public class WispParticle extends GenericParticle
{
    public WispParticle(ClientWorld world, ParticleData data, double x, double y, double z, double vx, double vy, double vz) {
        super(world, data, x, y, z, vx, vy, vz);
    }

    @Override
    protected int getBrightnessForRender(float partialTicks) {
        return 0xF000F0;
    }

    @Override
    public void renderParticle(IVertexBuilder b, ActiveRenderInfo info, float pticks) {
        super.renderParticle(ParticleRendering.getDelayedRender().getBuffer(RenderUtil.GLOWING_PARTICLE), info, pticks);
    }
}
