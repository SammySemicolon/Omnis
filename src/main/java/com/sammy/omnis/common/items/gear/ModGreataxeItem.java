package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.IComboItem;
import com.sammy.omnis.common.items.ModAxeItem;
import com.sammy.omnis.core.init.effects.OmnisEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;

public class ModGreataxeItem extends ModAxeItem implements IComboItem
{
    public final int stunnedAmplifier;
    public ModGreataxeItem(IItemTier material, int damage, float speed, int stunnedAmplifier, Properties properties)
    {
        super(material, damage, speed, properties);
        this.stunnedAmplifier = stunnedAmplifier;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        increaseCombo(attacker, target);
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public int maxCombo(LivingEntity attacker, LivingEntity target)
    {
        return 5;
    }

    @Override
    public void triggerCombo(LivingEntity attacker, LivingEntity target)
    {
        target.addPotionEffect(new EffectInstance(OmnisEffects.STUNNED.get(), 100, stunnedAmplifier));
    }
}
