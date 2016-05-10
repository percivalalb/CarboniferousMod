package carboniferous.world.biome;

import java.util.Random;

import carboniferous.entity.EntityAmmonite;
import carboniferous.entity.EntityCrab;
import carboniferous.entity.EntityDendrerpeton;
import carboniferous.entity.EntityDimetrodon;
import carboniferous.entity.EntityOrthacanthus;
import carboniferous.world.feature.WorldGenCalamites;
import carboniferous.world.feature.WorldGenIceFeature;
import carboniferous.world.feature.WorldGenLepidodendron;
import carboniferous.world.feature.WorldGenSmallTrees;
import carboniferous.world.feature.WorldGenWaterCalamites;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeGenIceSheet extends BiomeGenBaseCarboniferous {

	public WorldGenIceFeature iceFeatureGenerator = new WorldGenIceFeature();
	
	public BiomeGenIceSheet(int par1) {
		super(par1);
		this.setColor(0xfa9418);
		this.setBiomeName("Ice Sheet");
		this.temperature = 0.1F;
		this.setHeight(BiomeGenBaseCarboniferous.height_icesheet);
		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.ice;
		this.spawnableCreatureList.clear();
	    this.spawnableMonsterList.clear();
	    this.spawnableWaterCreatureList.clear();
	}

	@Override
    public int getSkyColorByTemp(float temp) {
        return 0x66cc99;
    }
	
	@Override
	public void decorate(World world, Random rand, int xChunk, int zChunk) {
    
		int k;

		for (k = 0; k < 3; ++k) {
			int l = xChunk + rand.nextInt(16) + 8;
			int  i1 = zChunk + rand.nextInt(16) + 8;
			this.iceFeatureGenerator.generate(world, rand, l, world.getHeightValue(l, i1), i1);
     	}

        super.decorate(world, rand, xChunk, zChunk);
    }
}
