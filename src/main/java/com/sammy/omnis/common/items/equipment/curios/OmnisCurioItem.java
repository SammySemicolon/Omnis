package com.sammy.omnis.common.items.equipment.curios;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class OmnisCurioItem extends Item implements ICurioItem
{
    public OmnisCurioItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean canRightClickEquip(ItemStack stack)
    {
        return true;
    }
}
