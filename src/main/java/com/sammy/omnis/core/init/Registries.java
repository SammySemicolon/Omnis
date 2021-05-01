package com.sammy.omnis.core.init;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.common.loot.OmnisLootModifier;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;

public class Registries
{
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, MODID);

    public static final RegistryObject<OmnisLootModifier.Serializer> TEAR_OF_VEX = GLM.register("tear_of_vex", OmnisLootModifier.Serializer::new);
    public static final RegistryObject<OmnisLootModifier.Serializer> EVOKER_CHARM = GLM.register("evoker_charm", OmnisLootModifier.Serializer::new);
    public static final RegistryObject<OmnisLootModifier.Serializer> RAVAGED_SCRAP_RAVAGER = GLM.register("ravaged_scrap_ravager", OmnisLootModifier.Serializer::new);
    public static final RegistryObject<OmnisLootModifier.Serializer> RAVAGED_SCRAP_ILLAGER = GLM.register("ravaged_scrap_illager", OmnisLootModifier.Serializer::new);
    public static final RegistryObject<OmnisLootModifier.Serializer> RAVAGED_SCRAP_VINDICATOR = GLM.register("ravaged_scrap_vindicator", OmnisLootModifier.Serializer::new);
}
