package com.sammy.omnis.common.items.basic;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;


public class ModAxeItem extends AxeItem
{
    public ModAxeItem(Tier material, int damage, float speed, Properties properties)
    {
        super(material, damage + 6, speed - 3.2f, properties.durability(material.getUses()));
    }
}


