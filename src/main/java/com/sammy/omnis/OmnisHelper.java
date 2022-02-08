package com.sammy.omnis;

import com.mojang.math.Vector3d;
import com.sammy.omnis.core.registry.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sammy.omnis.OmnisMod.MODID;


public class OmnisHelper
{
    public static boolean areWeOnClient(Level level)
    {
        return level.isClientSide;
    }
    public static boolean areWeOnServer(Level level)
    {
        return !areWeOnClient(level);
    }
    
    public static ResourceLocation prefix(String path)
    {
        return new ResourceLocation(MODID, path);
    }
    
    public static <T> ArrayList<T> toArrayList(T... items)
    {
        return new ArrayList<>(Arrays.asList(items));
    }
    
    public static <T> ArrayList<T> toArrayList(Stream<T> items)
    {
        return items.collect(Collectors.toCollection(ArrayList::new));
    }

    public static void updateState(Level levelIn, BlockPos pos) {
        updateState(levelIn.getBlockState(pos), levelIn, pos);
    }

    public static void updateState(BlockState state, Level levelIn, BlockPos pos) {
        levelIn.sendBlockUpdated(pos, state, state, 2);
    }

    public static void updateAndNotifyState(Level levelIn, BlockPos pos) {
        updateAndNotifyState(levelIn.getBlockState(pos), levelIn, pos);
    }

    public static void updateAndNotifyState(BlockState state, Level levelIn, BlockPos pos) {
        levelIn.sendBlockUpdated(pos, state, state, 2);
        state.updateNeighbourShapes(levelIn, pos, 2);
    }

    public static CompoundTag writeBlockPos(CompoundTag compoundNBT, BlockPos pos) {
        compoundNBT.putInt("X", pos.getX());
        compoundNBT.putInt("Y", pos.getY());
        compoundNBT.putInt("Z", pos.getZ());
        return compoundNBT;
    }

    public static CompoundTag writeBlockPos(CompoundTag compoundNBT, BlockPos pos, String extra) {
        compoundNBT.putInt(extra + "X", pos.getX());
        compoundNBT.putInt(extra + "Y", pos.getY());
        compoundNBT.putInt(extra + "Z", pos.getZ());
        return compoundNBT;
    }

    public static BlockPos readBlockPos(CompoundTag tag) {
        return new BlockPos(tag.getInt("X"), tag.getInt("Y"), tag.getInt("Z"));
    }

    public static BlockPos readBlockPos(CompoundTag tag, String extra) {
        return new BlockPos(tag.getInt(extra + "X"), tag.getInt(extra + "Y"), tag.getInt(extra + "Z"));
    }

    public static Vector3d randPos(BlockPos pos, Random rand, double min, double max) {
        double x = Mth.nextDouble(rand, min, max) + pos.getX();
        double y = Mth.nextDouble(rand, min, max) + pos.getY();
        double z = Mth.nextDouble(rand, min, max) + pos.getZ();
        return new Vector3d(x, y, z);
    }
    public static String toTitleCase(String givenString, String regex)
    {
        String[] stringArray = givenString.split(regex);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray)
        {
            stringBuilder.append(Character.toUpperCase(string.charAt(0))).append(string.substring(1)).append(regex);
        }
        return stringBuilder.toString().trim().replaceAll(regex, " ").substring(0, stringBuilder.length() - 1);
    }
    
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> Collection<T> takeAll(Collection<? extends T> src, T... items)
    {
        List<T> ret = Arrays.asList(items);
        for (T item : items)
        {
            if (!src.contains(item))
            {
                return Collections.emptyList();
            }
        }
        if (!src.removeAll(ret))
        {
            return Collections.emptyList();
        }
        return ret;
    }
    
    public static <T> Collection<T> takeAll(Collection<T> src, Predicate<T> pred)
    {
        List<T> ret = new ArrayList<>();
        
        Iterator<T> iter = src.iterator();
        while (iter.hasNext())
        {
            T item = iter.next();
            if (pred.test(item))
            {
                iter.remove();
                ret.add(item);
            }
        }
        
        if (ret.isEmpty())
        {
            return Collections.emptyList();
        }
        return ret;
    }

    public static Block[] getModBlocks(Class<?>... blockClasses) {
        Collection<RegistryObject<Block>> blocks = BlockRegistry.BLOCKS.getEntries();
        ArrayList<Block> matchingBlocks = new ArrayList<>();
        for (RegistryObject<Block> registryObject : blocks) {
            if (Arrays.stream(blockClasses).anyMatch(b -> b.isInstance(registryObject.get()))) {
                matchingBlocks.add(registryObject.get());
            }
        }
        return matchingBlocks.toArray(new Block[0]);
    }

    public static boolean hasCurioEquipped(LivingEntity entity, RegistryObject<Item> curio) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(curio.get(), entity).isPresent();
    }
    @Nonnull
    public static Optional<ImmutableTriple<String, Integer, ItemStack>> findCosmeticCurio(Predicate<ItemStack> filter, @Nonnull final LivingEntity livingEntity)
    {
        ImmutableTriple<String, Integer, ItemStack> result = CuriosApi.getCuriosHelper().getCuriosHandler(livingEntity).map(handler -> {
            Map<String, ICurioStacksHandler> curios = handler.getCurios();

            for (String id : curios.keySet())
            {
                ICurioStacksHandler stacksHandler = curios.get(id);
                IDynamicStackHandler stackHandler = stacksHandler.getStacks();
                IDynamicStackHandler cosmeticStackHelper = stacksHandler.getCosmeticStacks();

                for (int i = 0; i < stackHandler.getSlots(); i++)
                {
                    ItemStack stack = stackHandler.getStackInSlot(i);

                    if (!stack.isEmpty() && filter.test(stack))
                    {
                        return new ImmutableTriple<>(id, i, stack);
                    }
                }
                for (int i = 0; i < cosmeticStackHelper.getSlots(); i++)
                {
                    ItemStack stack = cosmeticStackHelper.getStackInSlot(i);

                    if (!stack.isEmpty() && filter.test(stack))
                    {
                        return new ImmutableTriple<>(id, i, stack);
                    }
                }
            }
            return new ImmutableTriple<>("", 0, ItemStack.EMPTY);
        }).orElse(new ImmutableTriple<>("", 0, ItemStack.EMPTY));

        return result.getLeft().isEmpty() ? Optional.empty() : Optional.of(result);
    }
}
