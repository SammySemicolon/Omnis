package com.sammy.omnis.core.registry.item.tabs;

import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class OmnisTab extends ItemGroup
{
    public static final OmnisTab INSTANCE = new OmnisTab();

    public OmnisTab() {
        super(OmnisMod.MODID);
    }
    
    @Nonnull
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.HAUNTED_STEEL_BLOCK.get());
    }
}
