/*package net.zz.wand.recipie;

import net.minecraft.item.Items;
import net.minecraft.recipe.builder.ShapedRecipeBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.ItemPredicate;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.zz.wand.YourModItems;

public class RecipeSetup {
    public static void registerRecipes(Consumer<Recipe<?>> consumer) {
        ShapedRecipeBuilder.create(YourModItems.ACCELERATION_WAND)
                .pattern("123")
                .pattern("456")
                .pattern("789")
                .input('1', Items.DIAMOND)
                .input('2', Items.STICK)
                .input('3', Items.REDSTONE)
                .input('4', Items.IRON_INGOT)
                .input('5', Items.GOLD_INGOT)
                .input('6', Items.NETHER_STAR)
                .input('7', Items.GLOWSTONE_DUST)
                .input('8', Items.LAPIS_LAZULI)
                .input('9', Items.PISTON)
                .criteria("has_items", InventoryChangedCriterion.create(ItemPredicate.Builder.create().items(Items.DIAMOND).build()))
                .offerTo(consumer, new Identifier("your_mod_id", "acceleration_wand_recipe"));
    }
}
*/