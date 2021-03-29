package com.sammy.omnis.init;

import com.sammy.omnis.common.blocks.VexwartBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;

public class OmnisBlocks
{
    public static AbstractBlock.Properties HAUNTED_STEEL_BLOCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE).sound(OmnisSounds.HAUNTED_STEEL).hardnessAndResistance(50f,3600f);
    }
    public static AbstractBlock.Properties HEXWART_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BLUE).hardnessAndResistance(1.0F).sound(SoundType.WART);
    }
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> HAUNTED_STEEL_BLOCK = BLOCKS.register("haunted_steel_block", () -> new Block(HAUNTED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> VEXWART_BLOCK = BLOCKS.register("vexwart_block", () -> new Block(HEXWART_PROPERTIES()));
    public static final RegistryObject<Block> VEXWART = BLOCKS.register("vexwart", () -> new VexwartBlock(HEXWART_PROPERTIES().notSolid()));

}
