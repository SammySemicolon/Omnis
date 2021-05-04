package com.sammy.omnis.common.items.loot;

import com.sammy.omnis.common.items.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModSwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

public class SpellBladeItem extends ModSwordItem implements ITooltipItem
{
    public final float effectStrength;
    public SpellBladeItem(IItemTier material, int attackDamage, float attackSpeed, Properties properties, float effectStrength)
    {
        super(material, attackDamage, attackSpeed, properties);
        this.effectStrength = effectStrength;
    }
    @Override
    public void detailedTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.arcane_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @Override
    public void tooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.arcane").mergeStyle(TextFormatting.BLUE));
    }
}
