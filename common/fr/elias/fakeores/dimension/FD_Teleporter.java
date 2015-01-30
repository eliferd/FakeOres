package fr.elias.fakeores.dimension;

import fr.elias.fakeores.common.FakeOres;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class FD_Teleporter extends Teleporter
{
    private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap destinationCoordinateCache = new LongHashMap();

    private final List destinationCoordinateKeys = new ArrayList();

    public FD_Teleporter(WorldServer worldServer)
    {
        super(worldServer);
        this.worldServerInstance = worldServer;
        this.random = new Random(worldServer.getSeed());
    }

    public void placeInPortal(Entity entity, double x, double y, double z, float rotationYaw)
    {
        if(this.worldServerInstance.provider.getDimensionId() != 1)
        {
            if(!this.placeInExistingPortal(entity, x, y, z, rotationYaw))
            {
                this.makePortal(entity);
                this.placeInExistingPortal(entity, x, y, z, rotationYaw);
            }
        }
        else
        {
            int i = MathHelper.floor_double(entity.posX);
            int j = MathHelper.floor_double(entity.posY) - 1;
            int k = MathHelper.floor_double(entity.posZ);
            byte b0 = 1;
            byte b1 = 0;
            for(int l = -2; l <= 2; ++l)
            {
                for(int i1 = -2; i1 <= 2; ++i1)
                {
                    for(int j1 = -1; j1 < 3; ++j1)
                    {
                        int k1 = i + i1 * b0 + l * b1;
                        int l1 = j + j1;
                        int i2 = k + i1 * b1 - l * b0;
                        boolean flag = j1 < 0;

                        this.worldServerInstance.setBlockState(new BlockPos(k1, l1, i2), flag ? FakeOres.fd_redobsidian.getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }
            entity.setLocationAndAngles(i, j, k, entity.rotationYaw, 0.0F);
            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        }
    }

    public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float rotationYaw)
    {
        boolean flag = true;
        double d3 = -1.0D;
        int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_double(entity.posZ);
        Object object = BlockPos.ORIGIN;
        boolean flag1 = true;
        long k = ChunkCoordIntPair.chunkXZ2Int(i, j);

        if(this.destinationCoordinateCache.containsItem(k))
        {
            FD_PortalPosition portalposition = (FD_PortalPosition)this.destinationCoordinateCache.getValueByKey(k);
            d3 = 0.0D;
            object = portalposition;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag1 = false;
        }
        else
        {
            BlockPos pos = new BlockPos(entity);
            for(int l = -128; l <= 128; ++l)
            {
                BlockPos pos1;
                for(int i1 = -128; i1 <= 128; ++i1)
                {
                    for(BlockPos pos2 = pos.add(l, this.worldServerInstance.getActualHeight() - 1 - pos.getY(), i1); pos2.getY() >= 0; pos2 = pos1)
                    {
                        pos1 = pos2.down();
                        if(this.worldServerInstance.getBlockState(pos2).getBlock() == FakeOres.fd_portal)
                        {
                            while(this.worldServerInstance.getBlockState(pos1 = pos2.down()).getBlock() == FakeOres.fd_portal)
                            {
                                pos2 = pos1;
                            }
                            double d7 = pos2.distanceSq(pos1);
                            if(d3 < 0.0D || d7 < d3)
                            {
                                d3 = d7;
                                object = pos2;
                            }
                        }
                    }
                }
            }
        }
        if(d3 >= 0.0D)
        {
            if(flag)
            {
                this.destinationCoordinateCache.add(k, new FD_PortalPosition((BlockPos)object, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(k));
            }
            double d8 = ((BlockPos)object).getX() + 0.5D;
            double d9 = ((BlockPos)object).getY() + 0.5D;
            double d4 = ((BlockPos)object).getZ() + 0.5D;
            EnumFacing face = null;
            if(this.worldServerInstance.getBlockState(((BlockPos)object).west()).getBlock() == FakeOres.fd_portal)
            {
                face = EnumFacing.NORTH;
            }
            if(this.worldServerInstance.getBlockState(((BlockPos)object).east()).getBlock() == FakeOres.fd_portal)
            {
                face = EnumFacing.SOUTH;
            }
            if(this.worldServerInstance.getBlockState(((BlockPos)object).north()).getBlock() == FakeOres.fd_portal)
            {
                face = EnumFacing.EAST;
            }
            if(this.worldServerInstance.getBlockState(((BlockPos)object).south()).getBlock() == FakeOres.fd_portal)
            {
                face = EnumFacing.WEST;
            }
            EnumFacing face1 = EnumFacing.getHorizontal(entity.getTeleportDirection());
            if(face != null)
            {
                EnumFacing face2 = face.rotateYCCW();
                BlockPos pos3 = ((BlockPos)object).offset(face);
                boolean flag2 = this.func_180265_a(pos3);
                boolean flag3 = this.func_180265_a(pos3.offset(face2));
                if(flag3 && flag2)
                {
                    object = ((BlockPos)object).offset(face2);
                    face = face.getOpposite();
                    face2 = face2.getOpposite();
                    BlockPos pos4 = ((BlockPos)object).offset(face);
                    flag2 = this.func_180265_a(pos4);
                    flag3 = this.func_180265_a(pos4.offset(face2));
                }
                float f1 = 0.5F;
                float f2 = 0.5F;
                if(!flag3 && flag2)
                {
                    f1 = 1.0F;
                }
                else if(flag3 && !flag2)
                {
                    f1 = 0.0F;
                }
                else if(flag3 && flag2)
                {
                    f2 = 0.0F;
                }
                d8 = ((BlockPos)object).getX() + 0.5D;
                d9 = ((BlockPos)object).getY() + 0.5D;
                d4 = ((BlockPos)object).getZ() + 0.5D;
                d8 += face2.getFrontOffsetX() * f1 + face.getFrontOffsetX() * f2;
                d4 += face2.getFrontOffsetZ() * f1 + face.getFrontOffsetZ() * f2;
                float f3 = 0.0F;
                float f4 = 0.0F;
                float f5 = 0.0F;
                float f6 = 0.0F;
                if(face == face1)
                {
                    f3 = 1.0F;
                    f4 = 1.0F;
                }
                else if(face == face1.getOpposite())
                {
                    f3 = -1.0F;
                    f4 = -1.0F;
                }
                else if(face == face1.rotateY())
                {
                    f5 = 1.0F;
                    f6 = -1.0F;
                }
                else
                {
                    f5 = -1.0F;
                    f6 = 1.0F;
                }
                double d10 = entity.motionX;
                double d11 = entity.motionZ;
                entity.motionX = d10 * f3 + d11 * f6;
                entity.motionZ = d10 * f5 + d11 * f4;
                entity.rotationYaw = rotationYaw - face1.getHorizontalIndex() * 90 + face.getHorizontalIndex() * 90;
            }
            else
            {
                entity.motionX = entity.motionY = entity.motionZ = 0.0D;
            }
            entity.setLocationAndAngles(d8, d9, d4, entity.rotationYaw, entity.rotationPitch);
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean func_180265_a(BlockPos pos)
    {
        return !this.worldServerInstance.isAirBlock(pos) || !this.worldServerInstance.isAirBlock(pos.up());
    }

    @Override
    public boolean makePortal(Entity entity)
    {
        byte b0 = 16;
        double d0 = -1.0D;
        int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_double(entity.posY);
        int k = MathHelper.floor_double(entity.posZ);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.random.nextInt(4);
        int i2;
        double d1;
        int k2;
        double d2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        double d3;
        double d4;
        for(i2 = i - b0; i2 <= i + b0; ++i2)
        {
            d1 = i2 + 0.5D - entity.posX;
            for(k2 = k - b0; k2 <= k + b0; ++k2)
            {
                d2 = k2 + 0.5D - entity.posZ;
                label274:

                for(i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3)
                {
                    if(this.worldServerInstance.isAirBlock(new BlockPos(i2, i3, k2)))
                    {
                        while(i3 > 0 && this.worldServerInstance.isAirBlock(new BlockPos(i2, i3 - 1, k2)))
                        {
                            --i3;
                        }
                        for(j3 = l1; j3 < l1 + 4; ++j3)
                        {
                            k3 = j3 % 2;
                            l3 = 1 - k3;
                            if(j3 % 4 >= 2)
                            {
                                k3 = -k3;
                                l3 = -l3;
                            }
                            for(i4 = 0; i4 < 3; ++i4)
                            {
                                for(j4 = 0; j4 < 4; ++j4)
                                {
                                    for(k4 = -1; k4 < 4; ++k4)
                                    {
                                        l4 = i2 + (j4 - 1) * k3 + i4 * l3;
                                        i5 = i3 + k4;
                                        int j5 = k2 + (j4 - 1) * l3 - i4 * k3;

                                        if(k4 < 0 && !this.worldServerInstance.getBlockState(new BlockPos(l4, i5, j5)).getBlock().getMaterial().isSolid() || k4 >= 0 && !this.worldServerInstance.isAirBlock(new BlockPos(l4, i5, j5)))
                                        {
                                            continue label274;
                                        }
                                    }
                                }
                            }
                            d3 = i3 + 0.5D - entity.posY;
                            d4 = d1 * d1 + d3 * d3 + d2 * d2;

                            if(d0 < 0.0D || d4 < d0)
                            {
                                d0 = d4;
                                l = i2;
                                i1 = i3;
                                j1 = k2;
                                k1 = j3 % 4;
                            }
                        }
                    }
                }
            }
        }
        if(d0 < 0.0D)
        {
            for(i2 = i - b0; i2 <= i + b0; ++i2)
            {
                d1 = i2 + 0.5D - entity.posX;
                for(k2 = k - b0; k2 <= k + b0; ++k2)
                {
                    d2 = k2 + 0.5D - entity.posZ;
                    label222:

                    for(i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3)
                    {
                        if(this.worldServerInstance.isAirBlock(new BlockPos(i2, i3, k2)))
                        {
                            while(i3 > 0 && this.worldServerInstance.isAirBlock(new BlockPos(i2, i3 - 1, k2)))
                            {
                                --i3;
                            }

                            for(j3 = l1; j3 < l1 + 2; ++j3)
                            {
                                k3 = j3 % 2;
                                l3 = 1 - k3;

                                for(i4 = 0; i4 < 4; ++i4)
                                {
                                    for(j4 = -1; j4 < 4; ++j4)
                                    {
                                        k4 = i2 + (i4 - 1) * k3;
                                        l4 = i3 + j4;
                                        i5 = k2 + (i4 - 1) * l3;

                                        if(j4 < 0 && !this.worldServerInstance.getBlockState(new BlockPos(k4, l4, i5)).getBlock().getMaterial().isSolid() || j4 >= 0 && !this.worldServerInstance.isAirBlock(new BlockPos(k4, l4, i5)))
                                        {
                                            continue label222;
                                        }
                                    }
                                }

                                d3 = i3 + 0.5D - entity.posY;
                                d4 = d1 * d1 + d3 * d3 + d2 * d2;

                                if(d0 < 0.0D || d4 < d0)
                                {
                                    d0 = d4;
                                    l = i2;
                                    i1 = i3;
                                    j1 = k2;
                                    k1 = j3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int k5 = l;
        int j2 = i1;
        k2 = j1;
        int l5 = k1 % 2;
        int l2 = 1 - l5;

        if(k1 % 4 >= 2)
        {
            l5 = -l5;
            l2 = -l2;
        }

        if(d0 < 0.0D)
        {
            i1 = MathHelper.clamp_int(i1, 70, this.worldServerInstance.getActualHeight() - 10);
            j2 = i1;

            for(i3 = -1; i3 <= 1; ++i3)
            {
                for(j3 = 1; j3 < 3; ++j3)
                {
                    for(k3 = -1; k3 < 3; ++k3)
                    {
                        l3 = k5 + (j3 - 1) * l5 + i3 * l2;
                        i4 = j2 + k3;
                        j4 = k2 + (j3 - 1) * l2 - i3 * l5;
                        boolean flag = k3 < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(l3, i4, j4), flag ? FakeOres.fd_redobsidian.getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }
        }

        IBlockState iblockstate = FakeOres.fd_portal.getDefaultState().withProperty(FD_BlockPortal.AXIS, l5 != 0 ? Axis.X : Axis.Z);

        for(j3 = 0; j3 < 4; ++j3)
        {
            for(k3 = 0; k3 < 4; ++k3)
            {
                for(l3 = -1; l3 < 4; ++l3)
                {
                    i4 = k5 + (k3 - 1) * l5;
                    j4 = j2 + l3;
                    k4 = k2 + (k3 - 1) * l2;
                    boolean flag1 = k3 == 0 || k3 == 3 || l3 == -1 || l3 == 3;
                    this.worldServerInstance.setBlockState(new BlockPos(i4, j4, k4), flag1 ? FakeOres.fd_redobsidian.getDefaultState() : iblockstate, 2);
                }
            }
            for(k3 = 0; k3 < 4; ++k3)
            {
                for(l3 = -1; l3 < 4; ++l3)
                {
                    i4 = k5 + (k3 - 1) * l5;
                    j4 = j2 + l3;
                    k4 = k2 + (k3 - 1) * l2;
                    this.worldServerInstance.notifyNeighborsOfStateChange(new BlockPos(i4, j4, k4), this.worldServerInstance.getBlockState(new BlockPos(i4, j4, k4)).getBlock());
                }
            }
        }
        return true;
    }

    @Override
    public void removeStalePortalLocations(long time)
    {
        if(time % 100L == 0L)
        {
            Iterator iterator = this.destinationCoordinateKeys.iterator();
            long j = time - 600L;
            while(iterator.hasNext())
            {
                Long olong = (Long)iterator.next();
                FD_PortalPosition portalposition = (FD_PortalPosition)this.destinationCoordinateCache.getValueByKey(olong.longValue());
                if(portalposition == null || portalposition.lastUpdateTime < j)
                {
                    iterator.remove();
                    this.destinationCoordinateCache.remove(olong.longValue());
                }
            }
        }
    }
}