package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;

import carboniferous.core.helper.LogHelper;
import carboniferous.entity.EntityGiantSnail;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockIce;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class BlockBrittleIce extends BlockBreakable {

    public BlockBrittleIce() {
        super("ice", Material.ice, false);
        this.slipperiness = 0.9F;
        this.setHardness(0.5F);
        this.setLightOpacity(3);
        this.setStepSound(soundTypeGlass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return super.shouldSideBeRendered(blockAccess, x, y, z, 1 - side);
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
        player.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
        player.addExhaustion(0.025F);

        if (this.canSilkHarvest(world, player, x, y, z, meta) && EnchantmentHelper.getSilkTouchModifier(player)) {
            ArrayList<ItemStack> items = new ArrayList<ItemStack>();
            ItemStack itemstack = this.createStackedBlock(meta);

            if (itemstack != null) items.add(itemstack);

            ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, meta, 0, 1.0f, true, player);
            for (ItemStack is : items)
                this.dropBlockAsItem(world, x, y, z, is);
        }
        else {
            if (world.provider.isHellWorld)
            {
                world.setBlockToAir(x, y, z);
                return;
            }

            int i1 = EnchantmentHelper.getFortuneModifier(player);
            harvesters.set(player);
            this.dropBlockAsItem(world, x, y, z, meta, i1);
            harvesters.set(null);
            Material material = world.getBlock(x, y - 1, z).getMaterial();

            if (material.blocksMovement() || material.isLiquid()) {
                world.setBlock(x, y, z, Blocks.flowing_water);
            }
        }
    }
    
    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
    	Entity snail = new EntityGiantSnail(world);
    	snail.setPosition(x, y + 1, z);
    	world.spawnEntityInWorld(snail);
    	LogHelper.logInfo("Ice walk");
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    	world.spawnEntityInWorld(new EntityGiantSnail(world));
    	LogHelper.logInfo("Ice coll");
    }

    @Override
    public int quantityDropped(Random rand) {
        return 0;
    }

    @Override
    public int getMobilityFlag() {
        return 0;
    }
}