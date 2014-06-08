package fr.elias.fakeores.dimension;

import java.util.Random;

import fr.elias.fakeores.common.FakeOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockBase extends Block
{

	public BlockBase(Material material)
	{
		super(material);
		this.setCreativeTab(FakeOres.fakeOresTab);
	}
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		if(this == FakeOres.fd_stone)
		{
			return Item.getItemFromBlock(FakeOres.fd_cobblestone);
		}else
		if(this == FakeOres.fd_grass)
		{
			return Item.getItemFromBlock(FakeOres.fd_dirt);
		}else
		return Item.getItemFromBlock(this);
	}
}
