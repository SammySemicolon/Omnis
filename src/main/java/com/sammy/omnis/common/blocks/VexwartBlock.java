package com.sammy.omnis.common.blocks;

import com.sammy.omnis.init.OmnisItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

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
}
