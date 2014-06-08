package fr.elias.fakeores.common;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFakeOres extends Block {

	public BlockFakeOres() 
	{
		super(Material.rock);
		setCreativeTab(FakeOres.fakeOresTab);
	}

	 public void onBlockDestroyedByPlayer(World par1World, int x, int y, int z, int metaData) 
	 {
		 if(FMLCommonHandler.instance().getEffectiveSide().isClient() && par1World.difficultySetting == EnumDifficulty.PEACEFUL)
		 {
			 FMLClientHandler.instance().getClient().thePlayer.addChatMessage(new ChatComponentText("Your Minecraft is in peaceful mode. All fake ores are now disabled. Please change your difficulty setting."));
		 }
		 if(!par1World.isRemote)
		 {
				if(Loader.isModLoaded("IC2"))
				{
					if(this == FakeOres.fakeCopper)
					{
						EntityCopperOre copperEntity = new EntityCopperOre(par1World);
						copperEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
						par1World.spawnEntityInWorld(copperEntity);
					}
					if(this == FakeOres.fakeTin)
					{
						EntityTinOre tinEntity = new EntityTinOre(par1World);
						tinEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
						par1World.spawnEntityInWorld(tinEntity);
					}
					if(this == FakeOres.fakeUranium)
					{
						EntityUraniumOre uraniumEntity = new EntityUraniumOre(par1World);
						uraniumEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
						par1World.spawnEntityInWorld(uraniumEntity);
					}
				}
				super.onBlockDestroyedByPlayer(par1World, x, y, z, metaData);
		 }
	 }
	 public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){return null;} // BugFix 1
	 public int quantityDropped(Random par1Random){return 0;} // BugFix 2
	 public int idPicked(World par1World, int par2, int par3, int par4) {return 0;} // BugFix 3
}
