package com.sammy.omnis.common.items.basic;


import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class ModShovelItem extends ShovelItem
{
    public ModShovelItem(Tier material, float damage, float speed, Properties properties)
    {
        super(material, damage + 1.5f, speed - 3f, properties.durability(material.getUses()));
    }
}