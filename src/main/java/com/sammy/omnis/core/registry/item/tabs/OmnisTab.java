package com.sammy.omnis.core.registry.item.tabs;

import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class OmnisTab extends CreativeModeTab
{
    public static final OmnisTab INSTANCE = new OmnisTab();

    public OmnisTab() {
        super(OmnisMod.OMNIS);
    }
    
    @Nonnull
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.HAUNTED_STEEL_BLOCK.get());
    }
}
