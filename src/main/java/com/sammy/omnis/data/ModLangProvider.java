package com.sammy.omnis.data;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.init.OmnisBlocks;
import com.sammy.omnis.init.OmnisItems;
import net.minecraft.block.Block;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashSet;
import java.util.Set;

import static com.sammy.omnis.init.OmnisSounds.SOUNDS;
import static com.sammy.omnis.init.Registries.*;
import static com.sammy.omnis.OmnisMod.MODID;


public class ModLangProvider extends LanguageProvider
{
    public ModLangProvider(DataGenerator gen)
    {
        super(gen, MODID, "en_us");
    }
    
    @Override
    protected void addTranslations()
    {
        Set<RegistryObject<Block>> blocks = new HashSet<>(OmnisBlocks.BLOCKS.getEntries());
        Set<RegistryObject<Item>> items = new HashSet<>(OmnisItems.ITEMS.getEntries());
        Set<RegistryObject<SoundEvent>> sounds = new HashSet<>(SOUNDS.getEntries());
        Set<RegistryObject<Enchantment>> enchantments = new HashSet<>(ENCHANTMENTS.getEntries());
        Set<RegistryObject<Effect>> effects = new HashSet<>(EFFECTS.getEntries());
        OmnisHelper.takeAll(items, i -> i.get() instanceof BlockItem);
        OmnisHelper.takeAll(blocks, i -> i.get() instanceof WallTorchBlock);
        blocks.forEach(b -> {
            String name = b.get().getTranslationKey().replaceFirst("block." + MODID + ".", "");
            name = OmnisHelper.toTitleCase(specialBlockNameChanges(name), "_");
            add(b.get().getTranslationKey(), name);
        });
        
        items.forEach(i -> {
            if (!(i.get() instanceof BlockItem))
            {
                String name = i.get().getTranslationKey().replaceFirst("item." + MODID + ".", "");
                name = OmnisHelper.toTitleCase(specialBlockNameChanges(name), "_");
                add(i.get().getTranslationKey(), name);
            }
        });

        sounds.forEach(s -> {
            String name = OmnisHelper.toTitleCase(s.getId().getPath(), "_");
            add(MODID + ".subtitle." + s.getId().getPath(), name);
        });
        enchantments.forEach(e -> {
            String name = OmnisHelper.toTitleCase(e.getId().getPath(), "_");
            add(e.get().getName(), name);
        });
        
        effects.forEach(e -> {
            String name = OmnisHelper.toTitleCase(e.getId().getPath(), "_");
            add("effect." + MODID + "." + e.get().getRegistryName().getPath(), name);
        });
        
        add("itemGroup." + MODID, "Omnis ");
    }
    
    @Override
    public String getName()
    {
        return "Lang Entries";
    }
    
    public void addTooltip(String identifier, String tooltip)
    {
        add("modname.tooltip." + identifier, tooltip);
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