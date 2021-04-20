package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.ModShovelItem;
import net.minecraft.item.IItemTier;

public class ModSpearItem extends ModShovelItem
{
    public float distanceDamage;
    public ModSpearItem(IItemTier material, int damage, float speed, float distanceDamage, Properties properties)
    {
        super(material, damage + 1.5f, speed + 0.6f, properties);
        this.distanceDamage = distanceDamage;
    }
}
