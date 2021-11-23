package com.sammy.omnis.common.blocks;

import com.sammy.omnis.core.init.OmnisItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.Tags;

public class VexwartBlock extends NetherWartBlock
{
    public VexwartBlock(Properties builder)
    {
        super(builder);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
    {
        return OmnisItems.VEXWART.get().getDefaultInstance();
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader reader, BlockPos pos) {
        return reader.getBlockState(pos.down()).isIn(Blocks.SOUL_SAND);
    }
}
