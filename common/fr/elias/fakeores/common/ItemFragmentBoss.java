package fr.elias.fakeores.common;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFragmentBoss extends Item {

	public ItemFragmentBoss() {
		super();
	}
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
    {
    	par3List.add("MAKE SURE YOU'RE IN A SAFE AREA TO SPAWN ORE BOSS !");
    	super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
    }
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        stack.stackSize--;
        if (!worldIn.isRemote)
        {
    		EntityOresBoss boss = new EntityOresBoss(worldIn);
    		boss.setLocationAndAngles((double)hitX + 0.5D, (double)hitY + 0.5D, (double)hitZ + 0.5D, MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F), 0.0F);
    		worldIn.spawnEntityInWorld(boss);
        	return true;
        }
		return true;
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.EPIC;
    }
}
