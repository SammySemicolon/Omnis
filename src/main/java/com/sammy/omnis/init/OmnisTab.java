package com.sammy.omnis.init;

import com.sammy.omnis.OmnisMod;
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
        return new ItemStack(OmnisItems.HAUNTED_STEEL_BLOCK.get());
    }
}
