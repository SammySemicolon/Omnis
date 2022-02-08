package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

import net.minecraft.item.Item.Properties;

public class ModScytheItem extends ModCombatItem implements ITooltipItem, IHurtEventItem
{
    public final float areaDamage;
    public ModScytheItem(IItemTier material, float damage, float speed, float areaDamage, Properties properties)
    {
        super(material, damage + 3, speed - 2.4f, properties);
        this.areaDamage = areaDamage;
    }

    @Override
    public void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack) {
        float damage = 1.0f + event.getAmount() * (areaDamage + EnchantmentHelper.getSweepingDamageRatio(attacker));
        target.level.getEntities(attacker, target.getBoundingBox().inflate(1)).forEach(e ->
        {
            if (e instanceof LivingEntity)
            {
                e.hurt(DamageSource.mobAttack(attacker), damage);
                ((LivingEntity) e).knockback(0.4F, Mth.sin(attacker.yRot * ((float) Math.PI / 180F)), (-Mth.cos(attacker.yRot * ((float) Math.PI / 180F))));
            }
        });
        if (attacker instanceof PlayerEntity)
        {
            ((PlayerEntity) attacker).sweepAttack();
        }
        attacker.level.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, attacker.getSoundSource(), 1,1);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.sweeping_detailed").withStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.sweeping").withStyle(TextFormatting.BLUE));
    }
}
