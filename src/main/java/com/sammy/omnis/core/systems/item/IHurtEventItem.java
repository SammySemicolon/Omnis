package com.sammy.omnis.core.systems.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public interface IHurtEventItem {
    public default void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack)
    {
        hurtEvent(attacker, target, stack);
    }
    public default void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack)
    {

    }
}
