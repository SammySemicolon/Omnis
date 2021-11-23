package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.effects.EffectRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
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

public class ModHammerItem extends ModCombatItem implements ITooltipItem, IHurtEventItem {
    public final int staggeredAmplifier;

    public ModHammerItem(IItemTier material, float damage, float speed, int staggeredAmplifier, Properties properties) {
        super(material, damage + 6, speed - 3.2f, properties);
        this.staggeredAmplifier = staggeredAmplifier;
    }

    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getMaxHealth() == target.getHealth()) {
            target.addPotionEffect(new EffectInstance(EffectRegistry.STAGGERED.get(), 200, staggeredAmplifier));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.staggering_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.staggering").mergeStyle(TextFormatting.BLUE));
    }
}