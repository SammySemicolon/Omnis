package com.sammy.omnis.common.items.gear.loot;

import com.sammy.omnis.core.registry.effects.EffectRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModAxeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

import net.minecraft.item.Item.Properties;

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
                if (playerEntity.getCooldowns().isOnCooldown(stack.getItem()))
                {
                    return;
                }
                else
                {
                    playerEntity.getCooldowns().addCooldown(stack.getItem(), effectCooldown);
                }
            }
            target.addEffect(new EffectInstance(EffectRegistry.STUNNED.get(), 160, 0));
            target.addEffect(new EffectInstance(EffectRegistry.STAGGERED.get(), 160, 0));
        }
    }
    @Override
    public void addSneakTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.ravage_detailed").withStyle(TextFormatting.BLUE));
    }

    @Override
    public void addDefaultTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.ravage").withStyle(TextFormatting.BLUE));
    }
}
