package com.sammy.omnis.core.init;

import com.sammy.omnis.common.items.*;
import com.sammy.omnis.common.items.loot.CurioEvokerCharm;
import com.sammy.omnis.common.items.loot.SpellBladeItem;
import com.sammy.omnis.common.items.loot.VindicatorAxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.omnis.OmnisMod.MODID;
import static com.sammy.omnis.common.items.OmnisItemTiers.ItemTierEnum.HAUNTED_ITEM;
import static com.sammy.omnis.common.items.OmnisItemTiers.ItemTierEnum.RAVAGED_ITEM;

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
    public static final RegistryObject<Item> RAVAGED_SCRAP = ITEMS.register("ravaged_scrap", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_METAL = ITEMS.register("ravaged_metal", () -> new Item(DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> TEAR_OF_VEX = ITEMS.register("tear_of_vex", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> VEXWART = ITEMS.register("vexwart", () -> new BlockItem(OmnisBlocks.VEXWART.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> VEXWART_BLOCK = ITEMS.register("vexwart_block", () -> new BlockItem(OmnisBlocks.VEXWART_BLOCK.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_STEEL_INGOT = ITEMS.register("haunted_steel_ingot", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_STEEL_BLOCK = ITEMS.register("haunted_steel_block", () -> new BlockItem(OmnisBlocks.HAUNTED_STEEL_BLOCK.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGED_BROADSWORD = ITEMS.register("ravaged_broadsword", () -> new ModSwordItem(RAVAGED_ITEM, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_HAMMER = ITEMS.register("ravaged_hammer", () -> new ModPickaxeItem(RAVAGED_ITEM, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_BATTLE_AXE = ITEMS.register("ravaged_battle_axe", () -> new ModAxeItem(RAVAGED_ITEM, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_SPEAR = ITEMS.register("ravaged_spear", () -> new ModShovelItem(RAVAGED_ITEM, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGED_SCYTHE = ITEMS.register("ravaged_scythe", () -> new ModHoeItem(RAVAGED_ITEM, 0, 0, GEAR_PROPERTIES()));

    public static final RegistryObject<Item> VINDICATOR_AXE = ITEMS.register("vindicator_axe", () -> new VindicatorAxeItem(ItemTier.IRON, 2, -0.2f, GEAR_PROPERTIES(), 80));
    public static final RegistryObject<Item> SPELL_BLADE = ITEMS.register("spell_blade", () -> new SpellBladeItem(ItemTier.DIAMOND, -1, 0.1f, GEAR_PROPERTIES(), 0.25f));

    public static final RegistryObject<Item> HAUNTED_BROADSWORD = ITEMS.register("haunted_broadsword", () -> new ModSwordItem(HAUNTED_ITEM, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_HAMMER = ITEMS.register("haunted_hammer", () -> new ModPickaxeItem(HAUNTED_ITEM, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_BATTLE_AXE = ITEMS.register("haunted_battle_axe", () -> new ModAxeItem(HAUNTED_ITEM, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_SPEAR = ITEMS.register("haunted_spear", () -> new ModShovelItem(HAUNTED_ITEM, 0, 0, GEAR_PROPERTIES()));
    public static final RegistryObject<Item> HAUNTED_SCYTHE = ITEMS.register("haunted_scythe", () -> new ModHoeItem(HAUNTED_ITEM, 0, 0, GEAR_PROPERTIES()));

    public static final RegistryObject<Item> HAUNTED_VINDICATOR_AXE = ITEMS.register("haunted_vindicator_axe", () -> new VindicatorAxeItem(HAUNTED_ITEM, 2, -0.2f, GEAR_PROPERTIES(), 40));
    public static final RegistryObject<Item> HAUNTED_SPELL_BLADE = ITEMS.register("haunted_spell_blade", () -> new SpellBladeItem(HAUNTED_ITEM, -2, 0.1f, GEAR_PROPERTIES(), 0.5f));

    public static final RegistryObject<Item> EVOKER_CHARM = ITEMS.register("evoker_charm", () -> new CurioEvokerCharm(GEAR_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGESTONE = ITEMS.register("ravagestone", () -> new BlockItem(OmnisBlocks.RAVAGESTONE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_RAVAGESTONE = ITEMS.register("polished_ravagestone", () -> new BlockItem(OmnisBlocks.POLISHED_RAVAGESTONE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_BRICKS = ITEMS.register("ravagestone_bricks", () -> new BlockItem(OmnisBlocks.RAVAGESTONE_BRICKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_TILES = ITEMS.register("ravagestone_tiles", () -> new BlockItem(OmnisBlocks.RAVAGESTONE_TILES.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> CARVED_RAVAGESTONE = ITEMS.register("carved_ravagestone", () -> new BlockItem(OmnisBlocks.CARVED_RAVAGESTONE.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGESTONE_SLAB = ITEMS.register("ravagestone_slab", () -> new BlockItem(OmnisBlocks.RAVAGESTONE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_RAVAGESTONE_SLAB = ITEMS.register("polished_ravagestone_slab", () -> new BlockItem(OmnisBlocks.POLISHED_RAVAGESTONE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_BRICKS_SLAB = ITEMS.register("ravagestone_bricks_slab", () -> new BlockItem(OmnisBlocks.RAVAGESTONE_BRICKS_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_TILES_SLAB = ITEMS.register("ravagestone_tiles_slab", () -> new BlockItem(OmnisBlocks.RAVAGESTONE_TILES_SLAB.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> RAVAGESTONE_STAIRS = ITEMS.register("ravagestone_stairs", () -> new BlockItem(OmnisBlocks.RAVAGESTONE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_RAVAGESTONE_STAIRS = ITEMS.register("polished_ravagestone_stairs", () -> new BlockItem(OmnisBlocks.POLISHED_RAVAGESTONE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_BRICKS_STAIRS = ITEMS.register("ravagestone_bricks_stairs", () -> new BlockItem(OmnisBlocks.RAVAGESTONE_BRICKS_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RAVAGESTONE_TILES_STAIRS = ITEMS.register("ravagestone_tiles_stairs", () -> new BlockItem(OmnisBlocks.RAVAGESTONE_TILES_STAIRS.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> GLOOMSTONE = ITEMS.register("gloomstone", () -> new BlockItem(OmnisBlocks.GLOOMSTONE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_GLOOMSTONE = ITEMS.register("polished_gloomstone", () -> new BlockItem(OmnisBlocks.POLISHED_GLOOMSTONE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_BRICKS = ITEMS.register("gloomstone_bricks", () -> new BlockItem(OmnisBlocks.GLOOMSTONE_BRICKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_TILES = ITEMS.register("gloomstone_tiles", () -> new BlockItem(OmnisBlocks.GLOOMSTONE_TILES.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> CARVED_GLOOMSTONE = ITEMS.register("carved_gloomstone", () -> new BlockItem(OmnisBlocks.CARVED_GLOOMSTONE.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> GLOOMSTONE_SLAB = ITEMS.register("gloomstone_slab", () -> new BlockItem(OmnisBlocks.GLOOMSTONE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_GLOOMSTONE_SLAB = ITEMS.register("polished_gloomstone_slab", () -> new BlockItem(OmnisBlocks.POLISHED_GLOOMSTONE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_BRICKS_SLAB = ITEMS.register("gloomstone_bricks_slab", () -> new BlockItem(OmnisBlocks.GLOOMSTONE_BRICKS_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_TILES_SLAB = ITEMS.register("gloomstone_tiles_slab", () -> new BlockItem(OmnisBlocks.GLOOMSTONE_TILES_SLAB.get(), DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> GLOOMSTONE_STAIRS = ITEMS.register("gloomstone_stairs", () -> new BlockItem(OmnisBlocks.GLOOMSTONE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> POLISHED_GLOOMSTONE_STAIRS = ITEMS.register("polished_gloomstone_stairs", () -> new BlockItem(OmnisBlocks.POLISHED_GLOOMSTONE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_BRICKS_STAIRS = ITEMS.register("gloomstone_bricks_stairs", () -> new BlockItem(OmnisBlocks.GLOOMSTONE_BRICKS_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GLOOMSTONE_TILES_STAIRS = ITEMS.register("gloomstone_tiles_stairs", () -> new BlockItem(OmnisBlocks.GLOOMSTONE_TILES_STAIRS.get(), DEFAULT_PROPERTIES()));

}
