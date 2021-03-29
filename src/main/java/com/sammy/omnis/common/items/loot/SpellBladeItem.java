package com.sammy.omnis.common.items.loot;

import com.sammy.omnis.common.items.ModSwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class SpellBladeItem extends ModSwordItem
{
    public SpellBladeItem(IItemTier material, int attackDamage, float attackSpeed, Properties properties)
    {
        super(material, attackDamage, attackSpeed, properties);
    }
}
