package carboniferous.world.biome;

import java.util.Random;

import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.entity.EntityDragonfly;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenBaseCarboniferous extends BiomeGenBase {
	
	protected static final BiomeGenBase.Height height_carboniferous_river = new BiomeGenBase.Height(-0.5F, 0.0F);
	protected static final BiomeGenBase.Height height_carboniferous_ocean = new BiomeGenBase.Height(-1.5F, 0.0F);
	protected static final BiomeGenBase.Height height_calamites_swamp = new BiomeGenBase.Height(-0.15F, 0.15F);
	protected static final BiomeGenBase.Height height_highlands = new BiomeGenBase.Height(4F, 0.3F);
	protected static final BiomeGenBase.Height height_island = new BiomeGenBase.Height(-0.4F, 0.5F);
	protected static final BiomeGenBase.Height height_coal_swamp = new BiomeGenBase.Height(-0.05F, 0.10F);
	protected static final BiomeGenBase.Height height_rainforest = new BiomeGenBase.Height(0.25F, 0.25F);
	protected static final BiomeGenBase.Height height_bog = new BiomeGenBase.Height(0.0F, 0.4F);
	protected static final BiomeGenBase.Height height_icesheet = new BiomeGenBase.Height(0.1F, 0.0F);
	
	public static final BiomeGenBase carboniferousRiver = new BiomeGenRiverCarboniferous(Properties.BIOME_ID_RIVER);
	public static final BiomeGenBase carboniferousOcean = new BiomeGenOceanCarboniferous(Properties.BIOME_ID_OCEAN);
	
	public static final BiomeGenBase calamitesSwamp = new BiomeGenCalamitesSwamp(Properties.BIOME_ID_CALAMITESSWAMP);
	public static final BiomeGenBase highlands = new BiomeGenHighlands(Properties.BIOME_ID_HIGHLANDS);
	public static final BiomeGenBase island = new BiomeGenIsland(Properties.BIOME_ID_ISLAND);
	public static final BiomeGenBase coalSwamp = new BiomeGenCoalSwamp(Properties.BIOME_ID_COALSWAMP);
	public static final BiomeGenBase rainforest = new BiomeGenRainforest(Properties.BIOME_ID_RAINFOREST);
	public static final BiomeGenBase bog = new BiomeGenBog(Properties.BIOME_ID_BOG);
	public static final BiomeGenBase icesheet = new BiomeGenIceSheet(Properties.BIOME_ID_ICE_SHEET);

	public BiomeGenBaseCarboniferous(int id) {
		super(id);
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
    public void genTerrainBlocks(World world, Random rand, Block[] dataId, byte[] dataMeta, int x, int z, double stoneNoise) {
    	int blocksOfFiller = 10;
    	
    	
        Block block = this.topBlock;
        byte b0 = (byte)(this.field_150604_aj & 255);
        Block block1 = this.fillerBlock;
        int k = -1;
        int l = (int)(stoneNoise / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int xInChunk = x & 15;
        int zInChunk = z & 15;
        int layerSize = dataId.length / 256;

        for(int y = 255; y >= 0; --y) {
            int index = (zInChunk * 16 + xInChunk) * layerSize + y;

            if(y <= 0 + rand.nextInt(5))
                dataId[index] = Blocks.bedrock;
            else {
                Block orignalBlock = dataId[index];

                if(orignalBlock != null && orignalBlock.getMaterial() != Material.air) {
                    if(orignalBlock == ModBlocks.multiBlock1) {
                        if(k == -1) {
                            if (l <= 0) {
                                block = null;
                                b0 = 0;
                                block1 = ModBlocks.multiBlock1;
                            }
                            else if(y >= 59 && y <= 64) {
                                block = this.topBlock;
                                b0 = (byte)(this.field_150604_aj & 255);
                                block1 = this.fillerBlock;
                            }

                            if(y < 63 && (block == null || block.getMaterial() == Material.air)) {
                                if (this.getFloatTemperature(x, y, z) < 0.15F) {
                                    block = Blocks.ice;
                                    b0 = 0;
                                }
                                else {
                                    block = Blocks.water;
                                    b0 = 0;
                                }
                            }

                            k = l;

                            if (y >= 62) {
                                dataId[index] = block;
                                dataMeta[index] = b0;
                            }
                            else if (y < 52 + blocksOfFiller - l) {
                                block = null;
                                block1 = ModBlocks.multiBlock1;
                                dataId[index] = ModBlocks.dirt;
                            }
                            else
                                dataId[index] = block1;
                        }
                        else if (k > 0) {
                            --k;
                            dataId[index] = block1;

                            if (k == 0 && block1 == Blocks.sand) {
                                k = rand.nextInt(4) + Math.max(0, y - 63);
                                block1 = Blocks.sandstone;
                            }
                        }
                    }
                }
                else
                    k = -1;
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
