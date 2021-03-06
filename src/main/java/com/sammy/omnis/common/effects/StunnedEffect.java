package com.sammy.omnis.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.common.ForgeMod;

public class StunnedEffect extends Effect
{
    public StunnedEffect()
    {
        super(EffectType.HARMFUL, 7504018);
        addAttributesModifier(ForgeMod.REACH_DISTANCE.get(), "39af1573-4283-48c0-9d1d-21056fdf44d4", -0.2f, AttributeModifier.Operation.MULTIPLY_TOTAL);
        addAttributesModifier(Attributes.MOVEMENT_SPEED, "c5c03946-774c-4b8a-a482-82186ce40915", -0.2f, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
    
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier)
    {
    }
}