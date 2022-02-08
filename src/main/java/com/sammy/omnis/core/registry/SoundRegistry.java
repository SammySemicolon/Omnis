package com.sammy.omnis.core.registry;

import com.sammy.omnis.OmnisHelper;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;

public class SoundRegistry
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final SoundEvent HAUNTED_STEEL_BREAK = register(new SoundEvent(OmnisHelper.prefix("haunted_steel_break")));
    public static final SoundEvent HAUNTED_STEEL_PLACE = register(new SoundEvent(OmnisHelper.prefix("haunted_steel_place")));
    public static final SoundEvent HAUNTED_STEEL_STEP = register(new SoundEvent(OmnisHelper.prefix("haunted_steel_step")));
    public static final SoundEvent HAUNTED_STEEL_HIT = register(new SoundEvent(OmnisHelper.prefix("haunted_steel_hit")));

    public static final SoundEvent RAVAGED_METAL_BREAK = register(new SoundEvent(OmnisHelper.prefix("ravaged_metal_break")));
    public static final SoundEvent RAVAGED_METAL_PLACE = register(new SoundEvent(OmnisHelper.prefix("ravaged_metal_place")));
    public static final SoundEvent RAVAGED_METAL_STEP = register(new SoundEvent(OmnisHelper.prefix("ravaged_metal_step")));
    public static final SoundEvent RAVAGED_METAL_HIT = register(new SoundEvent(OmnisHelper.prefix("ravaged_metal_hit")));

    public static final SoundEvent GLOOMSTONE_BREAK = register(new SoundEvent(OmnisHelper.prefix("gloomstone_break")));
    public static final SoundEvent GLOOMSTONE_PLACE = register(new SoundEvent(OmnisHelper.prefix("gloomstone_place")));
    public static final SoundEvent GLOOMSTONE_STEP = register(new SoundEvent(OmnisHelper.prefix("gloomstone_step")));
    public static final SoundEvent GLOOMSTONE_HIT = register(new SoundEvent(OmnisHelper.prefix("gloomstone_hit")));

    public static final SoundEvent RAVAGESTONE_BREAK = register(new SoundEvent(OmnisHelper.prefix("ravagestone_break")));
    public static final SoundEvent RAVAGESTONE_PLACE = register(new SoundEvent(OmnisHelper.prefix("ravagestone_place")));
    public static final SoundEvent RAVAGESTONE_STEP = register(new SoundEvent(OmnisHelper.prefix("ravagestone_step")));
    public static final SoundEvent RAVAGESTONE_HIT = register(new SoundEvent(OmnisHelper.prefix("ravagestone_hit")));

    public static final ForgeSoundType HAUNTED_STEEL = new ForgeSoundType(1.0F, 1.0F, ()->HAUNTED_STEEL_BREAK, ()->HAUNTED_STEEL_STEP, ()->HAUNTED_STEEL_PLACE, ()->HAUNTED_STEEL_HIT, ()-> SoundEvents.NETHERITE_BLOCK_FALL);
    public static final ForgeSoundType RAVAGED_METAL = new ForgeSoundType(1.0F, 1.0F, ()->RAVAGED_METAL_BREAK, ()->RAVAGED_METAL_STEP, ()->RAVAGED_METAL_PLACE, ()->RAVAGED_METAL_HIT, ()->SoundEvents.NETHERITE_BLOCK_FALL);
    public static final ForgeSoundType GLOOMSTONE = new ForgeSoundType(1.0F, 1.0F, ()->GLOOMSTONE_BREAK, ()->GLOOMSTONE_STEP, ()->GLOOMSTONE_PLACE, ()->GLOOMSTONE_HIT, ()->SoundEvents.NETHERRACK_FALL);
    public static final ForgeSoundType RAVAGESTONE = new ForgeSoundType(1.0F, 1.25F, ()->RAVAGESTONE_BREAK, ()->RAVAGESTONE_STEP, ()->RAVAGESTONE_PLACE, ()->RAVAGESTONE_HIT, ()->SoundEvents.NETHERRACK_FALL);

    public static final SoundEvent HEAVY_CRIT = register(new SoundEvent(OmnisHelper.prefix("heavy_crit")));
    public static final SoundEvent MAGIC_CRIT = register(new SoundEvent(OmnisHelper.prefix("magic_crit")));

    public static final SoundEvent SINISTER_EQUIP = register(new SoundEvent(OmnisHelper.prefix("sinister_equip")));
    public static final SoundEvent HOLY_EQUIP = register(new SoundEvent(OmnisHelper.prefix("holy_equip")));


    public static SoundEvent register(SoundEvent soundEvent)
    {
        SOUNDS.register(soundEvent.getLocation().getPath(), ()->soundEvent);
        return soundEvent;
    }
}
