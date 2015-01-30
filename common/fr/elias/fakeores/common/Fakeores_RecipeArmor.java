package fr.elias.fakeores.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class Fakeores_RecipeArmor
{
    private String[][] recipePatterns = new String[][] { {"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] recipeItems;

    public Fakeores_RecipeArmor()
    {
        this.recipeItems = new Object[][] { {FakeOres.fd_blurk_ingot}, {FakeOres.fd_blurk_helmet}, {FakeOres.fd_blurk_chestplate}, {FakeOres.fd_blurk_leggins}, {FakeOres.fd_blurk_boots}};
    }

    /**
     * Adds the armor recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager p_77609_1_)
    {
        for(int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for(int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                p_77609_1_.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], 'X', object});
            }
        }
    }
}