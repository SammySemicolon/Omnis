package com.sammy.omnis.common.events;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.common.items.loot.CurioEvokerCharm;
import com.sammy.omnis.common.items.loot.SpellBladeItem;
import com.sammy.omnis.core.init.OmnisItems;
import com.sammy.omnis.network.packets.ParticlePacket;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;
import top.theillusivec4.curios.api.CuriosApi;

import static com.sammy.omnis.network.NetworkManager.INSTANCE;
import static com.sammy.omnis.network.packets.ParticlePacket.typeEnum.spellBlade;

@Mod.EventBusSubscriber
public class RuntimeEvents
{

    @SubscribeEvent
    public static void triggerOnHitEffects(LivingHurtEvent event)
    {
        if (event.getSource().getTrueSource() instanceof LivingEntity)
        {
            LivingEntity attacker = (LivingEntity) event.getSource().getTrueSource();
            LivingEntity target = event.getEntityLiving();
            ItemStack heldItem = attacker.getHeldItemMainhand();
            if (heldItem.getItem() instanceof SpellBladeItem)
            {
                if (!event.getSource().isMagicDamage())
                {
                    SpellBladeItem spellBladeItem = (SpellBladeItem) heldItem.getItem();
                    float amount = event.getAmount() * spellBladeItem.effectStrength;
                    event.setAmount(event.getAmount() - amount);
                    event.getEntity().hurtResistantTime = 0;
                    target.attackEntityFrom(DamageSource.causeMobDamage(attacker).setMagicDamage(), amount);
                    if (attacker.world instanceof ServerWorld)
                    {
                        INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> target), new ParticlePacket(spellBlade, target.getPosX(), target.getPosY() + target.getHeight() / 2, target.getPosZ()));
                    }
                }
            }
            if (CuriosApi.getCuriosHelper().findEquippedCurio(s -> s.getItem() instanceof CurioEvokerCharm, attacker).isPresent())
            {
                if (event.getSource().isMagicDamage())
                {
                    event.setAmount(event.getAmount() + 4);
                }
            }
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
