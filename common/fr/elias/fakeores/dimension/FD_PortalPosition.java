package fr.elias.fakeores.dimension;

import net.minecraft.util.BlockPos;

public class FD_PortalPosition extends BlockPos
{
    public long lastUpdateTime;

    public FD_PortalPosition(BlockPos pos, long creationTime)
    {
        super(pos.getX(), pos.getY(), pos.getZ());
        this.lastUpdateTime = creationTime;
    }
}