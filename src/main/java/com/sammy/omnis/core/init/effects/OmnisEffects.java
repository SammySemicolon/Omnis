package com.sammy.omnis.core.init.effects;

import com.sammy.omnis.common.effects.ComboEffect;
import com.sammy.omnis.common.effects.MagicProficiency;
import com.sammy.omnis.common.effects.StaggeredEffect;
import com.sammy.omnis.common.effects.StunnedEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;

public class OmnisEffects
{
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, MODID);

    public static final RegistryObject<Effect> MAGIC_PROFICIENCY = EFFECTS.register("magic_proficiency", MagicProficiency::new);
    public static final RegistryObject<Effect> COMBO = EFFECTS.register("combo", ComboEffect::new);
    public static final RegistryObject<Effect> STAGGERED = EFFECTS.register("staggered", StaggeredEffect::new);
    public static final RegistryObject<Effect> STUNNED = EFFECTS.register("stunned", StunnedEffect::new);

}
