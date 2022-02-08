package com.sammy.omnis.core.data;

import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.loot.OmnisLootModifier;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import com.sammy.omnis.core.registry.misc.LootModifierRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import static com.sammy.omnis.core.registry.misc.LootModifierRegistry.EVOKER_CHARM;
import static com.sammy.omnis.core.registry.misc.LootModifierRegistry.TEAR_OF_VEX;

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
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/vex")).build() }, 0.1f,1,1, ItemRegistry.TEAR_OF_VEX.get()
        ));
        add("evoker_charm", EVOKER_CHARM.get(), new OmnisLootModifier(
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/evoker")).build() }, 0.25f,1,0, ItemRegistry.EVOKER_CHARM.get()
        ));
        add("ravaged_scrap_ravager", LootModifierRegistry.RAVAGED_SCRAP_RAVAGER.get(), new OmnisLootModifier(
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/ravager")).build() }, 1,2,8, ItemRegistry.RAVAGED_SCRAP.get()
        ));
        add("ravaged_scrap_pillager", LootModifierRegistry.RAVAGED_SCRAP_PILLAGER.get(), new OmnisLootModifier(
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/pillager")).build() }, 0.5f,1,2, ItemRegistry.RAVAGED_SCRAP.get()
        ));
        add("ravaged_scrap_vindicator", LootModifierRegistry.RAVAGED_SCRAP_VINDICATOR.get(), new OmnisLootModifier(
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/vindicator")).build() }, 0.75f,1,3, ItemRegistry.RAVAGED_SCRAP.get()
        ));

        add("ravaged_scrap_griefer", LootModifierRegistry.RAVAGED_SCRAP_GRIEFER.get(), new OmnisLootModifier(
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("savageandravage", "entities/griefer")).build() }, 0.75f,1,2, ItemRegistry.RAVAGED_SCRAP.get()
        ));
        add("ravaged_scrap_executioner", LootModifierRegistry.RAVAGED_SCRAP_EXECUTIONER.get(), new OmnisLootModifier(
                new ILootCondition[] { LootTableIdCondition.builder(new ResourceLocation("savageandravage", "entities/executioner")).build() }, 1,1,3, ItemRegistry.RAVAGED_SCRAP.get()
        ));

    }
}