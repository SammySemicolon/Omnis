package com.sammy.omnis.core.systems.item;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.List;

public interface ITooltipItem
{
    public default void addTooltip(List<Component> tooltip)
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
    public default void addSneakTooltip(List<Component> tooltip)
    {

    }
    public void addDefaultTooltip(List<Component> tooltip);
}
