package carboniferous.world.biome;

import java.util.Random;

import carboniferous.world.feature.WorldGenCalamites;
import carboniferous.world.feature.WorldGenSigillaria;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

/**
 * @author ProPercivalalb
 **/
public class BiomeRainforest extends BiomeCarboniferous {
  
	public BiomeRainforest() {
		super(new BiomeProperties("Rainforest").setBaseHeight(0.25F).setHeightVariation(0.25F).setTemperature(2.0F).setRainfall(2.0F).setWaterColor(39219));
        this.decorator.treesPerChunk = 4;
        this.decorator.grassPerChunk = 16;
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityDimetrodon.class, 10, 1, 3));
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x339933;
    }
    
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
    	int i = random.nextInt(6);
    	if(i <= 1) {
    		return new WorldGenCalamites(false);
        }
    	else
    		return new WorldGenSigillaria(false);
        
    	/**int i = random.nextInt(6);
        if (i <= 1) {
            return (WorldGenAbstractTree)new WorldGenSmallTrees(false);
        }
        if (i == 2) {
            return (WorldGenAbstractTree)new WorldGenCordaites(false);
        }
        else {
            return (WorldGenAbstractTree)new WorldGenLepidodendron(false);
        }**/
    }
}
