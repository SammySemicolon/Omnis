package com.sammy.omnis.common.blocks.surge;

import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SurgeJetBlock extends AirBlock {
    public SurgeJetBlock(Properties properties) {
        super(properties);
    }
}