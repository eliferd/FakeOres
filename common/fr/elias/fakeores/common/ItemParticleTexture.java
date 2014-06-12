package fr.elias.fakeores.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemParticleTexture extends Item 
{
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) 
    {
    	if(entity instanceof EntityPlayer)
    	{
    		if(((EntityPlayer) entity).inventory.hasItem(this))
    		{
    			((EntityPlayer) entity).inventory.consumeInventoryItem(this);
    		}
    		((EntityPlayer) entity).inventoryContainer.detectAndSendChanges();
    	}
    }
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        return false;
    }

}
