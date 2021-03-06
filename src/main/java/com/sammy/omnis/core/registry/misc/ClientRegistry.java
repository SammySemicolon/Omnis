package com.sammy.omnis.core.registry.misc;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.core.registry.block.BlockRegistry;
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
public class ClientRegistry
{

    @SubscribeEvent
    public static void setRenderLayers(FMLClientSetupEvent event)
    {
        Set<RegistryObject<Block>> blocks = new HashSet<>(BlockRegistry.BLOCKS.getEntries());
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof TorchBlock).forEach(ClientRegistry::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof TrapDoorBlock).forEach(ClientRegistry::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof DoorBlock).forEach(ClientRegistry::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof SaplingBlock).forEach(ClientRegistry::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof LeavesBlock).forEach(ClientRegistry::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof BushBlock).forEach(ClientRegistry::setCutout);
        OmnisHelper.takeAll(blocks, b -> b.get() instanceof LanternBlock).forEach(ClientRegistry::setCutout);
    }
    
    public static void setCutout(RegistryObject<Block> b)
    {
        RenderTypeLookup.setRenderLayer(b.get(), RenderType.getCutout());
    }
}