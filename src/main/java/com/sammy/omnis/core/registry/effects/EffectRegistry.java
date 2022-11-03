package com.sammy.omnis.core.registry.effects;

import com.sammy.omnis.common.effects.MagicProficiency;
import com.sammy.omnis.common.effects.StaggeredEffect;
import com.sammy.omnis.common.effects.StunnedEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.OMNIS;

public class EffectRegistry
{
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, OMNIS);

    public static final RegistryObject<MobEffect> MAGIC_PROFICIENCY = EFFECTS.register("magic_proficiency", MagicProficiency::new);
    public static final RegistryObject<MobEffect> STAGGERED = EFFECTS.register("staggered", StaggeredEffect::new);
    public static final RegistryObject<MobEffect> STUNNED = EFFECTS.register("stunned", StunnedEffect::new);

}
