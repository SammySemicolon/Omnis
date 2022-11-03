package com.sammy.omnis.common.items.gear.loot;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Tier;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import team.lodestar.lodestone.systems.item.IEventResponderItem;
import team.lodestar.lodestone.systems.item.tools.LodestoneSwordItem;

import java.util.List;

public class SpellBladeItem extends LodestoneSwordItem implements ITooltipItem, IEventResponderItem {
    public final float effectStrength;

    public SpellBladeItem(Tier material, int attackDamage, float attackSpeed, Properties properties, float effectStrength) {
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
        tooltip.add(new TranslatableComponent("omnis.tooltip.arcane_detailed").withStyle(ChatFormatting.BLUE));
    }

    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(new TranslatableComponent("omnis.tooltip.arcane").withStyle(ChatFormatting.BLUE));
    }
}
