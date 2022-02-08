package com.sammy.omnis.core.eventhandlers;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import com.sammy.omnis.core.registry.misc.AttributeRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import net.minecraft.client.renderer.entity.WanderingTraderRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.MobEffectCategory;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
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
    public static void giveSammyHisTreat(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntity();
            if (OmnisHelper.areWeOnServer(playerEntity.level)) {
                if (playerEntity.getUUID().equals(UUID.fromString("0ca54301-6170-4c44-b3e0-b8afa6b81ed2"))) {
                    if (!OmnisHelper.findCosmeticCurio(s -> s.getItem().equals(ItemRegistry.FLUFFY_TAIL.get()), playerEntity).isPresent()) {
                        ItemHandlerHelper.giveItemToPlayer(playerEntity, ItemRegistry.FLUFFY_TAIL.get().getDefaultInstance());
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent event) {
        if (event.getType().equals(VillagerProfession.CLERIC)) {
            event.getTrades().putIfAbsent(1, Collections.singletonList(new BasicTrade(ItemRegistry.EVOKER_CHARM.get().getDefaultInstance(), new ItemStack(Items.EMERALD, 20), ItemRegistry.ANKH_CHARM.get().getDefaultInstance(), 3, 0, 1)));
        }
    }
    @SubscribeEvent
    public static void addTrades(WandererTradesEvent event)
    {
        event.getRareTrades().add(new BasicTrade(ItemRegistry.EVOKER_CHARM.get().getDefaultInstance(), new ItemStack(Items.EMERALD, 20), ItemRegistry.ANKH_CHARM.get().getDefaultInstance(), 3,0,1));
    }
    @SubscribeEvent
    public static void ankhCharmEffect(PotionEvent.PotionAddedEvent event) {
        if (OmnisHelper.hasCurioEquipped(event.getEntityLiving(), ItemRegistry.ANKH_CHARM)) {
            EffectInstance instance = event.getPotionEffect();
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
        if (event.getSource().getEntity() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
            LivingEntity target = event.getEntityLiving();
            ItemStack stack = attacker.getMainHandItem();
            Item item = stack.getItem();
            if (item instanceof IHurtEventItem) {
                IHurtEventItem eventItem = (IHurtEventItem) item;
                eventItem.hurtEvent(event, attacker, target, stack);
            }
            if (event.getSource().isMagic()) {
                float resistance = (float) target.getAttributeValue(AttributeRegistry.MAGIC_RESISTANCE);
                float proficiency = (float) target.getAttributeValue(AttributeRegistry.MAGIC_PROFICIENCY);
                float amount = event.getAmount() + proficiency;
                float multiplier = 1 - (resistance * 0.125f);
                event.setAmount(amount*multiplier);
            }
        }
    }

    @SubscribeEvent
    public static void giveEnemiesSpecialWeapons(EntityJoinLevelEvent event) {
        if (OmnisHelper.areWeOnServer(event.getLevel())) {
            if (event.getEntity() instanceof VexEntity) {
                VexEntity vexEntity = (VexEntity) event.getEntity();
                if (event.getLevel().random.nextFloat() < 0.1f) {
                    vexEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemRegistry.SPELL_BLADE.get().getDefaultInstance());
                    vexEntity.setDropChance(EquipmentSlot.MAINHAND, 0.8F);
                }
            }
            if (event.getEntity() instanceof VindicatorEntity) {
                VindicatorEntity vindicatorEntity = (VindicatorEntity) event.getEntity();
                if (event.getLevel().random.nextFloat() < 0.1f) {
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