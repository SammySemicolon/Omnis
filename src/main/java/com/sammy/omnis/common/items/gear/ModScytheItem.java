package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ModScytheItem extends ModCombatItem implements ITooltipItem, IHurtEventItem
{
    public final float areaDamage;
    public ModScytheItem(IItemTier material, float damage, float speed, float areaDamage, Properties properties)
    {
        super(material, damage + 3, speed - 2.4f, properties);
        this.areaDamage = areaDamage;
    }

    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        target.world.getEntitiesWithinAABBExcludingEntity(attacker, target.getBoundingBox().grow(1)).forEach(e ->
        {
            if (e instanceof LivingEntity)
            {
                float baseDamage = (float) attacker.getAttributeValue(Attributes.ATTACK_DAMAGE);
                float damage = 1.0f + baseDamage * areaDamage + baseDamage * EnchantmentHelper.getSweepingDamageRatio(attacker);
                e.attackEntityFrom(DamageSource.causeMobDamage(attacker), damage);
                ((LivingEntity) e).applyKnockback(0.4F, MathHelper.sin(attacker.rotationYaw * ((float) Math.PI / 180F)), (-MathHelper.cos(attacker.rotationYaw * ((float) Math.PI / 180F))));
            }
        });
        if (attacker instanceof PlayerEntity)
        {
            ((PlayerEntity) attacker).spawnSweepParticles();
        }
        attacker.world.playSound(null, attacker.getPosX(), attacker.getPosY(), attacker.getPosZ(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, attacker.getSoundCategory(), 1,1);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.sweeping_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.sweeping").mergeStyle(TextFormatting.BLUE));
    }
}
