package fr.elias.fakeores.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBossStar extends Item
{
	public ItemBossStar() {
		super();
		// TODO Auto-generated constructor stub
	}
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World par3World, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
    	if(!par3World.isRemote && par3World.getBlock(x, y, z).equals(FakeOres.fd_redobsidian))
		{
			if(par3World.getBlock(x, y, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x - 1, y, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x - 2, y + 1, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x - 2, y + 2, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x - 2, y + 3, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x + 1, y + 1, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x + 1, y + 2, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x + 1, y + 3, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x - 1, y + 4, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 4, z).equals(FakeOres.fd_redobsidian))
			{
				for(int i = 0; i < 3; i++)
				{
					par3World.setBlock(x, y + 1 + i, z, FakeOres.fd_portal);
					par3World.setBlock(x - 1, y + 1 + i, z, FakeOres.fd_portal);
				}
				if(!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
				}
				return true;
			}

			if(par3World.getBlock(x, y, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x + 1, y, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x + 2, y + 1, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x + 2, y + 2, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x + 2, y + 3, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x - 1, y + 1, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x - 1, y + 2, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x - 1, y + 3, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x + 1, y + 4, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 4, z).equals(FakeOres.fd_redobsidian))
			{
				for(int i = 0; i < 3; i++)
				{
					par3World.setBlock(x, y + 1 + i, z, FakeOres.fd_portal);
					par3World.setBlock(x + 1, y + 1 + i, z, FakeOres.fd_portal);
				}
				if(!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
				}
				return true;
			}

			if(par3World.getBlock(x, y, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y, z - 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 1, z - 2).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 2, z - 2).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 3, z - 2).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 1, z + 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 2, z + 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 3, z + 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 4, z - 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 4, z).equals(FakeOres.fd_redobsidian))
			{
				for(int i = 0; i < 3; i++)
				{
					par3World.setBlock(x, y + 1 + i, z, FakeOres.fd_portal);
					par3World.setBlock(x, y + 1 + i, z - 1, FakeOres.fd_portal);
				}
				if(!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
				}
				return true;
			}

			if(par3World.getBlock(x, y, z).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y, z + 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 1, z + 2).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 2, z + 2).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 3, z + 2).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 1, z - 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 2, z - 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 3, z - 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 4, z + 1).equals(FakeOres.fd_redobsidian) && par3World.getBlock(x, y + 4, z).equals(FakeOres.fd_redobsidian))
			{
				for(int i = 0; i < 3; i++)
				{
					par3World.setBlock(x, y + 1 + i, z, FakeOres.fd_portal);
					par3World.setBlock(x, y + 1 + i, z + 1, FakeOres.fd_portal);
				}
				if(!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
				}
				return true;
			}
		}
    	if(par3World.isRemote)
    	{
    		par3World.spawnParticle("largesmoke", x, y, z, hitX, hitY, hitZ);
    	}
    	return false;
    }
}
