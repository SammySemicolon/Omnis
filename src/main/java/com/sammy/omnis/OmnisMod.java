package com.sammy.omnis;

import com.sammy.omnis.core.data.*;
import com.sammy.omnis.core.registry.EntityRegistry;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sammy.omnis.OmnisMod.OMNIS;
import static com.sammy.omnis.core.registry.block.BlockRegistry.BLOCKS;
import static com.sammy.omnis.core.registry.block.TileEntityRegistry.TILE_ENTITIES;
import static com.sammy.omnis.core.registry.item.EnchantmentRegistry.ENCHANTMENTS;
import static com.sammy.omnis.core.registry.item.ItemRegistry.ITEMS;
import static com.sammy.omnis.core.registry.AttributeRegistry.ATTRIBUTES;
import static com.sammy.omnis.core.registry.ParticleRegistry.PARTICLES;
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
        ATTRIBUTES.register(modBus);
        ENCHANTMENTS.register(modBus);
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        TILE_ENTITIES.register(modBus);
        EntityRegistry.ENTITY_TYPES.register(modBus);
        LOOT_MODIFIERS.register(modBus);
        POTIONS.register(modBus);
        EFFECTS.register(modBus);
        PARTICLES.register(modBus);
        SOUNDS.register(modBus);
        modBus.addListener(this::gatherData);
    }

    public static ResourceLocation omnisPath(String path) {
        return new ResourceLocation(OMNIS, path);
    }

    public void gatherData(GatherDataEvent evt) {
        BlockTagsProvider provider = new ModBlockTagProvider(evt.getGenerator(), evt.getExistingFileHelper());
        evt.getGenerator().addProvider(new ModBlockStateProvider(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ModItemModelProvider(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ModLangProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(provider);
        evt.getGenerator().addProvider(new ModLootTableProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(new ModLootProvider(evt.getGenerator()));
        evt.getGenerator().addProvider(new ModItemTagProvider(evt.getGenerator(), provider, evt.getExistingFileHelper()));
        evt.getGenerator().addProvider(new ModRecipeProvider(evt.getGenerator()));
    }
}