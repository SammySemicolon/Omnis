package com.sammy.omnis.common.events;

import com.sammy.omnis.OmnisHelper;
import com.sammy.omnis.common.items.ITooltipItem;
import com.sammy.omnis.common.items.equipment.armor.HauntedSteelArmorItem;
import com.sammy.omnis.common.items.gear.ModBroadswordItem;
import com.sammy.omnis.common.items.gear.ModGreataxeItem;
import com.sammy.omnis.common.items.gear.ModHammerItem;
import com.sammy.omnis.common.items.loot.CurioEvokerCharm;
import com.sammy.omnis.common.items.loot.SpellBladeItem;
import com.sammy.omnis.common.items.loot.VindicatorAxeItem;
import com.sammy.omnis.core.init.OmnisItems;
import com.sammy.omnis.core.init.effects.OmnisEffects;
import com.sammy.omnis.network.packets.ParticlePacket;
import net.minecraft.client.gui.screen.Screen;
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
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;
import top.theillusivec4.curios.api.CuriosApi;

import static com.sammy.omnis.network.NetworkManager.INSTANCE;
import static com.sammy.omnis.network.packets.ParticlePacket.typeEnum.spellBlade;
import static com.sammy.omnis.network.packets.ParticlePacket.typeEnum.vindicatorAxe;

@Mod.EventBusSubscriber
public class RuntimeEvents
{
    @SubscribeEvent
    public static void tooltipsEvent(ItemTooltipEvent event)
    {
        if (event.getItemStack().getItem() instanceof ITooltipItem)
        {
            ITooltipItem tooltipItem = (ITooltipItem) event.getItemStack().getItem();
            if (tooltipItem.noDetailed())
            {
                tooltipItem.tooltip(event.getToolTip());
                return;
            }
            if (Screen.hasShiftDown())
            {
                tooltipItem.detailedTooltip(event.getToolTip());
            }
            else
            {
                tooltipItem.tooltip(event.getToolTip());
            }
        }
    }
    @SubscribeEvent
    public static void triggerOnHitEffects(LivingHurtEvent event)
    {
        if (event.getSource().getTrueSource() instanceof PlayerEntity)
        {
            PlayerEntity attacker = (PlayerEntity) event.getSource().getTrueSource();
            LivingEntity target = event.getEntityLiving();
            ItemStack heldStack = attacker.getHeldItemMainhand();
            Item heldItem = heldStack.getItem();
            if (target.getMaxHealth() == target.getHealth())
            {
                boolean success = false;
                if (heldItem instanceof ModHammerItem)
                {
                    target.addPotionEffect(new EffectInstance(OmnisEffects.STAGGERED.get(), 200, ((ModHammerItem) heldItem).staggeredAmplifier));
                    success = true;
                }
                if (heldItem instanceof ModGreataxeItem)
                {
                    target.addPotionEffect(new EffectInstance(OmnisEffects.STUNNED.get(), 200, ((ModGreataxeItem) heldItem).stunnedAmplifier));
                    success = true;
                }
                if (heldItem instanceof ModBroadswordItem)
                {
                    if (!attacker.getCooldownTracker().hasCooldown(heldItem))
                    {
                        attacker.getCooldownTracker().setCooldown(heldItem, 4);
                        target.hurtResistantTime = 0;
                        target.attackEntityFrom(DamageSource.causeMobDamage(attacker), ((ModBroadswordItem) heldItem).extraDamage);
                        success = true;
                    }
                }
                if (success)
                {
                    target.world.playSound(null, target.getPosition(), SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.PLAYERS, 1, 1.8f);
                    target.world.playSound(null, target.getPosition(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 1, 0.8f);
                    target.world.playSound(null, target.getPosition(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 1, 1f);
                    target.world.playSound(null, target.getPosition(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 1, 1.2f);
                    attacker.onCriticalHit(target);
                }
            }
            if (heldItem instanceof VindicatorAxeItem)
            {
                if (target.getCreatureAttribute().equals(CreatureAttribute.ILLAGER) || target instanceof PlayerEntity || target instanceof AbstractVillagerEntity || target instanceof ZombieVillagerEntity)
                {
                    VindicatorAxeItem vindicatorAxeItem = (VindicatorAxeItem) heldItem;
                    if (!attacker.getCooldownTracker().hasCooldown(heldItem))
                    {
                        event.setAmount(event.getAmount()+8);
                        if (attacker.world instanceof ServerWorld)
                        {
                            INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> target), new ParticlePacket(vindicatorAxe, target.getPosX(), target.getPosY() + target.getEyeHeight(), target.getPosZ()));
                        }
                        attacker.getCooldownTracker().setCooldown(vindicatorAxeItem.getItem(), vindicatorAxeItem.effectCooldown);
                    }
                }
            }
            if (heldItem instanceof SpellBladeItem)
            {
                if (!event.getSource().isMagicDamage())
                {
                    SpellBladeItem spellBladeItem = (SpellBladeItem) heldItem;
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
            if (event.getSource().isMagicDamage())
            {
                float resistance = 1f;
                for (ItemStack stack : target.getArmorInventoryList())
                {
                    if (stack.getItem() instanceof HauntedSteelArmorItem)
                    {
                        resistance -= 0.125f;
                    }
                }
                event.setAmount(event.getAmount() * resistance);
            }
            if (CuriosApi.getCuriosHelper().findEquippedCurio(s -> s.getItem() instanceof CurioEvokerCharm, attacker).isPresent())
            {
                if (event.getSource().isMagicDamage())
                {
                    event.setAmount(event.getAmount() + 4);
                }
            }
            EffectInstance effectInstance = attacker.getActivePotionEffect(OmnisEffects.MAGIC_PROFICIENCY.get());
            if (effectInstance != null)
            {
                if (event.getSource().isMagicDamage())
                {
                    event.setAmount(event.getAmount() + 4*(effectInstance.getAmplifier()+1));
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
