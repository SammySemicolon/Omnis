package com.sammy.omnis.common.items.loot;

import com.sammy.omnis.common.items.ModAxeItem;
import net.minecraft.item.IItemTier;

public class VindidatorAxeItem extends ModAxeItem
{
    public final float effectCooldown;

    public VindidatorAxeItem(IItemTier material, int damage, float speed, Properties properties, float effectCooldown)
    {
        super(material, damage, speed, properties);
        this.effectCooldown = effectCooldown;
    }
}
