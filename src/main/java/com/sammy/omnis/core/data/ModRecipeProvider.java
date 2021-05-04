package com.sammy.omnis.core.data;

import com.sammy.omnis.core.init.OmnisItems;
import net.minecraft.advancements.criterion.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Item;
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
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.VEXWART_BLOCK.get()).key('#', OmnisItems.VEXWART.get()).patternLine("###").patternLine("###").patternLine("###").setGroup("vexwart").addCriterion("has_tear_of_vex", hasItem(OmnisItems.TEAR_OF_VEX.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(OmnisItems.VEXWART.get(), 9).addIngredient(OmnisItems.VEXWART_BLOCK.get()).setGroup("vexwart").addCriterion("has_tear_of_vex", hasItem(OmnisItems.TEAR_OF_VEX.get())).build(consumer, "vexwart_alt");
        ShapelessRecipeBuilder.shapelessRecipe(OmnisItems.VEXWART.get(), 2).addIngredient(OmnisItems.TEAR_OF_VEX.get()).addIngredient(Items.NETHER_WART, 2).setGroup("vexwart").addCriterion("has_tear_of_vex", hasItem(OmnisItems.TEAR_OF_VEX.get())).build(consumer);

        smithingReinforce(consumer, OmnisItems.SPELL_BLADE.get(), OmnisItems.HAUNTED_SPELL_BLADE.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, OmnisItems.VINDICATOR_AXE.get(), OmnisItems.HAUNTED_VINDICATOR_AXE.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());

        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_METAL_BLOCK.get()).key('#', OmnisItems.RAVAGED_METAL.get()).patternLine("###").patternLine("###").patternLine("###").setGroup("ravaged_metal").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(OmnisItems.RAVAGED_METAL.get(), 9).addIngredient(OmnisItems.RAVAGED_METAL_BLOCK.get()).setGroup("ravaged_metal").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer, "ravaged_metal_alt");
        ShapelessRecipeBuilder.shapelessRecipe(OmnisItems.RAVAGED_METAL.get()).addIngredient(OmnisItems.RAVAGED_SCRAP.get(), 4).addIngredient(Tags.Items.INGOTS_IRON).setGroup("ravaged_metal").addCriterion("has_ravaged_scrap", hasItem(OmnisItems.RAVAGED_SCRAP.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_BATTLE_AXE.get()).key('#', Items.STICK).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("X X").patternLine("X#X").patternLine(" # ").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_SCYTHE.get()).key('#', Items.STICK).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("XX ").patternLine(" #X").patternLine("#  ").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_HAMMER.get()).key('#', Items.STICK).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("XXX").patternLine("X# ").patternLine(" # ").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_SPEAR.get()).key('#', Items.STICK).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("X").patternLine("#").patternLine("#").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_BROADSWORD.get()).key('#', Items.STICK).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("X").patternLine("X").patternLine("#").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_HELMET.get()).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("XXX").patternLine("X X").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_CHESTPLATE.get()).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("X X").patternLine("XXX").patternLine("XXX").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_LEGGINGS.get()).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("XXX").patternLine("X X").patternLine("X X").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGED_BOOTS.get()).key('X', OmnisItems.RAVAGED_METAL.get()).patternLine("X X").patternLine("X X").addCriterion("has_ravaged_metal", hasItem(OmnisItems.RAVAGED_METAL.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(OmnisItems.HAUNTED_STEEL_BLOCK.get()).key('#', OmnisItems.HAUNTED_STEEL_INGOT.get()).patternLine("###").patternLine("###").patternLine("###").setGroup("haunted_steel").addCriterion("has_haunted_steel", hasItem(OmnisItems.HAUNTED_STEEL_INGOT.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(OmnisItems.HAUNTED_STEEL_INGOT.get(), 9).addIngredient(OmnisItems.HAUNTED_STEEL_BLOCK.get()).setGroup("haunted_steel").addCriterion("has_haunted_steel", hasItem(OmnisItems.HAUNTED_STEEL_INGOT.get())).build(consumer, "haunted_ingot_alt");
        ShapelessRecipeBuilder.shapelessRecipe(OmnisItems.HAUNTED_STEEL_INGOT.get()).addIngredient(Items.NETHERITE_SCRAP, 1).addIngredient(OmnisItems.TEAR_OF_VEX.get(), 4).addIngredient(Items.GOLD_INGOT, 4).setGroup("haunted_steel").addCriterion("has_haunted_steel", hasItem(OmnisItems.HAUNTED_STEEL_INGOT.get())).build(consumer);

        smithingReinforce(consumer, OmnisItems.RAVAGED_BATTLE_AXE.get(), OmnisItems.HAUNTED_BATTLE_AXE.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, OmnisItems.RAVAGED_HAMMER.get(), OmnisItems.HAUNTED_HAMMER.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, OmnisItems.RAVAGED_SPEAR.get(), OmnisItems.HAUNTED_SPEAR.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, OmnisItems.RAVAGED_SCYTHE.get(), OmnisItems.HAUNTED_SCYTHE.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, OmnisItems.RAVAGED_BROADSWORD.get(), OmnisItems.HAUNTED_BROADSWORD.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());

        smithingReinforce(consumer, OmnisItems.RAVAGED_HELMET.get(), OmnisItems.HAUNTED_HELMET.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, OmnisItems.RAVAGED_CHESTPLATE.get(), OmnisItems.HAUNTED_CHESTPLATE.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, OmnisItems.RAVAGED_LEGGINGS.get(), OmnisItems.HAUNTED_LEGGINGS.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());
        smithingReinforce(consumer, OmnisItems.RAVAGED_BOOTS.get(), OmnisItems.HAUNTED_BOOTS.get(), OmnisItems.HAUNTED_STEEL_INGOT.get());

        ShapelessRecipeBuilder.shapelessRecipe(OmnisItems.GLOOMSTONE.get()).addIngredient(OmnisItems.TEAR_OF_VEX.get()).addIngredient(Ingredient.fromTag(Tags.Items.STONE), 8).addCriterion("has_tear_of_vex", hasItem(OmnisItems.TEAR_OF_VEX.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(OmnisItems.GLOOMSTONE_WALL.get(), 6).key('#', OmnisItems.GLOOMSTONE.get()).patternLine("###").patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.GLOOMSTONE_SLAB.get(), 6).key('#', OmnisItems.GLOOMSTONE.get()).patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.GLOOMSTONE_STAIRS.get(), 4).key('#', OmnisItems.GLOOMSTONE.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE.get()), OmnisItems.GLOOMSTONE_SLAB.get(), 2).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE.get()), OmnisItems.GLOOMSTONE_STAIRS.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE.get()), OmnisItems.GLOOMSTONE_WALL.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_wall_stonecutting");

        shapedRecipe(OmnisItems.POLISHED_GLOOMSTONE.get(),9).key('#', OmnisItems.GLOOMSTONE.get()).patternLine("###").patternLine("###").patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.POLISHED_GLOOMSTONE_SLAB.get(), 6).key('#', OmnisItems.POLISHED_GLOOMSTONE.get()).patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.POLISHED_GLOOMSTONE_STAIRS.get(), 4).key('#', OmnisItems.POLISHED_GLOOMSTONE.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.POLISHED_GLOOMSTONE.get()), OmnisItems.POLISHED_GLOOMSTONE_SLAB.get(), 2).addCriterion("has_polished_gloomstone", hasItem(OmnisItems.POLISHED_GLOOMSTONE.get())).build(consumer, "polished_gloomstone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.POLISHED_GLOOMSTONE.get()), OmnisItems.POLISHED_GLOOMSTONE_STAIRS.get()).addCriterion("has_polished_gloomstone", hasItem(OmnisItems.POLISHED_GLOOMSTONE.get())).build(consumer, "polished_gloomstone_stairs_stonecutting");

        shapedRecipe(OmnisItems.GLOOMSTONE_BRICKS.get(),4).key('#', OmnisItems.GLOOMSTONE.get()).patternLine("##").patternLine("##").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.GLOOMSTONE_BRICKS_SLAB.get(), 6).key('#', OmnisItems.GLOOMSTONE_BRICKS.get()).patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.GLOOMSTONE_BRICKS_STAIRS.get(), 4).key('#', OmnisItems.GLOOMSTONE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.GLOOMSTONE_BRICKS_WALL.get(), 6).key('#', OmnisItems.GLOOMSTONE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE_BRICKS.get()), OmnisItems.GLOOMSTONE_BRICKS_SLAB.get(), 2).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_bricks_slab_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE_BRICKS.get()), OmnisItems.GLOOMSTONE_BRICKS_STAIRS.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_bricks_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE_BRICKS.get()), OmnisItems.GLOOMSTONE_BRICKS_WALL.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_brick_wall_stonecutting");

        shapedRecipe(OmnisItems.GLOOMSTONE_TILES.get(),4).key('#', OmnisItems.GLOOMSTONE_BRICKS.get()).patternLine("##").patternLine("##").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.GLOOMSTONE_TILES_SLAB.get(), 6).key('#', OmnisItems.GLOOMSTONE_TILES.get()).patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.GLOOMSTONE_TILES_STAIRS.get(), 4).key('#', OmnisItems.GLOOMSTONE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.GLOOMSTONE_TILES_WALL.get(), 6).key('#', OmnisItems.GLOOMSTONE_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE.get()), OmnisItems.GLOOMSTONE_TILES.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_tiles_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE_BRICKS.get()), OmnisItems.GLOOMSTONE_TILES.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_tiles_stonecutting_alt");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE_TILES.get()), OmnisItems.GLOOMSTONE_TILES_SLAB.get(), 2).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_tiles_slab_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE_TILES.get()), OmnisItems.GLOOMSTONE_TILES_STAIRS.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_tiles_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE_TILES.get()), OmnisItems.GLOOMSTONE_TILES_WALL.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_tiles_wall_stonecutting");

        shapedRecipe(OmnisItems.CARVED_GLOOMSTONE.get()).key('#', OmnisItems.GLOOMSTONE_SLAB.get()).patternLine("#").patternLine("#").addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE.get()), OmnisItems.GLOOMSTONE_BRICKS.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "gloomstone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE.get()), OmnisItems.POLISHED_GLOOMSTONE.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "polished_gloomstone_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE.get()), OmnisItems.CARVED_GLOOMSTONE.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "carved_gloomstone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.GLOOMSTONE_BRICKS.get()), OmnisItems.CARVED_GLOOMSTONE.get()).addCriterion("has_gloomstone", hasItem(OmnisItems.GLOOMSTONE.get())).build(consumer, "carved_gloomstone_bricks_stonecutting_alt");

        ShapelessRecipeBuilder.shapelessRecipe(OmnisItems.RAVAGESTONE.get()).addIngredient(OmnisItems.RAVAGED_SCRAP.get()).addIngredient(Ingredient.fromTag(Tags.Items.STONE), 8).setGroup("ravaged_metal").addCriterion("has_ravaged_scrap", hasItem(OmnisItems.RAVAGED_SCRAP.get())).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGESTONE_WALL.get(), 6).key('#', OmnisItems.RAVAGESTONE.get()).patternLine("###").patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.RAVAGESTONE_SLAB.get(), 6).key('#', OmnisItems.RAVAGESTONE.get()).patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.RAVAGESTONE_STAIRS.get(), 4).key('#', OmnisItems.RAVAGESTONE.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE.get()), OmnisItems.RAVAGESTONE_SLAB.get(), 2).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE.get()), OmnisItems.RAVAGESTONE_STAIRS.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE.get()), OmnisItems.RAVAGESTONE_WALL.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_wall_stonecutting");

        shapedRecipe(OmnisItems.POLISHED_RAVAGESTONE.get(),9).key('#', OmnisItems.RAVAGESTONE.get()).patternLine("###").patternLine("###").patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.POLISHED_RAVAGESTONE_SLAB.get(), 6).key('#', OmnisItems.POLISHED_RAVAGESTONE.get()).patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.POLISHED_RAVAGESTONE_STAIRS.get(), 4).key('#', OmnisItems.POLISHED_RAVAGESTONE.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.POLISHED_RAVAGESTONE.get()), OmnisItems.POLISHED_RAVAGESTONE_SLAB.get(), 2).addCriterion("has_polished_ravagestone", hasItem(OmnisItems.POLISHED_RAVAGESTONE.get())).build(consumer, "polished_ravagestone_slab_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.POLISHED_RAVAGESTONE.get()), OmnisItems.POLISHED_RAVAGESTONE_STAIRS.get()).addCriterion("has_polished_ravagestone", hasItem(OmnisItems.POLISHED_RAVAGESTONE.get())).build(consumer, "polished_ravagestone_stairs_stonecutting");

        shapedRecipe(OmnisItems.RAVAGESTONE_BRICKS.get(),4).key('#', OmnisItems.RAVAGESTONE.get()).patternLine("##").patternLine("##").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.RAVAGESTONE_BRICKS_SLAB.get(), 6).key('#', OmnisItems.RAVAGESTONE_BRICKS.get()).patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.RAVAGESTONE_BRICKS_STAIRS.get(), 4).key('#', OmnisItems.RAVAGESTONE_BRICKS.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGESTONE_BRICKS_WALL.get(), 6).key('#', OmnisItems.RAVAGESTONE_BRICKS.get()).patternLine("###").patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE_BRICKS.get()), OmnisItems.RAVAGESTONE_BRICKS_SLAB.get(), 2).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_bricks_slab_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE_BRICKS.get()), OmnisItems.RAVAGESTONE_BRICKS_STAIRS.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_bricks_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE_BRICKS.get()), OmnisItems.RAVAGESTONE_BRICKS_WALL.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_brick_wall_stonecutting");

        shapedRecipe(OmnisItems.RAVAGESTONE_TILES.get(),4).key('#', OmnisItems.RAVAGESTONE_BRICKS.get()).patternLine("##").patternLine("##").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.RAVAGESTONE_TILES_SLAB.get(), 6).key('#', OmnisItems.RAVAGESTONE_TILES.get()).patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        shapedRecipe(OmnisItems.RAVAGESTONE_TILES_STAIRS.get(), 4).key('#', OmnisItems.RAVAGESTONE_TILES.get()).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(OmnisItems.RAVAGESTONE_TILES_WALL.get(), 6).key('#', OmnisItems.RAVAGESTONE_TILES.get()).patternLine("###").patternLine("###").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE.get()), OmnisItems.RAVAGESTONE_TILES.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_tiles_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE_BRICKS.get()), OmnisItems.RAVAGESTONE_TILES.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_tiles_stonecutting_alt");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE_TILES.get()), OmnisItems.RAVAGESTONE_TILES_SLAB.get(), 2).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_tiles_slab_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE_TILES.get()), OmnisItems.RAVAGESTONE_TILES_STAIRS.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_tiles_stairs_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE_TILES.get()), OmnisItems.RAVAGESTONE_TILES_WALL.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_tiles_wall_stonecutting");

        shapedRecipe(OmnisItems.CARVED_RAVAGESTONE.get()).key('#', OmnisItems.RAVAGESTONE_SLAB.get()).patternLine("#").patternLine("#").addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer);
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE.get()), OmnisItems.RAVAGESTONE_BRICKS.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "ravagestone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE.get()), OmnisItems.POLISHED_RAVAGESTONE.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "polished_ravagestone_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE.get()), OmnisItems.CARVED_RAVAGESTONE.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "carved_ravagestone_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(OmnisItems.RAVAGESTONE_BRICKS.get()), OmnisItems.CARVED_RAVAGESTONE.get()).addCriterion("has_ravagestone", hasItem(OmnisItems.RAVAGESTONE.get())).build(consumer, "carved_ravagestone_bricks_stonecutting_alt");
    }
    private static void smithingReinforce(Consumer<IFinishedRecipe> recipeConsumer, Item itemToReinforce, Item output, Item reinforcement)
    {
        SmithingRecipeBuilder.smithingRecipe(Ingredient.fromItems(itemToReinforce), Ingredient.fromItems(reinforcement), output).addCriterion("has_" + Registry.ITEM.getKey(reinforcement).getPath(), hasItem(reinforcement)).build(recipeConsumer, Registry.ITEM.getKey(output).getPath() + "_smithing");
    }
    private static void shapelessPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider planks, ITag<Item> input)
    {
        shapelessRecipe(planks, 4).addIngredient(input).setGroup("planks").addCriterion("has_logs", hasItem(input)).build(recipeConsumer);
    }
    private static void shapelessWood(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider stripped, IItemProvider input)
    {
        shapedRecipe(stripped, 3).key('#', input).patternLine("##").patternLine("##").setGroup("bark").addCriterion("has_log", hasItem(input)).build(recipeConsumer);
    }
    private static void shapelessButton(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider button, IItemProvider input)
    {
        shapelessRecipe(button).addIngredient(input).addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapedDoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider door, IItemProvider input)
    {
        shapedRecipe(door, 3).key('#', input).patternLine("##").patternLine("##").patternLine("##").addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapedFence(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fence, IItemProvider input)
    {
        shapedRecipe(fence, 3).key('#', Items.STICK).key('W', input).patternLine("W#W").patternLine("W#W").addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapedFenceGate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fenceGate, IItemProvider input)
    {
        shapedRecipe(fenceGate).key('#', Items.STICK).key('W', input).patternLine("#W#").patternLine("#W#").addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapedPressurePlate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider pressurePlate, IItemProvider input)
    {
        shapedRecipe(pressurePlate).key('#', input).patternLine("##").addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapedSlab(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider slab, IItemProvider input)
    {
        shapedRecipe(slab, 6).key('#', input).patternLine("###").addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapedStairs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider stairs, IItemProvider input)
    {
        shapedRecipe(stairs, 4).key('#', input).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapelessSolidTrapdoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider button, IItemProvider input)
    {
        shapelessRecipe(button).addIngredient(input).addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapedTrapdoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider trapdoor, IItemProvider input)
    {
        shapedRecipe(trapdoor, 2).key('#', input).patternLine("###").patternLine("###").addCriterion("has_input", hasItem(input)).build(recipeConsumer);
    }
    private static void shapedSign(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sign, IItemProvider input)
    {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        shapedRecipe(sign, 3).setGroup("sign").key('#', input).key('X', Items.STICK).patternLine("###").patternLine("###").patternLine(" X ").addCriterion("has_" + s, hasItem(input)).build(recipeConsumer);
    }
    private static void shapelessColoredWool(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredWool, IItemProvider dye)
    {
        shapelessRecipe(coloredWool).addIngredient(dye).addIngredient(Blocks.WHITE_WOOL).setGroup("wool").addCriterion("has_white_wool", hasItem(Blocks.WHITE_WOOL)).build(recipeConsumer);
    }
    private static void shapedCarpet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider carpet, IItemProvider input)
    {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        shapedRecipe(carpet, 3).key('#', input).patternLine("##").setGroup("carpet").addCriterion("has_" + s, hasItem(input)).build(recipeConsumer);
    }
    private static void shapelessColoredCarpet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredCarpet, IItemProvider dye)
    {
        String s = Registry.ITEM.getKey(coloredCarpet.asItem()).getPath();
        String s1 = Registry.ITEM.getKey(dye.asItem()).getPath();
        shapedRecipe(coloredCarpet, 8).key('#', Blocks.WHITE_CARPET).key('$', dye).patternLine("###").patternLine("#$#").patternLine("###").setGroup("carpet").addCriterion("has_white_carpet", hasItem(Blocks.WHITE_CARPET)).addCriterion("has_" + s1, hasItem(dye)).build(recipeConsumer, s + "_from_white_carpet");
    }
    private static void shapedBed(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider bed, IItemProvider wool)
    {
        String s = Registry.ITEM.getKey(wool.asItem()).getPath();
        shapedRecipe(bed).key('#', wool).key('X', ItemTags.PLANKS).patternLine("###").patternLine("XXX").setGroup("bed").addCriterion("has_" + s, hasItem(wool)).build(recipeConsumer);
    }
    private static void shapedColoredBed(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredBed, IItemProvider dye)
    {
        String s = Registry.ITEM.getKey(coloredBed.asItem()).getPath();
        shapelessRecipe(coloredBed).addIngredient(Items.WHITE_BED).addIngredient(dye).setGroup("dyed_bed").addCriterion("has_bed", hasItem(Items.WHITE_BED)).build(recipeConsumer, s + "_from_white_bed");
    }
    private static void shapedBanner(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider banner, IItemProvider input)
    {
        String s = Registry.ITEM.getKey(input.asItem()).getPath();
        shapedRecipe(banner).key('#', input).key('|', Items.STICK).patternLine("###").patternLine("###").patternLine(" | ").setGroup("banner").addCriterion("has_" + s, hasItem(input)).build(recipeConsumer);
    }
    private static void shapedColoredGlass(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredGlass, IItemProvider dye)
    {
        shapedRecipe(coloredGlass, 8).key('#', Blocks.GLASS).key('X', dye).patternLine("###").patternLine("#X#").patternLine("###").setGroup("stained_glass").addCriterion("has_glass", hasItem(Blocks.GLASS)).build(recipeConsumer);
    }
    private static void shapedGlassPane(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider pane, IItemProvider glass)
    {
        shapedRecipe(pane, 16).key('#', glass).patternLine("###").patternLine("###").setGroup("stained_glass_pane").addCriterion("has_glass", hasItem(glass)).build(recipeConsumer);
    }
    private static void shapedColoredPane(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredPane, IItemProvider dye)
    {
        String s = Registry.ITEM.getKey(coloredPane.asItem()).getPath();
        String s1 = Registry.ITEM.getKey(dye.asItem()).getPath();
        shapedRecipe(coloredPane, 8).key('#', Blocks.GLASS_PANE).key('$', dye).patternLine("###").patternLine("#$#").patternLine("###").setGroup("stained_glass_pane").addCriterion("has_glass_pane", hasItem(Blocks.GLASS_PANE)).addCriterion("has_" + s1, hasItem(dye)).build(recipeConsumer, s + "_from_glass_pane");
    }
    private static void shapedColoredTerracotta(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredTerracotta, IItemProvider dye)
    {
        shapedRecipe(coloredTerracotta, 8).key('#', Blocks.TERRACOTTA).key('X', dye).patternLine("###").patternLine("#X#").patternLine("###").setGroup("stained_terracotta").addCriterion("has_terracotta", hasItem(Blocks.TERRACOTTA)).build(recipeConsumer);
    }
    private static void shapedColorConcretePowder(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredConcretePowder, IItemProvider dye)
    {
        shapelessRecipe(coloredConcretePowder, 8).addIngredient(dye).addIngredient(Blocks.SAND, 4).addIngredient(Blocks.GRAVEL, 4).setGroup("concrete_powder").addCriterion("has_sand", hasItem(Blocks.SAND)).addCriterion("has_gravel", hasItem(Blocks.GRAVEL)).build(recipeConsumer);
    }
    protected static EnterBlockTrigger.Instance enteredBlock(Block block)
    {
        return new EnterBlockTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, block, StatePropertiesPredicate.EMPTY);
    }
    protected static InventoryChangeTrigger.Instance hasItem(IItemProvider item)
    {
        return hasItem(ItemPredicate.Builder.create().item(item).build());
    }
    protected static InventoryChangeTrigger.Instance hasItem(ITag<Item> tag)
    {
        return hasItem(ItemPredicate.Builder.create().tag(tag).build());
    }
    protected static InventoryChangeTrigger.Instance hasItem(ItemPredicate... predicate)
    {
        return new InventoryChangeTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, MinMaxBounds.IntBound.UNBOUNDED, MinMaxBounds.IntBound.UNBOUNDED, MinMaxBounds.IntBound.UNBOUNDED, predicate);
    }
}