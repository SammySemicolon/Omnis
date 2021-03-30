package com.sammy.omnis.core.data;

import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.loot.OmnisLootModifier;
import com.sammy.omnis.core.init.OmnisItems;
import com.sammy.omnis.core.init.Registries;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import static com.sammy.omnis.core.init.Registries.EVOKER_CHARM;
import static com.sammy.omnis.core.init.Registries.TEAR_OF_VEX;

public class ModLootProvider extends GlobalLootModifierProvider
{
    public ModLootProvider(DataGenerator gen)
    {
        super(gen, OmnisMod.MODID);
    }

    @Override
    protected void start()
    {
        add("tear_of_vex", TEAR_OF_VEX.get(), new OmnisLootModifier(
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/vex")).build() }, 0.1f,1,1, OmnisItems.TEAR_OF_VEX.get()
        ));
        add("evoker_charm", EVOKER_CHARM.get(), new OmnisLootModifier(
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/evoker")).build() }, 0.25f,1,0, OmnisItems.EVOKER_CHARM.get()
        ));
    }
}