package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.registry.effects.EffectRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModSwordItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public class ModBroadswordItem extends ModSwordItem implements ITooltipItem, IHurtEventItem {
    public final float extraDamage;

    public ModBroadswordItem(IItemTier material, int attackDamage, float attackSpeed, float extraDamage, Properties properties) {
        super(material, attackDamage + 1, attackSpeed - 0.2f, properties);
        this.extraDamage = extraDamage;
    }

    @Override
    public void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getHealth() >= target.getMaxHealth()*0.9f) {
            event.setAmount(event.getAmount() + extraDamage);
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f+target.world.rand.nextFloat()*0.2f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.crushing_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.crushing").mergeStyle(TextFormatting.BLUE));
    }
}