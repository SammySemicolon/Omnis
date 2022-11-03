package com.sammy.omnis.core.eventhandlers;

import com.sammy.omnis.OmnisMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import static com.sammy.omnis.OmnisMod.OMNIS;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = OMNIS, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetworkEvents {
    public static final String PROTOCOL_VERSION = "1";
    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(OmnisMod.omnisPath("main"), () -> NetworkEvents.PROTOCOL_VERSION, NetworkEvents.PROTOCOL_VERSION::equals, NetworkEvents.PROTOCOL_VERSION::equals);

    @SuppressWarnings("UnusedAssignment")
    @SubscribeEvent
    public static void registerPackets(FMLCommonSetupEvent event) {
        int index = 0;
    }
}