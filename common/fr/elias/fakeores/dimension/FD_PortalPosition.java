package fr.elias.fakeores.dimension;

import net.minecraft.util.ChunkCoordinates;

public class FD_PortalPosition extends ChunkCoordinates
{
	public long time;
	final FD_Teleporter teleporter;
	
	public FD_PortalPosition(FD_Teleporter fd_teleporter, int x, int y, int z, long creationTime)
	{
		super(x, y, z);
		this.teleporter = fd_teleporter;
		this.time = creationTime;
	}
	
	@Override
	public int compareTo(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
