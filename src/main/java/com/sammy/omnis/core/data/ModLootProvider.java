package com.sammy.omnis.core.data;

import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.loot.OmnisLootModifier;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootTableIdCondition;

import static com.sammy.omnis.core.registry.misc.LootModifierRegistry.*;

public class ModLootProvider extends GlobalLootModifierProvider {
    public ModLootProvider(DataGenerator gen) {
        super(gen, OmnisMod.OMNIS);
    }

    @Override
    protected void start() {
        GlobalLootModifierSerializer<OmnisLootModifier> lootModifier = OMNIS_LOOT_MODIFIER.get();
        add("tear_of_vex", lootModifier, new OmnisLootModifier(
                new LootItemCondition[]{entityTypeCondition(EntityType.VEX)}, 0.1f, 1, 1, ItemRegistry.TEAR_OF_VEX.get()
        ));
        add("evoker_charm", lootModifier, new OmnisLootModifier(
                new LootItemCondition[]{entityTypeCondition(EntityType.EVOKER)}, 0.25f, 1, 0, ItemRegistry.EVOKER_CHARM.get()
        ));
        add("ravaged_scrap_ravager", lootModifier, new OmnisLootModifier(
                new LootItemCondition[]{entityTypeCondition(EntityType.RAVAGER)}, 1, 4, 4, ItemRegistry.RAVAGED_SCRAP.get()
        ));
        add("ravaged_scrap_pillager", lootModifier, new OmnisLootModifier(
                new LootItemCondition[]{entityTypeCondition(EntityType.PILLAGER)}, 0.5f, 1, 2, ItemRegistry.RAVAGED_SCRAP.get()
        ));
        add("ravaged_scrap_vindicator", lootModifier, new OmnisLootModifier(
                new LootItemCondition[]{entityTypeCondition(EntityType.VINDICATOR)}, 0.75f, 1, 3, ItemRegistry.RAVAGED_SCRAP.get()
        ));
    }

    public static LootItemCondition entityTypeCondition(EntityType<?> entityType) {
        return LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityType))).build();
    }
}