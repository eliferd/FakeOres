package fr.elias.fakeores.dimension;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.elias.fakeores.client.EntityCustomSmokeFX;
import fr.elias.fakeores.client.TickClientHandlerEvent;
import fr.elias.fakeores.common.FakeOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class FD_BlockGrass extends BlockBase
{
	public IIcon top_icon;
	public String topIconName, sideIconName;
	public Block oldBlock, newBlock;
	public FD_BlockGrass(String topicon, String sideicon, Block old_Block, Block new_Block)
	{
		super(Material.grass);
		topIconName = topicon;
		sideIconName = sideicon;
		this.oldBlock = old_Block;
		this.newBlock = new_Block;
		this.setCreativeTab(FakeOres.fakeOresTab);
	}
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return side == 1 ? this.top_icon : (side == 0 ? FakeOres.fd_dirt.getBlockTextureFromSide(side) : this.blockIcon);
    }
    
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote)
        {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
            {
            	world.setBlock(x, y, z, oldBlock);
            }
            else if (world.getBlockLightValue(x, y + 1, z) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);

                    if (world.getBlock(i1, j1, k1) == oldBlock && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                    	world.setBlock(i1, j1, k1, newBlock); //grass
                    }
                }
            }
        }
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.sideIconName);
        this.top_icon = p_149651_1_.registerIcon(this.topIconName);
    }
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
    	if(this == FakeOres.fd_grass)
    	{
        	if(rand.nextInt(50) == 0)
        	{
            	Minecraft.getMinecraft().effectRenderer.addEffect(new EntityCustomSmokeFX(world, x + 0.5, y + 1, z + 0.5, 0.0D, 0.0D, 0.0D, 1F, FakeOres.texture_CustomSmokeFX_particle.getIconFromDamage(0)));
        	}
    	}
    }
    
}
