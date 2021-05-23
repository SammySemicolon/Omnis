package com.sammy.omnis.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.common.util.ForgeSoundType;

public class MagicProficiency extends Effect
{
    public MagicProficiency()
    {
        super(EffectType.BENEFICIAL, 7504018);

    }
    
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier)
    {

    }
}