package com.sammy.omnis.core.data;

import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.advancements.criterion.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.world.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static net.minecraft.data.ShapedRecipeBuilder.shapedRecipe;
import static net.minecraft.data.ShapelessRecipeBuilder.shapelessRecipe;

public class ModRecipeProvider extends RecipeProvider
{
    public ModRecipeProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }
    
    @Override
    public String getName()
    {
        return "Recipe Provider";
    }
    
    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(ItemRegistry.VEXWART_BLOCK.get()).define('#', ItemRegistry.VEXWART.get()).pattern("###").pattern("###").pattern("###").group("vexwart").unlockedBy("has_tear_of_vex", hasItem(ItemRegistry.TEAR_OF_VEX.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.VEXWART.get(), 9).requires(ItemRegistry.VEXWART_BLOCK.get()).group("vexwart").unlockedBy("has_tear_of_vex", hasItem(ItemRegistry.TEAR_OF_VEX.get())).save(consumer, "vexwart_alt");
        ShapelessRecipeBuilder.shapeless(ItemRegistry.VEXWART.get(), 2).requires(ItemRegistry.TEAR_OF_VEX.get()).requires(Items.NETHER_WART, 2).group("vexwart").unlockedBy("has_tear_of_vex", hasItem(ItemRegistry.TEAR_OF_VEX.get())).save(consumer);

        smithingReinforce(consumer, ItemRegistry.SPELL_BLADE.get(), ItemRegistry.HAUNTED_SPELL_BLADE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.VINDICATOR_AXE.get(), ItemRegistry.HAUNTED_VINDICATOR_AXE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.RAVAGED_CHARM.get(), ItemRegistry.HAUNTED_CHARM.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_METAL_BLOCK.get()).define('#', ItemRegistry.RAVAGED_METAL.get()).pattern("###").pattern("###").pattern("###").group("ravaged_metal").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.RAVAGED_METAL.get(), 9).requires(ItemRegistry.RAVAGED_METAL_BLOCK.get()).group("ravaged_metal").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer, "ravaged_metal_alt");
        ShapelessRecipeBuilder.shapeless(ItemRegistry.RAVAGED_METAL.get()).requires(ItemRegistry.RAVAGED_SCRAP.get(), 4).requires(Tags.Items.INGOTS_IRON).group("ravaged_metal").unlockedBy("has_ravaged_scrap", hasItem(ItemRegistry.RAVAGED_SCRAP.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_BATTLE_AXE.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X X").pattern("X#X").pattern(" # ").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_SCYTHE.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("XX ").pattern(" #X").pattern("#  ").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_HAMMER.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("XXX").pattern("X# ").pattern(" # ").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_SPEAR.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X").pattern("#").pattern("#").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_BROADSWORD.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X").pattern("X").pattern("#").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_HELMET.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("XXX").pattern("X X").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_CHESTPLATE.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X X").pattern("XXX").pattern("XXX").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_LEGGINGS.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("XXX").pattern("X X").pattern("X X").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_BOOTS.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X X").pattern("X X").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGED_CHARM.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).define('Y', Tags.Items.LEATHER).pattern(" Y ").pattern("Y Y").pattern(" X ").unlockedBy("has_ravaged_metal", hasItem(ItemRegistry.RAVAGED_METAL.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.HAUNTED_STEEL_BLOCK.get()).define('#', ItemRegistry.HAUNTED_STEEL_INGOT.get()).pattern("###").pattern("###").pattern("###").group("haunted_steel").unlockedBy("has_haunted_steel", hasItem(ItemRegistry.HAUNTED_STEEL_INGOT.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.HAUNTED_STEEL_INGOT.get(), 9).requires(ItemRegistry.HAUNTED_STEEL_BLOCK.get()).group("haunted_steel").unlockedBy("has_haunted_steel", hasItem(ItemRegistry.HAUNTED_STEEL_INGOT.get())).save(consumer, "haunted_ingot_alt");
        ShapelessRecipeBuilder.shapeless(ItemRegistry.HAUNTED_STEEL_INGOT.get()).requires(Items.NETHERITE_SCRAP, 1).requires(ItemRegistry.TEAR_OF_VEX.get(), 4).requires(Items.GOLD_INGOT, 4).group("haunted_steel").unlockedBy("has_haunted_steel", hasItem(ItemRegistry.HAUNTED_STEEL_INGOT.get())).save(consumer);

        smithingReinforce(consumer, ItemRegistry.RAVAGED_BATTLE_AXE.get(), ItemRegistry.HAUNTED_BATTLE_AXE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.RAVAGED_HAMMER.get(), ItemRegistry.HAUNTED_HAMMER.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.RAVAGED_SPEAR.get(), ItemRegistry.HAUNTED_SPEAR.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.RAVAGED_SCYTHE.get(), ItemRegistry.HAUNTED_SCYTHE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.RAVAGED_BROADSWORD.get(), ItemRegistry.HAUNTED_BROADSWORD.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

        smithingReinforce(consumer, ItemRegistry.RAVAGED_HELMET.get(), ItemRegistry.HAUNTED_HELMET.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.RAVAGED_CHESTPLATE.get(), ItemRegistry.HAUNTED_CHESTPLATE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.RAVAGED_LEGGINGS.get(), ItemRegistry.HAUNTED_LEGGINGS.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, ItemRegistry.RAVAGED_BOOTS.get(), ItemRegistry.HAUNTED_BOOTS.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

        ShapedRecipeBuilder.shaped(ItemRegistry.GLOOMSTONE.get(), 8).define('X', ItemRegistry.TEAR_OF_VEX.get()).define('Y', Tags.Items.STONE).pattern("YYY").pattern("YXY").pattern("YYY").unlockedBy("has_tear_of_vex", hasItem(ItemRegistry.TEAR_OF_VEX.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.GLOOMSTONE_WALL.get(), 6).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("###").pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_SLAB.get(), 6).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_STAIRS.get(), 4).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_SLAB.get(), 2).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_STAIRS.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_WALL.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_wall_stonecutting");

        shaped(ItemRegistry.POLISHED_GLOOMSTONE.get(),9).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.POLISHED_GLOOMSTONE_SLAB.get(), 6).define('#', ItemRegistry.POLISHED_GLOOMSTONE.get()).pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.POLISHED_GLOOMSTONE_STAIRS.get(), 4).define('#', ItemRegistry.POLISHED_GLOOMSTONE.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.POLISHED_GLOOMSTONE.get()), ItemRegistry.POLISHED_GLOOMSTONE_SLAB.get(), 2).unlocks("has_polished_gloomstone", hasItem(ItemRegistry.POLISHED_GLOOMSTONE.get())).save(consumer, "polished_gloomstone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.POLISHED_GLOOMSTONE.get()), ItemRegistry.POLISHED_GLOOMSTONE_STAIRS.get()).unlocks("has_polished_gloomstone", hasItem(ItemRegistry.POLISHED_GLOOMSTONE.get())).save(consumer, "polished_gloomstone_stairs_stonecutting");

        shaped(ItemRegistry.GLOOMSTONE_BRICKS.get(),4).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("##").pattern("##").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_BRICKS_SLAB.get(), 6).define('#', ItemRegistry.GLOOMSTONE_BRICKS.get()).pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_BRICKS_STAIRS.get(), 4).define('#', ItemRegistry.GLOOMSTONE_BRICKS.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GLOOMSTONE_BRICKS_WALL.get(), 6).define('#', ItemRegistry.GLOOMSTONE_BRICKS.get()).pattern("###").pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.GLOOMSTONE_BRICKS_SLAB.get(), 2).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_bricks_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.GLOOMSTONE_BRICKS_STAIRS.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_bricks_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.GLOOMSTONE_BRICKS_WALL.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_brick_wall_stonecutting");

        shaped(ItemRegistry.GLOOMSTONE_TILES.get(),4).define('#', ItemRegistry.GLOOMSTONE_BRICKS.get()).pattern("##").pattern("##").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_TILES_SLAB.get(), 6).define('#', ItemRegistry.GLOOMSTONE_TILES.get()).pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_TILES_STAIRS.get(), 4).define('#', ItemRegistry.GLOOMSTONE_TILES.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GLOOMSTONE_TILES_WALL.get(), 6).define('#', ItemRegistry.GLOOMSTONE_TILES.get()).pattern("###").pattern("###").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_TILES.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.GLOOMSTONE_TILES.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_stonecutting_alt");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_TILES.get()), ItemRegistry.GLOOMSTONE_TILES_SLAB.get(), 2).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_TILES.get()), ItemRegistry.GLOOMSTONE_TILES_STAIRS.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_TILES.get()), ItemRegistry.GLOOMSTONE_TILES_WALL.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_wall_stonecutting");

        shapedPressurePlate(consumer, ItemRegistry.GLOOMSTONE_PRESSURE_PLATE.get(), ItemRegistry.GLOOMSTONE.get());
        shaped(ItemRegistry.CARVED_GLOOMSTONE.get()).define('#', ItemRegistry.GLOOMSTONE_SLAB.get()).pattern("#").pattern("#").unlockedBy("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_BRICKS.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.POLISHED_GLOOMSTONE.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "polished_gloomstone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.CARVED_GLOOMSTONE.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "carved_gloomstone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.CARVED_GLOOMSTONE.get()).unlocks("has_gloomstone", hasItem(ItemRegistry.GLOOMSTONE.get())).save(consumer, "carved_gloomstone_bricks_stonecutting_alt");

        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGESTONE.get(), 8).define('X', ItemRegistry.RAVAGED_SCRAP.get()).define('Y', Tags.Items.STONE).pattern("YYY").pattern("YXY").pattern("YYY").unlockedBy("has_ravaged_scrap", hasItem(ItemRegistry.RAVAGED_SCRAP.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGESTONE_WALL.get(), 6).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("###").pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_SLAB.get(), 6).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_STAIRS.get(), 4).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_SLAB.get(), 2).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_STAIRS.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_WALL.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_wall_stonecutting");

        shaped(ItemRegistry.POLISHED_RAVAGESTONE.get(),9).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.POLISHED_RAVAGESTONE_SLAB.get(), 6).define('#', ItemRegistry.POLISHED_RAVAGESTONE.get()).pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.POLISHED_RAVAGESTONE_STAIRS.get(), 4).define('#', ItemRegistry.POLISHED_RAVAGESTONE.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.POLISHED_RAVAGESTONE.get()), ItemRegistry.POLISHED_RAVAGESTONE_SLAB.get(), 2).unlocks("has_polished_ravagestone", hasItem(ItemRegistry.POLISHED_RAVAGESTONE.get())).save(consumer, "polished_ravagestone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.POLISHED_RAVAGESTONE.get()), ItemRegistry.POLISHED_RAVAGESTONE_STAIRS.get()).unlocks("has_polished_ravagestone", hasItem(ItemRegistry.POLISHED_RAVAGESTONE.get())).save(consumer, "polished_ravagestone_stairs_stonecutting");

        shaped(ItemRegistry.RAVAGESTONE_BRICKS.get(),4).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("##").pattern("##").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_BRICKS_SLAB.get(), 6).define('#', ItemRegistry.RAVAGESTONE_BRICKS.get()).pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_BRICKS_STAIRS.get(), 4).define('#', ItemRegistry.RAVAGESTONE_BRICKS.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGESTONE_BRICKS_WALL.get(), 6).define('#', ItemRegistry.RAVAGESTONE_BRICKS.get()).pattern("###").pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.RAVAGESTONE_BRICKS_SLAB.get(), 2).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_bricks_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.RAVAGESTONE_BRICKS_STAIRS.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_bricks_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.RAVAGESTONE_BRICKS_WALL.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_brick_wall_stonecutting");

        shaped(ItemRegistry.RAVAGESTONE_TILES.get(),4).define('#', ItemRegistry.RAVAGESTONE_BRICKS.get()).pattern("##").pattern("##").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_TILES_SLAB.get(), 6).define('#', ItemRegistry.RAVAGESTONE_TILES.get()).pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_TILES_STAIRS.get(), 4).define('#', ItemRegistry.RAVAGESTONE_TILES.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RAVAGESTONE_TILES_WALL.get(), 6).define('#', ItemRegistry.RAVAGESTONE_TILES.get()).pattern("###").pattern("###").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_TILES.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.RAVAGESTONE_TILES.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_stonecutting_alt");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_TILES.get()), ItemRegistry.RAVAGESTONE_TILES_SLAB.get(), 2).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_TILES.get()), ItemRegistry.RAVAGESTONE_TILES_STAIRS.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_TILES.get()), ItemRegistry.RAVAGESTONE_TILES_WALL.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_wall_stonecutting");

        shapedPressurePlate(consumer, ItemRegistry.RAVAGESTONE_PRESSURE_PLATE.get(), ItemRegistry.RAVAGESTONE.get());
        shaped(ItemRegistry.CARVED_RAVAGESTONE.get()).define('#', ItemRegistry.RAVAGESTONE_SLAB.get()).pattern("#").pattern("#").unlockedBy("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_BRICKS.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.POLISHED_RAVAGESTONE.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "polished_ravagestone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.CARVED_RAVAGESTONE.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "carved_ravagestone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.CARVED_RAVAGESTONE.get()).unlocks("has_ravagestone", hasItem(ItemRegistry.RAVAGESTONE.get())).save(consumer, "carved_ravagestone_bricks_stonecutting_alt");
    }
    private static void smithingReinforce(Consumer<IFinishedRecipe> recipeConsumer, Item itemToReinforce, Item output, Item reinforcement)
    {
        SmithingRecipeBuilder.smithing(Ingredient.of(itemToReinforce), Ingredient.of(reinforcement), output).unlocks("has_" + Registry.ITEM.getKey(reinforcement).getPath(), hasItem(reinforcement)).save(recipeConsumer, Registry.ITEM.getKey(output).getPath() + "_smithing");
    }
    private static void shapelessPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider planks, ITag<Item> input)
    {
        shapeless(planks, 4).requires(input).group("planks").unlockedBy("has_logs", hasItem(input)).save(recipeConsumer);
    }
    private static void shapelessWood(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider stripped, IItemProvider input)
    {
        shaped(stripped, 3).define('#', input).pattern("##").pattern("##").group("bark").unlockedBy("has_log", hasItem(input)).save(recipeConsumer);
    }
    private static void shapelessButton(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider button, IItemProvider input)
    {
        shapeless(button).requires(input).unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapedDoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider door, IItemProvider input)
    {
        shaped(door, 3).define('#', input).pattern("##").pattern("##").pattern("##").unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapedFence(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fence, IItemProvider input)
    {
        shaped(fence, 3).define('#', Items.STICK).define('W', input).pattern("W#W").pattern("W#W").unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapedFenceGate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fenceGate, IItemProvider input)
    {
        shaped(fenceGate).define('#', Items.STICK).define('W', input).pattern("#W#").pattern("#W#").unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapedPressurePlate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider pressurePlate, IItemProvider input)
    {
        shaped(pressurePlate).define('#', input).pattern("##").unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapedSlab(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider slab, IItemProvider input)
    {
        shaped(slab, 6).define('#', input).pattern("###").unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapedStairs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider stairs, IItemProvider input)
    {
        shaped(stairs, 4).define('#', input).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapelessSolidTrapdoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider button, IItemProvider input)
    {
        shapeless(button).requires(input).unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapedTrapdoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider trapdoor, IItemProvider input)
    {
        shaped(trapdoor, 2).define('#', input).pattern("###").pattern("###").unlockedBy("has_input", hasItem(input)).save(recipeConsumer);
    }
    private static void shapedSign(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sign, IItemProvider input)
    {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        shaped(sign, 3).group("sign").define('#', input).define('X', Items.STICK).pattern("###").pattern("###").pattern(" X ").unlockedBy("has_" + s, hasItem(input)).save(recipeConsumer);
    }
    private static void shapelessColoredWool(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredWool, IItemProvider dye)
    {
        shapeless(coloredWool).requires(dye).requires(Blocks.WHITE_WOOL).group("wool").unlockedBy("has_white_wool", hasItem(Blocks.WHITE_WOOL)).save(recipeConsumer);
    }
    private static void shapedCarpet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider carpet, IItemProvider input)
    {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        shaped(carpet, 3).define('#', input).pattern("##").group("carpet").unlockedBy("has_" + s, hasItem(input)).save(recipeConsumer);
    }
    private static void shapelessColoredCarpet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredCarpet, IItemProvider dye)
    {
        String s = Registry.ITEM.getKey(coloredCarpet.asItem()).getPath();
        String s1 = Registry.ITEM.getKey(dye.asItem()).getPath();
        shaped(coloredCarpet, 8).define('#', Blocks.WHITE_CARPET).define('$', dye).pattern("###").pattern("#$#").pattern("###").group("carpet").unlockedBy("has_white_carpet", hasItem(Blocks.WHITE_CARPET)).unlockedBy("has_" + s1, hasItem(dye)).save(recipeConsumer, s + "_from_white_carpet");
    }
    private static void shapedBed(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider bed, IItemProvider wool)
    {
        String s = Registry.ITEM.getKey(wool.asItem()).getPath();
        shaped(bed).define('#', wool).define('X', ItemTags.PLANKS).pattern("###").pattern("XXX").group("bed").unlockedBy("has_" + s, hasItem(wool)).save(recipeConsumer);
    }
    private static void shapedColoredBed(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredBed, IItemProvider dye)
    {
        String s = Registry.ITEM.getKey(coloredBed.asItem()).getPath();
        shapeless(coloredBed).requires(Items.WHITE_BED).requires(dye).group("dyed_bed").unlockedBy("has_bed", hasItem(Items.WHITE_BED)).save(recipeConsumer, s + "_from_white_bed");
    }
    private static void shapedBanner(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider banner, IItemProvider input)
    {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        shaped(banner).define('#', input).define('|', Items.STICK).pattern("###").pattern("###").pattern(" | ").group("banner").unlockedBy("has_" + s, hasItem(input)).save(recipeConsumer);
    }
    private static void shapedColoredGlass(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredGlass, IItemProvider dye)
    {
        shaped(coloredGlass, 8).define('#', Blocks.GLASS).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_glass").unlockedBy("has_glass", hasItem(Blocks.GLASS)).save(recipeConsumer);
    }
    private static void shapedGlassPane(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider pane, IItemProvider glass)
    {
        shaped(pane, 16).define('#', glass).pattern("###").pattern("###").group("stained_glass_pane").unlockedBy("has_glass", hasItem(glass)).save(recipeConsumer);
    }
    private static void shapedColoredPane(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredPane, IItemProvider dye)
    {
        String s = Registry.ITEM.getKey(coloredPane.asItem()).getPath();
        String s1 = Registry.ITEM.getKey(dye.asItem()).getPath();
        shaped(coloredPane, 8).define('#', Blocks.GLASS_PANE).define('$', dye).pattern("###").pattern("#$#").pattern("###").group("stained_glass_pane").unlockedBy("has_glass_pane", hasItem(Blocks.GLASS_PANE)).unlockedBy("has_" + s1, hasItem(dye)).save(recipeConsumer, s + "_from_glass_pane");
    }
    private static void shapedColoredTerracotta(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredTerracotta, IItemProvider dye)
    {
        shaped(coloredTerracotta, 8).define('#', Blocks.TERRACOTTA).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_terracotta").unlockedBy("has_terracotta", hasItem(Blocks.TERRACOTTA)).save(recipeConsumer);
    }
    private static void shapedColorConcretePowder(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredConcretePowder, IItemProvider dye)
    {
        shapeless(coloredConcretePowder, 8).requires(dye).requires(Blocks.SAND, 4).requires(Blocks.GRAVEL, 4).group("concrete_powder").unlockedBy("has_sand", hasItem(Blocks.SAND)).unlockedBy("has_gravel", hasItem(Blocks.GRAVEL)).save(recipeConsumer);
    }
    protected static EnterBlockTrigger.Instance enteredBlock(Block block)
    {
        return new EnterBlockTrigger.Instance(EntityPredicate.AndPredicate.ANY, block, StatePropertiesPredicate.ANY);
    }
    protected static InventoryChangeTrigger.Instance hasItem(IItemProvider item)
    {
        return hasItem(ItemPredicate.Builder.item().of(item).build());
    }
    protected static InventoryChangeTrigger.Instance hasItem(ITag<Item> tag)
    {
        return hasItem(ItemPredicate.Builder.item().of(tag).build());
    }
    protected static InventoryChangeTrigger.Instance hasItem(ItemPredicate... predicate)
    {
        return new InventoryChangeTrigger.Instance(EntityPredicate.AndPredicate.ANY, MinMaxBounds.IntBound.ANY, MinMaxBounds.IntBound.ANY, MinMaxBounds.IntBound.ANY, predicate);
    }
}