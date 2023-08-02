package com.sammy.omnis.common.items.gear.loot;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sammy.omnis.core.registry.SoundRegistry;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

import team.lodestar.lodestone.registry.common.*;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CurioHauntedCharm extends Item implements ICurioItem {
    public CurioHauntedCharm(Properties builder) {
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
        map.put(LodestoneAttributeRegistry.MAGIC_RESISTANCE.get(), new AttributeModifier(UUID.fromString("bd9ddafc-2c03-44eb-b9b5-fffcba187a0e"), "Curio magic resistance", 2f, AttributeModifier.Operation.ADDITION));
        return map;
    }
}