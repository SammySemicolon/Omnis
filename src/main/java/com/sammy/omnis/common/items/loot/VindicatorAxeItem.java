package com.sammy.omnis.common.items.loot;

import com.sammy.omnis.common.items.basic.ModAxeItem;
import net.minecraft.item.IItemTier;

public class VindicatorAxeItem extends ModAxeItem
{
    public final int effectCooldown;

    public VindicatorAxeItem(IItemTier material, int damage, float speed, Properties properties, int effectCooldown)
    {
        super(material, damage, speed, properties);
        this.effectCooldown = effectCooldown;
    }
}
