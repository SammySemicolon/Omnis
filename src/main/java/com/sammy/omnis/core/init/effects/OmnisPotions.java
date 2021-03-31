package com.sammy.omnis.core.init.effects;

import com.sammy.omnis.core.init.OmnisItems;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OmnisPotions
{
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, MODID);

    public static final RegistryObject<Potion> MAGIC_PROFICIENCY = POTIONS.register("magic_proficiency", () -> new Potion("magic_proficiency", new EffectInstance(OmnisEffects.MAGIC_PROFICIENCY.get(), 3600)));
    public static final RegistryObject<Potion> LONG_MAGIC_PROFICIENCY = POTIONS.register("long_magic_proficiency", () -> new Potion("long_magic_proficiency", new EffectInstance(OmnisEffects.MAGIC_PROFICIENCY.get(), 9600)));
    public static final RegistryObject<Potion> STRONG_MAGIC_PROFICIENCY = POTIONS.register("strong_magic_proficiency", () -> new Potion("strong_magic_proficiency", new EffectInstance(OmnisEffects.MAGIC_PROFICIENCY.get(), 1800, 1)));

    @SubscribeEvent
    public static void addPotionRecipes(FMLCommonSetupEvent event)
    {
        PotionBrewing.addMix(Potions.WATER, OmnisItems.TEAR_OF_VEX.get(), Potions.MUNDANE);
        PotionBrewing.addMix(Potions.AWKWARD, OmnisItems.TEAR_OF_VEX.get(), MAGIC_PROFICIENCY.get());
        PotionBrewing.addMix(MAGIC_PROFICIENCY.get(), Items.REDSTONE, LONG_MAGIC_PROFICIENCY.get());
        PotionBrewing.addMix(MAGIC_PROFICIENCY.get(), Items.GLOWSTONE_DUST, STRONG_MAGIC_PROFICIENCY.get());

    }
}
