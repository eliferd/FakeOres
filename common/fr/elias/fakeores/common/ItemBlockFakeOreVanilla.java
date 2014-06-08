package fr.elias.fakeores.common;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockFakeOreVanilla extends ItemBlock
{
	public ItemBlockFakeOreVanilla(Block block)
	{
		super(block);
	}

	public int getMetadata(int metadata)
	{
		return metadata;
	}

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
