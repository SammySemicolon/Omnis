package com.sammy.omnis.data;

import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashSet;
import java.util.Set;

import static com.sammy.omnis.OmnisHelper.prefix;
import static com.sammy.omnis.OmnisHelper.takeAll;
import static com.sammy.omnis.OmnisMod.MODID;
import static com.sammy.omnis.init.OmnisItems.ITEMS;
import static com.sammy.omnis.init.OmnisItems.VEXWART;

public class ModItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider
{
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, MODID, existingFileHelper);
    }
    
    @Override
    protected void registerModels()
    {
        Set<RegistryObject<Item>> items = new HashSet<>(ITEMS.getEntries());
        items.remove(VEXWART);
        generatedItem(VEXWART);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof WallBlock).forEach(this::wallBlockItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof FenceBlock).forEach(this::fenceBlockItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof DoorBlock).forEach(this::generatedItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof TrapDoorBlock).forEach(this::trapdoorBlockItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof PressurePlateBlock).forEach(this::pressurePlateBlockItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof AbstractButtonBlock).forEach(this::buttonBlockItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof BushBlock && !(((BlockItem) i.get()).getBlock() instanceof DoublePlantBlock)).forEach(this::blockGeneratedItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof DoublePlantBlock).forEach(this::generatedItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof LanternBlock).forEach(this::generatedItem);
        takeAll(items, i -> i.get() instanceof BlockItem && ((BlockItem) i.get()).getBlock() instanceof TorchBlock).forEach(this::generatedItem);
        
        takeAll(items, i -> i.get() instanceof BlockItem).forEach(this::blockItem);
        takeAll(items, i -> i.get() instanceof ToolItem).forEach(this::handheldItem);
        takeAll(items, i -> i.get() instanceof SwordItem).forEach(this::handheldItem);
        takeAll(items, i -> i.get() instanceof BowItem).forEach(this::handheldItem);
        items.forEach(this::generatedItem);
    }
    
    private static final ResourceLocation GENERATED = new ResourceLocation("item/generated");
    private static final ResourceLocation HANDHELD = new ResourceLocation("item/handheld");
    
    private void handheldItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        withExistingParent(name, HANDHELD).texture("layer0", prefix("item/" + name));
    }
    
    private void generatedItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        withExistingParent(name, GENERATED).texture("layer0", prefix("item/" + name));
    }
    private void blockGeneratedItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        withExistingParent(name, GENERATED).texture("layer0", prefix("block/" + name));
    }
    private void essencePipeItem(RegistryObject<Item> i)
    {
        getBuilder("spirit_pipe").parent(new ModelFile.UncheckedModelFile(prefix("block/" + "spirit_pipe_core")));
    }
    private void blockItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        getBuilder(name).parent(new ModelFile.UncheckedModelFile(prefix("block/" + name)));
    }
    private void trapdoorBlockItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        getBuilder(name).parent(new ModelFile.UncheckedModelFile(prefix("block/" + name + "_bottom")));
    }
    private void fenceBlockItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        String baseName = name.substring(0, name.length() - 6);
        fenceInventory(name, prefix("block/" + baseName));
    }
    private void wallBlockItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        String baseName = name.substring(0, name.length() - 5);
        wallInventory(name, prefix("block/" + baseName));
    }
    private void pressurePlateBlockItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        getBuilder(name).parent(new ModelFile.UncheckedModelFile(prefix("block/" + name + "_up")));
    }
    private void buttonBlockItem(RegistryObject<Item> i)
    {
        String name = Registry.ITEM.getKey(i.get()).getPath();
        getBuilder(name).parent(new ModelFile.UncheckedModelFile(prefix("block/" + name + "_inventory")));
    }
    @Override
    public String getName()
    {
        return "Item Models";
    }
}