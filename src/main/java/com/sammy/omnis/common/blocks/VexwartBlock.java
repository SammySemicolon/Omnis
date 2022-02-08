package com.sammy.omnis.common.blocks;

import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;

public class VexwartBlock extends NetherWartBlock
{
    public VexwartBlock(Properties builder)
    {
        super(builder);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return ItemRegistry.VEXWART.get().getDefaultInstance();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return reader.getBlockState(pos.below()).is(Blocks.SOUL_SAND);
    }
}
