package com.sammy.omnis.common.items.gear.loot;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.SoundCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.List;

import net.minecraft.item.Item.Properties;

public class CurioAnkhCharm extends Item implements ICurio, ITooltipItem {
    public CurioAnkhCharm(Properties builder) {
        super(builder);
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag unused) {
        return CurioProvider.createProvider(new ICurio() {
            @Override
            public void playRightClickEquipSound(LivingEntity livingEntity) {
                livingEntity.level.playSound(null, livingEntity.blockPosition(), SoundRegistry.HOLY_EQUIP, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            }

            @Override
            public boolean canRightClickEquip() {
                return true;
            }
        });
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.curative_detailed").withStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.curative").withStyle(TextFormatting.BLUE));
    }
}