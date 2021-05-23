package com.sammy.omnis.common.loot;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class OmnisLootModifier extends LootModifier
{
    private final float itemChance;
    private final int itemCount;
    private final int extraItemCount;
    private final Item item;

    public OmnisLootModifier(ILootCondition[] conditionsIn, float itemChance, int itemCount, int extraItemCount, Item item)
    {
        super(conditionsIn);
        this.itemChance = itemChance;
        this.itemCount = itemCount;
        this.extraItemCount = extraItemCount;
        this.item = item;
    }

    public static class Serializer extends GlobalLootModifierSerializer<OmnisLootModifier>
    {

        @Override
        public OmnisLootModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn)
        {
            float itemChance = JSONUtils.getFloat(object, "itemChance");
            int itemCount = JSONUtils.getInt(object, "itemCount");
            int extraItemCount = JSONUtils.getInt(object, "extraItemCount");
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation((JSONUtils.getString(object, "item"))));
            return new OmnisLootModifier(conditionsIn, itemChance, itemCount, extraItemCount, item);
        }

        @Override
        public JsonObject write(OmnisLootModifier instance)
        {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("itemChance", instance.itemChance);
            json.addProperty("itemCount", instance.itemCount);
            json.addProperty("extraItemCount", instance.extraItemCount);
            json.addProperty("item", ForgeRegistries.ITEMS.getKey(instance.item).toString());
            return json;
        }
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
    {
        if (context.getRandom().nextFloat() < itemChance || itemChance == 1)
        {
            int count = itemCount + context.getRandom().nextInt(extraItemCount+1);
            generatedLoot.add(new ItemStack(item, count));
        }
        return generatedLoot;
    }
}