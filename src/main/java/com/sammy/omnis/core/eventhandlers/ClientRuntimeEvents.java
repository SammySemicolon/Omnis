package com.sammy.omnis.core.eventhandlers;

import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ClientRuntimeEvents {
    @SubscribeEvent
    public static void tooltipsEvent(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() instanceof ITooltipItem tooltipItem) {
            tooltipItem.addTooltip(event.getToolTip());
        }
    }
}