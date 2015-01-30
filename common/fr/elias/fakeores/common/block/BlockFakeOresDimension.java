package fr.elias.fakeores.common.block;

import fr.elias.fakeores.common.FakeOres;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockFakeOresDimension extends Block
{
    protected BlockFakeOresDimension(String blockName)
    {
        super(Material.rock);
        this.setUnlocalizedName(blockName);
        this.setCreativeTab(FakeOres.fakeOresTab);
        this.setHardness(2.5F);
        this.setResistance(5.0F);
    }

    @Override
    public int quantityDropped(Random rand)
    {
        if(this == FakeOres.fd_blurk_ore)
        {
            return rand.nextInt(1) + 1;
        }
        else
            return 1;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int p_149650_3_)
    {
        if(this == FakeOres.fd_rainbow_ore)
        {
            return rand.nextBoolean() ? Item.getItemFromBlock(FakeOres.fd_rainbow_ore) : FakeOres.fd_rainbow_ingot;
        }
        else
        {
            return Item.getItemFromBlock(this);
        }
    }
}