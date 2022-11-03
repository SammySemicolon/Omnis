package com.sammy.omnis.core.data;

import com.sammy.omnis.core.registry.item.ItemRegistry;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.sammy.omnis.OmnisMod.omnisPath;
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

        smithing(consumer, ItemRegistry.SPELL_BLADE.get(), ItemRegistry.HAUNTED_SPELL_BLADE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.VINDICATOR_AXE.get(), ItemRegistry.HAUNTED_VINDICATOR_AXE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.RAVAGED_CHARM.get(), ItemRegistry.HAUNTED_CHARM.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

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

        smithing(consumer, ItemRegistry.RAVAGED_BATTLE_AXE.get(), ItemRegistry.HAUNTED_BATTLE_AXE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.RAVAGED_HAMMER.get(), ItemRegistry.HAUNTED_HAMMER.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.RAVAGED_SPEAR.get(), ItemRegistry.HAUNTED_SPEAR.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.RAVAGED_SCYTHE.get(), ItemRegistry.HAUNTED_SCYTHE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.RAVAGED_BROADSWORD.get(), ItemRegistry.HAUNTED_BROADSWORD.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

        smithing(consumer, ItemRegistry.RAVAGED_HELMET.get(), ItemRegistry.HAUNTED_HELMET.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.RAVAGED_CHESTPLATE.get(), ItemRegistry.HAUNTED_CHESTPLATE.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.RAVAGED_LEGGINGS.get(), ItemRegistry.HAUNTED_LEGGINGS.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());
        smithing(consumer, ItemRegistry.RAVAGED_BOOTS.get(), ItemRegistry.HAUNTED_BOOTS.get(), ItemRegistry.HAUNTED_STEEL_INGOT.get());

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

    private static void smithing(Consumer<FinishedRecipe> recipeConsumer, Item input, Item output, Item ingot) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(input), Ingredient.of(ingot), output).unlocks("has_"+ingot.getRegistryName().getPath(), has(ingot)).save(recipeConsumer, Registry.ITEM.getKey(output.asItem()).getPath() + "_smithing");
    }

    private static void shapelessPlanks(Consumer<FinishedRecipe> recipeConsumer, ItemLike planks, TagKey<Item> input) {
        shapeless(planks, 4).requires(input).group("planks").unlockedBy("has_logs", has(input)).save(recipeConsumer);
    }

    private static void shapelessWood(Consumer<FinishedRecipe> recipeConsumer, ItemLike stripped, ItemLike input) {
        shaped(stripped, 3).define('#', input).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(input)).save(recipeConsumer);
    }

    private static void shapelessButton(Consumer<FinishedRecipe> recipeConsumer, ItemLike button, ItemLike input) {
        shapeless(button).requires(input).unlockedBy("has_input", has(input)).save(recipeConsumer);
    }

    private static void shapedDoor(Consumer<FinishedRecipe> recipeConsumer, ItemLike door, ItemLike input) {
        shaped(door, 3).define('#', input).pattern("##").pattern("##").pattern("##").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }

    private static void shapedFence(Consumer<FinishedRecipe> recipeConsumer, ItemLike fence, ItemLike input) {
        shaped(fence, 3).define('#', Tags.Items.RODS_WOODEN).define('W', input).pattern("W#W").pattern("W#W").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }

    private static void shapedFenceGate(Consumer<FinishedRecipe> recipeConsumer, ItemLike fenceGate, ItemLike input) {
        shaped(fenceGate).define('#', Tags.Items.RODS_WOODEN).define('W', input).pattern("#W#").pattern("#W#").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }

    private static void shapedPressurePlate(Consumer<FinishedRecipe> recipeConsumer, ItemLike pressurePlate, ItemLike input) {
        shaped(pressurePlate).define('#', input).pattern("##").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }

    private static void shapedSlab(Consumer<FinishedRecipe> recipeConsumer, ItemLike slab, ItemLike input) {
        shaped(slab, 6).define('#', input).pattern("###").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }

    private static void shapedStairs(Consumer<FinishedRecipe> recipeConsumer, ItemLike stairs, ItemLike input) {
        shaped(stairs, 4).define('#', input).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }

    private static void shapelessSolidTrapdoor(Consumer<FinishedRecipe> recipeConsumer, ItemLike solid, ItemLike normal) {
        shapeless(solid).requires(normal).unlockedBy("has_input", has(normal)).save(recipeConsumer);
    }

    private static void shapelessSolidTrapdoor(Consumer<FinishedRecipe> recipeConsumer, ItemLike solid, ItemLike normal, String path) {
        shapeless(solid).requires(normal).unlockedBy("has_input", has(normal)).save(recipeConsumer, omnisPath(path));
    }

    private static void shapedTrapdoor(Consumer<FinishedRecipe> recipeConsumer, ItemLike trapdoor, ItemLike input) {
        shaped(trapdoor, 2).define('#', input).pattern("###").pattern("###").unlockedBy("has_input", has(input)).save(recipeConsumer);
    }

    private static void shapedSign(Consumer<FinishedRecipe> recipeConsumer, ItemLike sign, ItemLike input) {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        shaped(sign, 3).group("sign").define('#', input).define('X', Tags.Items.RODS_WOODEN).pattern("###").pattern("###").pattern(" X ").unlockedBy("has_" + s, has(input)).save(recipeConsumer);
    }

    protected static EnterBlockTrigger.TriggerInstance insideOf(Block pBlock) {
        return new EnterBlockTrigger.TriggerInstance(EntityPredicate.Composite.ANY, pBlock, StatePropertiesPredicate.ANY);
    }

    protected static InventoryChangeTrigger.TriggerInstance has(MinMaxBounds.Ints pCount, ItemLike pItem) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItem).withCount(pCount).build());
    }

    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItemLike).build());
    }

    protected static InventoryChangeTrigger.TriggerInstance has(TagKey<Item> pTag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pTag).build());
    }

    protected static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... pPredicates) {
        return new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, pPredicates);
    }
}