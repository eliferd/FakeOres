package fr.elias.fakeores.dimension;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.elias.fakeores.common.FakeOres;

public class FD_BlockPortal extends BlockBase
{

	public FD_BlockPortal()
	{
		super(Material.portal);
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeGlass);
		this.setLightLevel(0.75F);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockaccess, int x, int y, int z)
	{
		float f;
		float f1;

		if(!blockaccess.getBlock(x - 1, y, z).equals(this) && !blockaccess.getBlock(x + 1, y, z).equals(this))
		{
			f = 0.125F;
			f1 = 0.5F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
		else
		{
			f = 0.5F;
			f1 = 0.125F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
	}
	
	@Override
	public void setBlockBoundsForItemRender()
	{
		float f1 = 0.125F;
		this.setBlockBounds(0, 0.0F, 0.5F - f1, 1F, 1.0F, 0.5F + f1);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		int y2 = y;
		while(world.getBlock(x, y2, z).equals(this))
		{
			y2--;
		}
		if(!world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian))
		{
			world.setBlockToAir(x, y, z);
		}
		int y3 = y2 + 1;
		boolean portalIsGood = false;
		if(world.getBlock(x, y3, z + 1).equals(this))
		{
			portalIsGood = (world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 1, z + 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 2, z + 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 3, z + 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 1, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 2, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 3, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z).equals(FakeOres.fd_redobsidian));
		}
		else if(world.getBlock(x, y3, z - 1).equals(this))
		{
			portalIsGood = (world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 1, z - 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 2, z - 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 3, z - 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 1, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 2, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 3, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z).equals(FakeOres.fd_redobsidian));
		}
		else if(world.getBlock(x + 1, y3, z).equals(this))
		{
			portalIsGood = (world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 2, y2 + 1, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 2, y2 + 2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 2, y2 + 3, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 1, y2 + 1, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 1, y2 + 2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 1, y2 + 3, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 4, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z).equals(FakeOres.fd_redobsidian));
		}
		else if(world.getBlock(x - 1, y3, z).equals(this))
		{
			portalIsGood = (world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 1, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 2, y2 + 1, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 2, y2 + 2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 2, y2 + 3, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 1, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 3, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 4, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z).equals(FakeOres.fd_redobsidian));
		}

		if(!portalIsGood)
		{
			world.setBlockToAir(x, y, z);
		}
	}
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 0;
	}
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if((entity.ridingEntity == null) && (entity.riddenByEntity == null))
		{
			if(entity.dimension != FakeOres.dimID)
			{
				if(entity instanceof EntityPlayerMP)
				{
					EntityPlayerMP player = (EntityPlayerMP)entity;
					if(player.timeUntilPortal > 0)
					{
						player.timeUntilPortal = 10;
					}
					else
					{
						player.timeUntilPortal = 10;
						player
						.mcServer
						.getConfigurationManager()
						.transferPlayerToDimension
						(player, 
								FakeOres.dimID, 
								new FD_Teleporter(
										player.
										mcServer
										.worldServerForDimension(
												FakeOres.dimID
												)));
					}
				}
				else
				{
					EntityTeleporter.teleportToDim(entity, FakeOres.dimID);
				}
			}
			else
			{
				if(entity instanceof EntityPlayerMP)
				{
					EntityPlayerMP player = (EntityPlayerMP)entity;
					if(player.timeUntilPortal > 0)
					{
						player.timeUntilPortal = 10;
					}
					else
					{
						player.timeUntilPortal = 10;
						player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new FD_Teleporter(player.mcServer.worldServerForDimension(0)));
					}
				}
				else
				{
					EntityTeleporter.teleportToDim(entity, 0);
				}
			}
		}

	}
	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return null;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		super.breakBlock(world, x, y, z, block, metadata);
		if(world.getBlock(x, y + 1, z).equals(this))
		{
			world.setBlockToAir(x, y + 1, z);
		}
		if(world.getBlock(x, y - 1, z).equals(this))
		{
			world.setBlockToAir(x, y - 1, z);
		}
		if(world.getBlock(x + 1, y, z).equals(this))
		{
			world.setBlockToAir(x + 1, y, z);
		}
		if(world.getBlock(x - 1, y, z).equals(this))
		{
			world.setBlockToAir(x - 1, y, z);
		}
		if(world.getBlock(x, y, z + 1).equals(this))
		{
			world.setBlockToAir(x, y, z + 1);
		}
		if(world.getBlock(x, y, z - 1).equals(this))
		{
			world.setBlockToAir(x, y, z - 1);
		}
	}
}
