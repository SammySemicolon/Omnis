package com.sammy.omnis.core.registry.misc;

import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.loot.OmnisLootModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.OMNIS;

public class LootModifierRegistry
{
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, OMNIS);

    public static final RegistryObject<GlobalLootModifierSerializer<OmnisLootModifier>> OMNIS_LOOT_MODIFIER = LOOT_MODIFIERS.register("add_items", OmnisLootModifier.Serializer::new);

}
