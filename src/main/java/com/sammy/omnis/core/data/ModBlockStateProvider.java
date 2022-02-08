package com.sammy.omnis.core.data;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.blocks.VexwartBlock;
import com.sammy.omnis.common.blocks.surge.SurgeBlock;
import com.sammy.omnis.common.blocks.surge.SurgeJetBlock;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static com.sammy.omnis.OmnisHelper.prefix;
import static com.sammy.omnis.core.registry.block.BlockRegistry.BLOCKS;
import static net.minecraft.state.properties.DoubleBlockHalf.LOWER;
import static net.minecraft.state.properties.DoubleBlockHalf.UPPER;

public class ModBlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider
{
    
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, OmnisMod.MODID, exFileHelper);
    }
    
    @Nonnull
    @Override
    public String getName()
    {
        return "Block States";
    }
    
    @Override
    protected void registerStatesAndModels()
    {
        Set<RegistryObject<Block>> blocks = new HashSet<>(BLOCKS.getEntries());

        OmnisHelper.takeAll(blocks, b -> b.get() instanceof SurgeJetBlock).forEach(this::surgeJetBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof SurgeBlock).forEach(this::surgeBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof VexwartBlock).forEach(this::vexwartBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof GrassBlock).forEach(this::grassBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof StairsBlock).forEach(this::stairsBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof RotatedPillarBlock).forEach(this::logBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof WallBlock).forEach(this::wallBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof FenceBlock).forEach(this::fenceBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof FenceGateBlock).forEach(this::fenceGateBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof DoorBlock).forEach(this::doorBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof TrapDoorBlock).forEach(this::trapdoorBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof PressurePlateBlock).forEach(this::pressurePlateBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof AbstractButtonBlock).forEach(this::buttonBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof DoublePlantBlock).forEach(this::tallPlantBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof BushBlock).forEach(this::plantBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof LanternBlock).forEach(this::lanternBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof WallTorchBlock).forEach(this::wallTorchBlock);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof TorchBlock).forEach(this::torchBlock);
        
        Collection<RegistryObject<Block>> slabs = OmnisHelper.takeAll(blocks, b -> b.get() instanceof SlabBlock);
        blocks.forEach(this::basicBlock);
        slabs.forEach(this::slabBlock);
        
    }
    
    public void basicBlock(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlock(blockRegistryObject.get());
    }
    public void surgeJetBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        ModelFile empty = models().withExistingParent(name, new ResourceLocation("block/air"));
        getVariantBuilder(blockRegistryObject.get()).forAllStates(s -> ConfiguredModel.builder().modelFile(empty).build());
    }
    public void surgeBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        ModelFile model = models().cubeBottomTop(name, prefix("block/" + name + "_side"), prefix("block/surge_block_bottom"), prefix("block/" + name + "_top"));
        directionalBlock(blockRegistryObject.get(), model);
    }
    public void emptyBlock(RegistryObject<Block> blockRegistryObject)
    {
        ModelFile empty = models().getExistingFile(new ResourceLocation("block/air"));
        getVariantBuilder(blockRegistryObject.get()).forAllStates(s -> ConfiguredModel.builder().modelFile(empty).build());
    }
    public void trapdoorBlock(RegistryObject<Block> blockRegistryObject)
    {
        trapdoorBlock((TrapDoorBlock) blockRegistryObject.get(), blockTexture(blockRegistryObject.get()), true);
    }
    public void torchBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        ModelFile torch = models().torchWall(blockRegistryObject.get().getRegistryName().getPath(), prefix("block/" + name));
    
        getVariantBuilder(blockRegistryObject.get()).forAllStates(s -> ConfiguredModel.builder().modelFile(torch).build());
    }
    public void wallTorchBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        ModelFile torch = models().torchWall(blockRegistryObject.get().getRegistryName().getPath(), prefix("block/" + name.substring(5)));
    
        getVariantBuilder(blockRegistryObject.get())
                .partialState().with(WallTorchBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(torch).rotationY(270).addModel()
                .partialState().with(WallTorchBlock.FACING, Direction.WEST)
                .modelForState().modelFile(torch).rotationY(180).addModel()
                .partialState().with(WallTorchBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(torch).rotationY(90).addModel()
                .partialState().with(WallTorchBlock.FACING, Direction.EAST)
                .modelForState().modelFile(torch).addModel();
    }
    
    public void grassBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        ModelFile file = models().cubeBottomTop(name, prefix("block/" + name + "_side"), new ResourceLocation("block/dirt"), prefix("block/" + name + "_top"));
    
        getVariantBuilder(blockRegistryObject.get()).partialState().modelForState()
                .modelFile(file)
                .nextModel().modelFile(file).rotationY(90)
                .nextModel().modelFile(file).rotationY(180)
                .nextModel().modelFile(file).rotationY(270)
                .addModel();
    }
    
    public void doorBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        doorBlock((DoorBlock) blockRegistryObject.get(), prefix("block/" + name + "_bottom"), prefix("block/" + name + "_top"));
    }
    
    public void fenceGateBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 11);
        fenceGateBlock((FenceGateBlock) blockRegistryObject.get(), prefix("block/" + baseName));
    }
    
    public void fenceBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 6);
        fenceBlock((FenceBlock) blockRegistryObject.get(), prefix("block/" + baseName));
    }
    
    public void wallBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 5);
        wallBlock((WallBlock) blockRegistryObject.get(), prefix("block/" + baseName));
    }
    
    public void stairsBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 7);
        stairsBlock((StairsBlock) blockRegistryObject.get(), prefix("block/" + baseName));
    }
    
    public void pressurePlateBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 15);
        ModelFile pressurePlateDown = models().withExistingParent(name + "_down", new ResourceLocation("block/pressure_plate_down")).texture("texture", prefix("block/" + baseName));
        ModelFile pressurePlateUp = models().withExistingParent(name + "_up", new ResourceLocation("block/pressure_plate_up")).texture("texture", prefix("block/" + baseName));
    
        getVariantBuilder(blockRegistryObject.get()).partialState().with(PressurePlateBlock.POWERED, true).modelForState().modelFile(pressurePlateDown).addModel().partialState().with(PressurePlateBlock.POWERED, false).modelForState().modelFile(pressurePlateUp).addModel();
    }
    public void lanternBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        ModelFile lantern = models().withExistingParent(name, new ResourceLocation("block/template_lantern")).texture("lantern", prefix("block/" + name));
        ModelFile hangingLantern = models().withExistingParent(name + "_hanging", new ResourceLocation("block/template_hanging_lantern")).texture("lantern", prefix("block/" + name));
        
        getVariantBuilder(blockRegistryObject.get()).partialState().with(LanternBlock.HANGING, true).modelForState().modelFile(hangingLantern).addModel().partialState().with(LanternBlock.HANGING, false).modelForState().modelFile(lantern).addModel();
    }
    
    public void buttonBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 7);
        ModelFile buttom = models().withExistingParent(name, new ResourceLocation("block/button")).texture("texture", prefix("block/" + baseName));
        ModelFile buttonPressed = models().withExistingParent(name + "_pressed", new ResourceLocation("block/button_pressed")).texture("texture", prefix("block/" + baseName));
        Function<BlockState, ModelFile> modelFunc = $ -> buttom;
        Function<BlockState, ModelFile> pressedModelFunc = $ -> buttonPressed;
        getVariantBuilder(blockRegistryObject.get()).forAllStates(s -> ConfiguredModel.builder().modelFile(s.getValue(BlockStateProperties.POWERED) ? pressedModelFunc.apply(s) : modelFunc.apply(s)).uvLock(s.getValue(BlockStateProperties.ATTACH_FACE).equals(AttachFace.WALL)).rotationX(s.getValue(BlockStateProperties.ATTACH_FACE).ordinal() * 90).rotationY((((int) s.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) + (s.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.CEILING ? 180 : 0)) % 360).build());
        models().withExistingParent(name + "_inventory", new ResourceLocation("block/button_inventory")).texture("texture", prefix("block/" + baseName));
    
    }

    public void vexwartBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();

        ModelFile stage0 = models().withExistingParent(name + "_0", new ResourceLocation("block/crop")).texture("crop", prefix("block/" + name + "_0"));
        ModelFile stage1 = models().withExistingParent(name + "_1", new ResourceLocation("block/crop")).texture("crop", prefix("block/" + name + "_1"));
        ModelFile stage2 = models().withExistingParent(name + "_2", new ResourceLocation("block/crop")).texture("crop", prefix("block/" + name + "_2"));
        ModelFile stage3 = models().withExistingParent(name + "_3", new ResourceLocation("block/crop")).texture("crop", prefix("block/" + name + "_3"));

        getVariantBuilder(blockRegistryObject.get()).partialState().with(VexwartBlock.AGE, 0).modelForState().modelFile(stage0).addModel()
                .partialState().with(VexwartBlock.AGE, 1).modelForState().modelFile(stage1).addModel()
                .partialState().with(VexwartBlock.AGE, 2).modelForState().modelFile(stage2).addModel()
                .partialState().with(VexwartBlock.AGE, 3).modelForState().modelFile(stage3).addModel();

    }
    public void tallPlantBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        ModelFile bottom = models().withExistingParent(name + "_bottom", new ResourceLocation("block/cross")).texture("cross", prefix("block/" + name + "_bottom"));
        ModelFile top = models().withExistingParent(name + "_top", new ResourceLocation("block/cross")).texture("cross", prefix("block/" + name + "_top"));
        
        getVariantBuilder(blockRegistryObject.get()).partialState().with(DoublePlantBlock.HALF, LOWER).modelForState().modelFile(bottom).addModel().partialState().with(DoublePlantBlock.HALF, UPPER).modelForState().modelFile(top).addModel();
    }
    
    public void plantBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        ModelFile cross = models().withExistingParent(name, new ResourceLocation("block/cross")).texture("cross", prefix("block/" + name));
        
        getVariantBuilder(blockRegistryObject.get()).forAllStates(s -> ConfiguredModel.builder().modelFile(cross).build());
    }
    
    public void slabBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 5);
        slabBlock((SlabBlock) blockRegistryObject.get(), prefix(baseName), prefix("block/" + baseName));
    }
    
    public void logBlock(RegistryObject<Block> blockRegistryObject)
    {
        logBlock((RotatedPillarBlock) blockRegistryObject.get());
    }
    
    public void woodBlock(RegistryObject<Block> blockRegistryObject)
    {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name + "_log";
        axisBlock((RotatedPillarBlock) blockRegistryObject.get(), prefix("block/" + baseName), prefix("block/" + baseName));
    }
}