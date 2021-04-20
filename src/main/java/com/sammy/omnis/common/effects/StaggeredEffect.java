package com.sammy.omnis.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class StaggeredEffect extends Effect
{
    public StaggeredEffect()
    {
        super(EffectType.HARMFUL, 7504018);

    }
    
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier)
    {
    }
}