package fr.elias.fakeores.dimension;

import fr.elias.fakeores.common.FakeOres;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FD_BlockPortal extends BlockBase
{
    public static final PropertyEnum AXIS = PropertyEnum.create("axis", Axis.class, new Axis[] {Axis.X, Axis.Z});

    public FD_BlockPortal()
    {
        super(Material.portal);
        this.setTickRandomly(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, Axis.X));
        this.setStepSound(Block.soundTypeGlass);
        this.setLightLevel(0.75F);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);

        if(worldIn.provider.isSurfaceWorld() && worldIn.getGameRules().getGameRuleBooleanValue("doMobSpawning") && rand.nextInt(2000) < worldIn.getDifficulty().getDifficultyId())
        {
            int i = pos.getY();
            BlockPos blockpos1;

            for(blockpos1 = pos; !World.doesBlockHaveSolidTopSurface(worldIn, blockpos1) && blockpos1.getY() > 0; blockpos1 = blockpos1.down())
            {
                ;
            }

            if(i > 0 && !worldIn.getBlockState(blockpos1.up()).getBlock().isNormalCube())
            {
                Entity entity = ItemMonsterPlacer.spawnCreature(worldIn, 57, blockpos1.getX() + 0.5D, blockpos1.getY() + 1.1D, blockpos1.getZ() + 0.5D);

                if(entity != null)
                {
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        Axis axis = (Axis)worldIn.getBlockState(pos).getValue(AXIS);
        float f = 0.125F;
        float f1 = 0.125F;

        if(axis == Axis.X)
        {
            f = 0.5F;
        }

        if(axis == Axis.Z)
        {
            f1 = 0.5F;
        }

        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    public static int getMetaForAxis(Axis axis)
    {
        return axis == Axis.X ? 1 : (axis == Axis.Z ? 2 : 0);
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }

    public boolean func_176548_d(World worldIn, BlockPos p_176548_2_)
    {
        FD_BlockPortal.Size size = new FD_BlockPortal.Size(worldIn, p_176548_2_, Axis.X);

        if(size.func_150860_b() && size.field_150864_e == 0)
        {
            size.func_150859_c();
            return true;
        }
        else
        {
            FD_BlockPortal.Size size1 = new FD_BlockPortal.Size(worldIn, p_176548_2_, Axis.Z);

            if(size1.func_150860_b() && size1.field_150864_e == 0)
            {
                size1.func_150859_c();
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        Axis axis = (Axis)state.getValue(AXIS);
        FD_BlockPortal.Size size;

        if(axis == Axis.X)
        {
            size = new FD_BlockPortal.Size(worldIn, pos, Axis.X);

            if(!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g)
            {
                worldIn.setBlockState(pos, Blocks.air.getDefaultState());
            }
        }
        else if(axis == Axis.Z)
        {
            size = new FD_BlockPortal.Size(worldIn, pos, Axis.Z);

            if(!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g)
            {
                worldIn.setBlockState(pos, Blocks.air.getDefaultState());
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        Axis axis = null;
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if(worldIn.getBlockState(pos).getBlock() == this)
        {
            axis = (Axis)iblockstate.getValue(AXIS);

            if(axis == null)
            {
                return false;
            }

            if(axis == Axis.Z && side != EnumFacing.EAST && side != EnumFacing.WEST)
            {
                return false;
            }

            if(axis == Axis.X && side != EnumFacing.SOUTH && side != EnumFacing.NORTH)
            {
                return false;
            }
        }

        boolean flag = worldIn.getBlockState(pos.west()).getBlock() == this && worldIn.getBlockState(pos.west(2)).getBlock() != this;
        boolean flag1 = worldIn.getBlockState(pos.east()).getBlock() == this && worldIn.getBlockState(pos.east(2)).getBlock() != this;
        boolean flag2 = worldIn.getBlockState(pos.north()).getBlock() == this && worldIn.getBlockState(pos.north(2)).getBlock() != this;
        boolean flag3 = worldIn.getBlockState(pos.south()).getBlock() == this && worldIn.getBlockState(pos.south(2)).getBlock() != this;
        boolean flag4 = flag || flag1 || axis == Axis.X;
        boolean flag5 = flag2 || flag3 || axis == Axis.Z;
        return flag4 && side == EnumFacing.WEST ? true : (flag4 && side == EnumFacing.EAST ? true : (flag5 && side == EnumFacing.NORTH ? true : flag5 && side == EnumFacing.SOUTH));
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 0;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if(entityIn.ridingEntity == null && entityIn.riddenByEntity == null)
        {
            entityIn.setInPortal();
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AXIS, (meta & 3) == 2 ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if(rand.nextInt(100) == 0)
        {
            worldIn.playSound(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "portal.portal", 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 4; ++i)
        {
            double d0 = pos.getX() + rand.nextFloat();
            double d1 = pos.getY() + rand.nextFloat();
            double d2 = pos.getZ() + rand.nextFloat();
            double d3 = (rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = (rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = (rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;

            if(worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this)
            {
                d0 = pos.getX() + 0.5D + 0.25D * j;
                d3 = rand.nextFloat() * 2.0F * j;
            }
            else
            {
                d2 = pos.getZ() + 0.5D + 0.25D * j;
                d5 = rand.nextFloat() * 2.0F * j;
            }

            worldIn.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5, new int[0]);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return getMetaForAxis((EnumFacing.Axis)state.getValue(AXIS));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return null;
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {AXIS});
    }

    /*
     * @Override public void onNeighborBlockChange(World world, int x, int y, int z, Block block) { int y2 = y; while(world.getBlock(x, y2, z).equals(this)) { y2--; } if(!world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian)) { world.setBlockToAir(x, y, z); } int y3 = y2 + 1; boolean portalIsGood = false; if(world.getBlock(x, y3, z + 1).equals(this)) { portalIsGood = (world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 1, z + 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 2, z + 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 3, z + 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 1, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 2, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 3, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z).equals(FakeOres.fd_redobsidian)); } else if(world.getBlock(x, y3, z - 1).equals(this)) { portalIsGood = (world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2, z - 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 1, z - 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 2, z - 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 3, z - 2).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 1, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 2, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 3, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z + 1).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z).equals(FakeOres.fd_redobsidian)); } else if(world.getBlock(x + 1, y3, z).equals(this)) { portalIsGood = (world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 2, y2 + 1, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 2, y2 + 2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 2, y2 + 3, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 1, y2 + 1, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 1, y2 + 2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 1, y2 + 3, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 4, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z).equals(FakeOres.fd_redobsidian)); } else if(world.getBlock(x - 1, y3, z).equals(this)) { portalIsGood = (world.getBlock(x, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 1, y2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 2, y2 + 1, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 2, y2 + 2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x - 2, y2 + 3, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 1, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 2, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 3, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x + 1, y2 + 4, z).equals(FakeOres.fd_redobsidian) && world.getBlock(x, y2 + 4, z).equals(FakeOres.fd_redobsidian)); } if(!portalIsGood) { world.setBlockToAir(x, y, z); } }
     */

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    /*
     * @Override public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) { if((entity.ridingEntity == null) && (entity.riddenByEntity == null)) { if(entity.dimension != FakeOres.dimID) { if(entity instanceof EntityPlayerMP) { EntityPlayerMP player = (EntityPlayerMP)entity; if(player.timeUntilPortal > 0) { player.timeUntilPortal = 10; } else { player.timeUntilPortal = 10; player.mcServer.getConfigurationManager().transferPlayerToDimension(player, FakeOres.dimID, new FD_Teleporter(player.mcServer.worldServerForDimension(FakeOres.dimID))); } } /* else { EntityTeleporter.teleportToDim(entity, FakeOres.dimID); }
     */
    /*
     * } else { if(entity instanceof EntityPlayerMP) { EntityPlayerMP player = (EntityPlayerMP)entity; if(player.timeUntilPortal > 0) { player.timeUntilPortal = 10; } else { player.timeUntilPortal = 10; player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new FD_Teleporter(player.mcServer.worldServerForDimension(0))); } } /* else { EntityTeleporter.teleportToDim(entity, 0); }
     */
    /*
     * } } }
     */

    public static class Size
    {
        private final World world;
        private final Axis axis;
        private final EnumFacing field_150866_c;
        private final EnumFacing field_150863_d;
        private int field_150864_e = 0;
        private BlockPos pos;
        private int field_150862_g;
        private int field_150868_h;

        public Size(World world, BlockPos pos, Axis axis)
        {
            this.world = world;
            this.axis = axis;

            if(axis == Axis.X)
            {
                this.field_150863_d = EnumFacing.EAST;
                this.field_150866_c = EnumFacing.WEST;
            }
            else
            {
                this.field_150863_d = EnumFacing.NORTH;
                this.field_150866_c = EnumFacing.SOUTH;
            }

            for(BlockPos blockpos1 = pos; pos.getY() > blockpos1.getY() - 21 && pos.getY() > 0 && this.func_150857_a(world.getBlockState(pos.down()).getBlock()); pos = pos.down())
            {
                ;
            }

            int i = this.func_180120_a(pos, this.field_150863_d) - 1;

            if(i >= 0)
            {
                this.pos = pos.offset(this.field_150863_d, i);
                this.field_150868_h = this.func_180120_a(this.pos, this.field_150866_c);

                if(this.field_150868_h < 2 || this.field_150868_h > 21)
                {
                    this.pos = null;
                    this.field_150868_h = 0;
                }
            }

            if(this.pos != null)
            {
                this.field_150862_g = this.func_150858_a();
            }
        }

        protected int func_180120_a(BlockPos pos, EnumFacing face)
        {
            int i;

            for(i = 0; i < 22; ++i)
            {
                BlockPos blockpos1 = pos.offset(face, i);

                if(!this.func_150857_a(this.world.getBlockState(blockpos1).getBlock()) || this.world.getBlockState(blockpos1.down()).getBlock() != FakeOres.fd_redobsidian)
                {
                    break;
                }
            }

            Block block = this.world.getBlockState(pos.offset(face, i)).getBlock();
            return block == FakeOres.fd_redobsidian ? i : 0;
        }

        protected int func_150858_a()
        {
            int i;
            label56:

            for(this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g)
            {
                for(i = 0; i < this.field_150868_h; ++i)
                {
                    BlockPos blockpos = this.pos.offset(this.field_150866_c, i).up(this.field_150862_g);
                    Block block = this.world.getBlockState(blockpos).getBlock();

                    if(!this.func_150857_a(block))
                    {
                        break label56;
                    }

                    if(block == FakeOres.fd_portal)
                    {
                        ++this.field_150864_e;
                    }

                    if(i == 0)
                    {
                        block = this.world.getBlockState(blockpos.offset(this.field_150863_d)).getBlock();

                        if(block != FakeOres.fd_redobsidian)
                        {
                            break label56;
                        }
                    }
                    else if(i == this.field_150868_h - 1)
                    {
                        block = this.world.getBlockState(blockpos.offset(this.field_150866_c)).getBlock();

                        if(block != FakeOres.fd_redobsidian)
                        {
                            break label56;
                        }
                    }
                }
            }

            for(i = 0; i < this.field_150868_h; ++i)
            {
                if(this.world.getBlockState(this.pos.offset(this.field_150866_c, i).up(this.field_150862_g)).getBlock() != FakeOres.fd_redobsidian)
                {
                    this.field_150862_g = 0;
                    break;
                }
            }

            if(this.field_150862_g <= 21 && this.field_150862_g >= 3)
            {
                return this.field_150862_g;
            }
            else
            {
                this.pos = null;
                this.field_150868_h = 0;
                this.field_150862_g = 0;
                return 0;
            }
        }

        protected boolean func_150857_a(Block block)
        {
            return block.getMaterial() == Material.air || block == Blocks.fire || block == FakeOres.fd_portal;
        }

        public boolean func_150860_b()
        {
            return this.pos != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
        }

        public void func_150859_c()
        {
            for(int i = 0; i < this.field_150868_h; ++i)
            {
                BlockPos blockpos = this.pos.offset(this.field_150866_c, i);

                for(int j = 0; j < this.field_150862_g; ++j)
                {
                    this.world.setBlockState(blockpos.up(j), FakeOres.fd_portal.getDefaultState().withProperty(FD_BlockPortal.AXIS, this.axis), 2);
                }
            }
        }
    }
}