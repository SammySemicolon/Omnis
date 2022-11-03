package com.sammy.omnis.core.data;

import com.sammy.omnis.core.registry.block.BlockRegistry;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import team.lodestar.lodestone.helpers.DataHelper;

import java.util.HashSet;
import java.util.Set;

import static com.sammy.omnis.core.registry.SoundRegistry.SOUNDS;
import static com.sammy.omnis.OmnisMod.OMNIS;
import static com.sammy.omnis.core.registry.effects.EffectRegistry.EFFECTS;
import static com.sammy.omnis.core.registry.item.EnchantmentRegistry.ENCHANTMENTS;


public class ModLangProvider extends LanguageProvider
{
    public ModLangProvider(DataGenerator gen)
    {
        super(gen, OMNIS, "en_us");
    }
    
    @Override
    protected void addTranslations()
    {
        Set<RegistryObject<Block>> blocks = new HashSet<>(BlockRegistry.BLOCKS.getEntries());
        Set<RegistryObject<Item>> items = new HashSet<>(ItemRegistry.ITEMS.getEntries());
        Set<RegistryObject<SoundEvent>> sounds = new HashSet<>(SOUNDS.getEntries());
        Set<RegistryObject<Enchantment>> enchantments = new HashSet<>(ENCHANTMENTS.getEntries());
        Set<RegistryObject<MobEffect>> effects = new HashSet<>(EFFECTS.getEntries());
        DataHelper.takeAll(items, i -> i.get() instanceof BlockItem);
        DataHelper.takeAll(blocks, i -> i.get() instanceof WallTorchBlock);
        blocks.forEach(b -> {
            String name = b.get().getDescriptionId().replaceFirst("block." + OMNIS + ".", "");
            name = DataHelper.toTitleCase(specialBlockNameChanges(name), "_");
            add(b.get().getDescriptionId(), name);
        });
        
        items.forEach(i -> {
            if (!(i.get() instanceof BlockItem))
            {
                String name = i.get().getDescriptionId().replaceFirst("item." + OMNIS + ".", "");
                name = DataHelper.toTitleCase(specialBlockNameChanges(name), "_");
                add(i.get().getDescriptionId(), name);
            }
        });

        sounds.forEach(s -> {
            String name = DataHelper.toTitleCase(s.getId().getPath(), "_");
            add(OMNIS + ".subtitle." + s.getId().getPath(), name);
        });
        enchantments.forEach(e -> {
            String name = DataHelper.toTitleCase(e.getId().getPath(), "_");
            add(e.get().getDescriptionId(), name);
        });
        effects.forEach(e -> {
            String name = DataHelper.toTitleCase(e.getId().getPath(), "_");
            add("effect." + OMNIS + "." + e.get().getRegistryName().getPath(), name);
        });

        addTooltip("ravage", "Ravage");
        addTooltip("ravage_detailed", "Staggers and stuns enemies when attacking");

        addTooltip("arcane", "Arcane");
        addTooltip("arcane_detailed", "Deals both magic and physical damage with each swing");

        addTooltip("staggering", "Staggering");
        addTooltip("staggering_detailed", "Staggers healthy enemies\n" +
                "Staggered enemies deal less damage and have decreased armor");

        addTooltip("stunning", "Stunning");
        addTooltip("stunning_detailed", "Stuns healthy enemies\n" +
                "Stunned enemies move slower and have decreased range");

        addTooltip("crushing", "Crushing");
        addTooltip("crushing_detailed", "Deals more damage to healthy enemies");

        addTooltip("sweeping", "Sweeping");
        addTooltip("sweeping_detailed", "Every hit causes a strong sweep attack");

        addTooltip("outlying", "Outlying");
        addTooltip("outlying_detailed", "Deals more damage to faraway enemies");

        addTooltip("curative", "Curative");
        addTooltip("curative_detailed", "Beneficial potion effects last longer, harmful effects are shorter.");

        addPotion("magic_proficiency", "Magic Proficiency");

        add("attribute.name.omnis.magic_resistance", "Magic Resistance");
        add("attribute.name.omnis.magic_proficiency", "Magic Proficiency");

        add("itemGroup." + OMNIS, "Omnis");
    }

    @Override
    public String getName()
    {
        return "Lang Entries";
    }

    public void addTooltip(String identifier, String tooltip)
    {
        add("omnis.tooltip." + identifier, tooltip);
    }

    public void addPotion(String identifier, String name)
    {
        add("item.minecraft.potion.effect."+identifier, "Potion of "+name);
        add("item.minecraft.potion.effect.long_"+identifier, "Potion of "+name);
        add("item.minecraft.potion.effect.strong_"+identifier, "Potion of "+name);

        add("item.minecraft.splash_potion.effect."+identifier, "Splash Potion of "+name);
        add("item.minecraft.splash_potion.effect.long_"+identifier, "Splash Potion of "+name);
        add("item.minecraft.splash_potion.effect.strong_"+identifier, "Splash Potion of "+name);

        add("item.minecraft.lingering_potion.effect."+identifier, "Lingering Potion of "+name);
        add("item.minecraft.lingering_potion.effect.long_"+identifier, "Lingering Potion of "+name);
        add("item.minecraft.lingering_potion.effect.strong_"+identifier, "Lingering Potion of "+name);

        add("item.minecraft.tipped_arrow.effect."+identifier, "Arrow of "+name);
        add("item.minecraft.tipped_arrow.effect.long_"+identifier, "Arrow of "+name);
        add("item.minecraft.tipped_arrow.effect.strong_"+identifier, "Arrow of "+name);
    }
    public String specialBlockNameChanges(String name)
    {
        if ((!name.endsWith("_bricks")))
        {
            if (name.contains("bricks"))
            {
                name = name.replaceFirst("bricks", "brick");
            }
        }
        if (name.contains("_fence") || name.contains("_button"))
        {
            if (name.contains("planks"))
            {
                name = name.replaceFirst("_planks", "");
            }
        }
        return name;
    }
}