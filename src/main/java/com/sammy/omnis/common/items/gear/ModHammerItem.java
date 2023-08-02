package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.registry.effects.EffectRegistry;
import team.lodestar.lodestone.systems.item.IEventResponderItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import team.lodestar.lodestone.systems.item.ModCombatItem;
import team.lodestar.lodestone.systems.item.tools.LodestonePickaxeItem;

import java.util.List;

public class ModHammerItem extends ModCombatItem implements ITooltipItem, IEventResponderItem {
    public final int staggeredAmplifier;

    public ModHammerItem(Tier material, float damage, float speed, int staggeredAmplifier, Properties properties) {
        super(material, damage + 6, speed - 3.2f, properties);
        this.staggeredAmplifier = staggeredAmplifier;
    }

    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getHealth() >= target.getMaxHealth()*0.9f) {
            target.addEffect(new MobEffectInstance(EffectRegistry.STAGGERED.get(), 200, staggeredAmplifier));
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f+target.level.random.nextFloat()*0.2f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.staggering_detailed").withStyle(ChatFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.staggering").withStyle(ChatFormatting.BLUE));
    }
}