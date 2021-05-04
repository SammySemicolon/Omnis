package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModAxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ModGreataxeItem extends ModAxeItem implements ITooltipItem
{
    public final int stunnedAmplifier;
    public ModGreataxeItem(IItemTier material, int damage, float speed, int stunnedAmplifier, Properties properties)
    {
        super(material, damage, speed, properties);
        this.stunnedAmplifier = stunnedAmplifier;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void detailedTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.stunning_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.stunning").mergeStyle(TextFormatting.BLUE));
    }
}
