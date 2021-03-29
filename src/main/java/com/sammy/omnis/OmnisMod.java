package com.sammy.omnis;

import com.sammy.omnis.data.*;
import com.sammy.omnis.init.OmnisBlocks;
import com.sammy.omnis.init.OmnisSounds;
import net.minecraft.data.BlockTagsProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sammy.omnis.OmnisMod.MODID;
import static com.sammy.omnis.init.OmnisItems.ITEMS;
import static com.sammy.omnis.init.Registries.*;

@Mod(MODID)
public class OmnisMod
{
    public static final String MODID = "omnis";
    public static final Logger LOGGER = LogManager.getLogger();

    public OmnisMod() {

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENCHANTMENTS.register(modBus);
        OmnisBlocks.BLOCKS.register(modBus);
        ITEMS.register(modBus);
        TILE_ENTITIES.register(modBus);
        ENTITY_TYPES.register(modBus);
        EFFECTS.register(modBus);
        OmnisSounds.SOUNDS.register(modBus);
        modBus.addListener(this::gatherData);
    }
    public void gatherData(GatherDataEvent evt)
    {
        BlockTagsProvider provider = new ModBlockTagProvider(evt.getGenerator());
        evt.getGenerator().addProvider(new ModBlockStateProvider(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ModItemModelProvider(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ModLangProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(provider);
        evt.getGenerator().addProvider(new ModLootTableProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(new ModItemTagProvider(evt.getGenerator(),provider));
        evt.getGenerator().addProvider(new ModRecipeProvider(evt.getGenerator()));
    }
}
