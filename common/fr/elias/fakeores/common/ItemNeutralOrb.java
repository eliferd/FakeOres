package fr.elias.fakeores.common;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemNeutralOrb extends Item 
{
	public ItemNeutralOrb()
	{
		super();
	}
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_)
    {
        p_77644_1_.stackSize--;
        EntityPlayer player = (EntityPlayer)p_77644_3_;
        if(!(p_77644_2_ instanceof EntityOres) && !(p_77644_2_ instanceof EntityOresBoss))
        {
        	if(player.inventory.hasItem(Items.gunpowder))
        	{
                p_77644_2_.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)p_77644_3_), Float.MAX_VALUE);
                player.inventory.consumeInventoryItem(Items.gunpowder);
        	}else 
        	{
                p_77644_2_.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)p_77644_3_), Float.MIN_VALUE);
        	}
        }
        return true;
    }
}
