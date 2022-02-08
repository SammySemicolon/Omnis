package com.sammy.omnis.common.items.equipment.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class OmnisArmorItem extends ArmorItem {
    private final Multimap<Attribute, AttributeModifier> attributes;

    public OmnisArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder, ImmutableMultimap.Builder<Attribute, AttributeModifier> extraAttributes) {
        super(materialIn, slot, builder);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeBuilder = new ImmutableMultimap.Builder<>();
        attributeBuilder.putAll(defaultModifiers);
        attributeBuilder.putAll(extraAttributes.build());
        attributes = attributeBuilder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == this.slot ? this.attributes : ImmutableMultimap.of();
    }

    public String getTexture() {
        return null;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "omnis:textures/armor/" + getTexture() + ".png";
    }
}