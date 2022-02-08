package com.sammy.omnis.common.blocks.surge;

import com.sammy.omnis.common.blocks.OmnisDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.level.IBlockReader;
import net.minecraft.world.level.Level;

import java.awt.*;
import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock.Properties;

public class SurgeBlock extends OmnisDirectionalBlock {
    public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;
    public final Supplier<Block> jetBlock;

    public SurgeBlock(Properties p_i48415_1_, Supplier<Block> jetBlock) {
        super(p_i48415_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(TRIGGERED, false));
        this.jetBlock = jetBlock;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TRIGGERED);
        super.createBlockStateDefinition(builder);
    }
}