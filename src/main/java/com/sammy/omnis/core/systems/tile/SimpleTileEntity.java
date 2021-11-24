package com.sammy.omnis.core.systems.tile;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class SimpleTileEntity extends TileEntity
{
    public SimpleTileEntity(TileEntityType type)
    {
        super(type);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        super.write(compound);
        return writeData(compound);
    }
    
    @Override
    public void read(BlockState state, CompoundNBT compound)
    {
        super.read(state, compound);
        readData(compound);
    }
    
    @Override
    public CompoundNBT getUpdateTag()
    {
        return write(new CompoundNBT());
    }
    
    @Override
    public SUpdateTileEntityPacket getUpdatePacket()
    {
        CompoundNBT nbt = new CompoundNBT();
        writeData(nbt);
        return new SUpdateTileEntityPacket(pos, 0, nbt);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet)
    {
        super.onDataPacket(net, packet);
        readData(packet.getNbtCompound());
    }
    
    public void readData(CompoundNBT compound)
    {
    
    }
    public CompoundNBT writeData(CompoundNBT compound)
    {
        return compound;
    }
}