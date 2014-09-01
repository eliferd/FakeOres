package fr.elias.fakeores.common;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ItemAirOrb extends Item 
{
	public String type;
	public ItemAirOrb(String s) 
	{
		super();
		type = s;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) 
	{
		player.motionY += 0.5D;
		return itemstack;
	}

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List list, boolean p_77624_4_)
    {
    	if(Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
    	{
        	list.add("Just hold item in your hand");
        	list.add("and move near any entity (except slime), ENJOY ! :D");	
    	}else{
    		list.add("Press 'SHIFT' for more information.");
    	}
    }
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean isHeldedByPlayer)
	{
		EntityPlayer player = (EntityPlayer) entity;
		super.onUpdate(itemstack, world, entity, slot, isHeldedByPlayer);
		if(type == "normal")
		{
			List list = world.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox(player.posX, player.posY, player.posZ, player.posX + 1, player.posY + 1, player.posZ + 1).expand(6D, 4D, 6D));
			if (player != null) 
			{
				for (int i = 0; i < list.size(); i++) 
				{
					Entity entity2 = (Entity) list.get(i);
					if (!list.isEmpty() && !(entity2 instanceof EntityPlayer) && isHeldedByPlayer) 
					{
						double d = entity2.posX - player.posX;
						double d1 = entity2.posZ - player.posZ;
						entity2.motionX = d;
						entity2.motionZ = d1;
						if (world.rand.nextInt(20) == 0) 
						{
							itemstack.damageItem(2, player);
						}
					}
				}
				
			}
		}
		if(type == "reversed")
		{
			List list = world.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox(player.posX, player.posY, player.posZ, player.posX + 1, player.posY + 1, player.posZ + 1).expand(6D, 4D, 6D));
			if (player != null) 
			{
				for (int i = 0; i < list.size(); i++) 
				{
					Entity entity2 = (Entity) list.get(i);
					if (!list.isEmpty() && !(entity2 instanceof EntityPlayer) && isHeldedByPlayer) 
					{
						double d = player.posX - entity2.posX;
						double d1 = player.posZ - entity2.posZ;
						double d2 = player.posY - entity2.posY;
						entity2.motionX = d;
						entity2.motionZ = d1;
						if(!player.onGround)
						{
							entity2.motionY = d2;
						}
						entity2.fallDistance = player.fallDistance = Float.MIN_VALUE;
						if (world.rand.nextInt(20) == 0) 
						{
							itemstack.damageItem(2, player);
						}
					}
				}
			}
		}
	}
}
