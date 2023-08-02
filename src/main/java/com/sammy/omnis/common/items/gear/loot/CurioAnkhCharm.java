package com.sammy.omnis.common.items.gear.loot;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;


public class CurioAnkhCharm extends Item implements ICurioItem, ITooltipItem {
    public CurioAnkhCharm(Properties builder) {
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

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.curative_detailed").withStyle(ChatFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.curative").withStyle(ChatFormatting.BLUE));
    }
}