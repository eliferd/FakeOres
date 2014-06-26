package fr.elias.fakeores.common;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class CUSTOM_ItemPickaxe extends ItemTool 
{
    private static final Set field_150915_c = Sets.newHashSet(new Block[] {FakeOres.fd_stone, FakeOres.fd_cobblestone, Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
	protected CUSTOM_ItemPickaxe(ToolMaterial p_i45333_2_) 
	{
		super(0.5F, p_i45333_2_, field_150915_c);
		this.setCreativeTab(FakeOres.fakeOresTab);
	}
	
    public boolean func_150897_b(Block block)
    {
    	if(block == Blocks.obsidian)
    	{
    		return this.toolMaterial.getHarvestLevel() == 3;
    	}else 
    	if(block != Blocks.diamond_block && block != Blocks.diamond_ore)
    	{
    		if(block != Blocks.emerald_ore && block != Blocks.emerald_block)
    		{
    			if(block != Blocks.gold_block && block != Blocks.gold_ore && block != FakeOres.fd_rainbow_ore && block != FakeOres.fd_rainbow_block)
    			{
    				if(block != Blocks.iron_block && block != Blocks.iron_ore && block != FakeOres.fd_purlight_ore && block != FakeOres.fd_purlight_block)
    				{
    					if(block != Blocks.lapis_block && block != Blocks.lapis_ore && block != FakeOres.fd_daren_ore && block != FakeOres.fd_daren_block)
    					{
    						if(block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore && block != FakeOres.fd_blurk_ore && block != FakeOres.fd_blurk_block)
    						{
    							if(block.getMaterial() == Material.rock)
    							{
    								return true;
    							}else if(block.getMaterial() == Material.iron)
    							{
    								return true;
    							}else {
    								return block.getMaterial() == Material.anvil;
    							}
    						}else
    						{
    							return this.toolMaterial.getHarvestLevel() >= 2;
    						}
    					}else {
    						return this.toolMaterial.getHarvestLevel() >= 1;
    					}
    				}else {
    					return this.toolMaterial.getHarvestLevel() >= 1;
    				}
    			}else {
    				return this.toolMaterial.getHarvestLevel() >= 2;
    			}
    		}else {
    			return this.toolMaterial.getHarvestLevel() >= 2;
    		}
    	}else {
    		return this.toolMaterial.getHarvestLevel() >= 2;
    	}
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.iron && p_150893_2_.getMaterial() != Material.anvil && p_150893_2_.getMaterial() != Material.rock ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }
}
