package com.sammy.omnis.core.eventhandlers;

import com.sammy.omnis.core.registry.item.ItemRegistry;
import com.sammy.omnis.core.registry.AttributeRegistry;
import team.lodestar.lodestone.systems.item.IEventResponderItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.npc.VillagerProfession;
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
import team.lodestar.lodestone.helpers.CurioHelper;

import java.util.Collections;

@Mod.EventBusSubscriber
public class RuntimeEvents {

    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent event) {
        if (event.getType().equals(VillagerProfession.CLERIC)) {
            event.getTrades().putIfAbsent(1, Collections.singletonList(new BasicItemListing(ItemRegistry.EVOKER_CHARM.get().getDefaultInstance(), new ItemStack(Items.EMERALD, 20), ItemRegistry.ANKH_CHARM.get().getDefaultInstance(), 3, 0, 1)));
        }
    }

    @SubscribeEvent
    public static void addTrades(WandererTradesEvent event) {
        event.getRareTrades().add(new BasicItemListing(ItemRegistry.EVOKER_CHARM.get().getDefaultInstance(), new ItemStack(Items.EMERALD, 20), ItemRegistry.ANKH_CHARM.get().getDefaultInstance(), 3, 0, 1));
    }

    @SubscribeEvent
    public static void ankhCharmEffect(PotionEvent.PotionAddedEvent event) {
        if (CurioHelper.hasCurioEquipped(event.getEntityLiving(), ItemRegistry.ANKH_CHARM.get())) {
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
    public static void giveEnemiesSpecialWeapons(EntityJoinWorldEvent event) {
        if (event.getWorld() instanceof ServerLevel level) {
            if (event.getEntity() instanceof Vex vexEntity) {
                if (level.random.nextFloat() < 0.1f) {
                    vexEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemRegistry.SPELL_BLADE.get().getDefaultInstance());
                    vexEntity.setDropChance(EquipmentSlot.MAINHAND, 0.5F);
                }
            }
            if (event.getEntity() instanceof Vindicator vindicatorEntity) {
                if (level.random.nextFloat() < 0.1f) {
                    if (vindicatorEntity.getMainHandItem().getItem().equals(Items.IRON_AXE)) {
                        vindicatorEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemRegistry.VINDICATOR_AXE.get().getDefaultInstance());
                        vindicatorEntity.setDropChance(EquipmentSlot.MAINHAND, 0.5F);
                        vindicatorEntity.setAggressive(true);
                    }
                }
            }
        }
    }
}