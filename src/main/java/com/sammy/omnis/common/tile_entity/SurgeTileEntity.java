package com.sammy.omnis.common.tile_entity;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.common.blocks.surge.SurgeBlock;
import com.sammy.omnis.core.registry.block.TileEntityRegistry;
import com.sammy.omnis.core.systems.tile.SimpleTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class SurgeTileEntity extends SimpleTileEntity implements ITickableTileEntity {

    private final ArrayList<BlockPos> jetBlocks = new ArrayList<>();
    private int countdown;

    public SurgeTileEntity() {
        super(TileEntityRegistry.SURGE_BLOCK_TILE_ENTITY.get());
    }

    private Block jetBlock() {
        return ((SurgeBlock) getBlockState().getBlock()).jetBlock.get();
    }

    private boolean isActive() {
        return getBlockState().get(SurgeBlock.TRIGGERED);
    }

    private Direction direction() {
        return getBlockState().get(SurgeBlock.FACING);
    }

    @Override
    public void tick() {
        if (isActive()) {
            if (countdown <= 0) {
                int offset = jetBlocks.size() + 1;
                BlockPos newJetBlockPos = getPos().offset(direction(), offset);
                if (world.getBlockState(newJetBlockPos).isAir(world, newJetBlockPos)) {
                    world.setBlockState(newJetBlockPos, jetBlock().getDefaultState(), 3);
                    jetBlocks.add(newJetBlockPos);
                    OmnisHelper.updateAndNotifyState(world, newJetBlockPos);
                    countdown = 4;
                }
            } else {
                countdown--;
            }
        } else {
            if (!jetBlocks.isEmpty()) {
                jetBlocks.forEach(p -> {
                    if (jetBlock().getClass().isInstance(world.getBlockState(p).getBlock())) {
                        world.setBlockState(p, Blocks.AIR.getDefaultState());
                        OmnisHelper.updateAndNotifyState(world, p);
                    }
                });
                jetBlocks.clear();
            }
            countdown = 0;
        }
    }

    @Override
    public void readData(CompoundNBT compound) {
        countdown = compound.getInt("countdown");
        for (int i = 0; i < compound.getInt("blockCount"); i++) {
            jetBlocks.add(OmnisHelper.readBlockPos(compound, "part" + i));
        }

        super.readData(compound);
    }

    @Override
    public CompoundNBT writeData(CompoundNBT compound) {
        compound.putInt("countdown", countdown);
        if (!jetBlocks.isEmpty()) {
            compound.putInt("blockCount", jetBlocks.size());
            for (int i = 0; i < jetBlocks.size(); i++) {
                OmnisHelper.writeBlockPos(compound, jetBlocks.get(i), "part" + i);
            }
        }
        return super.writeData(compound);
    }
}