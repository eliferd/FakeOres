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
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityTarget, EntityLivingBase playerEntity)
    {
        itemstack.stackSize--;
        EntityPlayer player = (EntityPlayer)playerEntity;
        if(!(entityTarget instanceof EntityOres) && !(entityTarget instanceof EntityOresBoss))
        {
        	if(player.inventory.hasItem(Items.gunpowder))
        	{
                entityTarget.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)playerEntity), Float.MAX_VALUE);
                player.inventory.consumeInventoryItem(Items.gunpowder);
        	}else 
        	{
                entityTarget.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)playerEntity), Float.MIN_VALUE);
        	}
        }
        return true;
    }
}
