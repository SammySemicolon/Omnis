package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.registry.effects.EffectRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
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

public class ModHammerItem extends ModCombatItem implements ITooltipItem, IHurtEventItem {
    public final int staggeredAmplifier;

    public ModHammerItem(IItemTier material, float damage, float speed, int staggeredAmplifier, Properties properties) {
        super(material, damage + 6, speed - 3.2f, properties);
        this.staggeredAmplifier = staggeredAmplifier;
    }

    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getHealth() >= target.getMaxHealth()*0.9f) {
            target.addEffect(new EffectInstance(EffectRegistry.STAGGERED.get(), 200, staggeredAmplifier));
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f+target.level.random.nextFloat()*0.2f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.staggering_detailed").withStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.staggering").withStyle(TextFormatting.BLUE));
    }
}