package fr.elias.fakeores.common.block;

import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.common.entity.EntityCopperOre;
import fr.elias.fakeores.common.entity.EntityTinOre;
import fr.elias.fakeores.common.entity.EntityUraniumOre;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;

public class BlockFakeOres extends Block
{
    public BlockFakeOres()
    {
        super(Material.rock);
        setCreativeTab(FakeOres.fakeOresTab);
    }

    @Override
    public void onBlockDestroyedByPlayer(World par1World, BlockPos pos, IBlockState state)
    {
        if(FMLCommonHandler.instance().getEffectiveSide().isClient() && par1World.getDifficulty() == EnumDifficulty.PEACEFUL)
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
                    copperEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
                    par1World.spawnEntityInWorld(copperEntity);
                }
                if(this == FakeOres.fakeTin)
                {
                    EntityTinOre tinEntity = new EntityTinOre(par1World);
                    tinEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
                    par1World.spawnEntityInWorld(tinEntity);
                }
                if(this == FakeOres.fakeUranium)
                {
                    EntityUraniumOre uraniumEntity = new EntityUraniumOre(par1World);
                    uraniumEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
                    par1World.spawnEntityInWorld(uraniumEntity);
                }
            }
            super.onBlockDestroyedByPlayer(par1World, pos, state);
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    } // BugFix 1

    @Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
    } // BugFix 2
}