package com.sammy.omnis.common.blocks.surge;

import com.sammy.omnis.common.blocks.OmnisDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.awt.*;
import java.util.function.Supplier;


public class SurgeBlock extends OmnisDirectionalBlock {
    public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;
    public final Supplier<Block> jetBlock;

    public SurgeBlock(Properties p_i48415_1_, Supplier<Block> jetBlock) {
        super(p_i48415_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(TRIGGERED, false));
        this.jetBlock = jetBlock;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TRIGGERED);
        super.createBlockStateDefinition(builder);
    }
}