package com.sammy.omnis.common.items.gear.loot;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sammy.omnis.core.registry.AttributeRegistry;
import com.sammy.omnis.core.registry.SoundRegistry;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

import team.lodestar.lodestone.setup.LodestoneAttributeRegistry;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CurioEvokerCharm extends Item implements ICurioItem {
    public CurioEvokerCharm(Properties builder) {
        super(builder);
    }

    @Override
    public void playRightClickEquipSound(LivingEntity livingEntity, ItemStack stack) {
        livingEntity.level.playSound(null, livingEntity.blockPosition(), SoundRegistry.SINISTER_EQUIP, SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    @Override
    public boolean canRightClickEquip(ItemStack stack) {
        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(String identifier, ItemStack stack)
    {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();
        map.put(LodestoneAttributeRegistry.MAGIC_PROFICIENCY.get(), new AttributeModifier(UUID.fromString("62172327-7169-4f8d-8252-ddf0d4872de9"), "Curio magic proficiency", 1f, AttributeModifier.Operation.ADDITION));
        return map;
    }
}