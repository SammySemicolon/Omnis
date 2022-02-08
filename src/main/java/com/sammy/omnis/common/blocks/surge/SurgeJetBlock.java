package com.sammy.omnis.common.blocks.surge;

import net.minecraft.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.level.server.ServerLevel;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class SurgeJetBlock extends AirBlock {
    public SurgeJetBlock(Properties properties) {
        super(properties);
    }
}