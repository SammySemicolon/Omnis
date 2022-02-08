package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.registry.effects.EffectRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModAxeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

import net.minecraft.item.Item.Properties;

public class ModGreataxeItem extends ModAxeItem implements ITooltipItem, IHurtEventItem {
    public final int stunnedAmplifier;

    public ModGreataxeItem(IItemTier material, int damage, float speed, int stunnedAmplifier, Properties properties) {
        super(material, damage, speed, properties);
        this.stunnedAmplifier = stunnedAmplifier;
    }

    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getHealth() >= target.getMaxHealth()*0.9f) {
            target.addEffect(new EffectInstance(EffectRegistry.STUNNED.get(), 200, stunnedAmplifier));
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f+target.level.random.nextFloat()*0.2f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.stunning_detailed").withStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.stunning").withStyle(TextFormatting.BLUE));
    }
}
