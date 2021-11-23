package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public class ModSpearItem extends ModCombatItem implements ITooltipItem, IHurtEventItem
{
    public float distanceDamage;
    public ModSpearItem(IItemTier material, float damage, float speed, float distanceDamage, Properties properties)
    {
        super(material, damage + 3f, speed - 2.4f, properties);
        this.distanceDamage = distanceDamage;
    }

    @Override
    public void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack) {
        float distance = target.getDistance(attacker);
        if (distance > 3.5f)
        {
            target.hurtResistantTime = 0;
            event.setAmount(event.getAmount() + distanceDamage);
        }
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.outlying_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.outlying").mergeStyle(TextFormatting.BLUE));
    }
}
