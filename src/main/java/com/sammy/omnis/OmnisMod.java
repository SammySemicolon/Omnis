package com.sammy.omnis;

import com.sammy.omnis.data.*;
import net.minecraft.data.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.data.event.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sammy.omnis.OmnisMod.OMNIS;
import static com.sammy.omnis.core.registry.block.BlockRegistry.BLOCKS;
import static com.sammy.omnis.core.registry.item.ItemRegistry.ITEMS;
import static com.sammy.omnis.core.registry.SoundRegistry.SOUNDS;
import static com.sammy.omnis.core.registry.LootModifierRegistry.*;
import static com.sammy.omnis.core.registry.effects.EffectRegistry.EFFECTS;
import static com.sammy.omnis.core.registry.effects.PotionRegistry.POTIONS;

@Mod(OMNIS)
public class OmnisMod {
    public static final String OMNIS = "omnis";
    public static final Logger LOGGER = LogManager.getLogger();

    public OmnisMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        LOOT_MODIFIERS.register(modBus);
        POTIONS.register(modBus);
        EFFECTS.register(modBus);
        SOUNDS.register(modBus);

        modBus.addListener(DataOnly::gatherData);
    }

    public static ResourceLocation omnisPath(String path) {
        return new ResourceLocation(OMNIS, path);
    }

    public static class DataOnly {
        public static void gatherData(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            generator.addProvider(event.includeServer(), new OmnisBlockTags(generator, event.getExistingFileHelper()));
        }
    }

}