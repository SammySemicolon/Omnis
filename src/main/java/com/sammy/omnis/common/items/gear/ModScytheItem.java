package com.sammy.omnis.common.items.gear;

import com.sammy.omnis.common.items.ModHoeItem;
import net.minecraft.item.IItemTier;

public class ModScytheItem extends ModHoeItem
{
    public final float areaDamage;
    public ModScytheItem(IItemTier material, int damage, float speed, float areaDamage, Properties properties)
    {
        super(material, damage + 3, speed + 0.6f, properties);
        this.areaDamage = areaDamage;
    }
}
