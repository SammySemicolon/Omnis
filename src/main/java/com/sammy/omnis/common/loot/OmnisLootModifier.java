package com.sammy.omnis.common.loot;

import com.google.gson.JsonObject;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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

    public OmnisLootModifier(LootItemCondition[] conditionsIn, float itemChance, int itemCount, int extraItemCount, Item item)
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
        public OmnisLootModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn)
        {
            float itemChance = GsonHelper.getAsFloat(object, "itemChance");
            int itemCount = GsonHelper.getAsInt(object, "itemCount");
            int extraItemCount = GsonHelper.getAsInt(object, "extraItemCount");
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation((GsonHelper.getAsString(object, "item"))));
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
        if (itemChance == 1 || context.getRandom().nextFloat() < itemChance)
        {
            int count = itemCount + context.getRandom().nextInt(extraItemCount+1);
            generatedLoot.add(new ItemStack(item, count));
        }
        return generatedLoot;
    }
}