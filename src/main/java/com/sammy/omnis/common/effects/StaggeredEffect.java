package com.sammy.omnis.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.common.ForgeMod;

public class StaggeredEffect extends Effect
{
    public StaggeredEffect()
    {
        super(EffectType.HARMFUL, 7504018);
        addAttributesModifier(Attributes.ARMOR, "a77b8b57-a7e1-4a11-8191-808c08062411", -2f, AttributeModifier.Operation.ADDITION);
        addAttributesModifier(Attributes.ATTACK_DAMAGE, "26777582-0edb-4c1e-b13f-5b900b2ae24f", -1f, AttributeModifier.Operation.ADDITION);

    }
    
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier)
    {
    }
}