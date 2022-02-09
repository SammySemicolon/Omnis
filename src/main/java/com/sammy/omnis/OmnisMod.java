package com.sammy.omnis;

import com.sammy.omnis.core.data.*;
import com.sammy.omnis.core.registry.EntityRegistry;
import com.sammy.omnis.core.systems.particles.ParticleRendering;
import net.minecraft.data.BlockTagsProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sammy.omnis.OmnisMod.MODID;
import static com.sammy.omnis.core.registry.EntityRegistry.ENTITY_TYPES;
import static com.sammy.omnis.core.registry.block.BlockRegistry.BLOCKS;
import static com.sammy.omnis.core.registry.block.TileEntityRegistry.TILE_ENTITIES;
import static com.sammy.omnis.core.registry.item.EnchantmentRegistry.ENCHANTMENTS;
import static com.sammy.omnis.core.registry.item.ItemRegistry.ITEMS;
import static com.sammy.omnis.core.registry.misc.AttributeRegistry.ATTRIBUTES;
import static com.sammy.omnis.core.registry.ParticleRegistry.PARTICLES;
import static com.sammy.omnis.core.registry.SoundRegistry.SOUNDS;
import static com.sammy.omnis.core.registry.misc.LootModifierRegistry.*;
import static com.sammy.omnis.core.registry.effects.EffectRegistry.EFFECTS;
import static com.sammy.omnis.core.registry.effects.PotionRegistry.POTIONS;

@Mod(MODID)
public class OmnisMod
{
    public static final String MODID = "omnis";
    public static final Logger LOGGER = LogManager.getLogger();

    public OmnisMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ATTRIBUTES.register(modBus);
        ENCHANTMENTS.register(modBus);
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        TILE_ENTITIES.register(modBus);
        ENTITY_TYPES.register(modBus);
        GLM.register(modBus);
        POTIONS.register(modBus);
        EFFECTS.register(modBus);
        PARTICLES.register(modBus);
        SOUNDS.register(modBus);
        modBus.addListener(this::gatherData);
        DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> {
            MinecraftForge.EVENT_BUS.register(new ParticleRendering());
            return new Object();
        });
    }
    public void gatherData(GatherDataEvent evt)
    {
        BlockTagsProvider provider = new ModBlockTagProvider(evt.getGenerator(), evt.getExistingFileHelper());
        evt.getGenerator().addProvider(new ModBlockStateProvider(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ModItemModelProvider(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ModLangProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(provider);
        evt.getGenerator().addProvider(new ModLootTableProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(new ModLootProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(new ModItemTagProvider(evt.getGenerator(),provider, evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ModRecipeProvider(evt.getGenerator()));
    }
}
