package com.sammy.omnis.core.registry.block;

import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.blocks.VexwartBlock;
import com.sammy.omnis.core.registry.SoundRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import team.lodestar.lodestone.helpers.DataHelper;
import team.lodestar.lodestone.systems.block.LodestoneBlockProperties;

import java.util.HashSet;
import java.util.Set;

import static com.sammy.omnis.OmnisMod.OMNIS;
import static net.minecraft.world.level.block.PressurePlateBlock.Sensitivity.MOBS;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OMNIS);

    public static LodestoneBlockProperties HAUNTED_STEEL_BLOCK_PROPERTIES() {
        return new LodestoneBlockProperties(Material.METAL, MaterialColor.COLOR_BLUE).needsPickaxe().sound(SoundRegistry.HAUNTED_STEEL).strength(50f, 3600f).requiresCorrectToolForDrops();
    }

    public static LodestoneBlockProperties RAVAGED_METAL_BLOCK_PROPERTIES() {
        return new LodestoneBlockProperties(Material.METAL, MaterialColor.COLOR_BLUE).needsPickaxe().sound(SoundRegistry.RAVAGED_METAL).strength(25f, 3600f).requiresCorrectToolForDrops();
    }

    public static LodestoneBlockProperties VEXWART_PROPERTIES() {
        return new LodestoneBlockProperties(Material.GRASS, MaterialColor.COLOR_BLUE).needsHoe().strength(1.0F).sound(SoundType.WART_BLOCK);
    }

    public static LodestoneBlockProperties RAVAGESTONE_PROPERTIES() {
        return new LodestoneBlockProperties(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).needsPickaxe().sound(SoundRegistry.RAVAGESTONE).strength(1.25f, 9f).requiresCorrectToolForDrops();
    }

    public static LodestoneBlockProperties GLOOMSTONE_PROPERTIES() {
        return new LodestoneBlockProperties(Material.STONE, MaterialColor.TERRACOTTA_BLUE).needsPickaxe().sound(SoundRegistry.GLOOMSTONE).strength(1.25f, 9f).requiresCorrectToolForDrops();
    }

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

    public static final RegistryObject<Block> RAVAGESTONE_STAIRS = BLOCKS.register("ravagestone_stairs", () -> new StairBlock(RAVAGESTONE.get().defaultBlockState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_RAVAGESTONE_STAIRS = BLOCKS.register("polished_ravagestone_stairs", () -> new StairBlock(POLISHED_RAVAGESTONE.get().defaultBlockState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_BRICKS_STAIRS = BLOCKS.register("ravagestone_bricks_stairs", () -> new StairBlock(RAVAGESTONE_BRICKS.get().defaultBlockState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_TILES_STAIRS = BLOCKS.register("ravagestone_tiles_stairs", () -> new StairBlock(RAVAGESTONE_TILES.get().defaultBlockState(), RAVAGESTONE_PROPERTIES()));

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

    public static final RegistryObject<Block> GLOOMSTONE_STAIRS = BLOCKS.register("gloomstone_stairs", () -> new StairBlock(GLOOMSTONE.get().defaultBlockState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_GLOOMSTONE_STAIRS = BLOCKS.register("polished_gloomstone_stairs", () -> new StairBlock(POLISHED_GLOOMSTONE.get().defaultBlockState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_BRICKS_STAIRS = BLOCKS.register("gloomstone_bricks_stairs", () -> new StairBlock(GLOOMSTONE_BRICKS.get().defaultBlockState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_TILES_STAIRS = BLOCKS.register("gloomstone_tiles_stairs", () -> new StairBlock(GLOOMSTONE_TILES.get().defaultBlockState(), GLOOMSTONE_PROPERTIES()));

    public static final RegistryObject<Block> GLOOMSTONE_PRESSURE_PLATE = BLOCKS.register("gloomstone_pressure_plate", () -> new PressurePlateBlock(MOBS, GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_WALL = BLOCKS.register("gloomstone_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_BRICKS_WALL = BLOCKS.register("gloomstone_bricks_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_TILES_WALL = BLOCKS.register("gloomstone_tiles_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));


    @Mod.EventBusSubscriber(modid = OmnisMod.OMNIS, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientOnly {

        @SubscribeEvent
        public static void setRenderLayers(FMLClientSetupEvent event) {
            Set<RegistryObject<Block>> blocks = new HashSet<>(BLOCKS.getEntries());
            DataHelper.takeAll(blocks, b -> b.get() instanceof TorchBlock).forEach(ClientOnly::setCutout);
            DataHelper.takeAll(blocks, b -> b.get() instanceof TrapDoorBlock).forEach(ClientOnly::setCutout);
            DataHelper.takeAll(blocks, b -> b.get() instanceof DoorBlock).forEach(ClientOnly::setCutout);
            DataHelper.takeAll(blocks, b -> b.get() instanceof SaplingBlock).forEach(ClientOnly::setCutout);
            DataHelper.takeAll(blocks, b -> b.get() instanceof LeavesBlock).forEach(ClientOnly::setCutout);
            DataHelper.takeAll(blocks, b -> b.get() instanceof BushBlock).forEach(ClientOnly::setCutout);
            DataHelper.takeAll(blocks, b -> b.get() instanceof LanternBlock).forEach(ClientOnly::setCutout);
        }

        public static void setCutout(RegistryObject<Block> b) {
            ItemBlockRenderTypes.setRenderLayer(b.get(), RenderType.cutoutMipped());
        }
    }
}
