package com.sammy.omnis.core.init;

import com.sammy.omnis.OmnisHelper;
import net.minecraft.block.SoundType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;

public class OmnisSounds
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final SoundEvent HAUNTED_STEEL_BREAK = register(new SoundEvent(OmnisHelper.prefix("haunted_steel_break")));
    public static final SoundEvent HAUNTED_STEEL_PLACE = register(new SoundEvent(OmnisHelper.prefix("haunted_steel_place")));
    public static final SoundEvent HAUNTED_STEEL_STEP = register(new SoundEvent(OmnisHelper.prefix("haunted_steel_step")));
    public static final SoundEvent HAUNTED_STEEL_HIT = register(new SoundEvent(OmnisHelper.prefix("haunted_steel_hit")));

    public static final SoundEvent SINISTER_EQUIP = register(new SoundEvent(OmnisHelper.prefix("sinister_equip")));
    public static final SoundEvent HOLY_EQUIP = register(new SoundEvent(OmnisHelper.prefix("holy_equip")));

    public static final SoundType HAUNTED_STEEL = new SoundType(1.0F, 1.0F, HAUNTED_STEEL_BREAK, HAUNTED_STEEL_STEP, HAUNTED_STEEL_PLACE, HAUNTED_STEEL_HIT, SoundEvents.BLOCK_NETHERITE_BLOCK_FALL);
    public static SoundEvent register(SoundEvent soundEvent)
    {
        SOUNDS.register(soundEvent.name.getPath(), ()->soundEvent);
        return soundEvent;
    }
}
