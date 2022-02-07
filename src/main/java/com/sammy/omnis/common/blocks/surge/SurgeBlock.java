package com.sammy.omnis.common.blocks.surge;

import com.sammy.omnis.common.blocks.OmnisDirectionalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.awt.*;
import java.util.function.Supplier;

public class SurgeBlock extends OmnisDirectionalBlock {
    public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;
    public final Supplier<Block> jetBlock;

    public SurgeBlock(Properties p_i48415_1_, Supplier<Block> jetBlock) {
        super(p_i48415_1_);
        this.setDefaultState(this.stateContainer.getBaseState().with(TRIGGERED, false));
        this.jetBlock = jetBlock;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TRIGGERED);
        super.fillStateContainer(builder);
    }
}