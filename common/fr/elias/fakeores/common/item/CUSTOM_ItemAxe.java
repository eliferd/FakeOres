package fr.elias.fakeores.common.item;

import com.google.common.collect.Sets;

import fr.elias.fakeores.common.FakeOres;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class CUSTOM_ItemAxe extends ItemTool
{
    private static final Set field_150917_c = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

    public CUSTOM_ItemAxe(ToolMaterial p_i45333_2_)
    {
        super(0.0F, p_i45333_2_, field_150917_c);
        this.setCreativeTab(FakeOres.fakeOresTab);
    }

    @Override
    public float getStrVsBlock(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? super.getStrVsBlock(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }
}