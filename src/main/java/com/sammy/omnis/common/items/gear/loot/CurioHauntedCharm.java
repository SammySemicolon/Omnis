package com.sammy.omnis.common.items.gear.loot;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.registry.misc.AttributeRegistry;
import com.sammy.omnis.core.systems.item.CurioProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.UUID;

public class CurioHauntedCharm extends Item implements ICurio {
    public CurioHauntedCharm(Properties builder) {
        super(builder);
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT unused) {
        return CurioProvider.createProvider(new ICurio() {
            @Override
            public void playRightClickEquipSound(LivingEntity livingEntity) {
                livingEntity.world.playSound(null, livingEntity.getPosition(), SoundRegistry.SINISTER_EQUIP, SoundCategory.NEUTRAL, 1.0f, 1.0f);

            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext,
                                                                                UUID uuid) {
                Multimap<Attribute, AttributeModifier> atts = HashMultimap.create();
                atts.put(AttributeRegistry.MAGIC_RESISTANCE,
                        new AttributeModifier(uuid, "Curio magic resistance", 2,
                                AttributeModifier.Operation.ADDITION));
                return atts;
            }

            @Override
            public boolean canRightClickEquip() {
                return true;
            }
        });
    }
}