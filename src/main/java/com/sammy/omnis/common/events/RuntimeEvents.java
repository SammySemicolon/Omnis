package com.sammy.omnis.common.events;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.common.items.loot.CurioEvokerCharm;
import com.sammy.omnis.core.init.OmnisItems;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;

@Mod.EventBusSubscriber
public class RuntimeEvents
{

    @SubscribeEvent
    public static void triggerOnHitEffects(LivingHurtEvent event)
    {
        if (!event.getSource().isMagicDamage())
        {
            return;
        }
        if (CuriosApi.getCuriosHelper().findEquippedCurio(s -> s.getItem() instanceof CurioEvokerCharm, event.getEntityLiving()).isPresent())
        {
            event.setAmount(event.getAmount() + 4);
        }

    }
    @SubscribeEvent
    public static void giveEnemiesSpecialWeapons(EntityJoinWorldEvent event)
    {
        if (OmnisHelper.areWeOnServer(event.getWorld()))
        {
            if (event.getEntity() instanceof VexEntity)
            {
                VexEntity vexEntity = (VexEntity) event.getEntity();
                if (event.getWorld().rand.nextFloat() < 0.1f)
                {
                    vexEntity.setItemStackToSlot(EquipmentSlotType.MAINHAND, OmnisItems.SPELL_BLADE.get().getDefaultInstance());
                    vexEntity.setDropChance(EquipmentSlotType.MAINHAND, 0.8F);
                }
            }
            if (event.getEntity() instanceof VindicatorEntity)
            {
                VindicatorEntity vexEntity = (VindicatorEntity) event.getEntity();
                if (event.getWorld().rand.nextFloat() < 0.1f)
                {
                    vexEntity.setItemStackToSlot(EquipmentSlotType.MAINHAND, OmnisItems.VINDICATOR_AXE.get().getDefaultInstance());
                    vexEntity.setDropChance(EquipmentSlotType.MAINHAND, 0.8F);
                }
            }
        }
    }
}
