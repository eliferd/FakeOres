package fr.elias.fakeores.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockFakeOresDimension extends Block
{

	protected BlockFakeOresDimension(String blockName, String textureName)
	{
		super(Material.rock);
		this.setBlockName(blockName);
		this.setCreativeTab(FakeOres.fakeOresTab);
		this.setBlockTextureName("fakeores:" + textureName);
		this.setHardness(2.5F);
		this.setResistance(5.0F);
	}
    public int quantityDropped(Random rand)
    {
    	if(this == FakeOres.fd_blurk_ore)
    	{
    		return rand.nextInt(1) + 1;
    	}else
        return 1;
    }

    public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_)
    {
    	if(this == FakeOres.fd_rainbow_ore)
    	{
    		return rand.nextBoolean() ? Item.getItemFromBlock(FakeOres.fd_rainbow_ore) : FakeOres.fd_rainbow_ingot;
    	}else
    	{
            return Item.getItemFromBlock(this);
    	}
    }
}
