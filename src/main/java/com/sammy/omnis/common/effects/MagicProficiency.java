package com.sammy.omnis.common.effects;

import com.sammy.omnis.core.registry.misc.AttributeRegistry;
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
        addAttributesModifier(AttributeRegistry.MAGIC_PROFICIENCY.get(), "122d45bb-90de-4a29-a504-be2400759f49",4, AttributeModifier.Operation.ADDITION);
    }
    
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier)
    {

    }
}