package fr.elias.fakeores.common;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStrangeLiquid extends BlockFluidClassic {
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
	public BlockStrangeLiquid(Fluid fluid, Material material) {
		super(fluid, material);
		this.setCreativeTab(FakeOres.fakeOresTab);
	}
    @Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
    
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
    	super.onEntityWalking(world, x, y, z, entity);
        entity.motionX = world.rand.nextFloat();
        entity.motionY = world.rand.nextFloat();
        entity.motionZ = world.rand.nextFloat();
        if(world.isRemote)
        {
        	world.spawnParticle("largesmoke", entity.posX, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
        }
        if(world.rand.nextInt(40) == 0)
        {
        	world.createExplosion(entity, x, y, z, 2F, false);
        }
    }
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
    {    	
        entity.motionX = world.rand.nextFloat() * 0.7F;
        entity.motionY = world.rand.nextFloat() * 0.4F;
        entity.motionZ = world.rand.nextFloat() * 0.7F;
        if(world.rand.nextInt(40) == 0)
        {
        	world.createExplosion(entity, x, y, z, 2F, false);
        }
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon("fakeores:strangeStill");
            flowingIcon = register.registerIcon("fakeores:strangeFlowing");
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
}
