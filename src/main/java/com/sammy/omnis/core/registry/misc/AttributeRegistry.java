package com.sammy.omnis.core.registry.misc;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeRegistry {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, MODID);

    public static final Attribute MAGIC_RESISTANCE = register("magic_resistance", new RangedAttribute("attribute.name.omnis.magic_resistance", 0.0D, 0.0D, 2048.0D));
    public static final Attribute MAGIC_PROFICIENCY = register("magic_proficiency", new RangedAttribute("attribute.name.omnis.magic_proficiency", 0.0D, 0.0D, 2048.0D));

    public static Attribute register(String name, Attribute attribute) {
        ATTRIBUTES.register(name, () -> attribute);
        return attribute;
    }

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(e -> {
            event.add(e, AttributeRegistry.MAGIC_RESISTANCE);
            event.add(e, AttributeRegistry.MAGIC_PROFICIENCY);
        });
    }
}