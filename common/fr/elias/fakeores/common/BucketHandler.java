package fr.elias.fakeores.common;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BucketHandler
{
    public static BucketHandler INSTANCE = new BucketHandler();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();

    private BucketHandler()
    {}

    /*
     * @SubscribeEvent public void onBucketFill(FillBucketEvent event) { ItemStack result = fillCustomBucket(event.world, event.target); if (result == null) return; event.result = result; event.setResult(Result.ALLOW); }
     */

    /*
     * private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) { Block block = world.getBlockState(new BlockPos(pos.getBlockPos().getX(), pos.getBlockPos().getY(), pos.getBlockPos().getZ())).getBlock(); Item bucket = buckets.get(block); if (bucket != null && world.getBlockState(pos.blockX, pos.blockY, pos.blockZ) == 0) { world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ); return new ItemStack(bucket); } else return null; }
     */
}