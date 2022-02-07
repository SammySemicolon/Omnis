package com.sammy.omnis.common.items.gear.loot;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModSwordItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;


public class SpellBladeItem extends ModSwordItem implements ITooltipItem, IHurtEventItem {
    public final float effectStrength;

    public SpellBladeItem(IItemTier material, int attackDamage, float attackSpeed, Properties properties, float effectStrength) {
        super(material, attackDamage, attackSpeed, properties);
        this.effectStrength = effectStrength;
    }

    @Override
    public void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (!event.getSource().isMagicDamage()) {
            float amount = event.getAmount() * effectStrength;
            event.setAmount(event.getAmount() - amount);
            event.getEntity().hurtResistantTime = 0;
            if (target.isAlive()) {
                target.attackEntityFrom(DamageSource.causeMobDamage(attacker).setMagicDamage(), amount);
            }
            target.playSound(SoundRegistry.MAGIC_CRIT, 1, 1f + target.world.rand.nextFloat() * 0.2f);
        }
    }

    @Override
    public void addSneakTooltip(List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.arcane_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @Override
    public void addDefaultTooltip(List<ITextComponent> tooltip) {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.arcane").mergeStyle(TextFormatting.BLUE));
    }
}
