package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.ITooltipItem;
import com.sammy.omnis.common.items.ModCombatItem;
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

import java.util.List;

public class ModSpearItem extends ModCombatItem implements ITooltipItem
{
    public float distanceDamage;
    public ModSpearItem(IItemTier material, float damage, float speed, float distanceDamage, Properties properties)
    {
        super(material, damage + 3f, speed - 2.4f, properties);
        this.distanceDamage = distanceDamage;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        float distance = target.getDistance(attacker);
        if (distance > 2f)
        {
            target.hurtResistantTime = 0;
            target.attackEntityFrom(DamageSource.causeMobDamage(attacker), distanceDamage);
            target.world.playSound(null, target.getPosition(), SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.PLAYERS, 1, 1.8f);
            target.world.playSound(null, target.getPosition(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 1, 0.8f);
            target.world.playSound(null, target.getPosition(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 1, 1f);
            target.world.playSound(null, target.getPosition(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 1, 1.2f);
            if (attacker instanceof PlayerEntity)
            {
                ((PlayerEntity) attacker).onCriticalHit(target);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void detailedTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.outlying_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.outlying").mergeStyle(TextFormatting.BLUE));
    }
}
