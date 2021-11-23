package com.sammy.omnis.core.eventhandlers;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.common.items.gear.loot.CurioEvokerCharm;
import com.sammy.omnis.common.items.gear.loot.SpellBladeItem;
import com.sammy.omnis.common.items.gear.loot.VindicatorAxeItem;
import com.sammy.omnis.core.registry.item.ItemRegistry;
import com.sammy.omnis.core.registry.effects.EffectRegistry;
import com.sammy.omnis.core.registry.misc.AttributeRegistry;
import com.sammy.omnis.common.packets.ParticlePacket;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.items.ItemHandlerHelper;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.UUID;

import static com.sammy.omnis.core.eventhandlers.NetworkEvents.INSTANCE;
import static com.sammy.omnis.common.packets.ParticlePacket.typeEnum.spellBlade;
import static com.sammy.omnis.common.packets.ParticlePacket.typeEnum.vindicatorAxe;

@Mod.EventBusSubscriber
public class RuntimeEvents {
    @SubscribeEvent
    public static void giveSammyHisTreat(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntity();
            if (OmnisHelper.areWeOnServer(playerEntity.world)) {
                if (playerEntity.getUniqueID().equals(UUID.fromString("0ca54301-6170-4c44-b3e0-b8afa6b81ed2"))) {
                    if (!OmnisHelper.findCosmeticCurio(s -> s.getItem().equals(ItemRegistry.FLUFFY_TAIL.get()), playerEntity).isPresent()) {
                        ItemHandlerHelper.giveItemToPlayer(playerEntity, ItemRegistry.FLUFFY_TAIL.get().getDefaultInstance());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void triggerOnHurtEvents(LivingHurtEvent event) {
        if (event.getSource().getTrueSource() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) event.getSource().getTrueSource();
            LivingEntity target = event.getEntityLiving();
            ItemStack stack = attacker.getHeldItemMainhand();
            Item item = stack.getItem();
            if (item instanceof IHurtEventItem) {
                IHurtEventItem eventItem = (IHurtEventItem) item;
                eventItem.hurtEvent(event, attacker, target, stack);
            }
            if (event.getSource().isMagicDamage()) {
                float amount = event.getAmount();
                amount += attacker.getAttributeValue(AttributeRegistry.MAGIC_PROFICIENCY);
                float multiplier = (float) (1 - target.getAttributeValue(AttributeRegistry.MAGIC_RESISTANCE));
                event.setAmount(amount * multiplier);
            }
        }
    }

    @SubscribeEvent
    public static void giveEnemiesSpecialWeapons(EntityJoinWorldEvent event) {
        if (OmnisHelper.areWeOnServer(event.getWorld())) {
            if (event.getEntity() instanceof VexEntity) {
                VexEntity vexEntity = (VexEntity) event.getEntity();
                if (event.getWorld().rand.nextFloat() < 0.1f) {
                    vexEntity.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemRegistry.SPELL_BLADE.get().getDefaultInstance());
                    vexEntity.setDropChance(EquipmentSlotType.MAINHAND, 0.8F);
                }
            }
            if (event.getEntity() instanceof VindicatorEntity) {
                VindicatorEntity vindicatorEntity = (VindicatorEntity) event.getEntity();
                if (event.getWorld().rand.nextFloat() < 0.1f) {
                    if (vindicatorEntity.getHeldItemMainhand().getItem().equals(Items.IRON_AXE)) {
                        vindicatorEntity.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemRegistry.VINDICATOR_AXE.get().getDefaultInstance());
                        vindicatorEntity.setDropChance(EquipmentSlotType.MAINHAND, 0.8F);
                        vindicatorEntity.setAggroed(true);
                    }
                }
            }
        }
    }
}