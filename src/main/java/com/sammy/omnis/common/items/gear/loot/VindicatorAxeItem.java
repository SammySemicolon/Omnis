package com.sammy.omnis.common.items.gear.loot;

import com.sammy.omnis.core.registry.effects.EffectRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModAxeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

public class VindicatorAxeItem extends ModAxeItem implements ITooltipItem, IHurtEventItem
{
    public final int effectCooldown;

    public VindicatorAxeItem(IItemTier material, int damage, float speed, Properties properties, int effectCooldown)
    {
        super(material, damage, speed, properties);
        this.effectCooldown = effectCooldown;
    }
    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getMaxHealth() == target.getHealth()) {
            if (attacker instanceof PlayerEntity)
            {
                PlayerEntity playerEntity = (PlayerEntity) attacker;
                if (playerEntity.getCooldownTracker().hasCooldown(stack.getItem()))
                {
                    return;
                }
                else
                {
                    playerEntity.getCooldownTracker().setCooldown(stack.getItem(), effectCooldown);
                }
            }
            target.addPotionEffect(new EffectInstance(EffectRegistry.STUNNED.get(), 160, 0));
            target.addPotionEffect(new EffectInstance(EffectRegistry.STAGGERED.get(), 160, 0));
        }
    }
    @Override
    public void addSneakTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.ravage_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @Override
    public void addDefaultTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.ravage").mergeStyle(TextFormatting.BLUE));
    }
}
