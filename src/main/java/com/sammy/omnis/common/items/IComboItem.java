package com.sammy.omnis.common.items;

import com.sammy.omnis.core.init.effects.OmnisEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;

public interface IComboItem
{
    public default void increaseCombo(LivingEntity attacker, LivingEntity target)
    {
        EffectInstance activeEffect = attacker.getActivePotionEffect(OmnisEffects.COMBO.get());
        int combo = 0;
        if (activeEffect != null)
        {
            combo = activeEffect.getAmplifier() > 0 ? activeEffect.getAmplifier()+1 : 1;
        }
        if (combo == maxCombo(attacker,target))
        {
            triggerCombo(attacker, target);
            attacker.removePotionEffect(OmnisEffects.COMBO.get());
            return;
        }
        EffectInstance newEffect = new EffectInstance(OmnisEffects.COMBO.get(), 100, combo);
        attacker.addPotionEffect(newEffect);
    }
    public int maxCombo(LivingEntity attacker, LivingEntity target);
    public void triggerCombo(LivingEntity attacker, LivingEntity target);
}
