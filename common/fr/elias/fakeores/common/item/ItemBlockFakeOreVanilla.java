package fr.elias.fakeores.common.item;

import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.common.block.BlockFakeOresVanilla;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockFakeOreVanilla extends ItemBlock
{
    public ItemBlockFakeOreVanilla(Block block)
    {
        super(block);
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        if(stack.getItemDamage() >= 0 && stack.getItemDamage() <= BlockFakeOresVanilla.type.length)
        {
            return "tile." + BlockFakeOresVanilla.type[stack.getItemDamage()];
        }
        else
        {
            return "tile." + FakeOres.fakeOreVanilla.getUnlocalizedName(); // Unknown block, error !
        }
    }
}
