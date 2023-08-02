package com.sammy.omnis.common.loot;

import com.google.common.base.*;
import com.google.gson.JsonObject;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.util.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class OmnisLootModifier extends LootModifier
{
    public static final Supplier<Codec<OmnisLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).and(
                            inst.group(
                                    ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter((m) -> m.addedItem),
                                    Codec.INT.optionalFieldOf("min", 1).forGetter((m) -> m.min),
                                    Codec.INT.optionalFieldOf("max", 1).forGetter((m) -> m.max)
                            )
                    )
                    .apply(inst, OmnisLootModifier::new)));

    private final Item addedItem;
    private final int min;
    private final int max;

    /**
     * This loot modifier adds an item to the loot table, given the conditions specified.
     */
    protected OmnisLootModifier(LootItemCondition[] conditionsIn, Item addedItemIn, int min, int max) {
        super(conditionsIn);
        this.addedItem = addedItemIn;
        this.min = min;
        this.max = max;
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ItemStack addedStack = new ItemStack(addedItem, Mth.nextInt(context.getRandom(), min, max));
        if (addedStack.getCount() < addedStack.getMaxStackSize()) {
            generatedLoot.add(addedStack);
        } else {
            int i = addedStack.getCount();

            while (i > 0) {
                ItemStack subStack = addedStack.copy();
                subStack.setCount(Math.min(addedStack.getMaxStackSize(), i));
                i -= subStack.getCount();
                generatedLoot.add(subStack);
            }
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}