package com.sammy.omnis.core.registry.block;

import com.sammy.omnis.common.blocks.VexwartBlock;
import com.sammy.omnis.common.blocks.surge.SurgeBlock;
import com.sammy.omnis.core.registry.SoundRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;
import static net.minecraft.block.PressurePlateBlock.Sensitivity.MOBS;

public class BlockRegistry
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static AbstractBlock.Properties HAUNTED_STEEL_BLOCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE).sound(SoundRegistry.HAUNTED_STEEL).hardnessAndResistance(50f,3600f).setRequiresTool();
    }
    public static AbstractBlock.Properties RAVAGED_METAL_BLOCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE).sound(SoundRegistry.RAVAGED_METAL).hardnessAndResistance(25f,3600f).setRequiresTool();
    }
    public static AbstractBlock.Properties VEXWART_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BLUE).hardnessAndResistance(1.0F).sound(SoundType.WART);
    }
    public static AbstractBlock.Properties RAVAGESTONE_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).sound(SoundRegistry.RAVAGESTONE).hardnessAndResistance(1.25f,9f).setRequiresTool();
    }
    public static AbstractBlock.Properties GLOOMSTONE_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).sound(SoundRegistry.GLOOMSTONE).hardnessAndResistance(1.25f,9f).setRequiresTool();
    }
    public static final RegistryObject<Block> INFERNAL_SURGE_BLOCK = BLOCKS.register("infernal_surge_block", () -> new SurgeBlock(RAVAGED_METAL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> AQUATIC_SURGE_BLOCK = BLOCKS.register("aquatic_surge_block", () -> new SurgeBlock(RAVAGED_METAL_BLOCK_PROPERTIES()));

    public static final RegistryObject<Block> HAUNTED_STEEL_BLOCK = BLOCKS.register("haunted_steel_block", () -> new Block(HAUNTED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGED_METAL_BLOCK = BLOCKS.register("ravaged_metal_block", () -> new Block(RAVAGED_METAL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> VEXWART_BLOCK = BLOCKS.register("vexwart_block", () -> new Block(VEXWART_PROPERTIES()));
    public static final RegistryObject<Block> VEXWART = BLOCKS.register("vexwart", () -> new VexwartBlock(VEXWART_PROPERTIES().notSolid().doesNotBlockMovement().zeroHardnessAndResistance()));

    public static final RegistryObject<Block> RAVAGESTONE = BLOCKS.register("ravagestone", () -> new Block(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_RAVAGESTONE = BLOCKS.register("polished_ravagestone", () -> new Block(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_BRICKS = BLOCKS.register("ravagestone_bricks", () -> new Block(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_TILES = BLOCKS.register("ravagestone_tiles", () -> new Block(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> CARVED_RAVAGESTONE = BLOCKS.register("carved_ravagestone", () -> new Block(RAVAGESTONE_PROPERTIES()));

    public static final RegistryObject<Block> RAVAGESTONE_SLAB = BLOCKS.register("ravagestone_slab", () -> new SlabBlock(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_RAVAGESTONE_SLAB = BLOCKS.register("polished_ravagestone_slab", () -> new SlabBlock(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_BRICKS_SLAB = BLOCKS.register("ravagestone_bricks_slab", () -> new SlabBlock(RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_TILES_SLAB = BLOCKS.register("ravagestone_tiles_slab", () -> new SlabBlock(RAVAGESTONE_PROPERTIES()));

    public static final RegistryObject<Block> RAVAGESTONE_STAIRS = BLOCKS.register("ravagestone_stairs", () -> new StairsBlock(RAVAGESTONE.get().getDefaultState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_RAVAGESTONE_STAIRS = BLOCKS.register("polished_ravagestone_stairs", () -> new StairsBlock(POLISHED_RAVAGESTONE.get().getDefaultState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_BRICKS_STAIRS = BLOCKS.register("ravagestone_bricks_stairs", () -> new StairsBlock(RAVAGESTONE_BRICKS.get().getDefaultState(), RAVAGESTONE_PROPERTIES()));
    public static final RegistryObject<Block> RAVAGESTONE_TILES_STAIRS = BLOCKS.register("ravagestone_tiles_stairs", () -> new StairsBlock(RAVAGESTONE_TILES.get().getDefaultState(), RAVAGESTONE_PROPERTIES()));

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

    public static final RegistryObject<Block> GLOOMSTONE_STAIRS = BLOCKS.register("gloomstone_stairs", () -> new StairsBlock(GLOOMSTONE.get().getDefaultState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_GLOOMSTONE_STAIRS = BLOCKS.register("polished_gloomstone_stairs", () -> new StairsBlock(POLISHED_GLOOMSTONE.get().getDefaultState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_BRICKS_STAIRS = BLOCKS.register("gloomstone_bricks_stairs", () -> new StairsBlock(GLOOMSTONE_BRICKS.get().getDefaultState(), GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_TILES_STAIRS = BLOCKS.register("gloomstone_tiles_stairs", () -> new StairsBlock(GLOOMSTONE_TILES.get().getDefaultState(), GLOOMSTONE_PROPERTIES()));

    public static final RegistryObject<Block> GLOOMSTONE_PRESSURE_PLATE = BLOCKS.register("gloomstone_pressure_plate", () -> new PressurePlateBlock(MOBS, GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_WALL = BLOCKS.register("gloomstone_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_BRICKS_WALL = BLOCKS.register("gloomstone_bricks_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));
    public static final RegistryObject<Block> GLOOMSTONE_TILES_WALL = BLOCKS.register("gloomstone_tiles_wall", () -> new WallBlock(GLOOMSTONE_PROPERTIES()));

}
