package com.sammy.omnis.common.items.loot;

import com.sammy.omnis.common.items.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModAxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

public class VindicatorAxeItem extends ModAxeItem implements ITooltipItem
{
    public final int effectCooldown;

    public VindicatorAxeItem(IItemTier material, int damage, float speed, Properties properties, int effectCooldown)
    {
        super(material, damage, speed, properties);
        this.effectCooldown = effectCooldown;
    }
    @Override
    public void detailedTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.ravage_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @Override
    public void tooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.ravage").mergeStyle(TextFormatting.BLUE));
    }
}
