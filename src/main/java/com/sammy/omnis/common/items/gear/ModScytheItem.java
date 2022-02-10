package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public class ModScytheItem extends ModCombatItem implements ITooltipItem, IHurtEventItem
{
    public final float areaDamage;
    public ModScytheItem(Tier material, float damage, float speed, float areaDamage, Properties properties)
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
                ((LivingEntity) e).knockback(0.4F, Mth.sin(attacker.getYRot() * ((float) Math.PI / 180F)), (-Mth.cos(attacker.getYRot() * ((float) Math.PI / 180F))));
            }
        });
        if (attacker instanceof Player player)
        {
            player.sweepAttack();
        }
        attacker.level.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, attacker.getSoundSource(), 1,1);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslatableComponent("omnis.tooltip.sweeping_detailed").withStyle(ChatFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslatableComponent("omnis.tooltip.sweeping").withStyle(ChatFormatting.BLUE));
    }
}
