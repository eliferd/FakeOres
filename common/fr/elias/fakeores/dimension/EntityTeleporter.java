package fr.elias.fakeores.dimension;

import java.util.Iterator;

import fr.elias.fakeores.common.EntityDimensionMob;
import fr.elias.fakeores.common.EntityNopeGrenade;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class EntityTeleporter
{
	public static Entity teleportToDim(Entity entity, int targetDimId)
	{
		if(!entity.worldObj.isRemote && !entity.isDead && (entity instanceof EntityPlayer))
		{
			entity.worldObj.theProfiler.startSection("changeDimension");
			MinecraftServer minecraftserver = MinecraftServer.getServer();
			int dimID = entity.dimension;
			WorldServer worldserver = minecraftserver.worldServerForDimension(dimID);
			WorldServer worldserver1 = minecraftserver.worldServerForDimension(targetDimId);
			entity.dimension = targetDimId;

			entity.worldObj.removeEntity(entity);
			entity.isDead = false;
			entity.worldObj.theProfiler.startSection("reposition");
			minecraftserver.getConfigurationManager().transferEntityToWorld(entity, dimID, worldserver, worldserver1, new FD_Teleporter(worldserver1));
			entity.worldObj.theProfiler.endStartSection("reloading");
			Entity entity2 = EntityList.createEntityByName(EntityList.getEntityString(entity), worldserver1);

			if(entity2 != null)
			{
				entity2.copyDataFrom(entity, true);
				worldserver1.spawnEntityInWorld(entity2);
			}

			entity.isDead = true;
			entity.worldObj.theProfiler.endSection();
			worldserver.resetUpdateEntityTick();
			worldserver1.resetUpdateEntityTick();
			entity.worldObj.theProfiler.endSection();

			if(entity instanceof EntityItem)
			{
				if(!entity.worldObj.isRemote)
				{
					EntityItem item = (EntityItem)entity;
					Iterator iterator = entity.worldObj.getEntitiesWithinAABB(EntityItem.class, entity.boundingBox.expand(0.5D, 0.0D, 0.5D)).iterator();

					while(iterator.hasNext())
					{
						EntityItem entityitem = (EntityItem)iterator.next();
						item.combineItems(entityitem);
					}
				}
			}
		}
		return entity;
	}
}
