package com.sammy.omnis.common.items.basic;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class ModHoeItem extends HoeItem
{
    public ModHoeItem(Tier material, int damage, float speed, Properties properties)
    {
        super(material, damage, speed - 3, properties.durability(material.getUses()));
    }
}

