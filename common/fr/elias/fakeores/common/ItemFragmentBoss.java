package fr.elias.fakeores.common;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

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
    public boolean onItemUse(ItemStack stack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        stack.stackSize--;
        if (par3World.isRemote)
        {
            return true;
        }
        else
        {
    		EntityOresBoss boss = new EntityOresBoss(par3World);
    		boss.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, MathHelper.wrapAngleTo180_float(par3World.rand.nextFloat() * 360.0F), 0.0F);
    		par3World.spawnEntityInWorld(boss);
        	return true;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }
}
