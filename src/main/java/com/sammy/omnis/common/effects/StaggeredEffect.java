package com.sammy.omnis.common.effects;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class StaggeredEffect extends MobEffect
{
    public StaggeredEffect()
    {
        super(MobEffectCategory.HARMFUL, 7504018);
        addAttributeModifier(Attributes.ARMOR, "a77b8b57-a7e1-4a11-8191-808c08062411", -2f, AttributeModifier.Operation.ADDITION);
        addAttributeModifier(Attributes.ATTACK_DAMAGE, "26777582-0edb-4c1e-b13f-5b900b2ae24f", -1f, AttributeModifier.Operation.ADDITION);

    }
    
    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier)
    {
    }
}