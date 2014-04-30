package carboniferous.world.biome;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
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
	
	public static final BiomeGenBase carboniferousRiver = new BiomeGenRiverCarboniferous(Properties.BIOME_ID_RIVER);
	public static final BiomeGenBase carboniferousOcean = new BiomeGenOceanCarboniferous(Properties.BIOME_ID_OCEAN);
	
	public static final BiomeGenBase calamitesSwamp = new BiomeGenCalamitesSwamp(Properties.BIOME_ID_CALAMITESSWAMP);
	public static final BiomeGenBase highlands = new BiomeGenHighlands(Properties.BIOME_ID_HIGHLANDS);
	public static final BiomeGenBase island = new BiomeGenIsland(Properties.BIOME_ID_ISLAND);
	public static final BiomeGenBase coalSwamp = new BiomeGenCoalSwamp(Properties.BIOME_ID_COALSWAMP);
	public static final BiomeGenBase rainforest = new BiomeGenRainforest(Properties.BIOME_ID_RAINFOREST);
	public static final BiomeGenBase bog = new BiomeGenBog(Properties.BIOME_ID_BOG);
	
	//Block Metadata
    public byte topBlockMeta = 0;
    public byte fillerBlockMeta = 0;
	
	public BiomeGenBaseCarboniferous(int par1) {
		super(par1);
		this.theBiomeDecorator = new BiomeDecoratorCarboniferous(this);
		this.topBlock = (byte)ModBlocks.grass.blockID;
        this.fillerBlock = (byte)ModBlocks.dirt.blockID;
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
    public int getBiomeGrassColor() {
        return 3887907;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getBiomeFoliageColor() {
        return 13056;
    }
    
    public BiomeDecoratorCarboniferous getBiomeDecorator() {
    	return (BiomeDecoratorCarboniferous)this.theBiomeDecorator;
    }
    
    @Override
    public void decorate(World par1World, Random par2Random, int par3, int par4) {
    	super.decorate(par1World, par2Random, par3, par4);
    }
}
