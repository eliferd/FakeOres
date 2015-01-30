package fr.elias.fakeores.common.item;

import fr.elias.fakeores.common.entity.EntityNopeGrenade;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNopeGrenade extends Item
{
    public ItemNopeGrenade()
    {
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        EntityNopeGrenade grenade = new EntityNopeGrenade(world, entityplayer);
        if(!world.isRemote)
        {
            world.spawnEntityInWorld(grenade);
        }
        if(!entityplayer.capabilities.isCreativeMode)
        {
            --itemstack.stackSize;
        }
        return itemstack;
    }
}
