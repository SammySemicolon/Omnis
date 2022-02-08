package com.sammy.omnis.common.items.gear.loot;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModSwordItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;


import net.minecraft.item.Item.Properties;

public class SpellBladeItem extends ModSwordItem implements ITooltipItem, IHurtEventItem {
    public final float effectStrength;

    public SpellBladeItem(IItemTier material, int attackDamage, float attackSpeed, Properties properties, float effectStrength) {
        super(material, attackDamage, attackSpeed, properties);
        this.effectStrength = effectStrength;
    }

    @Override
    public void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (!event.getSource().isMagic()) {
            float amount = event.getAmount() * effectStrength;
            event.setAmount(event.getAmount() - amount);
            event.getEntity().invulnerableTime = 0;
            if (target.isAlive()) {
                target.hurt(DamageSource.mobAttack(attacker).setMagic(), amount);
            }
            target.playSound(SoundRegistry.MAGIC_CRIT, 1, 1f + target.level.random.nextFloat() * 0.2f);
        }
    }

    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.arcane_detailed").withStyle(TextFormatting.BLUE));
    }

    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.arcane").withStyle(TextFormatting.BLUE));
    }
}
