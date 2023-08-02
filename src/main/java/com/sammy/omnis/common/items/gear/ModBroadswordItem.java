package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import team.lodestar.lodestone.systems.item.IEventResponderItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import team.lodestar.lodestone.systems.item.tools.LodestoneSwordItem;

import java.util.List;

public class ModBroadswordItem extends LodestoneSwordItem implements ITooltipItem, IEventResponderItem {
    public final float extraDamage;

    public ModBroadswordItem(Tier material, int attackDamage, float attackSpeed, float extraDamage, Properties properties) {
        super(material, attackDamage + 1, attackSpeed - 0.2f, properties);
        this.extraDamage = extraDamage;
    }

    @Override
    public void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getHealth() >= target.getMaxHealth() * 0.9f) {
            event.setAmount(event.getAmount() + extraDamage);
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f+target.level.random.nextFloat()*0.2f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.crushing_detailed").withStyle(ChatFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.crushing").withStyle(ChatFormatting.BLUE));
    }
}