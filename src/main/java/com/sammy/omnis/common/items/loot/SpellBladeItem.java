package com.sammy.omnis.common.items.loot;

import com.sammy.omnis.common.items.basic.ModSwordItem;
import net.minecraft.item.IItemTier;

public class SpellBladeItem extends ModSwordItem
{
    public final float effectStrength;
    public SpellBladeItem(IItemTier material, int attackDamage, float attackSpeed, Properties properties, float effectStrength)
    {
        super(material, attackDamage, attackSpeed, properties);
        this.effectStrength = effectStrength;
    }
}
