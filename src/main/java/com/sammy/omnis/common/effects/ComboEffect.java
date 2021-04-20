package com.sammy.omnis.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class ComboEffect extends Effect
{
    public ComboEffect()
    {
        super(EffectType.BENEFICIAL, -1);

    }
    
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier)
    {
    }
}