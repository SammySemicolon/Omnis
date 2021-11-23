package com.sammy.omnis.core.systems.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;

import java.util.List;

public interface ITooltipItem
{
    public default void addTooltip(List<ITextComponent> tooltip)
    {
        if (sneakIndependent())
        {
            addDefaultTooltip(tooltip);
            return;
        }
        if (Screen.hasShiftDown())
        {
            addSneakTooltip(tooltip);
        }
        else
        {
            addDefaultTooltip(tooltip);
        }
    }
    public default boolean sneakIndependent()
    {
        return false;
    }
    public default void addSneakTooltip(List<ITextComponent> tooltip)
    {

    }
    public void addDefaultTooltip(List<ITextComponent> tooltip);
}
