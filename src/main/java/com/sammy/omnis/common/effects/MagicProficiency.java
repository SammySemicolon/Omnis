package com.sammy.omnis.common.effects;

import com.sammy.omnis.core.registry.misc.AttributeRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class MagicProficiency extends MobEffect
{
    public MagicProficiency()
    {
        super(MobEffectCategory.BENEFICIAL, 7504018);
        addAttributeModifier(AttributeRegistry.MAGIC_PROFICIENCY, "122d45bb-90de-4a29-a504-be2400759f49",4, AttributeModifier.Operation.ADDITION);
    }
    
    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier)
    {

    }
}