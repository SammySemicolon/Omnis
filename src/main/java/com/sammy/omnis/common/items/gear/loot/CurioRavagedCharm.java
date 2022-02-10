package com.sammy.omnis.common.items.gear.loot;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.registry.misc.AttributeRegistry;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CurioRavagedCharm extends Item implements ICurioItem {
    public CurioRavagedCharm(Properties builder) {
        super(builder);
    }

    @Override
    public void playRightClickEquipSound(LivingEntity livingEntity, ItemStack stack) {
        livingEntity.level.playSound(null, livingEntity.blockPosition(), SoundRegistry.HOLY_EQUIP, SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    @Override
    public boolean canRightClickEquip(ItemStack stack) {
        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(String identifier, ItemStack stack)
    {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();
        map.put(Attributes.ARMOR, new AttributeModifier(UUID.fromString("3934b50c-bf25-454f-aac9-42723e8648f2"), "Curio armor", 2f, AttributeModifier.Operation.ADDITION));
        map.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(UUID.fromString("3934b50c-bf25-454f-aac9-42723e8648f2"), "Curio armor toughness", 1f, AttributeModifier.Operation.ADDITION));
        return map;
    }
}