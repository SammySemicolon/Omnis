package com.sammy.omnis.common.effects;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;

public class StunnedEffect extends MobEffect
{
    public StunnedEffect()
    {
        super(MobEffectCategory.HARMFUL, 7504018);
        addAttributeModifier(ForgeMod.REACH_DISTANCE.get(), "39af1573-4283-48c0-9d1d-21056fdf44d4", -0.2f, AttributeModifier.Operation.MULTIPLY_TOTAL);
        addAttributeModifier(Attributes.MOVEMENT_SPEED, "c5c03946-774c-4b8a-a482-82186ce40915", -0.2f, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
    
    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier)
    {
    }
}