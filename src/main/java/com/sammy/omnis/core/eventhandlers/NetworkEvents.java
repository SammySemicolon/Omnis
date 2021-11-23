package com.sammy.omnis.core.eventhandlers;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.OmnisMod;
import com.sammy.omnis.common.packets.ParticlePacket;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import static com.sammy.omnis.OmnisMod.MODID;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetworkEvents
{
    public static final String PROTOCOL_VERSION = "1";
    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(OmnisHelper.prefix("main"), () -> NetworkEvents.PROTOCOL_VERSION, NetworkEvents.PROTOCOL_VERSION::equals, NetworkEvents.PROTOCOL_VERSION::equals);
    
    @SuppressWarnings("UnusedAssignment")
    @SubscribeEvent
    public static void registerPackets(FMLCommonSetupEvent event)
    {
        int index = 0;
        INSTANCE.registerMessage(index++, ParticlePacket.class, ParticlePacket::encode, ParticlePacket::decode, ParticlePacket::whenThisPacketIsReceived);
    }
}