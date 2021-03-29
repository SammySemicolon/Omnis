package com.sammy.omnis.init;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.OmnisMod;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid= OmnisMod.MODID, value= Dist.CLIENT, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ClientStartupEvents
{

    @SubscribeEvent
    public static void setRenderLayers(FMLClientSetupEvent event)
    {
        Set<RegistryObject<Block>> blocks = new HashSet<>(OmnisBlocks.BLOCKS.getEntries());
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof TorchBlock).forEach(ClientStartupEvents::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof TrapDoorBlock).forEach(ClientStartupEvents::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof DoorBlock).forEach(ClientStartupEvents::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof SaplingBlock).forEach(ClientStartupEvents::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof LeavesBlock).forEach(ClientStartupEvents::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof BushBlock).forEach(ClientStartupEvents::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof LanternBlock).forEach(ClientStartupEvents::setCutout);
    }
    
    public static void setCutout(RegistryObject<Block> b)
    {
        RenderTypeLookup.setRenderLayer(b.get(), RenderType.getCutout());
    }
}