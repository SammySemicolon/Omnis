package com.sammy.omnis.common.blocks.surge;

import com.sammy.omnis.common.blocks.OmnisDirectionalBlock;
import com.sammy.omnis.common.tile_entity.SurgeTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

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
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new SurgeTileEntity();
    }

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = worldIn.isBlockPowered(pos);
        boolean flag1 = state.get(TRIGGERED);
        if (flag && !flag1) {
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
            worldIn.setBlockState(pos, state.with(TRIGGERED, true), 4);
        } else if (!flag && flag1) {
            worldIn.setBlockState(pos, state.with(TRIGGERED, false), 4);
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TRIGGERED);
        super.fillStateContainer(builder);
    }
}