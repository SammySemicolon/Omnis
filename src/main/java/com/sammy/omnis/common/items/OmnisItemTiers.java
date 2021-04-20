package com.sammy.omnis.common.items;

import com.sammy.omnis.core.init.OmnisItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public class OmnisItemTiers
{
    //2, 250, 6.0F, 2.0F, 14 iron
    //4, 2031, 9.0F, 4.0F, 15 netherite
    public enum ItemTierEnum implements IItemTier
    {

        HAUNTED_ITEM(1951, 9f, 3.5f, 4, 22, OmnisItems.HAUNTED_STEEL_INGOT),
        RAVAGED_ITEM(1243, 8f, 2.5f, 3, 14, OmnisItems.HAUNTED_STEEL_INGOT);
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int harvestLevel;
        private final int enchantability;
        private final Supplier<Item> repairItem;

        ItemTierEnum(int maxUses, float efficiency, float attackDamage, int harvestLevel, int enchantability, Supplier<Item> repairItem)
        {
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.harvestLevel = harvestLevel;
            this.enchantability = enchantability;
            this.repairItem = repairItem;
        }

        @Override
        public int getMaxUses()
        {
            return maxUses;
        }

        @Override
        public float getEfficiency()
        {
            return efficiency;
        }

        @Override
        public float getAttackDamage()
        {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel()
        {
            return harvestLevel;
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return Ingredient.fromItems(repairItem.get());
        }
    }
}
