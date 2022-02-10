package com.sammy.omnis.core.data;

import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.*;
import net.minecraft.world.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static net.minecraft.data.recipes.ShapedRecipeBuilder.shaped;
import static net.minecraft.data.recipes.ShapelessRecipeBuilder.shapeless;

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
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        shaped(ItemRegistry.VEXWART_BLOCK.get()).define('#', ItemRegistry.VEXWART.get()).pattern("###").pattern("###").pattern("###").group("vexwart").unlockedBy("has_tear_of_vex", has(ItemRegistry.TEAR_OF_VEX.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.VEXWART.get(), 9).requires(ItemRegistry.VEXWART_BLOCK.get()).group("vexwart").unlockedBy("has_tear_of_vex", has(ItemRegistry.TEAR_OF_VEX.get())).save(consumer, "vexwart_alt");
        ShapelessRecipeBuilder.shapeless(ItemRegistry.VEXWART.get(), 2).requires(ItemRegistry.TEAR_OF_VEX.get()).requires(Items.NETHER_WART, 2).group("vexwart").unlockedBy("has_tear_of_vex", has(ItemRegistry.TEAR_OF_VEX.get())).save(consumer);

        netheriteSmithing(consumer, ItemRegistry.SPELL_BLADE.get(), ItemRegistry.HAUNTED_SPELL_BLADE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.VINDICATOR_AXE.get(), ItemRegistry.HAUNTED_VINDICATOR_AXE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.RAVAGED_CHARM.get(), ItemRegistry.HAUNTED_CHARM.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

        shaped(ItemRegistry.RAVAGED_METAL_BLOCK.get()).define('#', ItemRegistry.RAVAGED_METAL.get()).pattern("###").pattern("###").pattern("###").group("ravaged_metal").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.RAVAGED_METAL.get(), 9).requires(ItemRegistry.RAVAGED_METAL_BLOCK.get()).group("ravaged_metal").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer, "ravaged_metal_alt");
        ShapelessRecipeBuilder.shapeless(ItemRegistry.RAVAGED_METAL.get()).requires(ItemRegistry.RAVAGED_SCRAP.get(), 4).requires(Tags.Items.INGOTS_IRON).group("ravaged_metal").unlockedBy("has_ravaged_scrap", has(ItemRegistry.RAVAGED_SCRAP.get())).save(consumer);

        shaped(ItemRegistry.RAVAGED_BATTLE_AXE.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X X").pattern("X#X").pattern(" # ").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        shaped(ItemRegistry.RAVAGED_SCYTHE.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("XX ").pattern(" #X").pattern("#  ").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        shaped(ItemRegistry.RAVAGED_HAMMER.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("XXX").pattern("X# ").pattern(" # ").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        shaped(ItemRegistry.RAVAGED_SPEAR.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X").pattern("#").pattern("#").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        shaped(ItemRegistry.RAVAGED_BROADSWORD.get()).define('#', Items.STICK).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X").pattern("X").pattern("#").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);

        shaped(ItemRegistry.RAVAGED_HELMET.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("XXX").pattern("X X").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        shaped(ItemRegistry.RAVAGED_CHESTPLATE.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X X").pattern("XXX").pattern("XXX").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        shaped(ItemRegistry.RAVAGED_LEGGINGS.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("XXX").pattern("X X").pattern("X X").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);
        shaped(ItemRegistry.RAVAGED_BOOTS.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).pattern("X X").pattern("X X").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);

        shaped(ItemRegistry.RAVAGED_CHARM.get()).define('X', ItemRegistry.RAVAGED_METAL.get()).define('Y', Tags.Items.LEATHER).pattern(" Y ").pattern("Y Y").pattern(" X ").unlockedBy("has_ravaged_metal", has(ItemRegistry.RAVAGED_METAL.get())).save(consumer);

        shaped(ItemRegistry.HAUNTED_STEEL_BLOCK.get()).define('#', ItemRegistry.HAUNTED_STEEL_INGOT.get()).pattern("###").pattern("###").pattern("###").group("haunted_steel").unlockedBy("has_haunted_steel", has(ItemRegistry.HAUNTED_STEEL_INGOT.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.HAUNTED_STEEL_INGOT.get(), 9).requires(ItemRegistry.HAUNTED_STEEL_BLOCK.get()).group("haunted_steel").unlockedBy("has_haunted_steel", has(ItemRegistry.HAUNTED_STEEL_INGOT.get())).save(consumer, "haunted_ingot_alt");
        ShapelessRecipeBuilder.shapeless(ItemRegistry.HAUNTED_STEEL_INGOT.get()).requires(Items.NETHERITE_SCRAP, 1).requires(ItemRegistry.TEAR_OF_VEX.get(), 4).requires(Items.GOLD_INGOT, 4).group("haunted_steel").unlockedBy("has_haunted_steel", has(ItemRegistry.HAUNTED_STEEL_INGOT.get())).save(consumer);

        netheriteSmithing(consumer, ItemRegistry.RAVAGED_BATTLE_AXE.get(), ItemRegistry.HAUNTED_BATTLE_AXE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.RAVAGED_HAMMER.get(), ItemRegistry.HAUNTED_HAMMER.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.RAVAGED_SPEAR.get(), ItemRegistry.HAUNTED_SPEAR.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.RAVAGED_SCYTHE.get(), ItemRegistry.HAUNTED_SCYTHE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.RAVAGED_BROADSWORD.get(), ItemRegistry.HAUNTED_BROADSWORD.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

        netheriteSmithing(consumer, ItemRegistry.RAVAGED_HELMET.get(), ItemRegistry.HAUNTED_HELMET.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.RAVAGED_CHESTPLATE.get(), ItemRegistry.HAUNTED_CHESTPLATE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.RAVAGED_LEGGINGS.get(), ItemRegistry.HAUNTED_LEGGINGS.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        netheriteSmithing(consumer, ItemRegistry.RAVAGED_BOOTS.get(), ItemRegistry.HAUNTED_BOOTS.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

        shaped(ItemRegistry.GLOOMSTONE.get(), 8).define('X', ItemRegistry.TEAR_OF_VEX.get()).define('Y', Tags.Items.STONE).pattern("YYY").pattern("YXY").pattern("YYY").unlockedBy("has_tear_of_vex", has(ItemRegistry.TEAR_OF_VEX.get())).save(consumer);

        shaped(ItemRegistry.GLOOMSTONE_WALL.get(), 6).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("###").pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_SLAB.get(), 6).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_STAIRS.get(), 4).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_SLAB.get(), 2).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_STAIRS.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_WALL.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_wall_stonecutting");

        shaped(ItemRegistry.POLISHED_GLOOMSTONE.get(),9).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.POLISHED_GLOOMSTONE_SLAB.get(), 6).define('#', ItemRegistry.POLISHED_GLOOMSTONE.get()).pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.POLISHED_GLOOMSTONE_STAIRS.get(), 4).define('#', ItemRegistry.POLISHED_GLOOMSTONE.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.POLISHED_GLOOMSTONE.get()), ItemRegistry.POLISHED_GLOOMSTONE_SLAB.get(), 2).unlockedBy("has_polished_gloomstone", has(ItemRegistry.POLISHED_GLOOMSTONE.get())).save(consumer, "polished_gloomstone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.POLISHED_GLOOMSTONE.get()), ItemRegistry.POLISHED_GLOOMSTONE_STAIRS.get()).unlockedBy("has_polished_gloomstone", has(ItemRegistry.POLISHED_GLOOMSTONE.get())).save(consumer, "polished_gloomstone_stairs_stonecutting");

        shaped(ItemRegistry.GLOOMSTONE_BRICKS.get(),4).define('#', ItemRegistry.GLOOMSTONE.get()).pattern("##").pattern("##").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_BRICKS_SLAB.get(), 6).define('#', ItemRegistry.GLOOMSTONE_BRICKS.get()).pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_BRICKS_STAIRS.get(), 4).define('#', ItemRegistry.GLOOMSTONE_BRICKS.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_BRICKS_WALL.get(), 6).define('#', ItemRegistry.GLOOMSTONE_BRICKS.get()).pattern("###").pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.GLOOMSTONE_BRICKS_SLAB.get(), 2).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_bricks_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.GLOOMSTONE_BRICKS_STAIRS.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_bricks_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.GLOOMSTONE_BRICKS_WALL.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_brick_wall_stonecutting");

        shaped(ItemRegistry.GLOOMSTONE_TILES.get(),4).define('#', ItemRegistry.GLOOMSTONE_BRICKS.get()).pattern("##").pattern("##").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_TILES_SLAB.get(), 6).define('#', ItemRegistry.GLOOMSTONE_TILES.get()).pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_TILES_STAIRS.get(), 4).define('#', ItemRegistry.GLOOMSTONE_TILES.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        shaped(ItemRegistry.GLOOMSTONE_TILES_WALL.get(), 6).define('#', ItemRegistry.GLOOMSTONE_TILES.get()).pattern("###").pattern("###").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_TILES.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.GLOOMSTONE_TILES.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_stonecutting_alt");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_TILES.get()), ItemRegistry.GLOOMSTONE_TILES_SLAB.get(), 2).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_TILES.get()), ItemRegistry.GLOOMSTONE_TILES_STAIRS.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_TILES.get()), ItemRegistry.GLOOMSTONE_TILES_WALL.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_tiles_wall_stonecutting");

        shapedPressurePlate(consumer, ItemRegistry.GLOOMSTONE_PRESSURE_PLATE.get(), ItemRegistry.GLOOMSTONE.get());
        shaped(ItemRegistry.CARVED_GLOOMSTONE.get()).define('#', ItemRegistry.GLOOMSTONE_SLAB.get()).pattern("#").pattern("#").unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.GLOOMSTONE_BRICKS.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "gloomstone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.POLISHED_GLOOMSTONE.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "polished_gloomstone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE.get()), ItemRegistry.CARVED_GLOOMSTONE.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "carved_gloomstone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GLOOMSTONE_BRICKS.get()), ItemRegistry.CARVED_GLOOMSTONE.get()).unlockedBy("has_gloomstone", has(ItemRegistry.GLOOMSTONE.get())).save(consumer, "carved_gloomstone_bricks_stonecutting_alt");

        shaped(ItemRegistry.RAVAGESTONE.get(), 8).define('X', ItemRegistry.RAVAGED_SCRAP.get()).define('Y', Tags.Items.STONE).pattern("YYY").pattern("YXY").pattern("YYY").unlockedBy("has_ravaged_scrap", has(ItemRegistry.RAVAGED_SCRAP.get())).save(consumer);

        shaped(ItemRegistry.RAVAGESTONE_WALL.get(), 6).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("###").pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_SLAB.get(), 6).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_STAIRS.get(), 4).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_SLAB.get(), 2).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_STAIRS.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_WALL.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_wall_stonecutting");

        shaped(ItemRegistry.POLISHED_RAVAGESTONE.get(),9).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.POLISHED_RAVAGESTONE_SLAB.get(), 6).define('#', ItemRegistry.POLISHED_RAVAGESTONE.get()).pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.POLISHED_RAVAGESTONE_STAIRS.get(), 4).define('#', ItemRegistry.POLISHED_RAVAGESTONE.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.POLISHED_RAVAGESTONE.get()), ItemRegistry.POLISHED_RAVAGESTONE_SLAB.get(), 2).unlockedBy("has_polished_ravagestone", has(ItemRegistry.POLISHED_RAVAGESTONE.get())).save(consumer, "polished_ravagestone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.POLISHED_RAVAGESTONE.get()), ItemRegistry.POLISHED_RAVAGESTONE_STAIRS.get()).unlockedBy("has_polished_ravagestone", has(ItemRegistry.POLISHED_RAVAGESTONE.get())).save(consumer, "polished_ravagestone_stairs_stonecutting");

        shaped(ItemRegistry.RAVAGESTONE_BRICKS.get(),4).define('#', ItemRegistry.RAVAGESTONE.get()).pattern("##").pattern("##").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_BRICKS_SLAB.get(), 6).define('#', ItemRegistry.RAVAGESTONE_BRICKS.get()).pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_BRICKS_STAIRS.get(), 4).define('#', ItemRegistry.RAVAGESTONE_BRICKS.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_BRICKS_WALL.get(), 6).define('#', ItemRegistry.RAVAGESTONE_BRICKS.get()).pattern("###").pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.RAVAGESTONE_BRICKS_SLAB.get(), 2).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_bricks_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.RAVAGESTONE_BRICKS_STAIRS.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_bricks_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.RAVAGESTONE_BRICKS_WALL.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_brick_wall_stonecutting");

        shaped(ItemRegistry.RAVAGESTONE_TILES.get(),4).define('#', ItemRegistry.RAVAGESTONE_BRICKS.get()).pattern("##").pattern("##").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_TILES_SLAB.get(), 6).define('#', ItemRegistry.RAVAGESTONE_TILES.get()).pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_TILES_STAIRS.get(), 4).define('#', ItemRegistry.RAVAGESTONE_TILES.get()).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        shaped(ItemRegistry.RAVAGESTONE_TILES_WALL.get(), 6).define('#', ItemRegistry.RAVAGESTONE_TILES.get()).pattern("###").pattern("###").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_TILES.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.RAVAGESTONE_TILES.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_stonecutting_alt");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_TILES.get()), ItemRegistry.RAVAGESTONE_TILES_SLAB.get(), 2).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_slab_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_TILES.get()), ItemRegistry.RAVAGESTONE_TILES_STAIRS.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_TILES.get()), ItemRegistry.RAVAGESTONE_TILES_WALL.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_tiles_wall_stonecutting");

        shapedPressurePlate(consumer, ItemRegistry.RAVAGESTONE_PRESSURE_PLATE.get(), ItemRegistry.RAVAGESTONE.get());
        shaped(ItemRegistry.CARVED_RAVAGESTONE.get()).define('#', ItemRegistry.RAVAGESTONE_SLAB.get()).pattern("#").pattern("#").unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.RAVAGESTONE_BRICKS.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "ravagestone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.POLISHED_RAVAGESTONE.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "polished_ravagestone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE.get()), ItemRegistry.CARVED_RAVAGESTONE.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "carved_ravagestone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.RAVAGESTONE_BRICKS.get()), ItemRegistry.CARVED_RAVAGESTONE.get()).unlockedBy("has_ravagestone", has(ItemRegistry.RAVAGESTONE.get())).save(consumer, "carved_ravagestone_bricks_stonecutting_alt");
    }
    private static void shapelessPlanks(Consumer<FinishedRecipe> recipeConsumer, ItemLike planks, Tag<Item> input)
    {
        shapeless(planks, 4).requires(input).group("planks").unlockedBy("has_logs", has(input)).save(recipeConsumer);
    }
    private static void shapelessWood(Consumer<FinishedRecipe> recipeConsumer, ItemLike stripped, ItemLike input)
    {
        shaped(stripped, 3).define('#', input).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(input)).save(recipeConsumer);
    }
    private static void shapelessButton(Consumer<FinishedRecipe> recipeConsumer, ItemLike button, ItemLike input)
    {
        shapeless(button).requires(input).unlockedBy("has_input", has(input)).save(recipeConsumer);
    }
    private static void shapedDoor(Consumer<FinishedRecipe> recipeConsumer, ItemLike door, ItemLike input)
    {
        shaped(door, 3).define('#', input).pattern("##").pattern("##").pattern("##").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }
    private static void shapedFence(Consumer<FinishedRecipe> recipeConsumer, ItemLike fence, ItemLike input)
    {
        shaped(fence, 3).define('#', Items.STICK).define('W', input).pattern("W#W").pattern("W#W").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }
    private static void shapedFenceGate(Consumer<FinishedRecipe> recipeConsumer, ItemLike fenceGate, ItemLike input)
    {
        shaped(fenceGate).define('#', Items.STICK).define('W', input).pattern("#W#").pattern("#W#").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }
    private static void shapedPressurePlate(Consumer<FinishedRecipe> recipeConsumer, ItemLike pressurePlate, ItemLike input)
    {
        shaped(pressurePlate).define('#', input).pattern("##").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }
    private static void shapedSlab(Consumer<FinishedRecipe> recipeConsumer, ItemLike slab, ItemLike input)
    {
        shaped(slab, 6).define('#', input).pattern("###").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }
    private static void shapedStairs(Consumer<FinishedRecipe> recipeConsumer, ItemLike stairs, ItemLike input)
    {
        shaped(stairs, 4).define('#', input).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }
    private static void shapelessSolidTrapdoor(Consumer<FinishedRecipe> recipeConsumer, ItemLike solid, ItemLike normal)
    {
        shapeless(solid).requires(normal).unlockedBy("has_input", has(normal)).save(recipeConsumer);
    }
    private static void shapedTrapdoor(Consumer<FinishedRecipe> recipeConsumer, ItemLike trapdoor, ItemLike input)
    {
        shaped(trapdoor, 2).define('#', input).pattern("###").pattern("###").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }
    private static void shapedSign(Consumer<FinishedRecipe> recipeConsumer, ItemLike sign, ItemLike input)
    {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        shaped(sign, 3).group("sign").define('#', input).define('X', Items.STICK).pattern("###").pattern("###").pattern(" X ").unlockedBy("has_" + s, has(input)).save(recipeConsumer);
    }
    private static void netheriteSmithing(Consumer<FinishedRecipe> p_240469_0_, Item p_240469_1_, Item p_240469_2_, Item ingot) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(p_240469_1_), Ingredient.of(ingot), p_240469_2_).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(p_240469_0_, Registry.ITEM.getKey(p_240469_2_.asItem()).getPath() + "_smithing");
    }

    private static void planksFromLog(Consumer<FinishedRecipe> p_240470_0_, ItemLike p_240470_1_, Tag<Item> p_240470_2_) {
        ShapelessRecipeBuilder.shapeless(p_240470_1_, 4).requires(p_240470_2_).group("planks").unlockedBy("has_log", has(p_240470_2_)).save(p_240470_0_);
    }

    private static void planksFromLogs(Consumer<FinishedRecipe> p_240472_0_, ItemLike p_240472_1_, Tag<Item> p_240472_2_) {
        ShapelessRecipeBuilder.shapeless(p_240472_1_, 4).requires(p_240472_2_).group("planks").unlockedBy("has_logs", has(p_240472_2_)).save(p_240472_0_);
    }

    private static void woodFromLogs(Consumer<FinishedRecipe> p_240471_0_, ItemLike p_240471_1_, ItemLike p_240471_2_) {
        shaped(p_240471_1_, 3).define('#', p_240471_2_).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(p_240471_2_)).save(p_240471_0_);
    }

    private static void woodenBoat(Consumer<FinishedRecipe> p_240473_0_, ItemLike p_240473_1_, ItemLike p_240473_2_) {
        shaped(p_240473_1_).define('#', p_240473_2_).pattern("# #").pattern("###").group("boat").unlockedBy("in_water", insideOf(Blocks.WATER)).save(p_240473_0_);
    }

    private static void woodenButton(Consumer<FinishedRecipe> p_240474_0_, ItemLike p_240474_1_, ItemLike p_240474_2_) {
        ShapelessRecipeBuilder.shapeless(p_240474_1_).requires(p_240474_2_).group("wooden_button").unlockedBy("has_planks", has(p_240474_2_)).save(p_240474_0_);
    }

    private static void woodenDoor(Consumer<FinishedRecipe> p_240475_0_, ItemLike p_240475_1_, ItemLike p_240475_2_) {
        shaped(p_240475_1_, 3).define('#', p_240475_2_).pattern("##").pattern("##").pattern("##").group("wooden_door").unlockedBy("has_planks", has(p_240475_2_)).save(p_240475_0_);
    }

    private static void woodenFence(Consumer<FinishedRecipe> p_240476_0_, ItemLike p_240476_1_, ItemLike p_240476_2_) {
        shaped(p_240476_1_, 3).define('#', Items.STICK).define('W', p_240476_2_).pattern("W#W").pattern("W#W").group("wooden_fence").unlockedBy("has_planks", has(p_240476_2_)).save(p_240476_0_);
    }

    private static void woodenFenceGate(Consumer<FinishedRecipe> p_240477_0_, ItemLike p_240477_1_, ItemLike p_240477_2_) {
        shaped(p_240477_1_).define('#', Items.STICK).define('W', p_240477_2_).pattern("#W#").pattern("#W#").group("wooden_fence_gate").unlockedBy("has_planks", has(p_240477_2_)).save(p_240477_0_);
    }

    private static void woodenPressurePlate(Consumer<FinishedRecipe> p_240478_0_, ItemLike p_240478_1_, ItemLike p_240478_2_) {
        shaped(p_240478_1_).define('#', p_240478_2_).pattern("##").group("wooden_pressure_plate").unlockedBy("has_planks", has(p_240478_2_)).save(p_240478_0_);
    }

    private static void woodenSlab(Consumer<FinishedRecipe> p_240479_0_, ItemLike p_240479_1_, ItemLike p_240479_2_) {
        shaped(p_240479_1_, 6).define('#', p_240479_2_).pattern("###").group("wooden_slab").unlockedBy("has_planks", has(p_240479_2_)).save(p_240479_0_);
    }

    private static void woodenStairs(Consumer<FinishedRecipe> p_240480_0_, ItemLike p_240480_1_, ItemLike p_240480_2_) {
        shaped(p_240480_1_, 4).define('#', p_240480_2_).pattern("#  ").pattern("## ").pattern("###").group("wooden_stairs").unlockedBy("has_planks", has(p_240480_2_)).save(p_240480_0_);
    }

    private static void woodenTrapdoor(Consumer<FinishedRecipe> p_240481_0_, ItemLike p_240481_1_, ItemLike p_240481_2_) {
        shaped(p_240481_1_, 2).define('#', p_240481_2_).pattern("###").pattern("###").group("wooden_trapdoor").unlockedBy("has_planks", has(p_240481_2_)).save(p_240481_0_);
    }

    private static void woodenSign(Consumer<FinishedRecipe> p_240482_0_, ItemLike p_240482_1_, ItemLike p_240482_2_) {
        String s = Registry.ITEM.getKey(p_240482_2_.asItem()).getPath();
        shaped(p_240482_1_, 3).group("sign").define('#', p_240482_2_).define('X', Items.STICK).pattern("###").pattern("###").pattern(" X ").unlockedBy("has_" + s, has(p_240482_2_)).save(p_240482_0_);
    }

    private static void coloredWoolFromWhiteWoolAndDye(Consumer<FinishedRecipe> p_240483_0_, ItemLike p_240483_1_, ItemLike p_240483_2_) {
        ShapelessRecipeBuilder.shapeless(p_240483_1_).requires(p_240483_2_).requires(Blocks.WHITE_WOOL).group("wool").unlockedBy("has_white_wool", has(Blocks.WHITE_WOOL)).save(p_240483_0_);
    }

    private static void carpetFromWool(Consumer<FinishedRecipe> p_240484_0_, ItemLike p_240484_1_, ItemLike p_240484_2_) {
        String s = Registry.ITEM.getKey(p_240484_2_.asItem()).getPath();
        shaped(p_240484_1_, 3).define('#', p_240484_2_).pattern("##").group("carpet").unlockedBy("has_" + s, has(p_240484_2_)).save(p_240484_0_);
    }

    private static void coloredCarpetFromWhiteCarpetAndDye(Consumer<FinishedRecipe> p_240485_0_, ItemLike p_240485_1_, ItemLike p_240485_2_) {
        String s = Registry.ITEM.getKey(p_240485_1_.asItem()).getPath();
        String s1 = Registry.ITEM.getKey(p_240485_2_.asItem()).getPath();
        shaped(p_240485_1_, 8).define('#', Blocks.WHITE_CARPET).define('$', p_240485_2_).pattern("###").pattern("#$#").pattern("###").group("carpet").unlockedBy("has_white_carpet", has(Blocks.WHITE_CARPET)).unlockedBy("has_" + s1, has(p_240485_2_)).save(p_240485_0_, s + "_from_white_carpet");
    }

    private static void bedFromPlanksAndWool(Consumer<FinishedRecipe> p_240486_0_, ItemLike p_240486_1_, ItemLike p_240486_2_) {
        String s = Registry.ITEM.getKey(p_240486_2_.asItem()).getPath();
        shaped(p_240486_1_).define('#', p_240486_2_).define('X', ItemTags.PLANKS).pattern("###").pattern("XXX").group("bed").unlockedBy("has_" + s, has(p_240486_2_)).save(p_240486_0_);
    }

    private static void bedFromWhiteBedAndDye(Consumer<FinishedRecipe> p_240487_0_, ItemLike p_240487_1_, ItemLike p_240487_2_) {
        String s = Registry.ITEM.getKey(p_240487_1_.asItem()).getPath();
        ShapelessRecipeBuilder.shapeless(p_240487_1_).requires(Items.WHITE_BED).requires(p_240487_2_).group("dyed_bed").unlockedBy("has_bed", has(Items.WHITE_BED)).save(p_240487_0_, s + "_from_white_bed");
    }

    private static void banner(Consumer<FinishedRecipe> p_240488_0_, ItemLike p_240488_1_, ItemLike p_240488_2_) {
        String s = Registry.ITEM.getKey(p_240488_2_.asItem()).getPath();
        shaped(p_240488_1_).define('#', p_240488_2_).define('|', Items.STICK).pattern("###").pattern("###").pattern(" | ").group("banner").unlockedBy("has_" + s, has(p_240488_2_)).save(p_240488_0_);
    }

    private static void stainedGlassFromGlassAndDye(Consumer<FinishedRecipe> p_240489_0_, ItemLike p_240489_1_, ItemLike p_240489_2_) {
        shaped(p_240489_1_, 8).define('#', Blocks.GLASS).define('X', p_240489_2_).pattern("###").pattern("#X#").pattern("###").group("stained_glass").unlockedBy("has_glass", has(Blocks.GLASS)).save(p_240489_0_);
    }

    private static void stainedGlassPaneFromStainedGlass(Consumer<FinishedRecipe> p_240490_0_, ItemLike p_240490_1_, ItemLike p_240490_2_) {
        shaped(p_240490_1_, 16).define('#', p_240490_2_).pattern("###").pattern("###").group("stained_glass_pane").unlockedBy("has_glass", has(p_240490_2_)).save(p_240490_0_);
    }

    private static void stainedGlassPaneFromGlassPaneAndDye(Consumer<FinishedRecipe> p_240491_0_, ItemLike p_240491_1_, ItemLike p_240491_2_) {
        String s = Registry.ITEM.getKey(p_240491_1_.asItem()).getPath();
        String s1 = Registry.ITEM.getKey(p_240491_2_.asItem()).getPath();
        shaped(p_240491_1_, 8).define('#', Blocks.GLASS_PANE).define('$', p_240491_2_).pattern("###").pattern("#$#").pattern("###").group("stained_glass_pane").unlockedBy("has_glass_pane", has(Blocks.GLASS_PANE)).unlockedBy("has_" + s1, has(p_240491_2_)).save(p_240491_0_, s + "_from_glass_pane");
    }

    private static void coloredTerracottaFromTerracottaAndDye(Consumer<FinishedRecipe> p_240492_0_, ItemLike p_240492_1_, ItemLike p_240492_2_) {
        shaped(p_240492_1_, 8).define('#', Blocks.TERRACOTTA).define('X', p_240492_2_).pattern("###").pattern("#X#").pattern("###").group("stained_terracotta").unlockedBy("has_terracotta", has(Blocks.TERRACOTTA)).save(p_240492_0_);
    }

    private static void concretePowder(Consumer<FinishedRecipe> p_240493_0_, ItemLike p_240493_1_, ItemLike p_240493_2_) {
        ShapelessRecipeBuilder.shapeless(p_240493_1_, 8).requires(p_240493_2_).requires(Blocks.SAND, 4).requires(Blocks.GRAVEL, 4).group("concrete_powder").unlockedBy("has_sand", has(Blocks.SAND)).unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(p_240493_0_);
    }

    private static void cookRecipes(Consumer<FinishedRecipe> p_218445_0_, String p_218445_1_, SimpleCookingSerializer<?> p_218445_2_, int p_218445_3_) {
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.BEEF), Items.COOKED_BEEF, 0.35F, p_218445_3_, p_218445_2_).unlockedBy("has_beef", has(Items.BEEF)).save(p_218445_0_, "cooked_beef_from_" + p_218445_1_);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.CHICKEN), Items.COOKED_CHICKEN, 0.35F, p_218445_3_, p_218445_2_).unlockedBy("has_chicken", has(Items.CHICKEN)).save(p_218445_0_, "cooked_chicken_from_" + p_218445_1_);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.COD), Items.COOKED_COD, 0.35F, p_218445_3_, p_218445_2_).unlockedBy("has_cod", has(Items.COD)).save(p_218445_0_, "cooked_cod_from_" + p_218445_1_);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Blocks.KELP), Items.DRIED_KELP, 0.1F, p_218445_3_, p_218445_2_).unlockedBy("has_kelp", has(Blocks.KELP)).save(p_218445_0_, "dried_kelp_from_" + p_218445_1_);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.SALMON), Items.COOKED_SALMON, 0.35F, p_218445_3_, p_218445_2_).unlockedBy("has_salmon", has(Items.SALMON)).save(p_218445_0_, "cooked_salmon_from_" + p_218445_1_);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.MUTTON), Items.COOKED_MUTTON, 0.35F, p_218445_3_, p_218445_2_).unlockedBy("has_mutton", has(Items.MUTTON)).save(p_218445_0_, "cooked_mutton_from_" + p_218445_1_);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.PORKCHOP), Items.COOKED_PORKCHOP, 0.35F, p_218445_3_, p_218445_2_).unlockedBy("has_porkchop", has(Items.PORKCHOP)).save(p_218445_0_, "cooked_porkchop_from_" + p_218445_1_);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.POTATO), Items.BAKED_POTATO, 0.35F, p_218445_3_, p_218445_2_).unlockedBy("has_potato", has(Items.POTATO)).save(p_218445_0_, "baked_potato_from_" + p_218445_1_);
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(Items.RABBIT), Items.COOKED_RABBIT, 0.35F, p_218445_3_, p_218445_2_).unlockedBy("has_rabbit", has(Items.RABBIT)).save(p_218445_0_, "cooked_rabbit_from_" + p_218445_1_);
    }

    protected static EnterBlockTrigger.TriggerInstance insideOf(Block p_200407_0_) {
        return new EnterBlockTrigger.TriggerInstance(EntityPredicate.Composite.ANY, p_200407_0_, StatePropertiesPredicate.ANY);
    }

    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike p_200403_0_) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(p_200403_0_).build());
    }

    protected static InventoryChangeTrigger.TriggerInstance has(Tag<Item> p_200409_0_) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(p_200409_0_).build());
    }

    protected static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... p_200405_0_) {
        return new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, p_200405_0_);
    }
}