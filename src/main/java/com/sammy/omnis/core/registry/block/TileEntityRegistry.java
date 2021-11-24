package com.sammy.omnis.core.registry.block;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.common.blocks.surge.SurgeBlock;
import com.sammy.omnis.common.tile_entity.SurgeTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;

public class TileEntityRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);

    public static final RegistryObject<TileEntityType<SurgeTileEntity>> SURGE_BLOCK_TILE_ENTITY = TILE_ENTITIES.register("surge_block_tile_entity", () -> TileEntityType.Builder.create(SurgeTileEntity::new, OmnisHelper.getModBlocks(SurgeBlock.class)).build(null));

}
