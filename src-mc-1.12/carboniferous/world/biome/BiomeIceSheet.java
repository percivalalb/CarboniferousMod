package carboniferous.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeIceSheet extends BiomeCarboniferous {

	//public WorldGenIceFeature iceFeatureGenerator = new WorldGenIceFeature();
	
	public BiomeIceSheet() {
		super(new BiomeProperties("Ice Sheet").setBaseHeight(0.1F).setHeightVariation(0.0F).setTemperature(0.1F).setRainfall(2.0F).setWaterColor(39219));
		//this.setColor(0xfa9418);
		this.topBlock = Blocks.SNOW.getDefaultState();
		this.fillerBlock = Blocks.ICE.getDefaultState();
		this.spawnableCreatureList.clear();
	    this.spawnableMonsterList.clear();
	    this.spawnableWaterCreatureList.clear();
	}

	@Override
    public int getSkyColorByTemp(float temp) {
        return 0x66cc99;
    }
	
	/**
	@Override
	public void decorate(World world, Random rand, int xChunk, int zChunk) {
    
		int k;

		for (k = 0; k < 3; ++k) {
			int l = xChunk + rand.nextInt(16) + 8;
			int  i1 = zChunk + rand.nextInt(16) + 8;
			this.iceFeatureGenerator.generate(world, rand, l, world.getHeightValue(l, i1), i1);
     	}

        super.decorate(world, rand, xChunk, zChunk);
    }**/
}
