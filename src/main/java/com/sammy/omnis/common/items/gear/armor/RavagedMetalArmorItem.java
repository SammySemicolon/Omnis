package com.sammy.omnis.common.items.gear.armor;

import com.google.common.collect.ImmutableMultimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

import static com.sammy.omnis.core.registry.item.ArmorTierRegistry.ArmorTierEnum.RAVAGED_ARMOR;

public class RavagedMetalArmorItem extends OmnisArmorItem {
    public RavagedMetalArmorItem(EquipmentSlot slot, Item.Properties builder) {
        super(RAVAGED_ARMOR, slot, builder);
    }

    public String getTexture() {
        return "ravaged_metal";
    }
}