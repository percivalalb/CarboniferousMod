package carboniferous.world.biome;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.entity.EntityDragonfly;
import carboniferous.world.feature.WorldGenSpiderLair;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenBaseCarboniferous extends BiomeGenBase {
	
	protected static final BiomeGenBase.Height height_carboniferous_river = new BiomeGenBase.Height(-0.5F, 0.0F);
	protected static final BiomeGenBase.Height height_carboniferous_ocean = new BiomeGenBase.Height(-1.5F, 0.0F);
	protected static final BiomeGenBase.Height height_calamites_swamp = new BiomeGenBase.Height(-0.15F, 0.15F);
	protected static final BiomeGenBase.Height height_highlands = new BiomeGenBase.Height(1.5F, 0.5F);
	protected static final BiomeGenBase.Height height_island = new BiomeGenBase.Height(-0.2F, 0.6F);
	protected static final BiomeGenBase.Height height_coal_swamp = new BiomeGenBase.Height(-0.05F, 0.15F);
	protected static final BiomeGenBase.Height height_rainforest = new BiomeGenBase.Height(0.25F, 0.25F);
	protected static final BiomeGenBase.Height height_bog = new BiomeGenBase.Height(0.0F, 0.4F);
	
	public static final BiomeGenBase carboniferousRiver = new BiomeGenRiverCarboniferous(Properties.BIOME_ID_RIVER);
	public static final BiomeGenBase carboniferousOcean = new BiomeGenOceanCarboniferous(Properties.BIOME_ID_OCEAN);
	
	public static final BiomeGenBase calamitesSwamp = new BiomeGenCalamitesSwamp(Properties.BIOME_ID_CALAMITESSWAMP);
	public static final BiomeGenBase highlands = new BiomeGenHighlands(Properties.BIOME_ID_HIGHLANDS);
	public static final BiomeGenBase island = new BiomeGenIsland(Properties.BIOME_ID_ISLAND);
	public static final BiomeGenBase coalSwamp = new BiomeGenCoalSwamp(Properties.BIOME_ID_COALSWAMP);
	public static final BiomeGenBase rainforest = new BiomeGenRainforest(Properties.BIOME_ID_RAINFOREST);
	public static final BiomeGenBase bog = new BiomeGenBog(Properties.BIOME_ID_BOG);

	public BiomeGenBaseCarboniferous(int par1) {
		super(par1);
		this.theBiomeDecorator = new BiomeDecoratorCarboniferous();
		this.topBlock = ModBlocks.grass;
        this.fillerBlock = ModBlocks.dirt;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 4, 1, 2));
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 5, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDragonfly.class, 34, 4, 4));
        this.temperature = 2.0F;
        this.rainfall = 2.0F;
        this.waterColorMultiplier = 39219;
        this.setColor(0xfa9325);
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 10;
	}	
	
	@SideOnly(Side.CLIENT)
	@Override
    public int getBiomeGrassColor(int x, int y, int z) {
        return 3887907;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBiomeFoliageColor(int x, int y, int z) {
        return 13056;
    }
    
    @Override
    public void genTerrainBlocks(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_)
    {
        boolean flag = true;
        Block block = this.topBlock;
        byte b0 = (byte)(this.field_150604_aj & 255);
        Block block1 = this.fillerBlock;
        int k = -1;
        int l = (int)(p_150560_7_ / 3.0D + 3.0D + p_150560_2_.nextDouble() * 0.25D);
        int i1 = p_150560_5_ & 15;
        int j1 = p_150560_6_ & 15;
        int k1 = p_150560_3_.length / 256;

        for (int l1 = 255; l1 >= 0; --l1)
        {
            int i2 = (j1 * 16 + i1) * k1 + l1;

            if (l1 <= 0 + p_150560_2_.nextInt(5))
            {
                p_150560_3_[i2] = Blocks.bedrock;
            }
            else
            {
                Block block2 = p_150560_3_[i2];

                if (block2 != null && block2.getMaterial() != Material.air)
                {
                    if (block2 == ModBlocks.multiBlock1)
                    {
                        if (k == -1)
                        {
                            if (l <= 0)
                            {
                                block = null;
                                b0 = 0;
                                block1 = ModBlocks.multiBlock1;
                            }
                            else if (l1 >= 59 && l1 <= 64)
                            {
                                block = this.topBlock;
                                b0 = (byte)(this.field_150604_aj & 255);
                                block1 = this.fillerBlock;
                            }

                            if (l1 < 63 && (block == null || block.getMaterial() == Material.air))
                            {
                                if (this.getFloatTemperature(p_150560_5_, l1, p_150560_6_) < 0.15F)
                                {
                                    block = Blocks.ice;
                                    b0 = 0;
                                }
                                else
                                {
                                    block = Blocks.water;
                                    b0 = 0;
                                }
                            }

                            k = l;

                            if (l1 >= 62)
                            {
                                p_150560_3_[i2] = block;
                                p_150560_4_[i2] = b0;
                            }
                            else if (l1 < 56 - l)
                            {
                                block = null;
                                block1 = ModBlocks.multiBlock1;
                                p_150560_3_[i2] = Blocks.gravel;
                            }
                            else
                            {
                                p_150560_3_[i2] = block1;
                            }
                        }
                        else if (k > 0)
                        {
                            --k;
                            p_150560_3_[i2] = block1;

                            if (k == 0 && block1 == Blocks.sand)
                            {
                                k = p_150560_2_.nextInt(4) + Math.max(0, l1 - 63);
                                block1 = Blocks.sandstone;
                            }
                        }
                    }
                }
                else
                {
                    k = -1;
                }
            }
        }
    }
    
    public BiomeDecoratorCarboniferous getBiomeDecorator() {
    	return (BiomeDecoratorCarboniferous)this.theBiomeDecorator;
    }
    
    @Override
    public void decorate(World par1World, Random par2Random, int par3, int par4) {
    	super.decorate(par1World, par2Random, par3, par4);
    }
}
