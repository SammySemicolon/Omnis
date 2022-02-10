package com.sammy.omnis.core.eventhandlers;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import com.sammy.omnis.core.registry.misc.AttributeRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.Collections;
import java.util.UUID;

@Mod.EventBusSubscriber
public class RuntimeEvents {

    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent event) {
        if (event.getType().equals(VillagerProfession.CLERIC)) {
            event.getTrades().putIfAbsent(1, Collections.singletonList(new BasicItemListing(ItemRegistry.EVOKER_CHARM.get().getDefaultInstance(), new ItemStack(Items.EMERALD, 20), ItemRegistry.ANKH_CHARM.get().getDefaultInstance(), 3, 0, 1)));
        }
    }
    @SubscribeEvent
    public static void addTrades(WandererTradesEvent event)
    {
        event.getRareTrades().add(new BasicItemListing(ItemRegistry.EVOKER_CHARM.get().getDefaultInstance(), new ItemStack(Items.EMERALD, 20), ItemRegistry.ANKH_CHARM.get().getDefaultInstance(), 3,0,1));
    }
    @SubscribeEvent
    public static void ankhCharmEffect(PotionEvent.PotionAddedEvent event) {
        if (OmnisHelper.hasCurioEquipped(event.getEntityLiving(), ItemRegistry.ANKH_CHARM)) {
            MobEffectInstance instance = event.getPotionEffect();
            if (instance.getEffect().isBeneficial()) {
                instance.duration *= 1.5f;
            }
            if (instance.getEffect().getCategory().equals(MobEffectCategory.HARMFUL)) {
                instance.duration *= 0.5f;
            }
        }
    }
    @SubscribeEvent
    public static void triggerOnHurtEvents(LivingHurtEvent event) {
        float amount = event.getAmount();
        LivingEntity target = event.getEntityLiving();
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            ItemStack stack = attacker.getMainHandItem();
            Item item = stack.getItem();
            if (item instanceof IHurtEventItem eventItem) {
                eventItem.hurtEvent(event, attacker, target, stack);
            }
            if (event.getSource().isMagic()) {
                float proficiency = (float) attacker.getAttributeValue(AttributeRegistry.MAGIC_PROFICIENCY.get());
                amount *= 1 * Math.exp(0.075f * proficiency);
            }
        }
        if (event.getSource().isMagic()) {
            float resistance = (float) target.getAttributeValue(AttributeRegistry.MAGIC_RESISTANCE.get());
            amount *= 1 * Math.exp(-0.15f * resistance);
        }
        event.setAmount(amount);
    }


    @SubscribeEvent
    public static void giveEnemiesSpecialWeapons(EntityJoinWorldEvent event) {
        if (event.getWorld() instanceof ServerLevel level) {
            if (event.getEntity() instanceof Vex vexEntity) {
                if (level.random.nextFloat() < 0.1f) {
                    vexEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemRegistry.SPELL_BLADE.get().getDefaultInstance());
                    vexEntity.setDropChance(EquipmentSlot.MAINHAND, 0.8F);
                }
            }
            if (event.getEntity() instanceof Vindicator vindicatorEntity) {
                if (level.random.nextFloat() < 0.1f) {
                    if (vindicatorEntity.getMainHandItem().getItem().equals(Items.IRON_AXE)) {
                        vindicatorEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemRegistry.VINDICATOR_AXE.get().getDefaultInstance());
                        vindicatorEntity.setDropChance(EquipmentSlot.MAINHAND, 0.8F);
                        vindicatorEntity.setAggressive(true);
                    }
                }
            }
        }
    }
}