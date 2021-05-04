package com.sammy.omnis.common.events;

import com.sammy.omnis.common.items.ITooltipItem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ClientOnlyEvents
{
    @SubscribeEvent
    public static void tooltipsEvent(ItemTooltipEvent event)
    {
        if (event.getItemStack().getItem() instanceof ITooltipItem)
        {
            ITooltipItem tooltipItem = (ITooltipItem) event.getItemStack().getItem();
            if (tooltipItem.noDetailed())
            {
                tooltipItem.tooltip(event.getToolTip());
                return;
            }
            if (Screen.hasShiftDown())
            {
                tooltipItem.detailedTooltip(event.getToolTip());
            }
            else
            {
                tooltipItem.tooltip(event.getToolTip());
            }
        }
    }
}
