package com.sammy.omnis;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
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
    public static boolean areWeOnClient(World world)
    {
        return world.isRemote;
    }
    
    public static boolean areWeOnServer(World world)
    {
        return !areWeOnClient(world);
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
