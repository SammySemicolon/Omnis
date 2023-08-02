package com.sammy.omnis.core.registry;

import com.mojang.serialization.*;
import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.loot.OmnisLootModifier;
import net.minecraftforge.common.loot.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.OMNIS;

public class LootModifierRegistry
{
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, OMNIS);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEMS = LOOT_MODIFIERS.register("add_items", OmnisLootModifier.CODEC);

}
