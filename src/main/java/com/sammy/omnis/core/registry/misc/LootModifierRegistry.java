package com.sammy.omnis.core.registry.misc;

import com.sammy.omnis.common.loot.OmnisLootModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;

public class LootModifierRegistry
{
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, MODID);

    public static final RegistryObject<OmnisLootModifier.Serializer> TEAR_OF_VEX = GLM.register("tear_of_vex", OmnisLootModifier.Serializer::new);
    public static final RegistryObject<OmnisLootModifier.Serializer> EVOKER_CHARM = GLM.register("evoker_charm", OmnisLootModifier.Serializer::new);
    public static final RegistryObject<OmnisLootModifier.Serializer> RAVAGED_SCRAP_RAVAGER = GLM.register("ravaged_scrap_ravager", OmnisLootModifier.Serializer::new);
    public static final RegistryObject<OmnisLootModifier.Serializer> RAVAGED_SCRAP_ILLAGER = GLM.register("ravaged_scrap_illager", OmnisLootModifier.Serializer::new);
    public static final RegistryObject<OmnisLootModifier.Serializer> RAVAGED_SCRAP_VINDICATOR = GLM.register("ravaged_scrap_vindicator", OmnisLootModifier.Serializer::new);
}
