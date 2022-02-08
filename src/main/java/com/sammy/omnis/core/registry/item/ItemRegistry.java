package com.sammy.omnis.core.registry.item;

import com.sammy.omnis.common.items.equipment.armor.HauntedSteelArmorItem;
import com.sammy.omnis.common.items.equipment.armor.RavagedMetalArmorItem;
import com.sammy.omnis.common.items.gear.*;
import com.sammy.omnis.common.items.gear.loot.*;
import com.sammy.omnis.core.registry.block.BlockRegistry;
import com.sammy.omnis.core.registry.item.tabs.OmnisTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;
import static com.sammy.omnis.core.registry.item.ItemTierRegistry.ItemTierEnum.HAUNTED_ITEM;
import static com.sammy.omnis.core.registry.item.ItemTierRegistry.ItemTierEnum.RAVAGED_ITEM;

public class ItemRegistry
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static Item.Properties DEFAULT_PROPERTIES()
    {
        return new Item.Properties().tab(OmnisTab.INSTANCE);
    }
    public static Item.Properties GEAR_PROPERTIES()
    {
        return new Item.Properties().tab(OmnisTab.INSTANCE).stacksTo(1);
    }
    public static Item.Properties CREATIVE_PROPERTIES()
    {
        return new Item.Properties().stacksTo(1);
    }

    public static final RegistryObject<Item> INFERNAL_SURGE_BLOCK = ITEMS.register("infernal_surge_block", () -> new BlockItem(BlockRegistry.INFERNAL_SURGE_BLOCK.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> AQUATIC_SURGE_BLOCK = ITEMS.register("aquatic_surge_block", () -> new BlockItem(BlockRegistry.AQUATIC_SURGE_BLOCK.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGED_SCRAP = ITEMS.register("ravaged_scrap", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_METAL = ITEMS.register("ravaged_metal", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_METAL_BLOCK = ITEMS.register("ravaged_metal_block", () -> new BlockItem(BlockRegistry.RAVAGED_METAL_BLOCK.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> TEAR_OF_VEX = ITEMS.register("tear_of_vex", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> VEXWART = ITEMS.register("vexwart", () -> new BlockItem(BlockRegistry.VEXWART.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> VEXWART_BLOCK = ITEMS.register("vexwart_block", () -> new BlockItem(BlockRegistry.VEXWART_BLOCK.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> HAUNTED_STEEL_INGOT = ITEMS.register("haunted_steel_ingot", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_STEEL_BLOCK = ITEMS.register("haunted_steel_block", () -> new BlockItem(BlockRegistry.HAUNTED_STEEL_BLOCK.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGED_BROADSWORD = ITEMS.register("ravaged_broadsword", () -> new ModBroadswordItem(RAVAGED_ITEM, 0, 0, 3.5f, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_HAMMER = ITEMS.register("ravaged_hammer", () -> new ModHammerItem(RAVAGED_ITEM, 0, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_BATTLE_AXE = ITEMS.register("ravaged_battle_axe", () -> new ModGreataxeItem(RAVAGED_ITEM, 0, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_SPEAR = ITEMS.register("ravaged_spear", () -> new ModSpearItem(RAVAGED_ITEM, 0, 0, 1.5f, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_SCYTHE = ITEMS.register("ravaged_scythe", () -> new ModScytheItem(RAVAGED_ITEM, 0, 0, 0.25f, GEAR_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGED_HELMET = ITEMS.register("ravaged_helmet", () -> new RavagedMetalArmorItem(EquipmentSlot.HEAD, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_CHESTPLATE = ITEMS.register("ravaged_chestplate", () -> new RavagedMetalArmorItem(EquipmentSlot.CHEST, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_LEGGINGS = ITEMS.register("ravaged_leggings", () -> new RavagedMetalArmorItem(EquipmentSlot.LEGS, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_BOOTS = ITEMS.register("ravaged_boots", () -> new RavagedMetalArmorItem(EquipmentSlot.FEET, GEAR_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGED_CHARM = ITEMS.register("ravaged_charm", () -> new CurioRavagedCharm(GEAR_PROPERTIES()));

    public static final RegistryObject<Item> VINDICATOR_AXE = ITEMS.register("vindicator_axe", () -> new VindicatorAxeItem(ItemTier.IRON, 2, -0.2f, GEAR_PROPERTIES(), 240));
    public static final RegistryObject<Item> SPELL_BLADE = ITEMS.register("spell_blade", () -> new SpellBladeItem(ItemTier.DIAMOND, -1, 0.1f, GEAR_PROPERTIES(), 0.25f));

    public static final RegistryObject<Item> HAUNTED_BROADSWORD = ITEMS.register("haunted_broadsword", () -> new ModBroadswordItem(HAUNTED_ITEM, 0, 0, 5f, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_HAMMER = ITEMS.register("haunted_hammer", () -> new ModHammerItem(HAUNTED_ITEM, 0, 0, 1, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_BATTLE_AXE = ITEMS.register("haunted_battle_axe", () -> new ModGreataxeItem(HAUNTED_ITEM, 0, 0, 1, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_SPEAR = ITEMS.register("haunted_spear", () -> new ModSpearItem(HAUNTED_ITEM, 0, 0, 2.5f, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_SCYTHE = ITEMS.register("haunted_scythe", () -> new ModScytheItem(HAUNTED_ITEM, 0, 0, 0.5f, GEAR_PROPERTIES()));

    public static final RegistryObject<Item> HAUNTED_HELMET = ITEMS.register("haunted_helmet", () -> new HauntedSteelArmorItem(EquipmentSlot.HEAD, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_CHESTPLATE = ITEMS.register("haunted_chestplate", () -> new HauntedSteelArmorItem(EquipmentSlot.CHEST, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_LEGGINGS = ITEMS.register("haunted_leggings", () -> new HauntedSteelArmorItem(EquipmentSlot.LEGS, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_BOOTS = ITEMS.register("haunted_boots", () -> new HauntedSteelArmorItem(EquipmentSlot.FEET, GEAR_PROPERTIES()));

    public static final RegistryObject<Item> HAUNTED_CHARM = ITEMS.register("haunted_charm", () -> new CurioHauntedCharm(GEAR_PROPERTIES()));

    public static final RegistryObject<Item> HAUNTED_VINDICATOR_AXE = ITEMS.register("haunted_vindicator_axe", () -> new VindicatorAxeItem(HAUNTED_ITEM, 2, -0.2f, GEAR_PROPERTIES(), 120));
    public static final RegistryObject<Item> HAUNTED_SPELL_BLADE = ITEMS.register("haunted_spell_blade", () -> new SpellBladeItem(HAUNTED_ITEM, -1, 0.1f, GEAR_PROPERTIES(), 0.5f));

    public static final RegistryObject<Item> EVOKER_CHARM = ITEMS.register("evoker_charm", () -> new CurioEvokerCharm(GEAR_PROPERTIES()));
    public static final RegistryObject<Item> ANKH_CHARM = ITEMS.register("ankh_charm", () -> new CurioAnkhCharm(GEAR_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGESTONE = ITEMS.register("ravagestone", () -> new BlockItem(BlockRegistry.RAVAGESTONE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_RAVAGESTONE = ITEMS.register("polished_ravagestone", () -> new BlockItem(BlockRegistry.POLISHED_RAVAGESTONE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_BRICKS = ITEMS.register("ravagestone_bricks", () -> new BlockItem(BlockRegistry.RAVAGESTONE_BRICKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_TILES = ITEMS.register("ravagestone_tiles", () -> new BlockItem(BlockRegistry.RAVAGESTONE_TILES.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> CARVED_RAVAGESTONE = ITEMS.register("carved_ravagestone", () -> new BlockItem(BlockRegistry.CARVED_RAVAGESTONE.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGESTONE_SLAB = ITEMS.register("ravagestone_slab", () -> new BlockItem(BlockRegistry.RAVAGESTONE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_RAVAGESTONE_SLAB = ITEMS.register("polished_ravagestone_slab", () -> new BlockItem(BlockRegistry.POLISHED_RAVAGESTONE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_BRICKS_SLAB = ITEMS.register("ravagestone_bricks_slab", () -> new BlockItem(BlockRegistry.RAVAGESTONE_BRICKS_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_TILES_SLAB = ITEMS.register("ravagestone_tiles_slab", () -> new BlockItem(BlockRegistry.RAVAGESTONE_TILES_SLAB.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGESTONE_STAIRS = ITEMS.register("ravagestone_stairs", () -> new BlockItem(BlockRegistry.RAVAGESTONE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_RAVAGESTONE_STAIRS = ITEMS.register("polished_ravagestone_stairs", () -> new BlockItem(BlockRegistry.POLISHED_RAVAGESTONE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_BRICKS_STAIRS = ITEMS.register("ravagestone_bricks_stairs", () -> new BlockItem(BlockRegistry.RAVAGESTONE_BRICKS_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_TILES_STAIRS = ITEMS.register("ravagestone_tiles_stairs", () -> new BlockItem(BlockRegistry.RAVAGESTONE_TILES_STAIRS.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGESTONE_PRESSURE_PLATE = ITEMS.register("ravagestone_pressure_plate", () -> new BlockItem(BlockRegistry.RAVAGESTONE_PRESSURE_PLATE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_WALL = ITEMS.register("ravagestone_wall", () -> new BlockItem(BlockRegistry.RAVAGESTONE_WALL.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_BRICKS_WALL = ITEMS.register("ravagestone_bricks_wall", () -> new BlockItem(BlockRegistry.RAVAGESTONE_BRICKS_WALL.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_TILES_WALL = ITEMS.register("ravagestone_tiles_wall", () -> new BlockItem(BlockRegistry.RAVAGESTONE_TILES_WALL.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> GLOOMSTONE = ITEMS.register("gloomstone", () -> new BlockItem(BlockRegistry.GLOOMSTONE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_GLOOMSTONE = ITEMS.register("polished_gloomstone", () -> new BlockItem(BlockRegistry.POLISHED_GLOOMSTONE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_BRICKS = ITEMS.register("gloomstone_bricks", () -> new BlockItem(BlockRegistry.GLOOMSTONE_BRICKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_TILES = ITEMS.register("gloomstone_tiles", () -> new BlockItem(BlockRegistry.GLOOMSTONE_TILES.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> CARVED_GLOOMSTONE = ITEMS.register("carved_gloomstone", () -> new BlockItem(BlockRegistry.CARVED_GLOOMSTONE.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> GLOOMSTONE_SLAB = ITEMS.register("gloomstone_slab", () -> new BlockItem(BlockRegistry.GLOOMSTONE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_GLOOMSTONE_SLAB = ITEMS.register("polished_gloomstone_slab", () -> new BlockItem(BlockRegistry.POLISHED_GLOOMSTONE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_BRICKS_SLAB = ITEMS.register("gloomstone_bricks_slab", () -> new BlockItem(BlockRegistry.GLOOMSTONE_BRICKS_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_TILES_SLAB = ITEMS.register("gloomstone_tiles_slab", () -> new BlockItem(BlockRegistry.GLOOMSTONE_TILES_SLAB.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> GLOOMSTONE_STAIRS = ITEMS.register("gloomstone_stairs", () -> new BlockItem(BlockRegistry.GLOOMSTONE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_GLOOMSTONE_STAIRS = ITEMS.register("polished_gloomstone_stairs", () -> new BlockItem(BlockRegistry.POLISHED_GLOOMSTONE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_BRICKS_STAIRS = ITEMS.register("gloomstone_bricks_stairs", () -> new BlockItem(BlockRegistry.GLOOMSTONE_BRICKS_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_TILES_STAIRS = ITEMS.register("gloomstone_tiles_stairs", () -> new BlockItem(BlockRegistry.GLOOMSTONE_TILES_STAIRS.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> GLOOMSTONE_PRESSURE_PLATE = ITEMS.register("gloomstone_pressure_plate", () -> new BlockItem(BlockRegistry.GLOOMSTONE_PRESSURE_PLATE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_WALL = ITEMS.register("gloomstone_wall", () -> new BlockItem(BlockRegistry.GLOOMSTONE_WALL.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_BRICKS_WALL = ITEMS.register("gloomstone_bricks_wall", () -> new BlockItem(BlockRegistry.GLOOMSTONE_BRICKS_WALL.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_TILES_WALL = ITEMS.register("gloomstone_tiles_wall", () -> new BlockItem(BlockRegistry.GLOOMSTONE_TILES_WALL.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> FLUFFY_TAIL = ITEMS.register("fluffy_tail", () -> new CurioFluffyTail(CREATIVE_PROPERTIES()));

}
