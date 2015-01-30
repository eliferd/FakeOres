package fr.elias.fakeores.common.block;

import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.common.entity.EntityCoalOre;
import fr.elias.fakeores.common.entity.EntityDiamondOre;
import fr.elias.fakeores.common.entity.EntityEmeraldOre;
import fr.elias.fakeores.common.entity.EntityGoldOre;
import fr.elias.fakeores.common.entity.EntityIronOre;
import fr.elias.fakeores.common.entity.EntityLapisLazuliOre;
import fr.elias.fakeores.common.entity.EntityNetherQuartzOre;
import fr.elias.fakeores.common.entity.EntityRedstoneOre;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFakeOresVanilla extends Block
{
    public static String[] type = new String[] {"fakeDiamondOre", "fakeGoldOre", "fakeEmeraldOre", "fakeIronOre", "fakeCoalOre", "fakeRedstoneOre", "fakeNetherQuartz", "fakeLapisLazuli"};

    // diam = 0 : gold = 1 : emerald = 2 : iron = 3 : coal = 4 : red = 5 :
    // quartz = 6 : lapis = 7

    public BlockFakeOresVanilla()
    {
        super(Material.rock);
        setCreativeTab(FakeOres.fakeOresTab);
    }

    /*
     * public IIcon getIcon(int side, int metadata) { switch(metadata) { case 0: return Blocks.diamond_ore.getIcon(side, metadata); case 1: return Blocks.gold_ore.getIcon(side, metadata); case 2: return Blocks.emerald_ore.getIcon(side, metadata); case 3: return Blocks.iron_ore.getIcon(side, metadata); case 4: return Blocks.coal_ore.getIcon(side, metadata); case 5: return Blocks.redstone_ore.getIcon(side, metadata); case 6: return Blocks.quartz_ore.getIcon(side, metadata); case 7: return Blocks.lapis_ore.getIcon(side, metadata); default: return Blocks.stone.getIcon(side, metadata); } }
     */

    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state)
    {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if(FMLCommonHandler.instance().getEffectiveSide().isClient() && world.rand.nextInt(20) == 0)
        {
            FMLClientHandler.instance().getClient().thePlayer.addChatMessage(new ChatComponentText("If your Minecraft is in peaceful mode, All fake ores is disabled. Just change your difficulty setting."));
        }
        if(!world.isRemote)
        {
            if(this.getMetaFromState(state) == 0)
            {
                EntityDiamondOre diamondEntity = new EntityDiamondOre(world);
                diamondEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
                world.spawnEntityInWorld(diamondEntity);
            }
            if(this.getMetaFromState(state) == 1)
            {
                EntityGoldOre goldEntity = new EntityGoldOre(world);
                goldEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
                world.spawnEntityInWorld(goldEntity);
            }
            if(this.getMetaFromState(state) == 2)
            {
                EntityEmeraldOre emeraldEntity = new EntityEmeraldOre(world);
                emeraldEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
                world.spawnEntityInWorld(emeraldEntity);
            }
            if(this.getMetaFromState(state) == 3)
            {
                EntityIronOre ironEntity = new EntityIronOre(world);
                ironEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
                world.spawnEntityInWorld(ironEntity);
            }
            if(this.getMetaFromState(state) == 4)
            {
                EntityCoalOre coalEntity = new EntityCoalOre(world);
                coalEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
                world.spawnEntityInWorld(coalEntity);
            }
            if(this.getMetaFromState(state) == 5)
            {
                EntityRedstoneOre redstoneEntity = new EntityRedstoneOre(world);
                redstoneEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
                world.spawnEntityInWorld(redstoneEntity);
            }
            if(this.getMetaFromState(state) == 6)
            {
                EntityNetherQuartzOre nquartzEntity = new EntityNetherQuartzOre(world);
                nquartzEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
                world.spawnEntityInWorld(nquartzEntity);
            }
            if(this.getMetaFromState(state) == 7)
            {
                EntityLapisLazuliOre lapisEntity = new EntityLapisLazuliOre(world);
                lapisEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
                world.spawnEntityInWorld(lapisEntity);
            }
            super.onBlockDestroyedByPlayer(world, pos, state);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for(int i = 0; i < type.length; i++)
            list.add(new ItemStack(item, 1, i));
    }

    private Random rand = new Random();

    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
        IBlockState state = world.getBlockState(pos);
        if(this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int j1 = 0;

            if(this.getMetaFromState(state) == 4)
            {
                j1 = MathHelper.getRandomIntegerInRange(rand, 0, 2);
            }
            else if(this.getMetaFromState(state) == 0)
            {
                j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
            }
            else if(this.getMetaFromState(state) == 2)
            {
                j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
            }
            else if(this.getMetaFromState(state) == 7)
            {
                j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
            }
            else if(this.getMetaFromState(state) == 6)
            {
                j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
            }
            return j1;
        }
        return 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        return null;
    }

    @Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    @Override
    public boolean canSilkHarvest()
    {
        return false;
    }
}