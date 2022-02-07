package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.registry.effects.EffectRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModAxeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ModGreataxeItem extends ModAxeItem implements ITooltipItem, IHurtEventItem {
    public final int stunnedAmplifier;

    public ModGreataxeItem(IItemTier material, int damage, float speed, int stunnedAmplifier, Properties properties) {
        super(material, damage, speed, properties);
        this.stunnedAmplifier = stunnedAmplifier;
    }

    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getHealth() >= target.getMaxHealth()*0.9f) {
            target.addPotionEffect(new EffectInstance(EffectRegistry.STUNNED.get(), 200, stunnedAmplifier));
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f+target.world.rand.nextFloat()*0.2f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.stunning_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.stunning").mergeStyle(TextFormatting.BLUE));
    }
}
