package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import team.lodestar.lodestone.systems.item.IEventResponderItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import team.lodestar.lodestone.systems.item.ModCombatItem;

import java.util.List;

public class ModSpearItem extends ModCombatItem implements ITooltipItem, IEventResponderItem {
    public float distanceDamage;

    public ModSpearItem(Tier material, float damage, float speed, float distanceDamage, Properties properties) {
        super(material, damage + 3f, speed - 2.4f, properties);
        this.distanceDamage = distanceDamage;
    }

    @Override
    public void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack) {
        float distance = target.distanceTo(attacker);
        if (distance > 3f) {
            target.invulnerableTime = 0;
            event.setAmount(event.getAmount() + distanceDamage);
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f + target.level.random.nextFloat() * 0.2f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.outlying_detailed").withStyle(ChatFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("omnis.tooltip.outlying").withStyle(ChatFormatting.BLUE));
    }
}
