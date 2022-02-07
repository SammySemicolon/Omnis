package com.sammy.omnis.client.particle.wisp;

import com.mojang.serialization.Codec;
import com.sammy.omnis.core.systems.particles.data.ParticleData;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.ParticleType;

public class WispParticleType extends ParticleType<ParticleData> {
    public WispParticleType() {
        super(false, ParticleData.DESERIALIZER);
    }

    @Override
    public Codec<ParticleData> func_230522_e_() {
        return ParticleData.codecFor(this);
    }

    public static class Factory implements IParticleFactory<ParticleData> {
        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }

        @Override
        public Particle makeParticle(ParticleData data, ClientWorld world, double x, double y, double z, double mx, double my, double mz) {
            WispParticle ret = new WispParticle(world, data, x, y, z, mx, my, mz);
            ret.selectSpriteRandomly(sprite);
            return ret;
        }
    }
}
