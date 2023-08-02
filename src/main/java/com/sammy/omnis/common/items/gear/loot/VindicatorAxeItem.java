package com.sammy.omnis.common.items.gear.loot;

import com.sammy.omnis.core.registry.effects.EffectRegistry;
import team.lodestar.lodestone.systems.item.IEventResponderItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import team.lodestar.lodestone.systems.item.tools.LodestoneAxeItem;

import java.util.List;

public class VindicatorAxeItem extends LodestoneAxeItem implements ITooltipItem, IEventResponderItem {
    public final int effectCooldown;

    public VindicatorAxeItem(Tier material, int damage, float speed, Properties properties, int effectCooldown) {
        super(material, damage, speed, properties);
        this.effectCooldown = effectCooldown;
    }

    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getHealth() >= target.getMaxHealth() * 0.9f) {
            if (attacker instanceof Player playerEntity) {
                if (playerEntity.getCooldowns().isOnCooldown(stack.getItem())) {
                    return;
                } else {
                    playerEntity.getCooldowns().addCooldown(stack.getItem(), effectCooldown);
                }
            }
            target.addEffect(new MobEffectInstance(EffectRegistry.STUNNED.get(), 160, 0));
            target.addEffect(new MobEffectInstance(EffectRegistry.STAGGERED.get(), 160, 0));
        }
    }

    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.ravage_detailed").withStyle(ChatFormatting.BLUE));
    }

    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.ravage").withStyle(ChatFormatting.BLUE));
    }
}