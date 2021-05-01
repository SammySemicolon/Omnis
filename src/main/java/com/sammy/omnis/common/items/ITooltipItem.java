package com.sammy.omnis.common.items;

import net.minecraft.util.text.ITextComponent;

import java.util.List;

public interface ITooltipItem
{
    public default boolean noDetailed()
    {
        return false;
    }
    public default void detailedTooltip(List<ITextComponent> tooltip)
    {

    }
    public void tooltip(List<ITextComponent> tooltip);
}
