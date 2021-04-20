package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.IComboItem;
import com.sammy.omnis.common.items.ModSwordItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ModBroadswordItem extends ModSwordItem implements IComboItem
{
    public final float extraDamage;
    public ModBroadswordItem(IItemTier material, int attackDamage, float attackSpeed, float extraDamage, Properties properties)
    {
        super(material, attackDamage, attackSpeed, properties);
        this.extraDamage = extraDamage;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        increaseCombo(attacker, target);
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public int maxCombo(LivingEntity attacker, LivingEntity target)
    {
        return 2;
    }

    @Override
    public void triggerCombo(LivingEntity attacker, LivingEntity target)
    {
        target.hurtResistantTime = 0;
        target.attackEntityFrom(DamageSource.causeMobDamage(attacker), extraDamage);
    }
}
