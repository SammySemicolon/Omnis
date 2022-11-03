package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.registry.effects.EffectRegistry;
import team.lodestar.lodestone.systems.item.IEventResponderItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import team.lodestar.lodestone.systems.item.tools.LodestoneAxeItem;

import java.util.List;

public class ModGreataxeItem extends LodestoneAxeItem implements ITooltipItem, IEventResponderItem {
    public final int stunnedAmplifier;

    public ModGreataxeItem(Tier material, int damage, float speed, int stunnedAmplifier, Properties properties) {
        super(material, damage, speed, properties);
        this.stunnedAmplifier = stunnedAmplifier;
    }

    @Override
    public void hurtEvent(LivingEntity attacker, LivingEntity target, ItemStack stack) {
        if (target.getHealth() >= target.getMaxHealth()*0.9f) {
            target.addEffect(new MobEffectInstance(EffectRegistry.STUNNED.get(), 200, stunnedAmplifier));
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f+target.level.random.nextFloat()*0.2f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(new TranslatableComponent("omnis.tooltip.stunning_detailed").withStyle(ChatFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(new TranslatableComponent("omnis.tooltip.stunning").withStyle(ChatFormatting.BLUE));
    }
}
