package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.core.registry.SoundRegistry;
import com.sammy.omnis.core.systems.item.IHurtEventItem;
import com.sammy.omnis.core.systems.item.ITooltipItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

import net.minecraft.item.Item.Properties;

public class ModSpearItem extends ModCombatItem implements ITooltipItem, IHurtEventItem
{
    public float distanceDamage;
    public ModSpearItem(IItemTier material, float damage, float speed, float distanceDamage, Properties properties)
    {
        super(material, damage + 3f, speed - 2.4f, properties);
        this.distanceDamage = distanceDamage;
    }

    @Override
    public void hurtEvent(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, ItemStack stack) {
        float distance = target.distanceTo(attacker);
        if (distance > 3.5f)
        {
            target.invulnerableTime = 0;
            event.setAmount(event.getAmount() + distanceDamage);
            target.playSound(SoundRegistry.HEAVY_CRIT, 1, 1f+target.level.random.nextFloat()*0.2f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void addSneakTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.outlying_detailed").withStyle(TextFormatting.BLUE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addDefaultTooltip(List<Component> tooltip)
    {
        tooltip.add(new TranslationTextComponent("omnis.tooltip.outlying").withStyle(TextFormatting.BLUE));
    }
}
