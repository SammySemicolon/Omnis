package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.ITooltipItem;
import com.sammy.omnis.common.items.basic.ModSwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ModBroadswordItem extends ModSwordItem implements ITooltipItem
{
    public final float extraDamage;
    public ModBroadswordItem(IItemTier material, int attackDamage, float attackSpeed, float extraDamage, Properties properties)
    {
        super(material, attackDamage+1, attackSpeed-0.2f, properties);
        this.extraDamage = extraDamage;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void detailedTooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.crushing_detailed").mergeStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tooltip(List<ITextComponent> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.crushing").mergeStyle(TextFormatting.BLUE));
    }
}
