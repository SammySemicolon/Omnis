package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.ITooltipItem;
import com.sammy.omnis.common.items.ModCombatItem;
import net.minecraft.item.IItemTier;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ModHammerItem extends ModCombatItem implements ITooltipItem
{
    public final int staggeredAmplifier ;
    public ModHammerItem(IItemTier material, float damage, float speed, int staggeredAmplifier, Properties properties)
    {
        super(material, damage + 6, speed - 3.2f, properties);
        this.staggeredAmplifier = staggeredAmplifier;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void detailedTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.staggering_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.staggering").mergeStyle(TextFormatting.BLUE));
    }
}
