package com.sammy.omnis.core.registry.block;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.blocks.VexwartBlock;
import com.sammy.omnis.common.blocks.surge.SurgeBlock;
import com.sammy.omnis.common.blocks.surge.SurgeJetBlock;
import com.sammy.omnis.core.registry.SoundRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

import static com.sammy.omnis.OmnisMod.MODID;
import static net.minecraft.block.PressurePlateBlock.Sensitivity.MOBS;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static AbstractBlock.Properties HAUNTED_STEEL_BLOCK_PROPERTIES() {
        return AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).sound(SoundRegistry.HAUNTED_STEEL).strength(50f, 3600f).requiresCorrectToolForDrops();
    }

    public static AbstractBlock.Properties RAVAGED_METAL_BLOCK_PROPERTIES() {
        return AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).sound(SoundRegistry.RAVAGED_METAL).strength(25f, 3600f).requiresCorrectToolForDrops();
    }

    public static AbstractBlock.Properties VEXWART_PROPERTIES() {
        return AbstractBlock.Properties.of(Material.GRASS, MaterialColor.COLOR_BLUE).strength(1.0F).sound(SoundType.WART_BLOCK);
    }

    public static AbstractBlock.Properties RAVAGESTONE_PROPERTIES() {
        return AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).sound(SoundRegistry.RAVAGESTONE).strength(1.25f, 9f).requiresCorrectToolForDrops();
    }

    public static AbstractBlock.Properties GLOOMSTONE_PROPERTIES() {
        return AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE).sound(SoundRegistry.GLOOMSTONE).strength(1.25f, 9f).requiresCorrectToolForDrops();
    }

    public static final RegistryObject<Block> INFERNAL_SURGE_JET_BLOCK = BLOCKS.register("infernal_surge_jet_block", () -> new SurgeJetBlock(AbstractBlock.Properties.copy(Blocks.AIR).randomTicks().noOcclusion()));
    public static final RegistryObject<Block> AQUATIC_SURGE_JET_BLOCK = BLOCKS.register("aquatic_surge_jet_block", () -> new SurgeJetBlock(AbstractBlock.Properties.copy(Blocks.AIR).randomTicks().noOcclusion()));
    public static final RegistryObject<Block> INFERNAL_SURGE_BLOCK = BLOCKS.register("infernal_surge_block", () -> new SurgeBlock(RAVAGED_METAL_BLOCK_PROPERTIES(), INFERNAL_SURGE_JET_BLOCK));
    public static final RegistryObject<Block> AQUATIC_SURGE_BLOCK = BLOCKS.register("aquatic_surge_block", () -> new SurgeBlock(RAVAGED_METAL_BLOCK_PROPERTIES(), AQUATIC_SURGE_JET_BLOCK));

    public static final RegistryObject<Block> HAUNTED_STEEL_BLOCK = BLOCKS.register("haunted_steel_block", () -> new Block(HAUNTED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGED_METAL_BLOCK = BLOCKS.register("ravaged_metal_block", () -> new Block(RAVAGED_METAL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> VEXWART_BLOCK = BLOCKS.register("vexwart_block", () -> new Block(VEXWART_PROPERTIES()));
    public static final RegistryObject<Block> VEXWART = BLOCKS.register("vexwart", () -> new VexwartBlock(VEXWART_PROPERTIES().noOcclusion().noCollission().instabreak()));

    public static final RegistryObject<Block> RAVAGESTONE = BLOCKS.register("ravagestone", () -> new Block(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_RAVAGESTONE = BLOCKS.register("polished_ravagestone", () -> new Block(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_BRICKS = BLOCKS.register("ravagestone_bricks", () -> new Block(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_TILES = BLOCKS.register("ravagestone_tiles", () -> new Block(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> CARVED_RAVAGESTONE = BLOCKS.register("carved_ravagestone", () -> new Block(RAVAGESTONE_PROPERTIES()));

    public static final RegistryObject<Block> RAVAGESTONE_SLAB = BLOCKS.register("ravagestone_slab", () -> new SlabBlock(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_RAVAGESTONE_SLAB = BLOCKS.register("polished_ravagestone_slab", () -> new SlabBlock(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_BRICKS_SLAB = BLOCKS.register("ravagestone_bricks_slab", () -> new SlabBlock(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_TILES_SLAB = BLOCKS.register("ravagestone_tiles_slab", () -> new SlabBlock(RAVAGESTONE_PROPERTIES()));

    public static final RegistryObject<Block> RAVAGESTONE_STAIRS = BLOCKS.register("ravagestone_stairs", () -> new StairsBlock(RAVAGESTONE.get().defaultBlockState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_RAVAGESTONE_STAIRS = BLOCKS.register("polished_ravagestone_stairs", () -> new StairsBlock(POLISHED_RAVAGESTONE.get().defaultBlockState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_BRICKS_STAIRS = BLOCKS.register("ravagestone_bricks_stairs", () -> new StairsBlock(RAVAGESTONE_BRICKS.get().defaultBlockState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_TILES_STAIRS = BLOCKS.register("ravagestone_tiles_stairs", () -> new StairsBlock(RAVAGESTONE_TILES.get().defaultBlockState(), RAVAGESTONE_PROPERTIES()));

    public static final RegistryObject<Block> RAVAGESTONE_PRESSURE_PLATE = BLOCKS.register("ravagestone_pressure_plate", () -> new PressurePlateBlock(MOBS, RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_WALL = BLOCKS.register("ravagestone_wall", () -> new WallBlock(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_BRICKS_WALL = BLOCKS.register("ravagestone_bricks_wall", () -> new WallBlock(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_TILES_WALL = BLOCKS.register("ravagestone_tiles_wall", () -> new WallBlock(RAVAGESTONE_PROPERTIES()));


    public static final RegistryObject<Block> GLOOMSTONE = BLOCKS.register("gloomstone", () -> new Block(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_GLOOMSTONE = BLOCKS.register("polished_gloomstone", () -> new Block(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_BRICKS = BLOCKS.register("gloomstone_bricks", () -> new Block(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_TILES = BLOCKS.register("gloomstone_tiles", () -> new Block(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> CARVED_GLOOMSTONE = BLOCKS.register("carved_gloomstone", () -> new Block(GLOOMSTONE_PROPERTIES()));

    public static final RegistryObject<Block> GLOOMSTONE_SLAB = BLOCKS.register("gloomstone_slab", () -> new SlabBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_GLOOMSTONE_SLAB = BLOCKS.register("polished_gloomstone_slab", () -> new SlabBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_BRICKS_SLAB = BLOCKS.register("gloomstone_bricks_slab", () -> new SlabBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_TILES_SLAB = BLOCKS.register("gloomstone_tiles_slab", () -> new SlabBlock(GLOOMSTONE_PROPERTIES()));

    public static final RegistryObject<Block> GLOOMSTONE_STAIRS = BLOCKS.register("gloomstone_stairs", () -> new StairsBlock(GLOOMSTONE.get().defaultBlockState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_GLOOMSTONE_STAIRS = BLOCKS.register("polished_gloomstone_stairs", () -> new StairsBlock(POLISHED_GLOOMSTONE.get().defaultBlockState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_BRICKS_STAIRS = BLOCKS.register("gloomstone_bricks_stairs", () -> new StairsBlock(GLOOMSTONE_BRICKS.get().defaultBlockState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_TILES_STAIRS = BLOCKS.register("gloomstone_tiles_stairs", () -> new StairsBlock(GLOOMSTONE_TILES.get().defaultBlockState(), GLOOMSTONE_PROPERTIES()));

    public static final RegistryObject<Block> GLOOMSTONE_PRESSURE_PLATE = BLOCKS.register("gloomstone_pressure_plate", () -> new PressurePlateBlock(MOBS, GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_WALL = BLOCKS.register("gloomstone_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_BRICKS_WALL = BLOCKS.register("gloomstone_bricks_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_TILES_WALL = BLOCKS.register("gloomstone_tiles_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));


    @Mod.EventBusSubscriber(modid = OmnisMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientOnly {

        @SubscribeEvent
        public static void setRenderLayers(FMLClientSetupEvent event) {
            Set<RegistryObject<Block>> blocks = new HashSet<>(BLOCKS.getEntries());
            OmnisHelper.takeAll(blocks, b -> b.get() instanceof TorchBlock).forEach(ClientRegistry::setCutout);
            OmnisHelper.takeAll(blocks, b -> b.get() instanceof TrapDoorBlock).forEach(ClientRegistry::setCutout);
            OmnisHelper.takeAll(blocks, b -> b.get() instanceof DoorBlock).forEach(ClientRegistry::setCutout);
            OmnisHelper.takeAll(blocks, b -> b.get() instanceof SaplingBlock).forEach(ClientRegistry::setCutout);
            OmnisHelper.takeAll(blocks, b -> b.get() instanceof LeavesBlock).forEach(ClientRegistry::setCutout);
            OmnisHelper.takeAll(blocks, b -> b.get() instanceof BushBlock).forEach(ClientRegistry::setCutout);
            OmnisHelper.takeAll(blocks, b -> b.get() instanceof LanternBlock).forEach(ClientRegistry::setCutout);
        }

        public static void setCutout(RegistryObject<Block> b) {
            ItemBlockRenderTypes.setRenderLayer(b.get(), RenderType.cutoutMipped());
        }
    }
}
