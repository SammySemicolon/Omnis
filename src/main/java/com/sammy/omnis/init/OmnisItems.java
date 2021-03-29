package com.sammy.omnis.init;

import com.sammy.omnis.common.items.loot.SpellBladeItem;
import com.sammy.omnis.common.items.loot.VindidatorAxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;
import static com.sammy.omnis.common.items.OmnisItemTiers.ItemTierEnum.HAUNTED_STEEL_ITEM;

public class OmnisItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static Item.Properties DEFAULT_PROPERTIES()
    {
        return new Item.Properties().group(OmnisTab.INSTANCE);
    }
    public static Item.Properties GEAR_PROPERTIES()
    {
        return new Item.Properties().group(OmnisTab.INSTANCE).maxStackSize(1);
    }
    public static final RegistryObject<Item> TEAR_OF_HEX = ITEMS.register("tear_of_vex", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> VEXWART = ITEMS.register("vexwart", () -> new BlockItem(OmnisBlocks.VEXWART.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> VEXWART_BLOCK = ITEMS.register("vexwart_block", () -> new BlockItem(OmnisBlocks.VEXWART_BLOCK.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_STEEL_INGOT = ITEMS.register("haunted_steel_ingot", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_STEEL_BLOCK = ITEMS.register("haunted_steel_block", () -> new BlockItem(OmnisBlocks.HAUNTED_STEEL_BLOCK.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> VINDICATOR_AXE = ITEMS.register("vindicator_axe", () -> new VindidatorAxeItem(ItemTier.IRON, 2, -0.2f, GEAR_PROPERTIES(), 80));
    public static final RegistryObject<Item> HAUNTED_VINDICATOR_AXE = ITEMS.register("haunted_vindicator_axe", () -> new VindidatorAxeItem(HAUNTED_STEEL_ITEM, 2, -0.2f, GEAR_PROPERTIES(), 20));
    public static final RegistryObject<Item> SPELL_BLADE = ITEMS.register("spell_blade", () -> new SpellBladeItem(ItemTier.DIAMOND, -1, 0.1f, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_SPELL_BLADE = ITEMS.register("haunted_spell_blade", () -> new SpellBladeItem(HAUNTED_STEEL_ITEM, -1, 0.1f, GEAR_PROPERTIES()));


}
